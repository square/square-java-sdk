package com.squareup.square.utilities;

import static org.junit.jupiter.api.Assertions.*;

import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.SquareException;
import com.squareup.square.types.LoadResponse;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

/**
 * The Reporting API answers a still-processing <code>/v1/load</code> query with an HTTP 200 whose body is
 * <code>{"error": "Continue wait"}</code>. {@link ReportingHelper#loadAndWait} owns the retry loop around that sentinel.
 * These tests exercise the loop without a network by scripting the underlying {@code load} call, plus one test that
 * proves the sentinel actually survives the generated client's deserialization.
 */
public final class ReportingHelperTest {
    private static final String CONTINUE_WAIT = "Continue wait";

    private static final LoadResponse CONTINUE_WAIT_RESPONSE =
            LoadResponse.builder().additionalProperty("error", CONTINUE_WAIT).build();

    private static final LoadResponse RESOLVED_RESPONSE =
            LoadResponse.builder().queryType("regularQuery").build();

    /** A scripted {@code load} that returns each response in turn, then repeats the last one. */
    private static ReportingHelper.LoadCall scripted(AtomicInteger calls, LoadResponse... sequence) {
        return () -> {
            int i = calls.getAndIncrement();
            return sequence[Math.min(i, sequence.length - 1)];
        };
    }

    private static LoadAndWaitOptions fastOptions(int maxAttempts) {
        return LoadAndWaitOptions.builder()
                .initialDelayMs(1)
                .maxDelayMs(1)
                .maxAttempts(maxAttempts)
                .build();
    }

    @Test
    public void pollsPastContinueWaitAndReturnsResolvedResult() {
        AtomicInteger calls = new AtomicInteger();
        ReportingHelper.LoadCall call =
                scripted(calls, CONTINUE_WAIT_RESPONSE, CONTINUE_WAIT_RESPONSE, RESOLVED_RESPONSE);

        LoadResponse response = ReportingHelper.poll(call, fastOptions(5));

        // The helper must never hand back the raw sentinel.
        assertNull(response.getAdditionalProperties().get("error"));
        assertEquals(3, calls.get());
    }

    @Test
    public void returnsImmediatelyWhenFirstResponseHasResults() {
        AtomicInteger calls = new AtomicInteger();
        ReportingHelper.LoadCall call = scripted(calls, RESOLVED_RESPONSE);

        LoadResponse response = ReportingHelper.poll(call, fastOptions(5));

        assertNull(response.getAdditionalProperties().get("error"));
        assertEquals(1, calls.get());
    }

    @Test
    public void throwsOnceMaxAttemptsExhaustedWhileStillContinueWait() {
        AtomicInteger calls = new AtomicInteger();
        ReportingHelper.LoadCall call = scripted(calls, CONTINUE_WAIT_RESPONSE); // never resolves

        SquareException ex = assertThrows(SquareException.class, () -> ReportingHelper.poll(call, fastOptions(3)));

        assertTrue(ex.getMessage().contains("did not complete after 3 attempts"));
        assertEquals(3, calls.get());
    }

    @Test
    public void honorsThreadInterruptionMidPoll() {
        AtomicInteger calls = new AtomicInteger();
        ReportingHelper.LoadCall call = scripted(calls, CONTINUE_WAIT_RESPONSE); // would otherwise poll forever
        LoadAndWaitOptions options = LoadAndWaitOptions.builder()
                .initialDelayMs(60_000)
                .maxAttempts(10)
                .build();

        // Arm interruption so the first backoff sleep aborts immediately.
        Thread.currentThread().interrupt();
        try {
            SquareException ex = assertThrows(SquareException.class, () -> ReportingHelper.poll(call, options));
            assertTrue(ex.getMessage().contains("aborted"));
        } finally {
            // Clear the interrupt flag so it does not leak into other tests.
            Thread.interrupted();
        }
    }

    @Test
    public void treatsRealDeserializerContinueWaitBodyAsRetrySignal() throws Exception {
        // The crux of the design: the generated reporting.load deserializes the body with unknown-key passthrough,
        // so the "error" sentinel survives onto a LoadResponse (in additionalProperties) and "results" stays empty.
        // If this ever stops being true, loadAndWait would mistake "Continue wait" for a real result.
        LoadResponse parsed = ObjectMappers.JSON_MAPPER.readValue("{\"error\":\"Continue wait\"}", LoadResponse.class);

        assertEquals(CONTINUE_WAIT, parsed.getAdditionalProperties().get("error"));
        assertTrue(parsed.getResults().isEmpty());
    }
}

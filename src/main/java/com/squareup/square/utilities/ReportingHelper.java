package com.squareup.square.utilities;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SquareException;
import com.squareup.square.types.LoadRequest;
import com.squareup.square.types.LoadResponse;

/**
 * Utility to help with the <a href="https://developer.squareup.com/docs/reporting-api/overview">Square Reporting API</a>.
 *
 * <p>The <code>/reporting/v1/load</code> endpoint is asynchronous: a query that is still being computed comes back as an
 * HTTP 200 whose body is <code>{"error": "Continue wait"}</code> rather than the results. Clients are expected to
 * re-send the identical request, with backoff, until real results arrive. {@link #loadAndWait} owns that retry loop.
 */
public final class ReportingHelper {
    /**
     * Sentinel returned by the Reporting API on an HTTP 200 while a <code>/v1/load</code> query is still processing. It
     * is NOT an error — the request should be retried.
     */
    private static final String CONTINUE_WAIT = "Continue wait";

    private ReportingHelper() {}

    /**
     * Runs a reporting query with an empty request body and the default polling options. See
     * {@link #loadAndWait(SquareClient, LoadRequest, LoadAndWaitOptions)}.
     */
    public static LoadResponse loadAndWait(SquareClient client) {
        return loadAndWait(
                client,
                LoadRequest.builder().build(),
                LoadAndWaitOptions.builder().build());
    }

    /**
     * Runs a reporting query with the default polling options. See
     * {@link #loadAndWait(SquareClient, LoadRequest, LoadAndWaitOptions)}.
     */
    public static LoadResponse loadAndWait(SquareClient client, LoadRequest request) {
        return loadAndWait(client, request, LoadAndWaitOptions.builder().build());
    }

    /**
     * Runs a reporting query and transparently polls until it resolves, returning the final {@link LoadResponse}.
     * Re-sends the identical request with exponential backoff while the API answers "Continue wait".
     *
     * <p>The poll loop honors thread interruption: interrupting the calling thread (for example via
     * {@link java.util.concurrent.Future#cancel(boolean)}) aborts an in-flight wait and throws a {@link SquareException}.
     *
     * @param client  a configured {@link SquareClient}
     * @param request the reporting query (same shape as <code>client.reporting().load</code>)
     * @param options polling/backoff configuration
     * @return the resolved {@code LoadResponse} (never the "Continue wait" sentinel)
     * @throws SquareException if the query does not resolve within {@code maxAttempts}, or the calling thread is
     *                         interrupted while waiting
     */
    public static LoadResponse loadAndWait(SquareClient client, LoadRequest request, LoadAndWaitOptions options) {
        if (client == null) {
            throw new IllegalArgumentException("client must not be null");
        }
        LoadRequest query = request == null ? LoadRequest.builder().build() : request;
        return poll(() -> client.reporting().load(query, options.getRequestOptions()), options);
    }

    /**
     * The core polling loop, decoupled from {@link SquareClient} so it can be exercised without a network. Visible for
     * testing.
     */
    static LoadResponse poll(LoadCall call, LoadAndWaitOptions options) {
        long delayMs = options.getInitialDelayMs();
        for (int attempt = 1; attempt <= options.getMaxAttempts(); attempt++) {
            LoadResponse response = call.load();
            if (!isContinueWait(response)) {
                return response;
            }
            if (attempt == options.getMaxAttempts()) {
                break;
            }
            sleep(delayMs);
            delayMs = Math.min((long) (delayMs * options.getBackoffFactor()), options.getMaxDelayMs());
        }
        throw new SquareException(String.format(
                "Reporting query did not complete after %d attempts (\"%s\").",
                options.getMaxAttempts(), CONTINUE_WAIT));
    }

    /**
     * A "Continue wait" body deserializes into a {@link LoadResponse} (validation is skipped and unknown keys pass
     * through) with the {@code error} sentinel preserved on {@link LoadResponse#getAdditionalProperties()} and
     * {@code data} absent. That's the retry signal.
     */
    private static boolean isContinueWait(LoadResponse response) {
        return CONTINUE_WAIT.equals(response.getAdditionalProperties().get("error"));
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SquareException("Reporting query polling was aborted.", e);
        }
    }

    /** A single invocation of {@code reporting().load}. Visible for testing. */
    @FunctionalInterface
    interface LoadCall {
        LoadResponse load();
    }
}

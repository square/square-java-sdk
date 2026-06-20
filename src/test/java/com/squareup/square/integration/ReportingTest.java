package com.squareup.square.integration;

import static org.junit.jupiter.api.Assertions.*;

import com.squareup.square.SquareClient;
import com.squareup.square.core.Environment;
import com.squareup.square.types.Cube;
import com.squareup.square.types.LoadRequest;
import com.squareup.square.types.LoadResponse;
import com.squareup.square.types.Measure;
import com.squareup.square.types.MetadataResponse;
import com.squareup.square.types.Query;
import com.squareup.square.utilities.LoadAndWaitOptions;
import com.squareup.square.utilities.ReportingHelper;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Live smoke test for the Reporting API.
 *
 * <p>The Reporting API is a beta, bespoke offering served ONLY from production
 * (connect.squareup.com/reporting) — it is not routed on sandbox (returns 404 there). Validating it live therefore
 * needs a production, reporting-provisioned access token. CI's {@code TEST_SQUARE_TOKEN} is sandbox-only (it 401s
 * against prod), so this suite is gated behind {@code TEST_SQUARE_REPORTING} — which IS that prod, reporting-provisioned
 * token — and skips by default when it is unset, keeping CI green. The endpoints are read-only (schema discovery +
 * queries). The polling <em>logic</em> is covered without a live account in {@code ReportingHelperTest}.
 *
 * <p>Run it against a real prod account:
 *
 * <pre>{@code
 * TEST_SQUARE_REPORTING=<prod-reporting-token> ./gradlew test --tests '*ReportingTest'
 * # override the host with TEST_SQUARE_BASE_URL=<url> if reporting moves.
 * }</pre>
 */
public final class ReportingTest {
    private static SquareClient client;

    @BeforeAll
    static void setUp() {
        // Skip the entire suite (rather than fail) unless explicitly opted in.
        // A missing CI secret resolves to an empty string (not absent), so treat blank as unset.
        String reportingToken = System.getenv("TEST_SQUARE_REPORTING");
        Assumptions.assumeTrue(
                reportingToken != null && !reportingToken.isBlank(),
                "Set TEST_SQUARE_REPORTING=<prod-reporting-token> to run the reporting integration suite.");
        client = createReportingClient();
    }

    private static SquareClient createReportingClient() {
        // The reporting suite authenticates with TEST_SQUARE_REPORTING — a production, reporting-provisioned
        // access token (distinct from the sandbox TEST_SQUARE_TOKEN used by the other integration tests).
        String token = System.getenv("TEST_SQUARE_REPORTING");
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException(
                    "TEST_SQUARE_REPORTING must be set to run the reporting integration suite.");
        }
        // Reporting only exists on production; allow overriding the host via TEST_SQUARE_BASE_URL.
        String baseUrl = System.getenv("TEST_SQUARE_BASE_URL");
        Environment environment = baseUrl != null ? Environment.custom(baseUrl) : Environment.PRODUCTION;
        // Make the live target unambiguous in the test output (useful when triaging CI).
        System.out.println("[reporting] base URL: " + environment.getUrl() + "  ->  " + environment.getUrl()
                + "/reporting/v1/{meta,load}");
        return SquareClient.builder().token(token).environment(environment).build();
    }

    /** Resolves the first queryable measure from the live schema, e.g. "Orders.count". */
    private static String firstMeasureName() {
        MetadataResponse metadata = client.reporting().getMetadata();
        List<Cube> cubes = metadata.getCubes().orElse(Collections.emptyList());
        for (Cube cube : cubes) {
            for (Measure measure : cube.getMeasures()) {
                if (measure.getName() != null) {
                    return measure.getName();
                }
            }
        }
        throw new IllegalStateException("No cubes/measures are available on the reporting schema for this account.");
    }

    @Test
    public void getMetadataReturnsQueryableSchema() {
        MetadataResponse metadata = client.reporting().getMetadata();

        List<Cube> cubes = metadata.getCubes().orElse(Collections.emptyList());
        assertFalse(cubes.isEmpty(), "Expected at least one cube on the reporting schema.");
        System.out.println("Reporting schema: " + cubes.size() + " cube(s); first = "
                + cubes.get(0).getName());
    }

    @Test
    public void loadReturnsResultsOrContinueWaitSentinel() {
        String measure = firstMeasureName();
        LoadRequest request = LoadRequest.builder()
                .query(Query.builder()
                        .measures(Collections.singletonList(measure))
                        .build())
                .build();

        LoadResponse response = client.reporting().load(request);

        Object sentinel = response.getAdditionalProperties().get("error");
        if (sentinel != null) {
            // Documented async behavior: a still-processing query comes back as HTTP 200
            // with { "error": "Continue wait" } instead of results.
            assertEquals("Continue wait", sentinel);
        } else {
            assertTrue(response.getData().isPresent(), "Resolved query should carry data.");
        }
    }

    @Test
    public void loadAndWaitResolvesQueryWithoutSurfacingContinueWait() {
        String measure = firstMeasureName();
        LoadRequest request = LoadRequest.builder()
                .query(Query.builder()
                        .measures(Collections.singletonList(measure))
                        .build())
                .build();

        LoadResponse response = ReportingHelper.loadAndWait(
                client,
                request,
                LoadAndWaitOptions.builder()
                        .maxAttempts(20)
                        .initialDelayMs(2_000)
                        .maxDelayMs(20_000)
                        .build());

        // The polling helper must never hand back the raw "Continue wait" sentinel.
        assertNull(response.getAdditionalProperties().get("error"));
        assertTrue(response.getData().isPresent(), "Resolved query should carry data.");
    }
}

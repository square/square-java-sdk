package com.squareup.square.legacy.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.squareup.square.legacy.SquareClient;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.ListLocationsResponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocationsApiTest extends BaseApiTest {

    private static final int MAX_RETRIES = 5;
    private static final long INITIAL_RETRY_DELAY_MS = 2000;

    /**
     * Client instance.
     */
    private static SquareClient client;

    /**
     * Controller instance (for all tests).
     */
    private static LocationsApi controller;

    /**
     * Setup test class.
     */
    @BeforeClass
    public static void setUpClass() {
        client = createConfiguration();
        controller = client.getLocationsApi();
    }

    /**
     * Tear down test class.
     */
    @AfterClass
    public static void tearDownClass() {
        controller = null;
    }

    private interface ApiCall<T> {
        T execute() throws ApiException;
    }

    private <T> T withRetry(ApiCall<T> apiCall) throws ApiException {
        ApiException lastException = null;

        for (int attempt = 0; attempt < MAX_RETRIES; attempt++) {
            try {
                if (attempt > 0) {
                    // Calculate exponential backoff delay
                    long delayMs = INITIAL_RETRY_DELAY_MS * (long) Math.pow(2, attempt - 1);
                    System.out.printf("Retry attempt %d after %d ms delay%n", attempt + 1, delayMs);
                    Thread.sleep(delayMs);
                }

                return apiCall.execute();

            } catch (ApiException e) {
                lastException = e;
                
                // Check if it's a rate limit error
                if (e.getMessage() != null && 
                    (e.getMessage().contains("RATE_LIMITED") || 
                     e.getMessage().contains("rate limit"))) {
                    System.out.printf("Rate limited on attempt %d%n", attempt + 1);
                    continue;
                }
                
                // For authentication errors, throw immediately
                if (e.getMessage() != null && 
                    (e.getMessage().contains("UNAUTHORIZED") || 
                     e.getMessage().contains("UNAUTHENTICATED"))) {
                    throw e;
                }
                
                // For other errors, retry
                System.out.printf("API error on attempt %d: %s%n", attempt + 1, e.getMessage());
                
                if (attempt == MAX_RETRIES - 1) {
                    throw e;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted during retry delay", e);
            }
        }

        // If we've exhausted all retries, throw the last exception
        throw lastException;
    }

    /**
     * Provides details about all of the seller's
     * [locations](https://developer.squareup.com/docs/locations-api), including those with an
     * inactive status. Locations are listed alphabetically by `name`.
     * @throws Throwable exception if occurs.
     */
    @Test
    public void testListLocations() throws Exception {
        try {
            ListLocationsResponse response = withRetry(() -> {
                System.out.println("Attempting to list locations...");
                return controller.listLocations();
            });

            // Test whether the response is null
            assertNotNull("Response is null", response);
            assertNotNull("Response context is null", response.getContext());
            assertNotNull("Response context response is null", response.getContext().getResponse());
            
            // Test response code
            int statusCode = response.getContext().getResponse().getStatusCode();
            assertEquals("Status is not 200", 200, statusCode);
            
        } catch (ApiException e) {
            System.err.println("API Exception occurred: " + e.getMessage());
            if (e.getMessage() != null && 
                (e.getMessage().contains("UNAUTHORIZED") || 
                 e.getMessage().contains("UNAUTHENTICATED"))) {
                System.err.println("Authentication error - check your credentials");
            }
            throw e;
        }
    }
}
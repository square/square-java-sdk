
package com.squareup.square.api;

import com.squareup.square.Environment;
import com.squareup.square.SquareClient;
import com.squareup.square.testing.HttpCallbackCatcher;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.Timeout;

/**
 * Base class for all test cases.
 */
public class BaseApiTest {
    /**
     * Test configuration.
     */
    public static final int REQUEST_TIMEOUT = 30;

    public static final double ASSERT_PRECISION = 0.01;
    
    /**
     * Global rules for tests.
     */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(REQUEST_TIMEOUT);
    
    /**
     * Test fixtures,
     * Used to serve as HttpCallback and to capture request & response.
     */

    protected static HttpCallbackCatcher httpResponse;
    
    /**
     * Setup test.
     */
    @BeforeClass
    public static void setUp() throws Exception {
        httpResponse = new HttpCallbackCatcher(); 
    }

    /**
     * Tear down test.
     */
    @AfterClass
    public static void tearDown() throws Exception {
        httpResponse = null;
    }

    /**
     * Create test configuration from Environment variables.
     */
    protected static SquareClient createConfigurationFromEnvironment() {
        SquareClient.Builder builder = new SquareClient.Builder();

        final String environment = System.getenv("SQUARE_ENVIRONMENT");
        final String customUrl = System.getenv("SQUARE_CUSTOM_URL");
        final String squareVersion = System.getenv("SQUARE_SQUARE_VERSION");
        final String timeout = System.getenv("SQUARE_TIMEOUT");
        final String accessToken = System.getenv("SQUARE_ACCESS_TOKEN");

        if (accessToken != null) {
            builder.accessToken(accessToken);
        }
        if (environment != null) {
            builder.environment(Environment.fromString(environment));
        }
        if (customUrl != null) {
            builder.customUrl(customUrl);
        }
        if (squareVersion != null) {
            builder.squareVersion(squareVersion);
        }
        if (timeout != null) {
            builder.httpClientConfig(configBuilder -> configBuilder.timeout(
                    Long.parseLong(timeout)));
        }
        return builder.build();
    }

    
    /**
     * Create test configuration.
     */
    protected static SquareClient createConfiguration() {
        // Set Configuration parameters for test execution
        SquareClient config = createConfigurationFromEnvironment();
        config = config.newBuilder()
                .httpCallback(httpResponse)
                .build();
        return config;
    }
}

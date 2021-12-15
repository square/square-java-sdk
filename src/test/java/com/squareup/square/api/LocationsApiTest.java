
package com.squareup.square.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.squareup.square.SquareClient;
import com.squareup.square.exceptions.ApiException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocationsApiTest extends BaseApiTest {

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

    /**
     * Provides details about all of the seller's locations, including those with an inactive
     * status.
     * @throws Throwable exception if occurs.
     */
    @Test
    public void testListLocations() throws Exception {

        // Set callback and perform API call
        try {
            controller.listLocations();
        } catch (ApiException e) {
            // Empty block
        }

        // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

    }

}

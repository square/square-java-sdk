package com.squareup.square.api;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.squareup.square.ApiHelper;
import com.squareup.square.SquareClient;
import com.squareup.square.exceptions.*;
import com.squareup.square.models.*;
import com.squareup.square.testing.TestHelper;


public class LocationsApiTest extends BaseApiTest {

    /**
     * Client instance
     */
    private static SquareClient client;
    
    /**
     * Controller instance (for all tests)
     */
    private static LocationsApi controller;

    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        client = createConfiguration();
        controller = client.getLocationsApi();
    }

    /**
     * Tear down test class
     * @throws IOException
     */
    @AfterClass
    public static void tearDownClass() throws IOException {
        controller = null;
    }

    /**
     * Provides information of all locations of a business.
     * Most other Connect API endpoints have a required `location_id` path parameter.
     * The `id` field of the [`Location`](#type-location) objects returned by this
     * endpoint correspond to that `location_id` parameter.
     * @throws Throwable
     */
    @Test
    public void testListLocations() throws Exception {

        // Set callback and perform API call
        ListLocationsResponse result = null;
        try {
            result = controller.listLocations();
        } catch(ApiException e) {};

        // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

    }

}

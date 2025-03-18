package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.types.ListLocationsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class LocationsTest {
    private static SquareClient client;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
    }

    @Test
    public void testListLocations() {
        ListLocationsResponse response = client.locations().list();

        Assertions.assertTrue(response.getLocations().isPresent());
        Assertions.assertFalse(response.getLocations().get().isEmpty());
    }
}

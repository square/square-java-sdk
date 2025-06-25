package com.squareup.square.legacy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.ListLocationsResponse;
import com.squareup.square.legacy.models.Location;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

public final class LegacyTest {

    @Test
    public void testListLocations() {
        String token = System.getenv("TEST_SQUARE_TOKEN");

        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Please provide an API key to run tests");
        }

        SquareClient legacyClient = new SquareClient.Builder()
                .environment(com.squareup.square.legacy.Environment.SANDBOX)
                .accessToken(token)
                .build();

        ListLocationsResponse response;
        try {
            response = legacyClient.getLocationsApi().listLocations();
        } catch (ApiException | IOException e) {
            throw new RuntimeException(e);
        }

        List<Location> locations = response.getLocations();
        assertNotNull(locations);
        assertFalse(locations.isEmpty());
    }
}

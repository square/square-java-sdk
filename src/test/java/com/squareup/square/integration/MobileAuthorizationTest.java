package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.types.CreateMobileAuthorizationCodeRequest;
import com.squareup.square.types.CreateMobileAuthorizationCodeResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class MobileAuthorizationTest {
    private static SquareClient client;
    private static String locationId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
        locationId = Helpers.getDefaultLocationId(client);
    }

    @Test
    public void testCreateMobileAuthorizationCode() {
        CreateMobileAuthorizationCodeResponse response = client.mobile()
                .authorizationCode(CreateMobileAuthorizationCodeRequest.builder()
                        .locationId(locationId)
                        .build());

        Assertions.assertTrue(response.getAuthorizationCode().isPresent());
        Assertions.assertTrue(response.getExpiresAt().isPresent());
    }
}

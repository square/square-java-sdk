package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.terminal.types.CancelCheckoutsRequest;
import com.squareup.square.terminal.types.CreateTerminalCheckoutRequest;
import com.squareup.square.terminal.types.GetCheckoutsRequest;
import com.squareup.square.terminal.types.SearchTerminalCheckoutsRequest;
import com.squareup.square.types.CancelTerminalCheckoutResponse;
import com.squareup.square.types.CreateTerminalCheckoutResponse;
import com.squareup.square.types.DeviceCheckoutOptions;
import com.squareup.square.types.GetTerminalCheckoutResponse;
import com.squareup.square.types.SearchTerminalCheckoutsResponse;
import com.squareup.square.types.TerminalCheckout;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class TerminalTest {
    private SquareClient client;
    private String checkoutId;
    private String sandboxDeviceId = "da40d603-c2ea-4a65-8cfd-f42e36dab0c7";

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // Create terminal checkout for testing
        CreateTerminalCheckoutRequest checkoutRequest = CreateTerminalCheckoutRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .checkout(TerminalCheckout.builder()
                        .amountMoney(Helpers.newTestMoney(100))
                        .deviceOptions(DeviceCheckoutOptions.builder()
                                .deviceId(sandboxDeviceId)
                                .build())
                        .build())
                .build();
        CreateTerminalCheckoutResponse checkoutResponse =
                client.terminal().checkouts().create(checkoutRequest);
        if (!checkoutResponse.getCheckout().get().getId().isPresent()) {
            throw new RuntimeException("Checkout ID is null.");
        }
        checkoutId = checkoutResponse.getCheckout().get().getId().get();
    }

    @Test
    public void testCreateTerminalCheckout() {
        CreateTerminalCheckoutRequest checkoutRequest = CreateTerminalCheckoutRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .checkout(TerminalCheckout.builder()
                        .amountMoney(Helpers.newTestMoney(100))
                        .deviceOptions(DeviceCheckoutOptions.builder()
                                .deviceId(sandboxDeviceId)
                                .build())
                        .build())
                .build();
        CreateTerminalCheckoutResponse response = client.terminal().checkouts().create(checkoutRequest);

        Assertions.assertTrue(response.getCheckout().isPresent());
        Assertions.assertEquals(
                sandboxDeviceId, response.getCheckout().get().getDeviceOptions().getDeviceId());
        Assertions.assertEquals(
                100, response.getCheckout().get().getAmountMoney().getAmount().get());
    }

    @Test
    public void testSearchTerminalCheckouts() {
        SearchTerminalCheckoutsRequest searchRequest =
                SearchTerminalCheckoutsRequest.builder().limit(1).build();
        SearchTerminalCheckoutsResponse response = client.terminal().checkouts().search(searchRequest);

        Assertions.assertTrue(response.getCheckouts().isPresent());
        Assertions.assertFalse(response.getCheckouts().get().isEmpty());
    }

    @Test
    public void testGetTerminalCheckout() {
        GetTerminalCheckoutResponse response = client.terminal()
                .checkouts()
                .get(GetCheckoutsRequest.builder().checkoutId(checkoutId).build());

        Assertions.assertTrue(response.getCheckout().isPresent());
        Assertions.assertEquals(checkoutId, response.getCheckout().get().getId().get());
    }

    @Test
    public void testCancelTerminalCheckout() {
        CancelTerminalCheckoutResponse response = client.terminal()
                .checkouts()
                .cancel(CancelCheckoutsRequest.builder().checkoutId(checkoutId).build());

        Assertions.assertTrue(response.getCheckout().isPresent());
        Assertions.assertEquals(
                "CANCELED", response.getCheckout().get().getStatus().get());
    }
}

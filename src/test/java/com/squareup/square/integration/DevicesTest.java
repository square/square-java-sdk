package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.devices.types.CreateDeviceCodeRequest;
import com.squareup.square.devices.types.GetCodesRequest;
import com.squareup.square.types.CreateDeviceCodeResponse;
import com.squareup.square.types.DeviceCode;
import com.squareup.square.types.GetDeviceCodeResponse;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class DevicesTest {
    private SquareClient client;
    private String deviceCodeId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        CreateDeviceCodeResponse createResponse = client.devices()
                .codes()
                .create(CreateDeviceCodeRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .deviceCode(
                                DeviceCode.builder().productType("TERMINAL_API").build())
                        .build());
        Optional<DeviceCode> deviceCode = createResponse.getDeviceCode();
        if (!deviceCode.isPresent()) {
            throw new RuntimeException("Failed to create device code.");
        }
        if (!deviceCode.get().getId().isPresent()) {
            throw new RuntimeException("Device code ID is null.");
        }
        deviceCodeId = deviceCode.get().getId().get();
    }

    @Test
    public void testListDeviceCodes() {
        SyncPagingIterable<DeviceCode> response = client.devices().codes().list();
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testCreateDeviceCode() {
        CreateDeviceCodeResponse response = client.devices()
                .codes()
                .create(CreateDeviceCodeRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .deviceCode(
                                DeviceCode.builder().productType("TERMINAL_API").build())
                        .build());
        Assertions.assertTrue(response.getDeviceCode().isPresent());
        Assertions.assertEquals("TERMINAL_API", response.getDeviceCode().get().getProductType());
    }

    @Test
    public void testGetDeviceCode() {
        GetDeviceCodeResponse response = client.devices()
                .codes()
                .get(GetCodesRequest.builder().id(deviceCodeId).build());
        Assertions.assertTrue(response.getDeviceCode().isPresent());
        Assertions.assertEquals(
                deviceCodeId, response.getDeviceCode().get().getId().get());
        Assertions.assertEquals("TERMINAL_API", response.getDeviceCode().get().getProductType());
    }
}

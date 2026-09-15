package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.labor.types.CreateBreakTypeRequest;
import com.squareup.square.labor.types.DeleteBreakTypesRequest;
import com.squareup.square.labor.types.GetBreakTypesRequest;
import com.squareup.square.labor.types.ListWorkweekConfigsRequest;
import com.squareup.square.labor.types.UpdateBreakTypeRequest;
import com.squareup.square.types.BreakType;
import com.squareup.square.types.CreateBreakTypeResponse;
import com.squareup.square.types.DeleteBreakTypeResponse;
import com.squareup.square.types.GetBreakTypeResponse;
import com.squareup.square.types.Location;
import com.squareup.square.types.UpdateBreakTypeResponse;
import com.squareup.square.types.WorkweekConfig;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Labor API integration tests.
 *
 * <p>Shift tests were removed when the Shifts API was retired (2026-05-21, replaced by Timecards).
 * Break type and workweek config coverage remains.
 */
public class LaborTest {
    private SquareClient client;
    private String locationId;
    private String breakId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // Get first available location
        List<Location> locations = client.locations()
                .list()
                .getLocations()
                .orElseThrow(() -> new RuntimeException("No locations available"));
        if (locations.isEmpty()) {
            throw new RuntimeException("No locations available for testing");
        }
        locationId = locations.get(0).getId().orElseThrow(() -> new RuntimeException("Location ID not present"));

        // Create break type for testing
        CreateBreakTypeResponse breakResponse = client.labor()
                .breakTypes()
                .create(CreateBreakTypeRequest.builder()
                        .breakType(BreakType.builder()
                                .locationId(locationId)
                                .breakName("Lunch_" + UUID.randomUUID())
                                .expectedDuration("PT0H30M0S")
                                .isPaid(true)
                                .build())
                        .idempotencyKey(UUID.randomUUID().toString())
                        .build());
        if (!breakResponse.getBreakType().get().getId().isPresent()) {
            throw new RuntimeException("Failed to create break type.");
        }
        breakId = breakResponse.getBreakType().get().getId().get();
    }

    @AfterEach
    public void after() {
        try {
            client.labor()
                    .breakTypes()
                    .delete(DeleteBreakTypesRequest.builder().id(breakId).build());
        } catch (Exception e) {
            // Test may have already deleted the break
        }
    }

    @Test
    public void testListBreakTypes() {
        SyncPagingIterable<BreakType> response = client.labor().breakTypes().list();
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testGetBreakType() {
        GetBreakTypeResponse response = client.labor()
                .breakTypes()
                .get(GetBreakTypesRequest.builder().id(breakId).build());
        Assertions.assertTrue(response.getBreakType().isPresent());
        Assertions.assertEquals(breakId, response.getBreakType().get().getId().get());
    }

    @Test
    public void testUpdateBreakType() {
        UpdateBreakTypeRequest updateRequest = UpdateBreakTypeRequest.builder()
                .id(breakId)
                .breakType(BreakType.builder()
                        .locationId(locationId)
                        .breakName("Lunch_" + UUID.randomUUID())
                        .expectedDuration("PT1H0M0S")
                        .isPaid(true)
                        .build())
                .build();
        UpdateBreakTypeResponse response = client.labor().breakTypes().update(updateRequest);
        Assertions.assertTrue(response.getBreakType().isPresent());
        Assertions.assertEquals(breakId, response.getBreakType().get().getId().get());
        Assertions.assertEquals("PT1H", response.getBreakType().get().getExpectedDuration());
    }

    @Test
    public void testDeleteBreakType() {
        // Create break type
        CreateBreakTypeResponse breakResponse = client.labor()
                .breakTypes()
                .create(CreateBreakTypeRequest.builder()
                        .breakType(BreakType.builder()
                                .locationId(locationId)
                                .breakName("Lunch_" + UUID.randomUUID())
                                .expectedDuration("PT0H30M0S")
                                .isPaid(true)
                                .build())
                        .idempotencyKey(UUID.randomUUID().toString())
                        .build());

        Optional<BreakType> breakType = breakResponse.getBreakType();
        if (!breakType.isPresent()) {
            throw new RuntimeException("Failed to create break type.");
        }
        if (!breakType.get().getId().isPresent()) {
            throw new RuntimeException("Break ID is null.");
        }
        String testBreakId = breakType.get().getId().get();

        DeleteBreakTypeResponse response = client.labor()
                .breakTypes()
                .delete(DeleteBreakTypesRequest.builder().id(testBreakId).build());
        Assertions.assertNotNull(response);
    }

    @Test
    public void testListWorkweekConfigs() {
        SyncPagingIterable<WorkweekConfig> response = client.labor()
                .workweekConfigs()
                .list(ListWorkweekConfigsRequest.builder().build());
        Assertions.assertFalse(response.getItems().isEmpty());
    }
}

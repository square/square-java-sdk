package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.labor.types.CreateBreakTypeRequest;
import com.squareup.square.labor.types.CreateShiftRequest;
import com.squareup.square.labor.types.DeleteBreakTypesRequest;
import com.squareup.square.labor.types.DeleteShiftsRequest;
import com.squareup.square.labor.types.GetBreakTypesRequest;
import com.squareup.square.labor.types.GetShiftsRequest;
import com.squareup.square.labor.types.ListWorkweekConfigsRequest;
import com.squareup.square.labor.types.SearchShiftsRequest;
import com.squareup.square.labor.types.UpdateBreakTypeRequest;
import com.squareup.square.labor.types.UpdateShiftRequest;
import com.squareup.square.types.BreakType;
import com.squareup.square.types.CreateBreakTypeResponse;
import com.squareup.square.types.CreateShiftResponse;
import com.squareup.square.types.DeleteBreakTypeResponse;
import com.squareup.square.types.DeleteShiftResponse;
import com.squareup.square.types.GetBreakTypeResponse;
import com.squareup.square.types.GetShiftResponse;
import com.squareup.square.types.Location;
import com.squareup.square.types.SearchShiftsResponse;
import com.squareup.square.types.SearchTeamMembersFilter;
import com.squareup.square.types.SearchTeamMembersQuery;
import com.squareup.square.types.SearchTeamMembersRequest;
import com.squareup.square.types.Shift;
import com.squareup.square.types.ShiftWage;
import com.squareup.square.types.TeamMember;
import com.squareup.square.types.TeamMemberStatus;
import com.squareup.square.types.UpdateBreakTypeResponse;
import com.squareup.square.types.UpdateShiftResponse;
import com.squareup.square.types.WorkweekConfig;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LaborTest {
    private SquareClient client;
    private String locationId;
    private String memberId;
    private String breakId;
    private String shiftId;

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

        // Get first available team member at this location
        List<TeamMember> teamMembers = client.teamMembers()
                .search(SearchTeamMembersRequest.builder()
                        .query(SearchTeamMembersQuery.builder()
                                .filter(SearchTeamMembersFilter.builder()
                                        .locationIds(Collections.singletonList(locationId))
                                        .status(TeamMemberStatus.ACTIVE)
                                        .build())
                                .build())
                        .build())
                .getTeamMembers()
                .orElseThrow(() -> new RuntimeException("Failed to get team members"));

        if (teamMembers.isEmpty()) {
            throw new RuntimeException("No team members available at location " + locationId);
        }
        memberId = teamMembers.get(0).getId().orElseThrow(() -> new RuntimeException("Team member ID not present"));

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

        // Create shift for testing
        CreateShiftResponse shiftResponse = client.labor()
                .shifts()
                .create(CreateShiftRequest.builder()
                        .shift(Shift.builder()
                                .locationId(locationId)
                                .startAt(OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                                .teamMemberId(memberId)
                                .build())
                        .idempotencyKey(UUID.randomUUID().toString())
                        .build());
        if (!shiftResponse.getShift().get().getId().isPresent()) {
            throw new RuntimeException("Failed to create shift.");
        }
        shiftId = shiftResponse.getShift().get().getId().get();
    }

    @AfterEach
    public void after() {
        // Clean up resources
        try {
            client.labor()
                    .shifts()
                    .delete(DeleteShiftsRequest.builder().id(shiftId).build());
        } catch (Exception e) {
            // Test may have already deleted the shift
        }

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
    public void testSearchShifts() {
        SearchShiftsRequest searchRequest =
                SearchShiftsRequest.builder().limit(1).build();
        SearchShiftsResponse response = client.labor().shifts().search(searchRequest);
        Assertions.assertTrue(response.getShifts().isPresent());
        Assertions.assertFalse(response.getShifts().get().isEmpty());
    }

    @Test
    public void testGetShift() {
        GetShiftResponse response = client.labor()
                .shifts()
                .get(GetShiftsRequest.builder().id(shiftId).build());
        Assertions.assertTrue(response.getShift().isPresent());
        Assertions.assertEquals(shiftId, response.getShift().get().getId().get());
    }

    @Test
    public void testUpdateShift() {
        UpdateShiftRequest updateRequest = UpdateShiftRequest.builder()
                .id(shiftId)
                .shift(Shift.builder()
                        .locationId(locationId)
                        .startAt(OffsetDateTime.now().minusMinutes(1).format(DateTimeFormatter.ISO_INSTANT))
                        .teamMemberId(memberId)
                        .wage(ShiftWage.builder()
                                .title("Manager")
                                .hourlyRate(Helpers.newTestMoney(2500))
                                .build())
                        .build())
                .build();
        UpdateShiftResponse response = client.labor().shifts().update(updateRequest);
        Assertions.assertTrue(response.getShift().isPresent());
        Assertions.assertEquals(
                "Manager", response.getShift().get().getWage().get().getTitle().get());
        Assertions.assertEquals(
                2500,
                response.getShift()
                        .get()
                        .getWage()
                        .get()
                        .getHourlyRate()
                        .get()
                        .getAmount()
                        .get());
        Assertions.assertEquals(
                "USD",
                response.getShift()
                        .get()
                        .getWage()
                        .get()
                        .getHourlyRate()
                        .get()
                        .getCurrency()
                        .get()
                        .toString());
    }

    @Test
    public void testDeleteShift() throws Exception {
        try {
            // First search for existing shifts for this team member using query filter
            SearchShiftsRequest searchRequest = SearchShiftsRequest.builder()
                    .query(com.squareup.square.types.ShiftQuery.builder()
                            .filter(com.squareup.square.types.ShiftFilter.builder()
                                    .teamMemberIds(Collections.singletonList(memberId))
                                    .build())
                            .build())
                    .limit(100)
                    .build();

            SearchShiftsResponse existingShifts = client.labor().shifts().search(searchRequest);

            // Delete any existing shifts
            if (existingShifts.getShifts().isPresent()) {
                for (Shift existingShift : existingShifts.getShifts().get()) {
                    if (existingShift.getId().isPresent()) {
                        client.labor()
                                .shifts()
                                .delete(DeleteShiftsRequest.builder()
                                        .id(existingShift.getId().get())
                                        .build());
                    }
                }
            }

            // Start the shift 10 seconds from now and end it 20 seconds from now
            OffsetDateTime startTime = OffsetDateTime.now().plusSeconds(10);
            OffsetDateTime endTime = startTime.plusSeconds(10); // Very short shift for testing

            // Create shift
            CreateShiftResponse shiftResponse = client.labor()
                    .shifts()
                    .create(CreateShiftRequest.builder()
                            .shift(Shift.builder()
                                    .locationId(locationId)
                                    .startAt(startTime.format(DateTimeFormatter.ISO_INSTANT))
                                    .teamMemberId(memberId)
                                    .endAt(endTime.format(DateTimeFormatter.ISO_INSTANT))
                                    .build())
                            .idempotencyKey(UUID.randomUUID().toString())
                            .build());

            if (!shiftResponse.getShift().isPresent()) {
                throw new RuntimeException("Failed to create shift: shift response is empty");
            }

            Optional<Shift> shift = shiftResponse.getShift();
            if (!shift.get().getId().isPresent()) {
                throw new RuntimeException("Shift ID is null in response: " + shift);
            }

            String testShiftId = shift.get().getId().get();

            // Add a small delay to ensure the shift is fully created
            Thread.sleep(1000);

            DeleteShiftResponse response = client.labor()
                    .shifts()
                    .delete(DeleteShiftsRequest.builder().id(testShiftId).build());
            Assertions.assertNotNull(response);

        } catch (Exception e) {
            System.err.println("Test failed with exception: " + e.getMessage());
            if (e instanceof com.squareup.square.core.SquareApiException) {
                System.err.println("API Error details: " + e.getMessage());
            }
            e.printStackTrace();
            throw e;
        }
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

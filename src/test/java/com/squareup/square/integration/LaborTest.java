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
import com.squareup.square.types.CreateTeamMemberRequest;
import com.squareup.square.types.CreateTeamMemberResponse;
import com.squareup.square.types.DeleteBreakTypeResponse;
import com.squareup.square.types.DeleteShiftResponse;
import com.squareup.square.types.GetBreakTypeResponse;
import com.squareup.square.types.GetShiftResponse;
import com.squareup.square.types.SearchShiftsResponse;
import com.squareup.square.types.Shift;
import com.squareup.square.types.ShiftWage;
import com.squareup.square.types.TeamMember;
import com.squareup.square.types.UpdateBreakTypeResponse;
import com.squareup.square.types.UpdateShiftResponse;
import com.squareup.square.types.WorkweekConfig;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
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
        locationId = Helpers.createLocation(client);

        // Create team member for testing
        CreateTeamMemberResponse teamResponse = client.teamMembers()
                .create(CreateTeamMemberRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .teamMember(TeamMember.builder()
                                .givenName("Sherlock")
                                .familyName("Holmes")
                                .build())
                        .build());
        if (!teamResponse.getTeamMember().get().getId().isPresent()) {
            throw new RuntimeException("Failed to create team member.");
        }
        memberId = teamResponse.getTeamMember().get().getId().get();

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
    public void testDeleteShift() {
        // create team member
        CreateTeamMemberResponse teamMemberResponse = client.teamMembers()
                .create(CreateTeamMemberRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .teamMember(TeamMember.builder()
                                .givenName("Sherlock")
                                .familyName("Holmes")
                                .build())
                        .build());

        // create shift
        CreateShiftResponse shiftResponse = client.labor()
                .shifts()
                .create(CreateShiftRequest.builder()
                        .shift(Shift.builder()
                                .locationId(locationId)
                                .startAt(OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                                .teamMemberId(
                                        teamMemberResponse.getTeamMember().get().getId())
                                .build())
                        .idempotencyKey(UUID.randomUUID().toString())
                        .build());

        if (!shiftResponse.getShift().isPresent()) {
            throw new RuntimeException("Failed to create shift.");
        }
        if (!shiftResponse.getShift().get().getId().isPresent()) {
            throw new RuntimeException("Shift ID is null.");
        }
        shiftId = shiftResponse.getShift().get().getId().get();
        DeleteShiftResponse response = client.labor()
                .shifts()
                .delete(DeleteShiftsRequest.builder().id(shiftId).build());
        Assertions.assertNotNull(response);
    }

    @Test
    public void testDeleteBreakType() {
        // create break type
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
        breakId = breakType.get().getId().get();

        DeleteBreakTypeResponse response = client.labor()
                .breakTypes()
                .delete(DeleteBreakTypesRequest.builder().id(breakId).build());
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

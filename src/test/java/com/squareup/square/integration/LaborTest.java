package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SquareApiException;
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
    private static final int MAX_RETRIES = 5;
    private static final long INITIAL_RETRY_DELAY_MS = 2000;
    private static final long DELAY_BETWEEN_OPERATIONS_MS = 2000;

    private SquareClient client;
    private String locationId;
    private String memberId;
    private String breakId;
    private String shiftId;

    private interface ApiCall<T> {
        T execute() throws SquareApiException;
    }

    private <T> T withRetry(ApiCall<T> apiCall) throws SquareApiException {
        SquareApiException lastException = null;

        for (int attempt = 0; attempt < MAX_RETRIES; attempt++) {
            try {
                if (attempt > 0) {
                    // Calculate exponential backoff delay
                    long delayMs = INITIAL_RETRY_DELAY_MS * (long) Math.pow(2, attempt - 1);
                    System.out.printf("Retry attempt %d after %d ms delay%n", attempt + 1, delayMs);
                    Thread.sleep(delayMs);
                }

                return apiCall.execute();

            } catch (SquareApiException e) {
                lastException = e;
                
                // Check if it's a rate limit error
                if (e.statusCode() == 429) {
                    System.out.printf("Rate limited on attempt %d%n", attempt + 1);
                    continue;
                }
                
                // For authentication errors, throw immediately
                if (e.statusCode() == 401 || e.statusCode() == 403) {
                    throw e;
                }
                
                // For other errors, retry
                System.out.printf("API error on attempt %d: %s%n", attempt + 1, e.getMessage());
                
                if (attempt == MAX_RETRIES - 1) {
                    throw e;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted during retry delay", e);
            }
        }

        // If we've exhausted all retries, throw the last exception
        throw lastException;
    }

    @BeforeEach
    public void before() throws Exception {
        client = TestClientFactory.create();
        
        try {
            // Create location with retry
            locationId = withRetry(() -> Helpers.createLocation(client));
            System.out.println("Created location: " + locationId);

            Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);

            // Create team member for testing with retry
            CreateTeamMemberResponse teamResponse = withRetry(() ->
                client.teamMembers()
                    .create(CreateTeamMemberRequest.builder()
                            .idempotencyKey(UUID.randomUUID().toString())
                            .teamMember(TeamMember.builder()
                                    .givenName("Sherlock")
                                    .familyName("Holmes")
                                    .build())
                            .build())
            );

            if (!teamResponse.getTeamMember().isPresent() || !teamResponse.getTeamMember().get().getId().isPresent()) {
                throw new RuntimeException("Failed to create team member: No ID returned");
            }
            memberId = teamResponse.getTeamMember().get().getId().get();
            System.out.println("Created team member: " + memberId);

            Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);

            // Create break type for testing with retry
            CreateBreakTypeResponse breakResponse = withRetry(() ->
                client.labor()
                    .breakTypes()
                    .create(CreateBreakTypeRequest.builder()
                            .breakType(BreakType.builder()
                                    .locationId(locationId)
                                    .breakName("Lunch_" + UUID.randomUUID())
                                    .expectedDuration("PT0H30M0S")
                                    .isPaid(true)
                                    .build())
                            .idempotencyKey(UUID.randomUUID().toString())
                            .build())
            );

            if (!breakResponse.getBreakType().isPresent() || !breakResponse.getBreakType().get().getId().isPresent()) {
                throw new RuntimeException("Failed to create break type: No ID returned");
            }
            breakId = breakResponse.getBreakType().get().getId().get();
            System.out.println("Created break type: " + breakId);

            Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);

            // Create shift for testing with retry
            CreateShiftResponse shiftResponse = withRetry(() ->
                client.labor()
                    .shifts()
                    .create(CreateShiftRequest.builder()
                            .shift(Shift.builder()
                                    .locationId(locationId)
                                    .startAt(OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                                    .teamMemberId(memberId)
                                    .build())
                            .idempotencyKey(UUID.randomUUID().toString())
                            .build())
            );

            if (!shiftResponse.getShift().isPresent() || !shiftResponse.getShift().get().getId().isPresent()) {
                throw new RuntimeException("Failed to create shift: No ID returned");
            }
            shiftId = shiftResponse.getShift().get().getId().get();
            System.out.println("Created shift: " + shiftId);

        } catch (Exception e) {
            System.err.println("Setup failed: " + e.getMessage());
            // Clean up any resources that were created before the failure
            cleanup();
            throw e;
        }
    }

    private void cleanup() {
        // Clean up resources
        if (shiftId != null) {
            try {
                Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
                withRetry(() ->
                    client.labor()
                            .shifts()
                            .delete(DeleteShiftsRequest.builder().id(shiftId).build())
                );
                System.out.println("Successfully deleted shift: " + shiftId);
            } catch (Exception e) {
                System.out.println("Warning: Failed to delete shift: " + e.getMessage());
            }
        }

        if (breakId != null) {
            try {
                Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
                withRetry(() ->
                    client.labor()
                            .breakTypes()
                            .delete(DeleteBreakTypesRequest.builder().id(breakId).build())
                );
                System.out.println("Successfully deleted break type: " + breakId);
            } catch (Exception e) {
                System.out.println("Warning: Failed to delete break type: " + e.getMessage());
            }
        }
    }

    @AfterEach
    public void after() {
        cleanup();
    }

    @Test
    public void testListBreakTypes() throws Exception {
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        SyncPagingIterable<BreakType> response = withRetry(() ->
            client.labor().breakTypes().list()
        );
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testGetBreakType() throws Exception {
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        GetBreakTypeResponse response = withRetry(() ->
            client.labor()
                    .breakTypes()
                    .get(GetBreakTypesRequest.builder().id(breakId).build())
        );
        Assertions.assertTrue(response.getBreakType().isPresent());
        Assertions.assertEquals(breakId, response.getBreakType().get().getId().get());
    }

    @Test
    public void testUpdateBreakType() throws Exception {
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        UpdateBreakTypeRequest updateRequest = UpdateBreakTypeRequest.builder()
                .id(breakId)
                .breakType(BreakType.builder()
                        .locationId(locationId)
                        .breakName("Lunch_" + UUID.randomUUID())
                        .expectedDuration("PT1H0M0S")
                        .isPaid(true)
                        .build())
                .build();
        UpdateBreakTypeResponse response = withRetry(() ->
            client.labor().breakTypes().update(updateRequest)
        );
        Assertions.assertTrue(response.getBreakType().isPresent());
        Assertions.assertEquals(breakId, response.getBreakType().get().getId().get());
        Assertions.assertEquals("PT1H", response.getBreakType().get().getExpectedDuration());
    }

    @Test
    public void testSearchShifts() throws Exception {
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        SearchShiftsRequest searchRequest =
                SearchShiftsRequest.builder().limit(1).build();
        SearchShiftsResponse response = withRetry(() ->
            client.labor().shifts().search(searchRequest)
        );
        Assertions.assertTrue(response.getShifts().isPresent());
        Assertions.assertFalse(response.getShifts().get().isEmpty());
    }

    @Test
    public void testGetShift() throws Exception {
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        GetShiftResponse response = withRetry(() ->
            client.labor()
                    .shifts()
                    .get(GetShiftsRequest.builder().id(shiftId).build())
        );
        Assertions.assertTrue(response.getShift().isPresent());
        Assertions.assertEquals(shiftId, response.getShift().get().getId().get());
    }

    @Test
    public void testUpdateShift() throws Exception {
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
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
        UpdateShiftResponse response = withRetry(() ->
            client.labor().shifts().update(updateRequest)
        );
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
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        // create team member
        CreateTeamMemberResponse teamMemberResponse = withRetry(() ->
            client.teamMembers()
                    .create(CreateTeamMemberRequest.builder()
                            .idempotencyKey(UUID.randomUUID().toString())
                            .teamMember(TeamMember.builder()
                                    .givenName("Sherlock")
                                    .familyName("Holmes")
                                    .build())
                            .build())
        );

        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);

        // create shift
        CreateShiftResponse shiftResponse = withRetry(() ->
            client.labor()
                    .shifts()
                    .create(CreateShiftRequest.builder()
                            .shift(Shift.builder()
                                    .locationId(locationId)
                                    .startAt(OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                                    .teamMemberId(
                                            teamMemberResponse.getTeamMember().get().getId())
                                    .build())
                            .idempotencyKey(UUID.randomUUID().toString())
                            .build())
        );

        if (!shiftResponse.getShift().isPresent()) {
            throw new RuntimeException("Failed to create shift.");
        }
        if (!shiftResponse.getShift().get().getId().isPresent()) {
            throw new RuntimeException("Shift ID is null.");
        }
        String testShiftId = shiftResponse.getShift().get().getId().get();

        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);

        DeleteShiftResponse response = withRetry(() ->
            client.labor()
                    .shifts()
                    .delete(DeleteShiftsRequest.builder().id(testShiftId).build())
        );
        Assertions.assertNotNull(response);
    }

    @Test
    public void testDeleteBreakType() throws Exception {
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        // create break type
        CreateBreakTypeResponse breakResponse = withRetry(() ->
            client.labor()
                    .breakTypes()
                    .create(CreateBreakTypeRequest.builder()
                            .breakType(BreakType.builder()
                                    .locationId(locationId)
                                    .breakName("Lunch_" + UUID.randomUUID())
                                    .expectedDuration("PT0H30M0S")
                                    .isPaid(true)
                                    .build())
                            .idempotencyKey(UUID.randomUUID().toString())
                            .build())
        );

        Optional<BreakType> breakType = breakResponse.getBreakType();
        if (!breakType.isPresent()) {
            throw new RuntimeException("Failed to create break type.");
        }
        if (!breakType.get().getId().isPresent()) {
            throw new RuntimeException("Break ID is null.");
        }
        String testBreakId = breakType.get().getId().get();

        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);

        DeleteBreakTypeResponse response = withRetry(() ->
            client.labor()
                    .breakTypes()
                    .delete(DeleteBreakTypesRequest.builder().id(testBreakId).build())
        );
        Assertions.assertNotNull(response);
    }

    @Test
    public void testListWorkweekConfigs() throws Exception {
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        SyncPagingIterable<WorkweekConfig> response = withRetry(() ->
            client.labor()
                    .workweekConfigs()
                    .list(ListWorkweekConfigsRequest.builder().build())
        );
        Assertions.assertFalse(response.getItems().isEmpty());
    }
}
package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.customers.types.CreateCustomerGroupRequest;
import com.squareup.square.customers.types.DeleteGroupsRequest;
import com.squareup.square.customers.types.GetGroupsRequest;
import com.squareup.square.customers.types.UpdateCustomerGroupRequest;
import com.squareup.square.types.CreateCustomerGroupResponse;
import com.squareup.square.types.CustomerGroup;
import com.squareup.square.types.GetCustomerGroupResponse;
import com.squareup.square.types.UpdateCustomerGroupResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CustomerGroupsTest {

    private static final int MAX_RETRIES = 5;
    private static final long INITIAL_RETRY_DELAY_MS = 2000;
    private static final long DELAY_BETWEEN_OPERATIONS_MS = 2000;

    private SquareClient client;
    private String groupId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
        groupId = this.createTestCustomerGroup();
    }

    @AfterEach
    public void deleteTestCustomerGroup() {
        try {
            // Add delay before cleanup
            Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
            withRetry(() -> client.customers()
                    .groups()
                    .delete(DeleteGroupsRequest.builder().groupId(groupId).build()));
        } catch (Exception e) {
            System.out.println("Warning: Failed to delete test customer group: " + e.getMessage());
        }
    }

    @Test
    public void testCreateAndListCustomerGroup() throws InterruptedException {
        // Add delay before test
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        
        SyncPagingIterable<CustomerGroup> response = withRetry(() -> 
            client.customers().groups().list());
            
        Assertions.assertNotNull(response);
        List<CustomerGroup> groups = response.getItems();
        Assertions.assertFalse(groups.isEmpty());
    }

    @Test
    public void testRetrieveCustomerGroup() throws InterruptedException {
        // Add delay before test
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        
        GetCustomerGroupResponse response = withRetry(() ->
            client.customers()
                    .groups()
                    .get(GetGroupsRequest.builder().groupId(groupId).build()));
                    
        Assertions.assertTrue(response.getGroup().isPresent());
        Assertions.assertEquals(groupId, response.getGroup().get().getId().get());
    }

    @Test
    public void testUpdateCustomerGroup() throws InterruptedException {
        // Add delay before test
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        
        String newName = "Updated-" + UUID.randomUUID();
        UpdateCustomerGroupResponse response = withRetry(() ->
            client.customers()
                    .groups()
                    .update(UpdateCustomerGroupRequest.builder()
                            .groupId(groupId)
                            .group(CustomerGroup.builder().name(newName).build())
                            .build()));
                            
        Assertions.assertTrue(response.getGroup().isPresent());
        Assertions.assertEquals(newName, response.getGroup().get().getName());
    }

    @Test
    public void testRetrieveNonExistentGroup() throws InterruptedException {
        // Add delay before test
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        
        Assertions.assertThrows(SquareApiException.class, () -> {
            withRetry(() ->
                client.customers()
                        .groups()
                        .get(GetGroupsRequest.builder().groupId("not existent id").build()));
        });
    }

    @Test
    public void testCreateGroupWithInvalidData() throws InterruptedException {
        // Add delay before test
        Thread.sleep(DELAY_BETWEEN_OPERATIONS_MS);
        
        Assertions.assertThrows(SquareApiException.class, () -> {
            withRetry(() ->
                client.customers()
                        .groups()
                        .create(CreateCustomerGroupRequest.builder()
                                .group(CustomerGroup.builder()
                                        // Empty name should be invalid
                                        .name("")
                                        .build())
                                .idempotencyKey(UUID.randomUUID().toString())
                                .build()));
        });
    }

    private String createTestCustomerGroup() {
        CreateCustomerGroupResponse response = withRetry(() ->
            client.customers()
                    .groups()
                    .create(CreateCustomerGroupRequest.builder()
                            .group(CustomerGroup.builder()
                                    .name("Default-" + UUID.randomUUID())
                                    .build())
                            .idempotencyKey(UUID.randomUUID().toString())
                            .build()));
                            
        Optional<CustomerGroup> group = response.getGroup();
        if (!group.isPresent()) {
            throw new RuntimeException("Failed to create test customer group.");
        }
        return group.get().getId().get();
    }

    private interface ApiCall<T> {
        T execute() throws SquareApiException;
    }

    private <T> T withRetry(ApiCall<T> apiCall) {
        int attempt = 0;
        SquareApiException lastException = null;

        while (attempt < MAX_RETRIES) {
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
                    attempt++;
                    continue;
                }
                
                // For other API errors, throw immediately
                throw e;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupted during retry delay", e);
            }
        }

        // If we've exhausted all retries, throw the last exception
        throw lastException;
    }
}
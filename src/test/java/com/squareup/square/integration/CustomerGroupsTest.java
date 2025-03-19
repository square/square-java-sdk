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

    private SquareClient client;
    private String groupId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
        groupId = this.createTestCustomerGroup();
    }

    @AfterEach
    public void deleteTestCustomerGroup() {
        client.customers()
                .groups()
                .delete(DeleteGroupsRequest.builder().groupId(groupId).build());
    }

    @Test
    public void testCreateAndListCustomerGroup() {
        SyncPagingIterable<CustomerGroup> response = client.customers().groups().list();
        Assertions.assertNotNull(response);
        List<CustomerGroup> groups = response.getItems();
        Assertions.assertFalse(groups.isEmpty());
    }

    @Test
    public void testRetrieveCustomerGroup() {
        GetCustomerGroupResponse response = client.customers()
                .groups()
                .get(GetGroupsRequest.builder().groupId(groupId).build());
        Assertions.assertTrue(response.getGroup().isPresent());
        Assertions.assertEquals(groupId, response.getGroup().get().getId().get());
    }

    @Test
    public void testUpdateCustomerGroup() {
        String newName = "Updated-" + UUID.randomUUID();
        UpdateCustomerGroupResponse response = client.customers()
                .groups()
                .update(UpdateCustomerGroupRequest.builder()
                        .groupId(groupId)
                        .group(CustomerGroup.builder().name(newName).build())
                        .build());
        Assertions.assertTrue(response.getGroup().isPresent());
        Assertions.assertEquals(newName, response.getGroup().get().getName());
    }

    @Test
    public void testRetrieveNonExistentGroup() {
        Assertions.assertThrows(SquareApiException.class, () -> {
            client.customers()
                    .groups()
                    .get(GetGroupsRequest.builder().groupId("not existent id").build());
        });
    }

    @Test
    public void testCreateGroupWithInvalidData() {
        Assertions.assertThrows(SquareApiException.class, () -> {
            client.customers()
                    .groups()
                    .create(CreateCustomerGroupRequest.builder()
                            .group(CustomerGroup.builder()
                                    // Empty name should be invalid
                                    .name("")
                                    .build())
                            .idempotencyKey(UUID.randomUUID().toString())
                            .build());
        });
    }

    private String createTestCustomerGroup() {
        CreateCustomerGroupResponse response = client.customers()
                .groups()
                .create(CreateCustomerGroupRequest.builder()
                        .group(CustomerGroup.builder()
                                .name("Default-" + UUID.randomUUID())
                                .build())
                        .idempotencyKey(UUID.randomUUID().toString())
                        .build());
        Optional<CustomerGroup> group = response.getGroup();
        if (!group.isPresent()) {
            throw new RuntimeException("Failed to create test customer group.");
        }
        return group.get().getId().get();
    }
}

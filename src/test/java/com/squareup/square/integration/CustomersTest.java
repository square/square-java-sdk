package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.customers.types.AddGroupsRequest;
import com.squareup.square.customers.types.CreateCustomerCardRequest;
import com.squareup.square.customers.types.CreateCustomerCustomAttributeDefinitionRequest;
import com.squareup.square.customers.types.CreateCustomerGroupRequest;
import com.squareup.square.customers.types.DeleteCardsRequest;
import com.squareup.square.customers.types.DeleteCustomAttributeDefinitionsRequest;
import com.squareup.square.customers.types.DeleteCustomAttributesRequest;
import com.squareup.square.customers.types.DeleteGroupsRequest;
import com.squareup.square.customers.types.ListCustomAttributesRequest;
import com.squareup.square.customers.types.RemoveGroupsRequest;
import com.squareup.square.customers.types.UpsertCustomerCustomAttributeRequest;
import com.squareup.square.types.AddGroupToCustomerResponse;
import com.squareup.square.types.Address;
import com.squareup.square.types.Country;
import com.squareup.square.types.CreateCustomerCardResponse;
import com.squareup.square.types.CreateCustomerGroupResponse;
import com.squareup.square.types.CreateCustomerRequest;
import com.squareup.square.types.CreateCustomerResponse;
import com.squareup.square.types.CustomAttribute;
import com.squareup.square.types.CustomAttributeDefinition;
import com.squareup.square.types.CustomAttributeDefinitionVisibility;
import com.squareup.square.types.Customer;
import com.squareup.square.types.CustomerGroup;
import com.squareup.square.types.DeleteCustomerCardResponse;
import com.squareup.square.types.DeleteCustomerCustomAttributeResponse;
import com.squareup.square.types.DeleteCustomersRequest;
import com.squareup.square.types.GetCustomerResponse;
import com.squareup.square.types.GetCustomersRequest;
import com.squareup.square.types.RemoveGroupFromCustomerResponse;
import com.squareup.square.types.SearchCustomersRequest;
import com.squareup.square.types.SearchCustomersResponse;
import com.squareup.square.types.UpdateCustomerRequest;
import com.squareup.square.types.UpdateCustomerResponse;
import com.squareup.square.types.UpsertCustomerCustomAttributeResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CustomersTest {
    private SquareClient client;
    private String customerId;
    private String customerGroupId;
    private String customAttributeKey;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // Create test customer
        CreateCustomerResponse customerResponse = client.customers()
                .create(CreateCustomerRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .givenName("Amelia")
                        .familyName("Earhart")
                        .phoneNumber("1-212-555-4240")
                        .note("a customer")
                        .address(Address.builder()
                                .addressLine1("500 Electric Ave")
                                .addressLine2("Suite 600")
                                .locality("New York")
                                .administrativeDistrictLevel1("NY")
                                .postalCode("10003")
                                .country(Country.US)
                                .build())
                        .build());
        Optional<Customer> customer = customerResponse.getCustomer();
        if (!customer.isPresent()) {
            throw new RuntimeException("Failed to create test customer.");
        }
        if (!customer.get().getId().isPresent()) {
            throw new RuntimeException("Customer ID is null.");
        }
        customerId = customer.get().getId().get();

        // Create a customer group for testing
        CreateCustomerGroupResponse createGroupResponse = client.customers()
                .groups()
                .create(CreateCustomerGroupRequest.builder()
                        .group(CustomerGroup.builder()
                                .name("Test Group " + UUID.randomUUID())
                                .build())
                        .idempotencyKey(UUID.randomUUID().toString())
                        .build());
        Optional<CustomerGroup> group = createGroupResponse.getGroup();
        if (!group.isPresent()) {
            throw new RuntimeException("Failed to create test customer group.");
        }
        Optional<String> groupId = group.get().getId();
        if (!groupId.isPresent()) {
            throw new RuntimeException("Group ID is null.");
        }
        customerGroupId = groupId.get();

        // Create custom attribute definition
        customAttributeKey = "favorite-drink-" + UUID.randomUUID();
        client.customers()
                .customAttributeDefinitions()
                .create(CreateCustomerCustomAttributeDefinitionRequest.builder()
                        .customAttributeDefinition(CustomAttributeDefinition.builder()
                                .key(customAttributeKey)
                                .name("Favorite Drink" + UUID.randomUUID())
                                .description("A customer's favorite drink")
                                .visibility(CustomAttributeDefinitionVisibility.VISIBILITY_READ_WRITE_VALUES)
                                .schema(new HashMap<String, Object>() {
                                    {
                                        put(
                                                "$ref",
                                                "https://developer-production-s.squarecdn.com/schemas/v1/common.json#squareup.common.String");
                                    }
                                })
                                .build())
                        .build());
    }

    @AfterEach
    public void after() {
        try {
            client.customers()
                    .delete(DeleteCustomersRequest.builder()
                            .customerId(customerId)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            client.customers()
                    .groups()
                    .delete(DeleteGroupsRequest.builder()
                            .groupId(customerGroupId)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            client.customers()
                    .customAttributeDefinitions()
                    .delete(DeleteCustomAttributeDefinitionsRequest.builder()
                            .key(customAttributeKey)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSearchCustomers() {
        SearchCustomersRequest searchRequest =
                SearchCustomersRequest.builder().limit(1L).build();
        SearchCustomersResponse response = client.customers().search(searchRequest);

        Assertions.assertTrue(response.getCustomers().isPresent());
        Assertions.assertFalse(response.getCustomers().get().isEmpty());
    }

    @Test
    public void testRetrieveCustomer() {
        GetCustomerResponse response = client.customers()
                .get(GetCustomersRequest.builder().customerId(customerId).build());

        Optional<Customer> customer = response.getCustomer();
        Assertions.assertTrue(customer.isPresent());
        Assertions.assertEquals(customerId, customer.get().getId().get());
    }

    @Test
    public void testUpdateCustomer() {
        UpdateCustomerRequest updateRequest = UpdateCustomerRequest.builder()
                .customerId(customerId)
                .givenName("Updated Amelia")
                .familyName("Updated Earhart")
                .build();
        UpdateCustomerResponse response = client.customers().update(updateRequest);

        Optional<Customer> customer = response.getCustomer();
        Assertions.assertTrue(customer.isPresent(), "Failed to update customer.");
        Assertions.assertEquals("Updated Amelia", customer.get().getGivenName().get());
        Assertions.assertEquals(
                "Updated Earhart", customer.get().getFamilyName().get());
    }

    @Test
    public void testCreateCustomerCard() {
        CreateCustomerCardRequest createCardRequest = CreateCustomerCardRequest.builder()
                .customerId(customerId)
                .cardNonce("cnon:card-nonce-ok")
                .build();
        CreateCustomerCardResponse createCardResponse =
                client.customers().cards().create(createCardRequest);

        Assertions.assertTrue(createCardResponse.getCard().isPresent());
        Optional<String> customerCardId = createCardResponse.getCard().get().getId();
        Assertions.assertTrue(customerCardId.isPresent());

        DeleteCustomerCardResponse deleteCardResponse = client.customers()
                .cards()
                .delete(DeleteCardsRequest.builder()
                        .customerId(customerId)
                        .cardId(customerCardId.get())
                        .build());
        Assertions.assertNotNull(deleteCardResponse);
    }

    @Test
    public void testAddCustomerToGroup() {
        AddGroupToCustomerResponse addGroupResponse = client.customers()
                .groups()
                .add(AddGroupsRequest.builder()
                        .customerId(customerId)
                        .groupId(customerGroupId)
                        .build());
        Assertions.assertNotNull(addGroupResponse);

        RemoveGroupFromCustomerResponse removeGroupResponse = client.customers()
                .groups()
                .remove(RemoveGroupsRequest.builder()
                        .customerId(customerId)
                        .groupId(customerGroupId)
                        .build());
        Assertions.assertNotNull(removeGroupResponse);
    }

    @Test
    public void testCreateCustomerCustomAttribute() {
        UpsertCustomerCustomAttributeResponse createAttrResponse = client.customers()
                .customAttributes()
                .upsert(UpsertCustomerCustomAttributeRequest.builder()
                        .customerId(customerId)
                        .key(customAttributeKey)
                        .customAttribute(CustomAttribute.builder()
                                .value("Double-shot breve")
                                .key(customAttributeKey)
                                .build())
                        .build());

        Assertions.assertTrue(createAttrResponse.getCustomAttribute().isPresent());
        Assertions.assertEquals(
                "Double-shot breve",
                createAttrResponse.getCustomAttribute().get().getValue().get());
    }

    @Test
    public void testUpdateCustomerCustomAttribute() {
        UpsertCustomerCustomAttributeResponse updateAttrResponse = client.customers()
                .customAttributes()
                .upsert(UpsertCustomerCustomAttributeRequest.builder()
                        .customerId(customerId)
                        .key(customAttributeKey)
                        .customAttribute(
                                CustomAttribute.builder().value("Black coffee").build())
                        .build());

        Optional<CustomAttribute> customAttribute = updateAttrResponse.getCustomAttribute();
        Assertions.assertTrue(customAttribute.isPresent());
        Assertions.assertEquals("Black coffee", customAttribute.get().getValue().get());
    }

    @Test
    public void testListCustomerCustomAttributes() {
        client.customers()
                .customAttributes()
                .upsert(UpsertCustomerCustomAttributeRequest.builder()
                        .customerId(customerId)
                        .key(customAttributeKey)
                        .customAttribute(CustomAttribute.builder()
                                .value("Double-shot breve")
                                .build())
                        .build());

        SyncPagingIterable<CustomAttribute> pager = client.customers()
                .customAttributes()
                .list(ListCustomAttributesRequest.builder()
                        .customerId(customerId)
                        .withDefinitions(true)
                        .build());
        Assertions.assertNotNull(pager);

        List<CustomAttribute> attributes = pager.getItems();
        Assertions.assertFalse(attributes.isEmpty());

        DeleteCustomerCustomAttributeResponse deleteAttrResponse = client.customers()
                .customAttributes()
                .delete(DeleteCustomAttributesRequest.builder()
                        .customerId(customerId)
                        .key(customAttributeKey)
                        .build());
        Assertions.assertNotNull(deleteAttrResponse);
    }

    @Test
    public void testDeleteCustomerCustomAttribute() {
        client.customers()
                .customAttributes()
                .upsert(UpsertCustomerCustomAttributeRequest.builder()
                        .customerId(customerId)
                        .key(customAttributeKey)
                        .customAttribute(CustomAttribute.builder()
                                .value("Double-shot breve")
                                .build())
                        .build());

        DeleteCustomerCustomAttributeResponse response = client.customers()
                .customAttributes()
                .delete(DeleteCustomAttributesRequest.builder()
                        .customerId(customerId)
                        .key(customAttributeKey)
                        .build());
        Assertions.assertNotNull(response);
    }
}

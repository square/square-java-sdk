package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.catalog.types.UpsertCatalogObjectRequest;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.CatalogObject;
import com.squareup.square.types.Customer;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public final class PaginationTest {
    private static SquareClient client;

    @BeforeEach
    public void setUpBeforeClass() {
        client = TestClientFactory.create();
    }

    @Test
    public void testCustomersPagination() {
        // Setup: Create 5 customers
        for (int i = 0; i < 5; i++) {
            Helpers.createTestCustomer(client);
        }

        SyncPagingIterable<Customer> pager = client.customers().list();
        int count = 0;
        for (Customer customer : pager) {
            Assertions.assertNotNull(customer);
            Assertions.assertNotNull(customer.getId());
            count++;
        }
        Assertions.assertTrue(count > 4);
    }

    @Test
    @Disabled("Disabled because it occasionally throws 500s")
    public void testCatalogPagination() {
        // Setup: Create 5 catalog items
        for (int i = 0; i < 5; i++) {
            client.catalog()
                    .object()
                    .upsert(UpsertCatalogObjectRequest.builder()
                            .idempotencyKey(UUID.randomUUID().toString())
                            .object(Helpers.createTestCatalogItem(new Helpers.CreateCatalogItemOptions()))
                            .build());
        }

        SyncPagingIterable<CatalogObject> pager = client.catalog().list();
        int count = 0;
        for (CatalogObject object : pager) {
            Assertions.assertNotNull(object);
            count++;
        }
        Assertions.assertTrue(count > 4);
    }
}

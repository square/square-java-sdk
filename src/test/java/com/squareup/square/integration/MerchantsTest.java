package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.GetMerchantResponse;
import com.squareup.square.types.GetMerchantsRequest;
import com.squareup.square.types.Merchant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class MerchantsTest {
    private SquareClient client;
    private String merchantId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // Get first merchant ID
        SyncPagingIterable<Merchant> merchantResponse = client.merchants().list();
        if (merchantResponse.getItems().isEmpty()) {
            throw new RuntimeException("No merchants found.");
        }
        if (!merchantResponse.getItems().get(0).getId().isPresent()) {
            throw new RuntimeException("Merchant ID is null.");
        }
        merchantId = merchantResponse.getItems().get(0).getId().get();
    }

    @Test
    public void testListMerchants() {
        SyncPagingIterable<Merchant> response = client.merchants().list();
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testRetrieveMerchant() {
        GetMerchantResponse response = client.merchants()
                .get(GetMerchantsRequest.builder().merchantId(merchantId).build());

        Assertions.assertTrue(response.getMerchant().isPresent());
        Assertions.assertEquals(merchantId, response.getMerchant().get().getId().get());
    }
}

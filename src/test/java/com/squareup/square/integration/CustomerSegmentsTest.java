package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.customers.types.GetSegmentsRequest;
import com.squareup.square.customers.types.ListSegmentsRequest;
import com.squareup.square.types.CustomerSegment;
import com.squareup.square.types.GetCustomerSegmentResponse;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CustomerSegmentsTest {
    private static SquareClient client;

    @BeforeEach
    public void setUpBeforeClass() {
        client = TestClientFactory.create();
    }

    @Test
    public void testListCustomerSegments() {
        ListSegmentsRequest request = ListSegmentsRequest.builder().build();
        SyncPagingIterable<CustomerSegment> response =
                client.customers().segments().list(request);
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testRetrieveCustomerSegment() {
        ListSegmentsRequest listRequest = ListSegmentsRequest.builder().build();
        SyncPagingIterable<CustomerSegment> listResponse =
                client.customers().segments().list(listRequest);
        CustomerSegment segment = listResponse.iterator().next();
        Optional<String> segmentId = segment.getId();
        if (!segmentId.isPresent()) {
            throw new RuntimeException("Segment ID is null.");
        }

        GetCustomerSegmentResponse response = client.customers()
                .segments()
                .get(GetSegmentsRequest.builder().segmentId(segmentId.get()).build());

        Assertions.assertTrue(response.getSegment().isPresent());
        Assertions.assertNotNull(response.getSegment().get().getName());
    }
}

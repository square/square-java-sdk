package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.cashdrawers.types.ListShiftsRequest;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.CashDrawerShiftSummary;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CashDrawersTest {

    private SquareClient client;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
    }

    @Test
    public void testListCashDrawerShifts() {
        String beginTime = OffsetDateTime.now().minusSeconds(1).format(DateTimeFormatter.ISO_INSTANT);
        String endTime = OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
        String locationId = Helpers.getDefaultLocationId(client);

        ListShiftsRequest request = ListShiftsRequest.builder()
                .locationId(locationId)
                .beginTime(beginTime)
                .endTime(endTime)
                .build();

        SyncPagingIterable<CashDrawerShiftSummary> response =
                client.cashDrawers().shifts().list(request);

        Assertions.assertNotNull(response);
        Assertions.assertDoesNotThrow(response::getItems);
    }
}

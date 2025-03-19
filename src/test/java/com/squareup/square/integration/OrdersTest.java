package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.Nullable;
import com.squareup.square.types.BatchGetOrdersRequest;
import com.squareup.square.types.BatchGetOrdersResponse;
import com.squareup.square.types.CalculateOrderRequest;
import com.squareup.square.types.CalculateOrderResponse;
import com.squareup.square.types.CreateOrderRequest;
import com.squareup.square.types.CreateOrderResponse;
import com.squareup.square.types.Order;
import com.squareup.square.types.OrderLineItem;
import com.squareup.square.types.PayOrderRequest;
import com.squareup.square.types.PayOrderResponse;
import com.squareup.square.types.SearchOrdersRequest;
import com.squareup.square.types.SearchOrdersResponse;
import com.squareup.square.types.UpdateOrderRequest;
import com.squareup.square.types.UpdateOrderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class OrdersTest {
    private SquareClient client;
    private String locationId;
    private String orderId;
    private String lineItemUid;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
        locationId = Helpers.getDefaultLocationId(client);

        // Create initial order for testing
        CreateOrderResponse orderResponse = client.orders()
                .create(CreateOrderRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .order(Order.builder()
                                .locationId(locationId)
                                .lineItems(new ArrayList<OrderLineItem>() {
                                    {
                                        add(OrderLineItem.builder()
                                                .quantity("1")
                                                .name("New Item")
                                                .basePriceMoney(Helpers.newTestMoney(100))
                                                .build());
                                    }
                                })
                                .build())
                        .build());
        Optional<Order> order = orderResponse.getOrder();
        if (!order.isPresent()) {
            throw new RuntimeException("Order is null.");
        }
        if (!order.get().getId().isPresent()) {
            throw new RuntimeException("Order ID is null.");
        }
        orderId = order.get().getId().get();

        Optional<List<OrderLineItem>> lineItems = order.get().getLineItems();
        if (!lineItems.isPresent() || lineItems.get().isEmpty()) {
            throw new RuntimeException("Line items are null or empty.");
        }
        if (!lineItems.get().get(0).getUid().isPresent()) {
            throw new RuntimeException("Line item UID is null.");
        }
        lineItemUid = lineItems.get().get(0).getUid().get();
    }

    @Test
    public void testCreateOrder() {
        CreateOrderResponse response = client.orders()
                .create(CreateOrderRequest.builder()
                        .order(Order.builder()
                                .locationId(locationId)
                                .lineItems(new ArrayList<OrderLineItem>() {
                                    {
                                        add(OrderLineItem.builder()
                                                .quantity("1")
                                                .name("New Item")
                                                .basePriceMoney(Helpers.newTestMoney(100))
                                                .build());
                                    }
                                })
                                .build())
                        .build());

        Assertions.assertTrue(response.getOrder().isPresent());
        Assertions.assertEquals(locationId, response.getOrder().get().getLocationId());
        Optional<List<OrderLineItem>> lineItems = response.getOrder().get().getLineItems();
        Assertions.assertTrue(lineItems.isPresent());
        Assertions.assertFalse(lineItems.get().isEmpty());
        Assertions.assertEquals("New Item", lineItems.get().get(0).getName().get());
    }

    @Test
    public void testBatchRetrieveOrders() {
        BatchGetOrdersResponse response = client.orders()
                .batchGet(BatchGetOrdersRequest.builder().addOrderIds(orderId).build());

        Assertions.assertTrue(response.getOrders().isPresent());
        Assertions.assertEquals(
                orderId, response.getOrders().get().get(0).getId().get());
    }

    @Test
    public void testSearchOrders() {
        SearchOrdersResponse response = client.orders()
                .search(SearchOrdersRequest.builder()
                        .limit(1)
                        .locationIds(new ArrayList<String>() {
                            {
                                add(locationId);
                            }
                        })
                        .build());

        Assertions.assertTrue(response.getOrders().isPresent());
        Assertions.assertFalse(response.getOrders().get().isEmpty());
    }

    @Test
    public void testUpdateOrder() {
        UpdateOrderResponse response = client.orders()
                .update(UpdateOrderRequest.builder()
                        .orderId(orderId)
                        .idempotencyKey(UUID.randomUUID().toString())
                        .order(Order.builder()
                                .locationId(locationId)
                                .lineItems(new ArrayList<OrderLineItem>() {
                                    {
                                        add(OrderLineItem.builder()
                                                .quantity("1")
                                                .name("Updated Item")
                                                .basePriceMoney(Helpers.newTestMoney(0))
                                                .note(Nullable.ofNull())
                                                .build());
                                    }
                                })
                                .version(1)
                                .build())
                        .fieldsToClear(new ArrayList<String>() {
                            {
                                add("line_items[" + lineItemUid + "]");
                            }
                        })
                        .build());

        Assertions.assertTrue(response.getOrder().isPresent());
        Assertions.assertEquals(orderId, response.getOrder().get().getId().get());
        Optional<List<OrderLineItem>> lineItems = response.getOrder().get().getLineItems();
        Assertions.assertTrue(lineItems.isPresent());
        Assertions.assertFalse(lineItems.get().isEmpty());
        Assertions.assertEquals("Updated Item", lineItems.get().get(0).getName().get());
    }

    @Test
    public void testPayOrder() {
        testUpdateOrder();

        PayOrderResponse response = client.orders()
                .pay(PayOrderRequest.builder()
                        .orderId(orderId)
                        .idempotencyKey(UUID.randomUUID().toString())
                        .orderVersion(2)
                        .paymentIds(new ArrayList<>())
                        .build());

        Assertions.assertTrue(response.getOrder().isPresent());
        Assertions.assertEquals(orderId, response.getOrder().get().getId().get());
    }

    @Test
    public void testCalculateOrder() {
        CalculateOrderResponse response = client.orders()
                .calculate(CalculateOrderRequest.builder()
                        .order(Order.builder()
                                .locationId(locationId)
                                .lineItems(new ArrayList<OrderLineItem>() {
                                    {
                                        add(OrderLineItem.builder()
                                                .quantity("1")
                                                .name("New Item")
                                                .basePriceMoney(Helpers.newTestMoney(100))
                                                .build());
                                    }
                                })
                                .build())
                        .build());

        Assertions.assertTrue(response.getOrder().isPresent());
        Assertions.assertTrue(response.getOrder().get().getTotalMoney().isPresent());
    }
}

# Orders

```java
OrdersApi ordersApi = client.getOrdersApi();
```

## Class Name

`OrdersApi`

## Methods

* [Create Order](/doc/orders.md#create-order)
* [Batch Retrieve Orders](/doc/orders.md#batch-retrieve-orders)
* [Update Order](/doc/orders.md#update-order)
* [Calculate Order](/doc/orders.md#calculate-order)
* [Search Orders](/doc/orders.md#search-orders)
* [Pay Order](/doc/orders.md#pay-order)

## Create Order

Creates a new [Order](#type-order) which can include information on products for
purchase and settings to apply to the purchase.

To pay for a created order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders)
guide.

You can modify open orders using the [UpdateOrder](#endpoint-orders-updateorder) endpoint.

To learn more about the Orders API, see the
[Orders API Overview](https://developer.squareup.com/docs/orders-api/what-it-does).

```java
CompletableFuture<CreateOrderResponse> createOrderAsync(
    final String locationId,
    final CreateOrderRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the business location to associate the order with. |
| `body` | [`CreateOrderRequest`](/doc/models/create-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateOrderResponse`](/doc/models/create-order-response.md)

### Example Usage

```java
String locationId = "location_id4";
CreateOrderRequest body = new CreateOrderRequest.Builder()
    .build();

ordersApi.createOrderAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Batch Retrieve Orders

Retrieves a set of [Order](#type-order)s by their IDs.

If a given Order ID does not exist, the ID is ignored instead of generating an error.

```java
CompletableFuture<BatchRetrieveOrdersResponse> batchRetrieveOrdersAsync(
    final String locationId,
    final BatchRetrieveOrdersRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the orders' associated location. |
| `body` | [`BatchRetrieveOrdersRequest`](/doc/models/batch-retrieve-orders-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`BatchRetrieveOrdersResponse`](/doc/models/batch-retrieve-orders-response.md)

### Example Usage

```java
String locationId = "location_id4";
List<String> bodyOrderIds = new LinkedList<>();
bodyOrderIds.add("CAISEM82RcpmcFBM0TfOyiHV3es");
bodyOrderIds.add("CAISENgvlJ6jLWAzERDzjyHVybY");
BatchRetrieveOrdersRequest body = new BatchRetrieveOrdersRequest.Builder(
        bodyOrderIds)
    .build();

ordersApi.batchRetrieveOrdersAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Order

Updates an open [Order](#type-order) by adding, replacing, or deleting
fields. Orders with a `COMPLETED` or `CANCELED` state cannot be updated.

An UpdateOrder request requires the following:

- The `order_id` in the endpoint path, identifying the order to update.
- The latest `version` of the order to update.
- The [sparse order](https://developer.squareup.com/docs/orders-api/manage-orders#sparse-order-objects)
containing only the fields to update and the version the update is
being applied to.
- If deleting fields, the [dot notation paths](https://developer.squareup.com/docs/orders-api/manage-orders#on-dot-notation)
identifying fields to clear.

To pay for an order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders) guide.

To learn more about the Orders API, see the
[Orders API Overview](https://developer.squareup.com/docs/orders-api/what-it-does).

```java
CompletableFuture<UpdateOrderResponse> updateOrderAsync(
    final String locationId,
    final String orderId,
    final UpdateOrderRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the order's associated location. |
| `orderId` | `String` | Template, Required | The ID of the order to update. |
| `body` | [`UpdateOrderRequest`](/doc/models/update-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`UpdateOrderResponse`](/doc/models/update-order-response.md)

### Example Usage

```java
String locationId = "location_id4";
String orderId = "order_id6";
UpdateOrderRequest body = new UpdateOrderRequest.Builder()
    .build();

ordersApi.updateOrderAsync(locationId, orderId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Calculate Order

Calculates an [Order](#type-order).

```java
CompletableFuture<CalculateOrderResponse> calculateOrderAsync(
    final CalculateOrderRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CalculateOrderRequest`](/doc/models/calculate-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CalculateOrderResponse`](/doc/models/calculate-order-response.md)

### Example Usage

```java
List<OrderLineItem> bodyOrderLineItems = new LinkedList<>();

Money bodyOrderLineItems0BasePriceMoney = new Money.Builder()
    .amount(500L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderLineItems0 = new OrderLineItem.Builder(
        "1")
    .name("Item 1")
    .basePriceMoney(bodyOrderLineItems0BasePriceMoney)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems0);

Money bodyOrderLineItems1BasePriceMoney = new Money.Builder()
    .amount(300L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderLineItems1 = new OrderLineItem.Builder(
        "2")
    .name("Item 2")
    .basePriceMoney(bodyOrderLineItems1BasePriceMoney)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems1);

List<OrderLineItemDiscount> bodyOrderDiscounts = new LinkedList<>();

OrderLineItemDiscount bodyOrderDiscounts0 = new OrderLineItemDiscount.Builder()
    .name("50% Off")
    .percentage("50")
    .scope("ORDER")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts0);

Order bodyOrder = new Order.Builder(
        "D7AVYMEAPJ3A3")
    .lineItems(bodyOrderLineItems)
    .discounts(bodyOrderDiscounts)
    .build();
CalculateOrderRequest body = new CalculateOrderRequest.Builder(
        bodyOrder)
    .build();

ordersApi.calculateOrderAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Search Orders

Search all orders for one or more locations. Orders include all sales,
returns, and exchanges regardless of how or when they entered the Square
Ecosystem (e.g. Point of Sale, Invoices, Connect APIs, etc).

SearchOrders requests need to specify which locations to search and define a
[`SearchOrdersQuery`](#type-searchordersquery) object which controls
how to sort or filter the results. Your SearchOrdersQuery can:

  Set filter criteria.
  Set sort order.
  Determine whether to return results as complete Order objects, or as
[OrderEntry](#type-orderentry) objects.

Note that details for orders processed with Square Point of Sale while in
offline mode may not be transmitted to Square for up to 72 hours. Offline
orders have a `created_at` value that reflects the time the order was created,
not the time it was subsequently transmitted to Square.

```java
CompletableFuture<SearchOrdersResponse> searchOrdersAsync(
    final SearchOrdersRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchOrdersRequest`](/doc/models/search-orders-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`SearchOrdersResponse`](/doc/models/search-orders-response.md)

### Example Usage

```java
List<String> bodyLocationIds = new LinkedList<>();
bodyLocationIds.add("057P5VYJ4A5X1");
bodyLocationIds.add("18YC4JDH91E1H");
List<String> bodyQueryFilterStateFilterStates = new LinkedList<>();
bodyQueryFilterStateFilterStates.add("COMPLETED");
SearchOrdersStateFilter bodyQueryFilterStateFilter = new SearchOrdersStateFilter.Builder(
        bodyQueryFilterStateFilterStates)
    .build();
TimeRange bodyQueryFilterDateTimeFilterClosedAt = new TimeRange.Builder()
    .startAt("2018-03-03T20:00:00+00:00")
    .endAt("2019-03-04T21:54:45+00:00")
    .build();
SearchOrdersDateTimeFilter bodyQueryFilterDateTimeFilter = new SearchOrdersDateTimeFilter.Builder()
    .closedAt(bodyQueryFilterDateTimeFilterClosedAt)
    .build();
SearchOrdersFilter bodyQueryFilter = new SearchOrdersFilter.Builder()
    .stateFilter(bodyQueryFilterStateFilter)
    .dateTimeFilter(bodyQueryFilterDateTimeFilter)
    .build();
SearchOrdersSort bodyQuerySort = new SearchOrdersSort.Builder(
        "CLOSED_AT")
    .sortOrder("DESC")
    .build();
SearchOrdersQuery bodyQuery = new SearchOrdersQuery.Builder()
    .filter(bodyQueryFilter)
    .sort(bodyQuerySort)
    .build();
SearchOrdersRequest body = new SearchOrdersRequest.Builder()
    .locationIds(bodyLocationIds)
    .query(bodyQuery)
    .limit(3)
    .returnEntries(true)
    .build();

ordersApi.searchOrdersAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Pay Order

Pay for an [order](#type-order) using one or more approved [payments](#type-payment),
or settle an order with a total of `0`.

The total of the `payment_ids` listed in the request must be equal to the order
total. Orders with a total amount of `0` can be marked as paid by specifying an empty
array of `payment_ids` in the request.

To be used with PayOrder, a payment must:

- Reference the order by specifying the `order_id` when [creating the payment](#endpoint-payments-createpayment).
Any approved payments that reference the same `order_id` not specified in the
`payment_ids` will be canceled.
- Be approved with [delayed capture](https://developer.squareup.com/docs/payments-api/take-payments#delayed-capture).
Using a delayed capture payment with PayOrder will complete the approved payment.

Learn how to [pay for orders with a single payment using the Payments API](https://developer.squareup.com/docs/orders-api/pay-for-orders).

```java
CompletableFuture<PayOrderResponse> payOrderAsync(
    final String orderId,
    final PayOrderRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the order being paid. |
| `body` | [`PayOrderRequest`](/doc/models/pay-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`PayOrderResponse`](/doc/models/pay-order-response.md)

### Example Usage

```java
String orderId = "order_id6";
List<String> bodyPaymentIds = new LinkedList<>();
bodyPaymentIds.add("EnZdNAlWCmfh6Mt5FMNST1o7taB");
bodyPaymentIds.add("0LRiVlbXVwe8ozu4KbZxd12mvaB");
PayOrderRequest body = new PayOrderRequest.Builder(
        "c043a359-7ad9-4136-82a9-c3f1d66dcbff")
    .paymentIds(bodyPaymentIds)
    .build();

ordersApi.payOrderAsync(orderId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


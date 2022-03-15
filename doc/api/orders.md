# Orders

```java
OrdersApi ordersApi = client.getOrdersApi();
```

## Class Name

`OrdersApi`

## Methods

* [Create Order](../../doc/api/orders.md#create-order)
* [Batch Retrieve Orders](../../doc/api/orders.md#batch-retrieve-orders)
* [Calculate Order](../../doc/api/orders.md#calculate-order)
* [Clone Order](../../doc/api/orders.md#clone-order)
* [Search Orders](../../doc/api/orders.md#search-orders)
* [Retrieve Order](../../doc/api/orders.md#retrieve-order)
* [Update Order](../../doc/api/orders.md#update-order)
* [Pay Order](../../doc/api/orders.md#pay-order)


# Create Order

Creates a new [order](../../doc/models/order.md) that can include information about products for
purchase and settings to apply to the purchase.

To pay for a created order, see
[Pay for Orders](../../https://developer.squareup.com/docs/orders-api/pay-for-orders).

You can modify open orders using the [UpdateOrder](../../doc/api/orders.md#update-order) endpoint.

```java
CompletableFuture<CreateOrderResponse> createOrderAsync(
    final CreateOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateOrderRequest`](../../doc/models/create-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateOrderResponse`](../../doc/models/create-order-response.md)

## Example Usage

```java
OrderSource orderSource = new OrderSource.Builder()
    .name("name6")
    .build();
List<OrderLineItem> bodyOrderLineItems = new LinkedList<>();

MeasurementUnitCustom measurementUnitCustom = new MeasurementUnitCustom.Builder(
        "name9",
        "abbreviation1")
    .build();
MeasurementUnit measurementUnit = new MeasurementUnit.Builder()
    .customUnit(measurementUnitCustomUnit)
    .areaUnit("IMPERIAL_SQUARE_INCH")
    .lengthUnit("METRIC_KILOMETER")
    .volumeUnit("GENERIC_QUART")
    .weightUnit("METRIC_MILLIGRAM")
    .build();
OrderQuantityUnit orderQuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(orderQuantityUnitMeasurementUnit)
    .precision(189)
    .catalogObjectId("catalog_object_id1")
    .catalogVersion(133L)
    .build();
Money money = new Money.Builder()
    .amount(1599L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderLineItems0 = new OrderLineItem.Builder(
        "1")
    .uid("uid1")
    .name("New York Strip Steak")
    .quantityUnit(bodyOrderLineItems0QuantityUnit)
    .note("note3")
    .catalogObjectId("catalog_object_id5")
    .basePriceMoney(bodyOrderLineItems0BasePriceMoney)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems0);

MeasurementUnitCustom measurementUnitCustom = new MeasurementUnitCustom.Builder(
        "name8",
        "abbreviation0")
    .build();
MeasurementUnit measurementUnit = new MeasurementUnit.Builder()
    .customUnit(measurementUnitCustomUnit)
    .areaUnit("IMPERIAL_ACRE")
    .lengthUnit("IMPERIAL_INCH")
    .volumeUnit("GENERIC_PINT")
    .weightUnit("METRIC_GRAM")
    .build();
OrderQuantityUnit orderQuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(orderQuantityUnitMeasurementUnit)
    .precision(188)
    .catalogObjectId("catalog_object_id0")
    .catalogVersion(134L)
    .build();
List<OrderLineItemModifier> bodyOrderLineItems1Modifiers = new LinkedList<>();

Money money = new Money.Builder()
    .amount(53L)
    .currency("TTD")
    .build();
OrderLineItemModifier bodyOrderLineItems1Modifiers0 = new OrderLineItemModifier.Builder()
    .uid("uid1")
    .catalogObjectId("CHQX7Y4KY6N5KINJKZCFURPZ")
    .catalogVersion(69L)
    .name("name1")
    .basePriceMoney(bodyOrderLineItems1Modifiers0BasePriceMoney)
    .build();
bodyOrderLineItems1Modifiers.add(bodyOrderLineItems1Modifiers0);

List<OrderLineItemAppliedDiscount> bodyOrderLineItems1AppliedDiscounts = new LinkedList<>();

Money money = new Money.Builder()
    .amount(164L)
    .currency("CUC")
    .build();
OrderLineItemAppliedDiscount bodyOrderLineItems1AppliedDiscounts0 = new OrderLineItemAppliedDiscount.Builder(
        "one-dollar-off")
    .uid("uid4")
    .appliedMoney(bodyOrderLineItems1AppliedDiscounts0AppliedMoney)
    .build();
bodyOrderLineItems1AppliedDiscounts.add(bodyOrderLineItems1AppliedDiscounts0);

OrderLineItem bodyOrderLineItems1 = new OrderLineItem.Builder(
        "2")
    .uid("uid0")
    .name("name0")
    .quantityUnit(bodyOrderLineItems1QuantityUnit)
    .note("note4")
    .catalogObjectId("BEMYCSMIJL46OCDV4KYIKXIB")
    .modifiers(bodyOrderLineItems1Modifiers)
    .appliedDiscounts(bodyOrderLineItems1AppliedDiscounts)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems1);

List<OrderLineItemTax> bodyOrderTaxes = new LinkedList<>();

OrderLineItemTax bodyOrderTaxes0 = new OrderLineItemTax.Builder()
    .uid("state-sales-tax")
    .catalogObjectId("catalog_object_id1")
    .catalogVersion(189L)
    .name("State Sales Tax")
    .type("UNKNOWN_TAX")
    .percentage("9")
    .scope("ORDER")
    .build();
bodyOrderTaxes.add(bodyOrderTaxes0);

List<OrderLineItemDiscount> bodyOrderDiscounts = new LinkedList<>();

OrderLineItemDiscount bodyOrderDiscounts0 = new OrderLineItemDiscount.Builder()
    .uid("labor-day-sale")
    .catalogObjectId("catalog_object_id5")
    .catalogVersion(89L)
    .name("Labor Day Sale")
    .type("FIXED_PERCENTAGE")
    .percentage("5")
    .scope("ORDER")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts0);

OrderLineItemDiscount bodyOrderDiscounts1 = new OrderLineItemDiscount.Builder()
    .uid("membership-discount")
    .catalogObjectId("DB7L55ZH2BGWI4H23ULIWOQ7")
    .catalogVersion(90L)
    .name("name2")
    .type("FIXED_AMOUNT")
    .scope("ORDER")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts1);

Money money = new Money.Builder()
    .amount(100L)
    .currency("USD")
    .build();
OrderLineItemDiscount bodyOrderDiscounts2 = new OrderLineItemDiscount.Builder()
    .uid("one-dollar-off")
    .catalogObjectId("catalog_object_id7")
    .catalogVersion(91L)
    .name("Sale - $1.00 off")
    .type("VARIABLE_PERCENTAGE")
    .amountMoney(bodyOrderDiscounts2AmountMoney)
    .scope("LINE_ITEM")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts2);

Order order = new Order.Builder(
        "057P5VYJ4A5X1")
    .id("id0")
    .referenceId("my-order-001")
    .source(orderSource)
    .customerId("customer_id8")
    .lineItems(orderLineItems)
    .taxes(orderTaxes)
    .discounts(orderDiscounts)
    .build();
CreateOrderRequest body = new CreateOrderRequest.Builder()
    .order(bodyOrder)
    .idempotencyKey("8193148c-9586-11e6-99f9-28cfe92138cf")
    .build();

ordersApi.createOrderAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Batch Retrieve Orders

Retrieves a set of [orders](../../doc/models/order.md) by their IDs.

If a given order ID does not exist, the ID is ignored instead of generating an error.

```java
CompletableFuture<BatchRetrieveOrdersResponse> batchRetrieveOrdersAsync(
    final BatchRetrieveOrdersRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveOrdersRequest`](../../doc/models/batch-retrieve-orders-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchRetrieveOrdersResponse`](../../doc/models/batch-retrieve-orders-response.md)

## Example Usage

```java
List<String> bodyOrderIds = new LinkedList<>();
bodyOrderIds.add("CAISEM82RcpmcFBM0TfOyiHV3es");
bodyOrderIds.add("CAISENgvlJ6jLWAzERDzjyHVybY");
BatchRetrieveOrdersRequest body = new BatchRetrieveOrdersRequest.Builder(
        bodyOrderIds)
    .locationId("057P5VYJ4A5X1")
    .build();

ordersApi.batchRetrieveOrdersAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Calculate Order

Enables applications to preview order pricing without creating an order.

```java
CompletableFuture<CalculateOrderResponse> calculateOrderAsync(
    final CalculateOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CalculateOrderRequest`](../../doc/models/calculate-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CalculateOrderResponse`](../../doc/models/calculate-order-response.md)

## Example Usage

```java
OrderSource orderSource = new OrderSource.Builder()
    .name("name6")
    .build();
List<OrderLineItem> bodyOrderLineItems = new LinkedList<>();

MeasurementUnitCustom measurementUnitCustom = new MeasurementUnitCustom.Builder(
        "name9",
        "abbreviation1")
    .build();
MeasurementUnit measurementUnit = new MeasurementUnit.Builder()
    .customUnit(measurementUnitCustomUnit)
    .areaUnit("IMPERIAL_SQUARE_INCH")
    .lengthUnit("METRIC_KILOMETER")
    .volumeUnit("GENERIC_QUART")
    .weightUnit("METRIC_MILLIGRAM")
    .build();
OrderQuantityUnit orderQuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(orderQuantityUnitMeasurementUnit)
    .precision(189)
    .catalogObjectId("catalog_object_id1")
    .catalogVersion(133L)
    .build();
Money money = new Money.Builder()
    .amount(500L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderLineItems0 = new OrderLineItem.Builder(
        "1")
    .uid("uid1")
    .name("Item 1")
    .quantityUnit(bodyOrderLineItems0QuantityUnit)
    .note("note3")
    .catalogObjectId("catalog_object_id5")
    .basePriceMoney(bodyOrderLineItems0BasePriceMoney)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems0);

MeasurementUnitCustom measurementUnitCustom = new MeasurementUnitCustom.Builder(
        "name8",
        "abbreviation0")
    .build();
MeasurementUnit measurementUnit = new MeasurementUnit.Builder()
    .customUnit(measurementUnitCustomUnit)
    .areaUnit("IMPERIAL_ACRE")
    .lengthUnit("IMPERIAL_INCH")
    .volumeUnit("GENERIC_PINT")
    .weightUnit("METRIC_GRAM")
    .build();
OrderQuantityUnit orderQuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(orderQuantityUnitMeasurementUnit)
    .precision(188)
    .catalogObjectId("catalog_object_id0")
    .catalogVersion(134L)
    .build();
Money money = new Money.Builder()
    .amount(300L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderLineItems1 = new OrderLineItem.Builder(
        "2")
    .uid("uid0")
    .name("Item 2")
    .quantityUnit(bodyOrderLineItems1QuantityUnit)
    .note("note4")
    .catalogObjectId("catalog_object_id6")
    .basePriceMoney(bodyOrderLineItems1BasePriceMoney)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems1);

List<OrderLineItemDiscount> bodyOrderDiscounts = new LinkedList<>();

OrderLineItemDiscount bodyOrderDiscounts0 = new OrderLineItemDiscount.Builder()
    .uid("uid1")
    .catalogObjectId("catalog_object_id5")
    .catalogVersion(89L)
    .name("50% Off")
    .type("FIXED_PERCENTAGE")
    .percentage("50")
    .scope("ORDER")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts0);

Order order = new Order.Builder(
        "D7AVYMEAPJ3A3")
    .id("id0")
    .referenceId("reference_id8")
    .source(orderSource)
    .customerId("customer_id8")
    .lineItems(orderLineItems)
    .discounts(orderDiscounts)
    .build();
List<OrderReward> bodyProposedRewards = new LinkedList<>();

OrderReward bodyProposedRewards0 = new OrderReward.Builder(
        "id6",
        "reward_tier_id2")
    .build();
bodyProposedRewards.add(bodyProposedRewards0);

OrderReward bodyProposedRewards1 = new OrderReward.Builder(
        "id7",
        "reward_tier_id3")
    .build();
bodyProposedRewards.add(bodyProposedRewards1);

OrderReward bodyProposedRewards2 = new OrderReward.Builder(
        "id8",
        "reward_tier_id4")
    .build();
bodyProposedRewards.add(bodyProposedRewards2);

CalculateOrderRequest body = new CalculateOrderRequest.Builder(
        order)
    .proposedRewards(bodyProposedRewards)
    .build();

ordersApi.calculateOrderAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Clone Order

Creates a new order, in the `DRAFT` state, by duplicating an existing order. The newly created order has
only the core fields (such as line items, taxes, and discounts) copied from the original order.

```java
CompletableFuture<CloneOrderResponse> cloneOrderAsync(
    final CloneOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CloneOrderRequest`](../../doc/models/clone-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CloneOrderResponse`](../../doc/models/clone-order-response.md)

## Example Usage

```java
CloneOrderRequest body = new CloneOrderRequest.Builder(
        "ZAISEM52YcpmcWAzERDOyiWS123")
    .version(3)
    .idempotencyKey("UNIQUE_STRING")
    .build();

ordersApi.cloneOrderAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Orders

Search all orders for one or more locations. Orders include all sales,
returns, and exchanges regardless of how or when they entered the Square
ecosystem (such as Point of Sale, Invoices, and Connect APIs).

`SearchOrders` requests need to specify which locations to search and define a
[SearchOrdersQuery](../../doc/models/search-orders-query.md) object that controls
how to sort or filter the results. Your `SearchOrdersQuery` can:

Set filter criteria.
Set the sort order.
Determine whether to return results as complete `Order` objects or as
[OrderEntry](../../doc/models/order-entry.md) objects.

Note that details for orders processed with Square Point of Sale while in
offline mode might not be transmitted to Square for up to 72 hours. Offline
orders have a `created_at` value that reflects the time the order was created,
not the time it was subsequently transmitted to Square.

```java
CompletableFuture<SearchOrdersResponse> searchOrdersAsync(
    final SearchOrdersRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchOrdersRequest`](../../doc/models/search-orders-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchOrdersResponse`](../../doc/models/search-orders-response.md)

## Example Usage

```java
List<String> bodyLocationIds = new LinkedList<>();
bodyLocationIds.add("057P5VYJ4A5X1");
bodyLocationIds.add("18YC4JDH91E1H");
List<String> bodyQueryFilterStateFilterStates = new LinkedList<>();
bodyQueryFilterStateFilterStates.add("COMPLETED");
SearchOrdersStateFilter searchOrdersStateFilter = new SearchOrdersStateFilter.Builder(
        searchOrdersStateFilterStates)
    .build();
TimeRange timeRange = new TimeRange.Builder()
    .startAt("start_at8")
    .endAt("end_at4")
    .build();
TimeRange timeRange = new TimeRange.Builder()
    .startAt("start_at6")
    .endAt("end_at6")
    .build();
TimeRange timeRange = new TimeRange.Builder()
    .startAt("2018-03-03T20:00:00+00:00")
    .endAt("2019-03-04T21:54:45+00:00")
    .build();
SearchOrdersDateTimeFilter searchOrdersDateTimeFilter = new SearchOrdersDateTimeFilter.Builder()
    .createdAt(searchOrdersDateTimeFilterCreatedAt)
    .updatedAt(searchOrdersDateTimeFilterUpdatedAt)
    .closedAt(searchOrdersDateTimeFilterClosedAt)
    .build();
List<String> bodyQueryFilterFulfillmentFilterFulfillmentTypes = new LinkedList<>();
bodyQueryFilterFulfillmentFilterFulfillmentTypes.add("SHIPMENT");
List<String> bodyQueryFilterFulfillmentFilterFulfillmentStates = new LinkedList<>();
bodyQueryFilterFulfillmentFilterFulfillmentStates.add("CANCELED");
bodyQueryFilterFulfillmentFilterFulfillmentStates.add("FAILED");
SearchOrdersFulfillmentFilter searchOrdersFulfillmentFilter = new SearchOrdersFulfillmentFilter.Builder()
    .fulfillmentTypes(searchOrdersFulfillmentFilterFulfillmentTypes)
    .fulfillmentStates(searchOrdersFulfillmentFilterFulfillmentStates)
    .build();
List<String> bodyQueryFilterSourceFilterSourceNames = new LinkedList<>();
bodyQueryFilterSourceFilterSourceNames.add("source_names8");
SearchOrdersSourceFilter searchOrdersSourceFilter = new SearchOrdersSourceFilter.Builder()
    .sourceNames(searchOrdersSourceFilterSourceNames)
    .build();
List<String> bodyQueryFilterCustomerFilterCustomerIds = new LinkedList<>();
bodyQueryFilterCustomerFilterCustomerIds.add("customer_ids5");
bodyQueryFilterCustomerFilterCustomerIds.add("customer_ids6");
SearchOrdersCustomerFilter searchOrdersCustomerFilter = new SearchOrdersCustomerFilter.Builder()
    .customerIds(searchOrdersCustomerFilterCustomerIds)
    .build();
SearchOrdersFilter searchOrdersFilter = new SearchOrdersFilter.Builder()
    .stateFilter(searchOrdersFilterStateFilter)
    .dateTimeFilter(searchOrdersFilterDateTimeFilter)
    .fulfillmentFilter(searchOrdersFilterFulfillmentFilter)
    .sourceFilter(searchOrdersFilterSourceFilter)
    .customerFilter(searchOrdersFilterCustomerFilter)
    .build();
SearchOrdersSort searchOrdersSort = new SearchOrdersSort.Builder(
        "CLOSED_AT")
    .sortOrder("DESC")
    .build();
SearchOrdersQuery searchOrdersQuery = new SearchOrdersQuery.Builder()
    .filter(searchOrdersQueryFilter)
    .sort(searchOrdersQuerySort)
    .build();
SearchOrdersRequest body = new SearchOrdersRequest.Builder()
    .locationIds(bodyLocationIds)
    .cursor("cursor0")
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


# Retrieve Order

Retrieves an [Order](../../doc/models/order.md) by ID.

```java
CompletableFuture<RetrieveOrderResponse> retrieveOrderAsync(
    final String orderId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the order to retrieve. |

## Response Type

[`RetrieveOrderResponse`](../../doc/models/retrieve-order-response.md)

## Example Usage

```java
String orderId = "order_id6";

ordersApi.retrieveOrderAsync(orderId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Order

Updates an open [order](../../doc/models/order.md) by adding, replacing, or deleting
fields. Orders with a `COMPLETED` or `CANCELED` state cannot be updated.

An `UpdateOrder` request requires the following:

- The `order_id` in the endpoint path, identifying the order to update.
- The latest `version` of the order to update.
- The [sparse order](../../https://developer.squareup.com/docs/orders-api/manage-orders#sparse-order-objects)
  containing only the fields to update and the version to which the update is
  being applied.
- If deleting fields, the [dot notation paths](../../https://developer.squareup.com/docs/orders-api/manage-orders#on-dot-notation)
  identifying the fields to clear.

To pay for an order, see
[Pay for Orders](../../https://developer.squareup.com/docs/orders-api/pay-for-orders).

```java
CompletableFuture<UpdateOrderResponse> updateOrderAsync(
    final String orderId,
    final UpdateOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the order to update. |
| `body` | [`UpdateOrderRequest`](../../doc/models/update-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateOrderResponse`](../../doc/models/update-order-response.md)

## Example Usage

```java
String orderId = "order_id6";
OrderSource orderSource = new OrderSource.Builder()
    .name("name6")
    .build();
List<OrderLineItem> bodyOrderLineItems = new LinkedList<>();

MeasurementUnitCustom measurementUnitCustom = new MeasurementUnitCustom.Builder(
        "name9",
        "abbreviation1")
    .build();
MeasurementUnit measurementUnit = new MeasurementUnit.Builder()
    .customUnit(measurementUnitCustomUnit)
    .areaUnit("IMPERIAL_SQUARE_INCH")
    .lengthUnit("METRIC_KILOMETER")
    .volumeUnit("GENERIC_QUART")
    .weightUnit("METRIC_MILLIGRAM")
    .build();
OrderQuantityUnit orderQuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(orderQuantityUnitMeasurementUnit)
    .precision(189)
    .catalogObjectId("catalog_object_id1")
    .catalogVersion(133L)
    .build();
OrderLineItem bodyOrderLineItems0 = new OrderLineItem.Builder(
        "quantity7")
    .uid("uid1")
    .name("name1")
    .quantityUnit(bodyOrderLineItems0QuantityUnit)
    .note("note3")
    .catalogObjectId("catalog_object_id5")
    .build();
bodyOrderLineItems.add(bodyOrderLineItems0);

MeasurementUnitCustom measurementUnitCustom = new MeasurementUnitCustom.Builder(
        "name8",
        "abbreviation0")
    .build();
MeasurementUnit measurementUnit = new MeasurementUnit.Builder()
    .customUnit(measurementUnitCustomUnit)
    .areaUnit("IMPERIAL_ACRE")
    .lengthUnit("IMPERIAL_INCH")
    .volumeUnit("GENERIC_PINT")
    .weightUnit("METRIC_GRAM")
    .build();
OrderQuantityUnit orderQuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(orderQuantityUnitMeasurementUnit)
    .precision(188)
    .catalogObjectId("catalog_object_id0")
    .catalogVersion(134L)
    .build();
OrderLineItem bodyOrderLineItems1 = new OrderLineItem.Builder(
        "quantity6")
    .uid("uid0")
    .name("name0")
    .quantityUnit(bodyOrderLineItems1QuantityUnit)
    .note("note4")
    .catalogObjectId("catalog_object_id6")
    .build();
bodyOrderLineItems.add(bodyOrderLineItems1);

Order order = new Order.Builder(
        "location_id4")
    .id("id0")
    .referenceId("reference_id8")
    .source(orderSource)
    .customerId("customer_id8")
    .lineItems(orderLineItems)
    .build();
List<String> bodyFieldsToClear = new LinkedList<>();
bodyFieldsToClear.add("fields_to_clear7");
bodyFieldsToClear.add("fields_to_clear8");
UpdateOrderRequest body = new UpdateOrderRequest.Builder()
    .order(bodyOrder)
    .fieldsToClear(bodyFieldsToClear)
    .idempotencyKey("idempotency_key2")
    .build();

ordersApi.updateOrderAsync(orderId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Pay Order

Pay for an [order](../../doc/models/order.md) using one or more approved [payments](../../doc/models/payment.md)
or settle an order with a total of `0`.

The total of the `payment_ids` listed in the request must be equal to the order
total. Orders with a total amount of `0` can be marked as paid by specifying an empty
array of `payment_ids` in the request.

To be used with `PayOrder`, a payment must:

- Reference the order by specifying the `order_id` when [creating the payment](../../doc/api/payments.md#create-payment).
  Any approved payments that reference the same `order_id` not specified in the
  `payment_ids` is canceled.
- Be approved with [delayed capture](../../https://developer.squareup.com/docs/payments-api/take-payments#delayed-capture).
  Using a delayed capture payment with `PayOrder` completes the approved payment.

```java
CompletableFuture<PayOrderResponse> payOrderAsync(
    final String orderId,
    final PayOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the order being paid. |
| `body` | [`PayOrderRequest`](../../doc/models/pay-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`PayOrderResponse`](../../doc/models/pay-order-response.md)

## Example Usage

```java
String orderId = "order_id6";
List<String> bodyPaymentIds = new LinkedList<>();
bodyPaymentIds.add("EnZdNAlWCmfh6Mt5FMNST1o7taB");
bodyPaymentIds.add("0LRiVlbXVwe8ozu4KbZxd12mvaB");
PayOrderRequest body = new PayOrderRequest.Builder(
        "c043a359-7ad9-4136-82a9-c3f1d66dcbff")
    .orderVersion(82)
    .paymentIds(bodyPaymentIds)
    .build();

ordersApi.payOrderAsync(orderId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


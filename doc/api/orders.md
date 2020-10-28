# Orders

```java
OrdersApi ordersApi = client.getOrdersApi();
```

## Class Name

`OrdersApi`

## Methods

* [Create Order](/doc/api/orders.md#create-order)
* [Batch Retrieve Orders](/doc/api/orders.md#batch-retrieve-orders)
* [Calculate Order](/doc/api/orders.md#calculate-order)
* [Search Orders](/doc/api/orders.md#search-orders)
* [Retrieve Order](/doc/api/orders.md#retrieve-order)
* [Update Order](/doc/api/orders.md#update-order)
* [Pay Order](/doc/api/orders.md#pay-order)


# Create Order

Creates a new [Order](#type-order) which can include information on products for
purchase and settings to apply to the purchase.

To pay for a created order, please refer to the [Pay for Orders](https://developer.squareup.com/docs/orders-api/pay-for-orders)
guide.

You can modify open orders using the [UpdateOrder](#endpoint-orders-updateorder) endpoint.

```java
CompletableFuture<CreateOrderResponse> createOrderAsync(
    final CreateOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateOrderRequest`](/doc/models/create-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateOrderResponse`](/doc/models/create-order-response.md)

## Example Usage

```java
OrderSource bodyOrderSource = new OrderSource.Builder()
    .name("name6")
    .build();
List<OrderLineItem> bodyOrderLineItems = new LinkedList<>();

MeasurementUnitCustom bodyOrderLineItems0QuantityUnitMeasurementUnitCustomUnit = new MeasurementUnitCustom.Builder(
        "name9",
        "abbreviation1")
    .build();
MeasurementUnit bodyOrderLineItems0QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .customUnit(bodyOrderLineItems0QuantityUnitMeasurementUnitCustomUnit)
    .areaUnit("IMPERIAL_SQUARE_INCH")
    .lengthUnit("METRIC_KILOMETER")
    .volumeUnit("GENERIC_QUART")
    .weightUnit("METRIC_MILLIGRAM")
    .build();
OrderQuantityUnit bodyOrderLineItems0QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderLineItems0QuantityUnitMeasurementUnit)
    .precision(189)
    .build();
Money bodyOrderLineItems0BasePriceMoney = new Money.Builder()
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

MeasurementUnitCustom bodyOrderLineItems1QuantityUnitMeasurementUnitCustomUnit = new MeasurementUnitCustom.Builder(
        "name8",
        "abbreviation0")
    .build();
MeasurementUnit bodyOrderLineItems1QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .customUnit(bodyOrderLineItems1QuantityUnitMeasurementUnitCustomUnit)
    .areaUnit("IMPERIAL_ACRE")
    .lengthUnit("IMPERIAL_INCH")
    .volumeUnit("GENERIC_PINT")
    .weightUnit("METRIC_GRAM")
    .build();
OrderQuantityUnit bodyOrderLineItems1QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderLineItems1QuantityUnitMeasurementUnit)
    .precision(188)
    .build();
List<OrderLineItemModifier> bodyOrderLineItems1Modifiers = new LinkedList<>();

Money bodyOrderLineItems1Modifiers0BasePriceMoney = new Money.Builder()
    .amount(53L)
    .currency("TTD")
    .build();
Money bodyOrderLineItems1Modifiers0TotalPriceMoney = new Money.Builder()
    .amount(51L)
    .currency("EUR")
    .build();
OrderLineItemModifier bodyOrderLineItems1Modifiers0 = new OrderLineItemModifier.Builder()
    .uid("uid1")
    .catalogObjectId("CHQX7Y4KY6N5KINJKZCFURPZ")
    .name("name1")
    .basePriceMoney(bodyOrderLineItems1Modifiers0BasePriceMoney)
    .totalPriceMoney(bodyOrderLineItems1Modifiers0TotalPriceMoney)
    .build();
bodyOrderLineItems1Modifiers.add(bodyOrderLineItems1Modifiers0);

List<OrderLineItemAppliedDiscount> bodyOrderLineItems1AppliedDiscounts = new LinkedList<>();

Money bodyOrderLineItems1AppliedDiscounts0AppliedMoney = new Money.Builder()
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
    .name("Labor Day Sale")
    .type("FIXED_PERCENTAGE")
    .percentage("5")
    .scope("ORDER")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts0);

OrderLineItemDiscount bodyOrderDiscounts1 = new OrderLineItemDiscount.Builder()
    .uid("membership-discount")
    .catalogObjectId("DB7L55ZH2BGWI4H23ULIWOQ7")
    .name("name2")
    .type("FIXED_AMOUNT")
    .percentage("percentage0")
    .scope("ORDER")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts1);

Money bodyOrderDiscounts2AmountMoney = new Money.Builder()
    .amount(100L)
    .currency("USD")
    .build();
OrderLineItemDiscount bodyOrderDiscounts2 = new OrderLineItemDiscount.Builder()
    .uid("one-dollar-off")
    .catalogObjectId("catalog_object_id7")
    .name("Sale - $1.00 off")
    .type("VARIABLE_PERCENTAGE")
    .percentage("percentage1")
    .amountMoney(bodyOrderDiscounts2AmountMoney)
    .scope("LINE_ITEM")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts2);

Order bodyOrder = new Order.Builder(
        "057P5VYJ4A5X1")
    .id("id0")
    .referenceId("my-order-001")
    .source(bodyOrderSource)
    .customerId("customer_id8")
    .lineItems(bodyOrderLineItems)
    .taxes(bodyOrderTaxes)
    .discounts(bodyOrderDiscounts)
    .build();
CreateOrderRequest body = new CreateOrderRequest.Builder()
    .order(bodyOrder)
    .locationId("location_id0")
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

Retrieves a set of [Order](#type-order)s by their IDs.

If a given Order ID does not exist, the ID is ignored instead of generating an error.

```java
CompletableFuture<BatchRetrieveOrdersResponse> batchRetrieveOrdersAsync(
    final BatchRetrieveOrdersRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveOrdersRequest`](/doc/models/batch-retrieve-orders-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchRetrieveOrdersResponse`](/doc/models/batch-retrieve-orders-response.md)

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

Calculates an [Order](#type-order).

```java
CompletableFuture<CalculateOrderResponse> calculateOrderAsync(
    final CalculateOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CalculateOrderRequest`](/doc/models/calculate-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CalculateOrderResponse`](/doc/models/calculate-order-response.md)

## Example Usage

```java
OrderSource bodyOrderSource = new OrderSource.Builder()
    .name("name6")
    .build();
List<OrderLineItem> bodyOrderLineItems = new LinkedList<>();

MeasurementUnitCustom bodyOrderLineItems0QuantityUnitMeasurementUnitCustomUnit = new MeasurementUnitCustom.Builder(
        "name9",
        "abbreviation1")
    .build();
MeasurementUnit bodyOrderLineItems0QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .customUnit(bodyOrderLineItems0QuantityUnitMeasurementUnitCustomUnit)
    .areaUnit("IMPERIAL_SQUARE_INCH")
    .lengthUnit("METRIC_KILOMETER")
    .volumeUnit("GENERIC_QUART")
    .weightUnit("METRIC_MILLIGRAM")
    .build();
OrderQuantityUnit bodyOrderLineItems0QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderLineItems0QuantityUnitMeasurementUnit)
    .precision(189)
    .build();
Money bodyOrderLineItems0BasePriceMoney = new Money.Builder()
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

MeasurementUnitCustom bodyOrderLineItems1QuantityUnitMeasurementUnitCustomUnit = new MeasurementUnitCustom.Builder(
        "name8",
        "abbreviation0")
    .build();
MeasurementUnit bodyOrderLineItems1QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .customUnit(bodyOrderLineItems1QuantityUnitMeasurementUnitCustomUnit)
    .areaUnit("IMPERIAL_ACRE")
    .lengthUnit("IMPERIAL_INCH")
    .volumeUnit("GENERIC_PINT")
    .weightUnit("METRIC_GRAM")
    .build();
OrderQuantityUnit bodyOrderLineItems1QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderLineItems1QuantityUnitMeasurementUnit)
    .precision(188)
    .build();
Money bodyOrderLineItems1BasePriceMoney = new Money.Builder()
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
    .name("50% Off")
    .type("FIXED_PERCENTAGE")
    .percentage("50")
    .scope("ORDER")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts0);

Order bodyOrder = new Order.Builder(
        "D7AVYMEAPJ3A3")
    .id("id0")
    .referenceId("reference_id8")
    .source(bodyOrderSource)
    .customerId("customer_id8")
    .lineItems(bodyOrderLineItems)
    .discounts(bodyOrderDiscounts)
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
        bodyOrder)
    .proposedRewards(bodyProposedRewards)
    .build();

ordersApi.calculateOrderAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Orders

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

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchOrdersRequest`](/doc/models/search-orders-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchOrdersResponse`](/doc/models/search-orders-response.md)

## Example Usage

```java
List<String> bodyLocationIds = new LinkedList<>();
bodyLocationIds.add("057P5VYJ4A5X1");
bodyLocationIds.add("18YC4JDH91E1H");
List<String> bodyQueryFilterStateFilterStates = new LinkedList<>();
bodyQueryFilterStateFilterStates.add("COMPLETED");
SearchOrdersStateFilter bodyQueryFilterStateFilter = new SearchOrdersStateFilter.Builder(
        bodyQueryFilterStateFilterStates)
    .build();
TimeRange bodyQueryFilterDateTimeFilterCreatedAt = new TimeRange.Builder()
    .startAt("start_at8")
    .endAt("end_at4")
    .build();
TimeRange bodyQueryFilterDateTimeFilterUpdatedAt = new TimeRange.Builder()
    .startAt("start_at6")
    .endAt("end_at6")
    .build();
TimeRange bodyQueryFilterDateTimeFilterClosedAt = new TimeRange.Builder()
    .startAt("2018-03-03T20:00:00+00:00")
    .endAt("2019-03-04T21:54:45+00:00")
    .build();
SearchOrdersDateTimeFilter bodyQueryFilterDateTimeFilter = new SearchOrdersDateTimeFilter.Builder()
    .createdAt(bodyQueryFilterDateTimeFilterCreatedAt)
    .updatedAt(bodyQueryFilterDateTimeFilterUpdatedAt)
    .closedAt(bodyQueryFilterDateTimeFilterClosedAt)
    .build();
List<String> bodyQueryFilterFulfillmentFilterFulfillmentTypes = new LinkedList<>();
bodyQueryFilterFulfillmentFilterFulfillmentTypes.add("SHIPMENT");
List<String> bodyQueryFilterFulfillmentFilterFulfillmentStates = new LinkedList<>();
bodyQueryFilterFulfillmentFilterFulfillmentStates.add("CANCELED");
bodyQueryFilterFulfillmentFilterFulfillmentStates.add("FAILED");
SearchOrdersFulfillmentFilter bodyQueryFilterFulfillmentFilter = new SearchOrdersFulfillmentFilter.Builder()
    .fulfillmentTypes(bodyQueryFilterFulfillmentFilterFulfillmentTypes)
    .fulfillmentStates(bodyQueryFilterFulfillmentFilterFulfillmentStates)
    .build();
List<String> bodyQueryFilterSourceFilterSourceNames = new LinkedList<>();
bodyQueryFilterSourceFilterSourceNames.add("source_names8");
SearchOrdersSourceFilter bodyQueryFilterSourceFilter = new SearchOrdersSourceFilter.Builder()
    .sourceNames(bodyQueryFilterSourceFilterSourceNames)
    .build();
List<String> bodyQueryFilterCustomerFilterCustomerIds = new LinkedList<>();
bodyQueryFilterCustomerFilterCustomerIds.add("customer_ids5");
bodyQueryFilterCustomerFilterCustomerIds.add("customer_ids6");
SearchOrdersCustomerFilter bodyQueryFilterCustomerFilter = new SearchOrdersCustomerFilter.Builder()
    .customerIds(bodyQueryFilterCustomerFilterCustomerIds)
    .build();
SearchOrdersFilter bodyQueryFilter = new SearchOrdersFilter.Builder()
    .stateFilter(bodyQueryFilterStateFilter)
    .dateTimeFilter(bodyQueryFilterDateTimeFilter)
    .fulfillmentFilter(bodyQueryFilterFulfillmentFilter)
    .sourceFilter(bodyQueryFilterSourceFilter)
    .customerFilter(bodyQueryFilterCustomerFilter)
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

Retrieves an [Order](#type-order) by ID.

```java
CompletableFuture<RetrieveOrderResponse> retrieveOrderAsync(
    final String orderId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the order to retrieve. |

## Response Type

[`RetrieveOrderResponse`](/doc/models/retrieve-order-response.md)

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

```java
CompletableFuture<UpdateOrderResponse> updateOrderAsync(
    final String orderId,
    final UpdateOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the order to update. |
| `body` | [`UpdateOrderRequest`](/doc/models/update-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateOrderResponse`](/doc/models/update-order-response.md)

## Example Usage

```java
String orderId = "order_id6";
OrderSource bodyOrderSource = new OrderSource.Builder()
    .name("name6")
    .build();
List<OrderLineItem> bodyOrderLineItems = new LinkedList<>();

MeasurementUnitCustom bodyOrderLineItems0QuantityUnitMeasurementUnitCustomUnit = new MeasurementUnitCustom.Builder(
        "name9",
        "abbreviation1")
    .build();
MeasurementUnit bodyOrderLineItems0QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .customUnit(bodyOrderLineItems0QuantityUnitMeasurementUnitCustomUnit)
    .areaUnit("IMPERIAL_SQUARE_INCH")
    .lengthUnit("METRIC_KILOMETER")
    .volumeUnit("GENERIC_QUART")
    .weightUnit("METRIC_MILLIGRAM")
    .build();
OrderQuantityUnit bodyOrderLineItems0QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderLineItems0QuantityUnitMeasurementUnit)
    .precision(189)
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

MeasurementUnitCustom bodyOrderLineItems1QuantityUnitMeasurementUnitCustomUnit = new MeasurementUnitCustom.Builder(
        "name8",
        "abbreviation0")
    .build();
MeasurementUnit bodyOrderLineItems1QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .customUnit(bodyOrderLineItems1QuantityUnitMeasurementUnitCustomUnit)
    .areaUnit("IMPERIAL_ACRE")
    .lengthUnit("IMPERIAL_INCH")
    .volumeUnit("GENERIC_PINT")
    .weightUnit("METRIC_GRAM")
    .build();
OrderQuantityUnit bodyOrderLineItems1QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderLineItems1QuantityUnitMeasurementUnit)
    .precision(188)
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

Order bodyOrder = new Order.Builder(
        "location_id4")
    .id("id0")
    .referenceId("reference_id8")
    .source(bodyOrderSource)
    .customerId("customer_id8")
    .lineItems(bodyOrderLineItems)
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

```java
CompletableFuture<PayOrderResponse> payOrderAsync(
    final String orderId,
    final PayOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the order being paid. |
| `body` | [`PayOrderRequest`](/doc/models/pay-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`PayOrderResponse`](/doc/models/pay-order-response.md)

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


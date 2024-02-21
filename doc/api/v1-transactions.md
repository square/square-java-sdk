# V1 Transactions

```java
V1TransactionsApi v1TransactionsApi = client.getV1TransactionsApi();
```

## Class Name

`V1TransactionsApi`

## Methods

* [V1 List Orders](../../doc/api/v1-transactions.md#v1-list-orders)
* [V1 Retrieve Order](../../doc/api/v1-transactions.md#v1-retrieve-order)
* [V1 Update Order](../../doc/api/v1-transactions.md#v1-update-order)


# V1 List Orders

**This endpoint is deprecated.**

Provides summary information for a merchant's online store orders.

```java
CompletableFuture<List<V1Order>> v1ListOrdersAsync(
    final String locationId,
    final String order,
    final Integer limit,
    final String batchToken)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list online store orders for. |
| `order` | [`String`](../../doc/models/sort-order.md) | Query, Optional | The order in which payments are listed in the response. |
| `limit` | `Integer` | Query, Optional | The maximum number of payments to return in a single response. This value cannot exceed 200. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

## Response Type

[`List<V1Order>`](../../doc/models/v1-order.md)

## Example Usage

```java
String locationId = "location_id4";

v1TransactionsApi.v1ListOrdersAsync(locationId, null, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# V1 Retrieve Order

**This endpoint is deprecated.**

Provides comprehensive information for a single online store order, including the order's history.

```java
CompletableFuture<V1Order> v1RetrieveOrderAsync(
    final String locationId,
    final String orderId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the order's associated location. |
| `orderId` | `String` | Template, Required | The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint |

## Response Type

[`V1Order`](../../doc/models/v1-order.md)

## Example Usage

```java
String locationId = "location_id4";
String orderId = "order_id6";

v1TransactionsApi.v1RetrieveOrderAsync(locationId, orderId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# V1 Update Order

**This endpoint is deprecated.**

Updates the details of an online store order. Every update you perform on an order corresponds to one of three actions:

```java
CompletableFuture<V1Order> v1UpdateOrderAsync(
    final String locationId,
    final String orderId,
    final V1UpdateOrderRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the order's associated location. |
| `orderId` | `String` | Template, Required | The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint |
| `body` | [`V1UpdateOrderRequest`](../../doc/models/v1-update-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`V1Order`](../../doc/models/v1-order.md)

## Example Usage

```java
String locationId = "location_id4";
String orderId = "order_id6";
V1UpdateOrderRequest body = new V1UpdateOrderRequest.Builder(
    "REFUND"
)
.build();

v1TransactionsApi.v1UpdateOrderAsync(locationId, orderId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


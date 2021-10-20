# Transactions

```java
TransactionsApi transactionsApi = client.getTransactionsApi();
```

## Class Name

`TransactionsApi`

## Methods

* [List Transactions](/doc/api/transactions.md#list-transactions)
* [Retrieve Transaction](/doc/api/transactions.md#retrieve-transaction)
* [Capture Transaction](/doc/api/transactions.md#capture-transaction)
* [Void Transaction](/doc/api/transactions.md#void-transaction)


# List Transactions

**This endpoint is deprecated.**

Lists transactions for a particular location.

Transactions include payment information from sales and exchanges and refund
information from returns and exchanges.

Max results per [page](https://developer.squareup.com/docs/working-with-apis/pagination): 50

```java
CompletableFuture<ListTransactionsResponse> listTransactionsAsync(
    final String locationId,
    final String beginTime,
    final String endTime,
    final String sortOrder,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list transactions for. |
| `beginTime` | `String` | Query, Optional | The beginning of the requested reporting period, in RFC 3339 format.<br><br>See [Date ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for details on date inclusivity/exclusivity.<br><br>Default value: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The end of the requested reporting period, in RFC 3339 format.<br><br>See [Date ranges](https://developer.squareup.com/docs/build-basics/working-with-dates) for details on date inclusivity/exclusivity.<br><br>Default value: The current time. |
| `sortOrder` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which results are listed in the response (`ASC` for<br>oldest first, `DESC` for newest first).<br><br>Default value: `DESC` |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br><br>See [Paginating results](https://developer.squareup.com/docs/working-with-apis/pagination) for more information. |

## Response Type

[`ListTransactionsResponse`](/doc/models/list-transactions-response.md)

## Example Usage

```java
String locationId = "location_id4";
String beginTime = "begin_time2";
String endTime = "end_time2";
String sortOrder = "DESC";
String cursor = "cursor6";

transactionsApi.listTransactionsAsync(locationId, beginTime, endTime, sortOrder, cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Transaction

**This endpoint is deprecated.**

Retrieves details for a single transaction.

```java
CompletableFuture<RetrieveTransactionResponse> retrieveTransactionAsync(
    final String locationId,
    final String transactionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the transaction's associated location. |
| `transactionId` | `String` | Template, Required | The ID of the transaction to retrieve. |

## Response Type

[`RetrieveTransactionResponse`](/doc/models/retrieve-transaction-response.md)

## Example Usage

```java
String locationId = "location_id4";
String transactionId = "transaction_id8";

transactionsApi.retrieveTransactionAsync(locationId, transactionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Capture Transaction

**This endpoint is deprecated.**

Captures a transaction that was created with the [Charge]($e/Transactions/Charge)
endpoint with a `delay_capture` value of `true`.

See [Delayed capture transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
for more information.

```java
CompletableFuture<CaptureTransactionResponse> captureTransactionAsync(
    final String locationId,
    final String transactionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | - |
| `transactionId` | `String` | Template, Required | - |

## Response Type

[`CaptureTransactionResponse`](/doc/models/capture-transaction-response.md)

## Example Usage

```java
String locationId = "location_id4";
String transactionId = "transaction_id8";

transactionsApi.captureTransactionAsync(locationId, transactionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Void Transaction

**This endpoint is deprecated.**

Cancels a transaction that was created with the [Charge]($e/Transactions/Charge)
endpoint with a `delay_capture` value of `true`.

See [Delayed capture transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
for more information.

```java
CompletableFuture<VoidTransactionResponse> voidTransactionAsync(
    final String locationId,
    final String transactionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | - |
| `transactionId` | `String` | Template, Required | - |

## Response Type

[`VoidTransactionResponse`](/doc/models/void-transaction-response.md)

## Example Usage

```java
String locationId = "location_id4";
String transactionId = "transaction_id8";

transactionsApi.voidTransactionAsync(locationId, transactionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# V1 Transactions

```java
V1TransactionsApi v1TransactionsApi = client.getV1TransactionsApi();
```

## Class Name

`V1TransactionsApi`

## Methods

* [List Bank Accounts](/doc/v1-transactions.md#list-bank-accounts)
* [Retrieve Bank Account](/doc/v1-transactions.md#retrieve-bank-account)
* [List Orders](/doc/v1-transactions.md#list-orders)
* [Retrieve Order](/doc/v1-transactions.md#retrieve-order)
* [Update Order](/doc/v1-transactions.md#update-order)
* [List Payments](/doc/v1-transactions.md#list-payments)
* [Retrieve Payment](/doc/v1-transactions.md#retrieve-payment)
* [List Refunds](/doc/v1-transactions.md#list-refunds)
* [Create Refund](/doc/v1-transactions.md#create-refund)
* [List Settlements](/doc/v1-transactions.md#list-settlements)
* [Retrieve Settlement](/doc/v1-transactions.md#retrieve-settlement)

## List Bank Accounts

Provides non-confidential details for all of a location's associated bank accounts. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.

```java
CompletableFuture<List<V1BankAccount>> listBankAccountsAsync(
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list bank accounts for. |

### Response Type

[`List<V1BankAccount>`](/doc/models/v1-bank-account.md)

### Example Usage

```java
String locationId = "location_id4";

v1TransactionsApi.listBankAccountsAsync(locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Bank Account

Provides non-confidential details for a merchant's associated bank account. This endpoint does not provide full bank account numbers, and there is no way to obtain a full bank account number with the Connect API.

```java
CompletableFuture<V1BankAccount> retrieveBankAccountAsync(
    final String locationId,
    final String bankAccountId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the bank account's associated location. |
| `bankAccountId` | `String` | Template, Required | The bank account's Square-issued ID. You obtain this value from Settlement objects returned. |

### Response Type

[`V1BankAccount`](/doc/models/v1-bank-account.md)

### Example Usage

```java
String locationId = "location_id4";
String bankAccountId = "bank_account_id0";

v1TransactionsApi.retrieveBankAccountAsync(locationId, bankAccountId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Orders

Provides summary information for a merchant's online store orders.

```java
CompletableFuture<List<V1Order>> listOrdersAsync(
    final String locationId,
    final String order,
    final Integer limit,
    final String batchToken)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list online store orders for. |
| `order` | [`String`](/doc/models/sort-order.md) | Query, Optional | TThe order in which payments are listed in the response. |
| `limit` | `Integer` | Query, Optional | The maximum number of payments to return in a single response. This value cannot exceed 200. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

### Response Type

[`List<V1Order>`](/doc/models/v1-order.md)

### Example Usage

```java
String locationId = "location_id4";
String order = "DESC";
Integer limit = 172;
String batchToken = "batch_token2";

v1TransactionsApi.listOrdersAsync(locationId, order, limit, batchToken).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Order

Provides comprehensive information for a single online store order, including the order's history.

```java
CompletableFuture<V1Order> retrieveOrderAsync(
    final String locationId,
    final String orderId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the order's associated location. |
| `orderId` | `String` | Template, Required | The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint |

### Response Type

[`V1Order`](/doc/models/v1-order.md)

### Example Usage

```java
String locationId = "location_id4";
String orderId = "order_id6";

v1TransactionsApi.retrieveOrderAsync(locationId, orderId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Order

Updates the details of an online store order. Every update you perform on an order corresponds to one of three actions:

```java
CompletableFuture<V1Order> updateOrderAsync(
    final String locationId,
    final String orderId,
    final V1UpdateOrderRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the order's associated location. |
| `orderId` | `String` | Template, Required | The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint |
| `body` | [`V1UpdateOrderRequest`](/doc/models/v1-update-order-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Order`](/doc/models/v1-order.md)

### Example Usage

```java
String locationId = "location_id4";
String orderId = "order_id6";
V1UpdateOrderRequest body = new V1UpdateOrderRequest.Builder(
        "REFUND")
    .shippedTrackingNumber("shipped_tracking_number6")
    .completedNote("completed_note6")
    .refundedNote("refunded_note0")
    .canceledNote("canceled_note4")
    .build();

v1TransactionsApi.updateOrderAsync(locationId, orderId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Payments

Provides summary information for all payments taken for a given
Square account during a date range. Date ranges cannot exceed 1 year in
length. See Date ranges for details of inclusive and exclusive dates.

*Note**: Details for payments processed with Square Point of Sale while
in offline mode may not be transmitted to Square for up to 72 hours.
Offline payments have a `created_at` value that reflects the time the
payment was originally processed, not the time it was subsequently
transmitted to Square. Consequently, the ListPayments endpoint might
list an offline payment chronologically between online payments that
were seen in a previous request.

```java
CompletableFuture<List<V1Payment>> listPaymentsAsync(
    final String locationId,
    final String order,
    final String beginTime,
    final String endTime,
    final Integer limit,
    final String batchToken,
    final Boolean includePartial)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list payments for. If you specify me, this endpoint returns payments aggregated from all of the business's locations. |
| `order` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which payments are listed in the response. |
| `beginTime` | `String` | Query, Optional | The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time. |
| `limit` | `Integer` | Query, Optional | The maximum number of payments to return in a single response. This value cannot exceed 200. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |
| `includePartial` | `Boolean` | Query, Optional | Indicates whether or not to include partial payments in the response. Partial payments will have the tenders collected so far, but the itemizations will be empty until the payment is completed. |

### Response Type

[`List<V1Payment>`](/doc/models/v1-payment.md)

### Example Usage

```java
String locationId = "location_id4";
String order = "DESC";
String beginTime = "begin_time2";
String endTime = "end_time2";
Integer limit = 172;
String batchToken = "batch_token2";
Boolean includePartial = false;

v1TransactionsApi.listPaymentsAsync(locationId, order, beginTime, endTime, limit, batchToken, includePartial).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Payment

Provides comprehensive information for a single payment.

```java
CompletableFuture<V1Payment> retrievePaymentAsync(
    final String locationId,
    final String paymentId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the payment's associated location. |
| `paymentId` | `String` | Template, Required | The Square-issued payment ID. payment_id comes from Payment objects returned by the List Payments endpoint, Settlement objects returned by the List Settlements endpoint, or Refund objects returned by the List Refunds endpoint. |

### Response Type

[`V1Payment`](/doc/models/v1-payment.md)

### Example Usage

```java
String locationId = "location_id4";
String paymentId = "payment_id0";

v1TransactionsApi.retrievePaymentAsync(locationId, paymentId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Refunds

Provides the details for all refunds initiated by a merchant or any of the merchant's mobile staff during a date range. Date ranges cannot exceed one year in length.

```java
CompletableFuture<List<V1Refund>> listRefundsAsync(
    final String locationId,
    final String order,
    final String beginTime,
    final String endTime,
    final Integer limit,
    final String batchToken)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list refunds for. |
| `order` | [`String`](/doc/models/sort-order.md) | Query, Optional | TThe order in which payments are listed in the response. |
| `beginTime` | `String` | Query, Optional | The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time. |
| `limit` | `Integer` | Query, Optional | The approximate number of refunds to return in a single response. Default: 100. Max: 200. Response may contain more results than the prescribed limit when refunds are made simultaneously to multiple tenders in a payment or when refunds are generated in an exchange to account for the value of returned goods. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

### Response Type

[`List<V1Refund>`](/doc/models/v1-refund.md)

### Example Usage

```java
String locationId = "location_id4";
String order = "DESC";
String beginTime = "begin_time2";
String endTime = "end_time2";
Integer limit = 172;
String batchToken = "batch_token2";

v1TransactionsApi.listRefundsAsync(locationId, order, beginTime, endTime, limit, batchToken).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Refund

Issues a refund for a previously processed payment. You must issue
a refund within 60 days of the associated payment.

You cannot issue a partial refund for a split tender payment. You must
instead issue a full or partial refund for a particular tender, by
providing the applicable tender id to the V1CreateRefund endpoint.
Issuing a full refund for a split tender payment refunds all tenders
associated with the payment.

Issuing a refund for a card payment is not reversible. For development
purposes, you can create fake cash payments in Square Point of Sale and
refund them.

```java
CompletableFuture<V1Refund> createRefundAsync(
    final String locationId,
    final V1CreateRefundRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the original payment's associated location. |
| `body` | [`V1CreateRefundRequest`](/doc/models/v1-create-refund-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`V1Refund`](/doc/models/v1-refund.md)

### Example Usage

```java
String locationId = "location_id4";
V1Money bodyRefundedMoney = new V1Money.Builder()
    .amount(222)
    .currencyCode("CLF")
    .build();
V1CreateRefundRequest body = new V1CreateRefundRequest.Builder(
        "payment_id6",
        "FULL",
        "reason8")
    .refundedMoney(bodyRefundedMoney)
    .requestIdempotenceKey("request_idempotence_key2")
    .build();

v1TransactionsApi.createRefundAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Settlements

Provides summary information for all deposits and withdrawals
initiated by Square to a linked bank account during a date range. Date
ranges cannot exceed one year in length.

*Note**: the ListSettlements endpoint does not provide entry
information.

```java
CompletableFuture<List<V1Settlement>> listSettlementsAsync(
    final String locationId,
    final String order,
    final String beginTime,
    final String endTime,
    final Integer limit,
    final String status,
    final String batchToken)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list settlements for. If you specify me, this endpoint returns settlements aggregated from all of the business's locations. |
| `order` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which settlements are listed in the response. |
| `beginTime` | `String` | Query, Optional | The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time. |
| `limit` | `Integer` | Query, Optional | The maximum number of settlements to return in a single response. This value cannot exceed 200. |
| `status` | [`String`](/doc/models/v1-list-settlements-request-status.md) | Query, Optional | Provide this parameter to retrieve only settlements with a particular status (SENT or FAILED). |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

### Response Type

[`List<V1Settlement>`](/doc/models/v1-settlement.md)

### Example Usage

```java
String locationId = "location_id4";
String order = "DESC";
String beginTime = "begin_time2";
String endTime = "end_time2";
Integer limit = 172;
String status = "SENT";
String batchToken = "batch_token2";

v1TransactionsApi.listSettlementsAsync(locationId, order, beginTime, endTime, limit, status, batchToken).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Settlement

Provides comprehensive information for a single settlement.

The returned `Settlement` objects include an `entries` field that lists
the transactions that contribute to the settlement total. Most
settlement entries correspond to a payment payout, but settlement
entries are also generated for less common events, like refunds, manual
adjustments, or chargeback holds.

Square initiates its regular deposits as indicated in the
[Deposit Options with Square](https://squareup.com/help/us/en/article/3807)
help article. Details for a regular deposit are usually not available
from Connect API endpoints before 10 p.m. PST the same day.

Square does not know when an initiated settlement **completes**, only
whether it has failed. A completed settlement is typically reflected in
a bank account within 3 business days, but in exceptional cases it may
take longer.

```java
CompletableFuture<V1Settlement> retrieveSettlementAsync(
    final String locationId,
    final String settlementId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the settlements's associated location. |
| `settlementId` | `String` | Template, Required | The settlement's Square-issued ID. You obtain this value from Settlement objects returned by the List Settlements endpoint. |

### Response Type

[`V1Settlement`](/doc/models/v1-settlement.md)

### Example Usage

```java
String locationId = "location_id4";
String settlementId = "settlement_id0";

v1TransactionsApi.retrieveSettlementAsync(locationId, settlementId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


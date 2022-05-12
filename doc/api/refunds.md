# Refunds

```java
RefundsApi refundsApi = client.getRefundsApi();
```

## Class Name

`RefundsApi`

## Methods

* [List Payment Refunds](../../doc/api/refunds.md#list-payment-refunds)
* [Refund Payment](../../doc/api/refunds.md#refund-payment)
* [Get Payment Refund](../../doc/api/refunds.md#get-payment-refund)


# List Payment Refunds

Retrieves a list of refunds for the account making the request.

Results are eventually consistent, and new refunds or changes to refunds might take several
seconds to appear.

The maximum results per page is 100.

```java
CompletableFuture<ListPaymentRefundsResponse> listPaymentRefundsAsync(
    final String beginTime,
    final String endTime,
    final String sortOrder,
    final String cursor,
    final String locationId,
    final String status,
    final String sourceType,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `beginTime` | `String` | Query, Optional | The timestamp for the beginning of the requested reporting period, in RFC 3339 format.<br><br>Default: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The timestamp for the end of the requested reporting period, in RFC 3339 format.<br><br>Default: The current time. |
| `sortOrder` | `String` | Query, Optional | The order in which results are listed:<br><br>- `ASC` - Oldest to newest.<br>- `DESC` - Newest to oldest (default). |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). |
| `locationId` | `String` | Query, Optional | Limit results to the location supplied. By default, results are returned<br>for all locations associated with the seller. |
| `status` | `String` | Query, Optional | If provided, only refunds with the given status are returned.<br>For a list of refund status values, see [PaymentRefund](../../doc/models/payment-refund.md).<br><br>Default: If omitted, refunds are returned regardless of their status. |
| `sourceType` | `String` | Query, Optional | If provided, only returns refunds whose payments have the indicated source type.<br>Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`, `CASH`, and `EXTERNAL`.<br>For information about these payment source types, see<br>[Take Payments](https://developer.squareup.com/docs/payments-api/take-payments).<br><br>Default: If omitted, refunds are returned regardless of the source type. |
| `limit` | `Integer` | Query, Optional | The maximum number of results to be returned in a single page.<br><br>It is possible to receive fewer results than the specified limit on a given page.<br><br>If the supplied value is greater than 100, no more than 100 results are returned.<br><br>Default: 100 |

## Response Type

[`ListPaymentRefundsResponse`](../../doc/models/list-payment-refunds-response.md)

## Example Usage

```java
refundsApi.listPaymentRefundsAsync(null, null, null, null, null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Refund Payment

Refunds a payment. You can refund the entire payment amount or a
portion of it. You can use this endpoint to refund a card payment or record a
refund of a cash or external payment. For more information, see
[Refund Payment](https://developer.squareup.com/docs/payments-api/refund-payments).

```java
CompletableFuture<RefundPaymentResponse> refundPaymentAsync(
    final RefundPaymentRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`RefundPaymentRequest`](../../doc/models/refund-payment-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`RefundPaymentResponse`](../../doc/models/refund-payment-response.md)

## Example Usage

```java
Money money = new Money.Builder()
    .amount(1000L)
    .currency("USD")
    .build();
Money money = new Money.Builder()
    .amount(10L)
    .currency("USD")
    .build();
RefundPaymentRequest body = new RefundPaymentRequest.Builder(
        "9b7f2dcf-49da-4411-b23e-a2d6af21333a",
        amountMoney)
    .appFeeMoney(bodyAppFeeMoney)
    .paymentId("R2B3Z8WMVt3EAmzYWLZvz7Y69EbZY")
    .reason("Example")
    .build();

refundsApi.refundPaymentAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Payment Refund

Retrieves a specific refund using the `refund_id`.

```java
CompletableFuture<GetPaymentRefundResponse> getPaymentRefundAsync(
    final String refundId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `refundId` | `String` | Template, Required | The unique ID for the desired `PaymentRefund`. |

## Response Type

[`GetPaymentRefundResponse`](../../doc/models/get-payment-refund-response.md)

## Example Usage

```java
String refundId = "refund_id4";

refundsApi.getPaymentRefundAsync(refundId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


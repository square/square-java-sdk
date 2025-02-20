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
    final Integer limit,
    final String updatedAtBeginTime,
    final String updatedAtEndTime,
    final String sortField)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `beginTime` | `String` | Query, Optional | Indicates the start of the time range to retrieve each `PaymentRefund` for, in RFC 3339<br>format.  The range is determined using the `created_at` field for each `PaymentRefund`.<br><br>Default: The current time minus one year. |
| `endTime` | `String` | Query, Optional | Indicates the end of the time range to retrieve each `PaymentRefund` for, in RFC 3339<br>format.  The range is determined using the `created_at` field for each `PaymentRefund`.<br><br>Default: The current time. |
| `sortOrder` | `String` | Query, Optional | The order in which results are listed by `PaymentRefund.created_at`:<br><br>- `ASC` - Oldest to newest.<br>- `DESC` - Newest to oldest (default). |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `locationId` | `String` | Query, Optional | Limit results to the location supplied. By default, results are returned<br>for all locations associated with the seller. |
| `status` | `String` | Query, Optional | If provided, only refunds with the given status are returned.<br>For a list of refund status values, see [PaymentRefund](entity:PaymentRefund).<br><br>Default: If omitted, refunds are returned regardless of their status. |
| `sourceType` | `String` | Query, Optional | If provided, only returns refunds whose payments have the indicated source type.<br>Current values include `CARD`, `BANK_ACCOUNT`, `WALLET`, `CASH`, and `EXTERNAL`.<br>For information about these payment source types, see<br>[Take Payments](https://developer.squareup.com/docs/payments-api/take-payments).<br><br>Default: If omitted, refunds are returned regardless of the source type. |
| `limit` | `Integer` | Query, Optional | The maximum number of results to be returned in a single page.<br><br>It is possible to receive fewer results than the specified limit on a given page.<br><br>If the supplied value is greater than 100, no more than 100 results are returned.<br><br>Default: 100 |
| `updatedAtBeginTime` | `string` | Query, Optional | Indicates the start of the time range to retrieve each `PaymentRefund` for, in RFC 3339<br>format.  The range is determined using the `updated_at` field for each `PaymentRefund`.<br><br>Default: if omitted, the time range starts at `beginTime`. |
| `updatedAtEndTime` | `string` | Query, Optional | Indicates the end of the time range to retrieve each `PaymentRefund` for, in RFC 3339<br>format.  The range is determined using the `updated_at` field for each `PaymentRefund`.<br><br>Default: The current time. |
| `sortField` | `string` | Query, Optional | The field used to sort results by. The default is `CREATED_AT`.<br>Current values include `CREATED_AT` and `UPDATED_AT`.<br> |

## Response Type

[`ListPaymentRefundsResponse`](../../doc/models/list-payment-refunds-response.md)

## Example Usage

```java
refundsApi.listPaymentRefundsAsync(null, null, null, null, null, null, null, null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
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
RefundPaymentRequest body = new RefundPaymentRequest.Builder(
    "9b7f2dcf-49da-4411-b23e-a2d6af21333a",
    new Money.Builder()
        .amount(1000L)
        .currency("USD")
        .build()
)
.appFeeMoney(new Money.Builder()
        .amount(10L)
        .currency("USD")
        .build())
.paymentId("R2B3Z8WMVt3EAmzYWLZvz7Y69EbZY")
.reason("Example")
.build();

refundsApi.refundPaymentAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
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
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


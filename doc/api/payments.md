# Payments

```java
PaymentsApi paymentsApi = client.getPaymentsApi();
```

## Class Name

`PaymentsApi`

## Methods

* [List Payments](/doc/api/payments.md#list-payments)
* [Create Payment](/doc/api/payments.md#create-payment)
* [Cancel Payment by Idempotency Key](/doc/api/payments.md#cancel-payment-by-idempotency-key)
* [Get Payment](/doc/api/payments.md#get-payment)
* [Cancel Payment](/doc/api/payments.md#cancel-payment)
* [Complete Payment](/doc/api/payments.md#complete-payment)


# List Payments

Retrieves a list of payments taken by the account making the request.

The maximum results per page is 100.

```java
CompletableFuture<ListPaymentsResponse> listPaymentsAsync(
    final String beginTime,
    final String endTime,
    final String sortOrder,
    final String cursor,
    final String locationId,
    final Long total,
    final String last4,
    final String cardBrand,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `beginTime` | `String` | Query, Optional | The timestamp for the beginning of the reporting period, in RFC 3339 format.<br>Inclusive. Default: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The timestamp for the end of the reporting period, in RFC 3339 format.<br><br>Default: The current time. |
| `sortOrder` | `String` | Query, Optional | The order in which results are listed:<br><br>- `ASC` - Oldest to newest.<br>- `DESC` - Newest to oldest (default). |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). |
| `locationId` | `String` | Query, Optional | Limit results to the location supplied. By default, results are returned<br>for the default (main) location associated with the seller. |
| `total` | `Long` | Query, Optional | The exact amount in the `total_money` for a payment. |
| `last4` | `String` | Query, Optional | The last four digits of a payment card. |
| `cardBrand` | `String` | Query, Optional | The brand of the payment card (for example, VISA). |
| `limit` | `Integer` | Query, Optional | The maximum number of results to be returned in a single page.<br>It is possible to receive fewer results than the specified limit on a given page.<br><br>The default value of 100 is also the maximum allowed value. If the provided value is<br>greater than 100, it is ignored and the default value is used instead.<br><br>Default: `100` |

## Response Type

[`ListPaymentsResponse`](/doc/models/list-payments-response.md)

## Example Usage

```java
String beginTime = "begin_time2";
String endTime = "end_time2";
String sortOrder = "sort_order0";
String cursor = "cursor6";
String locationId = "location_id4";
Long total = 10L;
String last4 = "last_42";
String cardBrand = "card_brand6";
Integer limit = 172;

paymentsApi.listPaymentsAsync(beginTime, endTime, sortOrder, cursor, locationId, total, last4, cardBrand, limit).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Payment

Charges a payment source (for example, a card
represented by customer's card on file or a card nonce). In addition
to the payment source, the request must include the
amount to accept for the payment.

There are several optional parameters that you can include in the request
(for example, tip money, whether to autocomplete the payment, or a reference ID
to correlate this payment with another system).

The `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission is required
to enable application fees.

```java
CompletableFuture<CreatePaymentResponse> createPaymentAsync(
    final CreatePaymentRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreatePaymentRequest`](/doc/models/create-payment-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreatePaymentResponse`](/doc/models/create-payment-response.md)

## Example Usage

```java
Money bodyAmountMoney = new Money.Builder()
    .amount(200L)
    .currency("USD")
    .build();
Money bodyTipMoney = new Money.Builder()
    .amount(198L)
    .currency("CHF")
    .build();
Money bodyAppFeeMoney = new Money.Builder()
    .amount(10L)
    .currency("USD")
    .build();
CreatePaymentRequest body = new CreatePaymentRequest.Builder(
        "ccof:uIbfJXhXETSP197M3GB",
        "4935a656-a929-4792-b97c-8848be85c27c",
        bodyAmountMoney)
    .tipMoney(bodyTipMoney)
    .appFeeMoney(bodyAppFeeMoney)
    .delayDuration("delay_duration6")
    .autocomplete(true)
    .orderId("order_id0")
    .customerId("VDKXEEKPJN48QDG3BGGFAK05P8")
    .locationId("XK3DBG77NJBFX")
    .referenceId("123456")
    .note("Brief description")
    .build();

paymentsApi.createPaymentAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Payment by Idempotency Key

Cancels (voids) a payment identified by the idempotency key that is specified in the
request.

Use this method when the status of a `CreatePayment` request is unknown (for example, after you send a
`CreatePayment` request, a network error occurs and you do not get a response). In this case, you can
direct Square to cancel the payment using this endpoint. In the request, you provide the same
idempotency key that you provided in your `CreatePayment` request that you want to cancel. After
canceling the payment, you can submit your `CreatePayment` request again.

Note that if no payment with the specified idempotency key is found, no action is taken and the endpoint
returns successfully.

```java
CompletableFuture<CancelPaymentByIdempotencyKeyResponse> cancelPaymentByIdempotencyKeyAsync(
    final CancelPaymentByIdempotencyKeyRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CancelPaymentByIdempotencyKeyRequest`](/doc/models/cancel-payment-by-idempotency-key-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CancelPaymentByIdempotencyKeyResponse`](/doc/models/cancel-payment-by-idempotency-key-response.md)

## Example Usage

```java
CancelPaymentByIdempotencyKeyRequest body = new CancelPaymentByIdempotencyKeyRequest.Builder(
        "a7e36d40-d24b-11e8-b568-0800200c9a66")
    .build();

paymentsApi.cancelPaymentByIdempotencyKeyAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Payment

Retrieves details for a specific payment.

```java
CompletableFuture<GetPaymentResponse> getPaymentAsync(
    final String paymentId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `paymentId` | `String` | Template, Required | A unique ID for the desired payment. |

## Response Type

[`GetPaymentResponse`](/doc/models/get-payment-response.md)

## Example Usage

```java
String paymentId = "payment_id0";

paymentsApi.getPaymentAsync(paymentId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Payment

Cancels (voids) a payment. If you set `autocomplete` to `false` when creating a payment,
you can cancel the payment using this endpoint.

```java
CompletableFuture<CancelPaymentResponse> cancelPaymentAsync(
    final String paymentId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `paymentId` | `String` | Template, Required | The `payment_id` identifying the payment to be canceled. |

## Response Type

[`CancelPaymentResponse`](/doc/models/cancel-payment-response.md)

## Example Usage

```java
String paymentId = "payment_id0";

paymentsApi.cancelPaymentAsync(paymentId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Complete Payment

Completes (captures) a payment.

By default, payments are set to complete immediately after they are created.
If you set `autocomplete` to `false` when creating a payment, you can complete (capture)
the payment using this endpoint.

```java
CompletableFuture<CompletePaymentResponse> completePaymentAsync(
    final String paymentId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `paymentId` | `String` | Template, Required | The unique ID identifying the payment to be completed. |

## Response Type

[`CompletePaymentResponse`](/doc/models/complete-payment-response.md)

## Example Usage

```java
String paymentId = "payment_id0";

paymentsApi.completePaymentAsync(paymentId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


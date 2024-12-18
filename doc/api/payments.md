# Payments

```java
PaymentsApi paymentsApi = client.getPaymentsApi();
```

## Class Name

`PaymentsApi`

## Methods

* [List Payments](../../doc/api/payments.md#list-payments)
* [Create Payment](../../doc/api/payments.md#create-payment)
* [Cancel Payment by Idempotency Key](../../doc/api/payments.md#cancel-payment-by-idempotency-key)
* [Get Payment](../../doc/api/payments.md#get-payment)
* [Update Payment](../../doc/api/payments.md#update-payment)
* [Cancel Payment](../../doc/api/payments.md#cancel-payment)
* [Complete Payment](../../doc/api/payments.md#complete-payment)


# List Payments

Retrieves a list of payments taken by the account making the request.

Results are eventually consistent, and new payments or changes to payments might take several
seconds to appear.

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
    final Integer limit,
    final Boolean isOfflinePayment,
    final String offlineBeginTime,
    final String offlineEndTime,
    final String updatedAtBeginTime,
    final String updatedAtEndTime,
    final String sortField)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `beginTime` | `String` | Query, Optional | Indicates the start of the time range to retrieve payments for, in RFC 3339 format.  <br>The range is determined using the `created_at` field for each Payment.<br>Inclusive. Default: The current time minus one year. |
| `endTime` | `String` | Query, Optional | Indicates the end of the time range to retrieve payments for, in RFC 3339 format.  The<br>range is determined using the `created_at` field for each Payment.<br><br>Default: The current time. |
| `sortOrder` | `String` | Query, Optional | The order in which results are listed by `ListPaymentsRequest.sort_field`:<br><br>- `ASC` - Oldest to newest.<br>- `DESC` - Newest to oldest (default). |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `locationId` | `String` | Query, Optional | Limit results to the location supplied. By default, results are returned<br>for the default (main) location associated with the seller. |
| `total` | `Long` | Query, Optional | The exact amount in the `total_money` for a payment. |
| `last4` | `String` | Query, Optional | The last four digits of a payment card. |
| `cardBrand` | `String` | Query, Optional | The brand of the payment card (for example, VISA). |
| `limit` | `Integer` | Query, Optional | The maximum number of results to be returned in a single page.<br>It is possible to receive fewer results than the specified limit on a given page.<br><br>The default value of 100 is also the maximum allowed value. If the provided value is<br>greater than 100, it is ignored and the default value is used instead.<br><br>Default: `100` |
| `isOfflinePayment` | `Boolean` | Query, Optional | Whether the payment was taken offline or not.<br>**Default**: `false` |
| `offlineBeginTime` | `String` | Query, Optional | Indicates the start of the time range for which to retrieve offline payments, in RFC 3339<br>format for timestamps. The range is determined using the<br>`offline_payment_details.client_created_at` field for each Payment. If set, payments without a<br>value set in `offline_payment_details.client_created_at` will not be returned.<br><br>Default: The current time. |
| `offlineEndTime` | `String` | Query, Optional | Indicates the end of the time range for which to retrieve offline payments, in RFC 3339<br>format for timestamps. The range is determined using the<br>`offline_payment_details.client_created_at` field for each Payment. If set, payments without a<br>value set in `offline_payment_details.client_created_at` will not be returned.<br><br>Default: The current time. |
| `updatedAtBeginTime` | `String` | Query, Optional | Indicates the start of the time range to retrieve payments for, in RFC 3339 format.  The<br>range is determined using the `updated_at` field for each Payment. |
| `updatedAtEndTime` | `String` | Query, Optional | Indicates the end of the time range to retrieve payments for, in RFC 3339 format.  The<br>range is determined using the `updated_at` field for each Payment. |
| `sortField` | [`String`](../../doc/models/payment-sort-field.md) | Query, Optional | The field used to sort results by. The default is `CREATED_AT`. |

## Response Type

[`ListPaymentsResponse`](../../doc/models/list-payments-response.md)

## Example Usage

```java
Boolean isOfflinePayment = false;

paymentsApi.listPaymentsAsync(null, null, null, null, null, null, null, null, null, isOfflinePayment, null, null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Create Payment

Creates a payment using the provided source. You can use this endpoint
to charge a card (credit/debit card or  
Square gift card) or record a payment that the seller received outside of Square
(cash payment from a buyer or a payment that an external entity
processed on behalf of the seller).

The endpoint creates a
`Payment` object and returns it in the response.

```java
CompletableFuture<CreatePaymentResponse> createPaymentAsync(
    final CreatePaymentRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreatePaymentRequest`](../../doc/models/create-payment-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreatePaymentResponse`](../../doc/models/create-payment-response.md)

## Example Usage

```java
CreatePaymentRequest body = new CreatePaymentRequest.Builder(
    "ccof:GaJGNaZa8x4OgDJn4GB",
    "7b0f3ec5-086a-4871-8f13-3c81b3875218"
)
.amountMoney(new Money.Builder()
        .amount(1000L)
        .currency("USD")
        .build())
.appFeeMoney(new Money.Builder()
        .amount(10L)
        .currency("USD")
        .build())
.autocomplete(true)
.customerId("W92WH6P11H4Z77CTET0RNTGFW8")
.locationId("L88917AVBK2S5")
.referenceId("123456")
.note("Brief description")
.build();

paymentsApi.createPaymentAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
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
| `body` | [`CancelPaymentByIdempotencyKeyRequest`](../../doc/models/cancel-payment-by-idempotency-key-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CancelPaymentByIdempotencyKeyResponse`](../../doc/models/cancel-payment-by-idempotency-key-response.md)

## Example Usage

```java
CancelPaymentByIdempotencyKeyRequest body = new CancelPaymentByIdempotencyKeyRequest.Builder(
    "a7e36d40-d24b-11e8-b568-0800200c9a66"
)
.build();

paymentsApi.cancelPaymentByIdempotencyKeyAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
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

[`GetPaymentResponse`](../../doc/models/get-payment-response.md)

## Example Usage

```java
String paymentId = "payment_id0";

paymentsApi.getPaymentAsync(paymentId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Update Payment

Updates a payment with the APPROVED status.
You can update the `amount_money` and `tip_money` using this endpoint.

```java
CompletableFuture<UpdatePaymentResponse> updatePaymentAsync(
    final String paymentId,
    final UpdatePaymentRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `paymentId` | `String` | Template, Required | The ID of the payment to update. |
| `body` | [`UpdatePaymentRequest`](../../doc/models/update-payment-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdatePaymentResponse`](../../doc/models/update-payment-response.md)

## Example Usage

```java
String paymentId = "payment_id0";
UpdatePaymentRequest body = new UpdatePaymentRequest.Builder(
    "956f8b13-e4ec-45d6-85e8-d1d95ef0c5de"
)
.payment(new Payment.Builder()
        .amountMoney(new Money.Builder()
            .amount(1000L)
            .currency("USD")
            .build())
        .tipMoney(new Money.Builder()
            .amount(100L)
            .currency("USD")
            .build())
        .versionToken("ODhwVQ35xwlzRuoZEwKXucfu7583sPTzK48c5zoGd0g6o")
        .build())
.build();

paymentsApi.updatePaymentAsync(paymentId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Cancel Payment

Cancels (voids) a payment. You can use this endpoint to cancel a payment with
the APPROVED `status`.

```java
CompletableFuture<CancelPaymentResponse> cancelPaymentAsync(
    final String paymentId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `paymentId` | `String` | Template, Required | The ID of the payment to cancel. |

## Response Type

[`CancelPaymentResponse`](../../doc/models/cancel-payment-response.md)

## Example Usage

```java
String paymentId = "payment_id0";

paymentsApi.cancelPaymentAsync(paymentId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Complete Payment

Completes (captures) a payment.
By default, payments are set to complete immediately after they are created.

You can use this endpoint to complete a payment with the APPROVED `status`.

```java
CompletableFuture<CompletePaymentResponse> completePaymentAsync(
    final String paymentId,
    final CompletePaymentRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `paymentId` | `String` | Template, Required | The unique ID identifying the payment to be completed. |
| `body` | [`CompletePaymentRequest`](../../doc/models/complete-payment-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CompletePaymentResponse`](../../doc/models/complete-payment-response.md)

## Example Usage

```java
String paymentId = "payment_id0";
CompletePaymentRequest body = new CompletePaymentRequest.Builder()
    .build();

paymentsApi.completePaymentAsync(paymentId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


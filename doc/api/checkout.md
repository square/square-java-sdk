# Checkout

```java
CheckoutApi checkoutApi = client.getCheckoutApi();
```

## Class Name

`CheckoutApi`

## Methods

* [Create Checkout](../../doc/api/checkout.md#create-checkout)
* [List Payment Links](../../doc/api/checkout.md#list-payment-links)
* [Create Payment Link](../../doc/api/checkout.md#create-payment-link)
* [Delete Payment Link](../../doc/api/checkout.md#delete-payment-link)
* [Retrieve Payment Link](../../doc/api/checkout.md#retrieve-payment-link)
* [Update Payment Link](../../doc/api/checkout.md#update-payment-link)


# Create Checkout

Links a `checkoutId` to a `checkout_page_url` that customers are
directed to in order to provide their payment information using a
payment processing workflow hosted on connect.squareup.com.

NOTE: The Checkout API has been updated with new features.
For more information, see [Checkout API highlights](https://developer.squareup.com/docs/checkout-api#checkout-api-highlights).
We recommend that you use the new [CreatePaymentLink](../../doc/api/checkout.md#create-payment-link) 
endpoint in place of this previously released endpoint.

```java
CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
    final String locationId,
    final CreateCheckoutRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the business location to associate the checkout with. |
| `body` | [`CreateCheckoutRequest`](../../doc/models/create-checkout-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateCheckoutResponse`](../../doc/models/create-checkout-response.md)

## Example Usage

```java
String locationId = "location_id4";
List<OrderLineItem> bodyOrderOrderLineItems = new LinkedList<>();

List<OrderLineItemAppliedTax> bodyOrderOrderLineItems0AppliedTaxes = new LinkedList<>();

OrderLineItemAppliedTax bodyOrderOrderLineItems0AppliedTaxes0 = new OrderLineItemAppliedTax.Builder(
        "38ze1696-z1e3-5628-af6d-f1e04d947fg3")
    .build();
bodyOrderOrderLineItems0AppliedTaxes.add(bodyOrderOrderLineItems0AppliedTaxes0);

List<OrderLineItemAppliedDiscount> bodyOrderOrderLineItems0AppliedDiscounts = new LinkedList<>();

OrderLineItemAppliedDiscount bodyOrderOrderLineItems0AppliedDiscounts0 = new OrderLineItemAppliedDiscount.Builder(
        "56ae1696-z1e3-9328-af6d-f1e04d947gd4")
    .build();
bodyOrderOrderLineItems0AppliedDiscounts.add(bodyOrderOrderLineItems0AppliedDiscounts0);

Money money = new Money.Builder()
    .amount(1500L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderOrderLineItems0 = new OrderLineItem.Builder(
        "2")
    .name("Printed T Shirt")
    .appliedTaxes(bodyOrderOrderLineItems0AppliedTaxes)
    .appliedDiscounts(bodyOrderOrderLineItems0AppliedDiscounts)
    .basePriceMoney(bodyOrderOrderLineItems0BasePriceMoney)
    .build();
bodyOrderOrderLineItems.add(bodyOrderOrderLineItems0);

Money money = new Money.Builder()
    .amount(2500L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderOrderLineItems1 = new OrderLineItem.Builder(
        "1")
    .name("Slim Jeans")
    .basePriceMoney(bodyOrderOrderLineItems1BasePriceMoney)
    .build();
bodyOrderOrderLineItems.add(bodyOrderOrderLineItems1);

Money money = new Money.Builder()
    .amount(3500L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderOrderLineItems2 = new OrderLineItem.Builder(
        "3")
    .name("Woven Sweater")
    .basePriceMoney(bodyOrderOrderLineItems2BasePriceMoney)
    .build();
bodyOrderOrderLineItems.add(bodyOrderOrderLineItems2);

List<OrderLineItemTax> bodyOrderOrderTaxes = new LinkedList<>();

OrderLineItemTax bodyOrderOrderTaxes0 = new OrderLineItemTax.Builder()
    .uid("38ze1696-z1e3-5628-af6d-f1e04d947fg3")
    .type("INCLUSIVE")
    .percentage("7.75")
    .scope("LINE_ITEM")
    .build();
bodyOrderOrderTaxes.add(bodyOrderOrderTaxes0);

List<OrderLineItemDiscount> bodyOrderOrderDiscounts = new LinkedList<>();

Money money = new Money.Builder()
    .amount(100L)
    .currency("USD")
    .build();
OrderLineItemDiscount bodyOrderOrderDiscounts0 = new OrderLineItemDiscount.Builder()
    .uid("56ae1696-z1e3-9328-af6d-f1e04d947gd4")
    .type("FIXED_AMOUNT")
    .amountMoney(bodyOrderOrderDiscounts0AmountMoney)
    .scope("LINE_ITEM")
    .build();
bodyOrderOrderDiscounts.add(bodyOrderOrderDiscounts0);

Order order = new Order.Builder(
        "location_id")
    .referenceId("reference_id")
    .customerId("customer_id")
    .lineItems(orderLineItems)
    .taxes(orderTaxes)
    .discounts(orderDiscounts)
    .build();
CreateOrderRequest createOrderRequest = new CreateOrderRequest.Builder()
    .order(createOrderRequestOrder)
    .idempotencyKey("12ae1696-z1e3-4328-af6d-f1e04d947gd4")
    .build();
Address address = new Address.Builder()
    .addressLine1("1455 Market St.")
    .addressLine2("Suite 600")
    .locality("San Francisco")
    .administrativeDistrictLevel1("CA")
    .postalCode("94103")
    .country("US")
    .build();
List<ChargeRequestAdditionalRecipient> bodyAdditionalRecipients = new LinkedList<>();

Money money = new Money.Builder()
    .amount(60L)
    .currency("USD")
    .build();
ChargeRequestAdditionalRecipient bodyAdditionalRecipients0 = new ChargeRequestAdditionalRecipient.Builder(
        "057P5VYJ4A5X1",
        "Application fees",
        amountMoney)
    .build();
bodyAdditionalRecipients.add(bodyAdditionalRecipients0);

CreateCheckoutRequest body = new CreateCheckoutRequest.Builder(
        "86ae1696-b1e3-4328-af6d-f1e04d947ad6",
        order)
    .askForShippingAddress(true)
    .merchantSupportEmail("merchant+support@website.com")
    .prePopulateBuyerEmail("example@email.com")
    .prePopulateShippingAddress(bodyPrePopulateShippingAddress)
    .redirectUrl("https://merchant.website.com/order-confirm")
    .additionalRecipients(bodyAdditionalRecipients)
    .build();

checkoutApi.createCheckoutAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Payment Links

Lists all payment links.

```java
CompletableFuture<ListPaymentLinksResponse> listPaymentLinksAsync(
    final String cursor,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>If a cursor is not provided, the endpoint returns the first page of the results.<br>For more  information, see [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). |
| `limit` | `Integer` | Query, Optional | A limit on the number of results to return per page. The limit is advisory and<br>the implementation might return more or less results. If the supplied limit is negative, zero, or<br>greater than the maximum limit of 1000, it is ignored.<br><br>Default value: `100` |

## Response Type

[`ListPaymentLinksResponse`](../../doc/models/list-payment-links-response.md)

## Example Usage

```java
checkoutApi.listPaymentLinksAsync(null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Payment Link

Creates a Square-hosted checkout page. Applications can share the resulting payment link with their buyer to pay for goods and services.

```java
CompletableFuture<CreatePaymentLinkResponse> createPaymentLinkAsync(
    final CreatePaymentLinkRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreatePaymentLinkRequest`](../../doc/models/create-payment-link-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreatePaymentLinkResponse`](../../doc/models/create-payment-link-response.md)

## Example Usage

```java
Money money = new Money.Builder()
    .amount(10000L)
    .currency("USD")
    .build();
QuickPay quickPay = new QuickPay.Builder(
        "Auto Detailing",
        priceMoney,
        "A9Y43N9ABXZBP")
    .build();
CreatePaymentLinkRequest body = new CreatePaymentLinkRequest.Builder()
    .idempotencyKey("cd9e25dc-d9f2-4430-aedb-61605070e95f")
    .quickPay(bodyQuickPay)
    .build();

checkoutApi.createPaymentLinkAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Payment Link

Deletes a payment link.

```java
CompletableFuture<DeletePaymentLinkResponse> deletePaymentLinkAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The ID of the payment link to delete. |

## Response Type

[`DeletePaymentLinkResponse`](../../doc/models/delete-payment-link-response.md)

## Example Usage

```java
String id = "id0";

checkoutApi.deletePaymentLinkAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Payment Link

Retrieves a payment link.

```java
CompletableFuture<RetrievePaymentLinkResponse> retrievePaymentLinkAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The ID of link to retrieve. |

## Response Type

[`RetrievePaymentLinkResponse`](../../doc/models/retrieve-payment-link-response.md)

## Example Usage

```java
String id = "id0";

checkoutApi.retrievePaymentLinkAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Payment Link

Updates a payment link. You can update the `payment_link` fields such as
`description`, `checkout_options`, and  `pre_populated_data`.
You cannot update other fields such as the `order_id`, `version`, `URL`, or `timestamp` field.

```java
CompletableFuture<UpdatePaymentLinkResponse> updatePaymentLinkAsync(
    final String id,
    final UpdatePaymentLinkRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The ID of the payment link to update. |
| `body` | [`UpdatePaymentLinkRequest`](../../doc/models/update-payment-link-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdatePaymentLinkResponse`](../../doc/models/update-payment-link-response.md)

## Example Usage

```java
String id = "id0";
CheckoutOptions checkoutOptions = new CheckoutOptions.Builder()
    .askForShippingAddress(true)
    .build();
PaymentLink paymentLink = new PaymentLink.Builder(
        1)
    .checkoutOptions(paymentLinkCheckoutOptions)
    .build();
UpdatePaymentLinkRequest body = new UpdatePaymentLinkRequest.Builder(
        paymentLink)
    .build();

checkoutApi.updatePaymentLinkAsync(id, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


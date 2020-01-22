# Checkout

```java
CheckoutApi checkoutApi = client.getCheckoutApi();
```

## Class Name

`CheckoutApi`

## Create Checkout

Links a `checkoutId` to a `checkout_page_url` that customers will
be directed to in order to provide their payment information using a
payment processing workflow hosted on connect.squareup.com.

```java
CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
    final String locationId,
    final CreateCheckoutRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the business location to associate the checkout with. |
| `body` | [`CreateCheckoutRequest`](/doc/models/create-checkout-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateCheckoutResponse`](/doc/models/create-checkout-response.md)

### Example Usage

```java
String locationId = "location_id4";
List<CreateOrderRequestLineItem> bodyOrderLineItems = new LinkedList<>();

Money bodyOrderLineItems0BasePriceMoney = new Money.Builder()
    .amount(1500L)
    .currency("USD")
    .build();
List<CreateOrderRequestDiscount> bodyOrderLineItems0Discounts = new LinkedList<>();

CreateOrderRequestDiscount bodyOrderLineItems0Discounts0 = new CreateOrderRequestDiscount.Builder()
    .name("7% off previous season item")
    .percentage("7")
    .build();
bodyOrderLineItems0Discounts.add(bodyOrderLineItems0Discounts0);

Money bodyOrderLineItems0Discounts1AmountMoney = new Money.Builder()
    .amount(300L)
    .currency("USD")
    .build();
CreateOrderRequestDiscount bodyOrderLineItems0Discounts1 = new CreateOrderRequestDiscount.Builder()
    .name("$3 off Customer Discount")
    .amountMoney(bodyOrderLineItems0Discounts1AmountMoney)
    .build();
bodyOrderLineItems0Discounts.add(bodyOrderLineItems0Discounts1);

CreateOrderRequestLineItem bodyOrderLineItems0 = new CreateOrderRequestLineItem.Builder(
        "2")
    .name("Printed T Shirt")
    .basePriceMoney(bodyOrderLineItems0BasePriceMoney)
    .discounts(bodyOrderLineItems0Discounts)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems0);

Money bodyOrderLineItems1BasePriceMoney = new Money.Builder()
    .amount(2500L)
    .currency("USD")
    .build();
CreateOrderRequestLineItem bodyOrderLineItems1 = new CreateOrderRequestLineItem.Builder(
        "1")
    .name("Slim Jeans")
    .basePriceMoney(bodyOrderLineItems1BasePriceMoney)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems1);

Money bodyOrderLineItems2BasePriceMoney = new Money.Builder()
    .amount(3500L)
    .currency("USD")
    .build();
List<CreateOrderRequestTax> bodyOrderLineItems2Taxes = new LinkedList<>();

CreateOrderRequestTax bodyOrderLineItems2Taxes0 = new CreateOrderRequestTax.Builder()
    .name("Fair Trade Tax")
    .percentage("5")
    .build();
bodyOrderLineItems2Taxes.add(bodyOrderLineItems2Taxes0);

List<CreateOrderRequestDiscount> bodyOrderLineItems2Discounts = new LinkedList<>();

Money bodyOrderLineItems2Discounts0AmountMoney = new Money.Builder()
    .amount(1100L)
    .currency("USD")
    .build();
CreateOrderRequestDiscount bodyOrderLineItems2Discounts0 = new CreateOrderRequestDiscount.Builder()
    .name("$11 off Customer Discount")
    .amountMoney(bodyOrderLineItems2Discounts0AmountMoney)
    .build();
bodyOrderLineItems2Discounts.add(bodyOrderLineItems2Discounts0);

CreateOrderRequestLineItem bodyOrderLineItems2 = new CreateOrderRequestLineItem.Builder(
        "3")
    .name("Woven Sweater")
    .basePriceMoney(bodyOrderLineItems2BasePriceMoney)
    .taxes(bodyOrderLineItems2Taxes)
    .discounts(bodyOrderLineItems2Discounts)
    .build();
bodyOrderLineItems.add(bodyOrderLineItems2);

List<CreateOrderRequestTax> bodyOrderTaxes = new LinkedList<>();

CreateOrderRequestTax bodyOrderTaxes0 = new CreateOrderRequestTax.Builder()
    .name("Sales Tax")
    .percentage("8.5")
    .build();
bodyOrderTaxes.add(bodyOrderTaxes0);

List<CreateOrderRequestDiscount> bodyOrderDiscounts = new LinkedList<>();

CreateOrderRequestDiscount bodyOrderDiscounts0 = new CreateOrderRequestDiscount.Builder()
    .name("Father's day 12% OFF")
    .percentage("12")
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts0);

Money bodyOrderDiscounts1AmountMoney = new Money.Builder()
    .amount(5500L)
    .currency("USD")
    .build();
CreateOrderRequestDiscount bodyOrderDiscounts1 = new CreateOrderRequestDiscount.Builder()
    .name("Global Sales $55 OFF")
    .amountMoney(bodyOrderDiscounts1AmountMoney)
    .build();
bodyOrderDiscounts.add(bodyOrderDiscounts1);

CreateOrderRequest bodyOrder = new CreateOrderRequest.Builder()
    .referenceId("reference_id")
    .lineItems(bodyOrderLineItems)
    .taxes(bodyOrderTaxes)
    .discounts(bodyOrderDiscounts)
    .build();
Address bodyPrePopulateShippingAddress = new Address.Builder()
    .addressLine1("1455 Market St.")
    .addressLine2("Suite 600")
    .locality("San Francisco")
    .administrativeDistrictLevel1("CA")
    .postalCode("94103")
    .country("US")
    .firstName("Jane")
    .lastName("Doe")
    .build();
List<ChargeRequestAdditionalRecipient> bodyAdditionalRecipients = new LinkedList<>();

Money bodyAdditionalRecipients0AmountMoney = new Money.Builder()
    .amount(60L)
    .currency("USD")
    .build();
ChargeRequestAdditionalRecipient bodyAdditionalRecipients0 = new ChargeRequestAdditionalRecipient.Builder(
        "057P5VYJ4A5X1",
        "Application fees",
        bodyAdditionalRecipients0AmountMoney)
    .build();
bodyAdditionalRecipients.add(bodyAdditionalRecipients0);

CreateCheckoutRequest body = new CreateCheckoutRequest.Builder(
        "86ae1696-b1e3-4328-af6d-f1e04d947ad6",
        bodyOrder)
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


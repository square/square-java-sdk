# Checkout

```java
CheckoutApi checkoutApi = client.getCheckoutApi();
```

## Class Name

`CheckoutApi`


# Create Checkout

Links a `checkoutId` to a `checkout_page_url` that customers are
directed to in order to provide their payment information using a
payment processing workflow hosted on connect.squareup.com.

```java
CompletableFuture<CreateCheckoutResponse> createCheckoutAsync(
    final String locationId,
    final CreateCheckoutRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the business location to associate the checkout with. |
| `body` | [`CreateCheckoutRequest`](/doc/models/create-checkout-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateCheckoutResponse`](/doc/models/create-checkout-response.md)

## Example Usage

```java
String locationId = "location_id4";
OrderSource bodyOrderOrderSource = new OrderSource.Builder()
    .name("name8")
    .build();
List<OrderLineItem> bodyOrderOrderLineItems = new LinkedList<>();

MeasurementUnit bodyOrderOrderLineItems0QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .areaUnit("IMPERIAL_SQUARE_YARD")
    .lengthUnit("METRIC_CENTIMETER")
    .volumeUnit("GENERIC_SHOT")
    .weightUnit("METRIC_MILLIGRAM")
    .build();
OrderQuantityUnit bodyOrderOrderLineItems0QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderOrderLineItems0QuantityUnitMeasurementUnit)
    .precision(191)
    .catalogObjectId("catalog_object_id7")
    .catalogVersion(131L)
    .build();
List<OrderLineItemAppliedTax> bodyOrderOrderLineItems0AppliedTaxes = new LinkedList<>();

Money bodyOrderOrderLineItems0AppliedTaxes0AppliedMoney = new Money.Builder()
    .amount(53L)
    .currency("GBP")
    .build();
OrderLineItemAppliedTax bodyOrderOrderLineItems0AppliedTaxes0 = new OrderLineItemAppliedTax.Builder(
        "38ze1696-z1e3-5628-af6d-f1e04d947fg3")
    .uid("uid3")
    .appliedMoney(bodyOrderOrderLineItems0AppliedTaxes0AppliedMoney)
    .build();
bodyOrderOrderLineItems0AppliedTaxes.add(bodyOrderOrderLineItems0AppliedTaxes0);

List<OrderLineItemAppliedDiscount> bodyOrderOrderLineItems0AppliedDiscounts = new LinkedList<>();

Money bodyOrderOrderLineItems0AppliedDiscounts0AppliedMoney = new Money.Builder()
    .amount(161L)
    .currency("LSL")
    .build();
OrderLineItemAppliedDiscount bodyOrderOrderLineItems0AppliedDiscounts0 = new OrderLineItemAppliedDiscount.Builder(
        "56ae1696-z1e3-9328-af6d-f1e04d947gd4")
    .uid("uid7")
    .appliedMoney(bodyOrderOrderLineItems0AppliedDiscounts0AppliedMoney)
    .build();
bodyOrderOrderLineItems0AppliedDiscounts.add(bodyOrderOrderLineItems0AppliedDiscounts0);

Money bodyOrderOrderLineItems0BasePriceMoney = new Money.Builder()
    .amount(1500L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderOrderLineItems0 = new OrderLineItem.Builder(
        "2")
    .uid("uid3")
    .name("Printed T Shirt")
    .quantityUnit(bodyOrderOrderLineItems0QuantityUnit)
    .note("note1")
    .catalogObjectId("catalog_object_id3")
    .appliedTaxes(bodyOrderOrderLineItems0AppliedTaxes)
    .appliedDiscounts(bodyOrderOrderLineItems0AppliedDiscounts)
    .basePriceMoney(bodyOrderOrderLineItems0BasePriceMoney)
    .build();
bodyOrderOrderLineItems.add(bodyOrderOrderLineItems0);

MeasurementUnit bodyOrderOrderLineItems1QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .areaUnit("IMPERIAL_SQUARE_MILE")
    .lengthUnit("METRIC_MILLIMETER")
    .volumeUnit("GENERIC_CUP")
    .weightUnit("IMPERIAL_STONE")
    .build();
OrderQuantityUnit bodyOrderOrderLineItems1QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderOrderLineItems1QuantityUnitMeasurementUnit)
    .precision(192)
    .catalogObjectId("catalog_object_id6")
    .catalogVersion(130L)
    .build();
Money bodyOrderOrderLineItems1BasePriceMoney = new Money.Builder()
    .amount(2500L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderOrderLineItems1 = new OrderLineItem.Builder(
        "1")
    .uid("uid4")
    .name("Slim Jeans")
    .quantityUnit(bodyOrderOrderLineItems1QuantityUnit)
    .note("note0")
    .catalogObjectId("catalog_object_id2")
    .basePriceMoney(bodyOrderOrderLineItems1BasePriceMoney)
    .build();
bodyOrderOrderLineItems.add(bodyOrderOrderLineItems1);

MeasurementUnit bodyOrderOrderLineItems2QuantityUnitMeasurementUnit = new MeasurementUnit.Builder()
    .areaUnit("METRIC_SQUARE_CENTIMETER")
    .lengthUnit("IMPERIAL_MILE")
    .volumeUnit("GENERIC_PINT")
    .weightUnit("IMPERIAL_POUND")
    .build();
OrderQuantityUnit bodyOrderOrderLineItems2QuantityUnit = new OrderQuantityUnit.Builder()
    .measurementUnit(bodyOrderOrderLineItems2QuantityUnitMeasurementUnit)
    .precision(193)
    .catalogObjectId("catalog_object_id5")
    .catalogVersion(129L)
    .build();
Money bodyOrderOrderLineItems2BasePriceMoney = new Money.Builder()
    .amount(3500L)
    .currency("USD")
    .build();
OrderLineItem bodyOrderOrderLineItems2 = new OrderLineItem.Builder(
        "3")
    .uid("uid5")
    .name("Woven Sweater")
    .quantityUnit(bodyOrderOrderLineItems2QuantityUnit)
    .note("note9")
    .catalogObjectId("catalog_object_id1")
    .basePriceMoney(bodyOrderOrderLineItems2BasePriceMoney)
    .build();
bodyOrderOrderLineItems.add(bodyOrderOrderLineItems2);

List<OrderLineItemTax> bodyOrderOrderTaxes = new LinkedList<>();

OrderLineItemTax bodyOrderOrderTaxes0 = new OrderLineItemTax.Builder()
    .uid("38ze1696-z1e3-5628-af6d-f1e04d947fg3")
    .catalogObjectId("catalog_object_id7")
    .catalogVersion(47L)
    .name("name9")
    .type("INCLUSIVE")
    .percentage("7.75")
    .scope("LINE_ITEM")
    .build();
bodyOrderOrderTaxes.add(bodyOrderOrderTaxes0);

List<OrderLineItemDiscount> bodyOrderOrderDiscounts = new LinkedList<>();

Money bodyOrderOrderDiscounts0AmountMoney = new Money.Builder()
    .amount(100L)
    .currency("USD")
    .build();
OrderLineItemDiscount bodyOrderOrderDiscounts0 = new OrderLineItemDiscount.Builder()
    .uid("56ae1696-z1e3-9328-af6d-f1e04d947gd4")
    .catalogObjectId("catalog_object_id1")
    .catalogVersion(73L)
    .name("name7")
    .type("FIXED_AMOUNT")
    .amountMoney(bodyOrderOrderDiscounts0AmountMoney)
    .scope("LINE_ITEM")
    .build();
bodyOrderOrderDiscounts.add(bodyOrderOrderDiscounts0);

Order bodyOrderOrder = new Order.Builder(
        "location_id")
    .id("id6")
    .referenceId("reference_id")
    .source(bodyOrderOrderSource)
    .customerId("customer_id")
    .lineItems(bodyOrderOrderLineItems)
    .taxes(bodyOrderOrderTaxes)
    .discounts(bodyOrderOrderDiscounts)
    .build();
CreateOrderRequest bodyOrder = new CreateOrderRequest.Builder()
    .order(bodyOrderOrder)
    .idempotencyKey("12ae1696-z1e3-4328-af6d-f1e04d947gd4")
    .build();
Address bodyPrePopulateShippingAddress = new Address.Builder()
    .addressLine1("1455 Market St.")
    .addressLine2("Suite 600")
    .addressLine3("address_line_36")
    .locality("San Francisco")
    .sublocality("sublocality0")
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


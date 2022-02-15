# Gift Card Activities

```java
GiftCardActivitiesApi giftCardActivitiesApi = client.getGiftCardActivitiesApi();
```

## Class Name

`GiftCardActivitiesApi`

## Methods

* [List Gift Card Activities](/doc/api/gift-card-activities.md#list-gift-card-activities)
* [Create Gift Card Activity](/doc/api/gift-card-activities.md#create-gift-card-activity)


# List Gift Card Activities

Lists gift card activities. By default, you get gift card activities for all
gift cards in the seller's account. You can optionally specify query parameters to
filter the list. For example, you can get a list of gift card activities for a gift card,
for all gift cards in a specific region, or for activities within a time window.

```java
CompletableFuture<ListGiftCardActivitiesResponse> listGiftCardActivitiesAsync(
    final String giftCardId,
    final String type,
    final String locationId,
    final String beginTime,
    final String endTime,
    final Integer limit,
    final String cursor,
    final String sortOrder)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `giftCardId` | `String` | Query, Optional | If a gift card ID is provided, the endpoint returns activities related<br>to the specified gift card. Otherwise, the endpoint returns all gift card activities for<br>the seller. |
| `type` | `String` | Query, Optional | If a [type](/doc/models/gift-card-activity-type.md) is provided, the endpoint returns gift card activities of the specified type.<br>Otherwise, the endpoint returns all types of gift card activities. |
| `locationId` | `String` | Query, Optional | If a location ID is provided, the endpoint returns gift card activities for the specified location.<br>Otherwise, the endpoint returns gift card activities for all locations. |
| `beginTime` | `String` | Query, Optional | The timestamp for the beginning of the reporting period, in RFC 3339 format.<br>This start time is inclusive. The default value is the current time minus one year. |
| `endTime` | `String` | Query, Optional | The timestamp for the end of the reporting period, in RFC 3339 format.<br>This end time is inclusive. The default value is the current time. |
| `limit` | `Integer` | Query, Optional | If a limit is provided, the endpoint returns the specified number<br>of results (or fewer) per page. The maximum value is 100. The default value is 50.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>If a cursor is not provided, the endpoint returns the first page of the results.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `sortOrder` | `String` | Query, Optional | The order in which the endpoint returns the activities, based on `created_at`.<br><br>- `ASC` - Oldest to newest.<br>- `DESC` - Newest to oldest (default). |

## Response Type

[`ListGiftCardActivitiesResponse`](/doc/models/list-gift-card-activities-response.md)

## Example Usage

```java
String giftCardId = "gift_card_id8";
String type = "type0";
String locationId = "location_id4";
String beginTime = "begin_time2";
String endTime = "end_time2";
Integer limit = 172;
String cursor = "cursor6";
String sortOrder = "sort_order0";

giftCardActivitiesApi.listGiftCardActivitiesAsync(giftCardId, type, locationId, beginTime, endTime, limit, cursor, sortOrder).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Gift Card Activity

Creates a gift card activity. For more information, see
[GiftCardActivity](https://developer.squareup.com/docs/gift-cards/using-gift-cards-api#giftcardactivity) and
[Using activated gift cards](https://developer.squareup.com/docs/gift-cards/using-gift-cards-api#using-activated-gift-cards).

```java
CompletableFuture<CreateGiftCardActivityResponse> createGiftCardActivityAsync(
    final CreateGiftCardActivityRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateGiftCardActivityRequest`](/doc/models/create-gift-card-activity-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateGiftCardActivityResponse`](/doc/models/create-gift-card-activity-response.md)

## Example Usage

```java
Money money = new Money.Builder()
    .amount(88L)
    .currency("ANG")
    .build();
Money money = new Money.Builder()
    .amount(10L)
    .currency("MXV")
    .build();
List<String> bodyGiftCardActivityActivateActivityDetailsBuyerPaymentInstrumentIds = new LinkedList<>();
bodyGiftCardActivityActivateActivityDetailsBuyerPaymentInstrumentIds.add("buyer_payment_instrument_ids4");
bodyGiftCardActivityActivateActivityDetailsBuyerPaymentInstrumentIds.add("buyer_payment_instrument_ids5");
bodyGiftCardActivityActivateActivityDetailsBuyerPaymentInstrumentIds.add("buyer_payment_instrument_ids6");
GiftCardActivityActivate giftCardActivityActivate = new GiftCardActivityActivate.Builder()
    .amountMoney(giftCardActivityActivateAmountMoney)
    .orderId("jJNGHm4gLI6XkFbwtiSLqK72KkAZY")
    .lineItemUid("eIWl7X0nMuO9Ewbh0ChIx")
    .referenceId("reference_id4")
    .buyerPaymentInstrumentIds(giftCardActivityActivateBuyerPaymentInstrumentIds)
    .build();
GiftCardActivity giftCardActivity = new GiftCardActivity.Builder(
        "ACTIVATE",
        "81FN9BNFZTKS4")
    .id("id2")
    .createdAt("created_at0")
    .giftCardId("gftc:6d55a72470d940c6ba09c0ab8ad08d20")
    .giftCardGan("gift_card_gan8")
    .giftCardBalanceMoney(giftCardActivityGiftCardBalanceMoney)
    .activateActivityDetails(giftCardActivityActivateActivityDetails)
    .build();
CreateGiftCardActivityRequest body = new CreateGiftCardActivityRequest.Builder(
        "U16kfr-kA70er-q4Rsym-7U7NnY",
        giftCardActivity)
    .build();

giftCardActivitiesApi.createGiftCardActivityAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


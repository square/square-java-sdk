# Gift Cards

```java
GiftCardsApi giftCardsApi = client.getGiftCardsApi();
```

## Class Name

`GiftCardsApi`

## Methods

* [List Gift Cards](../../doc/api/gift-cards.md#list-gift-cards)
* [Create Gift Card](../../doc/api/gift-cards.md#create-gift-card)
* [Retrieve Gift Card From GAN](../../doc/api/gift-cards.md#retrieve-gift-card-from-gan)
* [Retrieve Gift Card From Nonce](../../doc/api/gift-cards.md#retrieve-gift-card-from-nonce)
* [Link Customer to Gift Card](../../doc/api/gift-cards.md#link-customer-to-gift-card)
* [Unlink Customer From Gift Card](../../doc/api/gift-cards.md#unlink-customer-from-gift-card)
* [Retrieve Gift Card](../../doc/api/gift-cards.md#retrieve-gift-card)


# List Gift Cards

Lists all gift cards. You can specify optional filters to retrieve
a subset of the gift cards. Results are sorted by `created_at` in ascending order.

```java
CompletableFuture<ListGiftCardsResponse> listGiftCardsAsync(
    final String type,
    final String state,
    final Integer limit,
    final String cursor,
    final String customerId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `type` | `String` | Query, Optional | If a [type](../../doc/models/gift-card-type.md) is provided, the endpoint returns gift cards of the specified type.<br>Otherwise, the endpoint returns gift cards of all types. |
| `state` | `String` | Query, Optional | If a [state](../../doc/models/gift-card-status.md) is provided, the endpoint returns the gift cards in the specified state.<br>Otherwise, the endpoint returns the gift cards of all states. |
| `limit` | `Integer` | Query, Optional | If a limit is provided, the endpoint returns only the specified number of results per page.<br>The maximum value is 50. The default value is 30.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>If a cursor is not provided, the endpoint returns the first page of the results.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `customerId` | `String` | Query, Optional | If a customer ID is provided, the endpoint returns only the gift cards linked to the specified customer. |

## Response Type

[`ListGiftCardsResponse`](../../doc/models/list-gift-cards-response.md)

## Example Usage

```java
giftCardsApi.listGiftCardsAsync(null, null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Gift Card

Creates a digital gift card or registers a physical (plastic) gift card. After the gift card
is created, you must call [CreateGiftCardActivity](../../doc/api/gift-card-activities.md#create-gift-card-activity)
to activate the card with an initial balance before it can be used for payment.

```java
CompletableFuture<CreateGiftCardResponse> createGiftCardAsync(
    final CreateGiftCardRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateGiftCardRequest`](../../doc/models/create-gift-card-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateGiftCardResponse`](../../doc/models/create-gift-card-response.md)

## Example Usage

```java
GiftCard giftCard = new GiftCard.Builder(
        "DIGITAL")
    .build();
CreateGiftCardRequest body = new CreateGiftCardRequest.Builder(
        "NC9Tm69EjbjtConu",
        "81FN9BNFZTKS4",
        giftCard)
    .build();

giftCardsApi.createGiftCardAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Gift Card From GAN

Retrieves a gift card using the gift card account number (GAN).

```java
CompletableFuture<RetrieveGiftCardFromGANResponse> retrieveGiftCardFromGANAsync(
    final RetrieveGiftCardFromGANRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`RetrieveGiftCardFromGANRequest`](../../doc/models/retrieve-gift-card-from-gan-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`RetrieveGiftCardFromGANResponse`](../../doc/models/retrieve-gift-card-from-gan-response.md)

## Example Usage

```java
RetrieveGiftCardFromGANRequest body = new RetrieveGiftCardFromGANRequest.Builder(
        "7783320001001635")
    .build();

giftCardsApi.retrieveGiftCardFromGANAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Gift Card From Nonce

Retrieves a gift card using a secure payment token that represents the gift card.

```java
CompletableFuture<RetrieveGiftCardFromNonceResponse> retrieveGiftCardFromNonceAsync(
    final RetrieveGiftCardFromNonceRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`RetrieveGiftCardFromNonceRequest`](../../doc/models/retrieve-gift-card-from-nonce-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`RetrieveGiftCardFromNonceResponse`](../../doc/models/retrieve-gift-card-from-nonce-response.md)

## Example Usage

```java
RetrieveGiftCardFromNonceRequest body = new RetrieveGiftCardFromNonceRequest.Builder(
        "cnon:7783322135245171")
    .build();

giftCardsApi.retrieveGiftCardFromNonceAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Link Customer to Gift Card

Links a customer to a gift card, which is also referred to as adding a card on file.

```java
CompletableFuture<LinkCustomerToGiftCardResponse> linkCustomerToGiftCardAsync(
    final String giftCardId,
    final LinkCustomerToGiftCardRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `giftCardId` | `String` | Template, Required | The ID of the gift card to be linked. |
| `body` | [`LinkCustomerToGiftCardRequest`](../../doc/models/link-customer-to-gift-card-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`LinkCustomerToGiftCardResponse`](../../doc/models/link-customer-to-gift-card-response.md)

## Example Usage

```java
String giftCardId = "gift_card_id8";
LinkCustomerToGiftCardRequest body = new LinkCustomerToGiftCardRequest.Builder(
        "GKY0FZ3V717AH8Q2D821PNT2ZW")
    .build();

giftCardsApi.linkCustomerToGiftCardAsync(giftCardId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Unlink Customer From Gift Card

Unlinks a customer from a gift card, which is also referred to as removing a card on file.

```java
CompletableFuture<UnlinkCustomerFromGiftCardResponse> unlinkCustomerFromGiftCardAsync(
    final String giftCardId,
    final UnlinkCustomerFromGiftCardRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `giftCardId` | `String` | Template, Required | The ID of the gift card to be unlinked. |
| `body` | [`UnlinkCustomerFromGiftCardRequest`](../../doc/models/unlink-customer-from-gift-card-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UnlinkCustomerFromGiftCardResponse`](../../doc/models/unlink-customer-from-gift-card-response.md)

## Example Usage

```java
String giftCardId = "gift_card_id8";
UnlinkCustomerFromGiftCardRequest body = new UnlinkCustomerFromGiftCardRequest.Builder(
        "GKY0FZ3V717AH8Q2D821PNT2ZW")
    .build();

giftCardsApi.unlinkCustomerFromGiftCardAsync(giftCardId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Gift Card

Retrieves a gift card using the gift card ID.

```java
CompletableFuture<RetrieveGiftCardResponse> retrieveGiftCardAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The ID of the gift card to retrieve. |

## Response Type

[`RetrieveGiftCardResponse`](../../doc/models/retrieve-gift-card-response.md)

## Example Usage

```java
String id = "id0";

giftCardsApi.retrieveGiftCardAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Subscriptions

```java
SubscriptionsApi subscriptionsApi = client.getSubscriptionsApi();
```

## Class Name

`SubscriptionsApi`

## Methods

* [Create Subscription](/doc/api/subscriptions.md#create-subscription)
* [Search Subscriptions](/doc/api/subscriptions.md#search-subscriptions)
* [Retrieve Subscription](/doc/api/subscriptions.md#retrieve-subscription)
* [Update Subscription](/doc/api/subscriptions.md#update-subscription)
* [Cancel Subscription](/doc/api/subscriptions.md#cancel-subscription)
* [List Subscription Events](/doc/api/subscriptions.md#list-subscription-events)
* [Resume Subscription](/doc/api/subscriptions.md#resume-subscription)


# Create Subscription

Creates a subscription for a customer to a subscription plan.

If you provide a card on file in the request, Square charges the card for
the subscription. Otherwise, Square bills an invoice to the customer's email
address. The subscription starts immediately, unless the request includes
the optional `start_date`. Each individual subscription is associated with a particular location.

```java
CompletableFuture<CreateSubscriptionResponse> createSubscriptionAsync(
    final CreateSubscriptionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateSubscriptionRequest`](/doc/models/create-subscription-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateSubscriptionResponse`](/doc/models/create-subscription-response.md)

## Example Usage

```java
Money bodyPriceOverrideMoney = new Money.Builder()
    .amount(100L)
    .currency("USD")
    .build();
CreateSubscriptionRequest body = new CreateSubscriptionRequest.Builder(
        "S8GWD5R9QB376",
        "6JHXF3B2CW3YKHDV4XEM674H",
        "CHFGVKYY8RSV93M5KCYTG4PN0G")
    .idempotencyKey("8193148c-9586-11e6-99f9-28cfe92138cf")
    .startDate("2020-08-01")
    .canceledDate("canceled_date0")
    .taxPercentage("5")
    .priceOverrideMoney(bodyPriceOverrideMoney)
    .cardId("ccof:qy5x8hHGYsgLrp4Q4GB")
    .timezone("America/Los_Angeles")
    .build();

subscriptionsApi.createSubscriptionAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Subscriptions

Searches for subscriptions.
Results are ordered chronologically by subscription creation date. If
the request specifies more than one location ID,
the endpoint orders the result
by location ID, and then by creation date within each location. If no locations are given
in the query, all locations are searched.

You can also optionally specify `customer_ids` to search by customer.
If left unset, all customers
associated with the specified locations are returned.
If the request specifies customer IDs, the endpoint orders results
first by location, within location by customer ID, and within
customer by subscription creation date.

For more information, see
[Retrieve subscriptions](https://developer.squareup.com/docs/subscriptions-api/overview#retrieve-subscriptions).

```java
CompletableFuture<SearchSubscriptionsResponse> searchSubscriptionsAsync(
    final SearchSubscriptionsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchSubscriptionsRequest`](/doc/models/search-subscriptions-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchSubscriptionsResponse`](/doc/models/search-subscriptions-response.md)

## Example Usage

```java
List<String> bodyQueryFilterCustomerIds = new LinkedList<>();
bodyQueryFilterCustomerIds.add("CHFGVKYY8RSV93M5KCYTG4PN0G");
List<String> bodyQueryFilterLocationIds = new LinkedList<>();
bodyQueryFilterLocationIds.add("S8GWD5R9QB376");
SearchSubscriptionsFilter bodyQueryFilter = new SearchSubscriptionsFilter.Builder()
    .customerIds(bodyQueryFilterCustomerIds)
    .locationIds(bodyQueryFilterLocationIds)
    .build();
SearchSubscriptionsQuery bodyQuery = new SearchSubscriptionsQuery.Builder()
    .filter(bodyQueryFilter)
    .build();
SearchSubscriptionsRequest body = new SearchSubscriptionsRequest.Builder()
    .cursor("cursor0")
    .limit(164)
    .query(bodyQuery)
    .build();

subscriptionsApi.searchSubscriptionsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Subscription

Retrieves a subscription.

```java
CompletableFuture<RetrieveSubscriptionResponse> retrieveSubscriptionAsync(
    final String subscriptionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to retrieve. |

## Response Type

[`RetrieveSubscriptionResponse`](/doc/models/retrieve-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";

subscriptionsApi.retrieveSubscriptionAsync(subscriptionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Subscription

Updates a subscription. You can set, modify, and clear the
`subscription` field values.

```java
CompletableFuture<UpdateSubscriptionResponse> updateSubscriptionAsync(
    final String subscriptionId,
    final UpdateSubscriptionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID for the subscription to update. |
| `body` | [`UpdateSubscriptionRequest`](/doc/models/update-subscription-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateSubscriptionResponse`](/doc/models/update-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
Money bodySubscriptionPriceOverrideMoney = new Money.Builder()
    .amount(2000L)
    .currency("USD")
    .build();
Subscription bodySubscription = new Subscription.Builder()
    .id("id8")
    .locationId("location_id2")
    .planId("plan_id0")
    .customerId("customer_id6")
    .startDate("start_date2")
    .taxPercentage("null")
    .priceOverrideMoney(bodySubscriptionPriceOverrideMoney)
    .version(1594155459464L)
    .build();
UpdateSubscriptionRequest body = new UpdateSubscriptionRequest.Builder()
    .subscription(bodySubscription)
    .build();

subscriptionsApi.updateSubscriptionAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Subscription

Sets the `canceled_date` field to the end of the active billing period.
After this date, the status changes from ACTIVE to CANCELED.

```java
CompletableFuture<CancelSubscriptionResponse> cancelSubscriptionAsync(
    final String subscriptionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to cancel. |

## Response Type

[`CancelSubscriptionResponse`](/doc/models/cancel-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";

subscriptionsApi.cancelSubscriptionAsync(subscriptionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Subscription Events

Lists all events for a specific subscription.
In the current implementation, only `START_SUBSCRIPTION` and `STOP_SUBSCRIPTION` (when the subscription was canceled) events are returned.

```java
CompletableFuture<ListSubscriptionEventsResponse> listSubscriptionEventsAsync(
    final String subscriptionId,
    final String cursor,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to retrieve the events for. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for the original query.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `limit` | `Integer` | Query, Optional | The upper limit on the number of subscription events to return<br>in the response.<br><br>Default: `200` |

## Response Type

[`ListSubscriptionEventsResponse`](/doc/models/list-subscription-events-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
String cursor = "cursor6";
Integer limit = 172;

subscriptionsApi.listSubscriptionEventsAsync(subscriptionId, cursor, limit).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Resume Subscription

Resumes a deactivated subscription.

```java
CompletableFuture<ResumeSubscriptionResponse> resumeSubscriptionAsync(
    final String subscriptionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to resume. |

## Response Type

[`ResumeSubscriptionResponse`](/doc/models/resume-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";

subscriptionsApi.resumeSubscriptionAsync(subscriptionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


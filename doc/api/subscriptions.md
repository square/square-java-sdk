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
* [Delete Subscription Action](/doc/api/subscriptions.md#delete-subscription-action)
* [Cancel Subscription](/doc/api/subscriptions.md#cancel-subscription)
* [List Subscription Events](/doc/api/subscriptions.md#list-subscription-events)
* [Pause Subscription](/doc/api/subscriptions.md#pause-subscription)
* [Resume Subscription](/doc/api/subscriptions.md#resume-subscription)
* [Swap Plan](/doc/api/subscriptions.md#swap-plan)


# Create Subscription

Creates a subscription to a subscription plan by a customer.

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
SubscriptionSource bodySource = new SubscriptionSource.Builder()
    .name("My App")
    .build();
CreateSubscriptionRequest body = new CreateSubscriptionRequest.Builder(
        "S8GWD5R9QB376",
        "6JHXF3B2CW3YKHDV4XEM674H",
        "CHFGVKYY8RSV93M5KCYTG4PN0G")
    .idempotencyKey("8193148c-9586-11e6-99f9-28cfe92138cf")
    .startDate("2021-10-20")
    .canceledDate("canceled_date0")
    .taxPercentage("5")
    .priceOverrideMoney(bodyPriceOverrideMoney)
    .cardId("ccof:qy5x8hHGYsgLrp4Q4GB")
    .timezone("America/Los_Angeles")
    .source(bodySource)
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
List<String> bodyQueryFilterSourceNames = new LinkedList<>();
bodyQueryFilterSourceNames.add("My App");
SearchSubscriptionsFilter bodyQueryFilter = new SearchSubscriptionsFilter.Builder()
    .customerIds(bodyQueryFilterCustomerIds)
    .locationIds(bodyQueryFilterLocationIds)
    .sourceNames(bodyQueryFilterSourceNames)
    .build();
SearchSubscriptionsQuery bodyQuery = new SearchSubscriptionsQuery.Builder()
    .filter(bodyQueryFilter)
    .build();
List<String> bodyInclude = new LinkedList<>();
bodyInclude.add("include4");
bodyInclude.add("include5");
bodyInclude.add("include6");
SearchSubscriptionsRequest body = new SearchSubscriptionsRequest.Builder()
    .cursor("cursor0")
    .limit(164)
    .query(bodyQuery)
    .include(bodyInclude)
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
    final String subscriptionId,
    final String include)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to retrieve. |
| `include` | `String` | Query, Optional | A query parameter to specify related information to be included in the response.<br><br>The supported query parameter values are:<br><br>- `actions`: to include scheduled actions on the targeted subscription. |

## Response Type

[`RetrieveSubscriptionResponse`](/doc/models/retrieve-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
String include = "include2";

subscriptionsApi.retrieveSubscriptionAsync(subscriptionId, include).thenAccept(result -> {
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
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to update. |
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


# Delete Subscription Action

Deletes a scheduled action for a subscription.

```java
CompletableFuture<DeleteSubscriptionActionResponse> deleteSubscriptionActionAsync(
    final String subscriptionId,
    final String actionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription the targeted action is to act upon. |
| `actionId` | `String` | Template, Required | The ID of the targeted action to be deleted. |

## Response Type

[`DeleteSubscriptionActionResponse`](/doc/models/delete-subscription-action-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
String actionId = "action_id6";

subscriptionsApi.deleteSubscriptionActionAsync(subscriptionId, actionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Subscription

Schedules a `CANCEL` action to cancel an active subscription
by setting the `canceled_date` field to the end of the active billing period
and changing the subscription status from ACTIVE to CANCELED after this date.

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
| `cursor` | `String` | Query, Optional | When the total number of resulting subscription events exceeds the limit of a paged response,<br>specify the cursor returned from a preceding response here to fetch the next set of results.<br>If the cursor is unset, the response contains the last page of the results.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `limit` | `Integer` | Query, Optional | The upper limit on the number of subscription events to return<br>in a paged response. |

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


# Pause Subscription

Schedules a `PAUSE` action to pause an active subscription.

```java
CompletableFuture<PauseSubscriptionResponse> pauseSubscriptionAsync(
    final String subscriptionId,
    final PauseSubscriptionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to pause. |
| `body` | [`PauseSubscriptionRequest`](/doc/models/pause-subscription-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`PauseSubscriptionResponse`](/doc/models/pause-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
PauseSubscriptionRequest body = new PauseSubscriptionRequest.Builder()
    .pauseEffectiveDate("pause_effective_date6")
    .pauseCycleDuration(94L)
    .resumeEffectiveDate("resume_effective_date4")
    .resumeChangeTiming("IMMEDIATE")
    .pauseReason("pause_reason2")
    .build();

subscriptionsApi.pauseSubscriptionAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Resume Subscription

Schedules a `RESUME` action to resume a paused or a deactivated subscription.

```java
CompletableFuture<ResumeSubscriptionResponse> resumeSubscriptionAsync(
    final String subscriptionId,
    final ResumeSubscriptionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to resume. |
| `body` | [`ResumeSubscriptionRequest`](/doc/models/resume-subscription-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`ResumeSubscriptionResponse`](/doc/models/resume-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
ResumeSubscriptionRequest body = new ResumeSubscriptionRequest.Builder()
    .resumeEffectiveDate("resume_effective_date4")
    .resumeChangeTiming("IMMEDIATE")
    .build();

subscriptionsApi.resumeSubscriptionAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Swap Plan

Schedules a `SWAP_PLAN` action to swap a subscription plan in an existing subscription.

```java
CompletableFuture<SwapPlanResponse> swapPlanAsync(
    final String subscriptionId,
    final SwapPlanRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to swap the subscription plan for. |
| `body` | [`SwapPlanRequest`](/doc/models/swap-plan-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SwapPlanResponse`](/doc/models/swap-plan-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
SwapPlanRequest body = new SwapPlanRequest.Builder(
        "new_plan_id2")
    .build();

subscriptionsApi.swapPlanAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


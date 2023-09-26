# Subscriptions

```java
SubscriptionsApi subscriptionsApi = client.getSubscriptionsApi();
```

## Class Name

`SubscriptionsApi`

## Methods

* [Create Subscription](../../doc/api/subscriptions.md#create-subscription)
* [Search Subscriptions](../../doc/api/subscriptions.md#search-subscriptions)
* [Retrieve Subscription](../../doc/api/subscriptions.md#retrieve-subscription)
* [Update Subscription](../../doc/api/subscriptions.md#update-subscription)
* [Delete Subscription Action](../../doc/api/subscriptions.md#delete-subscription-action)
* [Cancel Subscription](../../doc/api/subscriptions.md#cancel-subscription)
* [List Subscription Events](../../doc/api/subscriptions.md#list-subscription-events)
* [Pause Subscription](../../doc/api/subscriptions.md#pause-subscription)
* [Resume Subscription](../../doc/api/subscriptions.md#resume-subscription)
* [Swap Plan](../../doc/api/subscriptions.md#swap-plan)


# Create Subscription

Enrolls a customer in a subscription.

If you provide a card on file in the request, Square charges the card for
the subscription. Otherwise, Square sends an invoice to the customer's email
address. The subscription starts immediately, unless the request includes
the optional `start_date`. Each individual subscription is associated with a particular location.

For more information, see [Create a subscription](https://developer.squareup.com/docs/subscriptions-api/manage-subscriptions#create-a-subscription).

```java
CompletableFuture<CreateSubscriptionResponse> createSubscriptionAsync(
    final CreateSubscriptionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateSubscriptionRequest`](../../doc/models/create-subscription-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateSubscriptionResponse`](../../doc/models/create-subscription-response.md)

## Example Usage

```java
CreateSubscriptionRequest body = new CreateSubscriptionRequest.Builder(
    "S8GWD5R9QB376",
    "CHFGVKYY8RSV93M5KCYTG4PN0G"
)
.idempotencyKey("8193148c-9586-11e6-99f9-28cfe92138cf")
.planVariationId("6JHXF3B2CW3YKHDV4XEM674H")
.startDate("2023-06-20")
.cardId("ccof:qy5x8hHGYsgLrp4Q4GB")
.timezone("America/Los_Angeles")
.source(new SubscriptionSource.Builder()
        .name("My Application")
        .build())
.phases(Arrays.asList(
        new Phase.Builder()
            .ordinal(0)
            .orderTemplateId("U2NaowWxzXwpsZU697x7ZHOAnCNZY")
            .build()
    ))
.build();

subscriptionsApi.createSubscriptionAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
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

```java
CompletableFuture<SearchSubscriptionsResponse> searchSubscriptionsAsync(
    final SearchSubscriptionsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchSubscriptionsRequest`](../../doc/models/search-subscriptions-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchSubscriptionsResponse`](../../doc/models/search-subscriptions-response.md)

## Example Usage

```java
SearchSubscriptionsRequest body = new SearchSubscriptionsRequest.Builder()
    .query(new SearchSubscriptionsQuery.Builder()
        .filter(new SearchSubscriptionsFilter.Builder()
            .customerIds(Arrays.asList(
                "CHFGVKYY8RSV93M5KCYTG4PN0G"
            ))
            .locationIds(Arrays.asList(
                "S8GWD5R9QB376"
            ))
            .sourceNames(Arrays.asList(
                "My App"
            ))
            .build())
        .build())
    .build();

subscriptionsApi.searchSubscriptionsAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Subscription

Retrieves a specific subscription.

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

[`RetrieveSubscriptionResponse`](../../doc/models/retrieve-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";

subscriptionsApi.retrieveSubscriptionAsync(subscriptionId, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Update Subscription

Updates a subscription by modifying or clearing `subscription` field values.
To clear a field, set its value to `null`.

```java
CompletableFuture<UpdateSubscriptionResponse> updateSubscriptionAsync(
    final String subscriptionId,
    final UpdateSubscriptionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to update. |
| `body` | [`UpdateSubscriptionRequest`](../../doc/models/update-subscription-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateSubscriptionResponse`](../../doc/models/update-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
UpdateSubscriptionRequest body = new UpdateSubscriptionRequest.Builder()
    .subscription(new Subscription.Builder()
        .canceledDate("canceled_date6")
        .cardId("{NEW CARD ID}")
        .build())
    .build();

subscriptionsApi.updateSubscriptionAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
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

[`DeleteSubscriptionActionResponse`](../../doc/models/delete-subscription-action-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
String actionId = "action_id6";

subscriptionsApi.deleteSubscriptionActionAsync(subscriptionId, actionId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Cancel Subscription

Schedules a `CANCEL` action to cancel an active subscription. This
sets the `canceled_date` field to the end of the active billing period. After this date,
the subscription status changes from ACTIVE to CANCELED.

```java
CompletableFuture<CancelSubscriptionResponse> cancelSubscriptionAsync(
    final String subscriptionId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to cancel. |

## Response Type

[`CancelSubscriptionResponse`](../../doc/models/cancel-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";

subscriptionsApi.cancelSubscriptionAsync(subscriptionId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# List Subscription Events

Lists all [events](https://developer.squareup.com/docs/subscriptions-api/actions-events) for a specific subscription.

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
| `cursor` | `String` | Query, Optional | When the total number of resulting subscription events exceeds the limit of a paged response,<br>specify the cursor returned from a preceding response here to fetch the next set of results.<br>If the cursor is unset, the response contains the last page of the results.<br><br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `limit` | `Integer` | Query, Optional | The upper limit on the number of subscription events to return<br>in a paged response. |

## Response Type

[`ListSubscriptionEventsResponse`](../../doc/models/list-subscription-events-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";

subscriptionsApi.listSubscriptionEventsAsync(subscriptionId, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
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
| `body` | [`PauseSubscriptionRequest`](../../doc/models/pause-subscription-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`PauseSubscriptionResponse`](../../doc/models/pause-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
PauseSubscriptionRequest body = new PauseSubscriptionRequest.Builder()
    .build();

subscriptionsApi.pauseSubscriptionAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
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
| `body` | [`ResumeSubscriptionRequest`](../../doc/models/resume-subscription-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`ResumeSubscriptionResponse`](../../doc/models/resume-subscription-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
ResumeSubscriptionRequest body = new ResumeSubscriptionRequest.Builder()
    .build();

subscriptionsApi.resumeSubscriptionAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Swap Plan

Schedules a `SWAP_PLAN` action to swap a subscription plan variation in an existing subscription.
For more information, see [Swap Subscription Plan Variations](https://developer.squareup.com/docs/subscriptions-api/swap-plan-variations).

```java
CompletableFuture<SwapPlanResponse> swapPlanAsync(
    final String subscriptionId,
    final SwapPlanRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `subscriptionId` | `String` | Template, Required | The ID of the subscription to swap the subscription plan for. |
| `body` | [`SwapPlanRequest`](../../doc/models/swap-plan-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SwapPlanResponse`](../../doc/models/swap-plan-response.md)

## Example Usage

```java
String subscriptionId = "subscription_id0";
SwapPlanRequest body = new SwapPlanRequest.Builder()
    .newPlanVariationId("FQ7CDXXWSLUJRPM3GFJSJGZ7")
    .phases(Arrays.asList(
        new PhaseInput.Builder(
            0
        )
        .orderTemplateId("uhhnjH9osVv3shUADwaC0b3hNxQZY")
        .build()
    ))
    .build();

subscriptionsApi.swapPlanAsync(subscriptionId, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


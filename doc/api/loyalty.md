# Loyalty

```java
LoyaltyApi loyaltyApi = client.getLoyaltyApi();
```

## Class Name

`LoyaltyApi`

## Methods

* [Create Loyalty Account](../../doc/api/loyalty.md#create-loyalty-account)
* [Search Loyalty Accounts](../../doc/api/loyalty.md#search-loyalty-accounts)
* [Retrieve Loyalty Account](../../doc/api/loyalty.md#retrieve-loyalty-account)
* [Accumulate Loyalty Points](../../doc/api/loyalty.md#accumulate-loyalty-points)
* [Adjust Loyalty Points](../../doc/api/loyalty.md#adjust-loyalty-points)
* [Search Loyalty Events](../../doc/api/loyalty.md#search-loyalty-events)
* [List Loyalty Programs](../../doc/api/loyalty.md#list-loyalty-programs)
* [Retrieve Loyalty Program](../../doc/api/loyalty.md#retrieve-loyalty-program)
* [Calculate Loyalty Points](../../doc/api/loyalty.md#calculate-loyalty-points)
* [List Loyalty Promotions](../../doc/api/loyalty.md#list-loyalty-promotions)
* [Create Loyalty Promotion](../../doc/api/loyalty.md#create-loyalty-promotion)
* [Retrieve Loyalty Promotion](../../doc/api/loyalty.md#retrieve-loyalty-promotion)
* [Cancel Loyalty Promotion](../../doc/api/loyalty.md#cancel-loyalty-promotion)
* [Create Loyalty Reward](../../doc/api/loyalty.md#create-loyalty-reward)
* [Search Loyalty Rewards](../../doc/api/loyalty.md#search-loyalty-rewards)
* [Delete Loyalty Reward](../../doc/api/loyalty.md#delete-loyalty-reward)
* [Retrieve Loyalty Reward](../../doc/api/loyalty.md#retrieve-loyalty-reward)
* [Redeem Loyalty Reward](../../doc/api/loyalty.md#redeem-loyalty-reward)


# Create Loyalty Account

Creates a loyalty account. To create a loyalty account, you must provide the `program_id` and a `mapping` with the `phone_number` of the buyer.

```java
CompletableFuture<CreateLoyaltyAccountResponse> createLoyaltyAccountAsync(
    final CreateLoyaltyAccountRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateLoyaltyAccountRequest`](../../doc/models/create-loyalty-account-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateLoyaltyAccountResponse`](../../doc/models/create-loyalty-account-response.md)

## Example Usage

```java
LoyaltyAccountMapping loyaltyAccountMapping = new LoyaltyAccountMapping.Builder()
    .phoneNumber("+14155551234")
    .build();
LoyaltyAccount loyaltyAccount = new LoyaltyAccount.Builder(
        "d619f755-2d17-41f3-990d-c04ecedd64dd")
    .mapping(loyaltyAccountMapping)
    .build();
CreateLoyaltyAccountRequest body = new CreateLoyaltyAccountRequest.Builder(
        loyaltyAccount,
        "ec78c477-b1c3-4899-a209-a4e71337c996")
    .build();

loyaltyApi.createLoyaltyAccountAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Loyalty Accounts

Searches for loyalty accounts in a loyalty program.

You can search for a loyalty account using the phone number or customer ID associated with the account. To return all loyalty accounts, specify an empty `query` object or omit it entirely.

Search results are sorted by `created_at` in ascending order.

```java
CompletableFuture<SearchLoyaltyAccountsResponse> searchLoyaltyAccountsAsync(
    final SearchLoyaltyAccountsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchLoyaltyAccountsRequest`](../../doc/models/search-loyalty-accounts-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchLoyaltyAccountsResponse`](../../doc/models/search-loyalty-accounts-response.md)

## Example Usage

```java
List<LoyaltyAccountMapping> bodyQueryMappings = new LinkedList<>();

LoyaltyAccountMapping bodyQueryMappings0 = new LoyaltyAccountMapping.Builder()
    .phoneNumber("+14155551234")
    .build();
bodyQueryMappings.add(bodyQueryMappings0);

SearchLoyaltyAccountsRequestLoyaltyAccountQuery searchLoyaltyAccountsRequestLoyaltyAccountQuery = new SearchLoyaltyAccountsRequestLoyaltyAccountQuery.Builder()
    .mappings(searchLoyaltyAccountsRequestLoyaltyAccountQueryMappings)
    .build();
SearchLoyaltyAccountsRequest body = new SearchLoyaltyAccountsRequest.Builder()
    .query(bodyQuery)
    .limit(10)
    .build();

loyaltyApi.searchLoyaltyAccountsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Loyalty Account

Retrieves a loyalty account.

```java
CompletableFuture<RetrieveLoyaltyAccountResponse> retrieveLoyaltyAccountAsync(
    final String accountId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `accountId` | `String` | Template, Required | The ID of the [loyalty account](../../doc/models/loyalty-account.md) to retrieve. |

## Response Type

[`RetrieveLoyaltyAccountResponse`](../../doc/models/retrieve-loyalty-account-response.md)

## Example Usage

```java
String accountId = "account_id2";

loyaltyApi.retrieveLoyaltyAccountAsync(accountId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Accumulate Loyalty Points

Adds points earned from a purchase to a [loyalty account](../../doc/models/loyalty-account.md).

- If you are using the Orders API to manage orders, provide the `order_id`. Square reads the order
  to compute the points earned from both the base loyalty program and an associated
  [loyalty promotion](../../doc/models/loyalty-promotion.md). For purchases that qualify for multiple accrual
  rules, Square computes points based on the accrual rule that grants the most points.
  For purchases that qualify for multiple promotions, Square computes points based on the most
  recently created promotion. A purchase must first qualify for program points to be eligible for promotion points.

- If you are not using the Orders API to manage orders, provide `points` with the number of points to add.
  You must first perform a client-side computation of the points earned from the loyalty program and
  loyalty promotion. For spend-based and visit-based programs, you can call [CalculateLoyaltyPoints](../../doc/api/loyalty.md#calculate-loyalty-points)
  to compute the points earned from the base loyalty program. For information about computing points earned from a loyalty promotion, see
  [Calculating promotion points](https://developer.squareup.com/docs/loyalty-api/loyalty-promotions#calculate-promotion-points).

```java
CompletableFuture<AccumulateLoyaltyPointsResponse> accumulateLoyaltyPointsAsync(
    final String accountId,
    final AccumulateLoyaltyPointsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `accountId` | `String` | Template, Required | The ID of the target [loyalty account](../../doc/models/loyalty-account.md). |
| `body` | [`AccumulateLoyaltyPointsRequest`](../../doc/models/accumulate-loyalty-points-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`AccumulateLoyaltyPointsResponse`](../../doc/models/accumulate-loyalty-points-response.md)

## Example Usage

```java
String accountId = "account_id2";
LoyaltyEventAccumulatePoints loyaltyEventAccumulatePoints = new LoyaltyEventAccumulatePoints.Builder()
    .orderId("RFZfrdtm3mhO1oGzf5Cx7fEMsmGZY")
    .build();
AccumulateLoyaltyPointsRequest body = new AccumulateLoyaltyPointsRequest.Builder(
        accumulatePoints,
        "58b90739-c3e8-4b11-85f7-e636d48d72cb",
        "P034NEENMD09F")
    .build();

loyaltyApi.accumulateLoyaltyPointsAsync(accountId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Adjust Loyalty Points

Adds points to or subtracts points from a buyer's account.

Use this endpoint only when you need to manually adjust points. Otherwise, in your application flow, you call
[AccumulateLoyaltyPoints](../../doc/api/loyalty.md#accumulate-loyalty-points)
to add points when a buyer pays for the purchase.

```java
CompletableFuture<AdjustLoyaltyPointsResponse> adjustLoyaltyPointsAsync(
    final String accountId,
    final AdjustLoyaltyPointsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `accountId` | `String` | Template, Required | The ID of the target [loyalty account](../../doc/models/loyalty-account.md). |
| `body` | [`AdjustLoyaltyPointsRequest`](../../doc/models/adjust-loyalty-points-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`AdjustLoyaltyPointsResponse`](../../doc/models/adjust-loyalty-points-response.md)

## Example Usage

```java
String accountId = "account_id2";
LoyaltyEventAdjustPoints loyaltyEventAdjustPoints = new LoyaltyEventAdjustPoints.Builder(
        10)
    .reason("Complimentary points")
    .build();
AdjustLoyaltyPointsRequest body = new AdjustLoyaltyPointsRequest.Builder(
        "bc29a517-3dc9-450e-aa76-fae39ee849d1",
        adjustPoints)
    .build();

loyaltyApi.adjustLoyaltyPointsAsync(accountId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Loyalty Events

Searches for loyalty events.

A Square loyalty program maintains a ledger of events that occur during the lifetime of a
buyer's loyalty account. Each change in the point balance
(for example, points earned, points redeemed, and points expired) is
recorded in the ledger. Using this endpoint, you can search the ledger for events.

Search results are sorted by `created_at` in descending order.

```java
CompletableFuture<SearchLoyaltyEventsResponse> searchLoyaltyEventsAsync(
    final SearchLoyaltyEventsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchLoyaltyEventsRequest`](../../doc/models/search-loyalty-events-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchLoyaltyEventsResponse`](../../doc/models/search-loyalty-events-response.md)

## Example Usage

```java
LoyaltyEventOrderFilter loyaltyEventOrderFilter = new LoyaltyEventOrderFilter.Builder(
        "PyATxhYLfsMqpVkcKJITPydgEYfZY")
    .build();
LoyaltyEventFilter loyaltyEventFilter = new LoyaltyEventFilter.Builder()
    .orderFilter(loyaltyEventFilterOrderFilter)
    .build();
LoyaltyEventQuery loyaltyEventQuery = new LoyaltyEventQuery.Builder()
    .filter(loyaltyEventQueryFilter)
    .build();
SearchLoyaltyEventsRequest body = new SearchLoyaltyEventsRequest.Builder()
    .query(bodyQuery)
    .limit(30)
    .build();

loyaltyApi.searchLoyaltyEventsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Loyalty Programs

**This endpoint is deprecated.**

Returns a list of loyalty programs in the seller's account.
Loyalty programs define how buyers can earn points and redeem points for rewards. Square sellers can have only one loyalty program, which is created and managed from the Seller Dashboard. For more information, see [Loyalty Program Overview](https://developer.squareup.com/docs/loyalty/overview).

Replaced with [RetrieveLoyaltyProgram](../../doc/api/loyalty.md#retrieve-loyalty-program) when used with the keyword `main`.

```java
CompletableFuture<ListLoyaltyProgramsResponse> listLoyaltyProgramsAsync()
```

## Response Type

[`ListLoyaltyProgramsResponse`](../../doc/models/list-loyalty-programs-response.md)

## Example Usage

```java
loyaltyApi.listLoyaltyProgramsAsync().thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Loyalty Program

Retrieves the loyalty program in a seller's account, specified by the program ID or the keyword `main`.

Loyalty programs define how buyers can earn points and redeem points for rewards. Square sellers can have only one loyalty program, which is created and managed from the Seller Dashboard. For more information, see [Loyalty Program Overview](https://developer.squareup.com/docs/loyalty/overview).

```java
CompletableFuture<RetrieveLoyaltyProgramResponse> retrieveLoyaltyProgramAsync(
    final String programId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `programId` | `String` | Template, Required | The ID of the loyalty program or the keyword `main`. Either value can be used to retrieve the single loyalty program that belongs to the seller. |

## Response Type

[`RetrieveLoyaltyProgramResponse`](../../doc/models/retrieve-loyalty-program-response.md)

## Example Usage

```java
String programId = "program_id0";

loyaltyApi.retrieveLoyaltyProgramAsync(programId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Calculate Loyalty Points

Calculates the number of points a buyer can earn from a purchase. Applications might call this endpoint
to display the points to the buyer.

- If you are using the Orders API to manage orders, provide the `order_id` and (optional) `loyalty_account_id`.
  Square reads the order to compute the points earned from the base loyalty program and an associated
  [loyalty promotion](../../doc/models/loyalty-promotion.md).

- If you are not using the Orders API to manage orders, provide `transaction_amount_money` with the
  purchase amount. Square uses this amount to calculate the points earned from the base loyalty program,
  but not points earned from a loyalty promotion. For spend-based and visit-based programs, the `tax_mode`
  setting of the accrual rule indicates how taxes should be treated for loyalty points accrual.
  If the purchase qualifies for program points, call
  [ListLoyaltyPromotions](../../doc/api/loyalty.md#list-loyalty-promotions) and perform a client-side computation
  to calculate whether the purchase also qualifies for promotion points. For more information, see
  [Calculating promotion points](https://developer.squareup.com/docs/loyalty-api/loyalty-promotions#calculate-promotion-points).

```java
CompletableFuture<CalculateLoyaltyPointsResponse> calculateLoyaltyPointsAsync(
    final String programId,
    final CalculateLoyaltyPointsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `programId` | `String` | Template, Required | The ID of the [loyalty program](../../doc/models/loyalty-program.md), which defines the rules for accruing points. |
| `body` | [`CalculateLoyaltyPointsRequest`](../../doc/models/calculate-loyalty-points-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CalculateLoyaltyPointsResponse`](../../doc/models/calculate-loyalty-points-response.md)

## Example Usage

```java
String programId = "program_id0";
CalculateLoyaltyPointsRequest body = new CalculateLoyaltyPointsRequest.Builder()
    .orderId("RFZfrdtm3mhO1oGzf5Cx7fEMsmGZY")
    .loyaltyAccountId("79b807d2-d786-46a9-933b-918028d7a8c5")
    .build();

loyaltyApi.calculateLoyaltyPointsAsync(programId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Loyalty Promotions

Lists the loyalty promotions associated with a [loyalty program](../../doc/models/loyalty-program.md).
Results are sorted by the `created_at` date in descending order (newest to oldest).

```java
CompletableFuture<ListLoyaltyPromotionsResponse> listLoyaltyPromotionsAsync(
    final String programId,
    final String status,
    final String cursor,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `programId` | `String` | Template, Required | The ID of the base [loyalty program](../../doc/models/loyalty-program.md). To get the program ID,<br>call [RetrieveLoyaltyProgram](../../doc/api/loyalty.md#retrieve-loyalty-program) using the `main` keyword. |
| `status` | [`String`](../../doc/models/loyalty-promotion-status.md) | Query, Optional | The status to filter the results by. If a status is provided, only loyalty promotions<br>with the specified status are returned. Otherwise, all loyalty promotions associated with<br>the loyalty program are returned. |
| `cursor` | `String` | Query, Optional | The cursor returned in the paged response from the previous call to this endpoint.<br>Provide this cursor to retrieve the next page of results for your original request.<br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `limit` | `Integer` | Query, Optional | The maximum number of results to return in a single paged response.<br>The minimum value is 1 and the maximum value is 30. The default value is 30.<br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |

## Response Type

[`ListLoyaltyPromotionsResponse`](../../doc/models/list-loyalty-promotions-response.md)

## Example Usage

```java
String programId = "program_id0";

loyaltyApi.listLoyaltyPromotionsAsync(programId, null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Loyalty Promotion

Creates a loyalty promotion for a [loyalty program](../../doc/models/loyalty-program.md). A loyalty promotion
enables buyers to earn points in addition to those earned from the base loyalty program.

This endpoint sets the loyalty promotion to the `ACTIVE` or `SCHEDULED` status, depending on the
`available_time` setting. A loyalty program can have a maximum of 10 loyalty promotions with an
`ACTIVE` or `SCHEDULED` status.

```java
CompletableFuture<CreateLoyaltyPromotionResponse> createLoyaltyPromotionAsync(
    final String programId,
    final CreateLoyaltyPromotionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `programId` | `String` | Template, Required | The ID of the [loyalty program](../../doc/models/loyalty-program.md) to associate with the promotion.<br>To get the program ID, call [RetrieveLoyaltyProgram](../../doc/api/loyalty.md#retrieve-loyalty-program)<br>using the `main` keyword. |
| `body` | [`CreateLoyaltyPromotionRequest`](../../doc/models/create-loyalty-promotion-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateLoyaltyPromotionResponse`](../../doc/models/create-loyalty-promotion-response.md)

## Example Usage

```java
String programId = "program_id0";
LoyaltyPromotionIncentivePointsMultiplierData loyaltyPromotionIncentivePointsMultiplierData = new LoyaltyPromotionIncentivePointsMultiplierData.Builder(
        3)
    .build();
LoyaltyPromotionIncentive loyaltyPromotionIncentive = new LoyaltyPromotionIncentive.Builder(
        "POINTS_MULTIPLIER")
    .pointsMultiplierData(loyaltyPromotionIncentivePointsMultiplierData)
    .build();
List<String> bodyLoyaltyPromotionAvailableTimeTimePeriods = new LinkedList<>();
bodyLoyaltyPromotionAvailableTimeTimePeriods.add("BEGIN:VEVENT\\nDTSTART:20220816T160000\\nDURATION:PT2H\\nRRULE:FREQ=WEEKLY;BYDAY=TU\\nEND:VEVENT");
LoyaltyPromotionAvailableTimeData loyaltyPromotionAvailableTimeData = new LoyaltyPromotionAvailableTimeData.Builder(
        loyaltyPromotionAvailableTimeDataTimePeriods)
    .build();
LoyaltyPromotionTriggerLimit loyaltyPromotionTriggerLimit = new LoyaltyPromotionTriggerLimit.Builder(
        1)
    .interval("DAY")
    .build();
LoyaltyPromotion loyaltyPromotion = new LoyaltyPromotion.Builder(
        "Tuesday Happy Hour Promo",
        incentive,
        availableTime)
    .triggerLimit(loyaltyPromotionTriggerLimit)
    .build();
CreateLoyaltyPromotionRequest body = new CreateLoyaltyPromotionRequest.Builder(
        loyaltyPromotion,
        "ec78c477-b1c3-4899-a209-a4e71337c996")
    .build();

loyaltyApi.createLoyaltyPromotionAsync(programId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Loyalty Promotion

Retrieves a loyalty promotion.

```java
CompletableFuture<RetrieveLoyaltyPromotionResponse> retrieveLoyaltyPromotionAsync(
    final String promotionId,
    final String programId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `promotionId` | `String` | Template, Required | The ID of the [loyalty promotion](../../doc/models/loyalty-promotion.md) to retrieve. |
| `programId` | `String` | Template, Required | The ID of the base [loyalty program](../../doc/models/loyalty-program.md). To get the program ID,<br>call [RetrieveLoyaltyProgram](../../doc/api/loyalty.md#retrieve-loyalty-program) using the `main` keyword. |

## Response Type

[`RetrieveLoyaltyPromotionResponse`](../../doc/models/retrieve-loyalty-promotion-response.md)

## Example Usage

```java
String promotionId = "promotion_id0";
String programId = "program_id0";

loyaltyApi.retrieveLoyaltyPromotionAsync(promotionId, programId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Cancel Loyalty Promotion

Cancels a loyalty promotion. Use this endpoint to cancel an `ACTIVE` promotion earlier than the
end date, cancel an `ACTIVE` promotion when an end date is not specified, or cancel a `SCHEDULED` promotion.
Because updating a promotion is not supported, you can also use this endpoint to cancel a promotion before
you create a new one.

This endpoint sets the loyalty promotion to the `CANCELED` state

```java
CompletableFuture<CancelLoyaltyPromotionResponse> cancelLoyaltyPromotionAsync(
    final String promotionId,
    final String programId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `promotionId` | `String` | Template, Required | The ID of the [loyalty promotion](../../doc/models/loyalty-promotion.md) to cancel. You can cancel a<br>promotion that has an `ACTIVE` or `SCHEDULED` status. |
| `programId` | `String` | Template, Required | The ID of the base [loyalty program](../../doc/models/loyalty-program.md). |

## Response Type

[`CancelLoyaltyPromotionResponse`](../../doc/models/cancel-loyalty-promotion-response.md)

## Example Usage

```java
String promotionId = "promotion_id0";
String programId = "program_id0";

loyaltyApi.cancelLoyaltyPromotionAsync(promotionId, programId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Loyalty Reward

Creates a loyalty reward. In the process, the endpoint does following:

- Uses the `reward_tier_id` in the request to determine the number of points
  to lock for this reward.
- If the request includes `order_id`, it adds the reward and related discount to the order.

After a reward is created, the points are locked and
not available for the buyer to redeem another reward.

```java
CompletableFuture<CreateLoyaltyRewardResponse> createLoyaltyRewardAsync(
    final CreateLoyaltyRewardRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateLoyaltyRewardRequest`](../../doc/models/create-loyalty-reward-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateLoyaltyRewardResponse`](../../doc/models/create-loyalty-reward-response.md)

## Example Usage

```java
LoyaltyReward loyaltyReward = new LoyaltyReward.Builder(
        "5adcb100-07f1-4ee7-b8c6-6bb9ebc474bd",
        "e1b39225-9da5-43d1-a5db-782cdd8ad94f")
    .orderId("RFZfrdtm3mhO1oGzf5Cx7fEMsmGZY")
    .build();
CreateLoyaltyRewardRequest body = new CreateLoyaltyRewardRequest.Builder(
        reward,
        "18c2e5ea-a620-4b1f-ad60-7b167285e451")
    .build();

loyaltyApi.createLoyaltyRewardAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Loyalty Rewards

Searches for loyalty rewards. This endpoint accepts a request with no query filters and returns results for all loyalty accounts.
If you include a `query` object, `loyalty_account_id` is required and `status` is  optional.

If you know a reward ID, use the
[RetrieveLoyaltyReward](../../doc/api/loyalty.md#retrieve-loyalty-reward) endpoint.

Search results are sorted by `updated_at` in descending order.

```java
CompletableFuture<SearchLoyaltyRewardsResponse> searchLoyaltyRewardsAsync(
    final SearchLoyaltyRewardsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchLoyaltyRewardsRequest`](../../doc/models/search-loyalty-rewards-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchLoyaltyRewardsResponse`](../../doc/models/search-loyalty-rewards-response.md)

## Example Usage

```java
SearchLoyaltyRewardsRequestLoyaltyRewardQuery searchLoyaltyRewardsRequestLoyaltyRewardQuery = new SearchLoyaltyRewardsRequestLoyaltyRewardQuery.Builder(
        "5adcb100-07f1-4ee7-b8c6-6bb9ebc474bd")
    .build();
SearchLoyaltyRewardsRequest body = new SearchLoyaltyRewardsRequest.Builder()
    .query(bodyQuery)
    .limit(10)
    .build();

loyaltyApi.searchLoyaltyRewardsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Loyalty Reward

Deletes a loyalty reward by doing the following:

- Returns the loyalty points back to the loyalty account.
- If an order ID was specified when the reward was created
  (see [CreateLoyaltyReward](../../doc/api/loyalty.md#create-loyalty-reward)),
  it updates the order by removing the reward and related
  discounts.

You cannot delete a reward that has reached the terminal state (REDEEMED).

```java
CompletableFuture<DeleteLoyaltyRewardResponse> deleteLoyaltyRewardAsync(
    final String rewardId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `rewardId` | `String` | Template, Required | The ID of the [loyalty reward](../../doc/models/loyalty-reward.md) to delete. |

## Response Type

[`DeleteLoyaltyRewardResponse`](../../doc/models/delete-loyalty-reward-response.md)

## Example Usage

```java
String rewardId = "reward_id4";

loyaltyApi.deleteLoyaltyRewardAsync(rewardId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Loyalty Reward

Retrieves a loyalty reward.

```java
CompletableFuture<RetrieveLoyaltyRewardResponse> retrieveLoyaltyRewardAsync(
    final String rewardId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `rewardId` | `String` | Template, Required | The ID of the [loyalty reward](../../doc/models/loyalty-reward.md) to retrieve. |

## Response Type

[`RetrieveLoyaltyRewardResponse`](../../doc/models/retrieve-loyalty-reward-response.md)

## Example Usage

```java
String rewardId = "reward_id4";

loyaltyApi.retrieveLoyaltyRewardAsync(rewardId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Redeem Loyalty Reward

Redeems a loyalty reward.

The endpoint sets the reward to the `REDEEMED` terminal state.

If you are using your own order processing system (not using the
Orders API), you call this endpoint after the buyer paid for the
purchase.

After the reward reaches the terminal state, it cannot be deleted.
In other words, points used for the reward cannot be returned
to the account.

```java
CompletableFuture<RedeemLoyaltyRewardResponse> redeemLoyaltyRewardAsync(
    final String rewardId,
    final RedeemLoyaltyRewardRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `rewardId` | `String` | Template, Required | The ID of the [loyalty reward](../../doc/models/loyalty-reward.md) to redeem. |
| `body` | [`RedeemLoyaltyRewardRequest`](../../doc/models/redeem-loyalty-reward-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`RedeemLoyaltyRewardResponse`](../../doc/models/redeem-loyalty-reward-response.md)

## Example Usage

```java
String rewardId = "reward_id4";
RedeemLoyaltyRewardRequest body = new RedeemLoyaltyRewardRequest.Builder(
        "98adc7f7-6963-473b-b29c-f3c9cdd7d994",
        "P034NEENMD09F")
    .build();

loyaltyApi.redeemLoyaltyRewardAsync(rewardId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


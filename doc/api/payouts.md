# Payouts

```java
PayoutsApi payoutsApi = client.getPayoutsApi();
```

## Class Name

`PayoutsApi`

## Methods

* [List Payouts](../../doc/api/payouts.md#list-payouts)
* [Get Payout](../../doc/api/payouts.md#get-payout)
* [List Payout Entries](../../doc/api/payouts.md#list-payout-entries)


# List Payouts

Retrieves a list of all payouts for the default location.
You can filter payouts by location ID, status, time range, and order them in ascending or descending order.
To call this endpoint, set `PAYOUTS_READ` for the OAuth scope.

```java
CompletableFuture<ListPayoutsResponse> listPayoutsAsync(
    final String locationId,
    final String status,
    final String beginTime,
    final String endTime,
    final String sortOrder,
    final String cursor,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Query, Optional | The ID of the location for which to list the payouts.<br>By default, payouts are returned for the default (main) location associated with the seller. |
| `status` | [`String`](../../doc/models/payout-status.md) | Query, Optional | If provided, only payouts with the given status are returned. |
| `beginTime` | `String` | Query, Optional | The timestamp for the beginning of the payout creation time, in RFC 3339 format.<br>Inclusive. Default: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The timestamp for the end of the payout creation time, in RFC 3339 format.<br>Default: The current time. |
| `sortOrder` | [`String`](../../doc/models/sort-order.md) | Query, Optional | The order in which payouts are listed. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>For more information, see [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).<br>If request parameters change between requests, subsequent results may contain duplicates or missing records. |
| `limit` | `Integer` | Query, Optional | The maximum number of results to be returned in a single page.<br>It is possible to receive fewer results than the specified limit on a given page.<br>The default value of 100 is also the maximum allowed value. If the provided value is<br>greater than 100, it is ignored and the default value is used instead.<br>Default: `100` |

## Response Type

[`ListPayoutsResponse`](../../doc/models/list-payouts-response.md)

## Example Usage

```java
payoutsApi.listPayoutsAsync(null, null, null, null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Payout

Retrieves details of a specific payout identified by a payout ID.
To call this endpoint, set `PAYOUTS_READ` for the OAuth scope.

```java
CompletableFuture<GetPayoutResponse> getPayoutAsync(
    final String payoutId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `payoutId` | `String` | Template, Required | The ID of the payout to retrieve the information for. |

## Response Type

[`GetPayoutResponse`](../../doc/models/get-payout-response.md)

## Example Usage

```java
String payoutId = "payout_id6";

payoutsApi.getPayoutAsync(payoutId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Payout Entries

Retrieves a list of all payout entries for a specific payout.
To call this endpoint, set `PAYOUTS_READ` for the OAuth scope.

```java
CompletableFuture<ListPayoutEntriesResponse> listPayoutEntriesAsync(
    final String payoutId,
    final String sortOrder,
    final String cursor,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `payoutId` | `String` | Template, Required | The ID of the payout to retrieve the information for. |
| `sortOrder` | [`String`](../../doc/models/sort-order.md) | Query, Optional | The order in which payout entries are listed. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>For more information, see [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).<br>If request parameters change between requests, subsequent results may contain duplicates or missing records. |
| `limit` | `Integer` | Query, Optional | The maximum number of results to be returned in a single page.<br>It is possible to receive fewer results than the specified limit on a given page.<br>The default value of 100 is also the maximum allowed value. If the provided value is<br>greater than 100, it is ignored and the default value is used instead.<br>Default: `100` |

## Response Type

[`ListPayoutEntriesResponse`](../../doc/models/list-payout-entries-response.md)

## Example Usage

```java
String payoutId = "payout_id6";

payoutsApi.listPayoutEntriesAsync(payoutId, null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


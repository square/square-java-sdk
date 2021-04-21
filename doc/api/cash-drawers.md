# Cash Drawers

```java
CashDrawersApi cashDrawersApi = client.getCashDrawersApi();
```

## Class Name

`CashDrawersApi`

## Methods

* [List Cash Drawer Shifts](/doc/api/cash-drawers.md#list-cash-drawer-shifts)
* [Retrieve Cash Drawer Shift](/doc/api/cash-drawers.md#retrieve-cash-drawer-shift)
* [List Cash Drawer Shift Events](/doc/api/cash-drawers.md#list-cash-drawer-shift-events)


# List Cash Drawer Shifts

Provides the details for all of the cash drawer shifts for a location
in a date range.

```java
CompletableFuture<ListCashDrawerShiftsResponse> listCashDrawerShiftsAsync(
    final String locationId,
    final String sortOrder,
    final String beginTime,
    final String endTime,
    final Integer limit,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Query, Required | The ID of the location to query for a list of cash drawer shifts. |
| `sortOrder` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which cash drawer shifts are listed in the response,<br>based on their opened_at field. Default value: ASC |
| `beginTime` | `String` | Query, Optional | The inclusive start time of the query on opened_at, in ISO 8601 format. |
| `endTime` | `String` | Query, Optional | The exclusive end date of the query on opened_at, in ISO 8601 format. |
| `limit` | `Integer` | Query, Optional | Number of cash drawer shift events in a page of results (200 by<br>default, 1000 max). |
| `cursor` | `String` | Query, Optional | Opaque cursor for fetching the next page of results. |

## Response Type

[`ListCashDrawerShiftsResponse`](/doc/models/list-cash-drawer-shifts-response.md)

## Example Usage

```java
String locationId = "location_id4";
String sortOrder = "DESC";
String beginTime = "begin_time2";
String endTime = "end_time2";
Integer limit = 172;
String cursor = "cursor6";

cashDrawersApi.listCashDrawerShiftsAsync(locationId, sortOrder, beginTime, endTime, limit, cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Cash Drawer Shift

Provides the summary details for a single cash drawer shift. See
[ListCashDrawerShiftEvents](/doc/api/cash-drawers.md#list-cash-drawer-shift-events) for a list of cash drawer shift events.

```java
CompletableFuture<RetrieveCashDrawerShiftResponse> retrieveCashDrawerShiftAsync(
    final String locationId,
    final String shiftId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Query, Required | The ID of the location to retrieve cash drawer shifts from. |
| `shiftId` | `String` | Template, Required | The shift ID. |

## Response Type

[`RetrieveCashDrawerShiftResponse`](/doc/models/retrieve-cash-drawer-shift-response.md)

## Example Usage

```java
String locationId = "location_id4";
String shiftId = "shift_id0";

cashDrawersApi.retrieveCashDrawerShiftAsync(locationId, shiftId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Cash Drawer Shift Events

Provides a paginated list of events for a single cash drawer shift.

```java
CompletableFuture<ListCashDrawerShiftEventsResponse> listCashDrawerShiftEventsAsync(
    final String locationId,
    final String shiftId,
    final Integer limit,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Query, Required | The ID of the location to list cash drawer shifts for. |
| `shiftId` | `String` | Template, Required | The shift ID. |
| `limit` | `Integer` | Query, Optional | Number of resources to be returned in a page of results (200 by<br>default, 1000 max). |
| `cursor` | `String` | Query, Optional | Opaque cursor for fetching the next page of results. |

## Response Type

[`ListCashDrawerShiftEventsResponse`](/doc/models/list-cash-drawer-shift-events-response.md)

## Example Usage

```java
String locationId = "location_id4";
String shiftId = "shift_id0";
Integer limit = 172;
String cursor = "cursor6";

cashDrawersApi.listCashDrawerShiftEventsAsync(locationId, shiftId, limit, cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


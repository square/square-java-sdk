# Labor

```java
LaborApi laborApi = client.getLaborApi();
```

## Class Name

`LaborApi`

## Methods

* [List Break Types](../../doc/api/labor.md#list-break-types)
* [Create Break Type](../../doc/api/labor.md#create-break-type)
* [Delete Break Type](../../doc/api/labor.md#delete-break-type)
* [Get Break Type](../../doc/api/labor.md#get-break-type)
* [Update Break Type](../../doc/api/labor.md#update-break-type)
* [List Employee Wages](../../doc/api/labor.md#list-employee-wages)
* [Get Employee Wage](../../doc/api/labor.md#get-employee-wage)
* [Create Shift](../../doc/api/labor.md#create-shift)
* [Search Shifts](../../doc/api/labor.md#search-shifts)
* [Delete Shift](../../doc/api/labor.md#delete-shift)
* [Get Shift](../../doc/api/labor.md#get-shift)
* [Update Shift](../../doc/api/labor.md#update-shift)
* [List Team Member Wages](../../doc/api/labor.md#list-team-member-wages)
* [Get Team Member Wage](../../doc/api/labor.md#get-team-member-wage)
* [List Workweek Configs](../../doc/api/labor.md#list-workweek-configs)
* [Update Workweek Config](../../doc/api/labor.md#update-workweek-config)


# List Break Types

Returns a paginated list of `BreakType` instances for a business.

```java
CompletableFuture<ListBreakTypesResponse> listBreakTypesAsync(
    final String locationId,
    final Integer limit,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Query, Optional | Filter the returned `BreakType` results to only those that are associated with the<br>specified location. |
| `limit` | `Integer` | Query, Optional | The maximum number of `BreakType` results to return per page. The number can range between 1<br>and 200. The default is 200. |
| `cursor` | `String` | Query, Optional | A pointer to the next page of `BreakType` results to fetch. |

## Response Type

[`ListBreakTypesResponse`](../../doc/models/list-break-types-response.md)

## Example Usage

```java
laborApi.listBreakTypesAsync(null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Break Type

Creates a new `BreakType`.

A `BreakType` is a template for creating `Break` objects.
You must provide the following values in your request to this
endpoint:

- `location_id`
- `break_name`
- `expected_duration`
- `is_paid`

You can only have three `BreakType` instances per location. If you attempt to add a fourth
`BreakType` for a location, an `INVALID_REQUEST_ERROR` "Exceeded limit of 3 breaks per location."
is returned.

```java
CompletableFuture<CreateBreakTypeResponse> createBreakTypeAsync(
    final CreateBreakTypeRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateBreakTypeRequest`](../../doc/models/create-break-type-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateBreakTypeResponse`](../../doc/models/create-break-type-response.md)

## Example Usage

```java
BreakType breakType = new BreakType.Builder(
        "CGJN03P1D08GF",
        "Lunch Break",
        "PT30M",
        true)
    .build();
CreateBreakTypeRequest body = new CreateBreakTypeRequest.Builder(
        breakType)
    .idempotencyKey("PAD3NG5KSN2GL")
    .build();

laborApi.createBreakTypeAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Break Type

Deletes an existing `BreakType`.

A `BreakType` can be deleted even if it is referenced from a `Shift`.

```java
CompletableFuture<DeleteBreakTypeResponse> deleteBreakTypeAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The UUID for the `BreakType` being deleted. |

## Response Type

[`DeleteBreakTypeResponse`](../../doc/models/delete-break-type-response.md)

## Example Usage

```java
String id = "id0";

laborApi.deleteBreakTypeAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Break Type

Returns a single `BreakType` specified by `id`.

```java
CompletableFuture<GetBreakTypeResponse> getBreakTypeAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The UUID for the `BreakType` being retrieved. |

## Response Type

[`GetBreakTypeResponse`](../../doc/models/get-break-type-response.md)

## Example Usage

```java
String id = "id0";

laborApi.getBreakTypeAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Break Type

Updates an existing `BreakType`.

```java
CompletableFuture<UpdateBreakTypeResponse> updateBreakTypeAsync(
    final String id,
    final UpdateBreakTypeRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The UUID for the `BreakType` being updated. |
| `body` | [`UpdateBreakTypeRequest`](../../doc/models/update-break-type-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateBreakTypeResponse`](../../doc/models/update-break-type-response.md)

## Example Usage

```java
String id = "id0";
BreakType breakType = new BreakType.Builder(
        "26M7H24AZ9N6R",
        "Lunch",
        "PT50M",
        true)
    .version(1)
    .build();
UpdateBreakTypeRequest body = new UpdateBreakTypeRequest.Builder(
        breakType)
    .build();

laborApi.updateBreakTypeAsync(id, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Employee Wages

**This endpoint is deprecated.**

Returns a paginated list of `EmployeeWage` instances for a business.

```java
CompletableFuture<ListEmployeeWagesResponse> listEmployeeWagesAsync(
    final String employeeId,
    final Integer limit,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `employeeId` | `String` | Query, Optional | Filter the returned wages to only those that are associated with the specified employee. |
| `limit` | `Integer` | Query, Optional | The maximum number of `EmployeeWage` results to return per page. The number can range between<br>1 and 200. The default is 200. |
| `cursor` | `String` | Query, Optional | A pointer to the next page of `EmployeeWage` results to fetch. |

## Response Type

[`ListEmployeeWagesResponse`](../../doc/models/list-employee-wages-response.md)

## Example Usage

```java
laborApi.listEmployeeWagesAsync(null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Employee Wage

**This endpoint is deprecated.**

Returns a single `EmployeeWage` specified by `id`.

```java
CompletableFuture<GetEmployeeWageResponse> getEmployeeWageAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The UUID for the `EmployeeWage` being retrieved. |

## Response Type

[`GetEmployeeWageResponse`](../../doc/models/get-employee-wage-response.md)

## Example Usage

```java
String id = "id0";

laborApi.getEmployeeWageAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Shift

Creates a new `Shift`.

A `Shift` represents a complete workday for a single employee.
You must provide the following values in your request to this
endpoint:

- `location_id`
- `employee_id`
- `start_at`

An attempt to create a new `Shift` can result in a `BAD_REQUEST` error when:

- The `status` of the new `Shift` is `OPEN` and the employee has another
  shift with an `OPEN` status.
- The `start_at` date is in the future.
- The `start_at` or `end_at` date overlaps another shift for the same employee.
- The `Break` instances are set in the request and a break `start_at`
  is before the `Shift.start_at`, a break `end_at` is after
  the `Shift.end_at`, or both.

```java
CompletableFuture<CreateShiftResponse> createShiftAsync(
    final CreateShiftRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateShiftRequest`](../../doc/models/create-shift-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateShiftResponse`](../../doc/models/create-shift-response.md)

## Example Usage

```java
Money money = new Money.Builder()
    .amount(1100L)
    .currency("USD")
    .build();
ShiftWage shiftWage = new ShiftWage.Builder()
    .title("Barista")
    .hourlyRate(shiftWageHourlyRate)
    .build();
List<Break> bodyShiftBreaks = new LinkedList<>();

Break bodyShiftBreaks0 = new Break.Builder(
        "2019-01-25T11:11:00+00:00",
        "REGS1EQR1TPZ5",
        "Tea Break",
        "PT5M",
        true)
    .endAt("2019-01-25T11:16:00+00:00")
    .build();
bodyShiftBreaks.add(bodyShiftBreaks0);

Shift shift = new Shift.Builder(
        "2019-01-25T08:11:00+00:00")
    .locationId("PAA1RJZZKXBFG")
    .endAt("2019-01-25T18:11:00+00:00")
    .wage(shiftWage)
    .breaks(shiftBreaks)
    .teamMemberId("ormj0jJJZ5OZIzxrZYJI")
    .build();
CreateShiftRequest body = new CreateShiftRequest.Builder(
        shift)
    .idempotencyKey("HIDSNG5KS478L")
    .build();

laborApi.createShiftAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Shifts

Returns a paginated list of `Shift` records for a business.
The list to be returned can be filtered by:

- Location IDs.
- Employee IDs.
- Shift status (`OPEN` and `CLOSED`).
- Shift start.
- Shift end.
- Workday details.

The list can be sorted by:

- `start_at`.
- `end_at`.
- `created_at`.
- `updated_at`.

```java
CompletableFuture<SearchShiftsResponse> searchShiftsAsync(
    final SearchShiftsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchShiftsRequest`](../../doc/models/search-shifts-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchShiftsResponse`](../../doc/models/search-shifts-response.md)

## Example Usage

```java
DateRange dateRange = new DateRange.Builder()
    .startDate("2019-01-20")
    .endDate("2019-02-03")
    .build();
ShiftWorkday shiftWorkday = new ShiftWorkday.Builder()
    .dateRange(shiftWorkdayDateRange)
    .matchShiftsBy("START_AT")
    .defaultTimezone("America/Los_Angeles")
    .build();
ShiftFilter shiftFilter = new ShiftFilter.Builder()
    .workday(shiftFilterWorkday)
    .build();
ShiftQuery shiftQuery = new ShiftQuery.Builder()
    .filter(shiftQueryFilter)
    .build();
SearchShiftsRequest body = new SearchShiftsRequest.Builder()
    .query(bodyQuery)
    .limit(100)
    .build();

laborApi.searchShiftsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Shift

Deletes a `Shift`.

```java
CompletableFuture<DeleteShiftResponse> deleteShiftAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The UUID for the `Shift` being deleted. |

## Response Type

[`DeleteShiftResponse`](../../doc/models/delete-shift-response.md)

## Example Usage

```java
String id = "id0";

laborApi.deleteShiftAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Shift

Returns a single `Shift` specified by `id`.

```java
CompletableFuture<GetShiftResponse> getShiftAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The UUID for the `Shift` being retrieved. |

## Response Type

[`GetShiftResponse`](../../doc/models/get-shift-response.md)

## Example Usage

```java
String id = "id0";

laborApi.getShiftAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Shift

Updates an existing `Shift`.

When adding a `Break` to a `Shift`, any earlier `Break` instances in the `Shift` have
the `end_at` property set to a valid RFC-3339 datetime string.

When closing a `Shift`, all `Break` instances in the `Shift` must be complete with `end_at`
set on each `Break`.

```java
CompletableFuture<UpdateShiftResponse> updateShiftAsync(
    final String id,
    final UpdateShiftRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The ID of the object being updated. |
| `body` | [`UpdateShiftRequest`](../../doc/models/update-shift-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateShiftResponse`](../../doc/models/update-shift-response.md)

## Example Usage

```java
String id = "id0";
Money money = new Money.Builder()
    .amount(1500L)
    .currency("USD")
    .build();
ShiftWage shiftWage = new ShiftWage.Builder()
    .title("Bartender")
    .hourlyRate(shiftWageHourlyRate)
    .build();
List<Break> bodyShiftBreaks = new LinkedList<>();

Break bodyShiftBreaks0 = new Break.Builder(
        "2019-01-25T11:11:00+00:00",
        "REGS1EQR1TPZ5",
        "Tea Break",
        "PT5M",
        true)
    .id("X7GAQYVVRRG6P")
    .endAt("2019-01-25T11:16:00+00:00")
    .build();
bodyShiftBreaks.add(bodyShiftBreaks0);

Shift shift = new Shift.Builder(
        "2019-01-25T08:11:00+00:00")
    .locationId("PAA1RJZZKXBFG")
    .endAt("2019-01-25T18:11:00+00:00")
    .wage(shiftWage)
    .breaks(shiftBreaks)
    .version(1)
    .teamMemberId("ormj0jJJZ5OZIzxrZYJI")
    .build();
UpdateShiftRequest body = new UpdateShiftRequest.Builder(
        shift)
    .build();

laborApi.updateShiftAsync(id, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Team Member Wages

Returns a paginated list of `TeamMemberWage` instances for a business.

```java
CompletableFuture<ListTeamMemberWagesResponse> listTeamMemberWagesAsync(
    final String teamMemberId,
    final Integer limit,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `teamMemberId` | `String` | Query, Optional | Filter the returned wages to only those that are associated with the<br>specified team member. |
| `limit` | `Integer` | Query, Optional | The maximum number of `TeamMemberWage` results to return per page. The number can range between<br>1 and 200. The default is 200. |
| `cursor` | `String` | Query, Optional | A pointer to the next page of `EmployeeWage` results to fetch. |

## Response Type

[`ListTeamMemberWagesResponse`](../../doc/models/list-team-member-wages-response.md)

## Example Usage

```java
laborApi.listTeamMemberWagesAsync(null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Get Team Member Wage

Returns a single `TeamMemberWage` specified by `id`.

```java
CompletableFuture<GetTeamMemberWageResponse> getTeamMemberWageAsync(
    final String id)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The UUID for the `TeamMemberWage` being retrieved. |

## Response Type

[`GetTeamMemberWageResponse`](../../doc/models/get-team-member-wage-response.md)

## Example Usage

```java
String id = "id0";

laborApi.getTeamMemberWageAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Workweek Configs

Returns a list of `WorkweekConfig` instances for a business.

```java
CompletableFuture<ListWorkweekConfigsResponse> listWorkweekConfigsAsync(
    final Integer limit,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `limit` | `Integer` | Query, Optional | The maximum number of `WorkweekConfigs` results to return per page. |
| `cursor` | `String` | Query, Optional | A pointer to the next page of `WorkweekConfig` results to fetch. |

## Response Type

[`ListWorkweekConfigsResponse`](../../doc/models/list-workweek-configs-response.md)

## Example Usage

```java
laborApi.listWorkweekConfigsAsync(null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Workweek Config

Updates a `WorkweekConfig`.

```java
CompletableFuture<UpdateWorkweekConfigResponse> updateWorkweekConfigAsync(
    final String id,
    final UpdateWorkweekConfigRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | The UUID for the `WorkweekConfig` object being updated. |
| `body` | [`UpdateWorkweekConfigRequest`](../../doc/models/update-workweek-config-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateWorkweekConfigResponse`](../../doc/models/update-workweek-config-response.md)

## Example Usage

```java
String id = "id0";
WorkweekConfig workweekConfig = new WorkweekConfig.Builder(
        "MON",
        "10:00")
    .version(10)
    .build();
UpdateWorkweekConfigRequest body = new UpdateWorkweekConfigRequest.Builder(
        workweekConfig)
    .build();

laborApi.updateWorkweekConfigAsync(id, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# V1 Employees

```java
V1EmployeesApi v1EmployeesApi = client.getV1EmployeesApi();
```

## Class Name

`V1EmployeesApi`

## Methods

* [List Employees](/doc/api/v1-employees.md#list-employees)
* [Create Employee](/doc/api/v1-employees.md#create-employee)
* [Retrieve Employee](/doc/api/v1-employees.md#retrieve-employee)
* [Update Employee](/doc/api/v1-employees.md#update-employee)
* [List Employee Roles](/doc/api/v1-employees.md#list-employee-roles)
* [Create Employee Role](/doc/api/v1-employees.md#create-employee-role)
* [Retrieve Employee Role](/doc/api/v1-employees.md#retrieve-employee-role)
* [Update Employee Role](/doc/api/v1-employees.md#update-employee-role)
* [List Timecards](/doc/api/v1-employees.md#list-timecards)
* [Create Timecard](/doc/api/v1-employees.md#create-timecard)
* [Delete Timecard](/doc/api/v1-employees.md#delete-timecard)
* [Retrieve Timecard](/doc/api/v1-employees.md#retrieve-timecard)
* [Update Timecard](/doc/api/v1-employees.md#update-timecard)
* [List Timecard Events](/doc/api/v1-employees.md#list-timecard-events)
* [List Cash Drawer Shifts](/doc/api/v1-employees.md#list-cash-drawer-shifts)
* [Retrieve Cash Drawer Shift](/doc/api/v1-employees.md#retrieve-cash-drawer-shift)


# List Employees

Provides summary information for all of a business's employees.

```java
CompletableFuture<List<V1Employee>> listEmployeesAsync(
    final String order,
    final String beginUpdatedAt,
    final String endUpdatedAt,
    final String beginCreatedAt,
    final String endCreatedAt,
    final String status,
    final String externalId,
    final Integer limit,
    final String batchToken)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `order` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which employees are listed in the response, based on their created_at field.      Default value: ASC |
| `beginUpdatedAt` | `String` | Query, Optional | If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format |
| `endUpdatedAt` | `String` | Query, Optional | If filtering results by there updated_at field, the end of the requested reporting period, in ISO 8601 format. |
| `beginCreatedAt` | `String` | Query, Optional | If filtering results by their created_at field, the beginning of the requested reporting period, in ISO 8601 format. |
| `endCreatedAt` | `String` | Query, Optional | If filtering results by their created_at field, the end of the requested reporting period, in ISO 8601 format. |
| `status` | [`String`](/doc/models/v1-list-employees-request-status.md) | Query, Optional | If provided, the endpoint returns only employee entities with the specified status (ACTIVE or INACTIVE). |
| `externalId` | `String` | Query, Optional | If provided, the endpoint returns only employee entities with the specified external_id. |
| `limit` | `Integer` | Query, Optional | The maximum integer number of employee entities to return in a single response. Default 100, maximum 200. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

## Response Type

[`List<V1Employee>`](/doc/models/v1-employee.md)

## Example Usage

```java
String order = "DESC";
String beginUpdatedAt = "begin_updated_at6";
String endUpdatedAt = "end_updated_at4";
String beginCreatedAt = "begin_created_at6";
String endCreatedAt = "end_created_at8";
String status = "ACTIVE";
String externalId = "external_id6";
Integer limit = 172;
String batchToken = "batch_token2";

v1EmployeesApi.listEmployeesAsync(order, beginUpdatedAt, endUpdatedAt, beginCreatedAt, endCreatedAt, status, externalId, limit, batchToken).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Employee

Use the CreateEmployee endpoint to add an employee to a Square
account. Employees created with the Connect API have an initial status
of `INACTIVE`. Inactive employees cannot sign in to Square Point of Sale
until they are activated from the Square Dashboard. Employee status
cannot be changed with the Connect API.

<aside class="important">
Employee entities cannot be deleted. To disable employee profiles,
set the employee's status to <code>INACTIVE</code>
</aside>


```java
CompletableFuture<V1Employee> createEmployeeAsync(
    final V1Employee body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`V1Employee`](/doc/models/v1-employee.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`V1Employee`](/doc/models/v1-employee.md)

## Example Usage

```java
List<String> bodyRoleIds = new LinkedList<>();
bodyRoleIds.add("role_ids0");
bodyRoleIds.add("role_ids1");
List<String> bodyAuthorizedLocationIds = new LinkedList<>();
bodyAuthorizedLocationIds.add("authorized_location_ids7");
bodyAuthorizedLocationIds.add("authorized_location_ids8");
V1Employee body = new V1Employee.Builder(
        "first_name6",
        "last_name4")
    .id("id6")
    .roleIds(bodyRoleIds)
    .authorizedLocationIds(bodyAuthorizedLocationIds)
    .email("email0")
    .status("ACTIVE")
    .build();

v1EmployeesApi.createEmployeeAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Employee

Provides the details for a single employee.

```java
CompletableFuture<V1Employee> retrieveEmployeeAsync(
    final String employeeId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `employeeId` | `String` | Template, Required | The employee's ID. |

## Response Type

[`V1Employee`](/doc/models/v1-employee.md)

## Example Usage

```java
String employeeId = "employee_id0";

v1EmployeesApi.retrieveEmployeeAsync(employeeId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Employee

UpdateEmployee

```java
CompletableFuture<V1Employee> updateEmployeeAsync(
    final String employeeId,
    final V1Employee body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `employeeId` | `String` | Template, Required | The ID of the role to modify. |
| `body` | [`V1Employee`](/doc/models/v1-employee.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`V1Employee`](/doc/models/v1-employee.md)

## Example Usage

```java
String employeeId = "employee_id0";
List<String> bodyRoleIds = new LinkedList<>();
bodyRoleIds.add("role_ids0");
bodyRoleIds.add("role_ids1");
List<String> bodyAuthorizedLocationIds = new LinkedList<>();
bodyAuthorizedLocationIds.add("authorized_location_ids7");
bodyAuthorizedLocationIds.add("authorized_location_ids8");
V1Employee body = new V1Employee.Builder(
        "first_name6",
        "last_name4")
    .id("id6")
    .roleIds(bodyRoleIds)
    .authorizedLocationIds(bodyAuthorizedLocationIds)
    .email("email0")
    .status("ACTIVE")
    .build();

v1EmployeesApi.updateEmployeeAsync(employeeId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Employee Roles

Provides summary information for all of a business's employee roles.

```java
CompletableFuture<List<V1EmployeeRole>> listEmployeeRolesAsync(
    final String order,
    final Integer limit,
    final String batchToken)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `order` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which employees are listed in the response, based on their created_at field.Default value: ASC |
| `limit` | `Integer` | Query, Optional | The maximum integer number of employee entities to return in a single response. Default 100, maximum 200. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

## Response Type

[`List<V1EmployeeRole>`](/doc/models/v1-employee-role.md)

## Example Usage

```java
String order = "DESC";
Integer limit = 172;
String batchToken = "batch_token2";

v1EmployeesApi.listEmployeeRolesAsync(order, limit, batchToken).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Employee Role

Creates an employee role you can then assign to employees.

Square accounts can include any number of roles that can be assigned to
employees. These roles define the actions and permissions granted to an
employee with that role. For example, an employee with a "Shift Manager"
role might be able to issue refunds in Square Point of Sale, whereas an
employee with a "Clerk" role might not.

Roles are assigned with the [V1UpdateEmployee](#endpoint-v1updateemployee)
endpoint. An employee can have only one role at a time.

If an employee has no role, they have none of the permissions associated
with roles. All employees can accept payments with Square Point of Sale.

```java
CompletableFuture<V1EmployeeRole> createEmployeeRoleAsync(
    final V1EmployeeRole body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`V1EmployeeRole`](/doc/models/v1-employee-role.md) | Body, Required | An EmployeeRole object with a name and permissions, and an optional owner flag. |

## Response Type

[`V1EmployeeRole`](/doc/models/v1-employee-role.md)

## Example Usage

```java
List<String> bodyPermissions = new LinkedList<>();
bodyPermissions.add("REGISTER_APPLY_RESTRICTED_DISCOUNTS");
bodyPermissions.add("REGISTER_CHANGE_SETTINGS");
bodyPermissions.add("REGISTER_EDIT_ITEM");
V1EmployeeRole body = new V1EmployeeRole.Builder(
        "name6",
        bodyPermissions)
    .id("id6")
    .isOwner(false)
    .createdAt("created_at4")
    .updatedAt("updated_at8")
    .build();

v1EmployeesApi.createEmployeeRoleAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Employee Role

Provides the details for a single employee role.

```java
CompletableFuture<V1EmployeeRole> retrieveEmployeeRoleAsync(
    final String roleId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `roleId` | `String` | Template, Required | The role's ID. |

## Response Type

[`V1EmployeeRole`](/doc/models/v1-employee-role.md)

## Example Usage

```java
String roleId = "role_id6";

v1EmployeesApi.retrieveEmployeeRoleAsync(roleId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Employee Role

Modifies the details of an employee role.

```java
CompletableFuture<V1EmployeeRole> updateEmployeeRoleAsync(
    final String roleId,
    final V1EmployeeRole body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `roleId` | `String` | Template, Required | The ID of the role to modify. |
| `body` | [`V1EmployeeRole`](/doc/models/v1-employee-role.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`V1EmployeeRole`](/doc/models/v1-employee-role.md)

## Example Usage

```java
String roleId = "role_id6";
List<String> bodyPermissions = new LinkedList<>();
bodyPermissions.add("REGISTER_APPLY_RESTRICTED_DISCOUNTS");
bodyPermissions.add("REGISTER_CHANGE_SETTINGS");
bodyPermissions.add("REGISTER_EDIT_ITEM");
V1EmployeeRole body = new V1EmployeeRole.Builder(
        "name6",
        bodyPermissions)
    .id("id6")
    .isOwner(false)
    .createdAt("created_at4")
    .updatedAt("updated_at8")
    .build();

v1EmployeesApi.updateEmployeeRoleAsync(roleId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Timecards

Provides summary information for all of a business's employee timecards.

```java
CompletableFuture<List<V1Timecard>> listTimecardsAsync(
    final String order,
    final String employeeId,
    final String beginClockinTime,
    final String endClockinTime,
    final String beginClockoutTime,
    final String endClockoutTime,
    final String beginUpdatedAt,
    final String endUpdatedAt,
    final Boolean deleted,
    final Integer limit,
    final String batchToken)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `order` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which timecards are listed in the response, based on their created_at field. |
| `employeeId` | `String` | Query, Optional | If provided, the endpoint returns only timecards for the employee with the specified ID. |
| `beginClockinTime` | `String` | Query, Optional | If filtering results by their clockin_time field, the beginning of the requested reporting period, in ISO 8601 format. |
| `endClockinTime` | `String` | Query, Optional | If filtering results by their clockin_time field, the end of the requested reporting period, in ISO 8601 format. |
| `beginClockoutTime` | `String` | Query, Optional | If filtering results by their clockout_time field, the beginning of the requested reporting period, in ISO 8601 format. |
| `endClockoutTime` | `String` | Query, Optional | If filtering results by their clockout_time field, the end of the requested reporting period, in ISO 8601 format. |
| `beginUpdatedAt` | `String` | Query, Optional | If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format. |
| `endUpdatedAt` | `String` | Query, Optional | If filtering results by their updated_at field, the end of the requested reporting period, in ISO 8601 format. |
| `deleted` | `Boolean` | Query, Optional | If true, only deleted timecards are returned. If false, only valid timecards are returned.If you don't provide this parameter, both valid and deleted timecards are returned. |
| `limit` | `Integer` | Query, Optional | The maximum integer number of employee entities to return in a single response. Default 100, maximum 200. |
| `batchToken` | `String` | Query, Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. |

## Response Type

[`List<V1Timecard>`](/doc/models/v1-timecard.md)

## Example Usage

```java
String order = "DESC";
String employeeId = "employee_id0";
String beginClockinTime = "begin_clockin_time8";
String endClockinTime = "end_clockin_time2";
String beginClockoutTime = "begin_clockout_time0";
String endClockoutTime = "end_clockout_time2";
String beginUpdatedAt = "begin_updated_at6";
String endUpdatedAt = "end_updated_at4";
Boolean deleted = false;
Integer limit = 172;
String batchToken = "batch_token2";

v1EmployeesApi.listTimecardsAsync(order, employeeId, beginClockinTime, endClockinTime, beginClockoutTime, endClockoutTime, beginUpdatedAt, endUpdatedAt, deleted, limit, batchToken).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Timecard

Creates a timecard for an employee and clocks them in with an
`API_CREATE` event and a `clockin_time` set to the current time unless
the request provides a different value.

To import timecards from another
system (rather than clocking someone in). Specify the `clockin_time`
and* `clockout_time` in the request.

Timecards correspond to exactly one shift for a given employee, bounded
by the `clockin_time` and `clockout_time` fields. An employee is
considered clocked in if they have a timecard that doesn't have a
`clockout_time` set. An employee that is currently clocked in cannot
be clocked in a second time.

```java
CompletableFuture<V1Timecard> createTimecardAsync(
    final V1Timecard body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`V1Timecard`](/doc/models/v1-timecard.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`V1Timecard`](/doc/models/v1-timecard.md)

## Example Usage

```java
V1Timecard body = new V1Timecard.Builder(
        "employee_id4")
    .id("id6")
    .deleted(false)
    .clockinTime("clockin_time2")
    .clockoutTime("clockout_time2")
    .clockinLocationId("clockin_location_id4")
    .build();

v1EmployeesApi.createTimecardAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Timecard

Deletes a timecard. Timecards can also be deleted through the
Square Dashboard. Deleted timecards are still accessible through
Connect API endpoints, but cannot be modified. The `deleted` field of
the `Timecard` object indicates whether the timecard has been deleted.

__Note__: By default, deleted timecards appear alongside valid timecards in
results returned by the [ListTimecards](#endpoint-v1employees-listtimecards)
endpoint. To filter deleted timecards, include the `deleted` query
parameter in the list request.

Only approved accounts can manage their employees with Square.
Unapproved accounts cannot use employee management features with the
API.

```java
CompletableFuture<Object> deleteTimecardAsync(
    final String timecardId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `timecardId` | `String` | Template, Required | The ID of the timecard to delete. |

## Response Type

`Object`

## Example Usage

```java
String timecardId = "timecard_id0";

v1EmployeesApi.deleteTimecardAsync(timecardId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Timecard

Provides the details for a single timecard.

<aside>
Only approved accounts can manage their employees with Square.
Unapproved accounts cannot use employee management features with the
API.
</aside>


```java
CompletableFuture<V1Timecard> retrieveTimecardAsync(
    final String timecardId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `timecardId` | `String` | Template, Required | The timecard's ID. |

## Response Type

[`V1Timecard`](/doc/models/v1-timecard.md)

## Example Usage

```java
String timecardId = "timecard_id0";

v1EmployeesApi.retrieveTimecardAsync(timecardId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Timecard

Modifies the details of a timecard with an `API_EDIT` event for
the timecard. Updating an active timecard with a `clockout_time`
clocks the employee out.

```java
CompletableFuture<V1Timecard> updateTimecardAsync(
    final String timecardId,
    final V1Timecard body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `timecardId` | `String` | Template, Required | TThe ID of the timecard to modify. |
| `body` | [`V1Timecard`](/doc/models/v1-timecard.md) | Body, Required | An object containing the fields to POST for the request.<br>See the corresponding object definition for field details. |

## Response Type

[`V1Timecard`](/doc/models/v1-timecard.md)

## Example Usage

```java
String timecardId = "timecard_id0";
V1Timecard body = new V1Timecard.Builder(
        "employee_id4")
    .id("id6")
    .deleted(false)
    .clockinTime("clockin_time2")
    .clockoutTime("clockout_time2")
    .clockinLocationId("clockin_location_id4")
    .build();

v1EmployeesApi.updateTimecardAsync(timecardId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Timecard Events

Provides summary information for all events associated with a
particular timecard.

<aside>
Only approved accounts can manage their employees with Square.
Unapproved accounts cannot use employee management features with the
API.
</aside>


```java
CompletableFuture<List<V1TimecardEvent>> listTimecardEventsAsync(
    final String timecardId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `timecardId` | `String` | Template, Required | The ID of the timecard to list events for. |

## Response Type

[`List<V1TimecardEvent>`](/doc/models/v1-timecard-event.md)

## Example Usage

```java
String timecardId = "timecard_id0";

v1EmployeesApi.listTimecardEventsAsync(timecardId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Cash Drawer Shifts

Provides the details for all of a location's cash drawer shifts during a date range. The date range you specify cannot exceed 90 days.

```java
CompletableFuture<List<V1CashDrawerShift>> listCashDrawerShiftsAsync(
    final String locationId,
    final String order,
    final String beginTime,
    final String endTime)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list cash drawer shifts for. |
| `order` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which cash drawer shifts are listed in the response, based on their created_at field. Default value: ASC |
| `beginTime` | `String` | Query, Optional | The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time minus 90 days. |
| `endTime` | `String` | Query, Optional | The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time. |

## Response Type

[`List<V1CashDrawerShift>`](/doc/models/v1-cash-drawer-shift.md)

## Example Usage

```java
String locationId = "location_id4";
String order = "DESC";
String beginTime = "begin_time2";
String endTime = "end_time2";

v1EmployeesApi.listCashDrawerShiftsAsync(locationId, order, beginTime, endTime).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Cash Drawer Shift

Provides the details for a single cash drawer shift, including all events that occurred during the shift.

```java
CompletableFuture<V1CashDrawerShift> retrieveCashDrawerShiftAsync(
    final String locationId,
    final String shiftId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list cash drawer shifts for. |
| `shiftId` | `String` | Template, Required | The shift's ID. |

## Response Type

[`V1CashDrawerShift`](/doc/models/v1-cash-drawer-shift.md)

## Example Usage

```java
String locationId = "location_id4";
String shiftId = "shift_id0";

v1EmployeesApi.retrieveCashDrawerShiftAsync(locationId, shiftId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


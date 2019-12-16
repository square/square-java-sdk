# Employees

```java
EmployeesApi employeesApi = client.getEmployeesApi();
```

## Class Name

`EmployeesApi`

## Methods

* [List Employees](/doc/employees.md#list-employees)
* [Retrieve Employee](/doc/employees.md#retrieve-employee)

## List Employees

ListEmployees

```java
CompletableFuture<ListEmployeesResponse> listEmployeesAsync(
    final String locationId,
    final String status,
    final Integer limit,
    final String cursor
)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Query, Optional | Filter employees returned to only those that are associated with the specified location. |
| `status` | [`String`](/doc/models/employee-status.md) | Query, Optional | Specifies the EmployeeStatus to filter the employee by. |
| `limit` | `Integer` | Query, Optional | The number of employees to be returned on each page. |
| `cursor` | `String` | Query, Optional | The token required to retrieve the specified page of results. |

### Response Type

[`ListEmployeesResponse`](/doc/models/list-employees-response.md)

### Example Usage

```java
employeesApi.listEmployeesAsync(null, null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Employee

RetrieveEmployee

```java
CompletableFuture<RetrieveEmployeeResponse> retrieveEmployeeAsync(
    final String id
)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `id` | `String` | Template, Required | UUID for the employee that was requested. |

### Response Type

[`RetrieveEmployeeResponse`](/doc/models/retrieve-employee-response.md)

### Example Usage

```java
String id = "id0";

employeesApi.retrieveEmployeeAsync(id).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


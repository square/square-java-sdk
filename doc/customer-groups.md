# Customer Groups

```java
CustomerGroupsApi customerGroupsApi = client.getCustomerGroupsApi();
```

## Class Name

`CustomerGroupsApi`

## Methods

* [List Customer Groups](/doc/customer-groups.md#list-customer-groups)
* [Create Customer Group](/doc/customer-groups.md#create-customer-group)
* [Delete Customer Group](/doc/customer-groups.md#delete-customer-group)
* [Retrieve Customer Group](/doc/customer-groups.md#retrieve-customer-group)
* [Update Customer Group](/doc/customer-groups.md#update-customer-group)

## List Customer Groups

Retrieves the list of customer groups of a business.

```java
CompletableFuture<ListCustomerGroupsResponse> listCustomerGroupsAsync(
    final String cursor)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br><br>See the [Pagination guide](https://developer.squareup.com/docs/working-with-apis/pagination) for more information. |

### Response Type

[`ListCustomerGroupsResponse`](/doc/models/list-customer-groups-response.md)

### Example Usage

```java
customerGroupsApi.listCustomerGroupsAsync(null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Customer Group

Creates a new customer group for a business. 

The request must include at least the `name` value of the group.

```java
CompletableFuture<CreateCustomerGroupResponse> createCustomerGroupAsync(
    final CreateCustomerGroupRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateCustomerGroupRequest`](/doc/models/create-customer-group-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateCustomerGroupResponse`](/doc/models/create-customer-group-response.md)

### Example Usage

```java
CustomerGroup bodyGroup = new CustomerGroup.Builder(
        "Loyal Customers")
    .build();
CreateCustomerGroupRequest body = new CreateCustomerGroupRequest.Builder(
        bodyGroup)
    .build();

customerGroupsApi.createCustomerGroupAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Customer Group

Deletes a customer group as identified by the `group_id` value.

```java
CompletableFuture<DeleteCustomerGroupResponse> deleteCustomerGroupAsync(
    final String groupId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `groupId` | `String` | Template, Required | The ID of the customer group to delete. |

### Response Type

[`DeleteCustomerGroupResponse`](/doc/models/delete-customer-group-response.md)

### Example Usage

```java
String groupId = "group_id0";

customerGroupsApi.deleteCustomerGroupAsync(groupId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Customer Group

Retrieves a specific customer group as identified by the `group_id` value.

```java
CompletableFuture<RetrieveCustomerGroupResponse> retrieveCustomerGroupAsync(
    final String groupId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `groupId` | `String` | Template, Required | The ID of the customer group to retrieve. |

### Response Type

[`RetrieveCustomerGroupResponse`](/doc/models/retrieve-customer-group-response.md)

### Example Usage

```java
String groupId = "group_id0";

customerGroupsApi.retrieveCustomerGroupAsync(groupId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Customer Group

Updates a customer group as identified by the `group_id` value.

```java
CompletableFuture<UpdateCustomerGroupResponse> updateCustomerGroupAsync(
    final String groupId,
    final UpdateCustomerGroupRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `groupId` | `String` | Template, Required | The ID of the customer group to update. |
| `body` | [`UpdateCustomerGroupRequest`](/doc/models/update-customer-group-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`UpdateCustomerGroupResponse`](/doc/models/update-customer-group-response.md)

### Example Usage

```java
String groupId = "group_id0";
CustomerGroup bodyGroup = new CustomerGroup.Builder(
        "Loyal Customers")
    .build();
UpdateCustomerGroupRequest body = new UpdateCustomerGroupRequest.Builder(
        bodyGroup)
    .build();

customerGroupsApi.updateCustomerGroupAsync(groupId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


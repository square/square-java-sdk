# Order Custom Attributes

```java
OrderCustomAttributesApi orderCustomAttributesApi = client.getOrderCustomAttributesApi();
```

## Class Name

`OrderCustomAttributesApi`

## Methods

* [List Order Custom Attribute Definitions](../../doc/api/order-custom-attributes.md#list-order-custom-attribute-definitions)
* [Create Order Custom Attribute Definition](../../doc/api/order-custom-attributes.md#create-order-custom-attribute-definition)
* [Delete Order Custom Attribute Definition](../../doc/api/order-custom-attributes.md#delete-order-custom-attribute-definition)
* [Retrieve Order Custom Attribute Definition](../../doc/api/order-custom-attributes.md#retrieve-order-custom-attribute-definition)
* [Update Order Custom Attribute Definition](../../doc/api/order-custom-attributes.md#update-order-custom-attribute-definition)
* [Bulk Delete Order Custom Attributes](../../doc/api/order-custom-attributes.md#bulk-delete-order-custom-attributes)
* [Bulk Upsert Order Custom Attributes](../../doc/api/order-custom-attributes.md#bulk-upsert-order-custom-attributes)
* [List Order Custom Attributes](../../doc/api/order-custom-attributes.md#list-order-custom-attributes)
* [Delete Order Custom Attribute](../../doc/api/order-custom-attributes.md#delete-order-custom-attribute)
* [Retrieve Order Custom Attribute](../../doc/api/order-custom-attributes.md#retrieve-order-custom-attribute)
* [Upsert Order Custom Attribute](../../doc/api/order-custom-attributes.md#upsert-order-custom-attribute)


# List Order Custom Attribute Definitions

Lists the order-related [custom attribute definitions](../../doc/models/custom-attribute-definition.md) that belong to a Square seller account.

When all response pages are retrieved, the results include all custom attribute definitions
that are visible to the requesting application, including those that are created by other
applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`. Note that
seller-defined custom attributes (also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<ListOrderCustomAttributeDefinitionsResponse> listOrderCustomAttributeDefinitionsAsync(
    final String visibilityFilter,
    final String cursor,
    final Integer limit)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `visibilityFilter` | [`String`](../../doc/models/visibility-filter.md) | Query, Optional | Requests that all of the custom attributes be returned, or only those that are read-only or read-write. |
| `cursor` | `String` | Query, Optional | The cursor returned in the paged response from the previous call to this endpoint.<br>Provide this cursor to retrieve the next page of results for your original request.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `limit` | `Integer` | Query, Optional | The maximum number of results to return in a single paged response. This limit is advisory.<br>The response might contain more or fewer results. The minimum value is 1 and the maximum value is 100.<br>The default value is 20.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |

## Response Type

[`ListOrderCustomAttributeDefinitionsResponse`](../../doc/models/list-order-custom-attribute-definitions-response.md)

## Example Usage

```java
orderCustomAttributesApi.listOrderCustomAttributeDefinitionsAsync(null, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Create Order Custom Attribute Definition

Creates an order-related custom attribute definition.  Use this endpoint to
define a custom attribute that can be associated with orders.

After creating a custom attribute definition, you can set the custom attribute for orders
in the Square seller account.

```java
CompletableFuture<CreateOrderCustomAttributeDefinitionResponse> createOrderCustomAttributeDefinitionAsync(
    final CreateOrderCustomAttributeDefinitionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateOrderCustomAttributeDefinitionRequest`](../../doc/models/create-order-custom-attribute-definition-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateOrderCustomAttributeDefinitionResponse`](../../doc/models/create-order-custom-attribute-definition-response.md)

## Example Usage

```java
CreateOrderCustomAttributeDefinitionRequest body = new CreateOrderCustomAttributeDefinitionRequest.Builder(
    new CustomAttributeDefinition.Builder()
        .key("cover-count")
        .name("Cover count")
        .description("The number of people seated at a table")
        .visibility("VISIBILITY_READ_WRITE_VALUES")
        .build()
)
.idempotencyKey("IDEMPOTENCY_KEY")
.build();

orderCustomAttributesApi.createOrderCustomAttributeDefinitionAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Delete Order Custom Attribute Definition

Deletes an order-related [custom attribute definition](../../doc/models/custom-attribute-definition.md) from a Square seller account.

Only the definition owner can delete a custom attribute definition.

```java
CompletableFuture<DeleteOrderCustomAttributeDefinitionResponse> deleteOrderCustomAttributeDefinitionAsync(
    final String key)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to delete. |

## Response Type

[`DeleteOrderCustomAttributeDefinitionResponse`](../../doc/models/delete-order-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";

orderCustomAttributesApi.deleteOrderCustomAttributeDefinitionAsync(key).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Order Custom Attribute Definition

Retrieves an order-related [custom attribute definition](../../doc/models/custom-attribute-definition.md) from a Square seller account.

To retrieve a custom attribute definition created by another application, the `visibility`
setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes
(also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<RetrieveOrderCustomAttributeDefinitionResponse> retrieveOrderCustomAttributeDefinitionAsync(
    final String key,
    final Integer version)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to retrieve. |
| `version` | `Integer` | Query, Optional | To enable [optimistic concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)<br>control, include this optional field and specify the current version of the custom attribute. |

## Response Type

[`RetrieveOrderCustomAttributeDefinitionResponse`](../../doc/models/retrieve-order-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";

orderCustomAttributesApi.retrieveOrderCustomAttributeDefinitionAsync(key, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Update Order Custom Attribute Definition

Updates an order-related custom attribute definition for a Square seller account.

Only the definition owner can update a custom attribute definition. Note that sellers can view all custom attributes in exported customer data, including those set to `VISIBILITY_HIDDEN`.

```java
CompletableFuture<UpdateOrderCustomAttributeDefinitionResponse> updateOrderCustomAttributeDefinitionAsync(
    final String key,
    final UpdateOrderCustomAttributeDefinitionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to update. |
| `body` | [`UpdateOrderCustomAttributeDefinitionRequest`](../../doc/models/update-order-custom-attribute-definition-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateOrderCustomAttributeDefinitionResponse`](../../doc/models/update-order-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";
UpdateOrderCustomAttributeDefinitionRequest body = new UpdateOrderCustomAttributeDefinitionRequest.Builder(
    new CustomAttributeDefinition.Builder()
        .key("cover-count")
        .visibility("VISIBILITY_READ_ONLY")
        .version(1)
        .build()
)
.idempotencyKey("IDEMPOTENCY_KEY")
.build();

orderCustomAttributesApi.updateOrderCustomAttributeDefinitionAsync(key, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Bulk Delete Order Custom Attributes

Deletes order [custom attributes](../../doc/models/custom-attribute.md) as a bulk operation.

Use this endpoint to delete one or more custom attributes from one or more orders.
A custom attribute is based on a custom attribute definition in a Square seller account.  (To create a
custom attribute definition, use the [CreateOrderCustomAttributeDefinition](../../doc/api/order-custom-attributes.md#create-order-custom-attribute-definition) endpoint.)

This `BulkDeleteOrderCustomAttributes` endpoint accepts a map of 1 to 25 individual delete
requests and returns a map of individual delete responses. Each delete request has a unique ID
and provides an order ID and custom attribute. Each delete response is returned with the ID
of the corresponding request.

To delete a custom attribute owned by another application, the `visibility` setting
must be `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes
(also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<BulkDeleteOrderCustomAttributesResponse> bulkDeleteOrderCustomAttributesAsync(
    final BulkDeleteOrderCustomAttributesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkDeleteOrderCustomAttributesRequest`](../../doc/models/bulk-delete-order-custom-attributes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkDeleteOrderCustomAttributesResponse`](../../doc/models/bulk-delete-order-custom-attributes-response.md)

## Example Usage

```java
BulkDeleteOrderCustomAttributesRequest body = new BulkDeleteOrderCustomAttributesRequest.Builder(
    new LinkedHashMap<String, BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute>() {{
        put("cover-count", new BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute.Builder(
            "7BbXGEIWNldxAzrtGf9GPVZTwZ4F"
        )
        .key("cover-count")
        .build());
        put("table-number", new BulkDeleteOrderCustomAttributesRequestDeleteCustomAttribute.Builder(
            "7BbXGEIWNldxAzrtGf9GPVZTwZ4F"
        )
        .key("table-number")
        .build());
    }}
)
.build();

orderCustomAttributesApi.bulkDeleteOrderCustomAttributesAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Bulk Upsert Order Custom Attributes

Creates or updates order [custom attributes](../../doc/models/custom-attribute.md) as a bulk operation.

Use this endpoint to delete one or more custom attributes from one or more orders.
A custom attribute is based on a custom attribute definition in a Square seller account.  (To create a
custom attribute definition, use the [CreateOrderCustomAttributeDefinition](../../doc/api/order-custom-attributes.md#create-order-custom-attribute-definition) endpoint.)

This `BulkUpsertOrderCustomAttributes` endpoint accepts a map of 1 to 25 individual upsert
requests and returns a map of individual upsert responses. Each upsert request has a unique ID
and provides an order ID and custom attribute. Each upsert response is returned with the ID
of the corresponding request.

To create or update a custom attribute owned by another application, the `visibility` setting
must be `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes
(also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<BulkUpsertOrderCustomAttributesResponse> bulkUpsertOrderCustomAttributesAsync(
    final BulkUpsertOrderCustomAttributesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkUpsertOrderCustomAttributesRequest`](../../doc/models/bulk-upsert-order-custom-attributes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkUpsertOrderCustomAttributesResponse`](../../doc/models/bulk-upsert-order-custom-attributes-response.md)

## Example Usage

```java
BulkUpsertOrderCustomAttributesRequest body = new BulkUpsertOrderCustomAttributesRequest.Builder(
    new LinkedHashMap<String, BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute>() {{
        put("key0", new BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute.Builder(
            new CustomAttribute.Builder()
                .build(),
            "order_id2"
        )
        .build());
        put("key1", new BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute.Builder(
            new CustomAttribute.Builder()
                .build(),
            "order_id1"
        )
        .build());
    }}
)
.build();

orderCustomAttributesApi.bulkUpsertOrderCustomAttributesAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# List Order Custom Attributes

Lists the [custom attributes](../../doc/models/custom-attribute.md) associated with an order.

You can use the `with_definitions` query parameter to also retrieve custom attribute definitions
in the same call.

When all response pages are retrieved, the results include all custom attributes that are
visible to the requesting application, including those that are owned by other applications
and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<ListOrderCustomAttributesResponse> listOrderCustomAttributesAsync(
    final String orderId,
    final String visibilityFilter,
    final String cursor,
    final Integer limit,
    final Boolean withDefinitions)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the target [order](entity:Order). |
| `visibilityFilter` | [`String`](../../doc/models/visibility-filter.md) | Query, Optional | Requests that all of the custom attributes be returned, or only those that are read-only or read-write. |
| `cursor` | `String` | Query, Optional | The cursor returned in the paged response from the previous call to this endpoint.<br>Provide this cursor to retrieve the next page of results for your original request.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `limit` | `Integer` | Query, Optional | The maximum number of results to return in a single paged response. This limit is advisory.<br>The response might contain more or fewer results. The minimum value is 1 and the maximum value is 100.<br>The default value is 20.<br>For more information, see [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination). |
| `withDefinitions` | `Boolean` | Query, Optional | Indicates whether to return the [custom attribute definition](entity:CustomAttributeDefinition) in the `definition` field of each<br>custom attribute. Set this parameter to `true` to get the name and description of each custom attribute,<br>information about the data type, or other definition details. The default value is `false`.<br>**Default**: `false` |

## Response Type

[`ListOrderCustomAttributesResponse`](../../doc/models/list-order-custom-attributes-response.md)

## Example Usage

```java
String orderId = "order_id6";
Boolean withDefinitions = false;

orderCustomAttributesApi.listOrderCustomAttributesAsync(orderId, null, null, null, withDefinitions).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Delete Order Custom Attribute

Deletes a [custom attribute](../../doc/models/custom-attribute.md) associated with a customer profile.

To delete a custom attribute owned by another application, the `visibility` setting must be
`VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes
(also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<DeleteOrderCustomAttributeResponse> deleteOrderCustomAttributeAsync(
    final String orderId,
    final String customAttributeKey)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the target [order](entity:Order). |
| `customAttributeKey` | `String` | Template, Required | The key of the custom attribute to delete.  This key must match the key of an<br>existing custom attribute definition. |

## Response Type

[`DeleteOrderCustomAttributeResponse`](../../doc/models/delete-order-custom-attribute-response.md)

## Example Usage

```java
String orderId = "order_id6";
String customAttributeKey = "custom_attribute_key2";

orderCustomAttributesApi.deleteOrderCustomAttributeAsync(orderId, customAttributeKey).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Order Custom Attribute

Retrieves a [custom attribute](../../doc/models/custom-attribute.md) associated with an order.

You can use the `with_definition` query parameter to also retrieve the custom attribute definition
in the same call.

To retrieve a custom attribute owned by another application, the `visibility` setting must be
`VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes
also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<RetrieveOrderCustomAttributeResponse> retrieveOrderCustomAttributeAsync(
    final String orderId,
    final String customAttributeKey,
    final Integer version,
    final Boolean withDefinition)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the target [order](entity:Order). |
| `customAttributeKey` | `String` | Template, Required | The key of the custom attribute to retrieve.  This key must match the key of an<br>existing custom attribute definition. |
| `version` | `Integer` | Query, Optional | To enable [optimistic concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)<br>control, include this optional field and specify the current version of the custom attribute. |
| `withDefinition` | `Boolean` | Query, Optional | Indicates whether to return the [custom attribute definition](entity:CustomAttributeDefinition) in the `definition` field of each<br>custom attribute. Set this parameter to `true` to get the name and description of each custom attribute,<br>information about the data type, or other definition details. The default value is `false`.<br>**Default**: `false` |

## Response Type

[`RetrieveOrderCustomAttributeResponse`](../../doc/models/retrieve-order-custom-attribute-response.md)

## Example Usage

```java
String orderId = "order_id6";
String customAttributeKey = "custom_attribute_key2";
Boolean withDefinition = false;

orderCustomAttributesApi.retrieveOrderCustomAttributeAsync(orderId, customAttributeKey, null, withDefinition).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Upsert Order Custom Attribute

Creates or updates a [custom attribute](../../doc/models/custom-attribute.md) for an order.

Use this endpoint to set the value of a custom attribute for a specific order.
A custom attribute is based on a custom attribute definition in a Square seller account. (To create a
custom attribute definition, use the [CreateOrderCustomAttributeDefinition](../../doc/api/order-custom-attributes.md#create-order-custom-attribute-definition) endpoint.)

To create or update a custom attribute owned by another application, the `visibility` setting
must be `VISIBILITY_READ_WRITE_VALUES`. Note that seller-defined custom attributes
(also known as custom fields) are always set to `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<UpsertOrderCustomAttributeResponse> upsertOrderCustomAttributeAsync(
    final String orderId,
    final String customAttributeKey,
    final UpsertOrderCustomAttributeRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `orderId` | `String` | Template, Required | The ID of the target [order](entity:Order). |
| `customAttributeKey` | `String` | Template, Required | The key of the custom attribute to create or update.  This key must match the key<br>of an existing custom attribute definition. |
| `body` | [`UpsertOrderCustomAttributeRequest`](../../doc/models/upsert-order-custom-attribute-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpsertOrderCustomAttributeResponse`](../../doc/models/upsert-order-custom-attribute-response.md)

## Example Usage

```java
String orderId = "order_id6";
String customAttributeKey = "custom_attribute_key2";
UpsertOrderCustomAttributeRequest body = new UpsertOrderCustomAttributeRequest.Builder(
    new CustomAttribute.Builder()
        .build()
)
.build();

orderCustomAttributesApi.upsertOrderCustomAttributeAsync(orderId, customAttributeKey, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


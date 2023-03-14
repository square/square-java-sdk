# Location Custom Attributes

```java
LocationCustomAttributesApi locationCustomAttributesApi = client.getLocationCustomAttributesApi();
```

## Class Name

`LocationCustomAttributesApi`

## Methods

* [List Location Custom Attribute Definitions](../../doc/api/location-custom-attributes.md#list-location-custom-attribute-definitions)
* [Create Location Custom Attribute Definition](../../doc/api/location-custom-attributes.md#create-location-custom-attribute-definition)
* [Delete Location Custom Attribute Definition](../../doc/api/location-custom-attributes.md#delete-location-custom-attribute-definition)
* [Retrieve Location Custom Attribute Definition](../../doc/api/location-custom-attributes.md#retrieve-location-custom-attribute-definition)
* [Update Location Custom Attribute Definition](../../doc/api/location-custom-attributes.md#update-location-custom-attribute-definition)
* [Bulk Delete Location Custom Attributes](../../doc/api/location-custom-attributes.md#bulk-delete-location-custom-attributes)
* [Bulk Upsert Location Custom Attributes](../../doc/api/location-custom-attributes.md#bulk-upsert-location-custom-attributes)
* [List Location Custom Attributes](../../doc/api/location-custom-attributes.md#list-location-custom-attributes)
* [Delete Location Custom Attribute](../../doc/api/location-custom-attributes.md#delete-location-custom-attribute)
* [Retrieve Location Custom Attribute](../../doc/api/location-custom-attributes.md#retrieve-location-custom-attribute)
* [Upsert Location Custom Attribute](../../doc/api/location-custom-attributes.md#upsert-location-custom-attribute)


# List Location Custom Attribute Definitions

Lists the location-related [custom attribute definitions](../../doc/models/custom-attribute-definition.md) that belong to a Square seller account.
When all response pages are retrieved, the results include all custom attribute definitions
that are visible to the requesting application, including those that are created by other
applications and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<ListLocationCustomAttributeDefinitionsResponse> listLocationCustomAttributeDefinitionsAsync(
    final String visibilityFilter,
    final Integer limit,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `visibilityFilter` | [`String`](../../doc/models/visibility-filter.md) | Query, Optional | Filters the `CustomAttributeDefinition` results by their `visibility` values. |
| `limit` | `Integer` | Query, Optional | The maximum number of results to return in a single paged response. This limit is advisory.<br>The response might contain more or fewer results. The minimum value is 1 and the maximum value is 100.<br>The default value is 20. For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `cursor` | `String` | Query, Optional | The cursor returned in the paged response from the previous call to this endpoint.<br>Provide this cursor to retrieve the next page of results for your original request.<br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |

## Response Type

[`ListLocationCustomAttributeDefinitionsResponse`](../../doc/models/list-location-custom-attribute-definitions-response.md)

## Example Usage

```java
locationCustomAttributesApi.listLocationCustomAttributeDefinitionsAsync(null, null, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Location Custom Attribute Definition

Creates a location-related [custom attribute definition](../../doc/models/custom-attribute-definition.md) for a Square seller account.
Use this endpoint to define a custom attribute that can be associated with locations.
A custom attribute definition specifies the `key`, `visibility`, `schema`, and other properties
for a custom attribute. After the definition is created, you can call
[UpsertLocationCustomAttribute](../../doc/api/location-custom-attributes.md#upsert-location-custom-attribute) or
[BulkUpsertLocationCustomAttributes](../../doc/api/location-custom-attributes.md#bulk-upsert-location-custom-attributes)
to set the custom attribute for locations.

```java
CompletableFuture<CreateLocationCustomAttributeDefinitionResponse> createLocationCustomAttributeDefinitionAsync(
    final CreateLocationCustomAttributeDefinitionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateLocationCustomAttributeDefinitionRequest`](../../doc/models/create-location-custom-attribute-definition-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateLocationCustomAttributeDefinitionResponse`](../../doc/models/create-location-custom-attribute-definition-response.md)

## Example Usage

```java
CustomAttributeDefinition customAttributeDefinition = new CustomAttributeDefinition.Builder()
    .key("bestseller")
    .name("Bestseller")
    .description("Bestselling item at location")
    .visibility("VISIBILITY_READ_WRITE_VALUES")
    .build();

CreateLocationCustomAttributeDefinitionRequest body = new CreateLocationCustomAttributeDefinitionRequest.Builder(
        customAttributeDefinition)
    .build();

locationCustomAttributesApi.createLocationCustomAttributeDefinitionAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Location Custom Attribute Definition

Deletes a location-related [custom attribute definition](../../doc/models/custom-attribute-definition.md) from a Square seller account.
Deleting a custom attribute definition also deletes the corresponding custom attribute from
all locations.
Only the definition owner can delete a custom attribute definition.

```java
CompletableFuture<DeleteLocationCustomAttributeDefinitionResponse> deleteLocationCustomAttributeDefinitionAsync(
    final String key)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to delete. |

## Response Type

[`DeleteLocationCustomAttributeDefinitionResponse`](../../doc/models/delete-location-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";

locationCustomAttributesApi.deleteLocationCustomAttributeDefinitionAsync(key).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Location Custom Attribute Definition

Retrieves a location-related [custom attribute definition](../../doc/models/custom-attribute-definition.md) from a Square seller account.
To retrieve a custom attribute definition created by another application, the `visibility`
setting must be `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<RetrieveLocationCustomAttributeDefinitionResponse> retrieveLocationCustomAttributeDefinitionAsync(
    final String key,
    final Integer version)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to retrieve. If the requesting application<br>is not the definition owner, you must use the qualified key. |
| `version` | `Integer` | Query, Optional | The current version of the custom attribute definition, which is used for strongly consistent<br>reads to guarantee that you receive the most up-to-date data. When included in the request,<br>Square returns the specified version or a higher version if one exists. If the specified version<br>is higher than the current version, Square returns a `BAD_REQUEST` error. |

## Response Type

[`RetrieveLocationCustomAttributeDefinitionResponse`](../../doc/models/retrieve-location-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";

locationCustomAttributesApi.retrieveLocationCustomAttributeDefinitionAsync(key, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Location Custom Attribute Definition

Updates a location-related [custom attribute definition](../../doc/models/custom-attribute-definition.md) for a Square seller account.
Use this endpoint to update the following fields: `name`, `description`, `visibility`, or the
`schema` for a `Selection` data type.
Only the definition owner can update a custom attribute definition.

```java
CompletableFuture<UpdateLocationCustomAttributeDefinitionResponse> updateLocationCustomAttributeDefinitionAsync(
    final String key,
    final UpdateLocationCustomAttributeDefinitionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to update. |
| `body` | [`UpdateLocationCustomAttributeDefinitionRequest`](../../doc/models/update-location-custom-attribute-definition-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateLocationCustomAttributeDefinitionResponse`](../../doc/models/update-location-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";
CustomAttributeDefinition customAttributeDefinition = new CustomAttributeDefinition.Builder()
    .description("Update the description as desired.")
    .visibility("VISIBILITY_READ_ONLY")
    .build();

UpdateLocationCustomAttributeDefinitionRequest body = new UpdateLocationCustomAttributeDefinitionRequest.Builder(
        customAttributeDefinition)
    .build();

locationCustomAttributesApi.updateLocationCustomAttributeDefinitionAsync(key, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Bulk Delete Location Custom Attributes

Deletes [custom attributes](../../doc/models/custom-attribute.md) for locations as a bulk operation.
To delete a custom attribute owned by another application, the `visibility` setting must be
`VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<BulkDeleteLocationCustomAttributesResponse> bulkDeleteLocationCustomAttributesAsync(
    final BulkDeleteLocationCustomAttributesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkDeleteLocationCustomAttributesRequest`](../../doc/models/bulk-delete-location-custom-attributes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkDeleteLocationCustomAttributesResponse`](../../doc/models/bulk-delete-location-custom-attributes-response.md)

## Example Usage

```java
Map<String, BulkDeleteLocationCustomAttributesRequestLocationCustomAttributeDeleteRequest> values = new LinkedHashMap<>();
values.put("id1", values0);
values.put("id2", values1);
values.put("id3", values2);

BulkDeleteLocationCustomAttributesRequest body = new BulkDeleteLocationCustomAttributesRequest.Builder(
        values)
    .build();

locationCustomAttributesApi.bulkDeleteLocationCustomAttributesAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Bulk Upsert Location Custom Attributes

Creates or updates [custom attributes](../../doc/models/custom-attribute.md) for locations as a bulk operation.
Use this endpoint to set the value of one or more custom attributes for one or more locations.
A custom attribute is based on a custom attribute definition in a Square seller account, which is
created using the [CreateLocationCustomAttributeDefinition](../../doc/api/location-custom-attributes.md#create-location-custom-attribute-definition) endpoint.
This `BulkUpsertLocationCustomAttributes` endpoint accepts a map of 1 to 25 individual upsert
requests and returns a map of individual upsert responses. Each upsert request has a unique ID
and provides a location ID and custom attribute. Each upsert response is returned with the ID
of the corresponding request.
To create or update a custom attribute owned by another application, the `visibility` setting
must be `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<BulkUpsertLocationCustomAttributesResponse> bulkUpsertLocationCustomAttributesAsync(
    final BulkUpsertLocationCustomAttributesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkUpsertLocationCustomAttributesRequest`](../../doc/models/bulk-upsert-location-custom-attributes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkUpsertLocationCustomAttributesResponse`](../../doc/models/bulk-upsert-location-custom-attributes-response.md)

## Example Usage

```java
Map<String, BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest> values = new LinkedHashMap<>();
CustomAttribute customAttribute = new CustomAttribute.Builder()
    .build();

BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest values0 = new BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest.Builder(
        "location_id8",
        customAttribute)
    .build();

values.put("key0", values0);
CustomAttribute customAttribute = new CustomAttribute.Builder()
    .build();

BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest values1 = new BulkUpsertLocationCustomAttributesRequestLocationCustomAttributeUpsertRequest.Builder(
        "location_id9",
        customAttribute)
    .build();

values.put("key1", values1);

BulkUpsertLocationCustomAttributesRequest body = new BulkUpsertLocationCustomAttributesRequest.Builder(
        values)
    .build();

locationCustomAttributesApi.bulkUpsertLocationCustomAttributesAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# List Location Custom Attributes

Lists the [custom attributes](../../doc/models/custom-attribute.md) associated with a location.
You can use the `with_definitions` query parameter to also retrieve custom attribute definitions
in the same call.
When all response pages are retrieved, the results include all custom attributes that are
visible to the requesting application, including those that are owned by other applications
and set to `VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<ListLocationCustomAttributesResponse> listLocationCustomAttributesAsync(
    final String locationId,
    final String visibilityFilter,
    final Integer limit,
    final String cursor,
    final Boolean withDefinitions)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the target [location](../../doc/models/location.md). |
| `visibilityFilter` | [`String`](../../doc/models/visibility-filter.md) | Query, Optional | Filters the `CustomAttributeDefinition` results by their `visibility` values. |
| `limit` | `Integer` | Query, Optional | The maximum number of results to return in a single paged response. This limit is advisory.<br>The response might contain more or fewer results. The minimum value is 1 and the maximum value is 100.<br>The default value is 20. For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `cursor` | `String` | Query, Optional | The cursor returned in the paged response from the previous call to this endpoint.<br>Provide this cursor to retrieve the next page of results for your original request. For more<br>information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `withDefinitions` | `Boolean` | Query, Optional | Indicates whether to return the [custom attribute definition](../../doc/models/custom-attribute-definition.md) in the `definition` field of each<br>custom attribute. Set this parameter to `true` to get the name and description of each custom<br>attribute, information about the data type, or other definition details. The default value is `false`.<br>**Default**: `false` |

## Response Type

[`ListLocationCustomAttributesResponse`](../../doc/models/list-location-custom-attributes-response.md)

## Example Usage

```java
String locationId = "location_id4";
Boolean withDefinitions = false;

locationCustomAttributesApi.listLocationCustomAttributesAsync(locationId, null, null, null, withDefinitions).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Delete Location Custom Attribute

Deletes a [custom attribute](../../doc/models/custom-attribute.md) associated with a location.
To delete a custom attribute owned by another application, the `visibility` setting must be
`VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<DeleteLocationCustomAttributeResponse> deleteLocationCustomAttributeAsync(
    final String locationId,
    final String key)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the target [location](../../doc/models/location.md). |
| `key` | `String` | Template, Required | The key of the custom attribute to delete. This key must match the `key` of a custom<br>attribute definition in the Square seller account. If the requesting application is not the<br>definition owner, you must use the qualified key. |

## Response Type

[`DeleteLocationCustomAttributeResponse`](../../doc/models/delete-location-custom-attribute-response.md)

## Example Usage

```java
String locationId = "location_id4";
String key = "key0";

locationCustomAttributesApi.deleteLocationCustomAttributeAsync(locationId, key).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Location Custom Attribute

Retrieves a [custom attribute](../../doc/models/custom-attribute.md) associated with a location.
You can use the `with_definition` query parameter to also retrieve the custom attribute definition
in the same call.
To retrieve a custom attribute owned by another application, the `visibility` setting must be
`VISIBILITY_READ_ONLY` or `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<RetrieveLocationCustomAttributeResponse> retrieveLocationCustomAttributeAsync(
    final String locationId,
    final String key,
    final Boolean withDefinition,
    final Integer version)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the target [location](../../doc/models/location.md). |
| `key` | `String` | Template, Required | The key of the custom attribute to retrieve. This key must match the `key` of a custom<br>attribute definition in the Square seller account. If the requesting application is not the<br>definition owner, you must use the qualified key. |
| `withDefinition` | `Boolean` | Query, Optional | Indicates whether to return the [custom attribute definition](../../doc/models/custom-attribute-definition.md) in the `definition` field of<br>the custom attribute. Set this parameter to `true` to get the name and description of the custom<br>attribute, information about the data type, or other definition details. The default value is `false`.<br>**Default**: `false` |
| `version` | `Integer` | Query, Optional | The current version of the custom attribute, which is used for strongly consistent reads to<br>guarantee that you receive the most up-to-date data. When included in the request, Square<br>returns the specified version or a higher version if one exists. If the specified version is<br>higher than the current version, Square returns a `BAD_REQUEST` error. |

## Response Type

[`RetrieveLocationCustomAttributeResponse`](../../doc/models/retrieve-location-custom-attribute-response.md)

## Example Usage

```java
String locationId = "location_id4";
String key = "key0";
Boolean withDefinition = false;

locationCustomAttributesApi.retrieveLocationCustomAttributeAsync(locationId, key, withDefinition, null).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Upsert Location Custom Attribute

Creates or updates a [custom attribute](../../doc/models/custom-attribute.md) for a location.
Use this endpoint to set the value of a custom attribute for a specified location.
A custom attribute is based on a custom attribute definition in a Square seller account, which
is created using the [CreateLocationCustomAttributeDefinition](../../doc/api/location-custom-attributes.md#create-location-custom-attribute-definition) endpoint.
To create or update a custom attribute owned by another application, the `visibility` setting
must be `VISIBILITY_READ_WRITE_VALUES`.

```java
CompletableFuture<UpsertLocationCustomAttributeResponse> upsertLocationCustomAttributeAsync(
    final String locationId,
    final String key,
    final UpsertLocationCustomAttributeRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the target [location](../../doc/models/location.md). |
| `key` | `String` | Template, Required | The key of the custom attribute to create or update. This key must match the `key` of a<br>custom attribute definition in the Square seller account. If the requesting application is not<br>the definition owner, you must use the qualified key. |
| `body` | [`UpsertLocationCustomAttributeRequest`](../../doc/models/upsert-location-custom-attribute-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpsertLocationCustomAttributeResponse`](../../doc/models/upsert-location-custom-attribute-response.md)

## Example Usage

```java
String locationId = "location_id4";
String key = "key0";
CustomAttribute customAttribute = new CustomAttribute.Builder()
    .build();

UpsertLocationCustomAttributeRequest body = new UpsertLocationCustomAttributeRequest.Builder(
        customAttribute)
    .build();

locationCustomAttributesApi.upsertLocationCustomAttributeAsync(locationId, key, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


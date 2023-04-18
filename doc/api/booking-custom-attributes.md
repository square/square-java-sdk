# Booking Custom Attributes

```java
BookingCustomAttributesApi bookingCustomAttributesApi = client.getBookingCustomAttributesApi();
```

## Class Name

`BookingCustomAttributesApi`

## Methods

* [List Booking Custom Attribute Definitions](../../doc/api/booking-custom-attributes.md#list-booking-custom-attribute-definitions)
* [Create Booking Custom Attribute Definition](../../doc/api/booking-custom-attributes.md#create-booking-custom-attribute-definition)
* [Delete Booking Custom Attribute Definition](../../doc/api/booking-custom-attributes.md#delete-booking-custom-attribute-definition)
* [Retrieve Booking Custom Attribute Definition](../../doc/api/booking-custom-attributes.md#retrieve-booking-custom-attribute-definition)
* [Update Booking Custom Attribute Definition](../../doc/api/booking-custom-attributes.md#update-booking-custom-attribute-definition)
* [Bulk Delete Booking Custom Attributes](../../doc/api/booking-custom-attributes.md#bulk-delete-booking-custom-attributes)
* [Bulk Upsert Booking Custom Attributes](../../doc/api/booking-custom-attributes.md#bulk-upsert-booking-custom-attributes)
* [List Booking Custom Attributes](../../doc/api/booking-custom-attributes.md#list-booking-custom-attributes)
* [Delete Booking Custom Attribute](../../doc/api/booking-custom-attributes.md#delete-booking-custom-attribute)
* [Retrieve Booking Custom Attribute](../../doc/api/booking-custom-attributes.md#retrieve-booking-custom-attribute)
* [Upsert Booking Custom Attribute](../../doc/api/booking-custom-attributes.md#upsert-booking-custom-attribute)


# List Booking Custom Attribute Definitions

Get all bookings custom attribute definitions.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.

```java
CompletableFuture<ListBookingCustomAttributeDefinitionsResponse> listBookingCustomAttributeDefinitionsAsync(
    final Integer limit,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `limit` | `Integer` | Query, Optional | The maximum number of results to return in a single paged response. This limit is advisory.<br>The response might contain more or fewer results. The minimum value is 1 and the maximum value is 100.<br>The default value is 20. For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `cursor` | `String` | Query, Optional | The cursor returned in the paged response from the previous call to this endpoint.<br>Provide this cursor to retrieve the next page of results for your original request.<br>For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |

## Response Type

[`ListBookingCustomAttributeDefinitionsResponse`](../../doc/models/list-booking-custom-attribute-definitions-response.md)

## Example Usage

```java
bookingCustomAttributesApi.listBookingCustomAttributeDefinitionsAsync(null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Create Booking Custom Attribute Definition

Creates a bookings custom attribute definition.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<CreateBookingCustomAttributeDefinitionResponse> createBookingCustomAttributeDefinitionAsync(
    final CreateBookingCustomAttributeDefinitionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateBookingCustomAttributeDefinitionRequest`](../../doc/models/create-booking-custom-attribute-definition-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateBookingCustomAttributeDefinitionResponse`](../../doc/models/create-booking-custom-attribute-definition-response.md)

## Example Usage

```java
CreateBookingCustomAttributeDefinitionRequest body = new CreateBookingCustomAttributeDefinitionRequest.Builder(
    new CustomAttributeDefinition.Builder()
        .build()
)
.build();

bookingCustomAttributesApi.createBookingCustomAttributeDefinitionAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Delete Booking Custom Attribute Definition

Deletes a bookings custom attribute definition.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<DeleteBookingCustomAttributeDefinitionResponse> deleteBookingCustomAttributeDefinitionAsync(
    final String key)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to delete. |

## Response Type

[`DeleteBookingCustomAttributeDefinitionResponse`](../../doc/models/delete-booking-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";

bookingCustomAttributesApi.deleteBookingCustomAttributeDefinitionAsync(key).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Booking Custom Attribute Definition

Retrieves a bookings custom attribute definition.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.

```java
CompletableFuture<RetrieveBookingCustomAttributeDefinitionResponse> retrieveBookingCustomAttributeDefinitionAsync(
    final String key,
    final Integer version)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to retrieve. If the requesting application<br>is not the definition owner, you must use the qualified key. |
| `version` | `Integer` | Query, Optional | The current version of the custom attribute definition, which is used for strongly consistent<br>reads to guarantee that you receive the most up-to-date data. When included in the request,<br>Square returns the specified version or a higher version if one exists. If the specified version<br>is higher than the current version, Square returns a `BAD_REQUEST` error. |

## Response Type

[`RetrieveBookingCustomAttributeDefinitionResponse`](../../doc/models/retrieve-booking-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";

bookingCustomAttributesApi.retrieveBookingCustomAttributeDefinitionAsync(key, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Update Booking Custom Attribute Definition

Updates a bookings custom attribute definition.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<UpdateBookingCustomAttributeDefinitionResponse> updateBookingCustomAttributeDefinitionAsync(
    final String key,
    final UpdateBookingCustomAttributeDefinitionRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `key` | `String` | Template, Required | The key of the custom attribute definition to update. |
| `body` | [`UpdateBookingCustomAttributeDefinitionRequest`](../../doc/models/update-booking-custom-attribute-definition-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpdateBookingCustomAttributeDefinitionResponse`](../../doc/models/update-booking-custom-attribute-definition-response.md)

## Example Usage

```java
String key = "key0";
UpdateBookingCustomAttributeDefinitionRequest body = new UpdateBookingCustomAttributeDefinitionRequest.Builder(
    new CustomAttributeDefinition.Builder()
        .build()
)
.build();

bookingCustomAttributesApi.updateBookingCustomAttributeDefinitionAsync(key, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Bulk Delete Booking Custom Attributes

Bulk deletes bookings custom attributes.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<BulkDeleteBookingCustomAttributesResponse> bulkDeleteBookingCustomAttributesAsync(
    final BulkDeleteBookingCustomAttributesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkDeleteBookingCustomAttributesRequest`](../../doc/models/bulk-delete-booking-custom-attributes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkDeleteBookingCustomAttributesResponse`](../../doc/models/bulk-delete-booking-custom-attributes-response.md)

## Example Usage

```java
BulkDeleteBookingCustomAttributesRequest body = new BulkDeleteBookingCustomAttributesRequest.Builder(
    new LinkedHashMap<String, BookingCustomAttributeDeleteRequest>() {{
        put("key0", new BookingCustomAttributeDeleteRequest.Builder(
            "booking_id8",
            "key4"
        )
        .build());
        put("key1", new BookingCustomAttributeDeleteRequest.Builder(
            "booking_id9",
            "key5"
        )
        .build());
    }}
)
.build();

bookingCustomAttributesApi.bulkDeleteBookingCustomAttributesAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Bulk Upsert Booking Custom Attributes

Bulk upserts bookings custom attributes.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<BulkUpsertBookingCustomAttributesResponse> bulkUpsertBookingCustomAttributesAsync(
    final BulkUpsertBookingCustomAttributesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkUpsertBookingCustomAttributesRequest`](../../doc/models/bulk-upsert-booking-custom-attributes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkUpsertBookingCustomAttributesResponse`](../../doc/models/bulk-upsert-booking-custom-attributes-response.md)

## Example Usage

```java
BulkUpsertBookingCustomAttributesRequest body = new BulkUpsertBookingCustomAttributesRequest.Builder(
    new LinkedHashMap<String, BookingCustomAttributeUpsertRequest>() {{
        put("key0", new BookingCustomAttributeUpsertRequest.Builder(
            "booking_id8",
            new CustomAttribute.Builder()
                .build()
        )
        .build());
        put("key1", new BookingCustomAttributeUpsertRequest.Builder(
            "booking_id9",
            new CustomAttribute.Builder()
                .build()
        )
        .build());
    }}
)
.build();

bookingCustomAttributesApi.bulkUpsertBookingCustomAttributesAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# List Booking Custom Attributes

Lists a booking's custom attributes.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.

```java
CompletableFuture<ListBookingCustomAttributesResponse> listBookingCustomAttributesAsync(
    final String bookingId,
    final Integer limit,
    final String cursor,
    final Boolean withDefinitions)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bookingId` | `String` | Template, Required | The ID of the target [booking](entity:Booking). |
| `limit` | `Integer` | Query, Optional | The maximum number of results to return in a single paged response. This limit is advisory.<br>The response might contain more or fewer results. The minimum value is 1 and the maximum value is 100.<br>The default value is 20. For more information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `cursor` | `String` | Query, Optional | The cursor returned in the paged response from the previous call to this endpoint.<br>Provide this cursor to retrieve the next page of results for your original request. For more<br>information, see [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination). |
| `withDefinitions` | `Boolean` | Query, Optional | Indicates whether to return the [custom attribute definition](entity:CustomAttributeDefinition) in the `definition` field of each<br>custom attribute. Set this parameter to `true` to get the name and description of each custom<br>attribute, information about the data type, or other definition details. The default value is `false`.<br>**Default**: `false` |

## Response Type

[`ListBookingCustomAttributesResponse`](../../doc/models/list-booking-custom-attributes-response.md)

## Example Usage

```java
String bookingId = "booking_id4";
Boolean withDefinitions = false;

bookingCustomAttributesApi.listBookingCustomAttributesAsync(bookingId, null, null, withDefinitions).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Delete Booking Custom Attribute

Deletes a bookings custom attribute.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<DeleteBookingCustomAttributeResponse> deleteBookingCustomAttributeAsync(
    final String bookingId,
    final String key)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bookingId` | `String` | Template, Required | The ID of the target [booking](entity:Booking). |
| `key` | `String` | Template, Required | The key of the custom attribute to delete. This key must match the `key` of a custom<br>attribute definition in the Square seller account. If the requesting application is not the<br>definition owner, you must use the qualified key. |

## Response Type

[`DeleteBookingCustomAttributeResponse`](../../doc/models/delete-booking-custom-attribute-response.md)

## Example Usage

```java
String bookingId = "booking_id4";
String key = "key0";

bookingCustomAttributesApi.deleteBookingCustomAttributeAsync(bookingId, key).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Booking Custom Attribute

Retrieves a bookings custom attribute.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_READ` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_READ` and `APPOINTMENTS_READ` for the OAuth scope.

```java
CompletableFuture<RetrieveBookingCustomAttributeResponse> retrieveBookingCustomAttributeAsync(
    final String bookingId,
    final String key,
    final Boolean withDefinition,
    final Integer version)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bookingId` | `String` | Template, Required | The ID of the target [booking](entity:Booking). |
| `key` | `String` | Template, Required | The key of the custom attribute to retrieve. This key must match the `key` of a custom<br>attribute definition in the Square seller account. If the requesting application is not the<br>definition owner, you must use the qualified key. |
| `withDefinition` | `Boolean` | Query, Optional | Indicates whether to return the [custom attribute definition](entity:CustomAttributeDefinition) in the `definition` field of<br>the custom attribute. Set this parameter to `true` to get the name and description of the custom<br>attribute, information about the data type, or other definition details. The default value is `false`.<br>**Default**: `false` |
| `version` | `Integer` | Query, Optional | The current version of the custom attribute, which is used for strongly consistent reads to<br>guarantee that you receive the most up-to-date data. When included in the request, Square<br>returns the specified version or a higher version if one exists. If the specified version is<br>higher than the current version, Square returns a `BAD_REQUEST` error. |

## Response Type

[`RetrieveBookingCustomAttributeResponse`](../../doc/models/retrieve-booking-custom-attribute-response.md)

## Example Usage

```java
String bookingId = "booking_id4";
String key = "key0";
Boolean withDefinition = false;

bookingCustomAttributesApi.retrieveBookingCustomAttributeAsync(bookingId, key, withDefinition, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Upsert Booking Custom Attribute

Upserts a bookings custom attribute.

To call this endpoint with buyer-level permissions, set `APPOINTMENTS_WRITE` for the OAuth scope.
To call this endpoint with seller-level permissions, set `APPOINTMENTS_ALL_WRITE` and `APPOINTMENTS_WRITE` for the OAuth scope.

For calls to this endpoint with seller-level permissions to succeed, the seller must have subscribed to *Appointments Plus*
or *Appointments Premium*.

```java
CompletableFuture<UpsertBookingCustomAttributeResponse> upsertBookingCustomAttributeAsync(
    final String bookingId,
    final String key,
    final UpsertBookingCustomAttributeRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `bookingId` | `String` | Template, Required | The ID of the target [booking](entity:Booking). |
| `key` | `String` | Template, Required | The key of the custom attribute to create or update. This key must match the `key` of a<br>custom attribute definition in the Square seller account. If the requesting application is not<br>the definition owner, you must use the qualified key. |
| `body` | [`UpsertBookingCustomAttributeRequest`](../../doc/models/upsert-booking-custom-attribute-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`UpsertBookingCustomAttributeResponse`](../../doc/models/upsert-booking-custom-attribute-response.md)

## Example Usage

```java
String bookingId = "booking_id4";
String key = "key0";
UpsertBookingCustomAttributeRequest body = new UpsertBookingCustomAttributeRequest.Builder(
    new CustomAttribute.Builder()
        .build()
)
.build();

bookingCustomAttributesApi.upsertBookingCustomAttributeAsync(bookingId, key, body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


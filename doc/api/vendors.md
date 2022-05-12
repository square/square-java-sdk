# Vendors

```java
VendorsApi vendorsApi = client.getVendorsApi();
```

## Class Name

`VendorsApi`

## Methods

* [Bulk Create Vendors](../../doc/api/vendors.md#bulk-create-vendors)
* [Bulk Retrieve Vendors](../../doc/api/vendors.md#bulk-retrieve-vendors)
* [Bulk Update Vendors](../../doc/api/vendors.md#bulk-update-vendors)
* [Create Vendor](../../doc/api/vendors.md#create-vendor)
* [Search Vendors](../../doc/api/vendors.md#search-vendors)
* [Retrieve Vendor](../../doc/api/vendors.md#retrieve-vendor)
* [Update Vendor](../../doc/api/vendors.md#update-vendor)


# Bulk Create Vendors

Creates one or more [Vendor](../../doc/models/vendor.md) objects to represent suppliers to a seller.

```java
CompletableFuture<BulkCreateVendorsResponse> bulkCreateVendorsAsync(
    final BulkCreateVendorsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkCreateVendorsRequest`](../../doc/models/bulk-create-vendors-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkCreateVendorsResponse`](../../doc/models/bulk-create-vendors-response.md)

## Example Usage

```java
Map<String, Vendor> bodyVendors = new LinkedHashMap<>();

Vendor bodyVendors0 = new Vendor.Builder()
    .build();
bodyVendors.put("",bodyVendors0);

Vendor bodyVendors1 = new Vendor.Builder()
    .build();
bodyVendors.put("",bodyVendors1);

BulkCreateVendorsRequest body = new BulkCreateVendorsRequest.Builder(
        vendors)
    .build();

vendorsApi.bulkCreateVendorsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Bulk Retrieve Vendors

Retrieves one or more vendors of specified [Vendor](../../doc/models/vendor.md) IDs.

```java
CompletableFuture<BulkRetrieveVendorsResponse> bulkRetrieveVendorsAsync(
    final BulkRetrieveVendorsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkRetrieveVendorsRequest`](../../doc/models/bulk-retrieve-vendors-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkRetrieveVendorsResponse`](../../doc/models/bulk-retrieve-vendors-response.md)

## Example Usage

```java
List<String> bodyVendorIds = new LinkedList<>();
bodyVendorIds.add("INV_V_JDKYHBWT1D4F8MFH63DBMEN8Y4");
BulkRetrieveVendorsRequest body = new BulkRetrieveVendorsRequest.Builder()
    .vendorIds(bodyVendorIds)
    .build();

vendorsApi.bulkRetrieveVendorsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Bulk Update Vendors

Updates one or more of existing [Vendor](../../doc/models/vendor.md) objects as suppliers to a seller.

```java
CompletableFuture<BulkUpdateVendorsResponse> bulkUpdateVendorsAsync(
    final BulkUpdateVendorsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BulkUpdateVendorsRequest`](../../doc/models/bulk-update-vendors-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BulkUpdateVendorsResponse`](../../doc/models/bulk-update-vendors-response.md)

## Example Usage

```java
Map<String, UpdateVendorRequest> bodyVendors = new LinkedHashMap<>();

Vendor vendor = new Vendor.Builder()
    .build();
UpdateVendorRequest bodyVendors0 = new UpdateVendorRequest.Builder(
        vendor)
    .build();
bodyVendors.put("",bodyVendors0);

Vendor vendor = new Vendor.Builder()
    .build();
UpdateVendorRequest bodyVendors1 = new UpdateVendorRequest.Builder(
        vendor)
    .build();
bodyVendors.put("",bodyVendors1);

BulkUpdateVendorsRequest body = new BulkUpdateVendorsRequest.Builder(
        vendors)
    .build();

vendorsApi.bulkUpdateVendorsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Create Vendor

Creates a single [Vendor](../../doc/models/vendor.md) object to represent a supplier to a seller.

```java
CompletableFuture<CreateVendorResponse> createVendorAsync(
    final CreateVendorRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateVendorRequest`](../../doc/models/create-vendor-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`CreateVendorResponse`](../../doc/models/create-vendor-response.md)

## Example Usage

```java
CreateVendorRequest body = new CreateVendorRequest.Builder(
        "idempotency_key2")
    .build();

vendorsApi.createVendorAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Search Vendors

Searches for vendors using a filter against supported [Vendor](../../doc/models/vendor.md) properties and a supported sorter.

```java
CompletableFuture<SearchVendorsResponse> searchVendorsAsync(
    final SearchVendorsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchVendorsRequest`](../../doc/models/search-vendors-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`SearchVendorsResponse`](../../doc/models/search-vendors-response.md)

## Example Usage

```java
SearchVendorsRequest body = new SearchVendorsRequest.Builder()
    .build();

vendorsApi.searchVendorsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Retrieve Vendor

Retrieves the vendor of a specified [Vendor](../../doc/models/vendor.md) ID.

```java
CompletableFuture<RetrieveVendorResponse> retrieveVendorAsync(
    final String vendorId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `vendorId` | `String` | Template, Required | ID of the [Vendor](../../doc/models/vendor.md) to retrieve. |

## Response Type

[`RetrieveVendorResponse`](../../doc/models/retrieve-vendor-response.md)

## Example Usage

```java
String vendorId = "vendor_id8";

vendorsApi.retrieveVendorAsync(vendorId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


# Update Vendor

Updates an existing [Vendor](../../doc/models/vendor.md) object as a supplier to a seller.

```java
CompletableFuture<UpdateVendorResponse> updateVendorAsync(
    final UpdateVendorRequest body,
    final String vendorId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`UpdateVendorRequest`](../../doc/models/update-vendor-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |
| `vendorId` | `String` | Template, Required | - |

## Response Type

[`UpdateVendorResponse`](../../doc/models/update-vendor-response.md)

## Example Usage

```java
Vendor vendor = new Vendor.Builder()
    .id("INV_V_JDKYHBWT1D4F8MFH63DBMEN8Y4")
    .name("Jack's Chicken Shack")
    .version(1)
    .status("ACTIVE")
    .build();
UpdateVendorRequest body = new UpdateVendorRequest.Builder(
        vendor)
    .idempotencyKey("8fc6a5b0-9fe8-4b46-b46b-2ef95793abbe")
    .build();
String vendorId = "vendor_id8";

vendorsApi.updateVendorAsync(body, vendorId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


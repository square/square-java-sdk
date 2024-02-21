# Inventory

```java
InventoryApi inventoryApi = client.getInventoryApi();
```

## Class Name

`InventoryApi`

## Methods

* [Deprecated Retrieve Inventory Adjustment](../../doc/api/inventory.md#deprecated-retrieve-inventory-adjustment)
* [Retrieve Inventory Adjustment](../../doc/api/inventory.md#retrieve-inventory-adjustment)
* [Deprecated Batch Change Inventory](../../doc/api/inventory.md#deprecated-batch-change-inventory)
* [Deprecated Batch Retrieve Inventory Changes](../../doc/api/inventory.md#deprecated-batch-retrieve-inventory-changes)
* [Deprecated Batch Retrieve Inventory Counts](../../doc/api/inventory.md#deprecated-batch-retrieve-inventory-counts)
* [Batch Change Inventory](../../doc/api/inventory.md#batch-change-inventory)
* [Batch Retrieve Inventory Changes](../../doc/api/inventory.md#batch-retrieve-inventory-changes)
* [Batch Retrieve Inventory Counts](../../doc/api/inventory.md#batch-retrieve-inventory-counts)
* [Deprecated Retrieve Inventory Physical Count](../../doc/api/inventory.md#deprecated-retrieve-inventory-physical-count)
* [Retrieve Inventory Physical Count](../../doc/api/inventory.md#retrieve-inventory-physical-count)
* [Retrieve Inventory Transfer](../../doc/api/inventory.md#retrieve-inventory-transfer)
* [Retrieve Inventory Count](../../doc/api/inventory.md#retrieve-inventory-count)
* [Retrieve Inventory Changes](../../doc/api/inventory.md#retrieve-inventory-changes)


# Deprecated Retrieve Inventory Adjustment

**This endpoint is deprecated.**

Deprecated version of [RetrieveInventoryAdjustment](api-endpoint:Inventory-RetrieveInventoryAdjustment) after the endpoint URL
is updated to conform to the standard convention.

```java
CompletableFuture<RetrieveInventoryAdjustmentResponse> deprecatedRetrieveInventoryAdjustmentAsync(
    final String adjustmentId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `adjustmentId` | `String` | Template, Required | ID of the [InventoryAdjustment](entity:InventoryAdjustment) to retrieve. |

## Response Type

[`RetrieveInventoryAdjustmentResponse`](../../doc/models/retrieve-inventory-adjustment-response.md)

## Example Usage

```java
String adjustmentId = "adjustment_id0";

inventoryApi.deprecatedRetrieveInventoryAdjustmentAsync(adjustmentId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Inventory Adjustment

Returns the [InventoryAdjustment](../../doc/models/inventory-adjustment.md) object
with the provided `adjustment_id`.

```java
CompletableFuture<RetrieveInventoryAdjustmentResponse> retrieveInventoryAdjustmentAsync(
    final String adjustmentId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `adjustmentId` | `String` | Template, Required | ID of the [InventoryAdjustment](entity:InventoryAdjustment) to retrieve. |

## Response Type

[`RetrieveInventoryAdjustmentResponse`](../../doc/models/retrieve-inventory-adjustment-response.md)

## Example Usage

```java
String adjustmentId = "adjustment_id0";

inventoryApi.retrieveInventoryAdjustmentAsync(adjustmentId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Deprecated Batch Change Inventory

**This endpoint is deprecated.**

Deprecated version of [BatchChangeInventory](api-endpoint:Inventory-BatchChangeInventory) after the endpoint URL
is updated to conform to the standard convention.

```java
CompletableFuture<BatchChangeInventoryResponse> deprecatedBatchChangeInventoryAsync(
    final BatchChangeInventoryRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchChangeInventoryRequest`](../../doc/models/batch-change-inventory-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchChangeInventoryResponse`](../../doc/models/batch-change-inventory-response.md)

## Example Usage

```java
BatchChangeInventoryRequest body = new BatchChangeInventoryRequest.Builder(
    "8fc6a5b0-9fe8-4b46-b46b-2ef95793abbe"
)
.changes(Arrays.asList(
        new InventoryChange.Builder()
            .type("PHYSICAL_COUNT")
            .physicalCount(new InventoryPhysicalCount.Builder()
                .referenceId("1536bfbf-efed-48bf-b17d-a197141b2a92")
                .catalogObjectId("W62UWFY35CWMYGVWK6TWJDNI")
                .state("IN_STOCK")
                .locationId("C6W5YS5QM06F5")
                .quantity("53")
                .teamMemberId("LRK57NSQ5X7PUD05")
                .occurredAt("2016-11-16T22:25:24.878Z")
                .build())
            .build()
    ))
.ignoreUnchangedCounts(true)
.build();

inventoryApi.deprecatedBatchChangeInventoryAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Deprecated Batch Retrieve Inventory Changes

**This endpoint is deprecated.**

Deprecated version of [BatchRetrieveInventoryChanges](api-endpoint:Inventory-BatchRetrieveInventoryChanges) after the endpoint URL
is updated to conform to the standard convention.

```java
CompletableFuture<BatchRetrieveInventoryChangesResponse> deprecatedBatchRetrieveInventoryChangesAsync(
    final BatchRetrieveInventoryChangesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveInventoryChangesRequest`](../../doc/models/batch-retrieve-inventory-changes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchRetrieveInventoryChangesResponse`](../../doc/models/batch-retrieve-inventory-changes-response.md)

## Example Usage

```java
BatchRetrieveInventoryChangesRequest body = new BatchRetrieveInventoryChangesRequest.Builder()
    .catalogObjectIds(Arrays.asList(
        "W62UWFY35CWMYGVWK6TWJDNI"
    ))
    .locationIds(Arrays.asList(
        "C6W5YS5QM06F5"
    ))
    .types(Arrays.asList(
        "PHYSICAL_COUNT"
    ))
    .states(Arrays.asList(
        "IN_STOCK"
    ))
    .updatedAfter("2016-11-01T00:00:00.000Z")
    .updatedBefore("2016-12-01T00:00:00.000Z")
    .build();

inventoryApi.deprecatedBatchRetrieveInventoryChangesAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Deprecated Batch Retrieve Inventory Counts

**This endpoint is deprecated.**

Deprecated version of [BatchRetrieveInventoryCounts](api-endpoint:Inventory-BatchRetrieveInventoryCounts) after the endpoint URL
is updated to conform to the standard convention.

```java
CompletableFuture<BatchRetrieveInventoryCountsResponse> deprecatedBatchRetrieveInventoryCountsAsync(
    final BatchRetrieveInventoryCountsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveInventoryCountsRequest`](../../doc/models/batch-retrieve-inventory-counts-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchRetrieveInventoryCountsResponse`](../../doc/models/batch-retrieve-inventory-counts-response.md)

## Example Usage

```java
BatchRetrieveInventoryCountsRequest body = new BatchRetrieveInventoryCountsRequest.Builder()
    .catalogObjectIds(Arrays.asList(
        "W62UWFY35CWMYGVWK6TWJDNI"
    ))
    .locationIds(Arrays.asList(
        "59TNP9SA8VGDA"
    ))
    .updatedAfter("2016-11-16T00:00:00.000Z")
    .build();

inventoryApi.deprecatedBatchRetrieveInventoryCountsAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Batch Change Inventory

Applies adjustments and counts to the provided item quantities.

On success: returns the current calculated counts for all objects
referenced in the request.
On failure: returns a list of related errors.

```java
CompletableFuture<BatchChangeInventoryResponse> batchChangeInventoryAsync(
    final BatchChangeInventoryRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchChangeInventoryRequest`](../../doc/models/batch-change-inventory-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchChangeInventoryResponse`](../../doc/models/batch-change-inventory-response.md)

## Example Usage

```java
BatchChangeInventoryRequest body = new BatchChangeInventoryRequest.Builder(
    "8fc6a5b0-9fe8-4b46-b46b-2ef95793abbe"
)
.changes(Arrays.asList(
        new InventoryChange.Builder()
            .type("PHYSICAL_COUNT")
            .physicalCount(new InventoryPhysicalCount.Builder()
                .referenceId("1536bfbf-efed-48bf-b17d-a197141b2a92")
                .catalogObjectId("W62UWFY35CWMYGVWK6TWJDNI")
                .state("IN_STOCK")
                .locationId("C6W5YS5QM06F5")
                .quantity("53")
                .teamMemberId("LRK57NSQ5X7PUD05")
                .occurredAt("2016-11-16T22:25:24.878Z")
                .build())
            .build()
    ))
.ignoreUnchangedCounts(true)
.build();

inventoryApi.batchChangeInventoryAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Batch Retrieve Inventory Changes

Returns historical physical counts and adjustments based on the
provided filter criteria.

Results are paginated and sorted in ascending order according their
`occurred_at` timestamp (oldest first).

BatchRetrieveInventoryChanges is a catch-all query endpoint for queries
that cannot be handled by other, simpler endpoints.

```java
CompletableFuture<BatchRetrieveInventoryChangesResponse> batchRetrieveInventoryChangesAsync(
    final BatchRetrieveInventoryChangesRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveInventoryChangesRequest`](../../doc/models/batch-retrieve-inventory-changes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchRetrieveInventoryChangesResponse`](../../doc/models/batch-retrieve-inventory-changes-response.md)

## Example Usage

```java
BatchRetrieveInventoryChangesRequest body = new BatchRetrieveInventoryChangesRequest.Builder()
    .catalogObjectIds(Arrays.asList(
        "W62UWFY35CWMYGVWK6TWJDNI"
    ))
    .locationIds(Arrays.asList(
        "C6W5YS5QM06F5"
    ))
    .types(Arrays.asList(
        "PHYSICAL_COUNT"
    ))
    .states(Arrays.asList(
        "IN_STOCK"
    ))
    .updatedAfter("2016-11-01T00:00:00.000Z")
    .updatedBefore("2016-12-01T00:00:00.000Z")
    .build();

inventoryApi.batchRetrieveInventoryChangesAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Batch Retrieve Inventory Counts

Returns current counts for the provided
[CatalogObject](../../doc/models/catalog-object.md)s at the requested
[Location](../../doc/models/location.md)s.

Results are paginated and sorted in descending order according to their
`calculated_at` timestamp (newest first).

When `updated_after` is specified, only counts that have changed since that
time (based on the server timestamp for the most recent change) are
returned. This allows clients to perform a "sync" operation, for example
in response to receiving a Webhook notification.

```java
CompletableFuture<BatchRetrieveInventoryCountsResponse> batchRetrieveInventoryCountsAsync(
    final BatchRetrieveInventoryCountsRequest body)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveInventoryCountsRequest`](../../doc/models/batch-retrieve-inventory-counts-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

## Response Type

[`BatchRetrieveInventoryCountsResponse`](../../doc/models/batch-retrieve-inventory-counts-response.md)

## Example Usage

```java
BatchRetrieveInventoryCountsRequest body = new BatchRetrieveInventoryCountsRequest.Builder()
    .catalogObjectIds(Arrays.asList(
        "W62UWFY35CWMYGVWK6TWJDNI"
    ))
    .locationIds(Arrays.asList(
        "59TNP9SA8VGDA"
    ))
    .updatedAfter("2016-11-16T00:00:00.000Z")
    .build();

inventoryApi.batchRetrieveInventoryCountsAsync(body).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Deprecated Retrieve Inventory Physical Count

**This endpoint is deprecated.**

Deprecated version of [RetrieveInventoryPhysicalCount](api-endpoint:Inventory-RetrieveInventoryPhysicalCount) after the endpoint URL
is updated to conform to the standard convention.

```java
CompletableFuture<RetrieveInventoryPhysicalCountResponse> deprecatedRetrieveInventoryPhysicalCountAsync(
    final String physicalCountId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `physicalCountId` | `String` | Template, Required | ID of the<br>[InventoryPhysicalCount](entity:InventoryPhysicalCount) to retrieve. |

## Response Type

[`RetrieveInventoryPhysicalCountResponse`](../../doc/models/retrieve-inventory-physical-count-response.md)

## Example Usage

```java
String physicalCountId = "physical_count_id2";

inventoryApi.deprecatedRetrieveInventoryPhysicalCountAsync(physicalCountId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Inventory Physical Count

Returns the [InventoryPhysicalCount](../../doc/models/inventory-physical-count.md)
object with the provided `physical_count_id`.

```java
CompletableFuture<RetrieveInventoryPhysicalCountResponse> retrieveInventoryPhysicalCountAsync(
    final String physicalCountId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `physicalCountId` | `String` | Template, Required | ID of the<br>[InventoryPhysicalCount](entity:InventoryPhysicalCount) to retrieve. |

## Response Type

[`RetrieveInventoryPhysicalCountResponse`](../../doc/models/retrieve-inventory-physical-count-response.md)

## Example Usage

```java
String physicalCountId = "physical_count_id2";

inventoryApi.retrieveInventoryPhysicalCountAsync(physicalCountId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Inventory Transfer

Returns the [InventoryTransfer](../../doc/models/inventory-transfer.md) object
with the provided `transfer_id`.

```java
CompletableFuture<RetrieveInventoryTransferResponse> retrieveInventoryTransferAsync(
    final String transferId)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `transferId` | `String` | Template, Required | ID of the [InventoryTransfer](entity:InventoryTransfer) to retrieve. |

## Response Type

[`RetrieveInventoryTransferResponse`](../../doc/models/retrieve-inventory-transfer-response.md)

## Example Usage

```java
String transferId = "transfer_id6";

inventoryApi.retrieveInventoryTransferAsync(transferId).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Inventory Count

Retrieves the current calculated stock count for a given
[CatalogObject](../../doc/models/catalog-object.md) at a given set of
[Location](../../doc/models/location.md)s. Responses are paginated and unsorted.
For more sophisticated queries, use a batch endpoint.

```java
CompletableFuture<RetrieveInventoryCountResponse> retrieveInventoryCountAsync(
    final String catalogObjectId,
    final String locationIds,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `catalogObjectId` | `String` | Template, Required | ID of the [CatalogObject](entity:CatalogObject) to retrieve. |
| `locationIds` | `String` | Query, Optional | The [Location](entity:Location) IDs to look up as a comma-separated<br>list. An empty list queries all locations. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for the original query.<br><br>See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information. |

## Response Type

[`RetrieveInventoryCountResponse`](../../doc/models/retrieve-inventory-count-response.md)

## Example Usage

```java
String catalogObjectId = "catalog_object_id6";

inventoryApi.retrieveInventoryCountAsync(catalogObjectId, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


# Retrieve Inventory Changes

**This endpoint is deprecated.**

Returns a set of physical counts and inventory adjustments for the
provided [CatalogObject](entity:CatalogObject) at the requested
[Location](entity:Location)s.

You can achieve the same result by calling [BatchRetrieveInventoryChanges](api-endpoint:Inventory-BatchRetrieveInventoryChanges)
and having the `catalog_object_ids` list contain a single element of the `CatalogObject` ID.

Results are paginated and sorted in descending order according to their
`occurred_at` timestamp (newest first).

There are no limits on how far back the caller can page. This endpoint can be
used to display recent changes for a specific item. For more
sophisticated queries, use a batch endpoint.

```java
CompletableFuture<RetrieveInventoryChangesResponse> retrieveInventoryChangesAsync(
    final String catalogObjectId,
    final String locationIds,
    final String cursor)
```

## Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `catalogObjectId` | `String` | Template, Required | ID of the [CatalogObject](entity:CatalogObject) to retrieve. |
| `locationIds` | `String` | Query, Optional | The [Location](entity:Location) IDs to look up as a comma-separated<br>list. An empty list queries all locations. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for the original query.<br><br>See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information. |

## Response Type

[`RetrieveInventoryChangesResponse`](../../doc/models/retrieve-inventory-changes-response.md)

## Example Usage

```java
String catalogObjectId = "catalog_object_id6";

inventoryApi.retrieveInventoryChangesAsync(catalogObjectId, null, null).thenAccept(result -> {
    // TODO success callback handler
    System.out.println(result);
}).exceptionally(exception -> {
    // TODO failure callback handler
    exception.printStackTrace();
    return null;
});
```


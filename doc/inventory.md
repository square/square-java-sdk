# Inventory

```java
InventoryApi inventoryApi = client.getInventoryApi();
```

## Class Name

`InventoryApi`

## Methods

* [Retrieve Inventory Adjustment](/doc/inventory.md#retrieve-inventory-adjustment)
* [Batch Change Inventory](/doc/inventory.md#batch-change-inventory)
* [Batch Retrieve Inventory Changes](/doc/inventory.md#batch-retrieve-inventory-changes)
* [Batch Retrieve Inventory Counts](/doc/inventory.md#batch-retrieve-inventory-counts)
* [Retrieve Inventory Physical Count](/doc/inventory.md#retrieve-inventory-physical-count)
* [Retrieve Inventory Count](/doc/inventory.md#retrieve-inventory-count)
* [Retrieve Inventory Changes](/doc/inventory.md#retrieve-inventory-changes)

## Retrieve Inventory Adjustment

Returns the [InventoryAdjustment](#type-inventoryadjustment) object
with the provided `adjustment_id`.

```java
CompletableFuture<RetrieveInventoryAdjustmentResponse> retrieveInventoryAdjustmentAsync(
    final String adjustmentId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `adjustmentId` | `String` | Template, Required | ID of the [InventoryAdjustment](#type-inventoryadjustment) to retrieve. |

### Response Type

[`RetrieveInventoryAdjustmentResponse`](/doc/models/retrieve-inventory-adjustment-response.md)

### Example Usage

```java
String adjustmentId = "adjustment_id0";

inventoryApi.retrieveInventoryAdjustmentAsync(adjustmentId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Batch Change Inventory

Applies adjustments and counts to the provided item quantities.

On success: returns the current calculated counts for all objects
referenced in the request.
On failure: returns a list of related errors.

```java
CompletableFuture<BatchChangeInventoryResponse> batchChangeInventoryAsync(
    final BatchChangeInventoryRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchChangeInventoryRequest`](/doc/models/batch-change-inventory-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`BatchChangeInventoryResponse`](/doc/models/batch-change-inventory-response.md)

### Example Usage

```java
List<InventoryChange> bodyChanges = new LinkedList<>();

InventoryPhysicalCount bodyChanges0PhysicalCount = new InventoryPhysicalCount.Builder()
    .id("id0")
    .referenceId("1536bfbf-efed-48bf-b17d-a197141b2a92")
    .catalogObjectId("W62UWFY35CWMYGVWK6TWJDNI")
    .catalogObjectType("catalog_object_type4")
    .state("IN_STOCK")
    .locationId("C6W5YS5QM06F5")
    .quantity("53")
    .employeeId("LRK57NSQ5X7PUD05")
    .occurredAt("2016-11-16T22:25:24.878Z")
    .build();
InventoryAdjustment bodyChanges0Adjustment = new InventoryAdjustment.Builder()
    .id("id6")
    .referenceId("reference_id4")
    .fromState("SOLD")
    .toState("IN_TRANSIT_TO")
    .locationId("location_id0")
    .build();
InventoryTransfer bodyChanges0Transfer = new InventoryTransfer.Builder()
    .id("id0")
    .referenceId("reference_id8")
    .state("SOLD")
    .fromLocationId("from_location_id2")
    .toLocationId("to_location_id2")
    .build();
InventoryChange bodyChanges0 = new InventoryChange.Builder()
    .type("PHYSICAL_COUNT")
    .physicalCount(bodyChanges0PhysicalCount)
    .adjustment(bodyChanges0Adjustment)
    .transfer(bodyChanges0Transfer)
    .build();
bodyChanges.add(bodyChanges0);

BatchChangeInventoryRequest body = new BatchChangeInventoryRequest.Builder()
    .idempotencyKey("8fc6a5b0-9fe8-4b46-b46b-2ef95793abbe")
    .changes(bodyChanges)
    .ignoreUnchangedCounts(true)
    .build();

inventoryApi.batchChangeInventoryAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Batch Retrieve Inventory Changes

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

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveInventoryChangesRequest`](/doc/models/batch-retrieve-inventory-changes-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`BatchRetrieveInventoryChangesResponse`](/doc/models/batch-retrieve-inventory-changes-response.md)

### Example Usage

```java
List<String> bodyCatalogObjectIds = new LinkedList<>();
bodyCatalogObjectIds.add("W62UWFY35CWMYGVWK6TWJDNI");
List<String> bodyLocationIds = new LinkedList<>();
bodyLocationIds.add("C6W5YS5QM06F5");
List<String> bodyTypes = new LinkedList<>();
bodyTypes.add("PHYSICAL_COUNT");
List<String> bodyStates = new LinkedList<>();
bodyStates.add("IN_STOCK");
BatchRetrieveInventoryChangesRequest body = new BatchRetrieveInventoryChangesRequest.Builder()
    .catalogObjectIds(bodyCatalogObjectIds)
    .locationIds(bodyLocationIds)
    .types(bodyTypes)
    .states(bodyStates)
    .updatedAfter("2016-11-01T00:00:00.000Z")
    .updatedBefore("2016-12-01T00:00:00.000Z")
    .build();

inventoryApi.batchRetrieveInventoryChangesAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Batch Retrieve Inventory Counts

Returns current counts for the provided
[CatalogObject](#type-catalogobject)s at the requested
[Location](#type-location)s.

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

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`BatchRetrieveInventoryCountsRequest`](/doc/models/batch-retrieve-inventory-counts-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`BatchRetrieveInventoryCountsResponse`](/doc/models/batch-retrieve-inventory-counts-response.md)

### Example Usage

```java
List<String> bodyCatalogObjectIds = new LinkedList<>();
bodyCatalogObjectIds.add("W62UWFY35CWMYGVWK6TWJDNI");
List<String> bodyLocationIds = new LinkedList<>();
bodyLocationIds.add("59TNP9SA8VGDA");
List<String> bodyStates = new LinkedList<>();
bodyStates.add("IN_TRANSIT_TO");
BatchRetrieveInventoryCountsRequest body = new BatchRetrieveInventoryCountsRequest.Builder()
    .catalogObjectIds(bodyCatalogObjectIds)
    .locationIds(bodyLocationIds)
    .updatedAfter("2016-11-16T00:00:00.000Z")
    .cursor("cursor0")
    .states(bodyStates)
    .build();

inventoryApi.batchRetrieveInventoryCountsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Inventory Physical Count

Returns the [InventoryPhysicalCount](#type-inventoryphysicalcount)
object with the provided `physical_count_id`.

```java
CompletableFuture<RetrieveInventoryPhysicalCountResponse> retrieveInventoryPhysicalCountAsync(
    final String physicalCountId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `physicalCountId` | `String` | Template, Required | ID of the<br>[InventoryPhysicalCount](#type-inventoryphysicalcount) to retrieve. |

### Response Type

[`RetrieveInventoryPhysicalCountResponse`](/doc/models/retrieve-inventory-physical-count-response.md)

### Example Usage

```java
String physicalCountId = "physical_count_id2";

inventoryApi.retrieveInventoryPhysicalCountAsync(physicalCountId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Inventory Count

Retrieves the current calculated stock count for a given
[CatalogObject](#type-catalogobject) at a given set of
[Location](#type-location)s. Responses are paginated and unsorted.
For more sophisticated queries, use a batch endpoint.

```java
CompletableFuture<RetrieveInventoryCountResponse> retrieveInventoryCountAsync(
    final String catalogObjectId,
    final String locationIds,
    final String cursor)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `catalogObjectId` | `String` | Template, Required | ID of the [CatalogObject](#type-catalogobject) to retrieve. |
| `locationIds` | `String` | Query, Optional | The [Location](#type-location) IDs to look up as a comma-separated<br>list. An empty list queries all locations. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for the original query.<br><br>See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information. |

### Response Type

[`RetrieveInventoryCountResponse`](/doc/models/retrieve-inventory-count-response.md)

### Example Usage

```java
String catalogObjectId = "catalog_object_id6";
String locationIds = "location_ids0";
String cursor = "cursor6";

inventoryApi.retrieveInventoryCountAsync(catalogObjectId, locationIds, cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Inventory Changes

Returns a set of physical counts and inventory adjustments for the
provided [CatalogObject](#type-catalogobject) at the requested
[Location](#type-location)s.

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

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `catalogObjectId` | `String` | Template, Required | ID of the [CatalogObject](#type-catalogobject) to retrieve. |
| `locationIds` | `String` | Query, Optional | The [Location](#type-location) IDs to look up as a comma-separated<br>list. An empty list queries all locations. |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for the original query.<br><br>See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information. |

### Response Type

[`RetrieveInventoryChangesResponse`](/doc/models/retrieve-inventory-changes-response.md)

### Example Usage

```java
String catalogObjectId = "catalog_object_id6";
String locationIds = "location_ids0";
String cursor = "cursor6";

inventoryApi.retrieveInventoryChangesAsync(catalogObjectId, locationIds, cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```


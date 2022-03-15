
# Batch Retrieve Inventory Changes Request

## Structure

`BatchRetrieveInventoryChangesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CatalogObjectIds` | `List<String>` | Optional | The filter to return results by `CatalogObject` ID.<br>The filter is only applicable when set. The default value is null. | List<String> getCatalogObjectIds() |
| `LocationIds` | `List<String>` | Optional | The filter to return results by `Location` ID.<br>The filter is only applicable when set. The default value is null. | List<String> getLocationIds() |
| `Types` | [`List<String>`](../../doc/models/inventory-change-type.md) | Optional | The filter to return results by `InventoryChangeType` values other than `TRANSFER`.<br>The default value is `[PHYSICAL_COUNT, ADJUSTMENT]`. | List<String> getTypes() |
| `States` | [`List<String>`](../../doc/models/inventory-state.md) | Optional | The filter to return `ADJUSTMENT` query results by<br>`InventoryState`. This filter is only applied when set.<br>The default value is null. | List<String> getStates() |
| `UpdatedAfter` | `String` | Optional | The filter to return results with their `calculated_at` value  <br>after the given time as specified in an RFC 3339 timestamp.<br>The default value is the UNIX epoch of (`1970-01-01T00:00:00Z`). | String getUpdatedAfter() |
| `UpdatedBefore` | `String` | Optional | The filter to return results with their `created_at` or `calculated_at` value  <br>strictly before the given time as specified in an RFC 3339 timestamp.<br>The default value is the UNIX epoch of (`1970-01-01T00:00:00Z`). | String getUpdatedBefore() |
| `Cursor` | `String` | Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for the original query.<br><br>See the [Pagination](../../https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information. | String getCursor() |

## Example (as JSON)

```json
{
  "catalog_object_ids": [
    "W62UWFY35CWMYGVWK6TWJDNI"
  ],
  "location_ids": [
    "C6W5YS5QM06F5"
  ],
  "states": [
    "IN_STOCK"
  ],
  "types": [
    "PHYSICAL_COUNT"
  ],
  "updated_after": "2016-11-01T00:00:00.000Z",
  "updated_before": "2016-12-01T00:00:00.000Z"
}
```


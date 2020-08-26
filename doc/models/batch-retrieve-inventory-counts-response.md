## Batch Retrieve Inventory Counts Response

### Structure

`BatchRetrieveInventoryCountsResponse`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Counts` | [`List<InventoryCount>`](/doc/models/inventory-count.md) | Optional | The current calculated inventory counts for the requested objects<br>and locations. | List<InventoryCount> getCounts() |
| `Cursor` | `String` | Optional | The pagination cursor to be used in a subsequent request. If unset,<br>this is the final response.<br><br>See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information. | String getCursor() |

### Example (as JSON)

```json
{
  "errors": [],
  "counts": [
    {
      "catalog_object_id": "W62UWFY35CWMYGVWK6TWJDNI",
      "catalog_object_type": "ITEM_VARIATION",
      "state": "IN_STOCK",
      "location_id": "59TNP9SA8VGDA",
      "quantity": "79",
      "calculated_at": "2016-11-16T22:28:01.223Z"
    }
  ]
}
```


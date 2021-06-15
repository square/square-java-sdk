
# Batch Change Inventory Response

## Structure

`BatchChangeInventoryResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Counts` | [`List<InventoryCount>`](/doc/models/inventory-count.md) | Optional | The current counts for all objects referenced in the request. | List<InventoryCount> getCounts() |
| `Changes` | [`List<InventoryChange>`](/doc/models/inventory-change.md) | Optional | Changes created for the request. | List<InventoryChange> getChanges() |

## Example (as JSON)

```json
{
  "counts": [
    {
      "calculated_at": "2016-11-16T22:28:01.223Z",
      "catalog_object_id": "W62UWFY35CWMYGVWK6TWJDNI",
      "catalog_object_type": "ITEM_VARIATION",
      "location_id": "C6W5YS5QM06F5",
      "quantity": "53",
      "state": "IN_STOCK"
    }
  ],
  "errors": []
}
```


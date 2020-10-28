
# V1 List Inventory Response

## Structure

`V1ListInventoryResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Items` | [`List<V1InventoryEntry>`](/doc/models/v1-inventory-entry.md) | Optional | - | List<V1InventoryEntry> getItems() |

## Example (as JSON)

```json
{
  "items": [
    {
      "variation_id": "variation_id5",
      "quantity_on_hand": 93.37
    },
    {
      "variation_id": "variation_id4",
      "quantity_on_hand": 93.38
    }
  ]
}
```


## V1 Inventory Entry

V1InventoryEntry

### Structure

`V1InventoryEntry`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `VariationId` | `String` | Optional | The variation that the entry corresponds to. | String getVariationId() |
| `QuantityOnHand` | `Double` | Optional | The current available quantity of the item variation. | Double getQuantityOnHand() |

### Example (as JSON)

```json
{
  "variation_id": "variation_id2",
  "quantity_on_hand": 123.5
}
```


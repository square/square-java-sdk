## V1 Payment Item Detail

V1PaymentItemDetail

### Structure

`V1PaymentItemDetail`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CategoryName` | `String` | Optional | The name of the item's merchant-defined category, if any. | String getCategoryName() |
| `Sku` | `String` | Optional | The item's merchant-defined SKU, if any. | String getSku() |
| `ItemId` | `String` | Optional | The unique ID of the item purchased, if any. | String getItemId() |
| `ItemVariationId` | `String` | Optional | The unique ID of the item variation purchased, if any. | String getItemVariationId() |

### Example (as JSON)

```json
{
  "category_name": "category_name8",
  "sku": "sku4",
  "item_id": "item_id0",
  "item_variation_id": "item_variation_id4"
}
```


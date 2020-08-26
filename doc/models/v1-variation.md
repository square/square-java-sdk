## V1 Variation

V1Variation

### Structure

`V1Variation`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The item variation's unique ID. | String getId() |
| `Name` | `String` | Optional | The item variation's name. | String getName() |
| `ItemId` | `String` | Optional | The ID of the variation's associated item. | String getItemId() |
| `Ordinal` | `Integer` | Optional | Indicates the variation's list position when displayed in Square Point of Sale and the merchant dashboard. If more than one variation for the same item has the same ordinal value, those variations are displayed in alphabetical order | Integer getOrdinal() |
| `PricingType` | [`String`](/doc/models/v1-variation-pricing-type.md) | Optional | - | String getPricingType() |
| `PriceMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getPriceMoney() |
| `Sku` | `String` | Optional | The item variation's SKU, if any. | String getSku() |
| `TrackInventory` | `Boolean` | Optional | If true, inventory tracking is active for the variation. | Boolean getTrackInventory() |
| `InventoryAlertType` | [`String`](/doc/models/v1-variation-inventory-alert-type.md) | Optional | - | String getInventoryAlertType() |
| `InventoryAlertThreshold` | `Integer` | Optional | If the inventory quantity for the variation is less than or equal to this value and inventory_alert_type is LOW_QUANTITY, the variation displays an alert in the merchant dashboard. | Integer getInventoryAlertThreshold() |
| `UserData` | `String` | Optional | Arbitrary metadata associated with the variation. Cannot exceed 255 characters. | String getUserData() |
| `V2Id` | `String` | Optional | The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID. | String getV2Id() |

### Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "item_id": "item_id0",
  "ordinal": 80,
  "pricing_type": "FIXED_PRICING"
}
```


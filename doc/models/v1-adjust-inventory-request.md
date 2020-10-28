
# V1 Adjust Inventory Request

V1AdjustInventoryRequest

## Structure

`V1AdjustInventoryRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `QuantityDelta` | `Double` | Optional | The number to adjust the variation's quantity by. | Double getQuantityDelta() |
| `AdjustmentType` | [`String`](/doc/models/v1-adjust-inventory-request-adjustment-type.md) | Optional | - | String getAdjustmentType() |
| `Memo` | `String` | Optional | A note about the inventory adjustment. | String getMemo() |

## Example (as JSON)

```json
{
  "quantity_delta": 223.58,
  "adjustment_type": "MANUAL_ADJUST",
  "memo": "memo4"
}
```


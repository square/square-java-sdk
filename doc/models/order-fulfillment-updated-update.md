
# Order Fulfillment Updated Update

Information about fulfillment updates.

## Structure

`OrderFulfillmentUpdatedUpdate`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `FulfillmentUid` | `String` | Optional | A unique ID that identifies the fulfillment only within this order. | String getFulfillmentUid() |
| `OldState` | [`String`](../../doc/models/order-fulfillment-state.md) | Optional | The current state of this fulfillment. | String getOldState() |
| `NewState` | [`String`](../../doc/models/order-fulfillment-state.md) | Optional | The current state of this fulfillment. | String getNewState() |

## Example (as JSON)

```json
{
  "fulfillment_uid": "fulfillment_uid4",
  "old_state": "PREPARED",
  "new_state": "PREPARED"
}
```


## Order Fulfillment Updated Update

Information about fulfillment updates.

### Structure

`OrderFulfillmentUpdatedUpdate`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `FulfillmentUid` | `String` | Optional | Unique ID that identifies the fulfillment only within this order. |
| `OldState` | [`String`](/doc/models/order-fulfillment-state.md) | Optional | The current state of this fulfillment. |
| `NewState` | [`String`](/doc/models/order-fulfillment-state.md) | Optional | The current state of this fulfillment. |

### Example (as JSON)

```json
{
  "fulfillment_uid": null,
  "old_state": null,
  "new_state": null
}
```


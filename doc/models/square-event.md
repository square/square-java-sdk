
# Square Event

## Structure

`SquareEvent`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `MerchantId` | `String` | Optional | The ID of the target merchant associated with the event. | String getMerchantId() |
| `LocationId` | `String` | Optional | The ID of the location associated with the event. | String getLocationId() |
| `Type` | `String` | Optional | The type of event this represents. | String getType() |
| `EventId` | `String` | Optional | A unique ID for the event. | String getEventId() |
| `CreatedAt` | `String` | Optional | Timestamp of when the event was created, in RFC 3339 format. | String getCreatedAt() |
| `Data` | [`SquareEventData`](../../doc/models/square-event-data.md) | Optional | - | SquareEventData getData() |

## Example (as JSON)

```json
{
  "merchant_id": "merchant_id0",
  "location_id": "location_id4",
  "type": "type0",
  "event_id": "event_id6",
  "created_at": "created_at2",
  "data": {
    "type": "type0",
    "id": "id0",
    "deleted": false,
    "object": {
      "key1": "val1",
      "key2": "val2"
    }
  }
}
```


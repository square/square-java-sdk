
# Event

## Structure

`Event`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `MerchantId` | `String` | Optional | The ID of the target merchant associated with the event. | String getMerchantId() |
| `LocationId` | `String` | Optional | The ID of the location associated with the event. | String getLocationId() |
| `Type` | `String` | Optional | The type of event this represents. | String getType() |
| `EventId` | `String` | Optional | A unique ID for the event. | String getEventId() |
| `CreatedAt` | `String` | Optional | Timestamp of when the event was created, in RFC 3339 format. | String getCreatedAt() |
| `Data` | [`EventData`](../../doc/models/event-data.md) | Optional | - | EventData getData() |

## Example (as JSON)

```json
{
  "merchant_id": "merchant_id2",
  "location_id": "location_id6",
  "type": "type8",
  "event_id": "event_id8",
  "created_at": "created_at0"
}
```


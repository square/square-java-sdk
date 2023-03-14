
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
  "merchant_id": null,
  "location_id": null,
  "type": null,
  "event_id": null,
  "created_at": null,
  "data": null
}
```


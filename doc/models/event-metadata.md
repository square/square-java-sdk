
# Event Metadata

Contains metadata about a particular [Event](../../doc/models/event.md).

## Structure

`EventMetadata`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `EventId` | `String` | Optional | A unique ID for the event. | String getEventId() |
| `ApiVersion` | `String` | Optional | The API version of the event. This corresponds to the default API version of the developer application at the time when the event was created. | String getApiVersion() |

## Example (as JSON)

```json
{
  "event_id": "event_id0",
  "api_version": "api_version6"
}
```


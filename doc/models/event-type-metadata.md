
# Event Type Metadata

Contains the metadata of a webhook event type.

## Structure

`EventTypeMetadata`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `EventType` | `String` | Optional | The event type. | String getEventType() |
| `ApiVersionIntroduced` | `String` | Optional | The API version at which the event type was introduced. | String getApiVersionIntroduced() |
| `ReleaseStatus` | `String` | Optional | The release status of the event type. | String getReleaseStatus() |

## Example (as JSON)

```json
{
  "event_type": "event_type0",
  "api_version_introduced": "api_version_introduced0",
  "release_status": "release_status4"
}
```


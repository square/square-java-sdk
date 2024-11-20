
# List Event Types Response

Defines the fields that are included in the response body of
a request to the [ListEventTypes](../../doc/api/events.md#list-event-types) endpoint.

Note: if there are errors processing the request, the event types field will not be
present.

## Structure

`ListEventTypesResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Information on errors encountered during the request. | List<Error> getErrors() |
| `EventTypes` | `List<String>` | Optional | The list of event types. | List<String> getEventTypes() |
| `Metadata` | [`List<EventTypeMetadata>`](../../doc/models/event-type-metadata.md) | Optional | Contains the metadata of an event type. For more information, see [EventTypeMetadata](entity:EventTypeMetadata). | List<EventTypeMetadata> getMetadata() |

## Example (as JSON)

```json
{
  "event_types": [
    "inventory.count.updated"
  ],
  "metadata": [
    {
      "api_version_introduced": "2018-07-12",
      "event_type": "inventory.count.updated",
      "release_status": "PUBLIC"
    }
  ],
  "errors": [
    {
      "category": "MERCHANT_SUBSCRIPTION_ERROR",
      "code": "INVALID_EXPIRATION",
      "detail": "detail6",
      "field": "field4"
    },
    {
      "category": "MERCHANT_SUBSCRIPTION_ERROR",
      "code": "INVALID_EXPIRATION",
      "detail": "detail6",
      "field": "field4"
    }
  ]
}
```



# Event Data

## Structure

`EventData`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Type` | `String` | Optional | Name of the affected object’s type. | String getType() |
| `Id` | `String` | Optional | ID of the affected object. | String getId() |
| `Deleted` | `Boolean` | Optional | Is true if the affected object was deleted. Otherwise absent. | Boolean getDeleted() |
| `Object` | `JsonObject` | Optional | An object containing fields and values relevant to the event. Is absent if affected object was deleted. | JsonObject getObject() |

## Example (as JSON)

```json
{
  "type": "type0",
  "id": "id0",
  "deleted": false,
  "object": {
    "key1": "val1",
    "key2": "val2"
  }
}
```


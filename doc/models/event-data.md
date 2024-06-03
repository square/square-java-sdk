
# Event Data

## Structure

`EventData`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Type` | `String` | Optional | The name of the affected object’s type. | String getType() |
| `Id` | `String` | Optional | The ID of the affected object. | String getId() |
| `Deleted` | `Boolean` | Optional | This is true if the affected object has been deleted; otherwise, it's absent. | Boolean getDeleted() |
| `Object` | `JsonObject` | Optional | An object containing fields and values relevant to the event. It is absent if the affected object has been deleted. | JsonObject getObject() |

## Example (as JSON)

```json
{
  "type": "type2",
  "id": "id8",
  "deleted": false,
  "object": {
    "key1": "val1",
    "key2": "val2"
  }
}
```


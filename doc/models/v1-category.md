## V1 Category

V1Category

### Structure

`V1Category`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The category's unique ID. | String getId() |
| `Name` | `String` | Optional | The category's name. | String getName() |
| `V2Id` | `String` | Optional | The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID. | String getV2Id() |

### Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "v2_id": "v2_id2"
}
```


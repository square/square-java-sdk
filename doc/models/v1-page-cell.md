## V1 Page Cell

V1PageCell

### Structure

`V1PageCell`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `PageId` | `String` | Optional | The unique identifier of the page the cell is included on. |
| `Row` | `Integer` | Optional | The row of the cell. Always an integer between 0 and 4, inclusive. |
| `Column` | `Integer` | Optional | The column of the cell. Always an integer between 0 and 4, inclusive. |
| `ObjectType` | [`String`](/doc/models/v1-page-cell-object-type.md) | Optional | - |
| `ObjectId` | `String` | Optional | The unique identifier of the entity represented in the cell. Not present for cells with an object_type of PLACEHOLDER. |
| `PlaceholderType` | [`String`](/doc/models/v1-page-cell-placeholder-type.md) | Optional | - |

### Example (as JSON)

```json
{
  "page_id": null,
  "row": null,
  "column": null,
  "object_type": null,
  "object_id": null,
  "placeholder_type": null
}
```


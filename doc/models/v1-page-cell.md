
# V1 Page Cell

V1PageCell

## Structure

`V1PageCell`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `PageId` | `String` | Optional | The unique identifier of the page the cell is included on. | String getPageId() |
| `Row` | `Integer` | Optional | The row of the cell. Always an integer between 0 and 4, inclusive. | Integer getRow() |
| `Column` | `Integer` | Optional | The column of the cell. Always an integer between 0 and 4, inclusive. | Integer getColumn() |
| `ObjectType` | [`String`](/doc/models/v1-page-cell-object-type.md) | Optional | - | String getObjectType() |
| `ObjectId` | `String` | Optional | The unique identifier of the entity represented in the cell. Not present for cells with an object_type of PLACEHOLDER. | String getObjectId() |
| `PlaceholderType` | [`String`](/doc/models/v1-page-cell-placeholder-type.md) | Optional | - | String getPlaceholderType() |

## Example (as JSON)

```json
{
  "page_id": "page_id0",
  "row": 30,
  "column": 204,
  "object_type": "ITEM",
  "object_id": "object_id8"
}
```


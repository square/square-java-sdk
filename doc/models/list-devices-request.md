
# List Devices Request

## Structure

`ListDevicesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Cursor` | `String` | Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query.<br>See [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination) for more information. | String getCursor() |
| `SortOrder` | [`String`](../../doc/models/sort-order.md) | Optional | The order (e.g., chronological or alphabetical) in which results from a request are returned. | String getSortOrder() |
| `Limit` | `Integer` | Optional | The number of results to return in a single page.<br>**Constraints**: `>= 1`, `<= 100` | Integer getLimit() |
| `LocationId` | `String` | Optional | If present, only returns devices at the target location. | String getLocationId() |

## Example (as JSON)

```json
{
  "cursor": "cursor0",
  "sort_order": "DESC",
  "limit": 164,
  "location_id": "location_id0"
}
```


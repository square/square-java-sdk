
# Search Shifts Request

A request for a filtered and sorted set of `Shift` objects.

## Structure

`SearchShiftsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Query` | [`ShiftQuery`](../../doc/models/shift-query.md) | Optional | The parameters of a `Shift` search query, which includes filter and sort options. | ShiftQuery getQuery() |
| `Limit` | `Integer` | Optional | The number of resources in a page (200 by default).<br>**Constraints**: `>= 1`, `<= 200` | Integer getLimit() |
| `Cursor` | `String` | Optional | An opaque cursor for fetching the next page. | String getCursor() |

## Example (as JSON)

```json
{
  "query": null,
  "limit": null,
  "cursor": null
}
```


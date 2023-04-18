
# List Workweek Configs Request

A request for a set of `WorkweekConfig` objects.

## Structure

`ListWorkweekConfigsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Limit` | `Integer` | Optional | The maximum number of `WorkweekConfigs` results to return per page. | Integer getLimit() |
| `Cursor` | `String` | Optional | A pointer to the next page of `WorkweekConfig` results to fetch. | String getCursor() |

## Example (as JSON)

```json
{
  "limit": 172,
  "cursor": "cursor6"
}
```


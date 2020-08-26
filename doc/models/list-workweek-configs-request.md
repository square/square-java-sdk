## List Workweek Configs Request

A request for a set of `WorkweekConfig` objects

### Structure

`ListWorkweekConfigsRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Limit` | `Integer` | Optional | Maximum number of Workweek Configs to return per page. | Integer getLimit() |
| `Cursor` | `String` | Optional | Pointer to the next page of Workweek Config results to fetch. | String getCursor() |

### Example (as JSON)

```json
{
  "limit": 172,
  "cursor": "cursor6"
}
```


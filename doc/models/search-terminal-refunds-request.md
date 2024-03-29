
# Search Terminal Refunds Request

## Structure

`SearchTerminalRefundsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Query` | [`TerminalRefundQuery`](../../doc/models/terminal-refund-query.md) | Optional | - | TerminalRefundQuery getQuery() |
| `Cursor` | `String` | Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this cursor to retrieve the next set of results for the original query. | String getCursor() |
| `Limit` | `Integer` | Optional | Limits the number of results returned for a single request.<br>**Constraints**: `>= 1`, `<= 100` | Integer getLimit() |

## Example (as JSON)

```json
{
  "limit": 1,
  "query": {
    "filter": {
      "status": "COMPLETED",
      "device_id": "device_id0",
      "created_at": {
        "start_at": "start_at4",
        "end_at": "end_at8"
      }
    },
    "sort": {
      "sort_order": "sort_order8"
    }
  },
  "cursor": "cursor4"
}
```


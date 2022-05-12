
# Terminal Action Query

## Structure

`TerminalActionQuery`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Filter` | [`TerminalActionQueryFilter`](../../doc/models/terminal-action-query-filter.md) | Optional | - | TerminalActionQueryFilter getFilter() |
| `Sort` | [`TerminalActionQuerySort`](../../doc/models/terminal-action-query-sort.md) | Optional | - | TerminalActionQuerySort getSort() |

## Example (as JSON)

```json
{
  "include": [
    "CUSTOMER"
  ],
  "limit": 2,
  "query": {
    "filter": {
      "status": "COMPLETED"
    }
  }
}
```


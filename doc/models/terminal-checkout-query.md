
# Terminal Checkout Query

## Structure

`TerminalCheckoutQuery`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Filter` | [`TerminalCheckoutQueryFilter`](/doc/models/terminal-checkout-query-filter.md) | Optional | - | TerminalCheckoutQueryFilter getFilter() |
| `Sort` | [`TerminalCheckoutQuerySort`](/doc/models/terminal-checkout-query-sort.md) | Optional | - | TerminalCheckoutQuerySort getSort() |

## Example (as JSON)

```json
{
  "filter": {
    "device_id": "device_id0",
    "created_at": {
      "start_at": "start_at4",
      "end_at": "end_at8"
    },
    "status": "status6"
  },
  "sort": {
    "sort_order": "sort_order8"
  }
}
```


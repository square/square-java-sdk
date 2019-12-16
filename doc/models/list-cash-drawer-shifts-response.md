## List Cash Drawer Shifts Response

### Structure

`ListCashDrawerShiftsResponse`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Items` | [`List<CashDrawerShiftSummary>`](/doc/models/cash-drawer-shift-summary.md) | Optional | A collection of CashDrawerShiftSummary objects for shifts that match<br>the query. |
| `Cursor` | `String` | Optional | Opaque cursor for fetching the next page of results. Cursor is not<br>present in the last page of results. |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. |

### Example (as JSON)

```json
{
  "items": null,
  "cursor": null,
  "errors": null
}
```


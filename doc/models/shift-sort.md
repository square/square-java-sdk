## Shift Sort

Sets the sort order of search results.

### Structure

`ShiftSort`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Field` | [`String`](/doc/models/shift-sort-field.md) | Optional | Enumerates the `Shift` fields to sort on. | String getField() |
| `Order` | [`String`](/doc/models/sort-order.md) | Optional | The order (e.g., chronological or alphabetical) in which results from a request are returned. | String getOrder() |

### Example (as JSON)

```json
{
  "field": "START_AT",
  "order": "DESC"
}
```


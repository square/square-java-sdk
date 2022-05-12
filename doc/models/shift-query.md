
# Shift Query

The parameters of a `Shift` search query, which includes filter and sort options.

## Structure

`ShiftQuery`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Filter` | [`ShiftFilter`](../../doc/models/shift-filter.md) | Optional | Defines a filter used in a search for `Shift` records. `AND` logic is<br>used by Square's servers to apply each filter property specified. | ShiftFilter getFilter() |
| `Sort` | [`ShiftSort`](../../doc/models/shift-sort.md) | Optional | Sets the sort order of search results. | ShiftSort getSort() |

## Example (as JSON)

```json
{
  "filter": null,
  "sort": null
}
```


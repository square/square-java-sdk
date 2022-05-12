
# Customer Query

Represents a query (including filtering criteria, sorting criteria, or both) used to search
for customer profiles.

## Structure

`CustomerQuery`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Filter` | [`CustomerFilter`](../../doc/models/customer-filter.md) | Optional | Represents a set of `CustomerQuery` filters used to limit the set of<br>customers returned by the [SearchCustomers](../../doc/api/customers.md#search-customers) endpoint. | CustomerFilter getFilter() |
| `Sort` | [`CustomerSort`](../../doc/models/customer-sort.md) | Optional | Specifies how searched customers profiles are sorted, including the sort key and sort order. | CustomerSort getSort() |

## Example (as JSON)

```json
{
  "filter": null,
  "sort": null
}
```


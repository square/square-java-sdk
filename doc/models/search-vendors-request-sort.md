
# Search Vendors Request Sort

Defines a sorter used to sort results from [SearchVendors](../../doc/api/vendors.md#search-vendors).

## Structure

`SearchVendorsRequestSort`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Field` | [`String`](../../doc/models/search-vendors-request-sort-field.md) | Optional | The field to sort the returned [Vendor](../../doc/models/vendor.md) objects by. | String getField() |
| `Order` | [`String`](../../doc/models/sort-order.md) | Optional | The order (e.g., chronological or alphabetical) in which results from a request are returned. | String getOrder() |

## Example (as JSON)

```json
{
  "field": "NAME",
  "order": "DESC"
}
```


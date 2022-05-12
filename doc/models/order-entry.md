
# Order Entry

A lightweight description of an [order](../../doc/models/order.md) that is returned when
`returned_entries` is `true` on a [SearchOrdersRequest](../../doc/api/orders.md#search-orders).

## Structure

`OrderEntry`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `OrderId` | `String` | Optional | The ID of the order. | String getOrderId() |
| `Version` | `Integer` | Optional | The version number, which is incremented each time an update is committed to the order.<br>Orders that were not created through the API do not include a version number and<br>therefore cannot be updated.<br><br>[Read more about working with versions.](https://developer.squareup.com/docs/orders-api/manage-orders#update-orders) | Integer getVersion() |
| `LocationId` | `String` | Optional | The location ID the order belongs to. | String getLocationId() |

## Example (as JSON)

```json
{
  "order_id": null,
  "version": null,
  "location_id": null
}
```



# Payment Link Related Resources

## Structure

`PaymentLinkRelatedResources`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Orders` | [`List<Order>`](../../doc/models/order.md) | Optional | The order associated with the payment link. | List<Order> getOrders() |
| `SubscriptionPlans` | [`List<CatalogObject>`](../../doc/models/catalog-object.md) | Optional | The subscription plan associated with the payment link. | List<CatalogObject> getSubscriptionPlans() |

## Example (as JSON)

```json
{
  "orders": null,
  "subscription_plans": null
}
```


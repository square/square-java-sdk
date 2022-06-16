
# Catalog Subscription Plan

Describes a subscription plan. For more information, see
[Set Up and Manage a Subscription Plan](https://developer.squareup.com/docs/subscriptions-api/setup-plan).

## Structure

`CatalogSubscriptionPlan`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Name` | `String` | Required | The name of the plan. | String getName() |
| `Phases` | [`List<SubscriptionPhase>`](../../doc/models/subscription-phase.md) | Required | A list of SubscriptionPhase containing the [SubscriptionPhase](../../doc/models/subscription-phase.md) for this plan. | List<SubscriptionPhase> getPhases() |

## Example (as JSON)

```json
{
  "name": "name0",
  "phases": [
    {
      "uid": null,
      "cadence": "EVERY_FOUR_MONTHS",
      "periods": null,
      "recurring_price_money": null,
      "ordinal": null
    },
    {
      "uid": null,
      "cadence": "QUARTERLY",
      "periods": null,
      "recurring_price_money": null,
      "ordinal": null
    }
  ]
}
```


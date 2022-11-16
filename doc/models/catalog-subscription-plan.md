
# Catalog Subscription Plan

Describes a subscription plan. For more information, see
[Set Up and Manage a Subscription Plan](https://developer.squareup.com/docs/subscriptions-api/setup-plan).

## Structure

`CatalogSubscriptionPlan`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Name` | `String` | Required | The name of the plan. | String getName() |
| `Phases` | [`List<SubscriptionPhase>`](../../doc/models/subscription-phase.md) | Optional | A list of SubscriptionPhase containing the [SubscriptionPhase](../../doc/models/subscription-phase.md) for this plan.<br>This field it required. Not including this field will throw a REQUIRED_FIELD_MISSING error | List<SubscriptionPhase> getPhases() |

## Example (as JSON)

```json
{
  "name": "name0",
  "phases": null
}
```


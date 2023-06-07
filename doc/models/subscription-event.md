
# Subscription Event

Describes changes to a subscription and the subscription status.

## Structure

`SubscriptionEvent`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Required | The ID of the subscription event. | String getId() |
| `SubscriptionEventType` | [`String`](../../doc/models/subscription-event-subscription-event-type.md) | Required | Supported types of an event occurred to a subscription. | String getSubscriptionEventType() |
| `EffectiveDate` | `String` | Required | The `YYYY-MM-DD`-formatted date (for example, 2013-01-15) when the subscription event occurred. | String getEffectiveDate() |
| `Info` | [`SubscriptionEventInfo`](../../doc/models/subscription-event-info.md) | Optional | Provides information about the subscription event. | SubscriptionEventInfo getInfo() |
| `Phases` | [`List<Phase>`](../../doc/models/phase.md) | Optional | A list of Phases, to pass phase-specific information used in the swap. | List<Phase> getPhases() |
| `PlanVariationId` | `String` | Required | The ID of the subscription plan variation associated with the subscription. | String getPlanVariationId() |

## Example (as JSON)

```json
{
  "id": "id0",
  "subscription_event_type": "RESUME_SUBSCRIPTION",
  "effective_date": "effective_date0",
  "info": {
    "detail": "detail6",
    "code": "CUSTOMER_DELETED"
  },
  "phases": [
    {
      "uid": "uid5",
      "ordinal": 207,
      "order_template_id": "order_template_id7",
      "plan_phase_uid": "plan_phase_uid1"
    },
    {
      "uid": "uid6",
      "ordinal": 208,
      "order_template_id": "order_template_id8",
      "plan_phase_uid": "plan_phase_uid2"
    }
  ],
  "plan_variation_id": "plan_variation_id4"
}
```


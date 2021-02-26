
# Subscription Event

Describes changes to subscription and billing states.

## Structure

`SubscriptionEvent`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Required | The ID of the subscription event. | String getId() |
| `SubscriptionEventType` | [`String`](/doc/models/subscription-event-subscription-event-type.md) | Required | The possible subscription event types. | String getSubscriptionEventType() |
| `EffectiveDate` | `String` | Required | The date, in YYYY-MM-DD format (for<br>example, 2013-01-15), when the subscription event went into effect. | String getEffectiveDate() |
| `PlanId` | `String` | Required | The ID of the subscription plan associated with the subscription. | String getPlanId() |

## Example (as JSON)

```json
{
  "id": "id0",
  "subscription_event_type": "PLAN_CHANGE",
  "effective_date": "effective_date0",
  "plan_id": "plan_id8"
}
```


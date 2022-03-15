
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
| `PlanId` | `String` | Required | The ID of the subscription plan associated with the subscription. | String getPlanId() |
| `Info` | [`SubscriptionEventInfo`](../../doc/models/subscription-event-info.md) | Optional | Provides information about the subscription event. | SubscriptionEventInfo getInfo() |

## Example (as JSON)

```json
{
  "id": "id0",
  "subscription_event_type": "RESUME_SUBSCRIPTION",
  "effective_date": "effective_date0",
  "plan_id": "plan_id8",
  "info": {
    "detail": "detail6",
    "code": "CUSTOMER_DELETED"
  }
}
```


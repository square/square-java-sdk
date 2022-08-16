
# Test Webhook Subscription Request

Tests a [Subscription](../../doc/models/webhook-subscription.md) by sending a test event to its notification URL.

## Structure

`TestWebhookSubscriptionRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `EventType` | `String` | Optional | The event type that will be used to test the [Subscription](../../doc/models/webhook-subscription.md). The event type must be<br>contained in the list of event types in the [Subscription](../../doc/models/webhook-subscription.md). | String getEventType() |

## Example (as JSON)

```json
{
  "event_type": "payment.created"
}
```

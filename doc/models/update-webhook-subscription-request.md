
# Update Webhook Subscription Request

Updates a [Subscription](../../doc/models/webhook-subscription.md).

## Structure

`UpdateWebhookSubscriptionRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Subscription` | [`WebhookSubscription`](../../doc/models/webhook-subscription.md) | Optional | Represents the details of a webhook subscription, including notification URL,<br>event types, and signature key. | WebhookSubscription getSubscription() |

## Example (as JSON)

```json
{
  "subscription": {
    "enabled": false,
    "name": "Updated Example Webhook Subscription"
  }
}
```


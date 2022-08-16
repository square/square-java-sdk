
# Webhook Subscription

Represents the details of a webhook subscription, including notification URL,
event types, and signature key.

## Structure

`WebhookSubscription`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A Square-generated unique ID for the subscription.<br>**Constraints**: *Maximum Length*: `64` | String getId() |
| `Name` | `String` | Optional | The name of this subscription.<br>**Constraints**: *Maximum Length*: `64` | String getName() |
| `Enabled` | `Boolean` | Optional | Indicates whether the subscription is enabled (`true`) or not (`false`). | Boolean getEnabled() |
| `EventTypes` | `List<String>` | Optional | The event types associated with this subscription. | List<String> getEventTypes() |
| `NotificationUrl` | `String` | Optional | The URL to which webhooks are sent. | String getNotificationUrl() |
| `ApiVersion` | `String` | Optional | The API version of the subscription.<br>This field is optional for `CreateWebhookSubscription`.<br>The value defaults to the API version used by the application. | String getApiVersion() |
| `SignatureKey` | `String` | Optional | The Square-generated signature key used to validate the origin of the webhook event. | String getSignatureKey() |
| `CreatedAt` | `String` | Optional | The timestamp of when the subscription was created, in RFC 3339 format. For example, "2016-09-04T23:59:33.123Z". | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp of when the subscription was last updated, in RFC 3339 format.<br>For example, "2016-09-04T23:59:33.123Z". | String getUpdatedAt() |

## Example (as JSON)

```json
{
  "name": null,
  "enabled": null,
  "event_types": null,
  "notification_url": null,
  "api_version": null
}
```


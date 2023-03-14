
# Invoice Payment Reminder

Describes a payment request reminder (automatic notification) that Square sends
to the customer. You configure a reminder relative to the payment request
`due_date`.

## Structure

`InvoicePaymentReminder`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Uid` | `String` | Optional | A Square-assigned ID that uniquely identifies the reminder within the<br>`InvoicePaymentRequest`. | String getUid() |
| `RelativeScheduledDays` | `Integer` | Optional | The number of days before (a negative number) or after (a positive number)<br>the payment request `due_date` when the reminder is sent. For example, -3 indicates that<br>the reminder should be sent 3 days before the payment request `due_date`.<br>**Constraints**: `>= -32767`, `<= 32767` | Integer getRelativeScheduledDays() |
| `Message` | `String` | Optional | The reminder message.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `1000` | String getMessage() |
| `Status` | [`String`](../../doc/models/invoice-payment-reminder-status.md) | Optional | The status of a payment request reminder. | String getStatus() |
| `SentAt` | `String` | Optional | If sent, the timestamp when the reminder was sent, in RFC 3339 format. | String getSentAt() |

## Example (as JSON)

```json
{
  "uid": null,
  "relative_scheduled_days": null,
  "message": null,
  "status": null,
  "sent_at": null
}
```


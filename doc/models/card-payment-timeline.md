
# Card Payment Timeline

The timeline for card payments.

## Structure

`CardPaymentTimeline`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AuthorizedAt` | `String` | Optional | The timestamp when the payment was authorized, in RFC 3339 format. | String getAuthorizedAt() |
| `CapturedAt` | `String` | Optional | The timestamp when the payment was captured, in RFC 3339 format. | String getCapturedAt() |
| `VoidedAt` | `String` | Optional | The timestamp when the payment was voided, in RFC 3339 format. | String getVoidedAt() |

## Example (as JSON)

```json
{
  "authorized_at": null,
  "captured_at": null,
  "voided_at": null
}
```


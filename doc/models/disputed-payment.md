
# Disputed Payment

The payment the cardholder disputed.

## Structure

`DisputedPayment`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `PaymentId` | `String` | Optional | Square-generated unique ID of the payment being disputed.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `192` | String getPaymentId() |

## Example (as JSON)

```json
{
  "payment_id": "payment_id8"
}
```


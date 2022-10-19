
# Payment Balance Activity App Fee Refund Detail

## Structure

`PaymentBalanceActivityAppFeeRefundDetail`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `PaymentId` | `String` | Optional | The ID of the payment associated with this activity. | String getPaymentId() |
| `RefundId` | `String` | Optional | The ID of the refund associated with this activity. | String getRefundId() |
| `LocationId` | `String` | Optional | The ID of the location of the merchant associated with the payment refund activity | String getLocationId() |

## Example (as JSON)

```json
{
  "payment_id": null,
  "refund_id": null,
  "location_id": null
}
```


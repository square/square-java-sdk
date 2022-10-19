
# Payment Balance Activity Tax on Fee Detail

## Structure

`PaymentBalanceActivityTaxOnFeeDetail`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `PaymentId` | `String` | Optional | The ID of the payment associated with this activity. | String getPaymentId() |
| `TaxRateDescription` | `String` | Optional | The description of the tax rate being applied. For example: "GST", "HST". | String getTaxRateDescription() |

## Example (as JSON)

```json
{
  "payment_id": null,
  "tax_rate_description": null
}
```


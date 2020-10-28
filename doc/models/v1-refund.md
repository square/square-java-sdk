
# V1 Refund

V1Refund

## Structure

`V1Refund`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Type` | [`String`](/doc/models/v1-refund-type.md) | Optional | - | String getType() |
| `Reason` | `String` | Optional | The merchant-specified reason for the refund. | String getReason() |
| `RefundedMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getRefundedMoney() |
| `RefundedProcessingFeeMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getRefundedProcessingFeeMoney() |
| `RefundedTaxMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getRefundedTaxMoney() |
| `RefundedAdditiveTaxMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getRefundedAdditiveTaxMoney() |
| `RefundedAdditiveTax` | [`List<V1PaymentTax>`](/doc/models/v1-payment-tax.md) | Optional | All of the additive taxes associated with the refund. | List<V1PaymentTax> getRefundedAdditiveTax() |
| `RefundedInclusiveTaxMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getRefundedInclusiveTaxMoney() |
| `RefundedInclusiveTax` | [`List<V1PaymentTax>`](/doc/models/v1-payment-tax.md) | Optional | All of the inclusive taxes associated with the refund. | List<V1PaymentTax> getRefundedInclusiveTax() |
| `RefundedTipMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getRefundedTipMoney() |
| `RefundedDiscountMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getRefundedDiscountMoney() |
| `RefundedSurchargeMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getRefundedSurchargeMoney() |
| `RefundedSurcharges` | [`List<V1PaymentSurcharge>`](/doc/models/v1-payment-surcharge.md) | Optional | A list of all surcharges associated with the refund. | List<V1PaymentSurcharge> getRefundedSurcharges() |
| `CreatedAt` | `String` | Optional | The time when the merchant initiated the refund for Square to process, in ISO 8601 format. | String getCreatedAt() |
| `ProcessedAt` | `String` | Optional | The time when Square processed the refund on behalf of the merchant, in ISO 8601 format. | String getProcessedAt() |
| `PaymentId` | `String` | Optional | A Square-issued ID associated with the refund. For single-tender refunds, payment_id is the ID of the original payment ID. For split-tender refunds, payment_id is the ID of the original tender. For exchange-based refunds (is_exchange == true), payment_id is the ID of the original payment ID even if the payment includes other tenders. | String getPaymentId() |
| `MerchantId` | `String` | Optional | - | String getMerchantId() |
| `IsExchange` | `Boolean` | Optional | Indicates whether or not the refund is associated with an exchange. If is_exchange is true, the refund reflects the value of goods returned in the exchange not the total money refunded. | Boolean getIsExchange() |

## Example (as JSON)

```json
{
  "type": "FULL",
  "reason": "reason4",
  "refunded_money": {
    "amount": 214,
    "currency_code": "CHW"
  },
  "refunded_processing_fee_money": {
    "amount": 0,
    "currency_code": "LBP"
  },
  "refunded_tax_money": {
    "amount": 148,
    "currency_code": "BAM"
  }
}
```


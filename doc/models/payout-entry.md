
# Payout Entry

One or more PayoutEntries that make up a Payout. Each one has a date, amount, and type of activity.
The total amount of the payout will equal the sum of the payout entries for a batch payout

## Structure

`PayoutEntry`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Required | A unique ID for the payout entry.<br>**Constraints**: *Minimum Length*: `1` | String getId() |
| `PayoutId` | `String` | Required | The ID of the payout entries’ associated payout.<br>**Constraints**: *Minimum Length*: `1` | String getPayoutId() |
| `EffectiveAt` | `String` | Optional | The timestamp of when the payout entry affected the balance, in RFC 3339 format. | String getEffectiveAt() |
| `Type` | [`String`](../../doc/models/activity-type.md) | Optional | - | String getType() |
| `GrossAmountMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getGrossAmountMoney() |
| `FeeAmountMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getFeeAmountMoney() |
| `NetAmountMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getNetAmountMoney() |
| `TypeAutomaticSavingsDetails` | [`PaymentBalanceActivityAutomaticSavingsDetail`](../../doc/models/payment-balance-activity-automatic-savings-detail.md) | Optional | - | PaymentBalanceActivityAutomaticSavingsDetail getTypeAutomaticSavingsDetails() |
| `TypeAutomaticSavingsReversedDetails` | [`PaymentBalanceActivityAutomaticSavingsReversedDetail`](../../doc/models/payment-balance-activity-automatic-savings-reversed-detail.md) | Optional | - | PaymentBalanceActivityAutomaticSavingsReversedDetail getTypeAutomaticSavingsReversedDetails() |
| `TypeChargeDetails` | [`PaymentBalanceActivityChargeDetail`](../../doc/models/payment-balance-activity-charge-detail.md) | Optional | DESCRIPTION OF PaymentBalanceActivityChargeDetail | PaymentBalanceActivityChargeDetail getTypeChargeDetails() |
| `TypeDepositFeeDetails` | [`PaymentBalanceActivityDepositFeeDetail`](../../doc/models/payment-balance-activity-deposit-fee-detail.md) | Optional | - | PaymentBalanceActivityDepositFeeDetail getTypeDepositFeeDetails() |
| `TypeDisputeDetails` | [`PaymentBalanceActivityDisputeDetail`](../../doc/models/payment-balance-activity-dispute-detail.md) | Optional | - | PaymentBalanceActivityDisputeDetail getTypeDisputeDetails() |
| `TypeFeeDetails` | [`PaymentBalanceActivityFeeDetail`](../../doc/models/payment-balance-activity-fee-detail.md) | Optional | - | PaymentBalanceActivityFeeDetail getTypeFeeDetails() |
| `TypeFreeProcessingDetails` | [`PaymentBalanceActivityFreeProcessingDetail`](../../doc/models/payment-balance-activity-free-processing-detail.md) | Optional | - | PaymentBalanceActivityFreeProcessingDetail getTypeFreeProcessingDetails() |
| `TypeHoldAdjustmentDetails` | [`PaymentBalanceActivityHoldAdjustmentDetail`](../../doc/models/payment-balance-activity-hold-adjustment-detail.md) | Optional | - | PaymentBalanceActivityHoldAdjustmentDetail getTypeHoldAdjustmentDetails() |
| `TypeOpenDisputeDetails` | [`PaymentBalanceActivityOpenDisputeDetail`](../../doc/models/payment-balance-activity-open-dispute-detail.md) | Optional | - | PaymentBalanceActivityOpenDisputeDetail getTypeOpenDisputeDetails() |
| `TypeOtherDetails` | [`PaymentBalanceActivityOtherDetail`](../../doc/models/payment-balance-activity-other-detail.md) | Optional | - | PaymentBalanceActivityOtherDetail getTypeOtherDetails() |
| `TypeOtherAdjustmentDetails` | [`PaymentBalanceActivityOtherAdjustmentDetail`](../../doc/models/payment-balance-activity-other-adjustment-detail.md) | Optional | - | PaymentBalanceActivityOtherAdjustmentDetail getTypeOtherAdjustmentDetails() |
| `TypeRefundDetails` | [`PaymentBalanceActivityRefundDetail`](../../doc/models/payment-balance-activity-refund-detail.md) | Optional | - | PaymentBalanceActivityRefundDetail getTypeRefundDetails() |
| `TypeReleaseAdjustmentDetails` | [`PaymentBalanceActivityReleaseAdjustmentDetail`](../../doc/models/payment-balance-activity-release-adjustment-detail.md) | Optional | - | PaymentBalanceActivityReleaseAdjustmentDetail getTypeReleaseAdjustmentDetails() |
| `TypeReserveHoldDetails` | [`PaymentBalanceActivityReserveHoldDetail`](../../doc/models/payment-balance-activity-reserve-hold-detail.md) | Optional | - | PaymentBalanceActivityReserveHoldDetail getTypeReserveHoldDetails() |
| `TypeReserveReleaseDetails` | [`PaymentBalanceActivityReserveReleaseDetail`](../../doc/models/payment-balance-activity-reserve-release-detail.md) | Optional | - | PaymentBalanceActivityReserveReleaseDetail getTypeReserveReleaseDetails() |
| `TypeSquareCapitalPaymentDetails` | [`PaymentBalanceActivitySquareCapitalPaymentDetail`](../../doc/models/payment-balance-activity-square-capital-payment-detail.md) | Optional | - | PaymentBalanceActivitySquareCapitalPaymentDetail getTypeSquareCapitalPaymentDetails() |
| `TypeSquareCapitalReversedPaymentDetails` | [`PaymentBalanceActivitySquareCapitalReversedPaymentDetail`](../../doc/models/payment-balance-activity-square-capital-reversed-payment-detail.md) | Optional | - | PaymentBalanceActivitySquareCapitalReversedPaymentDetail getTypeSquareCapitalReversedPaymentDetails() |
| `TypeTaxOnFeeDetails` | [`PaymentBalanceActivityTaxOnFeeDetail`](../../doc/models/payment-balance-activity-tax-on-fee-detail.md) | Optional | - | PaymentBalanceActivityTaxOnFeeDetail getTypeTaxOnFeeDetails() |
| `TypeThirdPartyFeeDetails` | [`PaymentBalanceActivityThirdPartyFeeDetail`](../../doc/models/payment-balance-activity-third-party-fee-detail.md) | Optional | - | PaymentBalanceActivityThirdPartyFeeDetail getTypeThirdPartyFeeDetails() |
| `TypeThirdPartyFeeRefundDetails` | [`PaymentBalanceActivityThirdPartyFeeRefundDetail`](../../doc/models/payment-balance-activity-third-party-fee-refund-detail.md) | Optional | - | PaymentBalanceActivityThirdPartyFeeRefundDetail getTypeThirdPartyFeeRefundDetails() |

## Example (as JSON)

```json
{
  "id": "id0",
  "payout_id": "payout_id6",
  "effective_at": "effective_at6",
  "type": "REDEMPTION_CODE",
  "gross_amount_money": {
    "amount": 186,
    "currency": "SVC"
  },
  "fee_amount_money": {
    "amount": 126,
    "currency": "ANG"
  },
  "net_amount_money": {
    "amount": 6,
    "currency": "AOA"
  }
}
```


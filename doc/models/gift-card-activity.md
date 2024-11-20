
# Gift Card Activity

Represents an action performed on a [gift card](../../doc/models/gift-card.md) that affects its state or balance.
A gift card activity contains information about a specific activity type. For example, a `REDEEM` activity
includes a `redeem_activity_details` field that contains information about the redemption.

## Structure

`GiftCardActivity`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-assigned ID of the gift card activity. | String getId() |
| `Type` | [`String`](../../doc/models/gift-card-activity-type.md) | Required | Indicates the type of [gift card activity](../../doc/models/gift-card-activity.md). | String getType() |
| `LocationId` | `String` | Required | The ID of the [business location](entity:Location) where the activity occurred. | String getLocationId() |
| `CreatedAt` | `String` | Optional | The timestamp when the gift card activity was created, in RFC 3339 format. | String getCreatedAt() |
| `GiftCardId` | `String` | Optional | The gift card ID. When creating a gift card activity, `gift_card_id` is not required if<br>`gift_card_gan` is specified. | String getGiftCardId() |
| `GiftCardGan` | `String` | Optional | The gift card account number (GAN). When creating a gift card activity, `gift_card_gan`<br>is not required if `gift_card_id` is specified. | String getGiftCardGan() |
| `GiftCardBalanceMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getGiftCardBalanceMoney() |
| `LoadActivityDetails` | [`GiftCardActivityLoad`](../../doc/models/gift-card-activity-load.md) | Optional | Represents details about a `LOAD` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityLoad getLoadActivityDetails() |
| `ActivateActivityDetails` | [`GiftCardActivityActivate`](../../doc/models/gift-card-activity-activate.md) | Optional | Represents details about an `ACTIVATE` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityActivate getActivateActivityDetails() |
| `RedeemActivityDetails` | [`GiftCardActivityRedeem`](../../doc/models/gift-card-activity-redeem.md) | Optional | Represents details about a `REDEEM` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityRedeem getRedeemActivityDetails() |
| `ClearBalanceActivityDetails` | [`GiftCardActivityClearBalance`](../../doc/models/gift-card-activity-clear-balance.md) | Optional | Represents details about a `CLEAR_BALANCE` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityClearBalance getClearBalanceActivityDetails() |
| `DeactivateActivityDetails` | [`GiftCardActivityDeactivate`](../../doc/models/gift-card-activity-deactivate.md) | Optional | Represents details about a `DEACTIVATE` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityDeactivate getDeactivateActivityDetails() |
| `AdjustIncrementActivityDetails` | [`GiftCardActivityAdjustIncrement`](../../doc/models/gift-card-activity-adjust-increment.md) | Optional | Represents details about an `ADJUST_INCREMENT` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityAdjustIncrement getAdjustIncrementActivityDetails() |
| `AdjustDecrementActivityDetails` | [`GiftCardActivityAdjustDecrement`](../../doc/models/gift-card-activity-adjust-decrement.md) | Optional | Represents details about an `ADJUST_DECREMENT` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityAdjustDecrement getAdjustDecrementActivityDetails() |
| `RefundActivityDetails` | [`GiftCardActivityRefund`](../../doc/models/gift-card-activity-refund.md) | Optional | Represents details about a `REFUND` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityRefund getRefundActivityDetails() |
| `UnlinkedActivityRefundActivityDetails` | [`GiftCardActivityUnlinkedActivityRefund`](../../doc/models/gift-card-activity-unlinked-activity-refund.md) | Optional | Represents details about an `UNLINKED_ACTIVITY_REFUND` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityUnlinkedActivityRefund getUnlinkedActivityRefundActivityDetails() |
| `ImportActivityDetails` | [`GiftCardActivityImport`](../../doc/models/gift-card-activity-import.md) | Optional | Represents details about an `IMPORT` [gift card activity type](../../doc/models/gift-card-activity-type.md).<br>This activity type is used when Square imports a third-party gift card, in which case the<br>`gan_source` of the gift card is set to `OTHER`. | GiftCardActivityImport getImportActivityDetails() |
| `BlockActivityDetails` | [`GiftCardActivityBlock`](../../doc/models/gift-card-activity-block.md) | Optional | Represents details about a `BLOCK` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityBlock getBlockActivityDetails() |
| `UnblockActivityDetails` | [`GiftCardActivityUnblock`](../../doc/models/gift-card-activity-unblock.md) | Optional | Represents details about an `UNBLOCK` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityUnblock getUnblockActivityDetails() |
| `ImportReversalActivityDetails` | [`GiftCardActivityImportReversal`](../../doc/models/gift-card-activity-import-reversal.md) | Optional | Represents details about an `IMPORT_REVERSAL` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityImportReversal getImportReversalActivityDetails() |
| `TransferBalanceToActivityDetails` | [`GiftCardActivityTransferBalanceTo`](../../doc/models/gift-card-activity-transfer-balance-to.md) | Optional | Represents details about a `TRANSFER_BALANCE_TO` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityTransferBalanceTo getTransferBalanceToActivityDetails() |
| `TransferBalanceFromActivityDetails` | [`GiftCardActivityTransferBalanceFrom`](../../doc/models/gift-card-activity-transfer-balance-from.md) | Optional | Represents details about a `TRANSFER_BALANCE_FROM` [gift card activity type](../../doc/models/gift-card-activity-type.md). | GiftCardActivityTransferBalanceFrom getTransferBalanceFromActivityDetails() |

## Example (as JSON)

```json
{
  "id": "id8",
  "type": "REDEEM",
  "location_id": "location_id2",
  "created_at": "created_at6",
  "gift_card_id": "gift_card_id6",
  "gift_card_gan": "gift_card_gan4",
  "gift_card_balance_money": {
    "amount": 82,
    "currency": "IRR"
  }
}
```


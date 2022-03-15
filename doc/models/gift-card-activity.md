
# Gift Card Activity

Represents an action performed on a gift card that affects its state or balance.

## Structure

`GiftCardActivity`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The unique ID of the gift card activity. | String getId() |
| `Type` | [`String`](../../doc/models/gift-card-activity-type.md) | Required | Indicates the gift card activity type. | String getType() |
| `LocationId` | `String` | Required | The ID of the location at which the activity occurred. | String getLocationId() |
| `CreatedAt` | `String` | Optional | The timestamp when the gift card activity was created, in RFC 3339 format. | String getCreatedAt() |
| `GiftCardId` | `String` | Optional | The gift card ID. The ID is not required if a GAN is present. | String getGiftCardId() |
| `GiftCardGan` | `String` | Optional | The gift card GAN. The GAN is not required if `gift_card_id` is present. | String getGiftCardGan() |
| `GiftCardBalanceMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](../../https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getGiftCardBalanceMoney() |
| `LoadActivityDetails` | [`GiftCardActivityLoad`](../../doc/models/gift-card-activity-load.md) | Optional | Present only when `GiftCardActivityType` is LOAD. | GiftCardActivityLoad getLoadActivityDetails() |
| `ActivateActivityDetails` | [`GiftCardActivityActivate`](../../doc/models/gift-card-activity-activate.md) | Optional | Describes a gift card activity of the ACTIVATE type. | GiftCardActivityActivate getActivateActivityDetails() |
| `RedeemActivityDetails` | [`GiftCardActivityRedeem`](../../doc/models/gift-card-activity-redeem.md) | Optional | Present only when `GiftCardActivityType` is REDEEM. | GiftCardActivityRedeem getRedeemActivityDetails() |
| `ClearBalanceActivityDetails` | [`GiftCardActivityClearBalance`](../../doc/models/gift-card-activity-clear-balance.md) | Optional | Describes a gift card activity of the CLEAR_BALANCE type. | GiftCardActivityClearBalance getClearBalanceActivityDetails() |
| `DeactivateActivityDetails` | [`GiftCardActivityDeactivate`](../../doc/models/gift-card-activity-deactivate.md) | Optional | Describes a gift card activity of the DEACTIVATE type. | GiftCardActivityDeactivate getDeactivateActivityDetails() |
| `AdjustIncrementActivityDetails` | [`GiftCardActivityAdjustIncrement`](../../doc/models/gift-card-activity-adjust-increment.md) | Optional | Describes a gift card activity of the ADJUST_INCREMENT type. | GiftCardActivityAdjustIncrement getAdjustIncrementActivityDetails() |
| `AdjustDecrementActivityDetails` | [`GiftCardActivityAdjustDecrement`](../../doc/models/gift-card-activity-adjust-decrement.md) | Optional | Describes a gift card activity of the ADJUST_DECREMENT type. | GiftCardActivityAdjustDecrement getAdjustDecrementActivityDetails() |
| `RefundActivityDetails` | [`GiftCardActivityRefund`](../../doc/models/gift-card-activity-refund.md) | Optional | Present only when `GiftCardActivityType` is REFUND. | GiftCardActivityRefund getRefundActivityDetails() |
| `UnlinkedActivityRefundActivityDetails` | [`GiftCardActivityUnlinkedActivityRefund`](../../doc/models/gift-card-activity-unlinked-activity-refund.md) | Optional | Present only when `GiftCardActivityType` is UNLINKED_ACTIVITY_REFUND. | GiftCardActivityUnlinkedActivityRefund getUnlinkedActivityRefundActivityDetails() |
| `ImportActivityDetails` | [`GiftCardActivityImport`](../../doc/models/gift-card-activity-import.md) | Optional | Describes a gift card activity of the IMPORT type and the `GiftCardGANSource` is OTHER<br>(a third-party gift card). | GiftCardActivityImport getImportActivityDetails() |
| `BlockActivityDetails` | [`GiftCardActivityBlock`](../../doc/models/gift-card-activity-block.md) | Optional | Describes a gift card activity of the BLOCK type. | GiftCardActivityBlock getBlockActivityDetails() |
| `UnblockActivityDetails` | [`GiftCardActivityUnblock`](../../doc/models/gift-card-activity-unblock.md) | Optional | Present only when `GiftCardActivityType` is UNBLOCK. | GiftCardActivityUnblock getUnblockActivityDetails() |
| `ImportReversalActivityDetails` | [`GiftCardActivityImportReversal`](../../doc/models/gift-card-activity-import-reversal.md) | Optional | Present only when GiftCardActivityType is IMPORT_REVERSAL and GiftCardGANSource is OTHER | GiftCardActivityImportReversal getImportReversalActivityDetails() |

## Example (as JSON)

```json
{
  "id": "id0",
  "type": "ADJUST_INCREMENT",
  "location_id": "location_id4",
  "created_at": "created_at2",
  "gift_card_id": "gift_card_id8",
  "gift_card_gan": "gift_card_gan6",
  "gift_card_balance_money": {
    "amount": 82,
    "currency": "LSL"
  }
}
```


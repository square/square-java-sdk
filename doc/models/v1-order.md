## V1 Order

V1Order

### Structure

`V1Order`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. |
| `Id` | `String` | Optional | The order's unique identifier. |
| `BuyerEmail` | `String` | Optional | The email address of the order's buyer. |
| `RecipientName` | `String` | Optional | The name of the order's buyer. |
| `RecipientPhoneNumber` | `String` | Optional | The phone number to use for the order's delivery. |
| `State` | [`String`](/doc/models/v1-order-state.md) | Optional | - |
| `ShippingAddress` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. |
| `SubtotalMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `TotalShippingMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `TotalTaxMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `TotalPriceMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `TotalDiscountMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `CreatedAt` | `String` | Optional | The time when the order was created, in ISO 8601 format. |
| `UpdatedAt` | `String` | Optional | The time when the order was last modified, in ISO 8601 format. |
| `ExpiresAt` | `String` | Optional | The time when the order expires if no action is taken, in ISO 8601 format. |
| `PaymentId` | `String` | Optional | The unique identifier of the payment associated with the order. |
| `BuyerNote` | `String` | Optional | A note provided by the buyer when the order was created, if any. |
| `CompletedNote` | `String` | Optional | A note provided by the merchant when the order's state was set to COMPLETED, if any |
| `RefundedNote` | `String` | Optional | A note provided by the merchant when the order's state was set to REFUNDED, if any. |
| `CanceledNote` | `String` | Optional | A note provided by the merchant when the order's state was set to CANCELED, if any. |
| `Tender` | [`V1Tender`](/doc/models/v1-tender.md) | Optional | A tender represents a discrete monetary exchange. Square represents this<br>exchange as a money object with a specific currency and amount, where the<br>amount is given in the smallest denomination of the given currency.<br><br>Square POS can accept more than one form of tender for a single payment (such<br>as by splitting a bill between a credit card and a gift card). The `tender`<br>field of the Payment object lists all forms of tender used for the payment.<br><br>Split tender payments behave slightly differently from single tender payments:<br><br>The receipt_url for a split tender corresponds only to the first tender listed<br>in the tender field. To get the receipt URLs for the remaining tenders, use<br>the receipt_url fields of the corresponding Tender objects.<br><br>*A note on gift cards**: when a customer purchases a Square gift card from a<br>merchant, the merchant receives the full amount of the gift card in the<br>associated payment.<br><br>When that gift card is used as a tender, the balance of the gift card is<br>reduced and the merchant receives no funds. A `Tender` object with a type of<br>`SQUARE_GIFT_CARD` indicates a gift card was used for some or all of the<br>associated payment. |
| `OrderHistory` | [`List<V1OrderHistoryEntry>`](/doc/models/v1-order-history-entry.md) | Optional | The history of actions associated with the order. |
| `PromoCode` | `String` | Optional | The promo code provided by the buyer, if any. |
| `BtcReceiveAddress` | `String` | Optional | For Bitcoin transactions, the address that the buyer sent Bitcoin to. |
| `BtcPriceSatoshi` | `Double` | Optional | For Bitcoin transactions, the price of the buyer's order in satoshi (100 million satoshi equals 1 BTC). |

### Example (as JSON)

```json
{
  "errors": null,
  "id": null,
  "buyer_email": null,
  "recipient_name": null,
  "recipient_phone_number": null,
  "state": null,
  "shipping_address": null,
  "subtotal_money": null,
  "total_shipping_money": null,
  "total_tax_money": null,
  "total_price_money": null,
  "total_discount_money": null,
  "created_at": null,
  "updated_at": null,
  "expires_at": null,
  "payment_id": null,
  "buyer_note": null,
  "completed_note": null,
  "refunded_note": null,
  "canceled_note": null,
  "tender": null,
  "order_history": null,
  "promo_code": null,
  "btc_receive_address": null,
  "btc_price_satoshi": null
}
```


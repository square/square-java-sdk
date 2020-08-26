## V1 Order

V1Order

### Structure

`V1Order`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Id` | `String` | Optional | The order's unique identifier. | String getId() |
| `BuyerEmail` | `String` | Optional | The email address of the order's buyer. | String getBuyerEmail() |
| `RecipientName` | `String` | Optional | The name of the order's buyer. | String getRecipientName() |
| `RecipientPhoneNumber` | `String` | Optional | The phone number to use for the order's delivery. | String getRecipientPhoneNumber() |
| `State` | [`String`](/doc/models/v1-order-state.md) | Optional | - | String getState() |
| `ShippingAddress` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. | Address getShippingAddress() |
| `SubtotalMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getSubtotalMoney() |
| `TotalShippingMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getTotalShippingMoney() |
| `TotalTaxMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getTotalTaxMoney() |
| `TotalPriceMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getTotalPriceMoney() |
| `TotalDiscountMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getTotalDiscountMoney() |
| `CreatedAt` | `String` | Optional | The time when the order was created, in ISO 8601 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The time when the order was last modified, in ISO 8601 format. | String getUpdatedAt() |
| `ExpiresAt` | `String` | Optional | The time when the order expires if no action is taken, in ISO 8601 format. | String getExpiresAt() |
| `PaymentId` | `String` | Optional | The unique identifier of the payment associated with the order. | String getPaymentId() |
| `BuyerNote` | `String` | Optional | A note provided by the buyer when the order was created, if any. | String getBuyerNote() |
| `CompletedNote` | `String` | Optional | A note provided by the merchant when the order's state was set to COMPLETED, if any | String getCompletedNote() |
| `RefundedNote` | `String` | Optional | A note provided by the merchant when the order's state was set to REFUNDED, if any. | String getRefundedNote() |
| `CanceledNote` | `String` | Optional | A note provided by the merchant when the order's state was set to CANCELED, if any. | String getCanceledNote() |
| `Tender` | [`V1Tender`](/doc/models/v1-tender.md) | Optional | A tender represents a discrete monetary exchange. Square represents this<br>exchange as a money object with a specific currency and amount, where the<br>amount is given in the smallest denomination of the given currency.<br><br>Square POS can accept more than one form of tender for a single payment (such<br>as by splitting a bill between a credit card and a gift card). The `tender`<br>field of the Payment object lists all forms of tender used for the payment.<br><br>Split tender payments behave slightly differently from single tender payments:<br><br>The receipt_url for a split tender corresponds only to the first tender listed<br>in the tender field. To get the receipt URLs for the remaining tenders, use<br>the receipt_url fields of the corresponding Tender objects.<br><br>*A note on gift cards**: when a customer purchases a Square gift card from a<br>merchant, the merchant receives the full amount of the gift card in the<br>associated payment.<br><br>When that gift card is used as a tender, the balance of the gift card is<br>reduced and the merchant receives no funds. A `Tender` object with a type of<br>`SQUARE_GIFT_CARD` indicates a gift card was used for some or all of the<br>associated payment. | V1Tender getTender() |
| `OrderHistory` | [`List<V1OrderHistoryEntry>`](/doc/models/v1-order-history-entry.md) | Optional | The history of actions associated with the order. | List<V1OrderHistoryEntry> getOrderHistory() |
| `PromoCode` | `String` | Optional | The promo code provided by the buyer, if any. | String getPromoCode() |
| `BtcReceiveAddress` | `String` | Optional | For Bitcoin transactions, the address that the buyer sent Bitcoin to. | String getBtcReceiveAddress() |
| `BtcPriceSatoshi` | `Double` | Optional | For Bitcoin transactions, the price of the buyer's order in satoshi (100 million satoshi equals 1 BTC). | Double getBtcPriceSatoshi() |

### Example (as JSON)

```json
{
  "errors": [
    {
      "category": "AUTHENTICATION_ERROR",
      "code": "REQUEST_TIMEOUT",
      "detail": "detail1",
      "field": "field9"
    },
    {
      "category": "INVALID_REQUEST_ERROR",
      "code": "CONFLICT",
      "detail": "detail2",
      "field": "field0"
    },
    {
      "category": "RATE_LIMIT_ERROR",
      "code": "GONE",
      "detail": "detail3",
      "field": "field1"
    }
  ],
  "id": "id0",
  "buyer_email": "buyer_email8",
  "recipient_name": "recipient_name8",
  "recipient_phone_number": "recipient_phone_number4"
}
```


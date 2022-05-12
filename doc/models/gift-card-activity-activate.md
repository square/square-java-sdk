
# Gift Card Activity Activate

Describes a gift card activity of the ACTIVATE type.

## Structure

`GiftCardActivityActivate`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AmountMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmountMoney() |
| `OrderId` | `String` | Optional | The ID of the order associated with the activity.<br>This is required if your application uses the Square Orders API. | String getOrderId() |
| `LineItemUid` | `String` | Optional | The `line_item_uid` of the gift card line item in an order.<br>This is required if your application uses the Square Orders API. | String getLineItemUid() |
| `ReferenceId` | `String` | Optional | If your application does not use the Square Orders API, you can optionally use this field<br>to associate the gift card activity with a client-side entity. | String getReferenceId() |
| `BuyerPaymentInstrumentIds` | `List<String>` | Optional | Required if your application does not use the Square Orders API.<br>This is a list of client-provided payment instrument IDs.<br>Square uses this information to perform compliance checks.<br>If you use the Square Orders API, Square has the necessary instrument IDs to perform necessary<br>compliance checks. | List<String> getBuyerPaymentInstrumentIds() |

## Example (as JSON)

```json
{
  "amount_money": null,
  "order_id": null,
  "line_item_uid": null,
  "reference_id": null,
  "buyer_payment_instrument_ids": null
}
```



# Additional Recipient

Represents an additional recipient (other than the merchant) receiving a portion of this tender.

## Structure

`AdditionalRecipient`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationId` | `String` | Required | The location ID for a recipient (other than the merchant) receiving a portion of this tender.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `50` | String getLocationId() |
| `Description` | `String` | Optional | The description of the additional recipient.<br>**Constraints**: *Maximum Length*: `100` | String getDescription() |
| `AmountMoney` | [`Money`](../../doc/models/money.md) | Required | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmountMoney() |
| `ReceivableId` | `String` | Optional | The unique ID for the RETIRED `AdditionalRecipientReceivable` object. This field should be empty for any `AdditionalRecipient` objects created after the retirement.<br>**Constraints**: *Maximum Length*: `192` | String getReceivableId() |

## Example (as JSON)

```json
{
  "location_id": "location_id2",
  "description": "description2",
  "amount_money": {
    "amount": 186,
    "currency": "AUD"
  },
  "receivable_id": "receivable_id8"
}
```


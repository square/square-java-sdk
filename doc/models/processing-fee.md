
# Processing Fee

Represents Square processing fee.

## Structure

`ProcessingFee`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `EffectiveAt` | `String` | Optional | Timestamp of when the fee takes effect, in RFC 3339 format. | String getEffectiveAt() |
| `Type` | `String` | Optional | The type of fee assessed or adjusted. Can be one of: `INITIAL`, `ADJUSTMENT`. | String getType() |
| `AmountMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmountMoney() |

## Example (as JSON)

```json
{
  "effective_at": "effective_at6",
  "type": "type0",
  "amount_money": {
    "amount": 186,
    "currency": "NGN"
  }
}
```


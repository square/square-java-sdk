
# Catalog Quick Amount

Represents a Quick Amount in the Catalog.

## Structure

`CatalogQuickAmount`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Type` | [`String`](../../doc/models/catalog-quick-amount-type.md) | Required | Determines the type of a specific Quick Amount. | String getType() |
| `Amount` | [`Money`](../../doc/models/money.md) | Required | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmount() |
| `Score` | `Long` | Optional | Describes the ranking of the Quick Amount provided by machine learning model, in the range [0, 100].<br>MANUAL type amount will always have score = 100. | Long getScore() |
| `Ordinal` | `Long` | Optional | The order in which this Quick Amount should be displayed. | Long getOrdinal() |

## Example (as JSON)

```json
{
  "type": "QUICK_AMOUNT_TYPE_MANUAL",
  "amount": {
    "amount": 0,
    "currency": "LAK"
  },
  "score": 12,
  "ordinal": 200
}
```


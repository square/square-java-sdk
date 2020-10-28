
# V1 Discount

V1Discount

## Structure

`V1Discount`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The discount's unique ID. | String getId() |
| `Name` | `String` | Optional | The discount's name. | String getName() |
| `Rate` | `String` | Optional | The rate of the discount, as a string representation of a decimal number. A value of 0.07 corresponds to a rate of 7%. This rate is 0 if discount_type is VARIABLE_PERCENTAGE. | String getRate() |
| `AmountMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getAmountMoney() |
| `DiscountType` | [`String`](/doc/models/v1-discount-discount-type.md) | Optional | - | String getDiscountType() |
| `PinRequired` | `Boolean` | Optional | Indicates whether a mobile staff member needs to enter their PIN to apply the discount to a payment. | Boolean getPinRequired() |
| `Color` | [`String`](/doc/models/v1-discount-color.md) | Optional | - | String getColor() |
| `V2Id` | `String` | Optional | The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID. | String getV2Id() |

## Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "rate": "rate0",
  "amount_money": {
    "amount": 186,
    "currency_code": "KRW"
  },
  "discount_type": "VARIABLE_PERCENTAGE"
}
```


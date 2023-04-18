
# V1 Payment Modifier

V1PaymentModifier

## Structure

`V1PaymentModifier`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Name` | `String` | Optional | The modifier option's name. | String getName() |
| `AppliedMoney` | [`V1Money`](../../doc/models/v1-money.md) | Optional | - | V1Money getAppliedMoney() |
| `ModifierOptionId` | `String` | Optional | The ID of the applied modifier option, if available. Modifier options applied in older versions of Square Register might not have an ID. | String getModifierOptionId() |

## Example (as JSON)

```json
{
  "name": "name0",
  "applied_money": {
    "amount": 196,
    "currency_code": "LYD"
  },
  "modifier_option_id": "modifier_option_id6"
}
```


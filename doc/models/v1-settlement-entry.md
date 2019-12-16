## V1 Settlement Entry

V1SettlementEntry

### Structure

`V1SettlementEntry`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `PaymentId` | `String` | Optional | The settlement's unique identifier. |
| `Type` | [`String`](/doc/models/v1-settlement-entry-type.md) | Optional | - |
| `AmountMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `FeeMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |

### Example (as JSON)

```json
{
  "payment_id": null,
  "type": null,
  "amount_money": null,
  "fee_money": null
}
```


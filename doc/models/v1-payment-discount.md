## V1 Payment Discount

V1PaymentDiscount

### Structure

`V1PaymentDiscount`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Name` | `String` | Optional | The discount's name. | String getName() |
| `AppliedMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getAppliedMoney() |
| `DiscountId` | `String` | Optional | The ID of the applied discount, if available. Discounts applied in older versions of Square Register might not have an ID. | String getDiscountId() |

### Example (as JSON)

```json
{
  "name": "name0",
  "applied_money": {
    "amount": 196,
    "currency_code": "LYD"
  },
  "discount_id": "discount_id8"
}
```


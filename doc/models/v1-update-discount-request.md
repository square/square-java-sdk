## V1 Update Discount Request

### Structure

`V1UpdateDiscountRequest`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `Body` | [`V1Discount`](/doc/models/v1-discount.md) | V1Discount | V1Discount getBody() |

### Example (as JSON)

```json
{
  "body": {
    "id": "id6",
    "name": "name6",
    "rate": "rate4",
    "amount_money": {
      "amount": 194,
      "currency_code": "KWD"
    },
    "discount_type": "VARIABLE_AMOUNT"
  }
}
```


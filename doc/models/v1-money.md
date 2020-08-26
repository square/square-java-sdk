## V1 Money

### Structure

`V1Money`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Amount` | `Integer` | Optional | Amount in the lowest denominated value of this Currency. E.g. in USD<br>these are cents, in JPY they are Yen (which do not have a 'cent' concept). | Integer getAmount() |
| `CurrencyCode` | [`String`](/doc/models/currency.md) | Optional | Indicates the associated currency for an amount of money. Values correspond<br>to [ISO 4217](https://wikipedia.org/wiki/ISO_4217). | String getCurrencyCode() |

### Example (as JSON)

```json
{
  "amount": 46,
  "currency_code": "BTN"
}
```


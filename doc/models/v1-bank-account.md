## V1 Bank Account

V1BankAccount

### Structure

`V1BankAccount`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Id` | `String` | Optional | The bank account's Square-issued ID. |
| `MerchantId` | `String` | Optional | The Square-issued ID of the merchant associated with the bank account. |
| `BankName` | `String` | Optional | The name of the bank that manages the account. |
| `Name` | `String` | Optional | The name associated with the bank account. |
| `RoutingNumber` | `String` | Optional | The bank account's routing number. |
| `AccountNumberSuffix` | `String` | Optional | The last few digits of the bank account number. |
| `CurrencyCode` | `String` | Optional | The currency code of the currency associated with the bank account, in ISO 4217 format. For example, the currency code for US dollars is USD. |
| `Type` | [`String`](/doc/models/v1-bank-account-type.md) | Optional | - |

### Example (as JSON)

```json
{
  "id": null,
  "merchant_id": null,
  "bank_name": null,
  "name": null,
  "routing_number": null,
  "account_number_suffix": null,
  "currency_code": null,
  "type": null
}
```


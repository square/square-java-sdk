## V1 Bank Account

V1BankAccount

### Structure

`V1BankAccount`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The bank account's Square-issued ID. | String getId() |
| `MerchantId` | `String` | Optional | The Square-issued ID of the merchant associated with the bank account. | String getMerchantId() |
| `BankName` | `String` | Optional | The name of the bank that manages the account. | String getBankName() |
| `Name` | `String` | Optional | The name associated with the bank account. | String getName() |
| `RoutingNumber` | `String` | Optional | The bank account's routing number. | String getRoutingNumber() |
| `AccountNumberSuffix` | `String` | Optional | The last few digits of the bank account number. | String getAccountNumberSuffix() |
| `CurrencyCode` | `String` | Optional | The currency code of the currency associated with the bank account, in ISO 4217 format. For example, the currency code for US dollars is USD. | String getCurrencyCode() |
| `Type` | [`String`](/doc/models/v1-bank-account-type.md) | Optional | - | String getType() |

### Example (as JSON)

```json
{
  "id": "id0",
  "merchant_id": "merchant_id0",
  "bank_name": "bank_name4",
  "name": "name0",
  "routing_number": "routing_number4"
}
```


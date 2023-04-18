
# Bank Account Payment Details

Additional details about BANK_ACCOUNT type payments.

## Structure

`BankAccountPaymentDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `BankName` | `String` | Optional | The name of the bank associated with the bank account.<br>**Constraints**: *Maximum Length*: `100` | String getBankName() |
| `TransferType` | `String` | Optional | The type of the bank transfer. The type can be `ACH` or `UNKNOWN`.<br>**Constraints**: *Maximum Length*: `50` | String getTransferType() |
| `AccountOwnershipType` | `String` | Optional | The ownership type of the bank account performing the transfer.<br>The type can be `INDIVIDUAL`, `COMPANY`, or `ACCOUNT_TYPE_UNKNOWN`.<br>**Constraints**: *Maximum Length*: `50` | String getAccountOwnershipType() |
| `Fingerprint` | `String` | Optional | Uniquely identifies the bank account for this seller and can be used<br>to determine if payments are from the same bank account.<br>**Constraints**: *Maximum Length*: `255` | String getFingerprint() |
| `Country` | `String` | Optional | The two-letter ISO code representing the country the bank account is located in.<br>**Constraints**: *Minimum Length*: `2`, *Maximum Length*: `2` | String getCountry() |
| `StatementDescription` | `String` | Optional | The statement description as sent to the bank.<br>**Constraints**: *Maximum Length*: `1000` | String getStatementDescription() |
| `AchDetails` | [`ACHDetails`](../../doc/models/ach-details.md) | Optional | ACH-specific details about `BANK_ACCOUNT` type payments with the `transfer_type` of `ACH`. | ACHDetails getAchDetails() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Information about errors encountered during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "bank_name": "bank_name4",
  "transfer_type": "transfer_type8",
  "account_ownership_type": "account_ownership_type8",
  "fingerprint": "fingerprint6",
  "country": "country4",
  "statement_description": "statement_description4",
  "ach_details": {
    "routing_number": "routing_number0",
    "account_number_suffix": "account_number_suffix2",
    "account_type": "account_type2"
  },
  "errors": [
    {
      "category": "AUTHENTICATION_ERROR",
      "code": "REFUND_ALREADY_PENDING",
      "detail": "detail1",
      "field": "field9"
    },
    {
      "category": "INVALID_REQUEST_ERROR",
      "code": "PAYMENT_NOT_REFUNDABLE",
      "detail": "detail2",
      "field": "field0"
    },
    {
      "category": "RATE_LIMIT_ERROR",
      "code": "REFUND_DECLINED",
      "detail": "detail3",
      "field": "field1"
    }
  ]
}
```



# Tender Bank Account Details

Represents the details of a tender with `type` `BANK_ACCOUNT`.

See [BankAccountPaymentDetails](../../doc/models/bank-account-payment-details.md)
for more exposed details of a bank account payment.

## Structure

`TenderBankAccountDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Status` | [`String`](../../doc/models/tender-bank-account-details-status.md) | Optional | Indicates the bank account payment's current status. | String getStatus() |

## Example (as JSON)

```json
{
  "status": "FAILED"
}
```


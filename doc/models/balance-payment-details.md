## Balance Payment Details

Reflects the current status of a balance payment.

### Structure

`BalancePaymentDetails`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AccountId` | `String` | Optional | ID for the account used to fund the payment. | String getAccountId() |
| `Status` | `String` | Optional | The balance payment’s current state. Can be `COMPLETED` or `FAILED`. | String getStatus() |

### Example (as JSON)

```json
{
  "account_id": "account_id2",
  "status": "status8"
}
```


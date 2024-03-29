
# ACH Details

ACH-specific details about `BANK_ACCOUNT` type payments with the `transfer_type` of `ACH`.

## Structure

`ACHDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `RoutingNumber` | `String` | Optional | The routing number for the bank account.<br>**Constraints**: *Maximum Length*: `50` | String getRoutingNumber() |
| `AccountNumberSuffix` | `String` | Optional | The last few digits of the bank account number.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `4` | String getAccountNumberSuffix() |
| `AccountType` | `String` | Optional | The type of the bank account performing the transfer. The account type can be `CHECKING`,<br>`SAVINGS`, or `UNKNOWN`.<br>**Constraints**: *Maximum Length*: `50` | String getAccountType() |

## Example (as JSON)

```json
{
  "routing_number": "routing_number6",
  "account_number_suffix": "account_number_suffix6",
  "account_type": "account_type8"
}
```


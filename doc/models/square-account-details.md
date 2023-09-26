
# Square Account Details

Additional details about Square Account payments.

## Structure

`SquareAccountDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `PaymentSourceToken` | `String` | Optional | Unique identifier for the payment source used for this payment.<br>**Constraints**: *Maximum Length*: `255` | String getPaymentSourceToken() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Information about errors encountered during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "payment_source_token": "payment_source_token8",
  "errors": [
    {
      "category": "MERCHANT_SUBSCRIPTION_ERROR",
      "code": "MAP_KEY_LENGTH_TOO_LONG",
      "detail": "detail6",
      "field": "field4"
    },
    {
      "category": "MERCHANT_SUBSCRIPTION_ERROR",
      "code": "MAP_KEY_LENGTH_TOO_LONG",
      "detail": "detail6",
      "field": "field4"
    }
  ]
}
```


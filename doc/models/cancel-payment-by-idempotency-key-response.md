
# Cancel Payment by Idempotency Key Response

Defines the response returned by
[CancelPaymentByIdempotencyKey](/doc/api/payments.md#cancel-payment-by-idempotency-key).
On success, `errors` is empty.

## Structure

`CancelPaymentByIdempotencyKeyResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{}
```


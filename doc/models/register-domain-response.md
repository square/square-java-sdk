
# Register Domain Response

Defines the fields that are included in the response body of
a request to the [RegisterDomain](../../doc/api/apple-pay.md#register-domain) endpoint.

Either `errors` or `status` are present in a given response (never both).

## Structure

`RegisterDomainResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Status` | [`String`](../../doc/models/register-domain-response-status.md) | Optional | The status of the domain registration. | String getStatus() |

## Example (as JSON)

```json
{
  "status": "VERIFIED",
  "errors": [
    {
      "category": "MERCHANT_SUBSCRIPTION_ERROR",
      "code": "INVALID_EXPIRATION",
      "detail": "detail6",
      "field": "field4"
    },
    {
      "category": "MERCHANT_SUBSCRIPTION_ERROR",
      "code": "INVALID_EXPIRATION",
      "detail": "detail6",
      "field": "field4"
    },
    {
      "category": "MERCHANT_SUBSCRIPTION_ERROR",
      "code": "INVALID_EXPIRATION",
      "detail": "detail6",
      "field": "field4"
    }
  ]
}
```


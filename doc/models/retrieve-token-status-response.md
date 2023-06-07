
# Retrieve Token Status Response

Defines the fields that are included in the response body of
a request to the `RetrieveTokenStatus` endpoint.

## Structure

`RetrieveTokenStatusResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Scopes` | `List<String>` | Optional | The list of scopes associated with an access token. | List<String> getScopes() |
| `ExpiresAt` | `String` | Optional | The date and time when the `access_token` expires, in RFC 3339 format. Empty if the token never expires. | String getExpiresAt() |
| `ClientId` | `String` | Optional | The Square-issued application ID associated with the access token. This is the same application ID used to obtain the token.<br>**Constraints**: *Maximum Length*: `191` | String getClientId() |
| `MerchantId` | `String` | Optional | The ID of the authorizing merchant's business.<br>**Constraints**: *Minimum Length*: `8`, *Maximum Length*: `191` | String getMerchantId() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "client_id": "CLIENT_ID",
  "expires_at": "2022-10-14T14:44:00Z",
  "merchant_id": "MERCHANT_ID",
  "scopes": [
    "PAYMENTS_READ",
    "PAYMENTS_WRITE"
  ],
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


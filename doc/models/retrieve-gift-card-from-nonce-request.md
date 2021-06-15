
# Retrieve Gift Card From Nonce Request

A request to retrieve gift cards by using nonces.

## Structure

`RetrieveGiftCardFromNonceRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Nonce` | `String` | Required | The nonce of the gift card to retrieve.<br>**Constraints**: *Minimum Length*: `1` | String getNonce() |

## Example (as JSON)

```json
{
  "nonce": "cnon:7783322135245171"
}
```


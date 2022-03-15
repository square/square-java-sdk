
# Revoke Token Response

## Structure

`RevokeTokenResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Success` | `Boolean` | Optional | If the request is successful, this is `true`. | Boolean getSuccess() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "success": true
}
```


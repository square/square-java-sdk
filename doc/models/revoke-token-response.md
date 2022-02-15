
# Revoke Token Response

## Structure

`RevokeTokenResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Success` | `Boolean` | Optional | If the request is successful, this is `true`. | Boolean getSuccess() |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | An error object that provides details about how creation of the obtain<br>token failed. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "success": true
}
```



# V1 Phone Number

Represents a phone number.

## Structure

`V1PhoneNumber`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CallingCode` | `String` | Required | The phone number's international calling code. For US phone numbers, this value is +1. | String getCallingCode() |
| `Number` | `String` | Required | The phone number. | String getNumber() |

## Example (as JSON)

```json
{
  "calling_code": "calling_code0",
  "number": "number4"
}
```


## V1 Phone Number

Represents a phone number.

### Structure

`V1PhoneNumber`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `CallingCode` | `String` | The phone number's international calling code. For US phone numbers, this value is +1. | String getCallingCode() |
| `Number` | `String` | The phone number. | String getNumber() |

### Example (as JSON)

```json
{
  "calling_code": "calling_code4",
  "number": "number2"
}
```


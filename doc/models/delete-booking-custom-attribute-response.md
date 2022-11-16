
# Delete Booking Custom Attribute Response

Represents a [DeleteBookingCustomAttribute](../../doc/api/booking-custom-attributes.md#delete-booking-custom-attribute) response.
Either an empty object `{}` (for a successful deletion) or `errors` is present in the response.

## Structure

`DeleteBookingCustomAttributeResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "errors": []
}
```


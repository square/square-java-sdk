
# Delete Booking Custom Attribute Definition Response

Represents a [DeleteBookingCustomAttributeDefinition](../../doc/api/booking-custom-attributes.md#delete-booking-custom-attribute-definition) response
containing error messages when errors occurred during the request. The successful response does not contain any payload.

## Structure

`DeleteBookingCustomAttributeDefinitionResponse`

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


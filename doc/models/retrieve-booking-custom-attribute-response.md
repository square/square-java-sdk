
# Retrieve Booking Custom Attribute Response

Represents a [RetrieveBookingCustomAttribute](../../doc/api/booking-custom-attributes.md#retrieve-booking-custom-attribute) response.
Either `custom_attribute_definition` or `errors` is present in the response.

## Structure

`RetrieveBookingCustomAttributeResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CustomAttribute` | [`CustomAttribute`](../../doc/models/custom-attribute.md) | Optional | A custom attribute value. Each custom attribute value has a corresponding<br>`CustomAttributeDefinition` object. | CustomAttribute getCustomAttribute() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "custom_attribute": null,
  "errors": null
}
```



# Upsert Booking Custom Attribute Request

Represents an [UpsertBookingCustomAttribute](../../doc/api/booking-custom-attributes.md#upsert-booking-custom-attribute) request.

## Structure

`UpsertBookingCustomAttributeRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CustomAttribute` | [`CustomAttribute`](../../doc/models/custom-attribute.md) | Required | A custom attribute value. Each custom attribute value has a corresponding<br>`CustomAttributeDefinition` object. | CustomAttribute getCustomAttribute() |
| `IdempotencyKey` | `String` | Optional | A unique identifier for this request, used to ensure idempotency. For more information,<br>see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).<br>**Constraints**: *Maximum Length*: `45` | String getIdempotencyKey() |

## Example (as JSON)

```json
{
  "custom_attribute": {
    "key": null,
    "value": null,
    "version": null,
    "visibility": null,
    "definition": null
  },
  "idempotency_key": null
}
```


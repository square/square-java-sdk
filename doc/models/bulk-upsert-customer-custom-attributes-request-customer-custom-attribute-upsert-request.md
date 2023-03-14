
# Bulk Upsert Customer Custom Attributes Request Customer Custom Attribute Upsert Request

Represents an individual upsert request in a [BulkUpsertCustomerCustomAttributes](../../doc/api/customer-custom-attributes.md#bulk-upsert-customer-custom-attributes)
request. An individual request contains a customer ID, the custom attribute to create or update,
and an optional idempotency key.

## Structure

`BulkUpsertCustomerCustomAttributesRequestCustomerCustomAttributeUpsertRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CustomerId` | `String` | Required | The ID of the target [customer profile](../../doc/models/customer.md).<br>**Constraints**: *Minimum Length*: `1` | String getCustomerId() |
| `CustomAttribute` | [`CustomAttribute`](../../doc/models/custom-attribute.md) | Required | A custom attribute value. Each custom attribute value has a corresponding<br>`CustomAttributeDefinition` object. | CustomAttribute getCustomAttribute() |
| `IdempotencyKey` | `String` | Optional | A unique identifier for this individual upsert request, used to ensure idempotency.<br>For more information, see [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).<br>**Constraints**: *Maximum Length*: `45` | String getIdempotencyKey() |

## Example (as JSON)

```json
{
  "customer_id": "customer_id8",
  "custom_attribute": {
    "key": null,
    "value": null,
    "version": null,
    "visibility": null,
    "definition": null,
    "updated_at": null,
    "created_at": null
  },
  "idempotency_key": null
}
```


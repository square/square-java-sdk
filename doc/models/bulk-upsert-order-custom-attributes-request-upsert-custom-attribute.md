
# Bulk Upsert Order Custom Attributes Request Upsert Custom Attribute

Represents one upsert within the bulk operation.

## Structure

`BulkUpsertOrderCustomAttributesRequestUpsertCustomAttribute`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CustomAttribute` | [`CustomAttribute`](../../doc/models/custom-attribute.md) | Required | A custom attribute value. Each custom attribute value has a corresponding<br>`CustomAttributeDefinition` object. | CustomAttribute getCustomAttribute() |
| `IdempotencyKey` | `String` | Optional | A unique identifier for this request, used to ensure idempotency.<br>For more information, see [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency).<br>**Constraints**: *Maximum Length*: `45` | String getIdempotencyKey() |
| `OrderId` | `String` | Required | The ID of the target [order](../../doc/models/order.md). | String getOrderId() |

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
  "idempotency_key": null,
  "order_id": "order_id6"
}
```


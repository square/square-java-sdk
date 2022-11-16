
# Bulk Upsert Order Custom Attributes Response

Represents a response from a bulk upsert of order custom attributes.

## Structure

`BulkUpsertOrderCustomAttributesResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Values` | [`Map<String, UpsertOrderCustomAttributeResponse>`](../../doc/models/upsert-order-custom-attribute-response.md) | Required | A map of responses that correspond to individual upsert operations for custom attributes. | Map<String, UpsertOrderCustomAttributeResponse> getValues() |

## Example (as JSON)

```json
{
  "errors": null,
  "values": {
    "key0": {
      "custom_attribute": null,
      "errors": null
    },
    "key1": {
      "custom_attribute": null,
      "errors": null
    },
    "key2": {
      "custom_attribute": null,
      "errors": null
    }
  }
}
```



# Create Vendor Response

Represents an output from a call to [CreateVendor](../../doc/api/vendors.md#create-vendor).

## Structure

`CreateVendorResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Errors encountered when the request fails. | List<Error> getErrors() |
| `Vendor` | [`Vendor`](../../doc/models/vendor.md) | Optional | Represents a supplier to a seller. | Vendor getVendor() |

## Example (as JSON)

```json
{
  "errors": null,
  "vendor": null
}
```


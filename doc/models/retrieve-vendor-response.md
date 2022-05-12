
# Retrieve Vendor Response

Represents an output from a call to [RetrieveVendor](../../doc/api/vendors.md#retrieve-vendor).

## Structure

`RetrieveVendorResponse`

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


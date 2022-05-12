
# Vendor Contact

Represents a contact of a [Vendor](../../doc/models/vendor.md).

## Structure

`VendorContact`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique Square-generated ID for the [VendorContact](../../doc/models/vendor-contact.md).<br>This field is required when attempting to update a [VendorContact](../../doc/models/vendor-contact.md).<br>**Constraints**: *Maximum Length*: `100` | String getId() |
| `Name` | `String` | Optional | The name of the [VendorContact](../../doc/models/vendor-contact.md).<br>This field is required when attempting to create a [Vendor](../../doc/models/vendor.md).<br>**Constraints**: *Maximum Length*: `255` | String getName() |
| `EmailAddress` | `String` | Optional | The email address of the [VendorContact](../../doc/models/vendor-contact.md).<br>**Constraints**: *Maximum Length*: `255` | String getEmailAddress() |
| `PhoneNumber` | `String` | Optional | The phone number of the [VendorContact](../../doc/models/vendor-contact.md).<br>**Constraints**: *Maximum Length*: `255` | String getPhoneNumber() |
| `Removed` | `Boolean` | Optional | The state of the [VendorContact](../../doc/models/vendor-contact.md). | Boolean getRemoved() |
| `Ordinal` | `int` | Required | The ordinal of the [VendorContact](../../doc/models/vendor-contact.md). | int getOrdinal() |

## Example (as JSON)

```json
{
  "id": null,
  "name": null,
  "email_address": null,
  "phone_number": null,
  "removed": null,
  "ordinal": 80
}
```



# Vendor Contact

Represents a contact of a [Vendor](../../doc/models/vendor.md).

## Structure

`VendorContact`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique Square-generated ID for the [VendorContact](entity:VendorContact).<br>This field is required when attempting to update a [VendorContact](entity:VendorContact).<br>**Constraints**: *Maximum Length*: `100` | String getId() |
| `Name` | `String` | Optional | The name of the [VendorContact](entity:VendorContact).<br>This field is required when attempting to create a [Vendor](entity:Vendor).<br>**Constraints**: *Maximum Length*: `255` | String getName() |
| `EmailAddress` | `String` | Optional | The email address of the [VendorContact](entity:VendorContact).<br>**Constraints**: *Maximum Length*: `255` | String getEmailAddress() |
| `PhoneNumber` | `String` | Optional | The phone number of the [VendorContact](entity:VendorContact).<br>**Constraints**: *Maximum Length*: `255` | String getPhoneNumber() |
| `Removed` | `Boolean` | Optional | The state of the [VendorContact](entity:VendorContact). | Boolean getRemoved() |
| `Ordinal` | `int` | Required | The ordinal of the [VendorContact](entity:VendorContact). | int getOrdinal() |

## Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "email_address": "email_address2",
  "phone_number": "phone_number2",
  "removed": false,
  "ordinal": 80
}
```


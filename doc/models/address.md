## Address

Represents a physical address.

### Structure

`Address`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `AddressLine1` | `String` | Optional | The first line of the address.<br><br>Fields that start with `address_line` provide the address's most specific<br>details, like street number, street name, and building name. They do *not*<br>provide less specific details like city, state/province, or country (these<br>details are provided in other fields). |
| `AddressLine2` | `String` | Optional | The second line of the address, if any. |
| `AddressLine3` | `String` | Optional | The third line of the address, if any. |
| `Locality` | `String` | Optional | The city or town of the address. |
| `Sublocality` | `String` | Optional | A civil region within the address's `locality`, if any. |
| `Sublocality2` | `String` | Optional | A civil region within the address's `sublocality`, if any. |
| `Sublocality3` | `String` | Optional | A civil region within the address's `sublocality_2`, if any. |
| `AdministrativeDistrictLevel1` | `String` | Optional | A civil entity within the address's country. In the US, this<br>is the state. |
| `AdministrativeDistrictLevel2` | `String` | Optional | A civil entity within the address's `administrative_district_level_1`.<br>In the US, this is the county. |
| `AdministrativeDistrictLevel3` | `String` | Optional | A civil entity within the address's `administrative_district_level_2`,<br>if any. |
| `PostalCode` | `String` | Optional | The address's postal code. |
| `Country` | [`String`](/doc/models/country.md) | Optional | Indicates the country associated with another entity, such as a business.<br>Values are in [ISO 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm). |
| `FirstName` | `String` | Optional | Optional first name when it's representing recipient. |
| `LastName` | `String` | Optional | Optional last name when it's representing recipient. |
| `Organization` | `String` | Optional | Optional organization name when it's representing recipient. |

### Example (as JSON)

```json
{
  "address_line_1": null,
  "address_line_2": null,
  "address_line_3": null,
  "locality": null,
  "sublocality": null,
  "sublocality_2": null,
  "sublocality_3": null,
  "administrative_district_level_1": null,
  "administrative_district_level_2": null,
  "administrative_district_level_3": null,
  "postal_code": null,
  "country": null,
  "first_name": null,
  "last_name": null,
  "organization": null
}
```


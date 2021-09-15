
# Address

Represents a physical address.

## Structure

`Address`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AddressLine1` | `String` | Optional | The first line of the address.<br><br>Fields that start with `address_line` provide the address's most specific<br>details, like street number, street name, and building name. They do *not*<br>provide less specific details like city, state/province, or country (these<br>details are provided in other fields). | String getAddressLine1() |
| `AddressLine2` | `String` | Optional | The second line of the address, if any. | String getAddressLine2() |
| `AddressLine3` | `String` | Optional | The third line of the address, if any. | String getAddressLine3() |
| `Locality` | `String` | Optional | The city or town of the address. | String getLocality() |
| `Sublocality` | `String` | Optional | A civil region within the address's `locality`, if any. | String getSublocality() |
| `Sublocality2` | `String` | Optional | A civil region within the address's `sublocality`, if any. | String getSublocality2() |
| `Sublocality3` | `String` | Optional | A civil region within the address's `sublocality_2`, if any. | String getSublocality3() |
| `AdministrativeDistrictLevel1` | `String` | Optional | A civil entity within the address's country. In the US, this<br>is the state. | String getAdministrativeDistrictLevel1() |
| `AdministrativeDistrictLevel2` | `String` | Optional | A civil entity within the address's `administrative_district_level_1`.<br>In the US, this is the county. | String getAdministrativeDistrictLevel2() |
| `AdministrativeDistrictLevel3` | `String` | Optional | A civil entity within the address's `administrative_district_level_2`,<br>if any. | String getAdministrativeDistrictLevel3() |
| `PostalCode` | `String` | Optional | The address's postal code. | String getPostalCode() |
| `Country` | [`String`](/doc/models/country.md) | Optional | Indicates the country associated with another entity, such as a business.<br>Values are in [ISO 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm). | String getCountry() |
| `FirstName` | `String` | Optional | Optional first name when it's representing recipient. | String getFirstName() |
| `LastName` | `String` | Optional | Optional last name when it's representing recipient. | String getLastName() |
| `Organization` | `String` | Optional | Optional organization name when it's representing recipient. | String getOrganization() |

## Example (as JSON)

```json
{
  "address_line_1": "address_line_10",
  "address_line_2": "address_line_20",
  "address_line_3": "address_line_36",
  "locality": "locality0",
  "sublocality": "sublocality0"
}
```


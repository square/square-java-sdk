
# Address

Represents a postal address in a country.
For more information, see [Working with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).

## Structure

`Address`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AddressLine1` | `String` | Optional | The first line of the address.<br><br>Fields that start with `address_line` provide the address's most specific<br>details, like street number, street name, and building name. They do *not*<br>provide less specific details like city, state/province, or country (these<br>details are provided in other fields). | String getAddressLine1() |
| `AddressLine2` | `String` | Optional | The second line of the address, if any. | String getAddressLine2() |
| `AddressLine3` | `String` | Optional | The third line of the address, if any. | String getAddressLine3() |
| `Locality` | `String` | Optional | The city or town of the address. For a full list of field meanings by country, see [Working with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses). | String getLocality() |
| `Sublocality` | `String` | Optional | A civil region within the address's `locality`, if any. | String getSublocality() |
| `Sublocality2` | `String` | Optional | A civil region within the address's `sublocality`, if any. | String getSublocality2() |
| `Sublocality3` | `String` | Optional | A civil region within the address's `sublocality_2`, if any. | String getSublocality3() |
| `AdministrativeDistrictLevel1` | `String` | Optional | A civil entity within the address's country. In the US, this<br>is the state. For a full list of field meanings by country, see [Working with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses). | String getAdministrativeDistrictLevel1() |
| `AdministrativeDistrictLevel2` | `String` | Optional | A civil entity within the address's `administrative_district_level_1`.<br>In the US, this is the county. | String getAdministrativeDistrictLevel2() |
| `AdministrativeDistrictLevel3` | `String` | Optional | A civil entity within the address's `administrative_district_level_2`,<br>if any. | String getAdministrativeDistrictLevel3() |
| `PostalCode` | `String` | Optional | The address's postal code. For a full list of field meanings by country, see [Working with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses). | String getPostalCode() |
| `Country` | [`String`](../../doc/models/country.md) | Optional | Indicates the country associated with another entity, such as a business.<br>Values are in [ISO 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm). | String getCountry() |
| `FirstName` | `String` | Optional | Optional first name when it's representing recipient. | String getFirstName() |
| `LastName` | `String` | Optional | Optional last name when it's representing recipient. | String getLastName() |

## Example (as JSON)

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
  "last_name": null
}
```


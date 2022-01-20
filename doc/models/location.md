
# Location

Represents one of a business's [locations](https://developer.squareup.com/docs/locations-api).

## Structure

`Location`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A short, generated string of letters and numbers that uniquely identifies this location instance.<br>**Constraints**: *Maximum Length*: `32` | String getId() |
| `Name` | `String` | Optional | The name of the location.<br>This information appears in the dashboard as the nickname.<br>A location name must be unique within a seller account.<br>**Constraints**: *Maximum Length*: `255` | String getName() |
| `Address` | [`Address`](/doc/models/address.md) | Optional | Represents a postal address in a country.<br>For more information, see [Working with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses). | Address getAddress() |
| `Timezone` | `String` | Optional | The [IANA Timezone](https://www.iana.org/time-zones) identifier for<br>the timezone of the location. For example, `America/Los_Angeles`.<br>**Constraints**: *Maximum Length*: `30` | String getTimezone() |
| `Capabilities` | [`List<String>`](/doc/models/location-capability.md) | Optional | The Square features that are enabled for the location.<br>See [LocationCapability](/doc/models/location-capability.md) for possible values.<br>See [LocationCapability](#type-locationcapability) for possible values | List<String> getCapabilities() |
| `Status` | [`String`](/doc/models/location-status.md) | Optional | A location's status. | String getStatus() |
| `CreatedAt` | `String` | Optional | The time when the location was created, in RFC 3339 format.<br>For more information, see [Working with Dates](https://developer.squareup.com/docs/build-basics/working-with-dates).<br>**Constraints**: *Minimum Length*: `20`, *Maximum Length*: `25` | String getCreatedAt() |
| `MerchantId` | `String` | Optional | The ID of the merchant that owns the location.<br>**Constraints**: *Maximum Length*: `32` | String getMerchantId() |
| `Country` | [`String`](/doc/models/country.md) | Optional | Indicates the country associated with another entity, such as a business.<br>Values are in [ISO 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm). | String getCountry() |
| `LanguageCode` | `String` | Optional | The language associated with the location, in<br>[BCP 47 format](https://tools.ietf.org/html/bcp47#appendix-A).<br>For more information, see [Location language code](https://developer.squareup.com/docs/locations-api#location-language-code).<br>**Constraints**: *Minimum Length*: `5`, *Maximum Length*: `5` | String getLanguageCode() |
| `Currency` | [`String`](/doc/models/currency.md) | Optional | Indicates the associated currency for an amount of money. Values correspond<br>to [ISO 4217](https://wikipedia.org/wiki/ISO_4217). | String getCurrency() |
| `PhoneNumber` | `String` | Optional | The phone number of the location. For example, `+1 855-700-6000`.<br>**Constraints**: *Maximum Length*: `17` | String getPhoneNumber() |
| `BusinessName` | `String` | Optional | The business name of the location.<br>**Constraints**: *Maximum Length*: `255` | String getBusinessName() |
| `Type` | [`String`](/doc/models/location-type.md) | Optional | A location's type. | String getType() |
| `WebsiteUrl` | `String` | Optional | The website URL of the location.  For example, `https://squareup.com`.<br>**Constraints**: *Maximum Length*: `255` | String getWebsiteUrl() |
| `BusinessHours` | [`BusinessHours`](/doc/models/business-hours.md) | Optional | The hours of operation for a location. | BusinessHours getBusinessHours() |
| `BusinessEmail` | `String` | Optional | The email address of the location. This can be unique to the location, and is not always the email address for the business owner or admin.<br>**Constraints**: *Maximum Length*: `255` | String getBusinessEmail() |
| `Description` | `String` | Optional | The description of the location. For example, `Main Street location`.<br>**Constraints**: *Maximum Length*: `1024` | String getDescription() |
| `TwitterUsername` | `String` | Optional | The Twitter username of the location without the '@' symbol. For example, `Square`.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `15` | String getTwitterUsername() |
| `InstagramUsername` | `String` | Optional | The Instagram username of the location without the '@' symbol. For example, `square`.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `30` | String getInstagramUsername() |
| `FacebookUrl` | `String` | Optional | The Facebook profile URL of the location. The URL should begin with 'facebook.com/'. For example, `https://www.facebook.com/square`.<br>**Constraints**: *Maximum Length*: `255` | String getFacebookUrl() |
| `Coordinates` | [`Coordinates`](/doc/models/coordinates.md) | Optional | Latitude and longitude coordinates. | Coordinates getCoordinates() |
| `LogoUrl` | `String` | Optional | The URL of the logo image for the location. When configured in the Seller<br>dashboard (Receipts section), the logo appears on transactions (such as receipts and invoices)<br>that Square generates on behalf of the Seller. This image should have a roughly square (1:1) aspect ratio<br>and is recommended to be at least 200x200 pixels.<br>**Constraints**: *Maximum Length*: `255` | String getLogoUrl() |
| `PosBackgroundUrl` | `String` | Optional | The URL of the Point of Sale background image for the location.<br>**Constraints**: *Maximum Length*: `255` | String getPosBackgroundUrl() |
| `Mcc` | `String` | Optional | A four-digit number that describes the kind of goods or services sold at the location.<br>The [merchant category code (MCC)](https://developer.squareup.com/docs/locations-api#initialize-a-merchant-category-code) of the location as standardized by ISO 18245.<br>For example, `5045`, for a location that sells computer goods and software.<br>**Constraints**: *Minimum Length*: `4`, *Maximum Length*: `4` | String getMcc() |
| `FullFormatLogoUrl` | `String` | Optional | The URL of a full-format logo image for the location. When configured in the Seller<br>dashboard (Receipts section), the logo appears on transactions (such as receipts and invoices)<br>that Square generates on behalf of the Seller. This image can be wider than it is tall,<br>and is recommended to be at least 1280x648 pixels. | String getFullFormatLogoUrl() |
| `TaxIds` | [`TaxIds`](/doc/models/tax-ids.md) | Optional | Identifiers for the location used by various governments for tax purposes. | TaxIds getTaxIds() |

## Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "address": {
    "address_line_1": "address_line_16",
    "address_line_2": "address_line_26",
    "address_line_3": "address_line_32",
    "locality": "locality6",
    "sublocality": "sublocality6"
  },
  "timezone": "timezone0",
  "capabilities": [
    "AUTOMATIC_TRANSFERS"
  ]
}
```


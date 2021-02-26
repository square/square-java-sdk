
# Merchant

Represents a Square seller.

## Structure

`Merchant`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-issued ID of the merchant. | String getId() |
| `BusinessName` | `String` | Optional | The business name of the merchant. | String getBusinessName() |
| `Country` | [`String`](/doc/models/country.md) | Required | Indicates the country associated with another entity, such as a business.<br>Values are in [ISO 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm). | String getCountry() |
| `LanguageCode` | `String` | Optional | The language code associated with the merchant account, in BCP 47 format. | String getLanguageCode() |
| `Currency` | [`String`](/doc/models/currency.md) | Optional | Indicates the associated currency for an amount of money. Values correspond<br>to [ISO 4217](https://wikipedia.org/wiki/ISO_4217). | String getCurrency() |
| `Status` | [`String`](/doc/models/merchant-status.md) | Optional | - | String getStatus() |
| `MainLocationId` | `String` | Optional | The ID of the main `Location` for this merchant. | String getMainLocationId() |

## Example (as JSON)

```json
{
  "id": "id0",
  "business_name": "business_name4",
  "country": "FO",
  "language_code": "language_code8",
  "currency": "YER",
  "status": "ACTIVE"
}
```


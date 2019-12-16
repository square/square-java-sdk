## V1 Merchant

Defines the fields that are included in the response body of
a request to the **RetrieveBusiness** endpoint.

### Structure

`V1Merchant`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Id` | `String` | Optional | The merchant account's unique identifier. |
| `Name` | `String` | Optional | The name associated with the merchant account. |
| `Email` | `String` | Optional | The email address associated with the merchant account. |
| `AccountType` | [`String`](/doc/models/v1-merchant-account-type.md) | Optional | - |
| `AccountCapabilities` | `List<String>` | Optional | Capabilities that are enabled for the merchant's Square account. Capabilities that are not listed in this array are not enabled for the account. |
| `CountryCode` | `String` | Optional | The country associated with the merchant account, in ISO 3166-1-alpha-2 format. |
| `LanguageCode` | `String` | Optional | The language associated with the merchant account, in BCP 47 format. |
| `CurrencyCode` | `String` | Optional | The currency associated with the merchant account, in ISO 4217 format. For example, the currency code for US dollars is USD. |
| `BusinessName` | `String` | Optional | The name of the merchant's business. |
| `BusinessAddress` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. |
| `BusinessPhone` | [`V1PhoneNumber`](/doc/models/v1-phone-number.md) | Optional | Represents a phone number. |
| `BusinessType` | [`String`](/doc/models/v1-merchant-business-type.md) | Optional | - |
| `ShippingAddress` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. |
| `LocationDetails` | [`V1MerchantLocationDetails`](/doc/models/v1-merchant-location-details.md) | Optional | Additional information for a single-location account specified by its associated business account, if it has one. |
| `MarketUrl` | `String` | Optional | The URL of the merchant's online store. |

### Example (as JSON)

```json
{
  "id": null,
  "name": null,
  "email": null,
  "account_type": null,
  "account_capabilities": null,
  "country_code": null,
  "language_code": null,
  "currency_code": null,
  "business_name": null,
  "business_address": null,
  "business_phone": null,
  "business_type": null,
  "shipping_address": null,
  "location_details": null,
  "market_url": null
}
```


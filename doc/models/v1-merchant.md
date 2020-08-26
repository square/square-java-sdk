## V1 Merchant

Defines the fields that are included in the response body of
a request to the **RetrieveBusiness** endpoint.

### Structure

`V1Merchant`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The merchant account's unique identifier. | String getId() |
| `Name` | `String` | Optional | The name associated with the merchant account. | String getName() |
| `Email` | `String` | Optional | The email address associated with the merchant account. | String getEmail() |
| `AccountType` | [`String`](/doc/models/v1-merchant-account-type.md) | Optional | - | String getAccountType() |
| `AccountCapabilities` | `List<String>` | Optional | Capabilities that are enabled for the merchant's Square account. Capabilities that are not listed in this array are not enabled for the account. | List<String> getAccountCapabilities() |
| `CountryCode` | `String` | Optional | The country associated with the merchant account, in ISO 3166-1-alpha-2 format. | String getCountryCode() |
| `LanguageCode` | `String` | Optional | The language associated with the merchant account, in BCP 47 format. | String getLanguageCode() |
| `CurrencyCode` | `String` | Optional | The currency associated with the merchant account, in ISO 4217 format. For example, the currency code for US dollars is USD. | String getCurrencyCode() |
| `BusinessName` | `String` | Optional | The name of the merchant's business. | String getBusinessName() |
| `BusinessAddress` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. | Address getBusinessAddress() |
| `BusinessPhone` | [`V1PhoneNumber`](/doc/models/v1-phone-number.md) | Optional | Represents a phone number. | V1PhoneNumber getBusinessPhone() |
| `BusinessType` | [`String`](/doc/models/v1-merchant-business-type.md) | Optional | - | String getBusinessType() |
| `ShippingAddress` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. | Address getShippingAddress() |
| `LocationDetails` | [`V1MerchantLocationDetails`](/doc/models/v1-merchant-location-details.md) | Optional | Additional information for a single-location account specified by its associated business account, if it has one. | V1MerchantLocationDetails getLocationDetails() |
| `MarketUrl` | `String` | Optional | The URL of the merchant's online store. | String getMarketUrl() |

### Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "email": "email6",
  "account_type": "LOCATION",
  "account_capabilities": [
    "account_capabilities8"
  ]
}
```



# Create Customer Request

Defines the body parameters that can be included in a request to the
`CreateCustomer` endpoint.

## Structure

`CreateCustomerRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `IdempotencyKey` | `String` | Optional | The idempotency key for the request.	For more information, see<br>[Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency). | String getIdempotencyKey() |
| `GivenName` | `String` | Optional | The given name (that is, the first name) associated with the customer profile.<br><br>The maximum length for this value is 300 characters. | String getGivenName() |
| `FamilyName` | `String` | Optional | The family name (that is, the last name) associated with the customer profile.<br><br>The maximum length for this value is 300 characters. | String getFamilyName() |
| `CompanyName` | `String` | Optional | A business name associated with the customer profile.<br><br>The maximum length for this value is 500 characters. | String getCompanyName() |
| `Nickname` | `String` | Optional | A nickname for the customer profile.<br><br>The maximum length for this value is 100 characters. | String getNickname() |
| `EmailAddress` | `String` | Optional | The email address associated with the customer profile.<br><br>The maximum length for this value is 254 characters. | String getEmailAddress() |
| `Address` | [`Address`](../../doc/models/address.md) | Optional | Represents a postal address in a country.<br>For more information, see [Working with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses). | Address getAddress() |
| `PhoneNumber` | `String` | Optional | The phone number associated with the customer profile. The phone number must be valid and can contain<br>9–16 digits, with an optional `+` prefix and country code. For more information, see<br>[Customer phone numbers](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#phone-number). | String getPhoneNumber() |
| `ReferenceId` | `String` | Optional | An optional second ID used to associate the customer profile with an<br>entity in another system.<br><br>The maximum length for this value is 100 characters. | String getReferenceId() |
| `Note` | `String` | Optional | A custom note associated with the customer profile. | String getNote() |
| `Birthday` | `String` | Optional | The birthday associated with the customer profile, in `YYYY-MM-DD` or `MM-DD` format. For example,<br>specify `1998-09-21` for September 21, 1998, or `09-21` for September 21. Birthdays are returned in `YYYY-MM-DD`<br>format, where `YYYY` is the specified birth year or `0000` if a birth year is not specified. | String getBirthday() |
| `TaxIds` | [`CustomerTaxIds`](../../doc/models/customer-tax-ids.md) | Optional | Represents the tax ID associated with a [customer profile](../../doc/models/customer.md). The corresponding `tax_ids` field is available only for customers of sellers in EU countries or the United Kingdom.<br>For more information, see [Customer tax IDs](https://developer.squareup.com/docs/customers-api/what-it-does#customer-tax-ids). | CustomerTaxIds getTaxIds() |

## Example (as JSON)

```json
{
  "address": {
    "address_line_1": "500 Electric Ave",
    "address_line_2": "Suite 600",
    "administrative_district_level_1": "NY",
    "country": "US",
    "locality": "New York",
    "postal_code": "10003"
  },
  "email_address": "Amelia.Earhart@example.com",
  "family_name": "Earhart",
  "given_name": "Amelia",
  "note": "a customer",
  "phone_number": "+1-212-555-4240",
  "reference_id": "YOUR_REFERENCE_ID",
  "idempotency_key": "idempotency_key4",
  "company_name": "company_name4",
  "nickname": "nickname4"
}
```


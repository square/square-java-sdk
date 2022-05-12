
# Pre Populated Data

Describes buyer data to prepopulate in the payment form.
For more information,
see [Optional Checkout Configurations](https://developer.squareup.com/docs/checkout-api/optional-checkout-configurations).

## Structure

`PrePopulatedData`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `BuyerEmail` | `String` | Optional | The buyer email to prepopulate in the payment form.<br>**Constraints**: *Maximum Length*: `256` | String getBuyerEmail() |
| `BuyerPhoneNumber` | `String` | Optional | The buyer phone number to prepopulate in the payment form.<br>**Constraints**: *Maximum Length*: `17` | String getBuyerPhoneNumber() |
| `BuyerAddress` | [`Address`](../../doc/models/address.md) | Optional | Represents a postal address in a country.<br>For more information, see [Working with Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses). | Address getBuyerAddress() |

## Example (as JSON)

```json
{
  "buyer_email": null,
  "buyer_phone_number": null,
  "buyer_address": null
}
```



# Buy Now Pay Later Details

Additional details about a Buy Now Pay Later payment type.

## Structure

`BuyNowPayLaterDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Brand` | `String` | Optional | The brand used for the Buy Now Pay Later payment.<br>The brand can be `AFTERPAY` or `UNKNOWN`.<br>**Constraints**: *Maximum Length*: `50` | String getBrand() |
| `AfterpayDetails` | [`AfterpayDetails`](../../doc/models/afterpay-details.md) | Optional | Additional details about Afterpay payments. | AfterpayDetails getAfterpayDetails() |

## Example (as JSON)

```json
{
  "brand": "brand4",
  "afterpay_details": {
    "email_address": "email_address4"
  }
}
```


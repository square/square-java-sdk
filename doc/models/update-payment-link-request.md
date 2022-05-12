
# Update Payment Link Request

## Structure

`UpdatePaymentLinkRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `PaymentLink` | [`PaymentLink`](../../doc/models/payment-link.md) | Required | - | PaymentLink getPaymentLink() |

## Example (as JSON)

```json
{
  "payment_link": {
    "checkout_options": {
      "ask_for_shipping_address": true
    },
    "version": 1
  }
}
```


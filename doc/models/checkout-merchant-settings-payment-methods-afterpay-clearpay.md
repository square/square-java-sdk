
# Checkout Merchant Settings Payment Methods Afterpay Clearpay

The settings allowed for AfterpayClearpay.

## Structure

`CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `OrderEligibilityRange` | [`CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange`](../../doc/models/checkout-merchant-settings-payment-methods-afterpay-clearpay-eligibility-range.md) | Optional | A range of purchase price that qualifies. | CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange getOrderEligibilityRange() |
| `ItemEligibilityRange` | [`CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange`](../../doc/models/checkout-merchant-settings-payment-methods-afterpay-clearpay-eligibility-range.md) | Optional | A range of purchase price that qualifies. | CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange getItemEligibilityRange() |
| `Enabled` | `Boolean` | Optional | Indicates whether the payment method is enabled for the account. | Boolean getEnabled() |

## Example (as JSON)

```json
{
  "order_eligibility_range": {
    "min": {
      "amount": 34,
      "currency": "ISK"
    },
    "max": {
      "amount": 140,
      "currency": "OMR"
    }
  },
  "item_eligibility_range": {
    "min": {
      "amount": 34,
      "currency": "ISK"
    },
    "max": {
      "amount": 140,
      "currency": "OMR"
    }
  },
  "enabled": false
}
```


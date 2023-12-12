
# Checkout Merchant Settings Payment Methods

## Structure

`CheckoutMerchantSettingsPaymentMethods`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `ApplePay` | [`CheckoutMerchantSettingsPaymentMethodsPaymentMethod`](../../doc/models/checkout-merchant-settings-payment-methods-payment-method.md) | Optional | The settings allowed for a payment method. | CheckoutMerchantSettingsPaymentMethodsPaymentMethod getApplePay() |
| `GooglePay` | [`CheckoutMerchantSettingsPaymentMethodsPaymentMethod`](../../doc/models/checkout-merchant-settings-payment-methods-payment-method.md) | Optional | The settings allowed for a payment method. | CheckoutMerchantSettingsPaymentMethodsPaymentMethod getGooglePay() |
| `CashApp` | [`CheckoutMerchantSettingsPaymentMethodsPaymentMethod`](../../doc/models/checkout-merchant-settings-payment-methods-payment-method.md) | Optional | The settings allowed for a payment method. | CheckoutMerchantSettingsPaymentMethodsPaymentMethod getCashApp() |
| `AfterpayClearpay` | [`CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay`](../../doc/models/checkout-merchant-settings-payment-methods-afterpay-clearpay.md) | Optional | The settings allowed for AfterpayClearpay. | CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay getAfterpayClearpay() |

## Example (as JSON)

```json
{
  "apple_pay": {
    "enabled": false
  },
  "google_pay": {
    "enabled": false
  },
  "cash_app": {
    "enabled": false
  },
  "afterpay_clearpay": {
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
}
```


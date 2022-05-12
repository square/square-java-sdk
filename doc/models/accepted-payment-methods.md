
# Accepted Payment Methods

## Structure

`AcceptedPaymentMethods`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `ApplePay` | `Boolean` | Optional | Whether Apple Pay is accepted at checkout | Boolean getApplePay() |
| `GooglePay` | `Boolean` | Optional | Whether Google Pay is accepted at checkout | Boolean getGooglePay() |
| `CashAppPay` | `Boolean` | Optional | Whether Cash App Pay is accepted at checkout | Boolean getCashAppPay() |
| `AfterpayClearpay` | `Boolean` | Optional | Whether Afterpay/Clearpay is accepted at checkout | Boolean getAfterpayClearpay() |

## Example (as JSON)

```json
{
  "apple_pay": null,
  "google_pay": null,
  "cash_app_pay": null,
  "afterpay_clearpay": null
}
```



# Cancel Terminal Checkout Response

## Structure

`CancelTerminalCheckoutResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Information about errors encountered during the request. | List<Error> getErrors() |
| `Checkout` | [`TerminalCheckout`](/doc/models/terminal-checkout.md) | Optional | - | TerminalCheckout getCheckout() |

## Example (as JSON)

```json
{
  "checkout": {
    "amount_money": {
      "amount": 123,
      "currency": "USD"
    },
    "app_id": "APP_ID",
    "cancel_reason": "SELLER_CANCELED",
    "created_at": "2020-03-16T15:31:19.934Z",
    "deadline_duration": "PT10M",
    "device_options": {
      "device_id": "dbb5d83a-7838-11ea-bc55-0242ac130003",
      "skip_receipt_screen": true,
      "tip_settings": {
        "allow_tipping": true
      }
    },
    "id": "S1yDlPQx7slqO",
    "reference_id": "id36815",
    "status": "CANCELED",
    "updated_at": "2020-03-16T15:31:45.787Z"
  }
}
```


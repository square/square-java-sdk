
# Terminal Device Checkout Options

## Structure

`TerminalDeviceCheckoutOptions`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `SkipReceiptScreen` | `Boolean` | Optional | Instructs the device to skip the receipt screen. Defaults to false. | Boolean getSkipReceiptScreen() |
| `TipSettings` | [`TipSettings`](/doc/models/tip-settings.md) | Optional | - | TipSettings getTipSettings() |

## Example (as JSON)

```json
{
  "skip_receipt_screen": false,
  "tip_settings": {
    "allow_tipping": false,
    "separate_tip_screen": false,
    "custom_tip_field": false,
    "tip_percentages": [
      48
    ],
    "smart_tipping": false
  }
}
```



# Device Checkout Options

## Structure

`DeviceCheckoutOptions`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `DeviceId` | `String` | Required | The unique ID of the device intended for this `TerminalCheckout`.<br>A list of `DeviceCode` objects can be retrieved from the /v2/devices/codes endpoint.<br>Match a `DeviceCode.device_id` value with `device_id` to get the associated device code. | String getDeviceId() |
| `SkipReceiptScreen` | `Boolean` | Optional | Instructs the device to skip the receipt screen. Defaults to false. | Boolean getSkipReceiptScreen() |
| `CollectSignature` | `Boolean` | Optional | Indicates that signature collection is desired during checkout. Defaults to false. | Boolean getCollectSignature() |
| `TipSettings` | [`TipSettings`](../../doc/models/tip-settings.md) | Optional | - | TipSettings getTipSettings() |
| `ShowItemizedCart` | `Boolean` | Optional | Show the itemization screen prior to taking a payment. This field is only meaningful when the<br>checkout includes an order ID. Defaults to true. | Boolean getShowItemizedCart() |

## Example (as JSON)

```json
{
  "device_id": "device_id6",
  "skip_receipt_screen": null,
  "collect_signature": null,
  "tip_settings": null,
  "show_itemized_cart": null
}
```


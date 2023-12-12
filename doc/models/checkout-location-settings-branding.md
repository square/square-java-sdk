
# Checkout Location Settings Branding

## Structure

`CheckoutLocationSettingsBranding`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `HeaderType` | [`String`](../../doc/models/checkout-location-settings-branding-header-type.md) | Optional | - | String getHeaderType() |
| `ButtonColor` | `String` | Optional | The HTML-supported hex color for the button on the checkout page (for example, "#FFFFFF").<br>**Constraints**: *Minimum Length*: `7`, *Maximum Length*: `7` | String getButtonColor() |
| `ButtonShape` | [`String`](../../doc/models/checkout-location-settings-branding-button-shape.md) | Optional | - | String getButtonShape() |

## Example (as JSON)

```json
{
  "header_type": "FULL_WIDTH_LOGO",
  "button_color": "button_color2",
  "button_shape": "ROUNDED"
}
```


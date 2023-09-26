
# Device Component Details Battery Details

## Structure

`DeviceComponentDetailsBatteryDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `VisiblePercent` | `Integer` | Optional | The battery charge percentage as displayed on the device. | Integer getVisiblePercent() |
| `ExternalPower` | [`String`](../../doc/models/device-component-details-external-power.md) | Optional | An enum for ExternalPower. | String getExternalPower() |

## Example (as JSON)

```json
{
  "visible_percent": 48,
  "external_power": "AVAILABLE_CHARGING"
}
```


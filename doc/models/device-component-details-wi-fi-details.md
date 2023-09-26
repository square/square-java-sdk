
# Device Component Details Wi Fi Details

## Structure

`DeviceComponentDetailsWiFiDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Active` | `Boolean` | Optional | A boolean to represent whether the WiFI interface is currently active. | Boolean getActive() |
| `Ssid` | `String` | Optional | The name of the connected WIFI network. | String getSsid() |
| `IpAddressV4` | `String` | Optional | The string representation of the device’s IPv4 address. | String getIpAddressV4() |
| `SecureConnection` | `String` | Optional | The security protocol for a secure connection (e.g. WPA2). None provided if the connection<br>is unsecured. | String getSecureConnection() |
| `SignalStrength` | [`DeviceComponentDetailsMeasurement`](../../doc/models/device-component-details-measurement.md) | Optional | A value qualified by unit of measure. | DeviceComponentDetailsMeasurement getSignalStrength() |

## Example (as JSON)

```json
{
  "active": false,
  "ssid": "ssid6",
  "ip_address_v4": "ip_address_v40",
  "secure_connection": "secure_connection6",
  "signal_strength": {
    "value": 222
  }
}
```


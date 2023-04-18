
# Device Metadata

## Structure

`DeviceMetadata`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `BatteryPercentage` | `String` | Optional | The Terminal’s remaining battery percentage, between 1-100. | String getBatteryPercentage() |
| `ChargingState` | `String` | Optional | The current charging state of the Terminal.<br>Options: `CHARGING`, `NOT_CHARGING` | String getChargingState() |
| `LocationId` | `String` | Optional | The ID of the Square seller business location associated with the Terminal. | String getLocationId() |
| `MerchantId` | `String` | Optional | The ID of the Square merchant account that is currently signed-in to the Terminal. | String getMerchantId() |
| `NetworkConnectionType` | `String` | Optional | The Terminal’s current network connection type.<br>Options: `WIFI`, `ETHERNET` | String getNetworkConnectionType() |
| `PaymentRegion` | `String` | Optional | The country in which the Terminal is authorized to take payments. | String getPaymentRegion() |
| `SerialNumber` | `String` | Optional | The unique identifier assigned to the Terminal, which can be found on the lower back<br>of the device. | String getSerialNumber() |
| `OsVersion` | `String` | Optional | The current version of the Terminal’s operating system. | String getOsVersion() |
| `AppVersion` | `String` | Optional | The current version of the application running on the Terminal. | String getAppVersion() |
| `WifiNetworkName` | `String` | Optional | The name of the Wi-Fi network to which the Terminal is connected. | String getWifiNetworkName() |
| `WifiNetworkStrength` | `String` | Optional | The signal strength of the Wi-FI network connection.<br>Options: `POOR`, `FAIR`, `GOOD`, `EXCELLENT` | String getWifiNetworkStrength() |
| `IpAddress` | `String` | Optional | The IP address of the Terminal. | String getIpAddress() |

## Example (as JSON)

```json
{
  "battery_percentage": "battery_percentage6",
  "charging_state": "charging_state2",
  "location_id": "location_id4",
  "merchant_id": "merchant_id0",
  "network_connection_type": "network_connection_type0",
  "payment_region": "payment_region8",
  "serial_number": "serial_number6",
  "os_version": "os_version8",
  "app_version": "app_version0",
  "wifi_network_name": "wifi_network_name4",
  "wifi_network_strength": "wifi_network_strength0",
  "ip_address": "ip_address0"
}
```


## Device Details

Details about the device that took the payment.

### Structure

`DeviceDetails`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `DeviceId` | `String` | Optional | Square-issued ID of the device. | String getDeviceId() |
| `DeviceName` | `String` | Optional | The name of the device set by the merchant. | String getDeviceName() |

### Example (as JSON)

```json
{
  "device_id": "device_id6",
  "device_name": "device_name2"
}
```


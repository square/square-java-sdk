
# Device Component Details Application Details

## Structure

`DeviceComponentDetailsApplicationDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `ApplicationType` | [`String`](../../doc/models/application-type.md) | Optional | - | String getApplicationType() |
| `Version` | `String` | Optional | The version of the application. | String getVersion() |
| `SessionLocation` | `String` | Optional | The location_id of the session for the application. | String getSessionLocation() |
| `DeviceCodeId` | `String` | Optional | The id of the device code that was used to log in to the device. | String getDeviceCodeId() |

## Example (as JSON)

```json
{
  "application_type": "TERMINAL_API",
  "version": "version4",
  "session_location": "session_location0",
  "device_code_id": "device_code_id2"
}
```


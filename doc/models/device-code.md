
# Device Code

## Structure

`DeviceCode`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The unique id for this device code. | String getId() |
| `Name` | `String` | Optional | An optional user-defined name for the device code.<br>**Constraints**: *Maximum Length*: `128` | String getName() |
| `Code` | `String` | Optional | The unique code that can be used to login. | String getCode() |
| `DeviceId` | `String` | Optional | The unique id of the device that used this code. Populated when the device is paired up. | String getDeviceId() |
| `ProductType` | `String` | Required, Constant | **Default**: `"TERMINAL_API"`<br>*Default: `"TERMINAL_API"`* | String getProductType() |
| `LocationId` | `String` | Optional | The location assigned to this code.<br>**Constraints**: *Maximum Length*: `50` | String getLocationId() |
| `Status` | [`String`](/doc/models/device-code-status.md) | Optional | DeviceCode.Status enum. | String getStatus() |
| `PairBy` | `String` | Optional | When this DeviceCode will expire and no longer login. Timestamp in RFC 3339 format. | String getPairBy() |
| `CreatedAt` | `String` | Optional | When this DeviceCode was created. Timestamp in RFC 3339 format. | String getCreatedAt() |
| `StatusChangedAt` | `String` | Optional | When this DeviceCode's status was last changed. Timestamp in RFC 3339 format. | String getStatusChangedAt() |
| `PairedAt` | `String` | Optional | When this DeviceCode was paired. Timestamp in RFC 3339 format. | String getPairedAt() |

## Example (as JSON)

```json
{
  "id": null,
  "name": null,
  "code": null,
  "device_id": null,
  "product_type": "TERMINAL_API",
  "location_id": null,
  "status": null,
  "pair_by": null,
  "created_at": null,
  "status_changed_at": null,
  "paired_at": null
}
```


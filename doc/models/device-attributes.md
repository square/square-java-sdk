
# Device Attributes

## Structure

`DeviceAttributes`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Type` | `String` | Required, Constant | An enum identifier of the device type.<br>**Default**: `"TERMINAL"` | String getType() |
| `Manufacturer` | `String` | Required | The maker of the device. | String getManufacturer() |
| `Model` | `String` | Optional | The specific model of the device. | String getModel() |
| `Name` | `String` | Optional | A seller-specified name for the device. | String getName() |
| `ManufacturersId` | `String` | Optional | The manufacturer-supplied identifier for the device (where available). In many cases,<br>this identifier will be a serial number. | String getManufacturersId() |
| `UpdatedAt` | `String` | Optional | The RFC 3339-formatted value of the most recent update to the device information.<br>(Could represent any field update on the device.) | String getUpdatedAt() |
| `Version` | `String` | Optional | The current version of software installed on the device. | String getVersion() |
| `MerchantToken` | `String` | Optional | The merchant_token identifying the merchant controlling the device. | String getMerchantToken() |

## Example (as JSON)

```json
{
  "type": "TERMINAL",
  "manufacturer": "manufacturer0",
  "model": "model4",
  "name": "name6",
  "manufacturers_id": "manufacturers_id2",
  "updated_at": "updated_at2",
  "version": "version2"
}
```


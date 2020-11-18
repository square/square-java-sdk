
# Terminal Checkout Query Filter

## Structure

`TerminalCheckoutQueryFilter`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `DeviceId` | `String` | Optional | `TerminalCheckout`s associated with a specific device. If no device is specified then all<br>`TerminalCheckout`s for the merchant will be displayed. | String getDeviceId() |
| `CreatedAt` | [`TimeRange`](/doc/models/time-range.md) | Optional | Represents a generic time range. The start and end values are<br>represented in RFC 3339 format. Time ranges are customized to be<br>inclusive or exclusive based on the needs of a particular endpoint.<br>Refer to the relevant endpoint-specific documentation to determine<br>how time ranges are handled. | TimeRange getCreatedAt() |
| `Status` | `String` | Optional | Filtered results with the desired status of the `TerminalCheckout`<br>Options: PENDING, IN_PROGRESS, CANCELED, COMPLETED | String getStatus() |

## Example (as JSON)

```json
{
  "device_id": "device_id6",
  "created_at": {
    "start_at": "start_at4",
    "end_at": "end_at8"
  },
  "status": "status8"
}
```


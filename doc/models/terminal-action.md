
# Terminal Action

Represents an action processed by the Square Terminal.

## Structure

`TerminalAction`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique ID for this `TerminalAction`.<br>**Constraints**: *Minimum Length*: `10`, *Maximum Length*: `255` | String getId() |
| `DeviceId` | `String` | Optional | The unique Id of the device intended for this `TerminalAction`.<br>The Id can be retrieved from /v2/devices api. | String getDeviceId() |
| `DeadlineDuration` | `String` | Optional | The duration as an RFC 3339 duration, after which the action will be automatically canceled.<br>TerminalActions that are `PENDING` will be automatically `CANCELED` and have a cancellation reason<br>of `TIMED_OUT`<br><br>Default: 5 minutes from creation<br><br>Maximum: 5 minutes | String getDeadlineDuration() |
| `Status` | `String` | Optional | The status of the `TerminalAction`.<br>Options: `PENDING`, `IN_PROGRESS`, `CANCEL_REQUESTED`, `CANCELED`, `COMPLETED` | String getStatus() |
| `CancelReason` | [`String`](../../doc/models/action-cancel-reason.md) | Optional | - | String getCancelReason() |
| `CreatedAt` | `String` | Optional | The time when the `TerminalAction` was created as an RFC 3339 timestamp. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The time when the `TerminalAction` was last updated as an RFC 3339 timestamp. | String getUpdatedAt() |
| `AppId` | `String` | Optional | The ID of the application that created the action. | String getAppId() |
| `Type` | [`String`](../../doc/models/terminal-action-action-type.md) | Optional | Describes the type of this unit and indicates which field contains the unit information. This is an ‘open’ enum. | String getType() |
| `SaveCardOptions` | [`SaveCardOptions`](../../doc/models/save-card-options.md) | Optional | Describes save-card action fields. | SaveCardOptions getSaveCardOptions() |
| `DeviceMetadata` | [`DeviceMetadata`](../../doc/models/device-metadata.md) | Optional | - | DeviceMetadata getDeviceMetadata() |

## Example (as JSON)

```json
{
  "device_id": null,
  "deadline_duration": null,
  "cancel_reason": null,
  "type": null,
  "save_card_options": null,
  "device_metadata": null
}
```


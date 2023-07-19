
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
| `LocationId` | `String` | Optional | The location id the action is attached to, if a link can be made.<br>**Constraints**: *Maximum Length*: `64` | String getLocationId() |
| `Type` | [`String`](../../doc/models/terminal-action-action-type.md) | Optional | Describes the type of this unit and indicates which field contains the unit information. This is an ‘open’ enum. | String getType() |
| `QrCodeOptions` | [`QrCodeOptions`](../../doc/models/qr-code-options.md) | Optional | Fields to describe the action that displays QR-Codes. | QrCodeOptions getQrCodeOptions() |
| `SaveCardOptions` | [`SaveCardOptions`](../../doc/models/save-card-options.md) | Optional | Describes save-card action fields. | SaveCardOptions getSaveCardOptions() |
| `SignatureOptions` | [`SignatureOptions`](../../doc/models/signature-options.md) | Optional | - | SignatureOptions getSignatureOptions() |
| `ConfirmationOptions` | [`ConfirmationOptions`](../../doc/models/confirmation-options.md) | Optional | - | ConfirmationOptions getConfirmationOptions() |
| `ReceiptOptions` | [`ReceiptOptions`](../../doc/models/receipt-options.md) | Optional | Describes receipt action fields. | ReceiptOptions getReceiptOptions() |
| `DataCollectionOptions` | [`DataCollectionOptions`](../../doc/models/data-collection-options.md) | Optional | - | DataCollectionOptions getDataCollectionOptions() |
| `SelectOptions` | [`SelectOptions`](../../doc/models/select-options.md) | Optional | - | SelectOptions getSelectOptions() |
| `DeviceMetadata` | [`DeviceMetadata`](../../doc/models/device-metadata.md) | Optional | - | DeviceMetadata getDeviceMetadata() |
| `AwaitNextAction` | `Boolean` | Optional | Indicates the action will be linked to another action and requires a waiting dialog to be<br>displayed instead of returning to the idle screen on completion of the action.<br><br>Only supported on SIGNATURE, CONFIRMATION, DATA_COLLECTION, and SELECT types. | Boolean getAwaitNextAction() |
| `AwaitNextActionDuration` | `String` | Optional | The timeout duration of the waiting dialog as an RFC 3339 duration, after which the<br>waiting dialog will no longer be displayed and the Terminal will return to the idle screen.<br><br>Default: 5 minutes from when the waiting dialog is displayed<br><br>Maximum: 5 minutes | String getAwaitNextActionDuration() |

## Example (as JSON)

```json
{
  "id": "id0",
  "device_id": "device_id6",
  "deadline_duration": "deadline_duration8",
  "status": "status8",
  "cancel_reason": "SELLER_CANCELED"
}
```


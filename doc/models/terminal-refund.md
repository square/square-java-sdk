
# Terminal Refund

Represents a payment refund processed by the Square Terminal. Only supports Interac (Canadian debit network) payment refunds.

## Structure

`TerminalRefund`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | A unique ID for this `TerminalRefund`.<br>**Constraints**: *Minimum Length*: `10`, *Maximum Length*: `255` | String getId() |
| `RefundId` | `String` | Optional | The reference to the payment refund created by completing this `TerminalRefund`. | String getRefundId() |
| `PaymentId` | `String` | Required | The unique ID of the payment being refunded.<br>**Constraints**: *Minimum Length*: `1` | String getPaymentId() |
| `OrderId` | `String` | Optional | The reference to the Square order ID for the payment identified by the `payment_id`. | String getOrderId() |
| `AmountMoney` | [`Money`](../../doc/models/money.md) | Required | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmountMoney() |
| `Reason` | `String` | Required | A description of the reason for the refund.<br>**Constraints**: *Maximum Length*: `192` | String getReason() |
| `DeviceId` | `String` | Required | The unique ID of the device intended for this `TerminalRefund`.<br>The Id can be retrieved from /v2/devices api. | String getDeviceId() |
| `DeadlineDuration` | `String` | Optional | The RFC 3339 duration, after which the refund is automatically canceled.<br>A `TerminalRefund` that is `PENDING` is automatically `CANCELED` and has a cancellation reason<br>of `TIMED_OUT`.<br><br>Default: 5 minutes from creation.<br><br>Maximum: 5 minutes | String getDeadlineDuration() |
| `Status` | `String` | Optional | The status of the `TerminalRefund`.<br>Options: `PENDING`, `IN_PROGRESS`, `CANCEL_REQUESTED`, `CANCELED`, or `COMPLETED`. | String getStatus() |
| `CancelReason` | [`String`](../../doc/models/action-cancel-reason.md) | Optional | - | String getCancelReason() |
| `CreatedAt` | `String` | Optional | The time when the `TerminalRefund` was created, as an RFC 3339 timestamp. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The time when the `TerminalRefund` was last updated, as an RFC 3339 timestamp. | String getUpdatedAt() |
| `AppId` | `String` | Optional | The ID of the application that created the refund. | String getAppId() |
| `LocationId` | `String` | Optional | The location of the device where the `TerminalRefund` was directed.<br>**Constraints**: *Maximum Length*: `64` | String getLocationId() |

## Example (as JSON)

```json
{
  "id": "id8",
  "refund_id": "refund_id2",
  "payment_id": "payment_id8",
  "order_id": "order_id2",
  "amount_money": {
    "amount": 186,
    "currency": "AUD"
  },
  "reason": "reason6",
  "device_id": "device_id4",
  "deadline_duration": "deadline_duration0",
  "status": "status0"
}
```


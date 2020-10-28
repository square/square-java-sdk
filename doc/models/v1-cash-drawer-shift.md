
# V1 Cash Drawer Shift

Contains details for a single cash drawer shift.

## Structure

`V1CashDrawerShift`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The shift's unique ID. | String getId() |
| `EventType` | [`String`](/doc/models/v1-cash-drawer-shift-event-type.md) | Optional | - | String getEventType() |
| `OpenedAt` | `String` | Optional | The time when the shift began, in ISO 8601 format. | String getOpenedAt() |
| `EndedAt` | `String` | Optional | The time when the shift ended, in ISO 8601 format. | String getEndedAt() |
| `ClosedAt` | `String` | Optional | The time when the shift was closed, in ISO 8601 format. | String getClosedAt() |
| `EmployeeIds` | `List<String>` | Optional | The IDs of all employees that were logged into Square Register at some point during the cash drawer shift. | List<String> getEmployeeIds() |
| `OpeningEmployeeId` | `String` | Optional | The ID of the employee that started the cash drawer shift. | String getOpeningEmployeeId() |
| `EndingEmployeeId` | `String` | Optional | The ID of the employee that ended the cash drawer shift. | String getEndingEmployeeId() |
| `ClosingEmployeeId` | `String` | Optional | The ID of the employee that closed the cash drawer shift by auditing the cash drawer's contents. | String getClosingEmployeeId() |
| `Description` | `String` | Optional | A description of the cash drawer shift. | String getDescription() |
| `StartingCashMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getStartingCashMoney() |
| `CashPaymentMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getCashPaymentMoney() |
| `CashRefundsMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getCashRefundsMoney() |
| `CashPaidInMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getCashPaidInMoney() |
| `CashPaidOutMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getCashPaidOutMoney() |
| `ExpectedCashMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getExpectedCashMoney() |
| `ClosedCashMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - | V1Money getClosedCashMoney() |
| `Device` | [`Device`](/doc/models/device.md) | Optional | - | Device getDevice() |
| `Events` | [`List<V1CashDrawerEvent>`](/doc/models/v1-cash-drawer-event.md) | Optional | All of the events (payments, refunds, and so on) that involved the cash drawer during the shift. | List<V1CashDrawerEvent> getEvents() |

## Example (as JSON)

```json
{
  "id": "id0",
  "event_type": "ENDED",
  "opened_at": "opened_at8",
  "ended_at": "ended_at2",
  "closed_at": "closed_at2"
}
```


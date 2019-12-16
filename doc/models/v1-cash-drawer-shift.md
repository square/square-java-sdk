## V1 Cash Drawer Shift

Contains details for a single cash drawer shift.

### Structure

`V1CashDrawerShift`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Id` | `String` | Optional | The shift's unique ID. |
| `EventType` | [`String`](/doc/models/v1-cash-drawer-shift-event-type.md) | Optional | - |
| `OpenedAt` | `String` | Optional | The time when the shift began, in ISO 8601 format. |
| `EndedAt` | `String` | Optional | The time when the shift ended, in ISO 8601 format. |
| `ClosedAt` | `String` | Optional | The time when the shift was closed, in ISO 8601 format. |
| `EmployeeIds` | `List<String>` | Optional | The IDs of all employees that were logged into Square Register at some point during the cash drawer shift. |
| `OpeningEmployeeId` | `String` | Optional | The ID of the employee that started the cash drawer shift. |
| `EndingEmployeeId` | `String` | Optional | The ID of the employee that ended the cash drawer shift. |
| `ClosingEmployeeId` | `String` | Optional | The ID of the employee that closed the cash drawer shift by auditing the cash drawer's contents. |
| `Description` | `String` | Optional | A description of the cash drawer shift. |
| `StartingCashMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `CashPaymentMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `CashRefundsMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `CashPaidInMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `CashPaidOutMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `ExpectedCashMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `ClosedCashMoney` | [`V1Money`](/doc/models/v1-money.md) | Optional | - |
| `Device` | [`Device`](/doc/models/device.md) | Optional | - |
| `Events` | [`List<V1CashDrawerEvent>`](/doc/models/v1-cash-drawer-event.md) | Optional | All of the events (payments, refunds, and so on) that involved the cash drawer during the shift. |

### Example (as JSON)

```json
{
  "id": null,
  "event_type": null,
  "opened_at": null,
  "ended_at": null,
  "closed_at": null,
  "employee_ids": null,
  "opening_employee_id": null,
  "ending_employee_id": null,
  "closing_employee_id": null,
  "description": null,
  "starting_cash_money": null,
  "cash_payment_money": null,
  "cash_refunds_money": null,
  "cash_paid_in_money": null,
  "cash_paid_out_money": null,
  "expected_cash_money": null,
  "closed_cash_money": null,
  "device": null,
  "events": null
}
```


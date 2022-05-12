
# Cash Drawer Shift

This model gives the details of a cash drawer shift.
The cash_payment_money, cash_refund_money, cash_paid_in_money,
and cash_paid_out_money fields are all computed by summing their respective
event types.

## Structure

`CashDrawerShift`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The shift unique ID. | String getId() |
| `State` | [`String`](../../doc/models/cash-drawer-shift-state.md) | Optional | The current state of a cash drawer shift. | String getState() |
| `OpenedAt` | `String` | Optional | The time when the shift began, in ISO 8601 format. | String getOpenedAt() |
| `EndedAt` | `String` | Optional | The time when the shift ended, in ISO 8601 format. | String getEndedAt() |
| `ClosedAt` | `String` | Optional | The time when the shift was closed, in ISO 8601 format. | String getClosedAt() |
| `EmployeeIds` | `List<String>` | Optional | The IDs of all employees that were logged into Square Point of Sale at any<br>point while the cash drawer shift was open. | List<String> getEmployeeIds() |
| `OpeningEmployeeId` | `String` | Optional | The ID of the employee that started the cash drawer shift. | String getOpeningEmployeeId() |
| `EndingEmployeeId` | `String` | Optional | The ID of the employee that ended the cash drawer shift. | String getEndingEmployeeId() |
| `ClosingEmployeeId` | `String` | Optional | The ID of the employee that closed the cash drawer shift by auditing<br>the cash drawer contents. | String getClosingEmployeeId() |
| `Description` | `String` | Optional | The free-form text description of a cash drawer by an employee. | String getDescription() |
| `OpenedCashMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getOpenedCashMoney() |
| `CashPaymentMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getCashPaymentMoney() |
| `CashRefundsMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getCashRefundsMoney() |
| `CashPaidInMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getCashPaidInMoney() |
| `CashPaidOutMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getCashPaidOutMoney() |
| `ExpectedCashMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getExpectedCashMoney() |
| `ClosedCashMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getClosedCashMoney() |
| `Device` | [`CashDrawerDevice`](../../doc/models/cash-drawer-device.md) | Optional | - | CashDrawerDevice getDevice() |

## Example (as JSON)

```json
{
  "id": null,
  "state": null,
  "opened_at": null,
  "ended_at": null,
  "closed_at": null,
  "employee_ids": null,
  "opening_employee_id": null,
  "ending_employee_id": null,
  "closing_employee_id": null,
  "description": null,
  "opened_cash_money": null,
  "cash_payment_money": null,
  "cash_refunds_money": null,
  "cash_paid_in_money": null,
  "cash_paid_out_money": null,
  "expected_cash_money": null,
  "closed_cash_money": null,
  "device": null
}
```


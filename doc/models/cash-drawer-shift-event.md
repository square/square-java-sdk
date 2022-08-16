
# Cash Drawer Shift Event

## Structure

`CashDrawerShiftEvent`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The unique ID of the event. | String getId() |
| `EmployeeId` | `String` | Optional | The ID of the employee that created the event. | String getEmployeeId() |
| `EventType` | [`String`](../../doc/models/cash-drawer-event-type.md) | Optional | The types of events on a CashDrawerShift.<br>Each event type represents an employee action on the actual cash drawer<br>represented by a CashDrawerShift. | String getEventType() |
| `EventMoney` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getEventMoney() |
| `CreatedAt` | `String` | Optional | The event time in ISO 8601 format. | String getCreatedAt() |
| `Description` | `String` | Optional | An optional description of the event, entered by the employee that<br>created the event. | String getDescription() |

## Example (as JSON)

```json
{
  "id": null,
  "employee_id": null,
  "event_type": null,
  "event_money": null,
  "description": null
}
```


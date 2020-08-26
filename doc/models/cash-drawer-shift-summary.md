## Cash Drawer Shift Summary

The summary of a closed cash drawer shift.
This model contains only the money counted to start a cash drawer shift, counted
at the end of the shift, and the amount that should be in the drawer at shift
end based on summing all cash drawer shift events.

### Structure

`CashDrawerShiftSummary`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The shift unique ID. | String getId() |
| `State` | [`String`](/doc/models/cash-drawer-shift-state.md) | Optional | The current state of a cash drawer shift. | String getState() |
| `OpenedAt` | `String` | Optional | The shift start time in ISO 8601 format. | String getOpenedAt() |
| `EndedAt` | `String` | Optional | The shift end time in ISO 8601 format. | String getEndedAt() |
| `ClosedAt` | `String` | Optional | The shift close time in ISO 8601 format. | String getClosedAt() |
| `Description` | `String` | Optional | An employee free-text description of a cash drawer shift. | String getDescription() |
| `OpenedCashMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getOpenedCashMoney() |
| `ExpectedCashMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getExpectedCashMoney() |
| `ClosedCashMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getClosedCashMoney() |

### Example (as JSON)

```json
{
  "id": "id0",
  "state": "CLOSED",
  "opened_at": "opened_at8",
  "ended_at": "ended_at2",
  "closed_at": "closed_at2"
}
```


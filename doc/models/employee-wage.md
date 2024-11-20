
# Employee Wage

The hourly wage rate that an employee earns on a `Shift` for doing the job specified by the `title` property of this object. Deprecated at version 2020-08-26. Use [TeamMemberWage](entity:TeamMemberWage).

## Structure

`EmployeeWage`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The UUID for this object. | String getId() |
| `EmployeeId` | `String` | Optional | The `Employee` that this wage is assigned to. | String getEmployeeId() |
| `Title` | `String` | Optional | The job title that this wage relates to. | String getTitle() |
| `HourlyRate` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getHourlyRate() |

## Example (as JSON)

```json
{
  "id": "id0",
  "employee_id": "employee_id0",
  "title": "title6",
  "hourly_rate": {
    "amount": 172,
    "currency": "LAK"
  }
}
```


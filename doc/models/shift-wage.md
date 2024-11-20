
# Shift Wage

The hourly wage rate used to compensate an employee for this shift.

## Structure

`ShiftWage`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Title` | `String` | Optional | The name of the job performed during this shift. | String getTitle() |
| `HourlyRate` | [`Money`](../../doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getHourlyRate() |
| `JobId` | `String` | Optional | The id of the job performed during this shift. Square<br>labor-reporting UIs might group shifts together by id. This cannot be used to retrieve the job. | String getJobId() |
| `TipEligible` | `Boolean` | Optional | Whether team members are eligible for tips when working this job. | Boolean getTipEligible() |

## Example (as JSON)

```json
{
  "title": "title6",
  "hourly_rate": {
    "amount": 172,
    "currency": "LAK"
  },
  "job_id": "job_id2",
  "tip_eligible": false
}
```


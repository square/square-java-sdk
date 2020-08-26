## V1 List Timecards Request

### Structure

`V1ListTimecardsRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Order` | [`String`](/doc/models/sort-order.md) | Optional | The order (e.g., chronological or alphabetical) in which results from a request are returned. | String getOrder() |
| `EmployeeId` | `String` | Optional | If provided, the endpoint returns only timecards for the employee with the specified ID. | String getEmployeeId() |
| `BeginClockinTime` | `String` | Optional | If filtering results by their clockin_time field, the beginning of the requested reporting period, in ISO 8601 format. | String getBeginClockinTime() |
| `EndClockinTime` | `String` | Optional | If filtering results by their clockin_time field, the end of the requested reporting period, in ISO 8601 format. | String getEndClockinTime() |
| `BeginClockoutTime` | `String` | Optional | If filtering results by their clockout_time field, the beginning of the requested reporting period, in ISO 8601 format. | String getBeginClockoutTime() |
| `EndClockoutTime` | `String` | Optional | If filtering results by their clockout_time field, the end of the requested reporting period, in ISO 8601 format. | String getEndClockoutTime() |
| `BeginUpdatedAt` | `String` | Optional | If filtering results by their updated_at field, the beginning of the requested reporting period, in ISO 8601 format. | String getBeginUpdatedAt() |
| `EndUpdatedAt` | `String` | Optional | If filtering results by their updated_at field, the end of the requested reporting period, in ISO 8601 format. | String getEndUpdatedAt() |
| `Deleted` | `Boolean` | Optional | If true, only deleted timecards are returned. If false, only valid timecards are returned.If you don't provide this parameter, both valid and deleted timecards are returned. | Boolean getDeleted() |
| `Limit` | `Integer` | Optional | The maximum integer number of employee entities to return in a single response. Default 100, maximum 200. | Integer getLimit() |
| `BatchToken` | `String` | Optional | A pagination cursor to retrieve the next set of results for your<br>original query to the endpoint. | String getBatchToken() |

### Example (as JSON)

```json
{
  "order": "DESC",
  "employee_id": "employee_id0",
  "begin_clockin_time": "begin_clockin_time8",
  "end_clockin_time": "end_clockin_time2",
  "begin_clockout_time": "begin_clockout_time0"
}
```


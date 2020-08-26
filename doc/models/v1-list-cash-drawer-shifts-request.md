## V1 List Cash Drawer Shifts Request

### Structure

`V1ListCashDrawerShiftsRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Order` | [`String`](/doc/models/sort-order.md) | Optional | The order (e.g., chronological or alphabetical) in which results from a request are returned. | String getOrder() |
| `BeginTime` | `String` | Optional | The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time minus 90 days. | String getBeginTime() |
| `EndTime` | `String` | Optional | The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time. | String getEndTime() |

### Example (as JSON)

```json
{
  "order": "DESC",
  "begin_time": "begin_time2",
  "end_time": "end_time2"
}
```


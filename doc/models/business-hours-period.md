
# Business Hours Period

Represents a period of time during which a business location is open.

## Structure

`BusinessHoursPeriod`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `DayOfWeek` | [`String`](/doc/models/day-of-week.md) | Optional | Indicates the specific day  of the week. | String getDayOfWeek() |
| `StartLocalTime` | `String` | Optional | The start time of a business hours period, specified in local time using partial-time<br>RFC 3339 format. | String getStartLocalTime() |
| `EndLocalTime` | `String` | Optional | The end time of a business hours period, specified in local time using partial-time<br>RFC 3339 format. | String getEndLocalTime() |

## Example (as JSON)

```json
{
  "day_of_week": "SAT",
  "start_local_time": "start_local_time6",
  "end_local_time": "end_local_time8"
}
```


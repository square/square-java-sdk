
# Workweek Config

Sets the day of the week and hour of the day that a business starts a
workweek. This is used to calculate overtime pay.

## Structure

`WorkweekConfig`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The UUID for this object. | String getId() |
| `StartOfWeek` | [`String`](../../doc/models/weekday.md) | Required | The days of the week. | String getStartOfWeek() |
| `StartOfDayLocalTime` | `String` | Required | The local time at which a business week starts. Represented as a<br>string in `HH:MM` format (`HH:MM:SS` is also accepted, but seconds are<br>truncated).<br>**Constraints**: *Minimum Length*: `1` | String getStartOfDayLocalTime() |
| `Version` | `Integer` | Optional | Used for resolving concurrency issues. The request fails if the version<br>provided does not match the server version at the time of the request. If not provided,<br>Square executes a blind write; potentially overwriting data from another<br>write. | Integer getVersion() |
| `CreatedAt` | `String` | Optional | A read-only timestamp in RFC 3339 format; presented in UTC. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | A read-only timestamp in RFC 3339 format; presented in UTC. | String getUpdatedAt() |

## Example (as JSON)

```json
{
  "id": null,
  "start_of_week": "MON",
  "start_of_day_local_time": "start_of_day_local_time6",
  "version": null
}
```


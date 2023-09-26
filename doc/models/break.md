
# Break

A record of an employee's break during a shift.

## Structure

`Break`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The UUID for this object. | String getId() |
| `StartAt` | `String` | Required | RFC 3339; follows the same timezone information as `Shift`. Precision up to<br>the minute is respected; seconds are truncated.<br>**Constraints**: *Minimum Length*: `1` | String getStartAt() |
| `EndAt` | `String` | Optional | RFC 3339; follows the same timezone information as `Shift`. Precision up to<br>the minute is respected; seconds are truncated. | String getEndAt() |
| `BreakTypeId` | `String` | Required | The `BreakType` that this `Break` was templated on.<br>**Constraints**: *Minimum Length*: `1` | String getBreakTypeId() |
| `Name` | `String` | Required | A human-readable name.<br>**Constraints**: *Minimum Length*: `1` | String getName() |
| `ExpectedDuration` | `String` | Required | Format: RFC-3339 P[n]Y[n]M[n]DT[n]H[n]M[n]S. The expected length of<br>the break.<br>**Constraints**: *Minimum Length*: `1` | String getExpectedDuration() |
| `IsPaid` | `boolean` | Required | Whether this break counts towards time worked for compensation<br>purposes. | boolean getIsPaid() |

## Example (as JSON)

```json
{
  "id": "id6",
  "start_at": "start_at8",
  "end_at": "end_at4",
  "break_type_id": "break_type_id2",
  "name": "name6",
  "expected_duration": "expected_duration8",
  "is_paid": false
}
```


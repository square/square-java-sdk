## Break

A record of an employee's break during a shift.

### Structure

`Break`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | UUID for this object | String getId() |
| `StartAt` | `String` |  | RFC 3339; follows same timezone info as `Shift`. Precision up to<br>the minute is respected; seconds are truncated. | String getStartAt() |
| `EndAt` | `String` | Optional | RFC 3339; follows same timezone info as `Shift`. Precision up to<br>the minute is respected; seconds are truncated. | String getEndAt() |
| `BreakTypeId` | `String` |  | The `BreakType` this `Break` was templated on. | String getBreakTypeId() |
| `Name` | `String` |  | A human-readable name. | String getName() |
| `ExpectedDuration` | `String` |  | Format: RFC-3339 P[n]Y[n]M[n]DT[n]H[n]M[n]S. The expected length of<br>the break. | String getExpectedDuration() |
| `IsPaid` | `boolean` |  | Whether this break counts towards time worked for compensation<br>purposes. | boolean getIsPaid() |

### Example (as JSON)

```json
{
  "id": "id0",
  "start_at": "start_at2",
  "end_at": "end_at0",
  "break_type_id": "break_type_id6",
  "name": "name0",
  "expected_duration": "expected_duration4",
  "is_paid": false
}
```


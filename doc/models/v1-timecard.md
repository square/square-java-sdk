## V1 Timecard

Represents a timecard for an employee.

### Structure

`V1Timecard`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Id` | `String` | Optional | The timecard's unique ID. |
| `EmployeeId` | `String` |  | The ID of the employee the timecard is associated with. |
| `Deleted` | `Boolean` | Optional | If true, the timecard was deleted by the merchant, and it is no longer valid. |
| `ClockinTime` | `String` | Optional | The clock-in time for the timecard, in ISO 8601 format. |
| `ClockoutTime` | `String` | Optional | The clock-out time for the timecard, in ISO 8601 format. Provide this value only if importing timecard information from another system. |
| `ClockinLocationId` | `String` | Optional | The ID of the location the employee clocked in from. We strongly reccomend providing a clockin_location_id. Square uses the clockin_location_id to determine a timecard’s timezone and overtime rules. |
| `ClockoutLocationId` | `String` | Optional | The ID of the location the employee clocked out from. Provide this value only if importing timecard information from another system. |
| `CreatedAt` | `String` | Optional | The time when the timecard was created, in ISO 8601 format. |
| `UpdatedAt` | `String` | Optional | The time when the timecard was most recently updated, in ISO 8601 format. |
| `RegularSecondsWorked` | `Double` | Optional | The total number of regular (non-overtime) seconds worked in the timecard. |
| `OvertimeSecondsWorked` | `Double` | Optional | The total number of overtime seconds worked in the timecard. |
| `DoubletimeSecondsWorked` | `Double` | Optional | The total number of doubletime seconds worked in the timecard. |

### Example (as JSON)

```json
{
  "id": null,
  "employee_id": "employee_id0",
  "deleted": null,
  "clockin_time": null,
  "clockout_time": null,
  "clockin_location_id": null,
  "clockout_location_id": null,
  "created_at": null,
  "updated_at": null,
  "regular_seconds_worked": null,
  "overtime_seconds_worked": null,
  "doubletime_seconds_worked": null
}
```


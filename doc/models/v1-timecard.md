## V1 Timecard

Represents a timecard for an employee.

### Structure

`V1Timecard`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The timecard's unique ID. | String getId() |
| `EmployeeId` | `String` |  | The ID of the employee the timecard is associated with. | String getEmployeeId() |
| `Deleted` | `Boolean` | Optional | If true, the timecard was deleted by the merchant, and it is no longer valid. | Boolean getDeleted() |
| `ClockinTime` | `String` | Optional | The clock-in time for the timecard, in ISO 8601 format. | String getClockinTime() |
| `ClockoutTime` | `String` | Optional | The clock-out time for the timecard, in ISO 8601 format. Provide this value only if importing timecard information from another system. | String getClockoutTime() |
| `ClockinLocationId` | `String` | Optional | The ID of the location the employee clocked in from. We strongly reccomend providing a clockin_location_id. Square uses the clockin_location_id to determine a timecard’s timezone and overtime rules. | String getClockinLocationId() |
| `ClockoutLocationId` | `String` | Optional | The ID of the location the employee clocked out from. Provide this value only if importing timecard information from another system. | String getClockoutLocationId() |
| `CreatedAt` | `String` | Optional | The time when the timecard was created, in ISO 8601 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The time when the timecard was most recently updated, in ISO 8601 format. | String getUpdatedAt() |
| `RegularSecondsWorked` | `Double` | Optional | The total number of regular (non-overtime) seconds worked in the timecard. | Double getRegularSecondsWorked() |
| `OvertimeSecondsWorked` | `Double` | Optional | The total number of overtime seconds worked in the timecard. | Double getOvertimeSecondsWorked() |
| `DoubletimeSecondsWorked` | `Double` | Optional | The total number of doubletime seconds worked in the timecard. | Double getDoubletimeSecondsWorked() |

### Example (as JSON)

```json
{
  "id": "id0",
  "employee_id": "employee_id0",
  "deleted": false,
  "clockin_time": "clockin_time6",
  "clockout_time": "clockout_time4",
  "clockin_location_id": "clockin_location_id8"
}
```


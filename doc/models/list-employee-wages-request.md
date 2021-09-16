
# List Employee Wages Request

A request for a set of `EmployeeWage` objects.

## Structure

`ListEmployeeWagesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `EmployeeId` | `String` | Optional | Filter the returned wages to only those that are associated with the specified employee. | String getEmployeeId() |
| `Limit` | `Integer` | Optional | The maximum number of `EmployeeWage` results to return per page. The number can range between<br>1 and 200. The default is 200.<br>**Constraints**: `>= 1`, `<= 200` | Integer getLimit() |
| `Cursor` | `String` | Optional | A pointer to the next page of `EmployeeWage` results to fetch. | String getCursor() |

## Example (as JSON)

```json
{
  "employee_id": "employee_id0",
  "limit": 172,
  "cursor": "cursor6"
}
```


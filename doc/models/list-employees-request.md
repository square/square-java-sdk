
# List Employees Request

## Structure

`ListEmployeesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationId` | `String` | Optional | - | String getLocationId() |
| `Status` | [`String`](/doc/models/employee-status.md) | Optional | The status of the Employee being retrieved. | String getStatus() |
| `Limit` | `Integer` | Optional | The number of employees to be returned on each page. | Integer getLimit() |
| `Cursor` | `String` | Optional | The token required to retrieve the specified page of results. | String getCursor() |

## Example (as JSON)

```json
{
  "location_id": "location_id4",
  "status": "ACTIVE",
  "limit": 172,
  "cursor": "cursor6"
}
```



# List Employees Response

## Structure

`ListEmployeesResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Employees` | [`List<Employee>`](../../doc/models/employee.md) | Optional | - | List<Employee> getEmployees() |
| `Cursor` | `String` | Optional | The token to be used to retrieve the next page of results. | String getCursor() |
| `Errors` | [`List<Error>`](../../doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "employees": null,
  "cursor": null,
  "errors": null
}
```


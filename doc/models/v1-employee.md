## V1 Employee

Represents one of a business's employees.

### Structure

`V1Employee`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Id` | `String` | Optional | The employee's unique ID. |
| `FirstName` | `String` |  | The employee's first name. |
| `LastName` | `String` |  | The employee's last name. |
| `RoleIds` | `List<String>` | Optional | The ids of the employee's associated roles. Currently, you can specify only one or zero roles per employee. |
| `AuthorizedLocationIds` | `List<String>` | Optional | The IDs of the locations the employee is allowed to clock in at. |
| `Email` | `String` | Optional | The employee's email address. |
| `Status` | [`String`](/doc/models/v1-employee-status.md) | Optional | - |
| `ExternalId` | `String` | Optional | An ID the merchant can set to associate the employee with an entity in another system. |
| `CreatedAt` | `String` | Optional | The time when the employee entity was created, in ISO 8601 format. |
| `UpdatedAt` | `String` | Optional | The time when the employee entity was most recently updated, in ISO 8601 format. |

### Example (as JSON)

```json
{
  "id": null,
  "first_name": "first_name0",
  "last_name": "last_name8",
  "role_ids": null,
  "authorized_location_ids": null,
  "email": null,
  "status": null,
  "external_id": null,
  "created_at": null,
  "updated_at": null
}
```


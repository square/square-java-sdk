
# V1 Employee

Represents one of a business's employees.

## Structure

`V1Employee`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The employee's unique ID. | String getId() |
| `FirstName` | `String` | Required | The employee's first name. | String getFirstName() |
| `LastName` | `String` | Required | The employee's last name. | String getLastName() |
| `RoleIds` | `List<String>` | Optional | The ids of the employee's associated roles. Currently, you can specify only one or zero roles per employee. | List<String> getRoleIds() |
| `AuthorizedLocationIds` | `List<String>` | Optional | The IDs of the locations the employee is allowed to clock in at. | List<String> getAuthorizedLocationIds() |
| `Email` | `String` | Optional | The employee's email address. | String getEmail() |
| `Status` | [`String`](/doc/models/v1-employee-status.md) | Optional | - | String getStatus() |
| `ExternalId` | `String` | Optional | An ID the merchant can set to associate the employee with an entity in another system. | String getExternalId() |
| `CreatedAt` | `String` | Optional | The time when the employee entity was created, in ISO 8601 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The time when the employee entity was most recently updated, in ISO 8601 format. | String getUpdatedAt() |

## Example (as JSON)

```json
{
  "id": "id0",
  "first_name": "first_name0",
  "last_name": "last_name8",
  "role_ids": [
    "role_ids6",
    "role_ids7",
    "role_ids8"
  ],
  "authorized_location_ids": [
    "authorized_location_ids1"
  ],
  "email": "email6",
  "status": "ACTIVE"
}
```


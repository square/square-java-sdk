## Employee

An employee object that is used by the external API.

### Structure

`Employee`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `Id` | `String` | Optional | UUID for this object. |
| `FirstName` | `String` | Optional | The employee's first name. |
| `LastName` | `String` | Optional | The employee's last name. |
| `Email` | `String` | Optional | The employee's email address |
| `PhoneNumber` | `String` | Optional | The employee's phone number in E.164 format, i.e. "+12125554250" |
| `LocationIds` | `List<String>` | Optional | A list of location IDs where this employee has access to. |
| `Status` | [`String`](/doc/models/employee-status.md) | Optional | The status of the Employee being retrieved. |
| `IsOwner` | `Boolean` | Optional | Whether this employee is the owner of the merchant. Each merchant<br>has one owner employee, and that employee has full authority over<br>the account. |
| `CreatedAt` | `String` | Optional | A read-only timestamp in RFC 3339 format. |
| `UpdatedAt` | `String` | Optional | A read-only timestamp in RFC 3339 format. |

### Example (as JSON)

```json
{
  "id": null,
  "first_name": null,
  "last_name": null,
  "email": null,
  "phone_number": null,
  "location_ids": null,
  "status": null,
  "is_owner": null,
  "created_at": null,
  "updated_at": null
}
```


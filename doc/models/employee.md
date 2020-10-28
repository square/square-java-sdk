
# Employee

An employee object that is used by the external API.

## Structure

`Employee`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | UUID for this object. | String getId() |
| `FirstName` | `String` | Optional | The employee's first name. | String getFirstName() |
| `LastName` | `String` | Optional | The employee's last name. | String getLastName() |
| `Email` | `String` | Optional | The employee's email address | String getEmail() |
| `PhoneNumber` | `String` | Optional | The employee's phone number in E.164 format, i.e. "+12125554250" | String getPhoneNumber() |
| `LocationIds` | `List<String>` | Optional | A list of location IDs where this employee has access to. | List<String> getLocationIds() |
| `Status` | [`String`](/doc/models/employee-status.md) | Optional | The status of the Employee being retrieved. | String getStatus() |
| `IsOwner` | `Boolean` | Optional | Whether this employee is the owner of the merchant. Each merchant<br>has one owner employee, and that employee has full authority over<br>the account. | Boolean getIsOwner() |
| `CreatedAt` | `String` | Optional | A read-only timestamp in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | A read-only timestamp in RFC 3339 format. | String getUpdatedAt() |

## Example (as JSON)

```json
{
  "id": "id0",
  "first_name": "first_name0",
  "last_name": "last_name8",
  "email": "email6",
  "phone_number": "phone_number2"
}
```


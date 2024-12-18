
# Team Member

A record representing an individual team member for a business.

## Structure

`TeamMember`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The unique ID for the team member. | String getId() |
| `ReferenceId` | `String` | Optional | A second ID used to associate the team member with an entity in another system. | String getReferenceId() |
| `IsOwner` | `Boolean` | Optional | Whether the team member is the owner of the Square account. | Boolean getIsOwner() |
| `Status` | [`String`](../../doc/models/team-member-status.md) | Optional | Enumerates the possible statuses the team member can have within a business. | String getStatus() |
| `GivenName` | `String` | Optional | The given name (that is, the first name) associated with the team member. | String getGivenName() |
| `FamilyName` | `String` | Optional | The family name (that is, the last name) associated with the team member. | String getFamilyName() |
| `EmailAddress` | `String` | Optional | The email address associated with the team member. After accepting the invitation<br>from Square, only the team member can change this value. | String getEmailAddress() |
| `PhoneNumber` | `String` | Optional | The team member's phone number, in E.164 format. For example:<br>+14155552671 - the country code is 1 for US<br>+551155256325 - the country code is 55 for BR | String getPhoneNumber() |
| `CreatedAt` | `String` | Optional | The timestamp when the team member was created, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp when the team member was last updated, in RFC 3339 format. | String getUpdatedAt() |
| `AssignedLocations` | [`TeamMemberAssignedLocations`](../../doc/models/team-member-assigned-locations.md) | Optional | An object that represents a team member's assignment to locations. | TeamMemberAssignedLocations getAssignedLocations() |
| `WageSetting` | [`WageSetting`](../../doc/models/wage-setting.md) | Optional | Represents information about the overtime exemption status, job assignments, and compensation<br>for a [team member](../../doc/models/team-member.md). | WageSetting getWageSetting() |

## Example (as JSON)

```json
{
  "id": "id4",
  "reference_id": "reference_id8",
  "is_owner": false,
  "status": "ACTIVE",
  "given_name": "given_name6"
}
```


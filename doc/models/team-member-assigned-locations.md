
# Team Member Assigned Locations

An object that represents a team member's assignment to locations.

## Structure

`TeamMemberAssignedLocations`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AssignmentType` | [`String`](/doc/models/team-member-assigned-locations-assignment-type.md) | Optional | Enumerates the possible assignment types that the team member can have. | String getAssignmentType() |
| `LocationIds` | `List<String>` | Optional | The locations that the team member is assigned to. | List<String> getLocationIds() |

## Example (as JSON)

```json
{
  "assignment_type": "ALL_CURRENT_AND_FUTURE_LOCATIONS",
  "location_ids": [
    "location_ids0"
  ]
}
```


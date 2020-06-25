## Team Member Assigned Locations

An object that represents a team member's assignment to locations.

### Structure

`TeamMemberAssignedLocations`

### Fields

| Name | Type | Tags | Description |
|  --- | --- | --- | --- |
| `AssignmentType` | [`String`](/doc/models/team-member-assigned-locations-assignment-type.md) | Optional | Enumerates the possible assignment types the team member can have |
| `LocationIds` | `List<String>` | Optional | The locations that the team member is assigned to. |

### Example (as JSON)

```json
{
  "assignment_type": null,
  "location_ids": null
}
```


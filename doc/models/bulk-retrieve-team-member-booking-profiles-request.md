
# Bulk Retrieve Team Member Booking Profiles Request

Request payload for the [BulkRetrieveTeamMemberBookingProfiles](../../doc/api/bookings.md#bulk-retrieve-team-member-booking-profiles) endpoint.

## Structure

`BulkRetrieveTeamMemberBookingProfilesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `TeamMemberIds` | `List<String>` | Required | A non-empty list of IDs of team members whose booking profiles you want to retrieve. | List<String> getTeamMemberIds() |

## Example (as JSON)

```json
{
  "team_member_ids": [
    "team_member_ids1",
    "team_member_ids2"
  ]
}
```


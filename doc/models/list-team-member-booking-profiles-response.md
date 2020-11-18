
# List Team Member Booking Profiles Response

## Structure

`ListTeamMemberBookingProfilesResponse`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `TeamMemberBookingProfiles` | [`List<TeamMemberBookingProfile>`](/doc/models/team-member-booking-profile.md) | Optional | The list of team member booking profiles. | List<TeamMemberBookingProfile> getTeamMemberBookingProfiles() |
| `Cursor` | `String` | Optional | The cursor for paginating through the results. | String getCursor() |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

## Example (as JSON)

```json
{
  "errors": [],
  "team_member_booking_profiles": [
    {
      "display_name": "Sandbox Seller",
      "is_bookable": true,
      "team_member_id": "TMXUrsBWWcHTt79t"
    },
    {
      "display_name": "Sandbox Staff",
      "is_bookable": true,
      "team_member_id": "TMaJcbiRqPIGZuS9"
    }
  ]
}
```


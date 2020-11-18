
# Appointment Segment

Defines an appointment segment of a booking.

## Structure

`AppointmentSegment`

## Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `DurationMinutes` | `int` | The time span in minutes of an appointment segment. | int getDurationMinutes() |
| `ServiceVariationId` | `String` | The ID of the [CatalogItemVariation](#type-CatalogItemVariation) object representing the service booked in this segment. | String getServiceVariationId() |
| `TeamMemberId` | `String` | The ID of the [TeamMember](#type-TeamMember) object representing the team member booked in this segment. | String getTeamMemberId() |
| `ServiceVariationVersion` | `long` | The current version of the item variation representing the service booked in this segment. | long getServiceVariationVersion() |

## Example (as JSON)

```json
{
  "duration_minutes": 144,
  "service_variation_id": "service_variation_id6",
  "team_member_id": "team_member_id0",
  "service_variation_version": 56
}
```


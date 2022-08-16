
# Booking Creator Details

Information about a booking creator.

## Structure

`BookingCreatorDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CreatorType` | [`String`](../../doc/models/booking-creator-details-creator-type.md) | Optional | Supported types of a booking creator. | String getCreatorType() |
| `TeamMemberId` | `String` | Optional | The ID of the team member who created the booking, when the booking creator is of the `TEAM_MEMBER` type.<br>Access to this field requires seller-level permissions.<br>**Constraints**: *Maximum Length*: `32` | String getTeamMemberId() |
| `CustomerId` | `String` | Optional | The ID of the customer who created the booking, when the booking creator is of the `CUSTOMER` type.<br>Access to this field requires seller-level permissions.<br>**Constraints**: *Maximum Length*: `192` | String getCustomerId() |

## Example (as JSON)

```json
{
  "creator_type": null
}
```


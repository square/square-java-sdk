
# Location Booking Profile

The booking profile of a seller's location, including the location's ID and whether the location is enabled for online booking.

## Structure

`LocationBookingProfile`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationId` | `String` | Optional | The ID of the [location](entity:Location). | String getLocationId() |
| `BookingSiteUrl` | `String` | Optional | Url for the online booking site for this location. | String getBookingSiteUrl() |
| `OnlineBookingEnabled` | `Boolean` | Optional | Indicates whether the location is enabled for online booking. | Boolean getOnlineBookingEnabled() |

## Example (as JSON)

```json
{
  "location_id": "location_id8",
  "booking_site_url": "booking_site_url4",
  "online_booking_enabled": false
}
```



# List Bookings Request

## Structure

`ListBookingsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Limit` | `Integer` | Optional | The maximum number of results per page to return in a paged response.<br>**Constraints**: `>= 1`, `<= 10000` | Integer getLimit() |
| `Cursor` | `String` | Optional | The pagination cursor from the preceding response to return the next page of the results. Do not set this when retrieving the first page of the results.<br>**Constraints**: *Maximum Length*: `65536` | String getCursor() |
| `CustomerId` | `String` | Optional | The [customer](entity:Customer) for whom to retrieve bookings. If this is not set, bookings for all customers are retrieved.<br>**Constraints**: *Maximum Length*: `192` | String getCustomerId() |
| `TeamMemberId` | `String` | Optional | The team member for whom to retrieve bookings. If this is not set, bookings of all members are retrieved.<br>**Constraints**: *Maximum Length*: `32` | String getTeamMemberId() |
| `LocationId` | `String` | Optional | The location for which to retrieve bookings. If this is not set, all locations' bookings are retrieved.<br>**Constraints**: *Maximum Length*: `32` | String getLocationId() |
| `StartAtMin` | `String` | Optional | The RFC 3339 timestamp specifying the earliest of the start time. If this is not set, the current time is used. | String getStartAtMin() |
| `StartAtMax` | `String` | Optional | The RFC 3339 timestamp specifying the latest of the start time. If this is not set, the time of 31 days after `start_at_min` is used. | String getStartAtMax() |

## Example (as JSON)

```json
{
  "limit": 34,
  "cursor": "cursor4",
  "customer_id": "customer_id0",
  "team_member_id": "team_member_id2",
  "location_id": "location_id6"
}
```


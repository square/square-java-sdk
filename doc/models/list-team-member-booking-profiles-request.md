
# List Team Member Booking Profiles Request

## Structure

`ListTeamMemberBookingProfilesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `BookableOnly` | `Boolean` | Optional | Indicates whether to include only bookable team members in the returned result (`true`) or not (`false`). | Boolean getBookableOnly() |
| `Limit` | `Integer` | Optional | The maximum number of results to return. | Integer getLimit() |
| `Cursor` | `String` | Optional | The cursor for paginating through the results. | String getCursor() |
| `LocationId` | `String` | Optional | Indicates whether to include only team members enabled at the given location in the returned result. | String getLocationId() |

## Example (as JSON)

```json
{
  "bookable_only": false,
  "limit": 172,
  "cursor": "cursor6",
  "location_id": "location_id4"
}
```



# List Location Booking Profiles Request

## Structure

`ListLocationBookingProfilesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Limit` | `Integer` | Optional | The maximum number of results to return in a paged response.<br>**Constraints**: `>= 1`, `<= 100` | Integer getLimit() |
| `Cursor` | `String` | Optional | The pagination cursor from the preceding response to return the next page of the results. Do not set this when retrieving the first page of the results.<br>**Constraints**: *Maximum Length*: `65536` | String getCursor() |

## Example (as JSON)

```json
{
  "limit": 134,
  "cursor": "cursor2"
}
```


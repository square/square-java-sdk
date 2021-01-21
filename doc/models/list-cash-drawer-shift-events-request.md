
# List Cash Drawer Shift Events Request

## Structure

`ListCashDrawerShiftEventsRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationId` | `String` |  | The ID of the location to list cash drawer shifts for.<br>**Constraints**: *Minimum Length*: `1` | String getLocationId() |
| `Limit` | `Integer` | Optional | Number of resources to be returned in a page of results (200 by<br>default, 1000 max).<br>**Constraints**: `<= 1000` | Integer getLimit() |
| `Cursor` | `String` | Optional | Opaque cursor for fetching the next page of results. | String getCursor() |

## Example (as JSON)

```json
{
  "location_id": "location_id4",
  "limit": 172,
  "cursor": "cursor6"
}
```


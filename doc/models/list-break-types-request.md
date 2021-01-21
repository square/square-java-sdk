
# List Break Types Request

A request for a filtered set of `BreakType` objects

## Structure

`ListBreakTypesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationId` | `String` | Optional | Filter Break Types returned to only those that are associated with the<br>specified location. | String getLocationId() |
| `Limit` | `Integer` | Optional | Maximum number of Break Types to return per page. Can range between 1<br>and 200. The default is the maximum at 200.<br>**Constraints**: `>= 1`, `<= 200` | Integer getLimit() |
| `Cursor` | `String` | Optional | Pointer to the next page of Break Type results to fetch. | String getCursor() |

## Example (as JSON)

```json
{
  "location_id": "location_id4",
  "limit": 172,
  "cursor": "cursor6"
}
```



# List Break Types Request

A request for a filtered set of `BreakType` objects.

## Structure

`ListBreakTypesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationId` | `String` | Optional | Filter the returned `BreakType` results to only those that are associated with the<br>specified location. | String getLocationId() |
| `Limit` | `Integer` | Optional | The maximum number of `BreakType` results to return per page. The number can range between 1<br>and 200. The default is 200.<br>**Constraints**: `>= 1`, `<= 200` | Integer getLimit() |
| `Cursor` | `String` | Optional | A pointer to the next page of `BreakType` results to fetch. | String getCursor() |

## Example (as JSON)

```json
{
  "location_id": null,
  "limit": null,
  "cursor": null
}
```


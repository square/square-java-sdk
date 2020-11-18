
# Search Team Members Request

Represents a search request for a filtered list of `TeamMember` objects.

## Structure

`SearchTeamMembersRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Query` | [`SearchTeamMembersQuery`](/doc/models/search-team-members-query.md) | Optional | Represents the parameters in a search for `TeamMember` objects. | SearchTeamMembersQuery getQuery() |
| `Limit` | `Integer` | Optional | The maximum number of `TeamMember` objects in a page (25 by default). | Integer getLimit() |
| `Cursor` | `String` | Optional | The opaque cursor for fetching the next page. Read about<br>[pagination](https://developer.squareup.com/docs/working-with-apis/pagination) with Square APIs for more information. | String getCursor() |

## Example (as JSON)

```json
{
  "limit": 10,
  "query": {
    "filter": {
      "location_ids": [
        "0G5P3VGACMMQZ"
      ],
      "status": "ACTIVE"
    }
  }
}
```



# List Team Member Wages Request

A request for a set of `TeamMemberWage` objects

## Structure

`ListTeamMemberWagesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `TeamMemberId` | `String` | Optional | Filter wages returned to only those that are associated with the<br>specified team member. | String getTeamMemberId() |
| `Limit` | `Integer` | Optional | Maximum number of Team Member Wages to return per page. Can range between<br>1 and 200. The default is the maximum at 200. | Integer getLimit() |
| `Cursor` | `String` | Optional | Pointer to the next page of Employee Wage results to fetch. | String getCursor() |

## Example (as JSON)

```json
{
  "team_member_id": "team_member_id0",
  "limit": 172,
  "cursor": "cursor6"
}
```


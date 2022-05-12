
# List Team Member Wages Request

A request for a set of `TeamMemberWage` objects.

## Structure

`ListTeamMemberWagesRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `TeamMemberId` | `String` | Optional | Filter the returned wages to only those that are associated with the<br>specified team member. | String getTeamMemberId() |
| `Limit` | `Integer` | Optional | The maximum number of `TeamMemberWage` results to return per page. The number can range between<br>1 and 200. The default is 200.<br>**Constraints**: `>= 1`, `<= 200` | Integer getLimit() |
| `Cursor` | `String` | Optional | A pointer to the next page of `EmployeeWage` results to fetch. | String getCursor() |

## Example (as JSON)

```json
{
  "team_member_id": null,
  "limit": null,
  "cursor": null
}
```


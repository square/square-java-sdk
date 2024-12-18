
# Wage Setting

Represents information about the overtime exemption status, job assignments, and compensation
for a [team member](../../doc/models/team-member.md).

## Structure

`WageSetting`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `TeamMemberId` | `String` | Optional | The ID of the team member associated with the wage setting. | String getTeamMemberId() |
| `JobAssignments` | [`List<JobAssignment>`](../../doc/models/job-assignment.md) | Optional | **Required** The ordered list of jobs that the team member is assigned to.<br>The first job assignment is considered the team member's primary job. | List<JobAssignment> getJobAssignments() |
| `IsOvertimeExempt` | `Boolean` | Optional | Whether the team member is exempt from the overtime rules of the seller's country. | Boolean getIsOvertimeExempt() |
| `Version` | `Integer` | Optional | **Read only** Used for resolving concurrency issues. The request fails if the version<br>provided does not match the server version at the time of the request. If not provided,<br>Square executes a blind write, potentially overwriting data from another write. For more information,<br>see [optimistic concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency). | Integer getVersion() |
| `CreatedAt` | `String` | Optional | The timestamp when the wage setting was created, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp when the wage setting was last updated, in RFC 3339 format. | String getUpdatedAt() |

## Example (as JSON)

```json
{
  "team_member_id": "team_member_id2",
  "job_assignments": [
    {
      "job_title": "job_title6",
      "pay_type": "SALARY",
      "hourly_rate": {
        "amount": 172,
        "currency": "LAK"
      },
      "annual_rate": {
        "amount": 232,
        "currency": "NIO"
      },
      "weekly_hours": 98,
      "job_id": "job_id2"
    },
    {
      "job_title": "job_title6",
      "pay_type": "SALARY",
      "hourly_rate": {
        "amount": 172,
        "currency": "LAK"
      },
      "annual_rate": {
        "amount": 232,
        "currency": "NIO"
      },
      "weekly_hours": 98,
      "job_id": "job_id2"
    },
    {
      "job_title": "job_title6",
      "pay_type": "SALARY",
      "hourly_rate": {
        "amount": 172,
        "currency": "LAK"
      },
      "annual_rate": {
        "amount": 232,
        "currency": "NIO"
      },
      "weekly_hours": 98,
      "job_id": "job_id2"
    }
  ],
  "is_overtime_exempt": false,
  "version": 140,
  "created_at": "created_at0"
}
```


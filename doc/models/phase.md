
# Phase

Represents a phase, which can override subscription phases as defined by plan_id

## Structure

`Phase`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Uid` | `String` | Optional | id of subscription phase | String getUid() |
| `Ordinal` | `Integer` | Optional | index of phase in total subscription plan | Integer getOrdinal() |
| `OrderTemplateId` | `String` | Optional | id of order to be used in billing | String getOrderTemplateId() |
| `PlanPhaseUid` | `String` | Optional | the uid from the plan's phase in catalog | String getPlanPhaseUid() |

## Example (as JSON)

```json
{
  "uid": "uid4",
  "ordinal": 12,
  "order_template_id": "order_template_id6",
  "plan_phase_uid": "plan_phase_uid0"
}
```


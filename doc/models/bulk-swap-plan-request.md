
# Bulk Swap Plan Request

Defines input parameters in a call to the
[BulkSwapPlan](../../doc/api/subscriptions.md#bulk-swap-plan) endpoint.

## Structure

`BulkSwapPlanRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `NewPlanVariationId` | `String` | Required | The ID of the new subscription plan variation.<br><br>This field is required.<br>**Constraints**: *Minimum Length*: `1` | String getNewPlanVariationId() |
| `OldPlanVariationId` | `String` | Required | The ID of the plan variation whose subscriptions should be swapped. Active subscriptions<br>using this plan variation will be subscribed to the new plan variation on their next billing<br>day.<br>**Constraints**: *Minimum Length*: `1` | String getOldPlanVariationId() |
| `LocationId` | `String` | Required | The ID of the location to associate with the swapped subscriptions.<br>**Constraints**: *Minimum Length*: `1` | String getLocationId() |

## Example (as JSON)

```json
{
  "location_id": "S8GWD5R9QB376",
  "new_plan_variation_id": "FQ7CDXXWSLUJRPM3GFJSJGZ7",
  "old_plan_variation_id": "6JHXF3B2CW3YKHDV4XEM674H"
}
```


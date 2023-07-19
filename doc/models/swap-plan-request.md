
# Swap Plan Request

Defines input parameters in a call to the
[SwapPlan](../../doc/api/subscriptions.md#swap-plan) endpoint.

## Structure

`SwapPlanRequest`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `NewPlanVariationId` | `String` | Optional | The ID of the new subscription plan variation.<br><br>This field is required. | String getNewPlanVariationId() |
| `Phases` | [`List<PhaseInput>`](../../doc/models/phase-input.md) | Optional | A list of PhaseInputs, to pass phase-specific information used in the swap. | List<PhaseInput> getPhases() |

## Example (as JSON)

```json
{
  "new_plan_variation_id": "FQ7CDXXWSLUJRPM3GFJSJGZ7",
  "phases": [
    {
      "order_template_id": "uhhnjH9osVv3shUADwaC0b3hNxQZY",
      "ordinal": 0
    }
  ]
}
```


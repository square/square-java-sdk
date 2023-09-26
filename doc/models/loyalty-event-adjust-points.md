
# Loyalty Event Adjust Points

Provides metadata when the event `type` is `ADJUST_POINTS`.

## Structure

`LoyaltyEventAdjustPoints`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LoyaltyProgramId` | `String` | Optional | The Square-assigned ID of the [loyalty program](entity:LoyaltyProgram).<br>**Constraints**: *Maximum Length*: `36` | String getLoyaltyProgramId() |
| `Points` | `int` | Required | The number of points added or removed. | int getPoints() |
| `Reason` | `String` | Optional | The reason for the adjustment of points. | String getReason() |

## Example (as JSON)

```json
{
  "loyalty_program_id": "loyalty_program_id4",
  "points": 98,
  "reason": "reason0"
}
```


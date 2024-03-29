
# Loyalty Event Delete Reward

Provides metadata when the event `type` is `DELETE_REWARD`.

## Structure

`LoyaltyEventDeleteReward`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LoyaltyProgramId` | `String` | Required | The ID of the [loyalty program](entity:LoyaltyProgram).<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `36` | String getLoyaltyProgramId() |
| `RewardId` | `String` | Optional | The ID of the deleted [loyalty reward](entity:LoyaltyReward).<br>This field is returned only if the event source is `LOYALTY_API`.<br>**Constraints**: *Maximum Length*: `36` | String getRewardId() |
| `Points` | `int` | Required | The number of points returned to the loyalty account. | int getPoints() |

## Example (as JSON)

```json
{
  "loyalty_program_id": "loyalty_program_id2",
  "reward_id": "reward_id6",
  "points": 84
}
```


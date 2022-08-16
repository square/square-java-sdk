
# Loyalty Event Delete Reward

Provides metadata when the event `type` is `DELETE_REWARD`.

## Structure

`LoyaltyEventDeleteReward`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LoyaltyProgramId` | `String` | Required | The ID of the [loyalty program](../../doc/models/loyalty-program.md).<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `36` | String getLoyaltyProgramId() |
| `RewardId` | `String` | Optional | The ID of the deleted [loyalty reward](../../doc/models/loyalty-reward.md).<br>This field is returned only if the event source is `LOYALTY_API`.<br>**Constraints**: *Maximum Length*: `36` | String getRewardId() |
| `Points` | `int` | Required | The number of points returned to the loyalty account. | int getPoints() |

## Example (as JSON)

```json
{}
```


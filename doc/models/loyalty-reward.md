## Loyalty Reward

### Structure

`LoyaltyReward`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-assigned ID of the loyalty reward. | String getId() |
| `Status` | [`String`](/doc/models/loyalty-reward-status.md) | Optional | The status of the loyalty reward. | String getStatus() |
| `LoyaltyAccountId` | `String` |  | The Square-assigned ID of the [loyalty account](#type-LoyaltyAccount) to which the reward belongs. | String getLoyaltyAccountId() |
| `RewardTierId` | `String` |  | The Square-assigned ID of the [reward tier](#type-LoyaltyProgramRewardTier) used to create the reward. | String getRewardTierId() |
| `Points` | `Integer` | Optional | The number of loyalty points used for the reward. | Integer getPoints() |
| `OrderId` | `String` | Optional | The Square-assigned ID of the [order](#type-Order) to which the reward is attached. | String getOrderId() |
| `CreatedAt` | `String` | Optional | The timestamp when the reward was created, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp when the reward was last updated, in RFC 3339 format. | String getUpdatedAt() |
| `RedeemedAt` | `String` | Optional | The timestamp when the reward was redeemed, in RFC 3339 format. | String getRedeemedAt() |

### Example (as JSON)

```json
{
  "id": "id0",
  "status": "DELETED",
  "loyalty_account_id": "loyalty_account_id0",
  "reward_tier_id": "reward_tier_id6",
  "points": 236,
  "order_id": "order_id6",
  "created_at": "created_at2"
}
```


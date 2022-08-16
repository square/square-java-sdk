
# Loyalty Reward

Represents a contract to redeem loyalty points for a [reward tier](../../doc/models/loyalty-program-reward-tier.md) discount. Loyalty rewards can be in an ISSUED, REDEEMED, or DELETED state.
For more information, see [Manage loyalty rewards](https://developer.squareup.com/docs/loyalty-api/loyalty-rewards).

## Structure

`LoyaltyReward`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-assigned ID of the loyalty reward.<br>**Constraints**: *Maximum Length*: `36` | String getId() |
| `Status` | [`String`](../../doc/models/loyalty-reward-status.md) | Optional | The status of the loyalty reward. | String getStatus() |
| `LoyaltyAccountId` | `String` | Required | The Square-assigned ID of the [loyalty account](../../doc/models/loyalty-account.md) to which the reward belongs.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `36` | String getLoyaltyAccountId() |
| `RewardTierId` | `String` | Required | The Square-assigned ID of the [reward tier](../../doc/models/loyalty-program-reward-tier.md) used to create the reward.<br>**Constraints**: *Minimum Length*: `1`, *Maximum Length*: `36` | String getRewardTierId() |
| `Points` | `Integer` | Optional | The number of loyalty points used for the reward.<br>**Constraints**: `>= 1` | Integer getPoints() |
| `OrderId` | `String` | Optional | The Square-assigned ID of the [order](../../doc/models/order.md) to which the reward is attached. | String getOrderId() |
| `CreatedAt` | `String` | Optional | The timestamp when the reward was created, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp when the reward was last updated, in RFC 3339 format. | String getUpdatedAt() |
| `RedeemedAt` | `String` | Optional | The timestamp when the reward was redeemed, in RFC 3339 format. | String getRedeemedAt() |

## Example (as JSON)

```json
{
  "status": null,
  "loyalty_account_id": "loyalty_account_id0",
  "reward_tier_id": "reward_tier_id6",
  "order_id": null
}
```


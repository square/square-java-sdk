
# Search Loyalty Rewards Request Loyalty Reward Query

The set of search requirements.

## Structure

`SearchLoyaltyRewardsRequestLoyaltyRewardQuery`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LoyaltyAccountId` | `String` | Required | The ID of the [loyalty account](entity:LoyaltyAccount) to which the loyalty reward belongs.<br>**Constraints**: *Minimum Length*: `1` | String getLoyaltyAccountId() |
| `Status` | [`String`](../../doc/models/loyalty-reward-status.md) | Optional | The status of the loyalty reward. | String getStatus() |

## Example (as JSON)

```json
{
  "loyalty_account_id": "loyalty_account_id2",
  "status": "DELETED"
}
```


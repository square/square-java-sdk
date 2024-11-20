
# Loyalty Program

Represents a Square loyalty program. Loyalty programs define how buyers can earn points and redeem points for rewards.
Square sellers can have only one loyalty program, which is created and managed from the Seller Dashboard.
For more information, see [Loyalty Program Overview](https://developer.squareup.com/docs/loyalty/overview).

## Structure

`LoyaltyProgram`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The Square-assigned ID of the loyalty program. Updates to<br>the loyalty program do not modify the identifier.<br>**Constraints**: *Maximum Length*: `36` | String getId() |
| `Status` | [`String`](../../doc/models/loyalty-program-status.md) | Optional | Indicates whether the program is currently active. | String getStatus() |
| `RewardTiers` | [`List<LoyaltyProgramRewardTier>`](../../doc/models/loyalty-program-reward-tier.md) | Optional | The list of rewards for buyers, sorted by ascending points. | List<LoyaltyProgramRewardTier> getRewardTiers() |
| `ExpirationPolicy` | [`LoyaltyProgramExpirationPolicy`](../../doc/models/loyalty-program-expiration-policy.md) | Optional | Describes when the loyalty program expires. | LoyaltyProgramExpirationPolicy getExpirationPolicy() |
| `Terminology` | [`LoyaltyProgramTerminology`](../../doc/models/loyalty-program-terminology.md) | Optional | Represents the naming used for loyalty points. | LoyaltyProgramTerminology getTerminology() |
| `LocationIds` | `List<String>` | Optional | The [locations](entity:Location) at which the program is active. | List<String> getLocationIds() |
| `CreatedAt` | `String` | Optional | The timestamp when the program was created, in RFC 3339 format. | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp when the reward was last updated, in RFC 3339 format. | String getUpdatedAt() |
| `AccrualRules` | [`List<LoyaltyProgramAccrualRule>`](../../doc/models/loyalty-program-accrual-rule.md) | Optional | Defines how buyers can earn loyalty points from the base loyalty program.<br>To check for associated [loyalty promotions](entity:LoyaltyPromotion) that enable<br>buyers to earn extra points, call [ListLoyaltyPromotions](api-endpoint:Loyalty-ListLoyaltyPromotions). | List<LoyaltyProgramAccrualRule> getAccrualRules() |

## Example (as JSON)

```json
{
  "id": "id2",
  "status": "INACTIVE",
  "reward_tiers": [
    {
      "id": "id8",
      "points": 250,
      "name": "name8",
      "definition": {
        "scope": "ORDER",
        "discount_type": "FIXED_AMOUNT",
        "percentage_discount": "percentage_discount2",
        "catalog_object_ids": [
          "catalog_object_ids6"
        ],
        "fixed_discount_money": {
          "amount": 36,
          "currency": "SLL"
        },
        "max_discount_money": {
          "amount": 84,
          "currency": "BOB"
        }
      },
      "created_at": "created_at6",
      "pricing_rule_reference": {
        "object_id": "object_id0",
        "catalog_version": 218
      }
    },
    {
      "id": "id8",
      "points": 250,
      "name": "name8",
      "definition": {
        "scope": "ORDER",
        "discount_type": "FIXED_AMOUNT",
        "percentage_discount": "percentage_discount2",
        "catalog_object_ids": [
          "catalog_object_ids6"
        ],
        "fixed_discount_money": {
          "amount": 36,
          "currency": "SLL"
        },
        "max_discount_money": {
          "amount": 84,
          "currency": "BOB"
        }
      },
      "created_at": "created_at6",
      "pricing_rule_reference": {
        "object_id": "object_id0",
        "catalog_version": 218
      }
    }
  ],
  "expiration_policy": {
    "expiration_duration": "expiration_duration0"
  },
  "terminology": {
    "one": "one0",
    "other": "other6"
  }
}
```



# Loyalty Program Accrual Rule

Represents an accrual rule, which defines how buyers can earn points from the base [loyalty program](../../doc/models/loyalty-program.md).

## Structure

`LoyaltyProgramAccrualRule`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AccrualType` | [`String`](../../doc/models/loyalty-program-accrual-rule-type.md) | Required | The type of the accrual rule that defines how buyers can earn points. | String getAccrualType() |
| `Points` | `Integer` | Optional | The number of points that<br>buyers earn based on the `accrual_type`.<br>**Constraints**: `>= 1` | Integer getPoints() |
| `VisitData` | [`LoyaltyProgramAccrualRuleVisitData`](../../doc/models/loyalty-program-accrual-rule-visit-data.md) | Optional | Represents additional data for rules with the `VISIT` accrual type. | LoyaltyProgramAccrualRuleVisitData getVisitData() |
| `SpendData` | [`LoyaltyProgramAccrualRuleSpendData`](../../doc/models/loyalty-program-accrual-rule-spend-data.md) | Optional | Represents additional data for rules with the `SPEND` accrual type. | LoyaltyProgramAccrualRuleSpendData getSpendData() |
| `ItemVariationData` | [`LoyaltyProgramAccrualRuleItemVariationData`](../../doc/models/loyalty-program-accrual-rule-item-variation-data.md) | Optional | Represents additional data for rules with the `ITEM_VARIATION` accrual type. | LoyaltyProgramAccrualRuleItemVariationData getItemVariationData() |
| `CategoryData` | [`LoyaltyProgramAccrualRuleCategoryData`](../../doc/models/loyalty-program-accrual-rule-category-data.md) | Optional | Represents additional data for rules with the `CATEGORY` accrual type. | LoyaltyProgramAccrualRuleCategoryData getCategoryData() |

## Example (as JSON)

```json
{
  "accrual_type": "VISIT",
  "points": 86,
  "visit_data": {
    "minimum_amount_money": {
      "amount": 146,
      "currency": "GHS"
    },
    "tax_mode": "BEFORE_TAX"
  },
  "spend_data": {
    "amount_money": {
      "amount": 186,
      "currency": "AUD"
    },
    "excluded_category_ids": [
      "excluded_category_ids4"
    ],
    "excluded_item_variation_ids": [
      "excluded_item_variation_ids3",
      "excluded_item_variation_ids4"
    ],
    "tax_mode": "BEFORE_TAX"
  },
  "item_variation_data": {
    "item_variation_id": "item_variation_id0"
  },
  "category_data": {
    "category_id": "category_id4"
  }
}
```


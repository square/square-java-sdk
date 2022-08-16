
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
  "accrual_type": "ITEM_VARIATION",
  "visit_data": null,
  "spend_data": null,
  "item_variation_data": null,
  "category_data": null
}
```


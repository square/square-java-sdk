
# Catalog Item Food and Beverage Details

The food and beverage-specific details of a `FOOD_AND_BEV` item.

## Structure

`CatalogItemFoodAndBeverageDetails`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CalorieCount` | `Integer` | Optional | The calorie count (in the unit of kcal) for the `FOOD_AND_BEV` type of items. | Integer getCalorieCount() |
| `DietaryPreferences` | [`List<CatalogItemFoodAndBeverageDetailsDietaryPreference>`](../../doc/models/catalog-item-food-and-beverage-details-dietary-preference.md) | Optional | The dietary preferences for the `FOOD_AND_BEV` item. | List<CatalogItemFoodAndBeverageDetailsDietaryPreference> getDietaryPreferences() |
| `Ingredients` | [`List<CatalogItemFoodAndBeverageDetailsIngredient>`](../../doc/models/catalog-item-food-and-beverage-details-ingredient.md) | Optional | The ingredients for the `FOOD_AND_BEV` type item. | List<CatalogItemFoodAndBeverageDetailsIngredient> getIngredients() |

## Example (as JSON)

```json
{
  "calorie_count": 36,
  "dietary_preferences": [
    {
      "type": "STANDARD",
      "standard_name": "VEGETARIAN",
      "custom_name": "custom_name8"
    }
  ],
  "ingredients": [
    {
      "type": "STANDARD",
      "standard_name": "MILK",
      "custom_name": "custom_name8"
    },
    {
      "type": "STANDARD",
      "standard_name": "MILK",
      "custom_name": "custom_name8"
    }
  ]
}
```


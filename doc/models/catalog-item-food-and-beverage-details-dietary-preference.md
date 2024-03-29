
# Catalog Item Food and Beverage Details Dietary Preference

Dietary preferences that can be assigned to an `FOOD_AND_BEV` item and its ingredients.

## Structure

`CatalogItemFoodAndBeverageDetailsDietaryPreference`

## Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Type` | [`String`](../../doc/models/catalog-item-food-and-beverage-details-dietary-preference-type.md) | Optional | The type of dietary preference for the `FOOD_AND_BEV` type of items and integredients. | String getType() |
| `StandardName` | [`String`](../../doc/models/catalog-item-food-and-beverage-details-dietary-preference-standard-dietary-preference.md) | Optional | Standard dietary preferences for food and beverage items that are recommended on item creation. | String getStandardName() |
| `CustomName` | `String` | Optional | The name of a user-defined custom dietary preference. This should be null if it's a standard dietary preference. | String getCustomName() |

## Example (as JSON)

```json
{
  "type": "STANDARD",
  "standard_name": "GLUTEN_FREE",
  "custom_name": "custom_name4"
}
```


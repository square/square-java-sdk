package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogItemFoodAndBeverageDetails type.
 */
public class CatalogItemFoodAndBeverageDetails {
    private final OptionalNullable<Integer> calorieCount;
    private final OptionalNullable<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> dietaryPreferences;
    private final OptionalNullable<List<CatalogItemFoodAndBeverageDetailsIngredient>> ingredients;

    /**
     * Initialization constructor.
     * @param  calorieCount  Integer value for calorieCount.
     * @param  dietaryPreferences  List of CatalogItemFoodAndBeverageDetailsDietaryPreference value
     *         for dietaryPreferences.
     * @param  ingredients  List of CatalogItemFoodAndBeverageDetailsIngredient value for
     *         ingredients.
     */
    @JsonCreator
    public CatalogItemFoodAndBeverageDetails(
            @JsonProperty("calorie_count") Integer calorieCount,
            @JsonProperty("dietary_preferences")
                    List<CatalogItemFoodAndBeverageDetailsDietaryPreference> dietaryPreferences,
            @JsonProperty("ingredients") List<CatalogItemFoodAndBeverageDetailsIngredient> ingredients) {
        this.calorieCount = OptionalNullable.of(calorieCount);
        this.dietaryPreferences = OptionalNullable.of(dietaryPreferences);
        this.ingredients = OptionalNullable.of(ingredients);
    }

    /**
     * Initialization constructor.
     * @param  calorieCount  Integer value for calorieCount.
     * @param  dietaryPreferences  List of CatalogItemFoodAndBeverageDetailsDietaryPreference value
     *         for dietaryPreferences.
     * @param  ingredients  List of CatalogItemFoodAndBeverageDetailsIngredient value for
     *         ingredients.
     */
    protected CatalogItemFoodAndBeverageDetails(
            OptionalNullable<Integer> calorieCount,
            OptionalNullable<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> dietaryPreferences,
            OptionalNullable<List<CatalogItemFoodAndBeverageDetailsIngredient>> ingredients) {
        this.calorieCount = calorieCount;
        this.dietaryPreferences = dietaryPreferences;
        this.ingredients = ingredients;
    }

    /**
     * Internal Getter for CalorieCount.
     * The calorie count (in the unit of kcal) for the `FOOD_AND_BEV` type of items.
     * @return Returns the Internal Integer
     */
    @JsonGetter("calorie_count")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetCalorieCount() {
        return this.calorieCount;
    }

    /**
     * Getter for CalorieCount.
     * The calorie count (in the unit of kcal) for the `FOOD_AND_BEV` type of items.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getCalorieCount() {
        return OptionalNullable.getFrom(calorieCount);
    }

    /**
     * Internal Getter for DietaryPreferences.
     * The dietary preferences for the `FOOD_AND_BEV` item.
     * @return Returns the Internal List of CatalogItemFoodAndBeverageDetailsDietaryPreference
     */
    @JsonGetter("dietary_preferences")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>>
            internalGetDietaryPreferences() {
        return this.dietaryPreferences;
    }

    /**
     * Getter for DietaryPreferences.
     * The dietary preferences for the `FOOD_AND_BEV` item.
     * @return Returns the List of CatalogItemFoodAndBeverageDetailsDietaryPreference
     */
    @JsonIgnore
    public List<CatalogItemFoodAndBeverageDetailsDietaryPreference> getDietaryPreferences() {
        return OptionalNullable.getFrom(dietaryPreferences);
    }

    /**
     * Internal Getter for Ingredients.
     * The ingredients for the `FOOD_AND_BEV` type item.
     * @return Returns the Internal List of CatalogItemFoodAndBeverageDetailsIngredient
     */
    @JsonGetter("ingredients")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogItemFoodAndBeverageDetailsIngredient>> internalGetIngredients() {
        return this.ingredients;
    }

    /**
     * Getter for Ingredients.
     * The ingredients for the `FOOD_AND_BEV` type item.
     * @return Returns the List of CatalogItemFoodAndBeverageDetailsIngredient
     */
    @JsonIgnore
    public List<CatalogItemFoodAndBeverageDetailsIngredient> getIngredients() {
        return OptionalNullable.getFrom(ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calorieCount, dietaryPreferences, ingredients);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItemFoodAndBeverageDetails)) {
            return false;
        }
        CatalogItemFoodAndBeverageDetails other = (CatalogItemFoodAndBeverageDetails) obj;
        return Objects.equals(calorieCount, other.calorieCount)
                && Objects.equals(dietaryPreferences, other.dietaryPreferences)
                && Objects.equals(ingredients, other.ingredients);
    }

    /**
     * Converts this CatalogItemFoodAndBeverageDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItemFoodAndBeverageDetails [" + "calorieCount=" + calorieCount
                + ", dietaryPreferences=" + dietaryPreferences + ", ingredients=" + ingredients
                + "]";
    }

    /**
     * Builds a new {@link CatalogItemFoodAndBeverageDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemFoodAndBeverageDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.calorieCount = internalGetCalorieCount();
        builder.dietaryPreferences = internalGetDietaryPreferences();
        builder.ingredients = internalGetIngredients();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemFoodAndBeverageDetails}.
     */
    public static class Builder {
        private OptionalNullable<Integer> calorieCount;
        private OptionalNullable<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> dietaryPreferences;
        private OptionalNullable<List<CatalogItemFoodAndBeverageDetailsIngredient>> ingredients;

        /**
         * Setter for calorieCount.
         * @param  calorieCount  Integer value for calorieCount.
         * @return Builder
         */
        public Builder calorieCount(Integer calorieCount) {
            this.calorieCount = OptionalNullable.of(calorieCount);
            return this;
        }

        /**
         * UnSetter for calorieCount.
         * @return Builder
         */
        public Builder unsetCalorieCount() {
            calorieCount = null;
            return this;
        }

        /**
         * Setter for dietaryPreferences.
         * @param  dietaryPreferences  List of CatalogItemFoodAndBeverageDetailsDietaryPreference
         *         value for dietaryPreferences.
         * @return Builder
         */
        public Builder dietaryPreferences(List<CatalogItemFoodAndBeverageDetailsDietaryPreference> dietaryPreferences) {
            this.dietaryPreferences = OptionalNullable.of(dietaryPreferences);
            return this;
        }

        /**
         * UnSetter for dietaryPreferences.
         * @return Builder
         */
        public Builder unsetDietaryPreferences() {
            dietaryPreferences = null;
            return this;
        }

        /**
         * Setter for ingredients.
         * @param  ingredients  List of CatalogItemFoodAndBeverageDetailsIngredient value for
         *         ingredients.
         * @return Builder
         */
        public Builder ingredients(List<CatalogItemFoodAndBeverageDetailsIngredient> ingredients) {
            this.ingredients = OptionalNullable.of(ingredients);
            return this;
        }

        /**
         * UnSetter for ingredients.
         * @return Builder
         */
        public Builder unsetIngredients() {
            ingredients = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemFoodAndBeverageDetails} object using the set fields.
         * @return {@link CatalogItemFoodAndBeverageDetails}
         */
        public CatalogItemFoodAndBeverageDetails build() {
            return new CatalogItemFoodAndBeverageDetails(calorieCount, dietaryPreferences, ingredients);
        }
    }
}

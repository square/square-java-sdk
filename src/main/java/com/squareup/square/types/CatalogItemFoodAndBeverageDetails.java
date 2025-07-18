/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogItemFoodAndBeverageDetails.Builder.class)
public final class CatalogItemFoodAndBeverageDetails {
    private final Optional<Integer> calorieCount;

    private final Optional<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> dietaryPreferences;

    private final Optional<List<CatalogItemFoodAndBeverageDetailsIngredient>> ingredients;

    private final Map<String, Object> additionalProperties;

    private CatalogItemFoodAndBeverageDetails(
            Optional<Integer> calorieCount,
            Optional<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> dietaryPreferences,
            Optional<List<CatalogItemFoodAndBeverageDetailsIngredient>> ingredients,
            Map<String, Object> additionalProperties) {
        this.calorieCount = calorieCount;
        this.dietaryPreferences = dietaryPreferences;
        this.ingredients = ingredients;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The calorie count (in the unit of kcal) for the <code>FOOD_AND_BEV</code> type of items.
     */
    @JsonIgnore
    public Optional<Integer> getCalorieCount() {
        if (calorieCount == null) {
            return Optional.empty();
        }
        return calorieCount;
    }

    /**
     * @return The dietary preferences for the <code>FOOD_AND_BEV</code> item.
     */
    @JsonIgnore
    public Optional<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> getDietaryPreferences() {
        if (dietaryPreferences == null) {
            return Optional.empty();
        }
        return dietaryPreferences;
    }

    /**
     * @return The ingredients for the <code>FOOD_AND_BEV</code> type item.
     */
    @JsonIgnore
    public Optional<List<CatalogItemFoodAndBeverageDetailsIngredient>> getIngredients() {
        if (ingredients == null) {
            return Optional.empty();
        }
        return ingredients;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("calorie_count")
    private Optional<Integer> _getCalorieCount() {
        return calorieCount;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("dietary_preferences")
    private Optional<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> _getDietaryPreferences() {
        return dietaryPreferences;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("ingredients")
    private Optional<List<CatalogItemFoodAndBeverageDetailsIngredient>> _getIngredients() {
        return ingredients;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogItemFoodAndBeverageDetails && equalTo((CatalogItemFoodAndBeverageDetails) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogItemFoodAndBeverageDetails other) {
        return calorieCount.equals(other.calorieCount)
                && dietaryPreferences.equals(other.dietaryPreferences)
                && ingredients.equals(other.ingredients);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.calorieCount, this.dietaryPreferences, this.ingredients);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Integer> calorieCount = Optional.empty();

        private Optional<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> dietaryPreferences =
                Optional.empty();

        private Optional<List<CatalogItemFoodAndBeverageDetailsIngredient>> ingredients = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogItemFoodAndBeverageDetails other) {
            calorieCount(other.getCalorieCount());
            dietaryPreferences(other.getDietaryPreferences());
            ingredients(other.getIngredients());
            return this;
        }

        /**
         * <p>The calorie count (in the unit of kcal) for the <code>FOOD_AND_BEV</code> type of items.</p>
         */
        @JsonSetter(value = "calorie_count", nulls = Nulls.SKIP)
        public Builder calorieCount(Optional<Integer> calorieCount) {
            this.calorieCount = calorieCount;
            return this;
        }

        public Builder calorieCount(Integer calorieCount) {
            this.calorieCount = Optional.ofNullable(calorieCount);
            return this;
        }

        public Builder calorieCount(Nullable<Integer> calorieCount) {
            if (calorieCount.isNull()) {
                this.calorieCount = null;
            } else if (calorieCount.isEmpty()) {
                this.calorieCount = Optional.empty();
            } else {
                this.calorieCount = Optional.of(calorieCount.get());
            }
            return this;
        }

        /**
         * <p>The dietary preferences for the <code>FOOD_AND_BEV</code> item.</p>
         */
        @JsonSetter(value = "dietary_preferences", nulls = Nulls.SKIP)
        public Builder dietaryPreferences(
                Optional<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> dietaryPreferences) {
            this.dietaryPreferences = dietaryPreferences;
            return this;
        }

        public Builder dietaryPreferences(List<CatalogItemFoodAndBeverageDetailsDietaryPreference> dietaryPreferences) {
            this.dietaryPreferences = Optional.ofNullable(dietaryPreferences);
            return this;
        }

        public Builder dietaryPreferences(
                Nullable<List<CatalogItemFoodAndBeverageDetailsDietaryPreference>> dietaryPreferences) {
            if (dietaryPreferences.isNull()) {
                this.dietaryPreferences = null;
            } else if (dietaryPreferences.isEmpty()) {
                this.dietaryPreferences = Optional.empty();
            } else {
                this.dietaryPreferences = Optional.of(dietaryPreferences.get());
            }
            return this;
        }

        /**
         * <p>The ingredients for the <code>FOOD_AND_BEV</code> type item.</p>
         */
        @JsonSetter(value = "ingredients", nulls = Nulls.SKIP)
        public Builder ingredients(Optional<List<CatalogItemFoodAndBeverageDetailsIngredient>> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Builder ingredients(List<CatalogItemFoodAndBeverageDetailsIngredient> ingredients) {
            this.ingredients = Optional.ofNullable(ingredients);
            return this;
        }

        public Builder ingredients(Nullable<List<CatalogItemFoodAndBeverageDetailsIngredient>> ingredients) {
            if (ingredients.isNull()) {
                this.ingredients = null;
            } else if (ingredients.isEmpty()) {
                this.ingredients = Optional.empty();
            } else {
                this.ingredients = Optional.of(ingredients.get());
            }
            return this;
        }

        public CatalogItemFoodAndBeverageDetails build() {
            return new CatalogItemFoodAndBeverageDetails(
                    calorieCount, dietaryPreferences, ingredients, additionalProperties);
        }
    }
}

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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogItemFoodAndBeverageDetailsIngredient.Builder.class)
public final class CatalogItemFoodAndBeverageDetailsIngredient {
    private final Optional<CatalogItemFoodAndBeverageDetailsDietaryPreferenceType> type;

    private final Optional<CatalogItemFoodAndBeverageDetailsIngredientStandardIngredient> standardName;

    private final Optional<String> customName;

    private final Map<String, Object> additionalProperties;

    private CatalogItemFoodAndBeverageDetailsIngredient(
            Optional<CatalogItemFoodAndBeverageDetailsDietaryPreferenceType> type,
            Optional<CatalogItemFoodAndBeverageDetailsIngredientStandardIngredient> standardName,
            Optional<String> customName,
            Map<String, Object> additionalProperties) {
        this.type = type;
        this.standardName = standardName;
        this.customName = customName;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The dietary preference type of the ingredient. Supported values include <code>STANDARD</code> and <code>CUSTOM</code> as specified in <code>FoodAndBeverageDetails.DietaryPreferenceType</code>.
     * See <a href="#type-dietarypreferencetype">DietaryPreferenceType</a> for possible values
     */
    @JsonProperty("type")
    public Optional<CatalogItemFoodAndBeverageDetailsDietaryPreferenceType> getType() {
        return type;
    }

    /**
     * @return The name of the ingredient from a standard pre-defined list. This should be null if it's a custom dietary preference.
     * See <a href="#type-standardingredient">StandardIngredient</a> for possible values
     */
    @JsonProperty("standard_name")
    public Optional<CatalogItemFoodAndBeverageDetailsIngredientStandardIngredient> getStandardName() {
        return standardName;
    }

    /**
     * @return The name of a custom user-defined ingredient. This should be null if it's a standard dietary preference.
     */
    @JsonIgnore
    public Optional<String> getCustomName() {
        if (customName == null) {
            return Optional.empty();
        }
        return customName;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("custom_name")
    private Optional<String> _getCustomName() {
        return customName;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogItemFoodAndBeverageDetailsIngredient
                && equalTo((CatalogItemFoodAndBeverageDetailsIngredient) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogItemFoodAndBeverageDetailsIngredient other) {
        return type.equals(other.type)
                && standardName.equals(other.standardName)
                && customName.equals(other.customName);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type, this.standardName, this.customName);
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
        private Optional<CatalogItemFoodAndBeverageDetailsDietaryPreferenceType> type = Optional.empty();

        private Optional<CatalogItemFoodAndBeverageDetailsIngredientStandardIngredient> standardName = Optional.empty();

        private Optional<String> customName = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogItemFoodAndBeverageDetailsIngredient other) {
            type(other.getType());
            standardName(other.getStandardName());
            customName(other.getCustomName());
            return this;
        }

        /**
         * <p>The dietary preference type of the ingredient. Supported values include <code>STANDARD</code> and <code>CUSTOM</code> as specified in <code>FoodAndBeverageDetails.DietaryPreferenceType</code>.
         * See <a href="#type-dietarypreferencetype">DietaryPreferenceType</a> for possible values</p>
         */
        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<CatalogItemFoodAndBeverageDetailsDietaryPreferenceType> type) {
            this.type = type;
            return this;
        }

        public Builder type(CatalogItemFoodAndBeverageDetailsDietaryPreferenceType type) {
            this.type = Optional.ofNullable(type);
            return this;
        }

        /**
         * <p>The name of the ingredient from a standard pre-defined list. This should be null if it's a custom dietary preference.
         * See <a href="#type-standardingredient">StandardIngredient</a> for possible values</p>
         */
        @JsonSetter(value = "standard_name", nulls = Nulls.SKIP)
        public Builder standardName(
                Optional<CatalogItemFoodAndBeverageDetailsIngredientStandardIngredient> standardName) {
            this.standardName = standardName;
            return this;
        }

        public Builder standardName(CatalogItemFoodAndBeverageDetailsIngredientStandardIngredient standardName) {
            this.standardName = Optional.ofNullable(standardName);
            return this;
        }

        /**
         * <p>The name of a custom user-defined ingredient. This should be null if it's a standard dietary preference.</p>
         */
        @JsonSetter(value = "custom_name", nulls = Nulls.SKIP)
        public Builder customName(Optional<String> customName) {
            this.customName = customName;
            return this;
        }

        public Builder customName(String customName) {
            this.customName = Optional.ofNullable(customName);
            return this;
        }

        public Builder customName(Nullable<String> customName) {
            if (customName.isNull()) {
                this.customName = null;
            } else if (customName.isEmpty()) {
                this.customName = Optional.empty();
            } else {
                this.customName = Optional.of(customName.get());
            }
            return this;
        }

        public CatalogItemFoodAndBeverageDetailsIngredient build() {
            return new CatalogItemFoodAndBeverageDetailsIngredient(
                    type, standardName, customName, additionalProperties);
        }
    }
}

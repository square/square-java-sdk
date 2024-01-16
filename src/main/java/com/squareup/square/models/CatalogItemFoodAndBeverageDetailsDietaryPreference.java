
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogItemFoodAndBeverageDetailsDietaryPreference type.
 */
public class CatalogItemFoodAndBeverageDetailsDietaryPreference {
    private final String type;
    private final String standardName;
    private final OptionalNullable<String> customName;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  standardName  String value for standardName.
     * @param  customName  String value for customName.
     */
    @JsonCreator
    public CatalogItemFoodAndBeverageDetailsDietaryPreference(
            @JsonProperty("type") String type,
            @JsonProperty("standard_name") String standardName,
            @JsonProperty("custom_name") String customName) {
        this.type = type;
        this.standardName = standardName;
        this.customName = OptionalNullable.of(customName);
    }

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  standardName  String value for standardName.
     * @param  customName  String value for customName.
     */

    protected CatalogItemFoodAndBeverageDetailsDietaryPreference(String type, String standardName,
            OptionalNullable<String> customName) {
        this.type = type;
        this.standardName = standardName;
        this.customName = customName;
    }

    /**
     * Getter for Type.
     * The type of dietary preference for the `FOOD_AND_BEV` type of items and integredients.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for StandardName.
     * Standard dietary preferences for food and beverage items that are recommended on item
     * creation.
     * @return Returns the String
     */
    @JsonGetter("standard_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStandardName() {
        return standardName;
    }

    /**
     * Internal Getter for CustomName.
     * The name of a user-defined custom dietary preference. This should be null if it's a standard
     * dietary preference.
     * @return Returns the Internal String
     */
    @JsonGetter("custom_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomName() {
        return this.customName;
    }

    /**
     * Getter for CustomName.
     * The name of a user-defined custom dietary preference. This should be null if it's a standard
     * dietary preference.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomName() {
        return OptionalNullable.getFrom(customName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, standardName, customName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItemFoodAndBeverageDetailsDietaryPreference)) {
            return false;
        }
        CatalogItemFoodAndBeverageDetailsDietaryPreference other =
                (CatalogItemFoodAndBeverageDetailsDietaryPreference) obj;
        return Objects.equals(type, other.type)
            && Objects.equals(standardName, other.standardName)
            && Objects.equals(customName, other.customName);
    }

    /**
     * Converts this CatalogItemFoodAndBeverageDetailsDietaryPreference into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItemFoodAndBeverageDetailsDietaryPreference [" + "type=" + type
                + ", standardName=" + standardName + ", customName=" + customName + "]";
    }

    /**
     * Builds a new {@link CatalogItemFoodAndBeverageDetailsDietaryPreference.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemFoodAndBeverageDetailsDietaryPreference.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .type(getType())
                .standardName(getStandardName());
        builder.customName = internalGetCustomName();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemFoodAndBeverageDetailsDietaryPreference}.
     */
    public static class Builder {
        private String type;
        private String standardName;
        private OptionalNullable<String> customName;



        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for standardName.
         * @param  standardName  String value for standardName.
         * @return Builder
         */
        public Builder standardName(String standardName) {
            this.standardName = standardName;
            return this;
        }

        /**
         * Setter for customName.
         * @param  customName  String value for customName.
         * @return Builder
         */
        public Builder customName(String customName) {
            this.customName = OptionalNullable.of(customName);
            return this;
        }

        /**
         * UnSetter for customName.
         * @return Builder
         */
        public Builder unsetCustomName() {
            customName = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemFoodAndBeverageDetailsDietaryPreference} object using the
         * set fields.
         * @return {@link CatalogItemFoodAndBeverageDetailsDietaryPreference}
         */
        public CatalogItemFoodAndBeverageDetailsDietaryPreference build() {
            return new CatalogItemFoodAndBeverageDetailsDietaryPreference(type, standardName,
                    customName);
        }
    }
}

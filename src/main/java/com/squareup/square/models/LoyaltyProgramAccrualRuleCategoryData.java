
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramAccrualRuleCategoryData type.
 */
public class LoyaltyProgramAccrualRuleCategoryData {
    private final String categoryId;

    /**
     * Initialization constructor.
     * @param  categoryId  String value for categoryId.
     */
    @JsonCreator
    public LoyaltyProgramAccrualRuleCategoryData(
            @JsonProperty("category_id") String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Getter for CategoryId.
     * The ID of the `CATEGORY` [catalog object]($m/CatalogObject) that buyers can purchase to earn
     * points.
     * @return Returns the String
     */
    @JsonGetter("category_id")
    public String getCategoryId() {
        return categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramAccrualRuleCategoryData)) {
            return false;
        }
        LoyaltyProgramAccrualRuleCategoryData other = (LoyaltyProgramAccrualRuleCategoryData) obj;
        return Objects.equals(categoryId, other.categoryId);
    }

    /**
     * Converts this LoyaltyProgramAccrualRuleCategoryData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramAccrualRuleCategoryData [" + "categoryId=" + categoryId + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramAccrualRuleCategoryData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramAccrualRuleCategoryData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(categoryId);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramAccrualRuleCategoryData}.
     */
    public static class Builder {
        private String categoryId;

        /**
         * Initialization constructor.
         * @param  categoryId  String value for categoryId.
         */
        public Builder(String categoryId) {
            this.categoryId = categoryId;
        }

        /**
         * Setter for categoryId.
         * @param  categoryId  String value for categoryId.
         * @return Builder
         */
        public Builder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramAccrualRuleCategoryData} object using the set fields.
         * @return {@link LoyaltyProgramAccrualRuleCategoryData}
         */
        public LoyaltyProgramAccrualRuleCategoryData build() {
            return new LoyaltyProgramAccrualRuleCategoryData(categoryId);
        }
    }
}

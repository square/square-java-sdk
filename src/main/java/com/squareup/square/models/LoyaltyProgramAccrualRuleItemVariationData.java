
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramAccrualRuleItemVariationData type.
 */
public class LoyaltyProgramAccrualRuleItemVariationData {
    private final String itemVariationId;

    /**
     * Initialization constructor.
     * @param  itemVariationId  String value for itemVariationId.
     */
    @JsonCreator
    public LoyaltyProgramAccrualRuleItemVariationData(
            @JsonProperty("item_variation_id") String itemVariationId) {
        this.itemVariationId = itemVariationId;
    }

    /**
     * Getter for ItemVariationId.
     * The ID of the `ITEM_VARIATION` [catalog object]($m/CatalogObject) that buyers can purchase to
     * earn points.
     * @return Returns the String
     */
    @JsonGetter("item_variation_id")
    public String getItemVariationId() {
        return itemVariationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemVariationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramAccrualRuleItemVariationData)) {
            return false;
        }
        LoyaltyProgramAccrualRuleItemVariationData other =
                (LoyaltyProgramAccrualRuleItemVariationData) obj;
        return Objects.equals(itemVariationId, other.itemVariationId);
    }

    /**
     * Converts this LoyaltyProgramAccrualRuleItemVariationData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramAccrualRuleItemVariationData [" + "itemVariationId=" + itemVariationId
                + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramAccrualRuleItemVariationData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramAccrualRuleItemVariationData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(itemVariationId);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramAccrualRuleItemVariationData}.
     */
    public static class Builder {
        private String itemVariationId;

        /**
         * Initialization constructor.
         * @param  itemVariationId  String value for itemVariationId.
         */
        public Builder(String itemVariationId) {
            this.itemVariationId = itemVariationId;
        }

        /**
         * Setter for itemVariationId.
         * @param  itemVariationId  String value for itemVariationId.
         * @return Builder
         */
        public Builder itemVariationId(String itemVariationId) {
            this.itemVariationId = itemVariationId;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramAccrualRuleItemVariationData} object using the set
         * fields.
         * @return {@link LoyaltyProgramAccrualRuleItemVariationData}
         */
        public LoyaltyProgramAccrualRuleItemVariationData build() {
            return new LoyaltyProgramAccrualRuleItemVariationData(itemVariationId);
        }
    }
}

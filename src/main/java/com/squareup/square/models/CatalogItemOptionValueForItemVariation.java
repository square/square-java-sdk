package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogItemOptionValueForItemVariation type.
 */
public class CatalogItemOptionValueForItemVariation {

    /**
     * Initialization constructor.
     * @param itemOptionId
     * @param itemOptionValueId
     */
    @JsonCreator
    public CatalogItemOptionValueForItemVariation(
            @JsonProperty("item_option_id") String itemOptionId,
            @JsonProperty("item_option_value_id") String itemOptionValueId) {
        this.itemOptionId = itemOptionId;
        this.itemOptionValueId = itemOptionValueId;
    }

    private final String itemOptionId;
    private final String itemOptionValueId;
    /**
     * Getter for ItemOptionId.
     * The unique id of an item option.
     */
    @JsonGetter("item_option_id")
    public String getItemOptionId() {
        return this.itemOptionId;
    }

    /**
     * Getter for ItemOptionValueId.
     * The unique id of the selected value for the item option.
     */
    @JsonGetter("item_option_value_id")
    public String getItemOptionValueId() {
        return this.itemOptionValueId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId, itemOptionValueId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogItemOptionValueForItemVariation)) {
            return false;
        }
        CatalogItemOptionValueForItemVariation catalogItemOptionValueForItemVariation = (CatalogItemOptionValueForItemVariation) obj;
        return Objects.equals(itemOptionId, catalogItemOptionValueForItemVariation.itemOptionId) &&
            Objects.equals(itemOptionValueId, catalogItemOptionValueForItemVariation.itemOptionValueId);
    }

    /**
     * Builds a new {@link CatalogItemOptionValueForItemVariation.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemOptionValueForItemVariation.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionId(getItemOptionId())
            .itemOptionValueId(getItemOptionValueId());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOptionValueForItemVariation}
     */
    public static class Builder {
        private String itemOptionId;
        private String itemOptionValueId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for itemOptionId
         * @param itemOptionId
         * @return Builder
         */
        public Builder itemOptionId(String itemOptionId) {
            this.itemOptionId = itemOptionId;
            return this;
        }
        /**
         * Setter for itemOptionValueId
         * @param itemOptionValueId
         * @return Builder
         */
        public Builder itemOptionValueId(String itemOptionValueId) {
            this.itemOptionValueId = itemOptionValueId;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemOptionValueForItemVariation} object using the set fields.
         * @return {@link CatalogItemOptionValueForItemVariation}
         */
        public CatalogItemOptionValueForItemVariation build() {
            return new CatalogItemOptionValueForItemVariation(itemOptionId,
                itemOptionValueId);
        }
    }
}

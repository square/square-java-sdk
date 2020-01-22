package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryItemVariationsForItemOptionValues type.
 */
public class CatalogQueryItemVariationsForItemOptionValues {

    /**
     * Initialization constructor.
     * @param itemOptionValueIds
     */
    @JsonCreator
    public CatalogQueryItemVariationsForItemOptionValues(
            @JsonProperty("item_option_value_ids") List<String> itemOptionValueIds) {
        this.itemOptionValueIds = itemOptionValueIds;
    }

    private final List<String> itemOptionValueIds;
    /**
     * Getter for ItemOptionValueIds.
     * A set of `CatalogItemOptionValue` IDs to be used to find associated
     * `CatalogItemVariation`s. All ItemVariations that contain all of the given
     * Item Option Values (in any order) will be returned.
     */
    @JsonGetter("item_option_value_ids")
    public List<String> getItemOptionValueIds() {
        return this.itemOptionValueIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(itemOptionValueIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryItemVariationsForItemOptionValues)) {
            return false;
        }
        CatalogQueryItemVariationsForItemOptionValues catalogQueryItemVariationsForItemOptionValues = (CatalogQueryItemVariationsForItemOptionValues) obj;
        return Objects.equals(itemOptionValueIds, catalogQueryItemVariationsForItemOptionValues.itemOptionValueIds);
    }

    /**
     * Builds a new {@link CatalogQueryItemVariationsForItemOptionValues.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryItemVariationsForItemOptionValues.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionValueIds(getItemOptionValueIds());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryItemVariationsForItemOptionValues}
     */
    public static class Builder {
        private List<String> itemOptionValueIds;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for itemOptionValueIds
         * @param itemOptionValueIds
         * @return Builder
         */
        public Builder itemOptionValueIds(List<String> itemOptionValueIds) {
            this.itemOptionValueIds = itemOptionValueIds;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryItemVariationsForItemOptionValues} object using the set fields.
         * @return {@link CatalogQueryItemVariationsForItemOptionValues}
         */
        public CatalogQueryItemVariationsForItemOptionValues build() {
            return new CatalogQueryItemVariationsForItemOptionValues(itemOptionValueIds);
        }
    }
}

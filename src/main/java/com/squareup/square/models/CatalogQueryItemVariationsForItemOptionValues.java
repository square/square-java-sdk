
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogQueryItemVariationsForItemOptionValues type.
 */
public class CatalogQueryItemVariationsForItemOptionValues {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> itemOptionValueIds;

    /**
     * Initialization constructor.
     * @param  itemOptionValueIds  List of String value for itemOptionValueIds.
     */
    @JsonCreator
    public CatalogQueryItemVariationsForItemOptionValues(
            @JsonProperty("item_option_value_ids") List<String> itemOptionValueIds) {
        this.itemOptionValueIds = itemOptionValueIds;
    }

    /**
     * Getter for ItemOptionValueIds.
     * A set of `CatalogItemOptionValue` IDs to be used to find associated `CatalogItemVariation`s.
     * All ItemVariations that contain all of the given Item Option Values (in any order) will be
     * returned.
     * @return Returns the List of String
     */
    @JsonGetter("item_option_value_ids")
    public List<String> getItemOptionValueIds() {
        return itemOptionValueIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionValueIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQueryItemVariationsForItemOptionValues)) {
            return false;
        }
        CatalogQueryItemVariationsForItemOptionValues other =
                (CatalogQueryItemVariationsForItemOptionValues) obj;
        return Objects.equals(itemOptionValueIds, other.itemOptionValueIds);
    }

    /**
     * Converts this CatalogQueryItemVariationsForItemOptionValues into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogQueryItemVariationsForItemOptionValues [" + "itemOptionValueIds="
                + itemOptionValueIds + "]";
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
     * Class to build instances of {@link CatalogQueryItemVariationsForItemOptionValues}.
     */
    public static class Builder {
        private List<String> itemOptionValueIds;



        /**
         * Setter for itemOptionValueIds.
         * @param  itemOptionValueIds  List of String value for itemOptionValueIds.
         * @return Builder
         */
        public Builder itemOptionValueIds(List<String> itemOptionValueIds) {
            this.itemOptionValueIds = itemOptionValueIds;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryItemVariationsForItemOptionValues} object using the set
         * fields.
         * @return {@link CatalogQueryItemVariationsForItemOptionValues}
         */
        public CatalogQueryItemVariationsForItemOptionValues build() {
            return new CatalogQueryItemVariationsForItemOptionValues(itemOptionValueIds);
        }
    }
}

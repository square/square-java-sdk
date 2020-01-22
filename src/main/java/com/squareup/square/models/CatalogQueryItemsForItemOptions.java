package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryItemsForItemOptions type.
 */
public class CatalogQueryItemsForItemOptions {

    /**
     * Initialization constructor.
     * @param itemOptionIds
     */
    @JsonCreator
    public CatalogQueryItemsForItemOptions(
            @JsonProperty("item_option_ids") List<String> itemOptionIds) {
        this.itemOptionIds = itemOptionIds;
    }

    private final List<String> itemOptionIds;
    /**
     * Getter for ItemOptionIds.
     * A set of `CatalogItemOption` IDs to be used to find associated
     * `CatalogItem`s. All Items that contain all of the given Item Options (in any order)
     * will be returned.
     */
    @JsonGetter("item_option_ids")
    public List<String> getItemOptionIds() {
        return this.itemOptionIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(itemOptionIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryItemsForItemOptions)) {
            return false;
        }
        CatalogQueryItemsForItemOptions catalogQueryItemsForItemOptions = (CatalogQueryItemsForItemOptions) obj;
        return Objects.equals(itemOptionIds, catalogQueryItemsForItemOptions.itemOptionIds);
    }

    /**
     * Builds a new {@link CatalogQueryItemsForItemOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryItemsForItemOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionIds(getItemOptionIds());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryItemsForItemOptions}
     */
    public static class Builder {
        private List<String> itemOptionIds;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for itemOptionIds
         * @param itemOptionIds
         * @return Builder
         */
        public Builder itemOptionIds(List<String> itemOptionIds) {
            this.itemOptionIds = itemOptionIds;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryItemsForItemOptions} object using the set fields.
         * @return {@link CatalogQueryItemsForItemOptions}
         */
        public CatalogQueryItemsForItemOptions build() {
            return new CatalogQueryItemsForItemOptions(itemOptionIds);
        }
    }
}

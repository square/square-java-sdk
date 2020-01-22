package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogItemOptionForItem type.
 */
public class CatalogItemOptionForItem {

    /**
     * Initialization constructor.
     * @param itemOptionId
     */
    @JsonCreator
    public CatalogItemOptionForItem(
            @JsonProperty("item_option_id") String itemOptionId) {
        this.itemOptionId = itemOptionId;
    }

    private final String itemOptionId;
    /**
     * Getter for ItemOptionId.
     * The unique id of the item option, used to form the dimensions of the item option matrix in a specified order.
     */
    @JsonGetter("item_option_id")
    public String getItemOptionId() {
        return this.itemOptionId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogItemOptionForItem)) {
            return false;
        }
        CatalogItemOptionForItem catalogItemOptionForItem = (CatalogItemOptionForItem) obj;
        return Objects.equals(itemOptionId, catalogItemOptionForItem.itemOptionId);
    }

    /**
     * Builds a new {@link CatalogItemOptionForItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemOptionForItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionId(getItemOptionId());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOptionForItem}
     */
    public static class Builder {
        private String itemOptionId;

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
         * Builds a new {@link CatalogItemOptionForItem} object using the set fields.
         * @return {@link CatalogItemOptionForItem}
         */
        public CatalogItemOptionForItem build() {
            return new CatalogItemOptionForItem(itemOptionId);
        }
    }
}

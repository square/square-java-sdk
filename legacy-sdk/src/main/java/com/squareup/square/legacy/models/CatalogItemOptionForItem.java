package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogItemOptionForItem type.
 */
public class CatalogItemOptionForItem {
    private final OptionalNullable<String> itemOptionId;

    /**
     * Initialization constructor.
     * @param  itemOptionId  String value for itemOptionId.
     */
    @JsonCreator
    public CatalogItemOptionForItem(@JsonProperty("item_option_id") String itemOptionId) {
        this.itemOptionId = OptionalNullable.of(itemOptionId);
    }

    /**
     * Initialization constructor.
     * @param  itemOptionId  String value for itemOptionId.
     */
    protected CatalogItemOptionForItem(OptionalNullable<String> itemOptionId) {
        this.itemOptionId = itemOptionId;
    }

    /**
     * Internal Getter for ItemOptionId.
     * The unique id of the item option, used to form the dimensions of the item option matrix in a
     * specified order.
     * @return Returns the Internal String
     */
    @JsonGetter("item_option_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetItemOptionId() {
        return this.itemOptionId;
    }

    /**
     * Getter for ItemOptionId.
     * The unique id of the item option, used to form the dimensions of the item option matrix in a
     * specified order.
     * @return Returns the String
     */
    @JsonIgnore
    public String getItemOptionId() {
        return OptionalNullable.getFrom(itemOptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItemOptionForItem)) {
            return false;
        }
        CatalogItemOptionForItem other = (CatalogItemOptionForItem) obj;
        return Objects.equals(itemOptionId, other.itemOptionId);
    }

    /**
     * Converts this CatalogItemOptionForItem into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItemOptionForItem [" + "itemOptionId=" + itemOptionId + "]";
    }

    /**
     * Builds a new {@link CatalogItemOptionForItem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemOptionForItem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.itemOptionId = internalGetItemOptionId();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOptionForItem}.
     */
    public static class Builder {
        private OptionalNullable<String> itemOptionId;

        /**
         * Setter for itemOptionId.
         * @param  itemOptionId  String value for itemOptionId.
         * @return Builder
         */
        public Builder itemOptionId(String itemOptionId) {
            this.itemOptionId = OptionalNullable.of(itemOptionId);
            return this;
        }

        /**
         * UnSetter for itemOptionId.
         * @return Builder
         */
        public Builder unsetItemOptionId() {
            itemOptionId = null;
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

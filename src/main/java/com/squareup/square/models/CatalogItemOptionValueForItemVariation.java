
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
 * This is a model class for CatalogItemOptionValueForItemVariation type.
 */
public class CatalogItemOptionValueForItemVariation {
    private final OptionalNullable<String> itemOptionId;
    private final OptionalNullable<String> itemOptionValueId;

    /**
     * Initialization constructor.
     * @param  itemOptionId  String value for itemOptionId.
     * @param  itemOptionValueId  String value for itemOptionValueId.
     */
    @JsonCreator
    public CatalogItemOptionValueForItemVariation(
            @JsonProperty("item_option_id") String itemOptionId,
            @JsonProperty("item_option_value_id") String itemOptionValueId) {
        this.itemOptionId = OptionalNullable.of(itemOptionId);
        this.itemOptionValueId = OptionalNullable.of(itemOptionValueId);
    }

    /**
     * Initialization constructor.
     * @param  itemOptionId  String value for itemOptionId.
     * @param  itemOptionValueId  String value for itemOptionValueId.
     */

    protected CatalogItemOptionValueForItemVariation(OptionalNullable<String> itemOptionId,
            OptionalNullable<String> itemOptionValueId) {
        this.itemOptionId = itemOptionId;
        this.itemOptionValueId = itemOptionValueId;
    }

    /**
     * Internal Getter for ItemOptionId.
     * The unique id of an item option.
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
     * The unique id of an item option.
     * @return Returns the String
     */
    @JsonIgnore
    public String getItemOptionId() {
        return OptionalNullable.getFrom(itemOptionId);
    }

    /**
     * Internal Getter for ItemOptionValueId.
     * The unique id of the selected value for the item option.
     * @return Returns the Internal String
     */
    @JsonGetter("item_option_value_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetItemOptionValueId() {
        return this.itemOptionValueId;
    }

    /**
     * Getter for ItemOptionValueId.
     * The unique id of the selected value for the item option.
     * @return Returns the String
     */
    @JsonIgnore
    public String getItemOptionValueId() {
        return OptionalNullable.getFrom(itemOptionValueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId, itemOptionValueId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItemOptionValueForItemVariation)) {
            return false;
        }
        CatalogItemOptionValueForItemVariation other = (CatalogItemOptionValueForItemVariation) obj;
        return Objects.equals(itemOptionId, other.itemOptionId)
            && Objects.equals(itemOptionValueId, other.itemOptionValueId);
    }

    /**
     * Converts this CatalogItemOptionValueForItemVariation into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItemOptionValueForItemVariation [" + "itemOptionId=" + itemOptionId
                + ", itemOptionValueId=" + itemOptionValueId + "]";
    }

    /**
     * Builds a new {@link CatalogItemOptionValueForItemVariation.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemOptionValueForItemVariation.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.itemOptionId = internalGetItemOptionId();
        builder.itemOptionValueId = internalGetItemOptionValueId();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOptionValueForItemVariation}.
     */
    public static class Builder {
        private OptionalNullable<String> itemOptionId;
        private OptionalNullable<String> itemOptionValueId;



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
         * Setter for itemOptionValueId.
         * @param  itemOptionValueId  String value for itemOptionValueId.
         * @return Builder
         */
        public Builder itemOptionValueId(String itemOptionValueId) {
            this.itemOptionValueId = OptionalNullable.of(itemOptionValueId);
            return this;
        }

        /**
         * UnSetter for itemOptionValueId.
         * @return Builder
         */
        public Builder unsetItemOptionValueId() {
            itemOptionValueId = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemOptionValueForItemVariation} object using the set fields.
         * @return {@link CatalogItemOptionValueForItemVariation}
         */
        public CatalogItemOptionValueForItemVariation build() {
            return new CatalogItemOptionValueForItemVariation(itemOptionId, itemOptionValueId);
        }
    }
}

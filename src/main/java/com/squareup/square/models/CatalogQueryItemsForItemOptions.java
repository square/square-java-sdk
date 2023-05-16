
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogQueryItemsForItemOptions type.
 */
public class CatalogQueryItemsForItemOptions {
    private final OptionalNullable<List<String>> itemOptionIds;

    /**
     * Initialization constructor.
     * @param  itemOptionIds  List of String value for itemOptionIds.
     */
    @JsonCreator
    public CatalogQueryItemsForItemOptions(
            @JsonProperty("item_option_ids") List<String> itemOptionIds) {
        this.itemOptionIds = OptionalNullable.of(itemOptionIds);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogQueryItemsForItemOptions(OptionalNullable<List<String>> itemOptionIds) {
        this.itemOptionIds = itemOptionIds;
    }

    /**
     * Internal Getter for ItemOptionIds.
     * A set of `CatalogItemOption` IDs to be used to find associated `CatalogItem`s. All Items that
     * contain all of the given Item Options (in any order) will be returned.
     * @return Returns the Internal List of String
     */
    @JsonGetter("item_option_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetItemOptionIds() {
        return this.itemOptionIds;
    }

    /**
     * Getter for ItemOptionIds.
     * A set of `CatalogItemOption` IDs to be used to find associated `CatalogItem`s. All Items that
     * contain all of the given Item Options (in any order) will be returned.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getItemOptionIds() {
        return OptionalNullable.getFrom(itemOptionIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQueryItemsForItemOptions)) {
            return false;
        }
        CatalogQueryItemsForItemOptions other = (CatalogQueryItemsForItemOptions) obj;
        return Objects.equals(itemOptionIds, other.itemOptionIds);
    }

    /**
     * Converts this CatalogQueryItemsForItemOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogQueryItemsForItemOptions [" + "itemOptionIds=" + itemOptionIds + "]";
    }

    /**
     * Builds a new {@link CatalogQueryItemsForItemOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryItemsForItemOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.itemOptionIds = internalGetItemOptionIds();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryItemsForItemOptions}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> itemOptionIds;



        /**
         * Setter for itemOptionIds.
         * @param  itemOptionIds  List of String value for itemOptionIds.
         * @return Builder
         */
        public Builder itemOptionIds(List<String> itemOptionIds) {
            this.itemOptionIds = OptionalNullable.of(itemOptionIds);
            return this;
        }

        /**
         * UnSetter for itemOptionIds.
         * @return Builder
         */
        public Builder unsetItemOptionIds() {
            itemOptionIds = null;
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

package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryItemVariationsForItemOptionValues {

    @JsonCreator
    public CatalogQueryItemVariationsForItemOptionValues(
            @JsonProperty("item_option_value_ids") List<String> itemOptionValueIds) {
        this.itemOptionValueIds = itemOptionValueIds;
    }

    private final List<String> itemOptionValueIds;

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionValueIds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryItemVariationsForItemOptionValues)) {
            return false;
        }
        CatalogQueryItemVariationsForItemOptionValues catalogQueryItemVariationsForItemOptionValues = (CatalogQueryItemVariationsForItemOptionValues) o;
        return Objects.equals(itemOptionValueIds, catalogQueryItemVariationsForItemOptionValues.itemOptionValueIds);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionValueIds(getItemOptionValueIds());
            return builder;
    }

    public static class Builder {
        private List<String> itemOptionValueIds;

        public Builder() { }

        public Builder itemOptionValueIds(List<String> value) {
            itemOptionValueIds = value;
            return this;
        }

        public CatalogQueryItemVariationsForItemOptionValues build() {
            return new CatalogQueryItemVariationsForItemOptionValues(itemOptionValueIds);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogQueryItemsForItemOptions {

    @JsonCreator
    public CatalogQueryItemsForItemOptions(
            @JsonProperty("item_option_ids") List<String> itemOptionIds) {
        this.itemOptionIds = itemOptionIds;
    }

    private final List<String> itemOptionIds;

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionIds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogQueryItemsForItemOptions)) {
            return false;
        }
        CatalogQueryItemsForItemOptions catalogQueryItemsForItemOptions = (CatalogQueryItemsForItemOptions) o;
        return Objects.equals(itemOptionIds, catalogQueryItemsForItemOptions.itemOptionIds);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionIds(getItemOptionIds());
            return builder;
    }

    public static class Builder {
        private List<String> itemOptionIds;

        public Builder() { }

        public Builder itemOptionIds(List<String> value) {
            itemOptionIds = value;
            return this;
        }

        public CatalogQueryItemsForItemOptions build() {
            return new CatalogQueryItemsForItemOptions(itemOptionIds);
        }
    }
}

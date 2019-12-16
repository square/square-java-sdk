package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogItemOptionForItem {

    @JsonCreator
    public CatalogItemOptionForItem(
            @JsonProperty("item_option_id") String itemOptionId) {
        this.itemOptionId = itemOptionId;
    }

    private final String itemOptionId;

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogItemOptionForItem)) {
            return false;
        }
        CatalogItemOptionForItem catalogItemOptionForItem = (CatalogItemOptionForItem) o;
        return Objects.equals(itemOptionId, catalogItemOptionForItem.itemOptionId);
    }

    /**
     * Getter for ItemOptionId.
     * The unique id of the item option, used to form the dimensions of the item option matrix in a specified order.
     */
    @JsonGetter("item_option_id")
    public String getItemOptionId() { 
        return this.itemOptionId;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionId(getItemOptionId());
            return builder;
    }

    public static class Builder {
        private String itemOptionId;

        public Builder() { }

        public Builder itemOptionId(String value) {
            itemOptionId = value;
            return this;
        }

        public CatalogItemOptionForItem build() {
            return new CatalogItemOptionForItem(itemOptionId);
        }
    }
}

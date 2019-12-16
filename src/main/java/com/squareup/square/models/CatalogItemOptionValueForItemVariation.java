package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogItemOptionValueForItemVariation {

    @JsonCreator
    public CatalogItemOptionValueForItemVariation(
            @JsonProperty("item_option_id") String itemOptionId,
            @JsonProperty("item_option_value_id") String itemOptionValueId) {
        this.itemOptionId = itemOptionId;
        this.itemOptionValueId = itemOptionValueId;
    }

    private final String itemOptionId;
    private final String itemOptionValueId;

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId, itemOptionValueId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogItemOptionValueForItemVariation)) {
            return false;
        }
        CatalogItemOptionValueForItemVariation catalogItemOptionValueForItemVariation = (CatalogItemOptionValueForItemVariation) o;
        return Objects.equals(itemOptionId, catalogItemOptionValueForItemVariation.itemOptionId) &&
            Objects.equals(itemOptionValueId, catalogItemOptionValueForItemVariation.itemOptionValueId);
    }

    /**
     * Getter for ItemOptionId.
     * The unique id of an item option.
     */
    @JsonGetter("item_option_id")
    public String getItemOptionId() { 
        return this.itemOptionId;
    }

    /**
     * Getter for ItemOptionValueId.
     * The unique id of the selected value for the item option.
     */
    @JsonGetter("item_option_value_id")
    public String getItemOptionValueId() { 
        return this.itemOptionValueId;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionId(getItemOptionId())
            .itemOptionValueId(getItemOptionValueId());
            return builder;
    }

    public static class Builder {
        private String itemOptionId;
        private String itemOptionValueId;

        public Builder() { }

        public Builder itemOptionId(String value) {
            itemOptionId = value;
            return this;
        }
        public Builder itemOptionValueId(String value) {
            itemOptionValueId = value;
            return this;
        }

        public CatalogItemOptionValueForItemVariation build() {
            return new CatalogItemOptionValueForItemVariation(itemOptionId,
                itemOptionValueId);
        }
    }
}

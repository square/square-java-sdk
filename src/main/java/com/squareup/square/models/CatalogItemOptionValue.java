package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogItemOptionValue {

    @JsonCreator
    public CatalogItemOptionValue(
            @JsonProperty("item_option_id") String itemOptionId,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("color") String color,
            @JsonProperty("ordinal") Integer ordinal,
            @JsonProperty("item_variation_count") Long itemVariationCount) {
        this.itemOptionId = itemOptionId;
        this.name = name;
        this.description = description;
        this.color = color;
        this.ordinal = ordinal;
        this.itemVariationCount = itemVariationCount;
    }

    private final String itemOptionId;
    private final String name;
    private final String description;
    private final String color;
    private final Integer ordinal;
    private final Long itemVariationCount;

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId, name, description, color, ordinal, itemVariationCount);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogItemOptionValue)) {
            return false;
        }
        CatalogItemOptionValue catalogItemOptionValue = (CatalogItemOptionValue) o;
        return Objects.equals(itemOptionId, catalogItemOptionValue.itemOptionId) &&
            Objects.equals(name, catalogItemOptionValue.name) &&
            Objects.equals(description, catalogItemOptionValue.description) &&
            Objects.equals(color, catalogItemOptionValue.color) &&
            Objects.equals(ordinal, catalogItemOptionValue.ordinal) &&
            Objects.equals(itemVariationCount, catalogItemOptionValue.itemVariationCount);
    }

    /**
     * Getter for ItemOptionId.
     * Unique ID of the associated item option.
     */
    @JsonGetter("item_option_id")
    public String getItemOptionId() { 
        return this.itemOptionId;
    }

    /**
     * Getter for Name.
     * Name of this item option value. Searchable.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Description.
     * A human-readable description for the option value.
     */
    @JsonGetter("description")
    public String getDescription() { 
        return this.description;
    }

    /**
     * Getter for Color.
     * The HTML-supported hex color for the item option (e.g., "#ff8d4e85").
     * Only displayed if `show_colors` is enabled on the parent `ItemOption`. When
     * left unset, `color` defaults to white ("#ffffff") when `show_colors` is
     * enabled on the parent `ItemOption`.
     */
    @JsonGetter("color")
    public String getColor() { 
        return this.color;
    }

    /**
     * Getter for Ordinal.
     * Determines where this option value appears in a list of option values.
     */
    @JsonGetter("ordinal")
    public Integer getOrdinal() { 
        return this.ordinal;
    }

    /**
     * Getter for ItemVariationCount.
     * The number of `CatalogItemVariation`s that
     * currently make use of this Item Option value. Present only if `retrieve_counts`
     * was specified on the request used to retrieve the parent Item Option of this
     * value.
     * Maximum: 100 counts.
     */
    @JsonGetter("item_variation_count")
    public Long getItemVariationCount() { 
        return this.itemVariationCount;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .itemOptionId(getItemOptionId())
            .name(getName())
            .description(getDescription())
            .color(getColor())
            .ordinal(getOrdinal())
            .itemVariationCount(getItemVariationCount());
            return builder;
    }

    public static class Builder {
        private String itemOptionId;
        private String name;
        private String description;
        private String color;
        private Integer ordinal;
        private Long itemVariationCount;

        public Builder() { }

        public Builder itemOptionId(String value) {
            itemOptionId = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder description(String value) {
            description = value;
            return this;
        }
        public Builder color(String value) {
            color = value;
            return this;
        }
        public Builder ordinal(Integer value) {
            ordinal = value;
            return this;
        }
        public Builder itemVariationCount(Long value) {
            itemVariationCount = value;
            return this;
        }

        public CatalogItemOptionValue build() {
            return new CatalogItemOptionValue(itemOptionId,
                name,
                description,
                color,
                ordinal,
                itemVariationCount);
        }
    }
}

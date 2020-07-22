package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogItemOptionValue type.
 */
public class CatalogItemOptionValue {

    /**
     * Initialization constructor.
     * @param itemOptionId
     * @param name
     * @param description
     * @param color
     * @param ordinal
     * @param itemVariationCount
     */
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
     * Name of this item option value. This is a searchable attribute for use in applicable query filters.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Description.
     * A human-readable description for the option value. This is a searchable attribute for use in applicable query filters.
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
     * currently use this item option value. Present only if `retrieve_counts`
     * was specified on the request used to retrieve the parent item option of this
     * value.
     */
    @JsonGetter("item_variation_count")
    public Long getItemVariationCount() {
        return this.itemVariationCount;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId, name, description, color, ordinal, itemVariationCount);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogItemOptionValue)) {
            return false;
        }
        CatalogItemOptionValue catalogItemOptionValue = (CatalogItemOptionValue) obj;
        return Objects.equals(itemOptionId, catalogItemOptionValue.itemOptionId) &&
            Objects.equals(name, catalogItemOptionValue.name) &&
            Objects.equals(description, catalogItemOptionValue.description) &&
            Objects.equals(color, catalogItemOptionValue.color) &&
            Objects.equals(ordinal, catalogItemOptionValue.ordinal) &&
            Objects.equals(itemVariationCount, catalogItemOptionValue.itemVariationCount);
    }

    /**
     * Builds a new {@link CatalogItemOptionValue.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemOptionValue.Builder} object
     */
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

    /**
     * Class to build instances of {@link CatalogItemOptionValue}
     */
    public static class Builder {
        private String itemOptionId;
        private String name;
        private String description;
        private String color;
        private Integer ordinal;
        private Long itemVariationCount;

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
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for description
         * @param description
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        /**
         * Setter for color
         * @param color
         * @return Builder
         */
        public Builder color(String color) {
            this.color = color;
            return this;
        }
        /**
         * Setter for ordinal
         * @param ordinal
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = ordinal;
            return this;
        }
        /**
         * Setter for itemVariationCount
         * @param itemVariationCount
         * @return Builder
         */
        public Builder itemVariationCount(Long itemVariationCount) {
            this.itemVariationCount = itemVariationCount;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemOptionValue} object using the set fields.
         * @return {@link CatalogItemOptionValue}
         */
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

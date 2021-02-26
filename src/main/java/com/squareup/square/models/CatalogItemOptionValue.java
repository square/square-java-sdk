
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogItemOptionValue type.
 */
public class CatalogItemOptionValue {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String itemOptionId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String color;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer ordinal;

    /**
     * Initialization constructor.
     * @param  itemOptionId  String value for itemOptionId.
     * @param  name  String value for name.
     * @param  description  String value for description.
     * @param  color  String value for color.
     * @param  ordinal  Integer value for ordinal.
     */
    @JsonCreator
    public CatalogItemOptionValue(
            @JsonProperty("item_option_id") String itemOptionId,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("color") String color,
            @JsonProperty("ordinal") Integer ordinal) {
        this.itemOptionId = itemOptionId;
        this.name = name;
        this.description = description;
        this.color = color;
        this.ordinal = ordinal;
    }

    /**
     * Getter for ItemOptionId.
     * Unique ID of the associated item option.
     * @return Returns the String
     */
    @JsonGetter("item_option_id")
    public String getItemOptionId() {
        return itemOptionId;
    }

    /**
     * Getter for Name.
     * Name of this item option value. This is a searchable attribute for use in applicable query
     * filters.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Description.
     * A human-readable description for the option value. This is a searchable attribute for use in
     * applicable query filters.
     * @return Returns the String
     */
    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    /**
     * Getter for Color.
     * The HTML-supported hex color for the item option (e.g., "#ff8d4e85"). Only displayed if
     * `show_colors` is enabled on the parent `ItemOption`. When left unset, `color` defaults to
     * white ("#ffffff") when `show_colors` is enabled on the parent `ItemOption`.
     * @return Returns the String
     */
    @JsonGetter("color")
    public String getColor() {
        return color;
    }

    /**
     * Getter for Ordinal.
     * Determines where this option value appears in a list of option values.
     * @return Returns the Integer
     */
    @JsonGetter("ordinal")
    public Integer getOrdinal() {
        return ordinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemOptionId, name, description, color, ordinal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItemOptionValue)) {
            return false;
        }
        CatalogItemOptionValue other = (CatalogItemOptionValue) obj;
        return Objects.equals(itemOptionId, other.itemOptionId)
            && Objects.equals(name, other.name)
            && Objects.equals(description, other.description)
            && Objects.equals(color, other.color)
            && Objects.equals(ordinal, other.ordinal);
    }

    /**
     * Converts this CatalogItemOptionValue into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItemOptionValue [" + "itemOptionId=" + itemOptionId + ", name=" + name
                + ", description=" + description + ", color=" + color + ", ordinal=" + ordinal
                + "]";
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
                .ordinal(getOrdinal());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOptionValue}.
     */
    public static class Builder {
        private String itemOptionId;
        private String name;
        private String description;
        private String color;
        private Integer ordinal;



        /**
         * Setter for itemOptionId.
         * @param  itemOptionId  String value for itemOptionId.
         * @return Builder
         */
        public Builder itemOptionId(String itemOptionId) {
            this.itemOptionId = itemOptionId;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Setter for color.
         * @param  color  String value for color.
         * @return Builder
         */
        public Builder color(String color) {
            this.color = color;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  Integer value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemOptionValue} object using the set fields.
         * @return {@link CatalogItemOptionValue}
         */
        public CatalogItemOptionValue build() {
            return new CatalogItemOptionValue(itemOptionId, name, description, color, ordinal);
        }
    }
}

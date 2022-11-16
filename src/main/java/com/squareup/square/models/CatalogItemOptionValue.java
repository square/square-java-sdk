
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogItemOptionValue type.
 */
public class CatalogItemOptionValue {
    private final OptionalNullable<String> itemOptionId;
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> description;
    private final OptionalNullable<String> color;
    private final OptionalNullable<Integer> ordinal;

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
        this.itemOptionId = OptionalNullable.of(itemOptionId);
        this.name = OptionalNullable.of(name);
        this.description = OptionalNullable.of(description);
        this.color = OptionalNullable.of(color);
        this.ordinal = OptionalNullable.of(ordinal);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogItemOptionValue(OptionalNullable<String> itemOptionId,
            OptionalNullable<String> name, OptionalNullable<String> description,
            OptionalNullable<String> color, OptionalNullable<Integer> ordinal) {
        this.itemOptionId = itemOptionId;
        this.name = name;
        this.description = description;
        this.color = color;
        this.ordinal = ordinal;
    }

    /**
     * Internal Getter for ItemOptionId.
     * Unique ID of the associated item option.
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
     * Unique ID of the associated item option.
     * @return Returns the String
     */
    @JsonIgnore
    public String getItemOptionId() {
        return OptionalNullable.getFrom(itemOptionId);
    }

    /**
     * Internal Getter for Name.
     * Name of this item option value. This is a searchable attribute for use in applicable query
     * filters.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * Name of this item option value. This is a searchable attribute for use in applicable query
     * filters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for Description.
     * A human-readable description for the option value. This is a searchable attribute for use in
     * applicable query filters.
     * @return Returns the Internal String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDescription() {
        return this.description;
    }

    /**
     * Getter for Description.
     * A human-readable description for the option value. This is a searchable attribute for use in
     * applicable query filters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDescription() {
        return OptionalNullable.getFrom(description);
    }

    /**
     * Internal Getter for Color.
     * The HTML-supported hex color for the item option (e.g., "#ff8d4e85"). Only displayed if
     * `show_colors` is enabled on the parent `ItemOption`. When left unset, `color` defaults to
     * white ("#ffffff") when `show_colors` is enabled on the parent `ItemOption`.
     * @return Returns the Internal String
     */
    @JsonGetter("color")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetColor() {
        return this.color;
    }

    /**
     * Getter for Color.
     * The HTML-supported hex color for the item option (e.g., "#ff8d4e85"). Only displayed if
     * `show_colors` is enabled on the parent `ItemOption`. When left unset, `color` defaults to
     * white ("#ffffff") when `show_colors` is enabled on the parent `ItemOption`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getColor() {
        return OptionalNullable.getFrom(color);
    }

    /**
     * Internal Getter for Ordinal.
     * Determines where this option value appears in a list of option values.
     * @return Returns the Internal Integer
     */
    @JsonGetter("ordinal")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for Ordinal.
     * Determines where this option value appears in a list of option values.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getOrdinal() {
        return OptionalNullable.getFrom(ordinal);
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
        Builder builder = new Builder();
        builder.itemOptionId = internalGetItemOptionId();
        builder.name = internalGetName();
        builder.description = internalGetDescription();
        builder.color = internalGetColor();
        builder.ordinal = internalGetOrdinal();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemOptionValue}.
     */
    public static class Builder {
        private OptionalNullable<String> itemOptionId;
        private OptionalNullable<String> name;
        private OptionalNullable<String> description;
        private OptionalNullable<String> color;
        private OptionalNullable<Integer> ordinal;



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
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = OptionalNullable.of(description);
            return this;
        }

        /**
         * UnSetter for description.
         * @return Builder
         */
        public Builder unsetDescription() {
            description = null;
            return this;
        }

        /**
         * Setter for color.
         * @param  color  String value for color.
         * @return Builder
         */
        public Builder color(String color) {
            this.color = OptionalNullable.of(color);
            return this;
        }

        /**
         * UnSetter for color.
         * @return Builder
         */
        public Builder unsetColor() {
            color = null;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  Integer value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = OptionalNullable.of(ordinal);
            return this;
        }

        /**
         * UnSetter for ordinal.
         * @return Builder
         */
        public Builder unsetOrdinal() {
            ordinal = null;
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

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogItemOptionValue.Builder.class)
public final class CatalogItemOptionValue {
    private final Optional<String> itemOptionId;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<String> color;

    private final Optional<Integer> ordinal;

    private final Map<String, Object> additionalProperties;

    private CatalogItemOptionValue(
            Optional<String> itemOptionId,
            Optional<String> name,
            Optional<String> description,
            Optional<String> color,
            Optional<Integer> ordinal,
            Map<String, Object> additionalProperties) {
        this.itemOptionId = itemOptionId;
        this.name = name;
        this.description = description;
        this.color = color;
        this.ordinal = ordinal;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Unique ID of the associated item option.
     */
    @JsonIgnore
    public Optional<String> getItemOptionId() {
        if (itemOptionId == null) {
            return Optional.empty();
        }
        return itemOptionId;
    }

    /**
     * @return Name of this item option value. This is a searchable attribute for use in applicable query filters.
     */
    @JsonIgnore
    public Optional<String> getName() {
        if (name == null) {
            return Optional.empty();
        }
        return name;
    }

    /**
     * @return A human-readable description for the option value. This is a searchable attribute for use in applicable query filters.
     */
    @JsonIgnore
    public Optional<String> getDescription() {
        if (description == null) {
            return Optional.empty();
        }
        return description;
    }

    /**
     * @return The HTML-supported hex color for the item option (e.g., &quot;#ff8d4e85&quot;).
     * Only displayed if <code>show_colors</code> is enabled on the parent <code>ItemOption</code>. When
     * left unset, <code>color</code> defaults to white (&quot;#ffffff&quot;) when <code>show_colors</code> is
     * enabled on the parent <code>ItemOption</code>.
     */
    @JsonIgnore
    public Optional<String> getColor() {
        if (color == null) {
            return Optional.empty();
        }
        return color;
    }

    /**
     * @return Determines where this option value appears in a list of option values.
     */
    @JsonIgnore
    public Optional<Integer> getOrdinal() {
        if (ordinal == null) {
            return Optional.empty();
        }
        return ordinal;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("item_option_id")
    private Optional<String> _getItemOptionId() {
        return itemOptionId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("name")
    private Optional<String> _getName() {
        return name;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("description")
    private Optional<String> _getDescription() {
        return description;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("color")
    private Optional<String> _getColor() {
        return color;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("ordinal")
    private Optional<Integer> _getOrdinal() {
        return ordinal;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogItemOptionValue && equalTo((CatalogItemOptionValue) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogItemOptionValue other) {
        return itemOptionId.equals(other.itemOptionId)
                && name.equals(other.name)
                && description.equals(other.description)
                && color.equals(other.color)
                && ordinal.equals(other.ordinal);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.itemOptionId, this.name, this.description, this.color, this.ordinal);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> itemOptionId = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> color = Optional.empty();

        private Optional<Integer> ordinal = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogItemOptionValue other) {
            itemOptionId(other.getItemOptionId());
            name(other.getName());
            description(other.getDescription());
            color(other.getColor());
            ordinal(other.getOrdinal());
            return this;
        }

        @JsonSetter(value = "item_option_id", nulls = Nulls.SKIP)
        public Builder itemOptionId(Optional<String> itemOptionId) {
            this.itemOptionId = itemOptionId;
            return this;
        }

        public Builder itemOptionId(String itemOptionId) {
            this.itemOptionId = Optional.ofNullable(itemOptionId);
            return this;
        }

        public Builder itemOptionId(Nullable<String> itemOptionId) {
            if (itemOptionId.isNull()) {
                this.itemOptionId = null;
            } else if (itemOptionId.isEmpty()) {
                this.itemOptionId = Optional.empty();
            } else {
                this.itemOptionId = Optional.of(itemOptionId.get());
            }
            return this;
        }

        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public Builder name(Optional<String> name) {
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = Optional.ofNullable(name);
            return this;
        }

        public Builder name(Nullable<String> name) {
            if (name.isNull()) {
                this.name = null;
            } else if (name.isEmpty()) {
                this.name = Optional.empty();
            } else {
                this.name = Optional.of(name.get());
            }
            return this;
        }

        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public Builder description(Optional<String> description) {
            this.description = description;
            return this;
        }

        public Builder description(String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        public Builder description(Nullable<String> description) {
            if (description.isNull()) {
                this.description = null;
            } else if (description.isEmpty()) {
                this.description = Optional.empty();
            } else {
                this.description = Optional.of(description.get());
            }
            return this;
        }

        @JsonSetter(value = "color", nulls = Nulls.SKIP)
        public Builder color(Optional<String> color) {
            this.color = color;
            return this;
        }

        public Builder color(String color) {
            this.color = Optional.ofNullable(color);
            return this;
        }

        public Builder color(Nullable<String> color) {
            if (color.isNull()) {
                this.color = null;
            } else if (color.isEmpty()) {
                this.color = Optional.empty();
            } else {
                this.color = Optional.of(color.get());
            }
            return this;
        }

        @JsonSetter(value = "ordinal", nulls = Nulls.SKIP)
        public Builder ordinal(Optional<Integer> ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        public Builder ordinal(Integer ordinal) {
            this.ordinal = Optional.ofNullable(ordinal);
            return this;
        }

        public Builder ordinal(Nullable<Integer> ordinal) {
            if (ordinal.isNull()) {
                this.ordinal = null;
            } else if (ordinal.isEmpty()) {
                this.ordinal = Optional.empty();
            } else {
                this.ordinal = Optional.of(ordinal.get());
            }
            return this;
        }

        public CatalogItemOptionValue build() {
            return new CatalogItemOptionValue(itemOptionId, name, description, color, ordinal, additionalProperties);
        }
    }
}

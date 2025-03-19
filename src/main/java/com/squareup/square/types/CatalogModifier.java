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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CatalogModifier.Builder.class)
public final class CatalogModifier {
    private final Optional<String> name;

    private final Optional<Money> priceMoney;

    private final Optional<Integer> ordinal;

    private final Optional<String> modifierListId;

    private final Optional<List<ModifierLocationOverrides>> locationOverrides;

    private final Optional<String> imageId;

    private final Map<String, Object> additionalProperties;

    private CatalogModifier(
            Optional<String> name,
            Optional<Money> priceMoney,
            Optional<Integer> ordinal,
            Optional<String> modifierListId,
            Optional<List<ModifierLocationOverrides>> locationOverrides,
            Optional<String> imageId,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.priceMoney = priceMoney;
        this.ordinal = ordinal;
        this.modifierListId = modifierListId;
        this.locationOverrides = locationOverrides;
        this.imageId = imageId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The modifier name.  This is a searchable attribute for use in applicable query filters, and its value length is of Unicode code points.
     */
    @JsonIgnore
    public Optional<String> getName() {
        if (name == null) {
            return Optional.empty();
        }
        return name;
    }

    /**
     * @return The modifier price.
     */
    @JsonProperty("price_money")
    public Optional<Money> getPriceMoney() {
        return priceMoney;
    }

    /**
     * @return Determines where this <code>CatalogModifier</code> appears in the <code>CatalogModifierList</code>.
     */
    @JsonIgnore
    public Optional<Integer> getOrdinal() {
        if (ordinal == null) {
            return Optional.empty();
        }
        return ordinal;
    }

    /**
     * @return The ID of the <code>CatalogModifierList</code> associated with this modifier.
     */
    @JsonIgnore
    public Optional<String> getModifierListId() {
        if (modifierListId == null) {
            return Optional.empty();
        }
        return modifierListId;
    }

    /**
     * @return Location-specific price overrides.
     */
    @JsonIgnore
    public Optional<List<ModifierLocationOverrides>> getLocationOverrides() {
        if (locationOverrides == null) {
            return Optional.empty();
        }
        return locationOverrides;
    }

    /**
     * @return The ID of the image associated with this <code>CatalogModifier</code> instance.
     * Currently this image is not displayed by Square, but is free to be displayed in 3rd party applications.
     */
    @JsonIgnore
    public Optional<String> getImageId() {
        if (imageId == null) {
            return Optional.empty();
        }
        return imageId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("name")
    private Optional<String> _getName() {
        return name;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("ordinal")
    private Optional<Integer> _getOrdinal() {
        return ordinal;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("modifier_list_id")
    private Optional<String> _getModifierListId() {
        return modifierListId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("location_overrides")
    private Optional<List<ModifierLocationOverrides>> _getLocationOverrides() {
        return locationOverrides;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("image_id")
    private Optional<String> _getImageId() {
        return imageId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogModifier && equalTo((CatalogModifier) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogModifier other) {
        return name.equals(other.name)
                && priceMoney.equals(other.priceMoney)
                && ordinal.equals(other.ordinal)
                && modifierListId.equals(other.modifierListId)
                && locationOverrides.equals(other.locationOverrides)
                && imageId.equals(other.imageId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.name, this.priceMoney, this.ordinal, this.modifierListId, this.locationOverrides, this.imageId);
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
        private Optional<String> name = Optional.empty();

        private Optional<Money> priceMoney = Optional.empty();

        private Optional<Integer> ordinal = Optional.empty();

        private Optional<String> modifierListId = Optional.empty();

        private Optional<List<ModifierLocationOverrides>> locationOverrides = Optional.empty();

        private Optional<String> imageId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogModifier other) {
            name(other.getName());
            priceMoney(other.getPriceMoney());
            ordinal(other.getOrdinal());
            modifierListId(other.getModifierListId());
            locationOverrides(other.getLocationOverrides());
            imageId(other.getImageId());
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

        @JsonSetter(value = "price_money", nulls = Nulls.SKIP)
        public Builder priceMoney(Optional<Money> priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = Optional.ofNullable(priceMoney);
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

        @JsonSetter(value = "modifier_list_id", nulls = Nulls.SKIP)
        public Builder modifierListId(Optional<String> modifierListId) {
            this.modifierListId = modifierListId;
            return this;
        }

        public Builder modifierListId(String modifierListId) {
            this.modifierListId = Optional.ofNullable(modifierListId);
            return this;
        }

        public Builder modifierListId(Nullable<String> modifierListId) {
            if (modifierListId.isNull()) {
                this.modifierListId = null;
            } else if (modifierListId.isEmpty()) {
                this.modifierListId = Optional.empty();
            } else {
                this.modifierListId = Optional.of(modifierListId.get());
            }
            return this;
        }

        @JsonSetter(value = "location_overrides", nulls = Nulls.SKIP)
        public Builder locationOverrides(Optional<List<ModifierLocationOverrides>> locationOverrides) {
            this.locationOverrides = locationOverrides;
            return this;
        }

        public Builder locationOverrides(List<ModifierLocationOverrides> locationOverrides) {
            this.locationOverrides = Optional.ofNullable(locationOverrides);
            return this;
        }

        public Builder locationOverrides(Nullable<List<ModifierLocationOverrides>> locationOverrides) {
            if (locationOverrides.isNull()) {
                this.locationOverrides = null;
            } else if (locationOverrides.isEmpty()) {
                this.locationOverrides = Optional.empty();
            } else {
                this.locationOverrides = Optional.of(locationOverrides.get());
            }
            return this;
        }

        @JsonSetter(value = "image_id", nulls = Nulls.SKIP)
        public Builder imageId(Optional<String> imageId) {
            this.imageId = imageId;
            return this;
        }

        public Builder imageId(String imageId) {
            this.imageId = Optional.ofNullable(imageId);
            return this;
        }

        public Builder imageId(Nullable<String> imageId) {
            if (imageId.isNull()) {
                this.imageId = null;
            } else if (imageId.isEmpty()) {
                this.imageId = Optional.empty();
            } else {
                this.imageId = Optional.of(imageId.get());
            }
            return this;
        }

        public CatalogModifier build() {
            return new CatalogModifier(
                    name, priceMoney, ordinal, modifierListId, locationOverrides, imageId, additionalProperties);
        }
    }
}

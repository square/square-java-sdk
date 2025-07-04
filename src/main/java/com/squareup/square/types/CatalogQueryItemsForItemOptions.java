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
@JsonDeserialize(builder = CatalogQueryItemsForItemOptions.Builder.class)
public final class CatalogQueryItemsForItemOptions {
    private final Optional<List<String>> itemOptionIds;

    private final Map<String, Object> additionalProperties;

    private CatalogQueryItemsForItemOptions(
            Optional<List<String>> itemOptionIds, Map<String, Object> additionalProperties) {
        this.itemOptionIds = itemOptionIds;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A set of <code>CatalogItemOption</code> IDs to be used to find associated
     * <code>CatalogItem</code>s. All Items that contain all of the given Item Options (in any order)
     * will be returned.
     */
    @JsonIgnore
    public Optional<List<String>> getItemOptionIds() {
        if (itemOptionIds == null) {
            return Optional.empty();
        }
        return itemOptionIds;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("item_option_ids")
    private Optional<List<String>> _getItemOptionIds() {
        return itemOptionIds;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CatalogQueryItemsForItemOptions && equalTo((CatalogQueryItemsForItemOptions) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CatalogQueryItemsForItemOptions other) {
        return itemOptionIds.equals(other.itemOptionIds);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.itemOptionIds);
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
        private Optional<List<String>> itemOptionIds = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CatalogQueryItemsForItemOptions other) {
            itemOptionIds(other.getItemOptionIds());
            return this;
        }

        /**
         * <p>A set of <code>CatalogItemOption</code> IDs to be used to find associated
         * <code>CatalogItem</code>s. All Items that contain all of the given Item Options (in any order)
         * will be returned.</p>
         */
        @JsonSetter(value = "item_option_ids", nulls = Nulls.SKIP)
        public Builder itemOptionIds(Optional<List<String>> itemOptionIds) {
            this.itemOptionIds = itemOptionIds;
            return this;
        }

        public Builder itemOptionIds(List<String> itemOptionIds) {
            this.itemOptionIds = Optional.ofNullable(itemOptionIds);
            return this;
        }

        public Builder itemOptionIds(Nullable<List<String>> itemOptionIds) {
            if (itemOptionIds.isNull()) {
                this.itemOptionIds = null;
            } else if (itemOptionIds.isEmpty()) {
                this.itemOptionIds = Optional.empty();
            } else {
                this.itemOptionIds = Optional.of(itemOptionIds.get());
            }
            return this;
        }

        public CatalogQueryItemsForItemOptions build() {
            return new CatalogQueryItemsForItemOptions(itemOptionIds, additionalProperties);
        }
    }
}

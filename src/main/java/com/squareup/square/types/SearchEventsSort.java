/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SearchEventsSort.Builder.class)
public final class SearchEventsSort {
    private final Optional<String> field;

    private final Optional<SortOrder> order;

    private final Map<String, Object> additionalProperties;

    private SearchEventsSort(
            Optional<String> field, Optional<SortOrder> order, Map<String, Object> additionalProperties) {
        this.field = field;
        this.order = order;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Sort events by event types.
     * See <a href="#type-searcheventssortfield">SearchEventsSortField</a> for possible values
     */
    @JsonProperty("field")
    public Optional<String> getField() {
        return field;
    }

    /**
     * @return The order to use for sorting the events.
     * See <a href="#type-sortorder">SortOrder</a> for possible values
     */
    @JsonProperty("order")
    public Optional<SortOrder> getOrder() {
        return order;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchEventsSort && equalTo((SearchEventsSort) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SearchEventsSort other) {
        return field.equals(other.field) && order.equals(other.order);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.field, this.order);
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
        private Optional<String> field = Optional.empty();

        private Optional<SortOrder> order = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(SearchEventsSort other) {
            field(other.getField());
            order(other.getOrder());
            return this;
        }

        /**
         * <p>Sort events by event types.
         * See <a href="#type-searcheventssortfield">SearchEventsSortField</a> for possible values</p>
         */
        @JsonSetter(value = "field", nulls = Nulls.SKIP)
        public Builder field(Optional<String> field) {
            this.field = field;
            return this;
        }

        public Builder field(String field) {
            this.field = Optional.ofNullable(field);
            return this;
        }

        /**
         * <p>The order to use for sorting the events.
         * See <a href="#type-sortorder">SortOrder</a> for possible values</p>
         */
        @JsonSetter(value = "order", nulls = Nulls.SKIP)
        public Builder order(Optional<SortOrder> order) {
            this.order = order;
            return this;
        }

        public Builder order(SortOrder order) {
            this.order = Optional.ofNullable(order);
            return this;
        }

        public SearchEventsSort build() {
            return new SearchEventsSort(field, order, additionalProperties);
        }
    }
}

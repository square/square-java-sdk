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
@JsonDeserialize(builder = TerminalRefundQuerySort.Builder.class)
public final class TerminalRefundQuerySort {
    private final Optional<String> sortOrder;

    private final Map<String, Object> additionalProperties;

    private TerminalRefundQuerySort(Optional<String> sortOrder, Map<String, Object> additionalProperties) {
        this.sortOrder = sortOrder;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The order in which results are listed.
     * <ul>
     * <li><code>ASC</code> - Oldest to newest.</li>
     * <li><code>DESC</code> - Newest to oldest (default).</li>
     * </ul>
     */
    @JsonIgnore
    public Optional<String> getSortOrder() {
        if (sortOrder == null) {
            return Optional.empty();
        }
        return sortOrder;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("sort_order")
    private Optional<String> _getSortOrder() {
        return sortOrder;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TerminalRefundQuerySort && equalTo((TerminalRefundQuerySort) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TerminalRefundQuerySort other) {
        return sortOrder.equals(other.sortOrder);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.sortOrder);
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
        private Optional<String> sortOrder = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(TerminalRefundQuerySort other) {
            sortOrder(other.getSortOrder());
            return this;
        }

        /**
         * <p>The order in which results are listed.</p>
         * <ul>
         * <li><code>ASC</code> - Oldest to newest.</li>
         * <li><code>DESC</code> - Newest to oldest (default).</li>
         * </ul>
         */
        @JsonSetter(value = "sort_order", nulls = Nulls.SKIP)
        public Builder sortOrder(Optional<String> sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public Builder sortOrder(String sortOrder) {
            this.sortOrder = Optional.ofNullable(sortOrder);
            return this;
        }

        public Builder sortOrder(Nullable<String> sortOrder) {
            if (sortOrder.isNull()) {
                this.sortOrder = null;
            } else if (sortOrder.isEmpty()) {
                this.sortOrder = Optional.empty();
            } else {
                this.sortOrder = Optional.of(sortOrder.get());
            }
            return this;
        }

        public TerminalRefundQuerySort build() {
            return new TerminalRefundQuerySort(sortOrder, additionalProperties);
        }
    }
}

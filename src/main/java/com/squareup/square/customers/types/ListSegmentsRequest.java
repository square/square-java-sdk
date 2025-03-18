/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.customers.types;

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
@JsonDeserialize(builder = ListSegmentsRequest.Builder.class)
public final class ListSegmentsRequest {
    private final Optional<String> cursor;

    private final Optional<Integer> limit;

    private final Map<String, Object> additionalProperties;

    private ListSegmentsRequest(
            Optional<String> cursor, Optional<Integer> limit, Map<String, Object> additionalProperties) {
        this.cursor = cursor;
        this.limit = limit;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A pagination cursor returned by previous calls to <code>ListCustomerSegments</code>.
     * This cursor is used to retrieve the next set of query results.
     * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination">Pagination</a>.</p>
     */
    @JsonIgnore
    public Optional<String> getCursor() {
        if (cursor == null) {
            return Optional.empty();
        }
        return cursor;
    }

    /**
     * @return The maximum number of results to return in a single page. This limit is advisory. The response might contain more or fewer results.
     * If the specified limit is less than 1 or greater than 50, Square returns a <code>400 VALUE_TOO_LOW</code> or <code>400 VALUE_TOO_HIGH</code> error. The default value is 50.
     * <p>For more information, see <a href="https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination">Pagination</a>.</p>
     */
    @JsonIgnore
    public Optional<Integer> getLimit() {
        if (limit == null) {
            return Optional.empty();
        }
        return limit;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("cursor")
    private Optional<String> _getCursor() {
        return cursor;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("limit")
    private Optional<Integer> _getLimit() {
        return limit;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListSegmentsRequest && equalTo((ListSegmentsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListSegmentsRequest other) {
        return cursor.equals(other.cursor) && limit.equals(other.limit);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.cursor, this.limit);
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
        private Optional<String> cursor = Optional.empty();

        private Optional<Integer> limit = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListSegmentsRequest other) {
            cursor(other.getCursor());
            limit(other.getLimit());
            return this;
        }

        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public Builder cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        public Builder cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        public Builder cursor(Nullable<String> cursor) {
            if (cursor.isNull()) {
                this.cursor = null;
            } else if (cursor.isEmpty()) {
                this.cursor = Optional.empty();
            } else {
                this.cursor = Optional.of(cursor.get());
            }
            return this;
        }

        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<Integer> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        public Builder limit(Nullable<Integer> limit) {
            if (limit.isNull()) {
                this.limit = null;
            } else if (limit.isEmpty()) {
                this.limit = Optional.empty();
            } else {
                this.limit = Optional.of(limit.get());
            }
            return this;
        }

        public ListSegmentsRequest build() {
            return new ListSegmentsRequest(cursor, limit, additionalProperties);
        }
    }
}

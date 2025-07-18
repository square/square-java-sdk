/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.labor.types;

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
@JsonDeserialize(builder = ListBreakTypesRequest.Builder.class)
public final class ListBreakTypesRequest {
    private final Optional<String> locationId;

    private final Optional<Integer> limit;

    private final Optional<String> cursor;

    private final Map<String, Object> additionalProperties;

    private ListBreakTypesRequest(
            Optional<String> locationId,
            Optional<Integer> limit,
            Optional<String> cursor,
            Map<String, Object> additionalProperties) {
        this.locationId = locationId;
        this.limit = limit;
        this.cursor = cursor;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Filter the returned <code>BreakType</code> results to only those that are associated with the
     * specified location.
     */
    @JsonIgnore
    public Optional<String> getLocationId() {
        if (locationId == null) {
            return Optional.empty();
        }
        return locationId;
    }

    /**
     * @return The maximum number of <code>BreakType</code> results to return per page. The number can range between 1
     * and 200. The default is 200.
     */
    @JsonIgnore
    public Optional<Integer> getLimit() {
        if (limit == null) {
            return Optional.empty();
        }
        return limit;
    }

    /**
     * @return A pointer to the next page of <code>BreakType</code> results to fetch.
     */
    @JsonIgnore
    public Optional<String> getCursor() {
        if (cursor == null) {
            return Optional.empty();
        }
        return cursor;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("location_id")
    private Optional<String> _getLocationId() {
        return locationId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("limit")
    private Optional<Integer> _getLimit() {
        return limit;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("cursor")
    private Optional<String> _getCursor() {
        return cursor;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListBreakTypesRequest && equalTo((ListBreakTypesRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListBreakTypesRequest other) {
        return locationId.equals(other.locationId) && limit.equals(other.limit) && cursor.equals(other.cursor);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.locationId, this.limit, this.cursor);
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
        private Optional<String> locationId = Optional.empty();

        private Optional<Integer> limit = Optional.empty();

        private Optional<String> cursor = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ListBreakTypesRequest other) {
            locationId(other.getLocationId());
            limit(other.getLimit());
            cursor(other.getCursor());
            return this;
        }

        /**
         * <p>Filter the returned <code>BreakType</code> results to only those that are associated with the
         * specified location.</p>
         */
        @JsonSetter(value = "location_id", nulls = Nulls.SKIP)
        public Builder locationId(Optional<String> locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder locationId(String locationId) {
            this.locationId = Optional.ofNullable(locationId);
            return this;
        }

        public Builder locationId(Nullable<String> locationId) {
            if (locationId.isNull()) {
                this.locationId = null;
            } else if (locationId.isEmpty()) {
                this.locationId = Optional.empty();
            } else {
                this.locationId = Optional.of(locationId.get());
            }
            return this;
        }

        /**
         * <p>The maximum number of <code>BreakType</code> results to return per page. The number can range between 1
         * and 200. The default is 200.</p>
         */
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

        /**
         * <p>A pointer to the next page of <code>BreakType</code> results to fetch.</p>
         */
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

        public ListBreakTypesRequest build() {
            return new ListBreakTypesRequest(locationId, limit, cursor, additionalProperties);
        }
    }
}

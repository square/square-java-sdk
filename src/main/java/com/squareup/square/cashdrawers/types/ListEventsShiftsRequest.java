/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.cashdrawers.types;

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
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ListEventsShiftsRequest.Builder.class)
public final class ListEventsShiftsRequest {
    private final String shiftId;

    private final String locationId;

    private final Optional<Integer> limit;

    private final Optional<String> cursor;

    private final Map<String, Object> additionalProperties;

    private ListEventsShiftsRequest(
            String shiftId,
            String locationId,
            Optional<Integer> limit,
            Optional<String> cursor,
            Map<String, Object> additionalProperties) {
        this.shiftId = shiftId;
        this.locationId = locationId;
        this.limit = limit;
        this.cursor = cursor;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The shift ID.
     */
    @JsonProperty("shift_id")
    public String getShiftId() {
        return shiftId;
    }

    /**
     * @return The ID of the location to list cash drawer shifts for.
     */
    @JsonProperty("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * @return Number of resources to be returned in a page of results (200 by
     * default, 1000 max).
     */
    @JsonIgnore
    public Optional<Integer> getLimit() {
        if (limit == null) {
            return Optional.empty();
        }
        return limit;
    }

    /**
     * @return Opaque cursor for fetching the next page of results.
     */
    @JsonIgnore
    public Optional<String> getCursor() {
        if (cursor == null) {
            return Optional.empty();
        }
        return cursor;
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
        return other instanceof ListEventsShiftsRequest && equalTo((ListEventsShiftsRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ListEventsShiftsRequest other) {
        return shiftId.equals(other.shiftId)
                && locationId.equals(other.locationId)
                && limit.equals(other.limit)
                && cursor.equals(other.cursor);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.shiftId, this.locationId, this.limit, this.cursor);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ShiftIdStage builder() {
        return new Builder();
    }

    public interface ShiftIdStage {
        /**
         * <p>The shift ID.</p>
         */
        LocationIdStage shiftId(@NotNull String shiftId);

        Builder from(ListEventsShiftsRequest other);
    }

    public interface LocationIdStage {
        /**
         * <p>The ID of the location to list cash drawer shifts for.</p>
         */
        _FinalStage locationId(@NotNull String locationId);
    }

    public interface _FinalStage {
        ListEventsShiftsRequest build();

        /**
         * <p>Number of resources to be returned in a page of results (200 by
         * default, 1000 max).</p>
         */
        _FinalStage limit(Optional<Integer> limit);

        _FinalStage limit(Integer limit);

        _FinalStage limit(Nullable<Integer> limit);

        /**
         * <p>Opaque cursor for fetching the next page of results.</p>
         */
        _FinalStage cursor(Optional<String> cursor);

        _FinalStage cursor(String cursor);

        _FinalStage cursor(Nullable<String> cursor);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ShiftIdStage, LocationIdStage, _FinalStage {
        private String shiftId;

        private String locationId;

        private Optional<String> cursor = Optional.empty();

        private Optional<Integer> limit = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ListEventsShiftsRequest other) {
            shiftId(other.getShiftId());
            locationId(other.getLocationId());
            limit(other.getLimit());
            cursor(other.getCursor());
            return this;
        }

        /**
         * <p>The shift ID.</p>
         * <p>The shift ID.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("shift_id")
        public LocationIdStage shiftId(@NotNull String shiftId) {
            this.shiftId = Objects.requireNonNull(shiftId, "shiftId must not be null");
            return this;
        }

        /**
         * <p>The ID of the location to list cash drawer shifts for.</p>
         * <p>The ID of the location to list cash drawer shifts for.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("location_id")
        public _FinalStage locationId(@NotNull String locationId) {
            this.locationId = Objects.requireNonNull(locationId, "locationId must not be null");
            return this;
        }

        /**
         * <p>Opaque cursor for fetching the next page of results.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage cursor(Nullable<String> cursor) {
            if (cursor.isNull()) {
                this.cursor = null;
            } else if (cursor.isEmpty()) {
                this.cursor = Optional.empty();
            } else {
                this.cursor = Optional.of(cursor.get());
            }
            return this;
        }

        /**
         * <p>Opaque cursor for fetching the next page of results.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage cursor(String cursor) {
            this.cursor = Optional.ofNullable(cursor);
            return this;
        }

        /**
         * <p>Opaque cursor for fetching the next page of results.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "cursor", nulls = Nulls.SKIP)
        public _FinalStage cursor(Optional<String> cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * <p>Number of resources to be returned in a page of results (200 by
         * default, 1000 max).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage limit(Nullable<Integer> limit) {
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
         * <p>Number of resources to be returned in a page of results (200 by
         * default, 1000 max).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage limit(Integer limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * <p>Number of resources to be returned in a page of results (200 by
         * default, 1000 max).</p>
         */
        @java.lang.Override
        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public _FinalStage limit(Optional<Integer> limit) {
            this.limit = limit;
            return this;
        }

        @java.lang.Override
        public ListEventsShiftsRequest build() {
            return new ListEventsShiftsRequest(shiftId, locationId, limit, cursor, additionalProperties);
        }
    }
}

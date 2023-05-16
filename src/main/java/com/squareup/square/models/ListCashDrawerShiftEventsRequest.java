
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListCashDrawerShiftEventsRequest type.
 */
public class ListCashDrawerShiftEventsRequest {
    private final String locationId;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListCashDrawerShiftEventsRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.locationId = locationId;
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListCashDrawerShiftEventsRequest(String locationId, OptionalNullable<Integer> limit,
            OptionalNullable<String> cursor) {
        this.locationId = locationId;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Getter for LocationId.
     * The ID of the location to list cash drawer shifts for.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Internal Getter for Limit.
     * Number of resources to be returned in a page of results (200 by default, 1000 max).
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * Number of resources to be returned in a page of results (200 by default, 1000 max).
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for Cursor.
     * Opaque cursor for fetching the next page of results.
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page of results.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCashDrawerShiftEventsRequest)) {
            return false;
        }
        ListCashDrawerShiftEventsRequest other = (ListCashDrawerShiftEventsRequest) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListCashDrawerShiftEventsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCashDrawerShiftEventsRequest [" + "locationId=" + locationId + ", limit="
                + limit + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListCashDrawerShiftEventsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCashDrawerShiftEventsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId);
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListCashDrawerShiftEventsRequest}.
     */
    public static class Builder {
        private String locationId;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> cursor;

        /**
         * Initialization constructor.
         * @param  locationId  String value for locationId.
         */
        public Builder(String locationId) {
            this.locationId = locationId;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Builds a new {@link ListCashDrawerShiftEventsRequest} object using the set fields.
         * @return {@link ListCashDrawerShiftEventsRequest}
         */
        public ListCashDrawerShiftEventsRequest build() {
            return new ListCashDrawerShiftEventsRequest(locationId, limit, cursor);
        }
    }
}

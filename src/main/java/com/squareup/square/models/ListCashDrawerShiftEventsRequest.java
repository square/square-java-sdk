package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListCashDrawerShiftEventsRequest type.
 */
public class ListCashDrawerShiftEventsRequest {

    /**
     * Initialization constructor.
     * @param locationId
     * @param limit
     * @param cursor
     */
    @JsonCreator
    public ListCashDrawerShiftEventsRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.locationId = locationId;
        this.limit = limit;
        this.cursor = cursor;
    }

    private final String locationId;
    private final Integer limit;
    private final String cursor;
    /**
     * Getter for LocationId.
     * The ID of the location to list cash drawer shifts for.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Limit.
     * Number of resources to be returned in a page of results (200 by
     * default, 1000 max).
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page of results.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCashDrawerShiftEventsRequest)) {
            return false;
        }
        ListCashDrawerShiftEventsRequest listCashDrawerShiftEventsRequest = (ListCashDrawerShiftEventsRequest) obj;
        return Objects.equals(locationId, listCashDrawerShiftEventsRequest.locationId) &&
            Objects.equals(limit, listCashDrawerShiftEventsRequest.limit) &&
            Objects.equals(cursor, listCashDrawerShiftEventsRequest.cursor);
    }

    /**
     * Builds a new {@link ListCashDrawerShiftEventsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCashDrawerShiftEventsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId)
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListCashDrawerShiftEventsRequest}
     */
    public static class Builder {
        private String locationId;
        private Integer limit;
        private String cursor;

        /**
         * Initialization constructor
         */
        public Builder(String locationId) {
            this.locationId = locationId;
        }

        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListCashDrawerShiftEventsRequest} object using the set fields.
         * @return {@link ListCashDrawerShiftEventsRequest}
         */
        public ListCashDrawerShiftEventsRequest build() {
            return new ListCashDrawerShiftEventsRequest(locationId,
                limit,
                cursor);
        }
    }
}

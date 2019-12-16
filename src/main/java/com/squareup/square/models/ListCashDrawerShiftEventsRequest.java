package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListCashDrawerShiftEventsRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(locationId, limit, cursor);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListCashDrawerShiftEventsRequest)) {
            return false;
        }
        ListCashDrawerShiftEventsRequest listCashDrawerShiftEventsRequest = (ListCashDrawerShiftEventsRequest) o;
        return Objects.equals(locationId, listCashDrawerShiftEventsRequest.locationId) &&
            Objects.equals(limit, listCashDrawerShiftEventsRequest.limit) &&
            Objects.equals(cursor, listCashDrawerShiftEventsRequest.cursor);
    }
    
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

 
    public Builder toBuilder() {
        Builder builder = new Builder(locationId)
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private String locationId;
        private Integer limit;
        private String cursor;

        public Builder(String locationId) {
            this.locationId = locationId;
        }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder limit(Integer value) {
            limit = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListCashDrawerShiftEventsRequest build() {
            return new ListCashDrawerShiftEventsRequest(locationId,
                limit,
                cursor);
        }
    }
}

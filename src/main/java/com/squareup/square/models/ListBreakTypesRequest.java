package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListBreakTypesRequest {

    @JsonCreator
    public ListBreakTypesRequest(
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
        if (!(o instanceof ListBreakTypesRequest)) {
            return false;
        }
        ListBreakTypesRequest listBreakTypesRequest = (ListBreakTypesRequest) o;
        return Objects.equals(locationId, listBreakTypesRequest.locationId) &&
            Objects.equals(limit, listBreakTypesRequest.limit) &&
            Objects.equals(cursor, listBreakTypesRequest.cursor);
    }

    /**
     * Getter for LocationId.
     * Filter Break Types returned to only those that are associated with the
     * specified location.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for Limit.
     * Maximum number of Break Types to return per page. Can range between 1
     * and 200. The default is the maximum at 200.
     */
    @JsonGetter("limit")
    public Integer getLimit() { 
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Break Type results to fetch.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationId(getLocationId())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private String locationId;
        private Integer limit;
        private String cursor;

        public Builder() { }

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

        public ListBreakTypesRequest build() {
            return new ListBreakTypesRequest(locationId,
                limit,
                cursor);
        }
    }
}

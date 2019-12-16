package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListEmployeesRequest {

    @JsonCreator
    public ListEmployeesRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("status") String status,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.locationId = locationId;
        this.status = status;
        this.limit = limit;
        this.cursor = cursor;
    }

    private final String locationId;
    private final String status;
    private final Integer limit;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(locationId, status, limit, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListEmployeesRequest)) {
            return false;
        }
        ListEmployeesRequest listEmployeesRequest = (ListEmployeesRequest) o;
        return Objects.equals(locationId, listEmployeesRequest.locationId) &&
            Objects.equals(status, listEmployeesRequest.status) &&
            Objects.equals(limit, listEmployeesRequest.limit) &&
            Objects.equals(cursor, listEmployeesRequest.cursor);
    }

    /**
     * Getter for LocationId.
     * Filter employees returned to only those that are associated with the specified location.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for Status.
     * The status of the Employee being retrieved.
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
    }

    /**
     * Getter for Limit.
     * The number of employees to be returned on each page.
     */
    @JsonGetter("limit")
    public Integer getLimit() { 
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * The token required to retrieve the specified page of results.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationId(getLocationId())
            .status(getStatus())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private String locationId;
        private String status;
        private Integer limit;
        private String cursor;

        public Builder() { }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
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

        public ListEmployeesRequest build() {
            return new ListEmployeesRequest(locationId,
                status,
                limit,
                cursor);
        }
    }
}

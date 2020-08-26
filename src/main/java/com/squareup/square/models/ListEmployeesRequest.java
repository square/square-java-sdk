package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListEmployeesRequest type.
 */
public class ListEmployeesRequest {

    /**
     * Initialization constructor.
     * @param locationId
     * @param status
     * @param limit
     * @param cursor
     */
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
    /**
     * Getter for LocationId.
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

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId, status, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListEmployeesRequest)) {
            return false;
        }
        ListEmployeesRequest listEmployeesRequest = (ListEmployeesRequest) obj;
        return Objects.equals(locationId, listEmployeesRequest.locationId) &&
            Objects.equals(status, listEmployeesRequest.status) &&
            Objects.equals(limit, listEmployeesRequest.limit) &&
            Objects.equals(cursor, listEmployeesRequest.cursor);
    }

    /**
     * Builds a new {@link ListEmployeesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListEmployeesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationId(getLocationId())
            .status(getStatus())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListEmployeesRequest}
     */
    public static class Builder {
        private String locationId;
        private String status;
        private Integer limit;
        private String cursor;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
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
         * Builds a new {@link ListEmployeesRequest} object using the set fields.
         * @return {@link ListEmployeesRequest}
         */
        public ListEmployeesRequest build() {
            return new ListEmployeesRequest(locationId,
                status,
                limit,
                cursor);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListCashDrawerShiftsRequest type.
 */
public class ListCashDrawerShiftsRequest {

    /**
     * Initialization constructor.
     * @param locationId
     * @param sortOrder
     * @param beginTime
     * @param endTime
     * @param limit
     * @param cursor
     */
    @JsonCreator
    public ListCashDrawerShiftsRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.locationId = locationId;
        this.sortOrder = sortOrder;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limit = limit;
        this.cursor = cursor;
    }

    private final String locationId;
    private final String sortOrder;
    private final String beginTime;
    private final String endTime;
    private final Integer limit;
    private final String cursor;
    /**
     * Getter for LocationId.
     * The ID of the location to query for a list of cash drawer shifts.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return this.sortOrder;
    }

    /**
     * Getter for BeginTime.
     * The inclusive start time of the query on opened_at, in ISO 8601 format.
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The exclusive end date of the query on opened_at, in ISO 8601 format.
     */
    @JsonGetter("end_time")
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * Getter for Limit.
     * Number of cash drawer shift events in a page of results (200 by
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
        return Objects.hash(locationId, sortOrder, beginTime, endTime, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCashDrawerShiftsRequest)) {
            return false;
        }
        ListCashDrawerShiftsRequest listCashDrawerShiftsRequest = (ListCashDrawerShiftsRequest) obj;
        return Objects.equals(locationId, listCashDrawerShiftsRequest.locationId) &&
            Objects.equals(sortOrder, listCashDrawerShiftsRequest.sortOrder) &&
            Objects.equals(beginTime, listCashDrawerShiftsRequest.beginTime) &&
            Objects.equals(endTime, listCashDrawerShiftsRequest.endTime) &&
            Objects.equals(limit, listCashDrawerShiftsRequest.limit) &&
            Objects.equals(cursor, listCashDrawerShiftsRequest.cursor);
    }

    /**
     * Builds a new {@link ListCashDrawerShiftsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCashDrawerShiftsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId)
            .sortOrder(getSortOrder())
            .beginTime(getBeginTime())
            .endTime(getEndTime())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListCashDrawerShiftsRequest}
     */
    public static class Builder {
        private String locationId;
        private String sortOrder;
        private String beginTime;
        private String endTime;
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
         * Setter for sortOrder
         * @param sortOrder
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }
        /**
         * Setter for beginTime
         * @param beginTime
         * @return Builder
         */
        public Builder beginTime(String beginTime) {
            this.beginTime = beginTime;
            return this;
        }
        /**
         * Setter for endTime
         * @param endTime
         * @return Builder
         */
        public Builder endTime(String endTime) {
            this.endTime = endTime;
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
         * Builds a new {@link ListCashDrawerShiftsRequest} object using the set fields.
         * @return {@link ListCashDrawerShiftsRequest}
         */
        public ListCashDrawerShiftsRequest build() {
            return new ListCashDrawerShiftsRequest(locationId,
                sortOrder,
                beginTime,
                endTime,
                limit,
                cursor);
        }
    }
}

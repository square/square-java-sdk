package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListCashDrawerShiftsRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(locationId, sortOrder, beginTime, endTime, limit, cursor);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListCashDrawerShiftsRequest)) {
            return false;
        }
        ListCashDrawerShiftsRequest listCashDrawerShiftsRequest = (ListCashDrawerShiftsRequest) o;
        return Objects.equals(locationId, listCashDrawerShiftsRequest.locationId) &&
            Objects.equals(sortOrder, listCashDrawerShiftsRequest.sortOrder) &&
            Objects.equals(beginTime, listCashDrawerShiftsRequest.beginTime) &&
            Objects.equals(endTime, listCashDrawerShiftsRequest.endTime) &&
            Objects.equals(limit, listCashDrawerShiftsRequest.limit) &&
            Objects.equals(cursor, listCashDrawerShiftsRequest.cursor);
    }
    
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

 
    public Builder toBuilder() {
        Builder builder = new Builder(locationId)
            .sortOrder(getSortOrder())
            .beginTime(getBeginTime())
            .endTime(getEndTime())
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private String locationId;
        private String sortOrder;
        private String beginTime;
        private String endTime;
        private Integer limit;
        private String cursor;

        public Builder(String locationId) {
            this.locationId = locationId;
        }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder sortOrder(String value) {
            sortOrder = value;
            return this;
        }
        public Builder beginTime(String value) {
            beginTime = value;
            return this;
        }
        public Builder endTime(String value) {
            endTime = value;
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

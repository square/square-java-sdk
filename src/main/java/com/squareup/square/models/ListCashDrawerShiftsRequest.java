
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
 * This is a model class for ListCashDrawerShiftsRequest type.
 */
public class ListCashDrawerShiftsRequest {
    private final String locationId;
    private final String sortOrder;
    private final OptionalNullable<String> beginTime;
    private final OptionalNullable<String> endTime;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  sortOrder  String value for sortOrder.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
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
        this.beginTime = OptionalNullable.of(beginTime);
        this.endTime = OptionalNullable.of(endTime);
        this.limit = OptionalNullable.of(limit);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  sortOrder  String value for sortOrder.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  limit  Integer value for limit.
     * @param  cursor  String value for cursor.
     */

    protected ListCashDrawerShiftsRequest(String locationId, String sortOrder,
            OptionalNullable<String> beginTime, OptionalNullable<String> endTime,
            OptionalNullable<Integer> limit, OptionalNullable<String> cursor) {
        this.locationId = locationId;
        this.sortOrder = sortOrder;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limit = limit;
        this.cursor = cursor;
    }

    /**
     * Getter for LocationId.
     * The ID of the location to query for a list of cash drawer shifts.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for SortOrder.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Internal Getter for BeginTime.
     * The inclusive start time of the query on opened_at, in ISO 8601 format.
     * @return Returns the Internal String
     */
    @JsonGetter("begin_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for BeginTime.
     * The inclusive start time of the query on opened_at, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBeginTime() {
        return OptionalNullable.getFrom(beginTime);
    }

    /**
     * Internal Getter for EndTime.
     * The exclusive end date of the query on opened_at, in ISO 8601 format.
     * @return Returns the Internal String
     */
    @JsonGetter("end_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEndTime() {
        return this.endTime;
    }

    /**
     * Getter for EndTime.
     * The exclusive end date of the query on opened_at, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndTime() {
        return OptionalNullable.getFrom(endTime);
    }

    /**
     * Internal Getter for Limit.
     * Number of cash drawer shift events in a page of results (200 by default, 1000 max).
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
     * Number of cash drawer shift events in a page of results (200 by default, 1000 max).
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
        return Objects.hash(locationId, sortOrder, beginTime, endTime, limit, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCashDrawerShiftsRequest)) {
            return false;
        }
        ListCashDrawerShiftsRequest other = (ListCashDrawerShiftsRequest) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime)
            && Objects.equals(limit, other.limit)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListCashDrawerShiftsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCashDrawerShiftsRequest [" + "locationId=" + locationId + ", sortOrder="
                + sortOrder + ", beginTime=" + beginTime + ", endTime=" + endTime + ", limit="
                + limit + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListCashDrawerShiftsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCashDrawerShiftsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId)
                .sortOrder(getSortOrder());
        builder.beginTime = internalGetBeginTime();
        builder.endTime = internalGetEndTime();
        builder.limit = internalGetLimit();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link ListCashDrawerShiftsRequest}.
     */
    public static class Builder {
        private String locationId;
        private String sortOrder;
        private OptionalNullable<String> beginTime;
        private OptionalNullable<String> endTime;
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
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Setter for beginTime.
         * @param  beginTime  String value for beginTime.
         * @return Builder
         */
        public Builder beginTime(String beginTime) {
            this.beginTime = OptionalNullable.of(beginTime);
            return this;
        }

        /**
         * UnSetter for beginTime.
         * @return Builder
         */
        public Builder unsetBeginTime() {
            beginTime = null;
            return this;
        }

        /**
         * Setter for endTime.
         * @param  endTime  String value for endTime.
         * @return Builder
         */
        public Builder endTime(String endTime) {
            this.endTime = OptionalNullable.of(endTime);
            return this;
        }

        /**
         * UnSetter for endTime.
         * @return Builder
         */
        public Builder unsetEndTime() {
            endTime = null;
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
         * Builds a new {@link ListCashDrawerShiftsRequest} object using the set fields.
         * @return {@link ListCashDrawerShiftsRequest}
         */
        public ListCashDrawerShiftsRequest build() {
            return new ListCashDrawerShiftsRequest(locationId, sortOrder, beginTime, endTime, limit,
                    cursor);
        }
    }
}

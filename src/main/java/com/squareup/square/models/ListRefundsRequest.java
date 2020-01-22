package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListRefundsRequest type.
 */
public class ListRefundsRequest {

    /**
     * Initialization constructor.
     * @param beginTime
     * @param endTime
     * @param sortOrder
     * @param cursor
     */
    @JsonCreator
    public ListRefundsRequest(
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
    }

    private final String beginTime;
    private final String endTime;
    private final String sortOrder;
    private final String cursor;
    /**
     * Getter for BeginTime.
     * The beginning of the requested reporting period, in RFC 3339 format.
     * See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     * Default value: The current time minus one year.
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The end of the requested reporting period, in RFC 3339 format.
     * See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.
     * Default value: The current time.
     */
    @JsonGetter("end_time")
    public String getEndTime() {
        return this.endTime;
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
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for your original query.
     * See [Paginating results](#paginatingresults) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListRefundsRequest)) {
            return false;
        }
        ListRefundsRequest listRefundsRequest = (ListRefundsRequest) obj;
        return Objects.equals(beginTime, listRefundsRequest.beginTime) &&
            Objects.equals(endTime, listRefundsRequest.endTime) &&
            Objects.equals(sortOrder, listRefundsRequest.sortOrder) &&
            Objects.equals(cursor, listRefundsRequest.cursor);
    }

    /**
     * Builds a new {@link ListRefundsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListRefundsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .beginTime(getBeginTime())
            .endTime(getEndTime())
            .sortOrder(getSortOrder())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListRefundsRequest}
     */
    public static class Builder {
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for sortOrder
         * @param sortOrder
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
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
         * Builds a new {@link ListRefundsRequest} object using the set fields.
         * @return {@link ListRefundsRequest}
         */
        public ListRefundsRequest build() {
            return new ListRefundsRequest(beginTime,
                endTime,
                sortOrder,
                cursor);
        }
    }
}

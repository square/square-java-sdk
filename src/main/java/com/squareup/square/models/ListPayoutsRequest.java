
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListPayoutsRequest type.
 */
public class ListPayoutsRequest {
    private final String locationId;
    private final String status;
    private final String beginTime;
    private final String endTime;
    private final String sortOrder;
    private final String cursor;
    private final Integer limit;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  status  String value for status.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  sortOrder  String value for sortOrder.
     * @param  cursor  String value for cursor.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public ListPayoutsRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("status") String status,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.locationId = locationId;
        this.status = status;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
        this.limit = limit;
    }

    /**
     * Getter for LocationId.
     * The ID of the location for which to list the payouts. By default, payouts are returned for
     * the default (main) location associated with the seller.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for Status.
     * Payout status types
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for BeginTime.
     * The timestamp for the beginning of the payout creation time, in RFC 3339 format. Inclusive.
     * Default: The current time minus one year.
     * @return Returns the String
     */
    @JsonGetter("begin_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * Getter for EndTime.
     * The timestamp for the end of the payout creation time, in RFC 3339 format. Default: The
     * current time.
     * @return Returns the String
     */
    @JsonGetter("end_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEndTime() {
        return endTime;
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
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination). If request
     * parameters change between requests, subsequent results may contain duplicates or missing
     * records.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. The default value of 100 is also the
     * maximum allowed value. If the provided value is greater than 100, it is ignored and the
     * default value is used instead. Default: `100`
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, status, beginTime, endTime, sortOrder, cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListPayoutsRequest)) {
            return false;
        }
        ListPayoutsRequest other = (ListPayoutsRequest) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(status, other.status)
            && Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListPayoutsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPayoutsRequest [" + "locationId=" + locationId + ", status=" + status
                + ", beginTime=" + beginTime + ", endTime=" + endTime + ", sortOrder=" + sortOrder
                + ", cursor=" + cursor + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListPayoutsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPayoutsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .locationId(getLocationId())
                .status(getStatus())
                .beginTime(getBeginTime())
                .endTime(getEndTime())
                .sortOrder(getSortOrder())
                .cursor(getCursor())
                .limit(getLimit());
        return builder;
    }

    /**
     * Class to build instances of {@link ListPayoutsRequest}.
     */
    public static class Builder {
        private String locationId;
        private String status;
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;
        private Integer limit;



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
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for beginTime.
         * @param  beginTime  String value for beginTime.
         * @return Builder
         */
        public Builder beginTime(String beginTime) {
            this.beginTime = beginTime;
            return this;
        }

        /**
         * Setter for endTime.
         * @param  endTime  String value for endTime.
         * @return Builder
         */
        public Builder endTime(String endTime) {
            this.endTime = endTime;
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
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds a new {@link ListPayoutsRequest} object using the set fields.
         * @return {@link ListPayoutsRequest}
         */
        public ListPayoutsRequest build() {
            return new ListPayoutsRequest(locationId, status, beginTime, endTime, sortOrder, cursor,
                    limit);
        }
    }
}

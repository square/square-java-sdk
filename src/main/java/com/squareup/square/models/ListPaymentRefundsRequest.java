
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ListPaymentRefundsRequest type.
 */
public class ListPaymentRefundsRequest {
    private final String beginTime;
    private final String endTime;
    private final String sortOrder;
    private final String cursor;
    private final String locationId;
    private final String status;
    private final String sourceType;
    private final Integer limit;

    /**
     * Initialization constructor.
     * @param beginTime String value for beginTime.
     * @param endTime String value for endTime.
     * @param sortOrder String value for sortOrder.
     * @param cursor String value for cursor.
     * @param locationId String value for locationId.
     * @param status String value for status.
     * @param sourceType String value for sourceType.
     * @param limit Integer value for limit.
     */
    @JsonCreator
    public ListPaymentRefundsRequest(
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("status") String status,
            @JsonProperty("source_type") String sourceType,
            @JsonProperty("limit") Integer limit) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
        this.locationId = locationId;
        this.status = status;
        this.sourceType = sourceType;
        this.limit = limit;
    }

    /**
     * Getter for BeginTime.
     * The timestamp for the beginning of the requested reporting period, in RFC 3339 format.
     * Default: The current time minus one year.
     * @return Returns the String
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The timestamp for the end of the requested reporting period, in RFC 3339 format. Default: The
     * current time.
     * @return Returns the String
     */
    @JsonGetter("end_time")
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * Getter for SortOrder.
     * The order in which results are listed: - `ASC` - Oldest to newest. - `DESC` - Newest to
     * oldest (default).
     * @return Returns the String
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return this.sortOrder;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for LocationId.
     * Limit results to the location supplied. By default, results are returned for all locations
     * associated with the seller.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Status.
     * If provided, only refunds with the given status are returned. For a list of refund status
     * values, see [PaymentRefund](#type-paymentrefund). Default: If omitted, refunds are returned
     * regardless of their status.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for SourceType.
     * If provided, only refunds with the given source type are returned. - `CARD` - List refunds
     * only for payments where `CARD` was specified as the payment source. Default: If omitted,
     * refunds are returned regardless of the source type.
     * @return Returns the String
     */
    @JsonGetter("source_type")
    public String getSourceType() {
        return this.sourceType;
    }

    /**
     * Getter for Limit.
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. If the supplied value is greater than
     * 100, no more than 100 results are returned. Default: 100
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor, locationId, status, sourceType,
                limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListPaymentRefundsRequest)) {
            return false;
        }
        ListPaymentRefundsRequest other = (ListPaymentRefundsRequest) obj;
        return Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(status, other.status)
            && Objects.equals(sourceType, other.sourceType)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this ListPaymentRefundsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPaymentRefundsRequest [" + "beginTime=" + beginTime + ", endTime=" + endTime
                + ", sortOrder=" + sortOrder + ", cursor=" + cursor + ", locationId=" + locationId
                + ", status=" + status + ", sourceType=" + sourceType + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link ListPaymentRefundsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPaymentRefundsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .beginTime(getBeginTime())
                .endTime(getEndTime())
                .sortOrder(getSortOrder())
                .cursor(getCursor())
                .locationId(getLocationId())
                .status(getStatus())
                .sourceType(getSourceType())
                .limit(getLimit());
        return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentRefundsRequest}.
     */
    public static class Builder {
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;
        private String locationId;
        private String status;
        private String sourceType;
        private Integer limit;



        /**
         * Setter for beginTime.
         * @param beginTime String value for beginTime.
         * @return Builder
         */
        public Builder beginTime(String beginTime) {
            this.beginTime = beginTime;
            return this;
        }

        /**
         * Setter for endTime.
         * @param endTime String value for endTime.
         * @return Builder
         */
        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        /**
         * Setter for sortOrder.
         * @param sortOrder String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for locationId.
         * @param locationId String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for status.
         * @param status String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for sourceType.
         * @param sourceType String value for sourceType.
         * @return Builder
         */
        public Builder sourceType(String sourceType) {
            this.sourceType = sourceType;
            return this;
        }

        /**
         * Setter for limit.
         * @param limit Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds a new {@link ListPaymentRefundsRequest} object using the set fields.
         * @return {@link ListPaymentRefundsRequest}
         */
        public ListPaymentRefundsRequest build() {
            return new ListPaymentRefundsRequest(beginTime, endTime, sortOrder, cursor, locationId,
                    status, sourceType, limit);
        }
    }
}

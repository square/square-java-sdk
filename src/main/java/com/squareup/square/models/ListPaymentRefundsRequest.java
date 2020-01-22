package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListPaymentRefundsRequest type.
 */
public class ListPaymentRefundsRequest {

    /**
     * Initialization constructor.
     * @param beginTime
     * @param endTime
     * @param sortOrder
     * @param cursor
     * @param locationId
     * @param status
     * @param sourceType
     */
    @JsonCreator
    public ListPaymentRefundsRequest(
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("status") String status,
            @JsonProperty("source_type") String sourceType) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
        this.locationId = locationId;
        this.status = status;
        this.sourceType = sourceType;
    }

    private final String beginTime;
    private final String endTime;
    private final String sortOrder;
    private final String cursor;
    private final String locationId;
    private final String status;
    private final String sourceType;
    /**
     * Getter for BeginTime.
     * Timestamp for the beginning of the requested reporting period, in RFC 3339 format.
     * Default: The current time minus one year.
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * Timestamp for the end of the requested reporting period, in RFC 3339 format.
     * Default: The current time.
     */
    @JsonGetter("end_time")
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * Getter for SortOrder.
     * The order in which results are listed.
     * - `ASC` - oldest to newest
     * - `DESC` - newest to oldest (default).
     */
    @JsonGetter("sort_order")
    public String getSortOrder() {
        return this.sortOrder;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for the original query.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for LocationId.
     * ID of location associated with payment.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Status.
     * If provided, only refunds with the given status are returned.
     * For a list of refund status values, see [PaymentRefund](#type-paymentrefund).
     * Default: If omitted refunds are returned regardless of status.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for SourceType.
     * If provided, only refunds with the given source type are returned.
     * - `CARD` - List refunds only for payments where card was specified as payment
     * source.
     * Default: If omitted refunds are returned regardless of source type.
     */
    @JsonGetter("source_type")
    public String getSourceType() {
        return this.sourceType;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor, locationId, status, sourceType);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListPaymentRefundsRequest)) {
            return false;
        }
        ListPaymentRefundsRequest listPaymentRefundsRequest = (ListPaymentRefundsRequest) obj;
        return Objects.equals(beginTime, listPaymentRefundsRequest.beginTime) &&
            Objects.equals(endTime, listPaymentRefundsRequest.endTime) &&
            Objects.equals(sortOrder, listPaymentRefundsRequest.sortOrder) &&
            Objects.equals(cursor, listPaymentRefundsRequest.cursor) &&
            Objects.equals(locationId, listPaymentRefundsRequest.locationId) &&
            Objects.equals(status, listPaymentRefundsRequest.status) &&
            Objects.equals(sourceType, listPaymentRefundsRequest.sourceType);
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
            .sourceType(getSourceType());
            return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentRefundsRequest}
     */
    public static class Builder {
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;
        private String locationId;
        private String status;
        private String sourceType;

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
         * Setter for sourceType
         * @param sourceType
         * @return Builder
         */
        public Builder sourceType(String sourceType) {
            this.sourceType = sourceType;
            return this;
        }

        /**
         * Builds a new {@link ListPaymentRefundsRequest} object using the set fields.
         * @return {@link ListPaymentRefundsRequest}
         */
        public ListPaymentRefundsRequest build() {
            return new ListPaymentRefundsRequest(beginTime,
                endTime,
                sortOrder,
                cursor,
                locationId,
                status,
                sourceType);
        }
    }
}

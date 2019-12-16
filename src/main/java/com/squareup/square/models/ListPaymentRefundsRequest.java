package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListPaymentRefundsRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor, locationId, status, sourceType);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListPaymentRefundsRequest)) {
            return false;
        }
        ListPaymentRefundsRequest listPaymentRefundsRequest = (ListPaymentRefundsRequest) o;
        return Objects.equals(beginTime, listPaymentRefundsRequest.beginTime) &&
            Objects.equals(endTime, listPaymentRefundsRequest.endTime) &&
            Objects.equals(sortOrder, listPaymentRefundsRequest.sortOrder) &&
            Objects.equals(cursor, listPaymentRefundsRequest.cursor) &&
            Objects.equals(locationId, listPaymentRefundsRequest.locationId) &&
            Objects.equals(status, listPaymentRefundsRequest.status) &&
            Objects.equals(sourceType, listPaymentRefundsRequest.sourceType);
    }

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

    public static class Builder {
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;
        private String locationId;
        private String status;
        private String sourceType;

        public Builder() { }

        public Builder beginTime(String value) {
            beginTime = value;
            return this;
        }
        public Builder endTime(String value) {
            endTime = value;
            return this;
        }
        public Builder sortOrder(String value) {
            sortOrder = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder sourceType(String value) {
            sourceType = value;
            return this;
        }

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

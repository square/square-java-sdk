package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListPaymentsRequest {

    @JsonCreator
    public ListPaymentsRequest(
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("total") Long total,
            @JsonProperty("last_4") String last4,
            @JsonProperty("card_brand") String cardBrand) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
        this.locationId = locationId;
        this.total = total;
        this.last4 = last4;
        this.cardBrand = cardBrand;
    }

    private final String beginTime;
    private final String endTime;
    private final String sortOrder;
    private final String cursor;
    private final String locationId;
    private final Long total;
    private final String last4;
    private final String cardBrand;

    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor, locationId, total, last4, cardBrand);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListPaymentsRequest)) {
            return false;
        }
        ListPaymentsRequest listPaymentsRequest = (ListPaymentsRequest) o;
        return Objects.equals(beginTime, listPaymentsRequest.beginTime) &&
            Objects.equals(endTime, listPaymentsRequest.endTime) &&
            Objects.equals(sortOrder, listPaymentsRequest.sortOrder) &&
            Objects.equals(cursor, listPaymentsRequest.cursor) &&
            Objects.equals(locationId, listPaymentsRequest.locationId) &&
            Objects.equals(total, listPaymentsRequest.total) &&
            Objects.equals(last4, listPaymentsRequest.last4) &&
            Objects.equals(cardBrand, listPaymentsRequest.cardBrand);
    }

    /**
     * Getter for BeginTime.
     * Timestamp for the beginning of the reporting period, in RFC 3339 format.
     * Inclusive. Default: The current time minus one year.
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
     * ID of location associated with payment
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for Total.
     * The exact amount in the total_money for a `Payment`.
     */
    @JsonGetter("total")
    public Long getTotal() { 
        return this.total;
    }

    /**
     * Getter for Last4.
     * The last 4 digits of `Payment` card.
     */
    @JsonGetter("last_4")
    public String getLast4() { 
        return this.last4;
    }

    /**
     * Getter for CardBrand.
     * The brand of `Payment` card. For example, `VISA`
     */
    @JsonGetter("card_brand")
    public String getCardBrand() { 
        return this.cardBrand;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .beginTime(getBeginTime())
            .endTime(getEndTime())
            .sortOrder(getSortOrder())
            .cursor(getCursor())
            .locationId(getLocationId())
            .total(getTotal())
            .last4(getLast4())
            .cardBrand(getCardBrand());
            return builder;
    }

    public static class Builder {
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;
        private String locationId;
        private Long total;
        private String last4;
        private String cardBrand;

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
        public Builder total(Long value) {
            total = value;
            return this;
        }
        public Builder last4(String value) {
            last4 = value;
            return this;
        }
        public Builder cardBrand(String value) {
            cardBrand = value;
            return this;
        }

        public ListPaymentsRequest build() {
            return new ListPaymentsRequest(beginTime,
                endTime,
                sortOrder,
                cursor,
                locationId,
                total,
                last4,
                cardBrand);
        }
    }
}

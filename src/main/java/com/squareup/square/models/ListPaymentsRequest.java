
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ListPaymentsRequest type.
 */
public class ListPaymentsRequest {
    private final String beginTime;
    private final String endTime;
    private final String sortOrder;
    private final String cursor;
    private final String locationId;
    private final Long total;
    private final String last4;
    private final String cardBrand;
    private final Integer limit;

    /**
     * Initialization constructor.
     * @param beginTime String value for beginTime.
     * @param endTime String value for endTime.
     * @param sortOrder String value for sortOrder.
     * @param cursor String value for cursor.
     * @param locationId String value for locationId.
     * @param total Long value for total.
     * @param last4 String value for last4.
     * @param cardBrand String value for cardBrand.
     * @param limit Integer value for limit.
     */
    @JsonCreator
    public ListPaymentsRequest(
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("sort_order") String sortOrder,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("total") Long total,
            @JsonProperty("last_4") String last4,
            @JsonProperty("card_brand") String cardBrand,
            @JsonProperty("limit") Integer limit) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
        this.locationId = locationId;
        this.total = total;
        this.last4 = last4;
        this.cardBrand = cardBrand;
        this.limit = limit;
    }

    /**
     * Getter for BeginTime.
     * The timestamp for the beginning of the reporting period, in RFC 3339 format. Inclusive.
     * Default: The current time minus one year.
     * @return Returns the String
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The timestamp for the end of the reporting period, in RFC 3339 format. Default: The current
     * time.
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
     * Limit results to the location supplied. By default, results are returned for the default
     * (main) location associated with the seller.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Total.
     * The exact amount in the `total_money` for a payment.
     * @return Returns the Long
     */
    @JsonGetter("total")
    public Long getTotal() {
        return this.total;
    }

    /**
     * Getter for Last4.
     * The last four digits of a payment card.
     * @return Returns the String
     */
    @JsonGetter("last_4")
    public String getLast4() {
        return this.last4;
    }

    /**
     * Getter for CardBrand.
     * The brand of the payment card (for example, VISA).
     * @return Returns the String
     */
    @JsonGetter("card_brand")
    public String getCardBrand() {
        return this.cardBrand;
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
    public Integer getLimit() {
        return this.limit;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor, locationId, total, last4,
                cardBrand, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListPaymentsRequest)) {
            return false;
        }
        ListPaymentsRequest other = (ListPaymentsRequest) obj;
        return Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime)
            && Objects.equals(sortOrder, other.sortOrder)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(total, other.total)
            && Objects.equals(last4, other.last4)
            && Objects.equals(cardBrand, other.cardBrand)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Builds a new {@link ListPaymentsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPaymentsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .beginTime(getBeginTime())
            .endTime(getEndTime())
            .sortOrder(getSortOrder())
            .cursor(getCursor())
            .locationId(getLocationId())
            .total(getTotal())
            .last4(getLast4())
            .cardBrand(getCardBrand())
            .limit(getLimit());
        return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentsRequest}.
     */
    public static class Builder {
        private String beginTime;
        private String endTime;
        private String sortOrder;
        private String cursor;
        private String locationId;
        private Long total;
        private String last4;
        private String cardBrand;
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
         * Setter for total.
         * @param total Long value for total.
         * @return Builder
         */
        public Builder total(Long total) {
            this.total = total;
            return this;
        }

        /**
         * Setter for last4.
         * @param last4 String value for last4.
         * @return Builder
         */
        public Builder last4(String last4) {
            this.last4 = last4;
            return this;
        }

        /**
         * Setter for cardBrand.
         * @param cardBrand String value for cardBrand.
         * @return Builder
         */
        public Builder cardBrand(String cardBrand) {
            this.cardBrand = cardBrand;
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
         * Builds a new {@link ListPaymentsRequest} object using the set fields.
         * @return {@link ListPaymentsRequest}
         */
        public ListPaymentsRequest build() {
            return new ListPaymentsRequest(beginTime,
                endTime,
                sortOrder,
                cursor,
                locationId,
                total,
                last4,
                cardBrand,
                limit);
        }
    }
}

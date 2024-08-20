
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
 * This is a model class for ListPaymentsRequest type.
 */
public class ListPaymentsRequest {
    private final OptionalNullable<String> beginTime;
    private final OptionalNullable<String> endTime;
    private final OptionalNullable<String> sortOrder;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<Long> total;
    private final OptionalNullable<String> last4;
    private final OptionalNullable<String> cardBrand;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<Boolean> isOfflinePayment;
    private final OptionalNullable<String> offlineBeginTime;
    private final OptionalNullable<String> offlineEndTime;

    /**
     * Initialization constructor.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  sortOrder  String value for sortOrder.
     * @param  cursor  String value for cursor.
     * @param  locationId  String value for locationId.
     * @param  total  Long value for total.
     * @param  last4  String value for last4.
     * @param  cardBrand  String value for cardBrand.
     * @param  limit  Integer value for limit.
     * @param  isOfflinePayment  Boolean value for isOfflinePayment.
     * @param  offlineBeginTime  String value for offlineBeginTime.
     * @param  offlineEndTime  String value for offlineEndTime.
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
            @JsonProperty("limit") Integer limit,
            @JsonProperty("is_offline_payment") Boolean isOfflinePayment,
            @JsonProperty("offline_begin_time") String offlineBeginTime,
            @JsonProperty("offline_end_time") String offlineEndTime) {
        this.beginTime = OptionalNullable.of(beginTime);
        this.endTime = OptionalNullable.of(endTime);
        this.sortOrder = OptionalNullable.of(sortOrder);
        this.cursor = OptionalNullable.of(cursor);
        this.locationId = OptionalNullable.of(locationId);
        this.total = OptionalNullable.of(total);
        this.last4 = OptionalNullable.of(last4);
        this.cardBrand = OptionalNullable.of(cardBrand);
        this.limit = OptionalNullable.of(limit);
        this.isOfflinePayment = OptionalNullable.of(isOfflinePayment);
        this.offlineBeginTime = OptionalNullable.of(offlineBeginTime);
        this.offlineEndTime = OptionalNullable.of(offlineEndTime);
    }

    /**
     * Initialization constructor.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  sortOrder  String value for sortOrder.
     * @param  cursor  String value for cursor.
     * @param  locationId  String value for locationId.
     * @param  total  Long value for total.
     * @param  last4  String value for last4.
     * @param  cardBrand  String value for cardBrand.
     * @param  limit  Integer value for limit.
     * @param  isOfflinePayment  Boolean value for isOfflinePayment.
     * @param  offlineBeginTime  String value for offlineBeginTime.
     * @param  offlineEndTime  String value for offlineEndTime.
     */

    protected ListPaymentsRequest(OptionalNullable<String> beginTime,
            OptionalNullable<String> endTime, OptionalNullable<String> sortOrder,
            OptionalNullable<String> cursor, OptionalNullable<String> locationId,
            OptionalNullable<Long> total, OptionalNullable<String> last4,
            OptionalNullable<String> cardBrand, OptionalNullable<Integer> limit,
            OptionalNullable<Boolean> isOfflinePayment, OptionalNullable<String> offlineBeginTime,
            OptionalNullable<String> offlineEndTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.sortOrder = sortOrder;
        this.cursor = cursor;
        this.locationId = locationId;
        this.total = total;
        this.last4 = last4;
        this.cardBrand = cardBrand;
        this.limit = limit;
        this.isOfflinePayment = isOfflinePayment;
        this.offlineBeginTime = offlineBeginTime;
        this.offlineEndTime = offlineEndTime;
    }

    /**
     * Internal Getter for BeginTime.
     * Indicates the start of the time range to retrieve payments for, in RFC 3339 format. The range
     * is determined using the `created_at` field for each Payment. Inclusive. Default: The current
     * time minus one year.
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
     * Indicates the start of the time range to retrieve payments for, in RFC 3339 format. The range
     * is determined using the `created_at` field for each Payment. Inclusive. Default: The current
     * time minus one year.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBeginTime() {
        return OptionalNullable.getFrom(beginTime);
    }

    /**
     * Internal Getter for EndTime.
     * Indicates the end of the time range to retrieve payments for, in RFC 3339 format. The range
     * is determined using the `created_at` field for each Payment. Default: The current time.
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
     * Indicates the end of the time range to retrieve payments for, in RFC 3339 format. The range
     * is determined using the `created_at` field for each Payment. Default: The current time.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndTime() {
        return OptionalNullable.getFrom(endTime);
    }

    /**
     * Internal Getter for SortOrder.
     * The order in which results are listed by `Payment.created_at`: - `ASC` - Oldest to newest. -
     * `DESC` - Newest to oldest (default).
     * @return Returns the Internal String
     */
    @JsonGetter("sort_order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSortOrder() {
        return this.sortOrder;
    }

    /**
     * Getter for SortOrder.
     * The order in which results are listed by `Payment.created_at`: - `ASC` - Oldest to newest. -
     * `DESC` - Newest to oldest (default).
     * @return Returns the String
     */
    @JsonIgnore
    public String getSortOrder() {
        return OptionalNullable.getFrom(sortOrder);
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
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
     * A pagination cursor returned by a previous call to this endpoint. Provide this cursor to
     * retrieve the next set of results for the original query. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for LocationId.
     * Limit results to the location supplied. By default, results are returned for the default
     * (main) location associated with the seller.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * Limit results to the location supplied. By default, results are returned for the default
     * (main) location associated with the seller.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for Total.
     * The exact amount in the `total_money` for a payment.
     * @return Returns the Internal Long
     */
    @JsonGetter("total")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetTotal() {
        return this.total;
    }

    /**
     * Getter for Total.
     * The exact amount in the `total_money` for a payment.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getTotal() {
        return OptionalNullable.getFrom(total);
    }

    /**
     * Internal Getter for Last4.
     * The last four digits of a payment card.
     * @return Returns the Internal String
     */
    @JsonGetter("last_4")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLast4() {
        return this.last4;
    }

    /**
     * Getter for Last4.
     * The last four digits of a payment card.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLast4() {
        return OptionalNullable.getFrom(last4);
    }

    /**
     * Internal Getter for CardBrand.
     * The brand of the payment card (for example, VISA).
     * @return Returns the Internal String
     */
    @JsonGetter("card_brand")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCardBrand() {
        return this.cardBrand;
    }

    /**
     * Getter for CardBrand.
     * The brand of the payment card (for example, VISA).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCardBrand() {
        return OptionalNullable.getFrom(cardBrand);
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. The default value of 100 is also the
     * maximum allowed value. If the provided value is greater than 100, it is ignored and the
     * default value is used instead. Default: `100`
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
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. The default value of 100 is also the
     * maximum allowed value. If the provided value is greater than 100, it is ignored and the
     * default value is used instead. Default: `100`
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for IsOfflinePayment.
     * Whether the payment was taken offline or not.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_offline_payment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsOfflinePayment() {
        return this.isOfflinePayment;
    }

    /**
     * Getter for IsOfflinePayment.
     * Whether the payment was taken offline or not.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsOfflinePayment() {
        return OptionalNullable.getFrom(isOfflinePayment);
    }

    /**
     * Internal Getter for OfflineBeginTime.
     * Indicates the start of the time range for which to retrieve offline payments, in RFC 3339
     * format for timestamps. The range is determined using the
     * `offline_payment_details.client_created_at` field for each Payment. If set, payments without
     * a value set in `offline_payment_details.client_created_at` will not be returned. Default: The
     * current time.
     * @return Returns the Internal String
     */
    @JsonGetter("offline_begin_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOfflineBeginTime() {
        return this.offlineBeginTime;
    }

    /**
     * Getter for OfflineBeginTime.
     * Indicates the start of the time range for which to retrieve offline payments, in RFC 3339
     * format for timestamps. The range is determined using the
     * `offline_payment_details.client_created_at` field for each Payment. If set, payments without
     * a value set in `offline_payment_details.client_created_at` will not be returned. Default: The
     * current time.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOfflineBeginTime() {
        return OptionalNullable.getFrom(offlineBeginTime);
    }

    /**
     * Internal Getter for OfflineEndTime.
     * Indicates the end of the time range for which to retrieve offline payments, in RFC 3339
     * format for timestamps. The range is determined using the
     * `offline_payment_details.client_created_at` field for each Payment. If set, payments without
     * a value set in `offline_payment_details.client_created_at` will not be returned. Default: The
     * current time.
     * @return Returns the Internal String
     */
    @JsonGetter("offline_end_time")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOfflineEndTime() {
        return this.offlineEndTime;
    }

    /**
     * Getter for OfflineEndTime.
     * Indicates the end of the time range for which to retrieve offline payments, in RFC 3339
     * format for timestamps. The range is determined using the
     * `offline_payment_details.client_created_at` field for each Payment. If set, payments without
     * a value set in `offline_payment_details.client_created_at` will not be returned. Default: The
     * current time.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOfflineEndTime() {
        return OptionalNullable.getFrom(offlineEndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginTime, endTime, sortOrder, cursor, locationId, total, last4,
                cardBrand, limit, isOfflinePayment, offlineBeginTime, offlineEndTime);
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
            && Objects.equals(limit, other.limit)
            && Objects.equals(isOfflinePayment, other.isOfflinePayment)
            && Objects.equals(offlineBeginTime, other.offlineBeginTime)
            && Objects.equals(offlineEndTime, other.offlineEndTime);
    }

    /**
     * Converts this ListPaymentsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListPaymentsRequest [" + "beginTime=" + beginTime + ", endTime=" + endTime
                + ", sortOrder=" + sortOrder + ", cursor=" + cursor + ", locationId=" + locationId
                + ", total=" + total + ", last4=" + last4 + ", cardBrand=" + cardBrand + ", limit="
                + limit + ", isOfflinePayment=" + isOfflinePayment + ", offlineBeginTime="
                + offlineBeginTime + ", offlineEndTime=" + offlineEndTime + "]";
    }

    /**
     * Builds a new {@link ListPaymentsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListPaymentsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.beginTime = internalGetBeginTime();
        builder.endTime = internalGetEndTime();
        builder.sortOrder = internalGetSortOrder();
        builder.cursor = internalGetCursor();
        builder.locationId = internalGetLocationId();
        builder.total = internalGetTotal();
        builder.last4 = internalGetLast4();
        builder.cardBrand = internalGetCardBrand();
        builder.limit = internalGetLimit();
        builder.isOfflinePayment = internalGetIsOfflinePayment();
        builder.offlineBeginTime = internalGetOfflineBeginTime();
        builder.offlineEndTime = internalGetOfflineEndTime();
        return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> beginTime;
        private OptionalNullable<String> endTime;
        private OptionalNullable<String> sortOrder;
        private OptionalNullable<String> cursor;
        private OptionalNullable<String> locationId;
        private OptionalNullable<Long> total;
        private OptionalNullable<String> last4;
        private OptionalNullable<String> cardBrand;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<Boolean> isOfflinePayment;
        private OptionalNullable<String> offlineBeginTime;
        private OptionalNullable<String> offlineEndTime;



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
         * Setter for sortOrder.
         * @param  sortOrder  String value for sortOrder.
         * @return Builder
         */
        public Builder sortOrder(String sortOrder) {
            this.sortOrder = OptionalNullable.of(sortOrder);
            return this;
        }

        /**
         * UnSetter for sortOrder.
         * @return Builder
         */
        public Builder unsetSortOrder() {
            sortOrder = null;
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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for total.
         * @param  total  Long value for total.
         * @return Builder
         */
        public Builder total(Long total) {
            this.total = OptionalNullable.of(total);
            return this;
        }

        /**
         * UnSetter for total.
         * @return Builder
         */
        public Builder unsetTotal() {
            total = null;
            return this;
        }

        /**
         * Setter for last4.
         * @param  last4  String value for last4.
         * @return Builder
         */
        public Builder last4(String last4) {
            this.last4 = OptionalNullable.of(last4);
            return this;
        }

        /**
         * UnSetter for last4.
         * @return Builder
         */
        public Builder unsetLast4() {
            last4 = null;
            return this;
        }

        /**
         * Setter for cardBrand.
         * @param  cardBrand  String value for cardBrand.
         * @return Builder
         */
        public Builder cardBrand(String cardBrand) {
            this.cardBrand = OptionalNullable.of(cardBrand);
            return this;
        }

        /**
         * UnSetter for cardBrand.
         * @return Builder
         */
        public Builder unsetCardBrand() {
            cardBrand = null;
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
         * Setter for isOfflinePayment.
         * @param  isOfflinePayment  Boolean value for isOfflinePayment.
         * @return Builder
         */
        public Builder isOfflinePayment(Boolean isOfflinePayment) {
            this.isOfflinePayment = OptionalNullable.of(isOfflinePayment);
            return this;
        }

        /**
         * UnSetter for isOfflinePayment.
         * @return Builder
         */
        public Builder unsetIsOfflinePayment() {
            isOfflinePayment = null;
            return this;
        }

        /**
         * Setter for offlineBeginTime.
         * @param  offlineBeginTime  String value for offlineBeginTime.
         * @return Builder
         */
        public Builder offlineBeginTime(String offlineBeginTime) {
            this.offlineBeginTime = OptionalNullable.of(offlineBeginTime);
            return this;
        }

        /**
         * UnSetter for offlineBeginTime.
         * @return Builder
         */
        public Builder unsetOfflineBeginTime() {
            offlineBeginTime = null;
            return this;
        }

        /**
         * Setter for offlineEndTime.
         * @param  offlineEndTime  String value for offlineEndTime.
         * @return Builder
         */
        public Builder offlineEndTime(String offlineEndTime) {
            this.offlineEndTime = OptionalNullable.of(offlineEndTime);
            return this;
        }

        /**
         * UnSetter for offlineEndTime.
         * @return Builder
         */
        public Builder unsetOfflineEndTime() {
            offlineEndTime = null;
            return this;
        }

        /**
         * Builds a new {@link ListPaymentsRequest} object using the set fields.
         * @return {@link ListPaymentsRequest}
         */
        public ListPaymentsRequest build() {
            return new ListPaymentsRequest(beginTime, endTime, sortOrder, cursor, locationId, total,
                    last4, cardBrand, limit, isOfflinePayment, offlineBeginTime, offlineEndTime);
        }
    }
}

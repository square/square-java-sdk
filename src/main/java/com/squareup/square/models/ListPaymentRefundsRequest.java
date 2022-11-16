
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListPaymentRefundsRequest type.
 */
public class ListPaymentRefundsRequest {
    private final OptionalNullable<String> beginTime;
    private final OptionalNullable<String> endTime;
    private final OptionalNullable<String> sortOrder;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> status;
    private final OptionalNullable<String> sourceType;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  sortOrder  String value for sortOrder.
     * @param  cursor  String value for cursor.
     * @param  locationId  String value for locationId.
     * @param  status  String value for status.
     * @param  sourceType  String value for sourceType.
     * @param  limit  Integer value for limit.
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
        this.beginTime = OptionalNullable.of(beginTime);
        this.endTime = OptionalNullable.of(endTime);
        this.sortOrder = OptionalNullable.of(sortOrder);
        this.cursor = OptionalNullable.of(cursor);
        this.locationId = OptionalNullable.of(locationId);
        this.status = OptionalNullable.of(status);
        this.sourceType = OptionalNullable.of(sourceType);
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Internal initialization constructor.
     */
    protected ListPaymentRefundsRequest(OptionalNullable<String> beginTime,
            OptionalNullable<String> endTime, OptionalNullable<String> sortOrder,
            OptionalNullable<String> cursor, OptionalNullable<String> locationId,
            OptionalNullable<String> status, OptionalNullable<String> sourceType,
            OptionalNullable<Integer> limit) {
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
     * Internal Getter for BeginTime.
     * The timestamp for the beginning of the requested reporting period, in RFC 3339 format.
     * Default: The current time minus one year.
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
     * The timestamp for the beginning of the requested reporting period, in RFC 3339 format.
     * Default: The current time minus one year.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBeginTime() {
        return OptionalNullable.getFrom(beginTime);
    }

    /**
     * Internal Getter for EndTime.
     * The timestamp for the end of the requested reporting period, in RFC 3339 format. Default: The
     * current time.
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
     * The timestamp for the end of the requested reporting period, in RFC 3339 format. Default: The
     * current time.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndTime() {
        return OptionalNullable.getFrom(endTime);
    }

    /**
     * Internal Getter for SortOrder.
     * The order in which results are listed: - `ASC` - Oldest to newest. - `DESC` - Newest to
     * oldest (default).
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
     * The order in which results are listed: - `ASC` - Oldest to newest. - `DESC` - Newest to
     * oldest (default).
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
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
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
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    /**
     * Internal Getter for LocationId.
     * Limit results to the location supplied. By default, results are returned for all locations
     * associated with the seller.
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
     * Limit results to the location supplied. By default, results are returned for all locations
     * associated with the seller.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for Status.
     * If provided, only refunds with the given status are returned. For a list of refund status
     * values, see [PaymentRefund]($m/PaymentRefund). Default: If omitted, refunds are returned
     * regardless of their status.
     * @return Returns the Internal String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStatus() {
        return this.status;
    }

    /**
     * Getter for Status.
     * If provided, only refunds with the given status are returned. For a list of refund status
     * values, see [PaymentRefund]($m/PaymentRefund). Default: If omitted, refunds are returned
     * regardless of their status.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStatus() {
        return OptionalNullable.getFrom(status);
    }

    /**
     * Internal Getter for SourceType.
     * If provided, only returns refunds whose payments have the indicated source type. Current
     * values include `CARD`, `BANK_ACCOUNT`, `WALLET`, `CASH`, and `EXTERNAL`. For information
     * about these payment source types, see [Take
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments). Default: If
     * omitted, refunds are returned regardless of the source type.
     * @return Returns the Internal String
     */
    @JsonGetter("source_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSourceType() {
        return this.sourceType;
    }

    /**
     * Getter for SourceType.
     * If provided, only returns refunds whose payments have the indicated source type. Current
     * values include `CARD`, `BANK_ACCOUNT`, `WALLET`, `CASH`, and `EXTERNAL`. For information
     * about these payment source types, see [Take
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments). Default: If
     * omitted, refunds are returned regardless of the source type.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSourceType() {
        return OptionalNullable.getFrom(sourceType);
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of results to be returned in a single page. It is possible to receive
     * fewer results than the specified limit on a given page. If the supplied value is greater than
     * 100, no more than 100 results are returned. Default: 100
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
     * fewer results than the specified limit on a given page. If the supplied value is greater than
     * 100, no more than 100 results are returned. Default: 100
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
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
        Builder builder = new Builder();
        builder.beginTime = internalGetBeginTime();
        builder.endTime = internalGetEndTime();
        builder.sortOrder = internalGetSortOrder();
        builder.cursor = internalGetCursor();
        builder.locationId = internalGetLocationId();
        builder.status = internalGetStatus();
        builder.sourceType = internalGetSourceType();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link ListPaymentRefundsRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> beginTime;
        private OptionalNullable<String> endTime;
        private OptionalNullable<String> sortOrder;
        private OptionalNullable<String> cursor;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> status;
        private OptionalNullable<String> sourceType;
        private OptionalNullable<Integer> limit;



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
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = OptionalNullable.of(status);
            return this;
        }

        /**
         * UnSetter for status.
         * @return Builder
         */
        public Builder unsetStatus() {
            status = null;
            return this;
        }

        /**
         * Setter for sourceType.
         * @param  sourceType  String value for sourceType.
         * @return Builder
         */
        public Builder sourceType(String sourceType) {
            this.sourceType = OptionalNullable.of(sourceType);
            return this;
        }

        /**
         * UnSetter for sourceType.
         * @return Builder
         */
        public Builder unsetSourceType() {
            sourceType = null;
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
         * Builds a new {@link ListPaymentRefundsRequest} object using the set fields.
         * @return {@link ListPaymentRefundsRequest}
         */
        public ListPaymentRefundsRequest build() {
            return new ListPaymentRefundsRequest(beginTime, endTime, sortOrder, cursor, locationId,
                    status, sourceType, limit);
        }
    }
}

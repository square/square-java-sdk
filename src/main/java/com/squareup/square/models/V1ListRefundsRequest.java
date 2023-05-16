
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
 * This is a model class for V1ListRefundsRequest type.
 */
public class V1ListRefundsRequest {
    private final String order;
    private final OptionalNullable<String> beginTime;
    private final OptionalNullable<String> endTime;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> batchToken;

    /**
     * Initialization constructor.
     * @param  order  String value for order.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  limit  Integer value for limit.
     * @param  batchToken  String value for batchToken.
     */
    @JsonCreator
    public V1ListRefundsRequest(
            @JsonProperty("order") String order,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
        this.order = order;
        this.beginTime = OptionalNullable.of(beginTime);
        this.endTime = OptionalNullable.of(endTime);
        this.limit = OptionalNullable.of(limit);
        this.batchToken = OptionalNullable.of(batchToken);
    }

    /**
     * Internal initialization constructor.
     */
    protected V1ListRefundsRequest(String order, OptionalNullable<String> beginTime,
            OptionalNullable<String> endTime, OptionalNullable<Integer> limit,
            OptionalNullable<String> batchToken) {
        this.order = order;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limit = limit;
        this.batchToken = batchToken;
    }

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrder() {
        return order;
    }

    /**
     * Internal Getter for BeginTime.
     * The beginning of the requested reporting period, in ISO 8601 format. If this value is before
     * January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The
     * current time minus one year.
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
     * The beginning of the requested reporting period, in ISO 8601 format. If this value is before
     * January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The
     * current time minus one year.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBeginTime() {
        return OptionalNullable.getFrom(beginTime);
    }

    /**
     * Internal Getter for EndTime.
     * The end of the requested reporting period, in ISO 8601 format. If this value is more than one
     * year greater than begin_time, this endpoint returns an error. Default value: The current
     * time.
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
     * The end of the requested reporting period, in ISO 8601 format. If this value is more than one
     * year greater than begin_time, this endpoint returns an error. Default value: The current
     * time.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEndTime() {
        return OptionalNullable.getFrom(endTime);
    }

    /**
     * Internal Getter for Limit.
     * The approximate number of refunds to return in a single response. Default: 100. Max: 200.
     * Response may contain more results than the prescribed limit when refunds are made
     * simultaneously to multiple tenders in a payment or when refunds are generated in an exchange
     * to account for the value of returned goods.
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
     * The approximate number of refunds to return in a single response. Default: 100. Max: 200.
     * Response may contain more results than the prescribed limit when refunds are made
     * simultaneously to multiple tenders in a payment or when refunds are generated in an exchange
     * to account for the value of returned goods.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    /**
     * Internal Getter for BatchToken.
     * A pagination cursor to retrieve the next set of results for your original query to the
     * endpoint.
     * @return Returns the Internal String
     */
    @JsonGetter("batch_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBatchToken() {
        return this.batchToken;
    }

    /**
     * Getter for BatchToken.
     * A pagination cursor to retrieve the next set of results for your original query to the
     * endpoint.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBatchToken() {
        return OptionalNullable.getFrom(batchToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, beginTime, endTime, limit, batchToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListRefundsRequest)) {
            return false;
        }
        V1ListRefundsRequest other = (V1ListRefundsRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime)
            && Objects.equals(limit, other.limit)
            && Objects.equals(batchToken, other.batchToken);
    }

    /**
     * Converts this V1ListRefundsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListRefundsRequest [" + "order=" + order + ", beginTime=" + beginTime
                + ", endTime=" + endTime + ", limit=" + limit + ", batchToken=" + batchToken + "]";
    }

    /**
     * Builds a new {@link V1ListRefundsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListRefundsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .order(getOrder());
        builder.beginTime = internalGetBeginTime();
        builder.endTime = internalGetEndTime();
        builder.limit = internalGetLimit();
        builder.batchToken = internalGetBatchToken();
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListRefundsRequest}.
     */
    public static class Builder {
        private String order;
        private OptionalNullable<String> beginTime;
        private OptionalNullable<String> endTime;
        private OptionalNullable<Integer> limit;
        private OptionalNullable<String> batchToken;



        /**
         * Setter for order.
         * @param  order  String value for order.
         * @return Builder
         */
        public Builder order(String order) {
            this.order = order;
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
         * Setter for batchToken.
         * @param  batchToken  String value for batchToken.
         * @return Builder
         */
        public Builder batchToken(String batchToken) {
            this.batchToken = OptionalNullable.of(batchToken);
            return this;
        }

        /**
         * UnSetter for batchToken.
         * @return Builder
         */
        public Builder unsetBatchToken() {
            batchToken = null;
            return this;
        }

        /**
         * Builds a new {@link V1ListRefundsRequest} object using the set fields.
         * @return {@link V1ListRefundsRequest}
         */
        public V1ListRefundsRequest build() {
            return new V1ListRefundsRequest(order, beginTime, endTime, limit, batchToken);
        }
    }
}

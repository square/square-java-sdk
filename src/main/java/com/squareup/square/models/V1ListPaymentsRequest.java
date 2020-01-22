package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListPaymentsRequest type.
 */
public class V1ListPaymentsRequest {

    /**
     * Initialization constructor.
     * @param order
     * @param beginTime
     * @param endTime
     * @param limit
     * @param batchToken
     * @param includePartial
     */
    @JsonCreator
    public V1ListPaymentsRequest(
            @JsonProperty("order") String order,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken,
            @JsonProperty("include_partial") Boolean includePartial) {
        this.order = order;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limit = limit;
        this.batchToken = batchToken;
        this.includePartial = includePartial;
    }

    private final String order;
    private final String beginTime;
    private final String endTime;
    private final Integer limit;
    private final String batchToken;
    private final Boolean includePartial;
    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("order")
    public String getOrder() {
        return this.order;
    }

    /**
     * Getter for BeginTime.
     * The beginning of the requested reporting period, in ISO 8601 format. If this value is before January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The current time minus one year.
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The end of the requested reporting period, in ISO 8601 format. If this value is more than one year greater than begin_time, this endpoint returns an error. Default value: The current time.
     */
    @JsonGetter("end_time")
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * Getter for Limit.
     * The maximum number of payments to return in a single response. This value cannot exceed 200.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for BatchToken.
     * A pagination cursor to retrieve the next set of results for your
     * original query to the endpoint.
     */
    @JsonGetter("batch_token")
    public String getBatchToken() {
        return this.batchToken;
    }

    /**
     * Getter for IncludePartial.
     * Indicates whether or not to include partial payments in the response. Partial payments will have the tenders collected so far, but the itemizations will be empty until the payment is completed.
     */
    @JsonGetter("include_partial")
    public Boolean getIncludePartial() {
        return this.includePartial;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(order, beginTime, endTime, limit, batchToken, includePartial);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ListPaymentsRequest)) {
            return false;
        }
        V1ListPaymentsRequest v1ListPaymentsRequest = (V1ListPaymentsRequest) obj;
        return Objects.equals(order, v1ListPaymentsRequest.order) &&
            Objects.equals(beginTime, v1ListPaymentsRequest.beginTime) &&
            Objects.equals(endTime, v1ListPaymentsRequest.endTime) &&
            Objects.equals(limit, v1ListPaymentsRequest.limit) &&
            Objects.equals(batchToken, v1ListPaymentsRequest.batchToken) &&
            Objects.equals(includePartial, v1ListPaymentsRequest.includePartial);
    }

    /**
     * Builds a new {@link V1ListPaymentsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListPaymentsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .beginTime(getBeginTime())
            .endTime(getEndTime())
            .limit(getLimit())
            .batchToken(getBatchToken())
            .includePartial(getIncludePartial());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListPaymentsRequest}
     */
    public static class Builder {
        private String order;
        private String beginTime;
        private String endTime;
        private Integer limit;
        private String batchToken;
        private Boolean includePartial;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for order
         * @param order
         * @return Builder
         */
        public Builder order(String order) {
            this.order = order;
            return this;
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
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }
        /**
         * Setter for batchToken
         * @param batchToken
         * @return Builder
         */
        public Builder batchToken(String batchToken) {
            this.batchToken = batchToken;
            return this;
        }
        /**
         * Setter for includePartial
         * @param includePartial
         * @return Builder
         */
        public Builder includePartial(Boolean includePartial) {
            this.includePartial = includePartial;
            return this;
        }

        /**
         * Builds a new {@link V1ListPaymentsRequest} object using the set fields.
         * @return {@link V1ListPaymentsRequest}
         */
        public V1ListPaymentsRequest build() {
            return new V1ListPaymentsRequest(order,
                beginTime,
                endTime,
                limit,
                batchToken,
                includePartial);
        }
    }
}

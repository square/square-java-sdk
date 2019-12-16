package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListPaymentsRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(order, beginTime, endTime, limit, batchToken, includePartial);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListPaymentsRequest)) {
            return false;
        }
        V1ListPaymentsRequest v1ListPaymentsRequest = (V1ListPaymentsRequest) o;
        return Objects.equals(order, v1ListPaymentsRequest.order) &&
            Objects.equals(beginTime, v1ListPaymentsRequest.beginTime) &&
            Objects.equals(endTime, v1ListPaymentsRequest.endTime) &&
            Objects.equals(limit, v1ListPaymentsRequest.limit) &&
            Objects.equals(batchToken, v1ListPaymentsRequest.batchToken) &&
            Objects.equals(includePartial, v1ListPaymentsRequest.includePartial);
    }

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

    public static class Builder {
        private String order;
        private String beginTime;
        private String endTime;
        private Integer limit;
        private String batchToken;
        private Boolean includePartial;

        public Builder() { }

        public Builder order(String value) {
            order = value;
            return this;
        }
        public Builder beginTime(String value) {
            beginTime = value;
            return this;
        }
        public Builder endTime(String value) {
            endTime = value;
            return this;
        }
        public Builder limit(Integer value) {
            limit = value;
            return this;
        }
        public Builder batchToken(String value) {
            batchToken = value;
            return this;
        }
        public Builder includePartial(Boolean value) {
            includePartial = value;
            return this;
        }

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

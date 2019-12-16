package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListSettlementsRequest {

    @JsonCreator
    public V1ListSettlementsRequest(
            @JsonProperty("order") String order,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("status") String status,
            @JsonProperty("batch_token") String batchToken) {
        this.order = order;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limit = limit;
        this.status = status;
        this.batchToken = batchToken;
    }

    private final String order;
    private final String beginTime;
    private final String endTime;
    private final Integer limit;
    private final String status;
    private final String batchToken;

    @Override
    public int hashCode() {
        return Objects.hash(order, beginTime, endTime, limit, status, batchToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListSettlementsRequest)) {
            return false;
        }
        V1ListSettlementsRequest v1ListSettlementsRequest = (V1ListSettlementsRequest) o;
        return Objects.equals(order, v1ListSettlementsRequest.order) &&
            Objects.equals(beginTime, v1ListSettlementsRequest.beginTime) &&
            Objects.equals(endTime, v1ListSettlementsRequest.endTime) &&
            Objects.equals(limit, v1ListSettlementsRequest.limit) &&
            Objects.equals(status, v1ListSettlementsRequest.status) &&
            Objects.equals(batchToken, v1ListSettlementsRequest.batchToken);
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
     * Getter for Status.
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .beginTime(getBeginTime())
            .endTime(getEndTime())
            .limit(getLimit())
            .status(getStatus())
            .batchToken(getBatchToken());
            return builder;
    }

    public static class Builder {
        private String order;
        private String beginTime;
        private String endTime;
        private Integer limit;
        private String status;
        private String batchToken;

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
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder batchToken(String value) {
            batchToken = value;
            return this;
        }

        public V1ListSettlementsRequest build() {
            return new V1ListSettlementsRequest(order,
                beginTime,
                endTime,
                limit,
                status,
                batchToken);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListCashDrawerShiftsRequest {

    @JsonCreator
    public V1ListCashDrawerShiftsRequest(
            @JsonProperty("order") String order,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime) {
        this.order = order;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    private final String order;
    private final String beginTime;
    private final String endTime;

    @Override
    public int hashCode() {
        return Objects.hash(order, beginTime, endTime);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListCashDrawerShiftsRequest)) {
            return false;
        }
        V1ListCashDrawerShiftsRequest v1ListCashDrawerShiftsRequest = (V1ListCashDrawerShiftsRequest) o;
        return Objects.equals(order, v1ListCashDrawerShiftsRequest.order) &&
            Objects.equals(beginTime, v1ListCashDrawerShiftsRequest.beginTime) &&
            Objects.equals(endTime, v1ListCashDrawerShiftsRequest.endTime);
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
     * The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time minus 90 days.
     */
    @JsonGetter("begin_time")
    public String getBeginTime() { 
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The beginning of the requested reporting period, in ISO 8601 format. Default value: The current time.
     */
    @JsonGetter("end_time")
    public String getEndTime() { 
        return this.endTime;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .beginTime(getBeginTime())
            .endTime(getEndTime());
            return builder;
    }

    public static class Builder {
        private String order;
        private String beginTime;
        private String endTime;

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

        public V1ListCashDrawerShiftsRequest build() {
            return new V1ListCashDrawerShiftsRequest(order,
                beginTime,
                endTime);
        }
    }
}

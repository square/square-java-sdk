package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListCashDrawerShiftsRequest type.
 */
public class V1ListCashDrawerShiftsRequest {

    /**
     * Initialization constructor.
     * @param order
     * @param beginTime
     * @param endTime
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(order, beginTime, endTime);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ListCashDrawerShiftsRequest)) {
            return false;
        }
        V1ListCashDrawerShiftsRequest v1ListCashDrawerShiftsRequest = (V1ListCashDrawerShiftsRequest) obj;
        return Objects.equals(order, v1ListCashDrawerShiftsRequest.order) &&
            Objects.equals(beginTime, v1ListCashDrawerShiftsRequest.beginTime) &&
            Objects.equals(endTime, v1ListCashDrawerShiftsRequest.endTime);
    }

    /**
     * Builds a new {@link V1ListCashDrawerShiftsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListCashDrawerShiftsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .beginTime(getBeginTime())
            .endTime(getEndTime());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListCashDrawerShiftsRequest}
     */
    public static class Builder {
        private String order;
        private String beginTime;
        private String endTime;

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
         * Builds a new {@link V1ListCashDrawerShiftsRequest} object using the set fields.
         * @return {@link V1ListCashDrawerShiftsRequest}
         */
        public V1ListCashDrawerShiftsRequest build() {
            return new V1ListCashDrawerShiftsRequest(order,
                beginTime,
                endTime);
        }
    }
}

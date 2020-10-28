
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1ListCashDrawerShiftsRequest type.
 */
public class V1ListCashDrawerShiftsRequest {
    private final String order;
    private final String beginTime;
    private final String endTime;

    /**
     * Initialization constructor.
     * @param order String value for order.
     * @param beginTime String value for beginTime.
     * @param endTime String value for endTime.
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

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("order")
    public String getOrder() {
        return this.order;
    }

    /**
     * Getter for BeginTime.
     * The beginning of the requested reporting period, in ISO 8601 format. Default value: The
     * current time minus 90 days.
     * @return Returns the String
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The beginning of the requested reporting period, in ISO 8601 format. Default value: The
     * current time.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListCashDrawerShiftsRequest)) {
            return false;
        }
        V1ListCashDrawerShiftsRequest other = (V1ListCashDrawerShiftsRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime);
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
     * Class to build instances of {@link V1ListCashDrawerShiftsRequest}.
     */
    public static class Builder {
        private String order;
        private String beginTime;
        private String endTime;



        /**
         * Setter for order.
         * @param order String value for order.
         * @return Builder
         */
        public Builder order(String order) {
            this.order = order;
            return this;
        }

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

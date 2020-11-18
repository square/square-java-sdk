
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1ListRefundsRequest type.
 */
public class V1ListRefundsRequest {
    private final String order;
    private final String beginTime;
    private final String endTime;
    private final Integer limit;
    private final String batchToken;

    /**
     * Initialization constructor.
     * @param order String value for order.
     * @param beginTime String value for beginTime.
     * @param endTime String value for endTime.
     * @param limit Integer value for limit.
     * @param batchToken String value for batchToken.
     */
    @JsonCreator
    public V1ListRefundsRequest(
            @JsonProperty("order") String order,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("end_time") String endTime,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
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
    public String getOrder() {
        return this.order;
    }

    /**
     * Getter for BeginTime.
     * The beginning of the requested reporting period, in ISO 8601 format. If this value is before
     * January 1, 2013 (2013-01-01T00:00:00Z), this endpoint returns an error. Default value: The
     * current time minus one year.
     * @return Returns the String
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for EndTime.
     * The end of the requested reporting period, in ISO 8601 format. If this value is more than one
     * year greater than begin_time, this endpoint returns an error. Default value: The current
     * time.
     * @return Returns the String
     */
    @JsonGetter("end_time")
    public String getEndTime() {
        return this.endTime;
    }

    /**
     * Getter for Limit.
     * The approximate number of refunds to return in a single response. Default: 100. Max: 200.
     * Response may contain more results than the prescribed limit when refunds are made
     * simultaneously to multiple tenders in a payment or when refunds are generated in an exchange
     * to account for the value of returned goods.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

    /**
     * Getter for BatchToken.
     * A pagination cursor to retrieve the next set of results for your original query to the
     * endpoint.
     * @return Returns the String
     */
    @JsonGetter("batch_token")
    public String getBatchToken() {
        return this.batchToken;
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
                .order(getOrder())
                .beginTime(getBeginTime())
                .endTime(getEndTime())
                .limit(getLimit())
                .batchToken(getBatchToken());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListRefundsRequest}.
     */
    public static class Builder {
        private String order;
        private String beginTime;
        private String endTime;
        private Integer limit;
        private String batchToken;



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
         * Setter for limit.
         * @param limit Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for batchToken.
         * @param batchToken String value for batchToken.
         * @return Builder
         */
        public Builder batchToken(String batchToken) {
            this.batchToken = batchToken;
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

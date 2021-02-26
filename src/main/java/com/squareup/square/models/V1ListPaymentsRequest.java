
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1ListPaymentsRequest type.
 */
public class V1ListPaymentsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String order;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String beginTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String endTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer limit;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String batchToken;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean includePartial;

    /**
     * Initialization constructor.
     * @param  order  String value for order.
     * @param  beginTime  String value for beginTime.
     * @param  endTime  String value for endTime.
     * @param  limit  Integer value for limit.
     * @param  batchToken  String value for batchToken.
     * @param  includePartial  Boolean value for includePartial.
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

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("order")
    public String getOrder() {
        return order;
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
        return beginTime;
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
        return endTime;
    }

    /**
     * Getter for Limit.
     * The maximum number of payments to return in a single response. This value cannot exceed 200.
     * @return Returns the Integer
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Getter for BatchToken.
     * A pagination cursor to retrieve the next set of results for your original query to the
     * endpoint.
     * @return Returns the String
     */
    @JsonGetter("batch_token")
    public String getBatchToken() {
        return batchToken;
    }

    /**
     * Getter for IncludePartial.
     * Indicates whether or not to include partial payments in the response. Partial payments will
     * have the tenders collected so far, but the itemizations will be empty until the payment is
     * completed.
     * @return Returns the Boolean
     */
    @JsonGetter("include_partial")
    public Boolean getIncludePartial() {
        return includePartial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, beginTime, endTime, limit, batchToken, includePartial);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListPaymentsRequest)) {
            return false;
        }
        V1ListPaymentsRequest other = (V1ListPaymentsRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(beginTime, other.beginTime)
            && Objects.equals(endTime, other.endTime)
            && Objects.equals(limit, other.limit)
            && Objects.equals(batchToken, other.batchToken)
            && Objects.equals(includePartial, other.includePartial);
    }

    /**
     * Converts this V1ListPaymentsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListPaymentsRequest [" + "order=" + order + ", beginTime=" + beginTime
                + ", endTime=" + endTime + ", limit=" + limit + ", batchToken=" + batchToken
                + ", includePartial=" + includePartial + "]";
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
     * Class to build instances of {@link V1ListPaymentsRequest}.
     */
    public static class Builder {
        private String order;
        private String beginTime;
        private String endTime;
        private Integer limit;
        private String batchToken;
        private Boolean includePartial;



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
            this.beginTime = beginTime;
            return this;
        }

        /**
         * Setter for endTime.
         * @param  endTime  String value for endTime.
         * @return Builder
         */
        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Setter for batchToken.
         * @param  batchToken  String value for batchToken.
         * @return Builder
         */
        public Builder batchToken(String batchToken) {
            this.batchToken = batchToken;
            return this;
        }

        /**
         * Setter for includePartial.
         * @param  includePartial  Boolean value for includePartial.
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
            return new V1ListPaymentsRequest(order, beginTime, endTime, limit, batchToken,
                    includePartial);
        }
    }
}

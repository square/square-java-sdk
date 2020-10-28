
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1ListOrdersRequest type.
 */
public class V1ListOrdersRequest {
    private final String order;
    private final Integer limit;
    private final String batchToken;

    /**
     * Initialization constructor.
     * @param order String value for order.
     * @param limit Integer value for limit.
     * @param batchToken String value for batchToken.
     */
    @JsonCreator
    public V1ListOrdersRequest(
            @JsonProperty("order") String order,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
        this.order = order;
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
     * Getter for Limit.
     * The maximum number of payments to return in a single response. This value cannot exceed 200.
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
        return Objects.hash(order, limit, batchToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListOrdersRequest)) {
            return false;
        }
        V1ListOrdersRequest other = (V1ListOrdersRequest) obj;
        return Objects.equals(order, other.order)
            && Objects.equals(limit, other.limit)
            && Objects.equals(batchToken, other.batchToken);
    }

    /**
     * Builds a new {@link V1ListOrdersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListOrdersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .limit(getLimit())
            .batchToken(getBatchToken());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListOrdersRequest}.
     */
    public static class Builder {
        private String order;
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
         * Builds a new {@link V1ListOrdersRequest} object using the set fields.
         * @return {@link V1ListOrdersRequest}
         */
        public V1ListOrdersRequest build() {
            return new V1ListOrdersRequest(order,
                limit,
                batchToken);
        }
    }
}

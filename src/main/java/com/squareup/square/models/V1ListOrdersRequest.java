
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
 * This is a model class for V1ListOrdersRequest type.
 */
public class V1ListOrdersRequest {
    private final String order;
    private final OptionalNullable<Integer> limit;
    private final OptionalNullable<String> batchToken;

    /**
     * Initialization constructor.
     * @param  order  String value for order.
     * @param  limit  Integer value for limit.
     * @param  batchToken  String value for batchToken.
     */
    @JsonCreator
    public V1ListOrdersRequest(
            @JsonProperty("order") String order,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
        this.order = order;
        this.limit = OptionalNullable.of(limit);
        this.batchToken = OptionalNullable.of(batchToken);
    }

    /**
     * Initialization constructor.
     * @param  order  String value for order.
     * @param  limit  Integer value for limit.
     * @param  batchToken  String value for batchToken.
     */

    protected V1ListOrdersRequest(String order, OptionalNullable<Integer> limit,
            OptionalNullable<String> batchToken) {
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrder() {
        return order;
    }

    /**
     * Internal Getter for Limit.
     * The maximum number of payments to return in a single response. This value cannot exceed 200.
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
     * The maximum number of payments to return in a single response. This value cannot exceed 200.
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
     * Converts this V1ListOrdersRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListOrdersRequest [" + "order=" + order + ", limit=" + limit + ", batchToken="
                + batchToken + "]";
    }

    /**
     * Builds a new {@link V1ListOrdersRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListOrdersRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .order(getOrder());
        builder.limit = internalGetLimit();
        builder.batchToken = internalGetBatchToken();
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListOrdersRequest}.
     */
    public static class Builder {
        private String order;
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
         * Builds a new {@link V1ListOrdersRequest} object using the set fields.
         * @return {@link V1ListOrdersRequest}
         */
        public V1ListOrdersRequest build() {
            return new V1ListOrdersRequest(order, limit, batchToken);
        }
    }
}

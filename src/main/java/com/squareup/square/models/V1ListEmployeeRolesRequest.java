package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListEmployeeRolesRequest type.
 */
public class V1ListEmployeeRolesRequest {

    /**
     * Initialization constructor.
     * @param order
     * @param limit
     * @param batchToken
     */
    @JsonCreator
    public V1ListEmployeeRolesRequest(
            @JsonProperty("order") String order,
            @JsonProperty("limit") Integer limit,
            @JsonProperty("batch_token") String batchToken) {
        this.order = order;
        this.limit = limit;
        this.batchToken = batchToken;
    }

    private final String order;
    private final Integer limit;
    private final String batchToken;
    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     */
    @JsonGetter("order")
    public String getOrder() {
        return this.order;
    }

    /**
     * Getter for Limit.
     * The maximum integer number of employee entities to return in a single response. Default 100, maximum 200.
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

 
    @Override
    public int hashCode() {
        return Objects.hash(order, limit, batchToken);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ListEmployeeRolesRequest)) {
            return false;
        }
        V1ListEmployeeRolesRequest v1ListEmployeeRolesRequest = (V1ListEmployeeRolesRequest) obj;
        return Objects.equals(order, v1ListEmployeeRolesRequest.order) &&
            Objects.equals(limit, v1ListEmployeeRolesRequest.limit) &&
            Objects.equals(batchToken, v1ListEmployeeRolesRequest.batchToken);
    }

    /**
     * Builds a new {@link V1ListEmployeeRolesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListEmployeeRolesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .limit(getLimit())
            .batchToken(getBatchToken());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListEmployeeRolesRequest}
     */
    public static class Builder {
        private String order;
        private Integer limit;
        private String batchToken;

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
         * Builds a new {@link V1ListEmployeeRolesRequest} object using the set fields.
         * @return {@link V1ListEmployeeRolesRequest}
         */
        public V1ListEmployeeRolesRequest build() {
            return new V1ListEmployeeRolesRequest(order,
                limit,
                batchToken);
        }
    }
}

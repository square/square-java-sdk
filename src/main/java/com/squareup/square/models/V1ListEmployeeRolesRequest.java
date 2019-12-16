package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListEmployeeRolesRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(order, limit, batchToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListEmployeeRolesRequest)) {
            return false;
        }
        V1ListEmployeeRolesRequest v1ListEmployeeRolesRequest = (V1ListEmployeeRolesRequest) o;
        return Objects.equals(order, v1ListEmployeeRolesRequest.order) &&
            Objects.equals(limit, v1ListEmployeeRolesRequest.limit) &&
            Objects.equals(batchToken, v1ListEmployeeRolesRequest.batchToken);
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .limit(getLimit())
            .batchToken(getBatchToken());
            return builder;
    }

    public static class Builder {
        private String order;
        private Integer limit;
        private String batchToken;

        public Builder() { }

        public Builder order(String value) {
            order = value;
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

        public V1ListEmployeeRolesRequest build() {
            return new V1ListEmployeeRolesRequest(order,
                limit,
                batchToken);
        }
    }
}

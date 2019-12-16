package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class BatchRetrieveOrdersRequest {

    @JsonCreator
    public BatchRetrieveOrdersRequest(
            @JsonProperty("order_ids") List<String> orderIds) {
        this.orderIds = orderIds;
    }

    private final List<String> orderIds;

    @Override
    public int hashCode() {
        return Objects.hash(orderIds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchRetrieveOrdersRequest)) {
            return false;
        }
        BatchRetrieveOrdersRequest batchRetrieveOrdersRequest = (BatchRetrieveOrdersRequest) o;
        return Objects.equals(orderIds, batchRetrieveOrdersRequest.orderIds);
    }

    /**
     * Getter for OrderIds.
     * The IDs of the orders to retrieve. A maximum of 100 orders can be retrieved per request.
     */
    @JsonGetter("order_ids")
    public List<String> getOrderIds() { 
        return this.orderIds;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(orderIds);
            return builder;
    }

    public static class Builder {
        private List<String> orderIds;

        public Builder(List<String> orderIds) {
            this.orderIds = orderIds;
        }

        public Builder orderIds(List<String> value) {
            orderIds = value;
            return this;
        }

        public BatchRetrieveOrdersRequest build() {
            return new BatchRetrieveOrdersRequest(orderIds);
        }
    }
}

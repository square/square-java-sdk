package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class BatchRetrieveOrdersResponse {

    @JsonCreator
    public BatchRetrieveOrdersResponse(
            @JsonProperty("orders") List<Order> orders,
            @JsonProperty("errors") List<Error> errors) {
        this.orders = orders;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<Order> orders;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(orders, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchRetrieveOrdersResponse)) {
            return false;
        }
        BatchRetrieveOrdersResponse batchRetrieveOrdersResponse = (BatchRetrieveOrdersResponse) o;
        return Objects.equals(orders, batchRetrieveOrdersResponse.orders) &&
            Objects.equals(errors, batchRetrieveOrdersResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Orders.
     * The requested orders. This will omit any requested orders that do not exist.
     */
    @JsonGetter("orders")
    public List<Order> getOrders() { 
        return this.orders;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orders(getOrders())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Order> orders;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder orders(List<Order> value) {
            orders = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public BatchRetrieveOrdersResponse build() {
            BatchRetrieveOrdersResponse model = new BatchRetrieveOrdersResponse(orders,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

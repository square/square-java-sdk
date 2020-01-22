package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for BatchRetrieveOrdersResponse type.
 */
public class BatchRetrieveOrdersResponse {

    /**
     * Initialization constructor.
     * @param orders
     * @param errors
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(orders, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchRetrieveOrdersResponse)) {
            return false;
        }
        BatchRetrieveOrdersResponse batchRetrieveOrdersResponse = (BatchRetrieveOrdersResponse) obj;
        return Objects.equals(orders, batchRetrieveOrdersResponse.orders) &&
            Objects.equals(errors, batchRetrieveOrdersResponse.errors);
    }

    /**
     * Builds a new {@link BatchRetrieveOrdersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveOrdersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orders(getOrders())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveOrdersResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Order> orders;
        private List<Error> errors;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for orders
         * @param orders
         * @return Builder
         */
        public Builder orders(List<Order> orders) {
            this.orders = orders;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveOrdersResponse} object using the set fields.
         * @return {@link BatchRetrieveOrdersResponse}
         */
        public BatchRetrieveOrdersResponse build() {
            BatchRetrieveOrdersResponse model = new BatchRetrieveOrdersResponse(orders,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

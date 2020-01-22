package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchOrdersResponse type.
 */
public class SearchOrdersResponse {

    /**
     * Initialization constructor.
     * @param orderEntries
     * @param orders
     * @param cursor
     * @param errors
     */
    @JsonCreator
    public SearchOrdersResponse(
            @JsonProperty("order_entries") List<OrderEntry> orderEntries,
            @JsonProperty("orders") List<Order> orders,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.orderEntries = orderEntries;
        this.orders = orders;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<OrderEntry> orderEntries;
    private final List<Order> orders;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for OrderEntries.
     * List of [OrderEntries](#type-orderentry) that fit the query
     * conditions. Populated only if `return_entries` was set to `true` in the request.
     */
    @JsonGetter("order_entries")
    public List<OrderEntry> getOrderEntries() {
        return this.orderEntries;
    }

    /**
     * Getter for Orders.
     * List of
     * [Order](#type-order) objects that match query conditions. Populated only if
     * `return_entries` in the request is set to `false`.
     */
    @JsonGetter("orders")
    public List<Order> getOrders() {
        return this.orders;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset,
     * this is the final response.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Errors.
     * [Errors](#type-error) encountered during the search.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(orderEntries, orders, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchOrdersResponse)) {
            return false;
        }
        SearchOrdersResponse searchOrdersResponse = (SearchOrdersResponse) obj;
        return Objects.equals(orderEntries, searchOrdersResponse.orderEntries) &&
            Objects.equals(orders, searchOrdersResponse.orders) &&
            Objects.equals(cursor, searchOrdersResponse.cursor) &&
            Objects.equals(errors, searchOrdersResponse.errors);
    }

    /**
     * Builds a new {@link SearchOrdersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orderEntries(getOrderEntries())
            .orders(getOrders())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<OrderEntry> orderEntries;
        private List<Order> orders;
        private String cursor;
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
         * Setter for orderEntries
         * @param orderEntries
         * @return Builder
         */
        public Builder orderEntries(List<OrderEntry> orderEntries) {
            this.orderEntries = orderEntries;
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
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
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
         * Builds a new {@link SearchOrdersResponse} object using the set fields.
         * @return {@link SearchOrdersResponse}
         */
        public SearchOrdersResponse build() {
            SearchOrdersResponse model = new SearchOrdersResponse(orderEntries,
                orders,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

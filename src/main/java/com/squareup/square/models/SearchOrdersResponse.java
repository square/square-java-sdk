package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class SearchOrdersResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(orderEntries, orders, cursor, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchOrdersResponse)) {
            return false;
        }
        SearchOrdersResponse searchOrdersResponse = (SearchOrdersResponse) o;
        return Objects.equals(orderEntries, searchOrdersResponse.orderEntries) &&
            Objects.equals(orders, searchOrdersResponse.orders) &&
            Objects.equals(cursor, searchOrdersResponse.cursor) &&
            Objects.equals(errors, searchOrdersResponse.errors);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orderEntries(getOrderEntries())
            .orders(getOrders())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<OrderEntry> orderEntries;
        private List<Order> orders;
        private String cursor;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder orderEntries(List<OrderEntry> value) {
            orderEntries = value;
            return this;
        }
        public Builder orders(List<Order> value) {
            orders = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

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

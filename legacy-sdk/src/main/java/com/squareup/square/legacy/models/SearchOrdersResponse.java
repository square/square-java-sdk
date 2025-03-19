package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchOrdersResponse type.
 */
public class SearchOrdersResponse {
    private HttpContext httpContext;
    private final List<OrderEntry> orderEntries;
    private final List<Order> orders;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  orderEntries  List of OrderEntry value for orderEntries.
     * @param  orders  List of Order value for orders.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for OrderEntries.
     * A list of [OrderEntries](entity:OrderEntry) that fit the query conditions. The list is
     * populated only if `return_entries` is set to `true` in the request.
     * @return Returns the List of OrderEntry
     */
    @JsonGetter("order_entries")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    /**
     * Getter for Orders.
     * A list of [Order](entity:Order) objects that match the query conditions. The list is
     * populated only if `return_entries` is set to `false` in the request.
     * @return Returns the List of Order
     */
    @JsonGetter("orders")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * [Errors](entity:Error) encountered during the search.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderEntries, orders, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrdersResponse)) {
            return false;
        }
        SearchOrdersResponse other = (SearchOrdersResponse) obj;
        return Objects.equals(orderEntries, other.orderEntries)
                && Objects.equals(orders, other.orders)
                && Objects.equals(cursor, other.cursor)
                && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this SearchOrdersResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchOrdersResponse [" + "orderEntries=" + orderEntries + ", orders=" + orders + ", cursor=" + cursor
                + ", errors=" + errors + "]";
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
     * Class to build instances of {@link SearchOrdersResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<OrderEntry> orderEntries;
        private List<Order> orders;
        private String cursor;
        private List<Error> errors;

        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for orderEntries.
         * @param  orderEntries  List of OrderEntry value for orderEntries.
         * @return Builder
         */
        public Builder orderEntries(List<OrderEntry> orderEntries) {
            this.orderEntries = orderEntries;
            return this;
        }

        /**
         * Setter for orders.
         * @param  orders  List of Order value for orders.
         * @return Builder
         */
        public Builder orders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
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
            SearchOrdersResponse model = new SearchOrdersResponse(orderEntries, orders, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

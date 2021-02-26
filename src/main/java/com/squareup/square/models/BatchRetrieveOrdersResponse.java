
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveOrdersResponse type.
 */
public class BatchRetrieveOrdersResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Order> orders;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  orders  List of Order value for orders.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BatchRetrieveOrdersResponse(
            @JsonProperty("orders") List<Order> orders,
            @JsonProperty("errors") List<Error> errors) {
        this.orders = orders;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Orders.
     * The requested orders. This will omit any requested orders that do not exist.
     * @return Returns the List of Order
     */
    @JsonGetter("orders")
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchRetrieveOrdersResponse)) {
            return false;
        }
        BatchRetrieveOrdersResponse other = (BatchRetrieveOrdersResponse) obj;
        return Objects.equals(orders, other.orders)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BatchRetrieveOrdersResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveOrdersResponse [" + "orders=" + orders + ", errors=" + errors + "]";
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
     * Class to build instances of {@link BatchRetrieveOrdersResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Order> orders;
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
         * Setter for orders.
         * @param  orders  List of Order value for orders.
         * @return Builder
         */
        public Builder orders(List<Order> orders) {
            this.orders = orders;
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
         * Builds a new {@link BatchRetrieveOrdersResponse} object using the set fields.
         * @return {@link BatchRetrieveOrdersResponse}
         */
        public BatchRetrieveOrdersResponse build() {
            BatchRetrieveOrdersResponse model =
                    new BatchRetrieveOrdersResponse(orders, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

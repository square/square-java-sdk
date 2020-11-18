
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for PayOrderResponse type.
 */
public class PayOrderResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Order order;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param order Order value for order.
     */
    @JsonCreator
    public PayOrderResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("order") Order order) {
        this.errors = errors;
        this.order = order;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. Order objects also include information on any
     * associated tenders, refunds, and returns. All Connect V2 Transactions have all been converted
     * to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    public Order getOrder() {
        return this.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, order);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayOrderResponse)) {
            return false;
        }
        PayOrderResponse other = (PayOrderResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(order, other.order);
    }

    /**
     * Converts this PayOrderResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PayOrderResponse [" + "errors=" + errors + ", order=" + order + "]";
    }

    /**
     * Builds a new {@link PayOrderResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PayOrderResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .order(getOrder());
        return builder;
    }

    /**
     * Class to build instances of {@link PayOrderResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Order order;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for order.
         * @param order Order value for order.
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        /**
         * Builds a new {@link PayOrderResponse} object using the set fields.
         * @return {@link PayOrderResponse}
         */
        public PayOrderResponse build() {
            PayOrderResponse model =
                    new PayOrderResponse(errors, order);
            model.httpContext = httpContext;
            return model;
        }
    }
}

package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for PayOrderResponse type.
 */
public class PayOrderResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param order
     */
    @JsonCreator
    public PayOrderResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("order") Order order) {
        this.errors = errors;
        this.order = order;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Order order;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square,
     * including line items that specify the products to purchase. Order objects also
     * include information on any associated tenders, refunds, and returns.
     * All Connect V2 Transactions have all been converted to Orders including all associated
     * itemization data.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof PayOrderResponse)) {
            return false;
        }
        PayOrderResponse payOrderResponse = (PayOrderResponse) obj;
        return Objects.equals(errors, payOrderResponse.errors) &&
            Objects.equals(order, payOrderResponse.order);
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
     * Class to build instances of {@link PayOrderResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Order order;

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
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for order
         * @param order
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
            PayOrderResponse model = new PayOrderResponse(errors,
                order);
            model.httpContext = httpContext;
            return model;
        }
    }
}

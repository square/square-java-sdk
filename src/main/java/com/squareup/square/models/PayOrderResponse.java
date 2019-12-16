package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class PayOrderResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, order);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PayOrderResponse)) {
            return false;
        }
        PayOrderResponse payOrderResponse = (PayOrderResponse) o;
        return Objects.equals(errors, payOrderResponse.errors) &&
            Objects.equals(order, payOrderResponse.order);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .order(getOrder());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Order order;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder order(Order value) {
            order = value;
            return this;
        }

        public PayOrderResponse build() {
            PayOrderResponse model = new PayOrderResponse(errors,
                order);
            model.httpContext = httpContext;
            return model;
        }
    }
}

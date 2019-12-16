package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreateOrderResponse {

    @JsonCreator
    public CreateOrderResponse(
            @JsonProperty("order") Order order,
            @JsonProperty("errors") List<Error> errors) {
        this.order = order;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final Order order;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(order, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateOrderResponse)) {
            return false;
        }
        CreateOrderResponse createOrderResponse = (CreateOrderResponse) o;
        return Objects.equals(order, createOrderResponse.order) &&
            Objects.equals(errors, createOrderResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
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
            .order(getOrder())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private Order order;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder order(Order value) {
            order = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public CreateOrderResponse build() {
            CreateOrderResponse model = new CreateOrderResponse(order,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

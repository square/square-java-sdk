package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreateCheckoutResponse {

    @JsonCreator
    public CreateCheckoutResponse(
            @JsonProperty("checkout") Checkout checkout,
            @JsonProperty("errors") List<Error> errors) {
        this.checkout = checkout;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final Checkout checkout;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(checkout, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateCheckoutResponse)) {
            return false;
        }
        CreateCheckoutResponse createCheckoutResponse = (CreateCheckoutResponse) o;
        return Objects.equals(checkout, createCheckoutResponse.checkout) &&
            Objects.equals(errors, createCheckoutResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Checkout.
     * Square Checkout lets merchants accept online payments for supported
     * payment types using a checkout workflow hosted on squareup.com.
     */
    @JsonGetter("checkout")
    public Checkout getCheckout() { 
        return this.checkout;
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
            .checkout(getCheckout())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private Checkout checkout;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder checkout(Checkout value) {
            checkout = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public CreateCheckoutResponse build() {
            CreateCheckoutResponse model = new CreateCheckoutResponse(checkout,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

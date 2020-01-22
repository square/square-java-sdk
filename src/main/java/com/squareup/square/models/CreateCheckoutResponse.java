package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CreateCheckoutResponse type.
 */
public class CreateCheckoutResponse {

    /**
     * Initialization constructor.
     * @param checkout
     * @param errors
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(checkout, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateCheckoutResponse)) {
            return false;
        }
        CreateCheckoutResponse createCheckoutResponse = (CreateCheckoutResponse) obj;
        return Objects.equals(checkout, createCheckoutResponse.checkout) &&
            Objects.equals(errors, createCheckoutResponse.errors);
    }

    /**
     * Builds a new {@link CreateCheckoutResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCheckoutResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .checkout(getCheckout())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateCheckoutResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private Checkout checkout;
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
         * Setter for checkout
         * @param checkout
         * @return Builder
         */
        public Builder checkout(Checkout checkout) {
            this.checkout = checkout;
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
         * Builds a new {@link CreateCheckoutResponse} object using the set fields.
         * @return {@link CreateCheckoutResponse}
         */
        public CreateCheckoutResponse build() {
            CreateCheckoutResponse model = new CreateCheckoutResponse(checkout,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

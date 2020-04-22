package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CancelTerminalCheckoutResponse type.
 */
public class CancelTerminalCheckoutResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param checkout
     */
    @JsonCreator
    public CancelTerminalCheckoutResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("checkout") TerminalCheckout checkout) {
        this.errors = errors;
        this.checkout = checkout;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final TerminalCheckout checkout;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Checkout.
     */
    @JsonGetter("checkout")
    public TerminalCheckout getCheckout() {
        return this.checkout;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, checkout);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CancelTerminalCheckoutResponse)) {
            return false;
        }
        CancelTerminalCheckoutResponse cancelTerminalCheckoutResponse = (CancelTerminalCheckoutResponse) obj;
        return Objects.equals(errors, cancelTerminalCheckoutResponse.errors) &&
            Objects.equals(checkout, cancelTerminalCheckoutResponse.checkout);
    }

    /**
     * Builds a new {@link CancelTerminalCheckoutResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelTerminalCheckoutResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .checkout(getCheckout());
            return builder;
    }

    /**
     * Class to build instances of {@link CancelTerminalCheckoutResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private TerminalCheckout checkout;

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
         * Setter for checkout
         * @param checkout
         * @return Builder
         */
        public Builder checkout(TerminalCheckout checkout) {
            this.checkout = checkout;
            return this;
        }

        /**
         * Builds a new {@link CancelTerminalCheckoutResponse} object using the set fields.
         * @return {@link CancelTerminalCheckoutResponse}
         */
        public CancelTerminalCheckoutResponse build() {
            CancelTerminalCheckoutResponse model = new CancelTerminalCheckoutResponse(errors,
                checkout);
            model.httpContext = httpContext;
            return model;
        }
    }
}

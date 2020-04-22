package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for GetTerminalCheckoutResponse type.
 */
public class GetTerminalCheckoutResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param checkout
     */
    @JsonCreator
    public GetTerminalCheckoutResponse(
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
        if(!(obj instanceof GetTerminalCheckoutResponse)) {
            return false;
        }
        GetTerminalCheckoutResponse getTerminalCheckoutResponse = (GetTerminalCheckoutResponse) obj;
        return Objects.equals(errors, getTerminalCheckoutResponse.errors) &&
            Objects.equals(checkout, getTerminalCheckoutResponse.checkout);
    }

    /**
     * Builds a new {@link GetTerminalCheckoutResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GetTerminalCheckoutResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .checkout(getCheckout());
            return builder;
    }

    /**
     * Class to build instances of {@link GetTerminalCheckoutResponse}
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
         * Builds a new {@link GetTerminalCheckoutResponse} object using the set fields.
         * @return {@link GetTerminalCheckoutResponse}
         */
        public GetTerminalCheckoutResponse build() {
            GetTerminalCheckoutResponse model = new GetTerminalCheckoutResponse(errors,
                checkout);
            model.httpContext = httpContext;
            return model;
        }
    }
}

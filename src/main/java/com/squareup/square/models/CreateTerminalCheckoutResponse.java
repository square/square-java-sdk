package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CreateTerminalCheckoutResponse type.
 */
public class CreateTerminalCheckoutResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param checkout
     */
    @JsonCreator
    public CreateTerminalCheckoutResponse(
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
        if(!(obj instanceof CreateTerminalCheckoutResponse)) {
            return false;
        }
        CreateTerminalCheckoutResponse createTerminalCheckoutResponse = (CreateTerminalCheckoutResponse) obj;
        return Objects.equals(errors, createTerminalCheckoutResponse.errors) &&
            Objects.equals(checkout, createTerminalCheckoutResponse.checkout);
    }

    /**
     * Builds a new {@link CreateTerminalCheckoutResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateTerminalCheckoutResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .checkout(getCheckout());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateTerminalCheckoutResponse}
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
         * Builds a new {@link CreateTerminalCheckoutResponse} object using the set fields.
         * @return {@link CreateTerminalCheckoutResponse}
         */
        public CreateTerminalCheckoutResponse build() {
            CreateTerminalCheckoutResponse model = new CreateTerminalCheckoutResponse(errors,
                checkout);
            model.httpContext = httpContext;
            return model;
        }
    }
}

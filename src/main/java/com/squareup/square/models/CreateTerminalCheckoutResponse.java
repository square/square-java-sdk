
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateTerminalCheckoutResponse type.
 */
public class CreateTerminalCheckoutResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TerminalCheckout checkout;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  checkout  TerminalCheckout value for checkout.
     */
    @JsonCreator
    public CreateTerminalCheckoutResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("checkout") TerminalCheckout checkout) {
        this.errors = errors;
        this.checkout = checkout;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Checkout.
     * @return Returns the TerminalCheckout
     */
    @JsonGetter("checkout")
    public TerminalCheckout getCheckout() {
        return checkout;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, checkout);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateTerminalCheckoutResponse)) {
            return false;
        }
        CreateTerminalCheckoutResponse other = (CreateTerminalCheckoutResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(checkout, other.checkout);
    }

    /**
     * Converts this CreateTerminalCheckoutResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateTerminalCheckoutResponse [" + "errors=" + errors + ", checkout=" + checkout
                + "]";
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
     * Class to build instances of {@link CreateTerminalCheckoutResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private TerminalCheckout checkout;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for checkout.
         * @param  checkout  TerminalCheckout value for checkout.
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
            CreateTerminalCheckoutResponse model =
                    new CreateTerminalCheckoutResponse(errors, checkout);
            model.httpContext = httpContext;
            return model;
        }
    }
}

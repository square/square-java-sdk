
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateCheckoutResponse type.
 */
public class CreateCheckoutResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Checkout checkout;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  checkout  Checkout value for checkout.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CreateCheckoutResponse(
            @JsonProperty("checkout") Checkout checkout,
            @JsonProperty("errors") List<Error> errors) {
        this.checkout = checkout;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Checkout.
     * Square Checkout lets merchants accept online payments for supported payment types using a
     * checkout workflow hosted on squareup.com.
     * @return Returns the Checkout
     */
    @JsonGetter("checkout")
    public Checkout getCheckout() {
        return checkout;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkout, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCheckoutResponse)) {
            return false;
        }
        CreateCheckoutResponse other = (CreateCheckoutResponse) obj;
        return Objects.equals(checkout, other.checkout)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CreateCheckoutResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateCheckoutResponse [" + "checkout=" + checkout + ", errors=" + errors + "]";
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
     * Class to build instances of {@link CreateCheckoutResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Checkout checkout;
        private List<Error> errors;



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
         * Setter for checkout.
         * @param  checkout  Checkout value for checkout.
         * @return Builder
         */
        public Builder checkout(Checkout checkout) {
            this.checkout = checkout;
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
         * Builds a new {@link CreateCheckoutResponse} object using the set fields.
         * @return {@link CreateCheckoutResponse}
         */
        public CreateCheckoutResponse build() {
            CreateCheckoutResponse model =
                    new CreateCheckoutResponse(checkout, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

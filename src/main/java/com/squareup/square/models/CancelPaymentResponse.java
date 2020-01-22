package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CancelPaymentResponse type.
 */
public class CancelPaymentResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param payment
     */
    @JsonCreator
    public CancelPaymentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("payment") Payment payment) {
        this.errors = errors;
        this.payment = payment;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Payment payment;

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
     * Getter for Payment.
     * Represents a payment processed by the Square API.
     */
    @JsonGetter("payment")
    public Payment getPayment() {
        return this.payment;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, payment);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CancelPaymentResponse)) {
            return false;
        }
        CancelPaymentResponse cancelPaymentResponse = (CancelPaymentResponse) obj;
        return Objects.equals(errors, cancelPaymentResponse.errors) &&
            Objects.equals(payment, cancelPaymentResponse.payment);
    }

    /**
     * Builds a new {@link CancelPaymentResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelPaymentResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .payment(getPayment());
            return builder;
    }

    /**
     * Class to build instances of {@link CancelPaymentResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Payment payment;

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
         * Setter for payment
         * @param payment
         * @return Builder
         */
        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        /**
         * Builds a new {@link CancelPaymentResponse} object using the set fields.
         * @return {@link CancelPaymentResponse}
         */
        public CancelPaymentResponse build() {
            CancelPaymentResponse model = new CancelPaymentResponse(errors,
                payment);
            model.httpContext = httpContext;
            return model;
        }
    }
}

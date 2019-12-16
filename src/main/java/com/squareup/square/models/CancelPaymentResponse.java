package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CancelPaymentResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, payment);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CancelPaymentResponse)) {
            return false;
        }
        CancelPaymentResponse cancelPaymentResponse = (CancelPaymentResponse) o;
        return Objects.equals(errors, cancelPaymentResponse.errors) &&
            Objects.equals(payment, cancelPaymentResponse.payment);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .payment(getPayment());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Payment payment;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder payment(Payment value) {
            payment = value;
            return this;
        }

        public CancelPaymentResponse build() {
            CancelPaymentResponse model = new CancelPaymentResponse(errors,
                payment);
            model.httpContext = httpContext;
            return model;
        }
    }
}

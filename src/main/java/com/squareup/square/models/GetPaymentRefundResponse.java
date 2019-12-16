package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class GetPaymentRefundResponse {

    @JsonCreator
    public GetPaymentRefundResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refund") PaymentRefund refund) {
        this.errors = errors;
        this.refund = refund;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final PaymentRefund refund;

    @Override
    public int hashCode() {
        return Objects.hash(errors, refund);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GetPaymentRefundResponse)) {
            return false;
        }
        GetPaymentRefundResponse getPaymentRefundResponse = (GetPaymentRefundResponse) o;
        return Objects.equals(errors, getPaymentRefundResponse.errors) &&
            Objects.equals(refund, getPaymentRefundResponse.refund);
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
     * Getter for Refund.
     * Represents a refund of a payment made using Square. Contains information on
     * the original payment and the amount of money refunded.
     */
    @JsonGetter("refund")
    public PaymentRefund getRefund() { 
        return this.refund;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .refund(getRefund());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private PaymentRefund refund;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder refund(PaymentRefund value) {
            refund = value;
            return this;
        }

        public GetPaymentRefundResponse build() {
            GetPaymentRefundResponse model = new GetPaymentRefundResponse(errors,
                refund);
            model.httpContext = httpContext;
            return model;
        }
    }
}

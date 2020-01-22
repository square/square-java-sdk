package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RefundPaymentResponse type.
 */
public class RefundPaymentResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param refund
     */
    @JsonCreator
    public RefundPaymentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refund") PaymentRefund refund) {
        this.errors = errors;
        this.refund = refund;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final PaymentRefund refund;

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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, refund);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RefundPaymentResponse)) {
            return false;
        }
        RefundPaymentResponse refundPaymentResponse = (RefundPaymentResponse) obj;
        return Objects.equals(errors, refundPaymentResponse.errors) &&
            Objects.equals(refund, refundPaymentResponse.refund);
    }

    /**
     * Builds a new {@link RefundPaymentResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RefundPaymentResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .refund(getRefund());
            return builder;
    }

    /**
     * Class to build instances of {@link RefundPaymentResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private PaymentRefund refund;

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
         * Setter for refund
         * @param refund
         * @return Builder
         */
        public Builder refund(PaymentRefund refund) {
            this.refund = refund;
            return this;
        }

        /**
         * Builds a new {@link RefundPaymentResponse} object using the set fields.
         * @return {@link RefundPaymentResponse}
         */
        public RefundPaymentResponse build() {
            RefundPaymentResponse model = new RefundPaymentResponse(errors,
                refund);
            model.httpContext = httpContext;
            return model;
        }
    }
}

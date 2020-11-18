
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RefundPaymentResponse type.
 */
public class RefundPaymentResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final PaymentRefund refund;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param refund PaymentRefund value for refund.
     */
    @JsonCreator
    public RefundPaymentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refund") PaymentRefund refund) {
        this.errors = errors;
        this.refund = refund;
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
        return this.errors;
    }

    /**
     * Getter for Refund.
     * Represents a refund of a payment made using Square. Contains information about the original
     * payment and the amount of money refunded.
     * @return Returns the PaymentRefund
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RefundPaymentResponse)) {
            return false;
        }
        RefundPaymentResponse other = (RefundPaymentResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(refund, other.refund);
    }

    /**
     * Converts this RefundPaymentResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RefundPaymentResponse [" + "errors=" + errors + ", refund=" + refund + "]";
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
     * Class to build instances of {@link RefundPaymentResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private PaymentRefund refund;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for refund.
         * @param refund PaymentRefund value for refund.
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
            RefundPaymentResponse model =
                    new RefundPaymentResponse(errors, refund);
            model.httpContext = httpContext;
            return model;
        }
    }
}

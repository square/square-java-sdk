
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
 * This is a model class for UpdatePaymentResponse type.
 */
public class UpdatePaymentResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Payment payment;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  payment  Payment value for payment.
     */
    @JsonCreator
    public UpdatePaymentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("payment") Payment payment) {
        this.errors = errors;
        this.payment = payment;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Payment.
     * Represents a payment processed by the Square API.
     * @return Returns the Payment
     */
    @JsonGetter("payment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Payment getPayment() {
        return payment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, payment);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdatePaymentResponse)) {
            return false;
        }
        UpdatePaymentResponse other = (UpdatePaymentResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(payment, other.payment);
    }

    /**
     * Converts this UpdatePaymentResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdatePaymentResponse [" + "errors=" + errors + ", payment=" + payment + "]";
    }

    /**
     * Builds a new {@link UpdatePaymentResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdatePaymentResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .payment(getPayment());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdatePaymentResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Payment payment;



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
         * Setter for payment.
         * @param  payment  Payment value for payment.
         * @return Builder
         */
        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        /**
         * Builds a new {@link UpdatePaymentResponse} object using the set fields.
         * @return {@link UpdatePaymentResponse}
         */
        public UpdatePaymentResponse build() {
            UpdatePaymentResponse model =
                    new UpdatePaymentResponse(errors, payment);
            model.httpContext = httpContext;
            return model;
        }
    }
}

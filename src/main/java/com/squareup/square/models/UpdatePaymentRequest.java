
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdatePaymentRequest type.
 */
public class UpdatePaymentRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Payment payment;
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  payment  Payment value for payment.
     */
    @JsonCreator
    public UpdatePaymentRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("payment") Payment payment) {
        this.payment = payment;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for Payment.
     * Represents a payment processed by the Square API.
     * @return Returns the Payment
     */
    @JsonGetter("payment")
    public Payment getPayment() {
        return payment;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `UpdatePayment` request. Keys can be any valid string
     * but must be unique for every `UpdatePayment` request. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdatePaymentRequest)) {
            return false;
        }
        UpdatePaymentRequest other = (UpdatePaymentRequest) obj;
        return Objects.equals(payment, other.payment)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this UpdatePaymentRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdatePaymentRequest [" + "idempotencyKey=" + idempotencyKey + ", payment="
                + payment + "]";
    }

    /**
     * Builds a new {@link UpdatePaymentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdatePaymentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
                .payment(getPayment());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdatePaymentRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private Payment payment;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Builds a new {@link UpdatePaymentRequest} object using the set fields.
         * @return {@link UpdatePaymentRequest}
         */
        public UpdatePaymentRequest build() {
            return new UpdatePaymentRequest(idempotencyKey, payment);
        }
    }
}

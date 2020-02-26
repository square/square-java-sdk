package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for DisputedPayment type.
 */
public class DisputedPayment {

    /**
     * Initialization constructor.
     * @param paymentId
     */
    @JsonCreator
    public DisputedPayment(
            @JsonProperty("payment_id") String paymentId) {
        this.paymentId = paymentId;
    }

    private final String paymentId;
    /**
     * Getter for PaymentId.
     * Square-generated unique ID of the payment being disputed.
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return this.paymentId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof DisputedPayment)) {
            return false;
        }
        DisputedPayment disputedPayment = (DisputedPayment) obj;
        return Objects.equals(paymentId, disputedPayment.paymentId);
    }

    /**
     * Builds a new {@link DisputedPayment.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DisputedPayment.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .paymentId(getPaymentId());
            return builder;
    }

    /**
     * Class to build instances of {@link DisputedPayment}
     */
    public static class Builder {
        private String paymentId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for paymentId
         * @param paymentId
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * Builds a new {@link DisputedPayment} object using the set fields.
         * @return {@link DisputedPayment}
         */
        public DisputedPayment build() {
            return new DisputedPayment(paymentId);
        }
    }
}

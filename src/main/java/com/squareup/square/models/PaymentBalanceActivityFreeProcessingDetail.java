
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for PaymentBalanceActivityFreeProcessingDetail type.
 */
public class PaymentBalanceActivityFreeProcessingDetail {
    private final String paymentId;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     */
    @JsonCreator
    public PaymentBalanceActivityFreeProcessingDetail(
            @JsonProperty("payment_id") String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Getter for PaymentId.
     * The ID of the payment associated with this activity.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBalanceActivityFreeProcessingDetail)) {
            return false;
        }
        PaymentBalanceActivityFreeProcessingDetail other =
                (PaymentBalanceActivityFreeProcessingDetail) obj;
        return Objects.equals(paymentId, other.paymentId);
    }

    /**
     * Converts this PaymentBalanceActivityFreeProcessingDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityFreeProcessingDetail [" + "paymentId=" + paymentId + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityFreeProcessingDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityFreeProcessingDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .paymentId(getPaymentId());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityFreeProcessingDetail}.
     */
    public static class Builder {
        private String paymentId;



        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * Builds a new {@link PaymentBalanceActivityFreeProcessingDetail} object using the set
         * fields.
         * @return {@link PaymentBalanceActivityFreeProcessingDetail}
         */
        public PaymentBalanceActivityFreeProcessingDetail build() {
            return new PaymentBalanceActivityFreeProcessingDetail(paymentId);
        }
    }
}

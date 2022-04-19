
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for PaymentBalanceActivityAutomaticSavingsReversedDetail type.
 */
public class PaymentBalanceActivityAutomaticSavingsReversedDetail {
    private final String paymentId;
    private final String payoutId;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  payoutId  String value for payoutId.
     */
    @JsonCreator
    public PaymentBalanceActivityAutomaticSavingsReversedDetail(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("payout_id") String payoutId) {
        this.paymentId = paymentId;
        this.payoutId = payoutId;
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

    /**
     * Getter for PayoutId.
     * The ID of the payout associated with this activity.
     * @return Returns the String
     */
    @JsonGetter("payout_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPayoutId() {
        return payoutId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, payoutId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBalanceActivityAutomaticSavingsReversedDetail)) {
            return false;
        }
        PaymentBalanceActivityAutomaticSavingsReversedDetail other =
                (PaymentBalanceActivityAutomaticSavingsReversedDetail) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(payoutId, other.payoutId);
    }

    /**
     * Converts this PaymentBalanceActivityAutomaticSavingsReversedDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityAutomaticSavingsReversedDetail [" + "paymentId=" + paymentId
                + ", payoutId=" + payoutId + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityAutomaticSavingsReversedDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityAutomaticSavingsReversedDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .paymentId(getPaymentId())
                .payoutId(getPayoutId());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityAutomaticSavingsReversedDetail}.
     */
    public static class Builder {
        private String paymentId;
        private String payoutId;



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
         * Setter for payoutId.
         * @param  payoutId  String value for payoutId.
         * @return Builder
         */
        public Builder payoutId(String payoutId) {
            this.payoutId = payoutId;
            return this;
        }

        /**
         * Builds a new {@link PaymentBalanceActivityAutomaticSavingsReversedDetail} object using
         * the set fields.
         * @return {@link PaymentBalanceActivityAutomaticSavingsReversedDetail}
         */
        public PaymentBalanceActivityAutomaticSavingsReversedDetail build() {
            return new PaymentBalanceActivityAutomaticSavingsReversedDetail(paymentId, payoutId);
        }
    }
}

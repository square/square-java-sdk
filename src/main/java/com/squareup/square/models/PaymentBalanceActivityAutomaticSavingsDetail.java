
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for PaymentBalanceActivityAutomaticSavingsDetail type.
 */
public class PaymentBalanceActivityAutomaticSavingsDetail {
    private final OptionalNullable<String> paymentId;
    private final OptionalNullable<String> payoutId;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  payoutId  String value for payoutId.
     */
    @JsonCreator
    public PaymentBalanceActivityAutomaticSavingsDetail(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("payout_id") String payoutId) {
        this.paymentId = OptionalNullable.of(paymentId);
        this.payoutId = OptionalNullable.of(payoutId);
    }

    /**
     * Internal initialization constructor.
     */
    protected PaymentBalanceActivityAutomaticSavingsDetail(OptionalNullable<String> paymentId,
            OptionalNullable<String> payoutId) {
        this.paymentId = paymentId;
        this.payoutId = payoutId;
    }

    /**
     * Internal Getter for PaymentId.
     * The ID of the payment associated with this activity.
     * @return Returns the Internal String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPaymentId() {
        return this.paymentId;
    }

    /**
     * Getter for PaymentId.
     * The ID of the payment associated with this activity.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentId() {
        return OptionalNullable.getFrom(paymentId);
    }

    /**
     * Internal Getter for PayoutId.
     * The ID of the payout associated with this activity.
     * @return Returns the Internal String
     */
    @JsonGetter("payout_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPayoutId() {
        return this.payoutId;
    }

    /**
     * Getter for PayoutId.
     * The ID of the payout associated with this activity.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPayoutId() {
        return OptionalNullable.getFrom(payoutId);
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
        if (!(obj instanceof PaymentBalanceActivityAutomaticSavingsDetail)) {
            return false;
        }
        PaymentBalanceActivityAutomaticSavingsDetail other =
                (PaymentBalanceActivityAutomaticSavingsDetail) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(payoutId, other.payoutId);
    }

    /**
     * Converts this PaymentBalanceActivityAutomaticSavingsDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityAutomaticSavingsDetail [" + "paymentId=" + paymentId
                + ", payoutId=" + payoutId + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityAutomaticSavingsDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityAutomaticSavingsDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.paymentId = internalGetPaymentId();
        builder.payoutId = internalGetPayoutId();
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityAutomaticSavingsDetail}.
     */
    public static class Builder {
        private OptionalNullable<String> paymentId;
        private OptionalNullable<String> payoutId;



        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = OptionalNullable.of(paymentId);
            return this;
        }

        /**
         * UnSetter for paymentId.
         * @return Builder
         */
        public Builder unsetPaymentId() {
            paymentId = null;
            return this;
        }

        /**
         * Setter for payoutId.
         * @param  payoutId  String value for payoutId.
         * @return Builder
         */
        public Builder payoutId(String payoutId) {
            this.payoutId = OptionalNullable.of(payoutId);
            return this;
        }

        /**
         * UnSetter for payoutId.
         * @return Builder
         */
        public Builder unsetPayoutId() {
            payoutId = null;
            return this;
        }

        /**
         * Builds a new {@link PaymentBalanceActivityAutomaticSavingsDetail} object using the set
         * fields.
         * @return {@link PaymentBalanceActivityAutomaticSavingsDetail}
         */
        public PaymentBalanceActivityAutomaticSavingsDetail build() {
            return new PaymentBalanceActivityAutomaticSavingsDetail(paymentId, payoutId);
        }
    }
}

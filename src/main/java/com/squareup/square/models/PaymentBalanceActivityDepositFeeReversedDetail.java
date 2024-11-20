
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for PaymentBalanceActivityDepositFeeReversedDetail type.
 */
public class PaymentBalanceActivityDepositFeeReversedDetail {
    private final OptionalNullable<String> payoutId;

    /**
     * Initialization constructor.
     * @param  payoutId  String value for payoutId.
     */
    @JsonCreator
    public PaymentBalanceActivityDepositFeeReversedDetail(
            @JsonProperty("payout_id") String payoutId) {
        this.payoutId = OptionalNullable.of(payoutId);
    }

    /**
     * Initialization constructor.
     * @param  payoutId  String value for payoutId.
     */

    protected PaymentBalanceActivityDepositFeeReversedDetail(OptionalNullable<String> payoutId) {
        this.payoutId = payoutId;
    }

    /**
     * Internal Getter for PayoutId.
     * The ID of the payout that triggered this deposit fee activity.
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
     * The ID of the payout that triggered this deposit fee activity.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPayoutId() {
        return OptionalNullable.getFrom(payoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payoutId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBalanceActivityDepositFeeReversedDetail)) {
            return false;
        }
        PaymentBalanceActivityDepositFeeReversedDetail other =
                (PaymentBalanceActivityDepositFeeReversedDetail) obj;
        return Objects.equals(payoutId, other.payoutId);
    }

    /**
     * Converts this PaymentBalanceActivityDepositFeeReversedDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityDepositFeeReversedDetail [" + "payoutId=" + payoutId + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityDepositFeeReversedDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityDepositFeeReversedDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.payoutId = internalGetPayoutId();
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityDepositFeeReversedDetail}.
     */
    public static class Builder {
        private OptionalNullable<String> payoutId;



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
         * Builds a new {@link PaymentBalanceActivityDepositFeeReversedDetail} object using the set
         * fields.
         * @return {@link PaymentBalanceActivityDepositFeeReversedDetail}
         */
        public PaymentBalanceActivityDepositFeeReversedDetail build() {
            return new PaymentBalanceActivityDepositFeeReversedDetail(payoutId);
        }
    }
}

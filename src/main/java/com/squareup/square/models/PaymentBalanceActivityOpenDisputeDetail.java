
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
 * This is a model class for PaymentBalanceActivityOpenDisputeDetail type.
 */
public class PaymentBalanceActivityOpenDisputeDetail {
    private final OptionalNullable<String> paymentId;
    private final OptionalNullable<String> disputeId;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  disputeId  String value for disputeId.
     */
    @JsonCreator
    public PaymentBalanceActivityOpenDisputeDetail(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("dispute_id") String disputeId) {
        this.paymentId = OptionalNullable.of(paymentId);
        this.disputeId = OptionalNullable.of(disputeId);
    }

    /**
     * Internal initialization constructor.
     */
    protected PaymentBalanceActivityOpenDisputeDetail(OptionalNullable<String> paymentId,
            OptionalNullable<String> disputeId) {
        this.paymentId = paymentId;
        this.disputeId = disputeId;
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
     * Internal Getter for DisputeId.
     * The ID of the dispute associated with this activity.
     * @return Returns the Internal String
     */
    @JsonGetter("dispute_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDisputeId() {
        return this.disputeId;
    }

    /**
     * Getter for DisputeId.
     * The ID of the dispute associated with this activity.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDisputeId() {
        return OptionalNullable.getFrom(disputeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, disputeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBalanceActivityOpenDisputeDetail)) {
            return false;
        }
        PaymentBalanceActivityOpenDisputeDetail other =
                (PaymentBalanceActivityOpenDisputeDetail) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(disputeId, other.disputeId);
    }

    /**
     * Converts this PaymentBalanceActivityOpenDisputeDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityOpenDisputeDetail [" + "paymentId=" + paymentId
                + ", disputeId=" + disputeId + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityOpenDisputeDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityOpenDisputeDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.paymentId = internalGetPaymentId();
        builder.disputeId = internalGetDisputeId();
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityOpenDisputeDetail}.
     */
    public static class Builder {
        private OptionalNullable<String> paymentId;
        private OptionalNullable<String> disputeId;



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
         * Setter for disputeId.
         * @param  disputeId  String value for disputeId.
         * @return Builder
         */
        public Builder disputeId(String disputeId) {
            this.disputeId = OptionalNullable.of(disputeId);
            return this;
        }

        /**
         * UnSetter for disputeId.
         * @return Builder
         */
        public Builder unsetDisputeId() {
            disputeId = null;
            return this;
        }

        /**
         * Builds a new {@link PaymentBalanceActivityOpenDisputeDetail} object using the set fields.
         * @return {@link PaymentBalanceActivityOpenDisputeDetail}
         */
        public PaymentBalanceActivityOpenDisputeDetail build() {
            return new PaymentBalanceActivityOpenDisputeDetail(paymentId, disputeId);
        }
    }
}

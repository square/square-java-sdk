
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for PaymentBalanceActivityRefundDetail type.
 */
public class PaymentBalanceActivityRefundDetail {
    private final String paymentId;
    private final String refundId;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  refundId  String value for refundId.
     */
    @JsonCreator
    public PaymentBalanceActivityRefundDetail(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("refund_id") String refundId) {
        this.paymentId = paymentId;
        this.refundId = refundId;
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
     * Getter for RefundId.
     * The ID of the refund associated with this activity.
     * @return Returns the String
     */
    @JsonGetter("refund_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRefundId() {
        return refundId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, refundId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBalanceActivityRefundDetail)) {
            return false;
        }
        PaymentBalanceActivityRefundDetail other = (PaymentBalanceActivityRefundDetail) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(refundId, other.refundId);
    }

    /**
     * Converts this PaymentBalanceActivityRefundDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityRefundDetail [" + "paymentId=" + paymentId + ", refundId="
                + refundId + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityRefundDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityRefundDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .paymentId(getPaymentId())
                .refundId(getRefundId());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityRefundDetail}.
     */
    public static class Builder {
        private String paymentId;
        private String refundId;



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
         * Setter for refundId.
         * @param  refundId  String value for refundId.
         * @return Builder
         */
        public Builder refundId(String refundId) {
            this.refundId = refundId;
            return this;
        }

        /**
         * Builds a new {@link PaymentBalanceActivityRefundDetail} object using the set fields.
         * @return {@link PaymentBalanceActivityRefundDetail}
         */
        public PaymentBalanceActivityRefundDetail build() {
            return new PaymentBalanceActivityRefundDetail(paymentId, refundId);
        }
    }
}

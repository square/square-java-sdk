
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityRefund type.
 */
public class GiftCardActivityRefund {
    private final String redeemActivityId;
    private final Money amountMoney;
    private final String referenceId;
    private final String paymentId;

    /**
     * Initialization constructor.
     * @param  redeemActivityId  String value for redeemActivityId.
     * @param  amountMoney  Money value for amountMoney.
     * @param  referenceId  String value for referenceId.
     * @param  paymentId  String value for paymentId.
     */
    @JsonCreator
    public GiftCardActivityRefund(
            @JsonProperty("redeem_activity_id") String redeemActivityId,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("payment_id") String paymentId) {
        this.redeemActivityId = redeemActivityId;
        this.amountMoney = amountMoney;
        this.referenceId = referenceId;
        this.paymentId = paymentId;
    }

    /**
     * Getter for RedeemActivityId.
     * The ID of the refunded `REDEEM` gift card activity. Square populates this field if the
     * `payment_id` in the corresponding [RefundPayment]($e/Refunds/RefundPayment) request
     * represents a redemption made by the same gift card. Note that you must use `RefundPayment` to
     * refund a gift card payment to the same gift card if the payment was processed by Square. For
     * applications that use a custom payment processing system, this field is required when
     * creating a `REFUND` activity. The provided `REDEEM` activity ID must be linked to the same
     * gift card.
     * @return Returns the String
     */
    @JsonGetter("redeem_activity_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRedeemActivityId() {
        return redeemActivityId;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for ReferenceId.
     * A client-specified ID that associates the gift card activity with an entity in another
     * system.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for PaymentId.
     * The ID of the refunded payment. Square populates this field if the refund is for a payment
     * processed by Square and one of the following conditions is true: - The Refunds API is used to
     * refund a gift card payment to the same gift card. - A seller initiated the refund from Square
     * Point of Sale or the Seller Dashboard. The payment source can be the same gift card or a
     * cross-tender payment from a credit card or a different gift card.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(redeemActivityId, amountMoney, referenceId, paymentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityRefund)) {
            return false;
        }
        GiftCardActivityRefund other = (GiftCardActivityRefund) obj;
        return Objects.equals(redeemActivityId, other.redeemActivityId)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(paymentId, other.paymentId);
    }

    /**
     * Converts this GiftCardActivityRefund into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityRefund [" + "redeemActivityId=" + redeemActivityId
                + ", amountMoney=" + amountMoney + ", referenceId=" + referenceId + ", paymentId="
                + paymentId + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityRefund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityRefund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .redeemActivityId(getRedeemActivityId())
                .amountMoney(getAmountMoney())
                .referenceId(getReferenceId())
                .paymentId(getPaymentId());
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityRefund}.
     */
    public static class Builder {
        private String redeemActivityId;
        private Money amountMoney;
        private String referenceId;
        private String paymentId;



        /**
         * Setter for redeemActivityId.
         * @param  redeemActivityId  String value for redeemActivityId.
         * @return Builder
         */
        public Builder redeemActivityId(String redeemActivityId) {
            this.redeemActivityId = redeemActivityId;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

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
         * Builds a new {@link GiftCardActivityRefund} object using the set fields.
         * @return {@link GiftCardActivityRefund}
         */
        public GiftCardActivityRefund build() {
            return new GiftCardActivityRefund(redeemActivityId, amountMoney, referenceId,
                    paymentId);
        }
    }
}

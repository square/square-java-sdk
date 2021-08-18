
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityUnlinkedActivityRefund type.
 */
public class GiftCardActivityUnlinkedActivityRefund {
    private final Money amountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String referenceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String paymentId;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  referenceId  String value for referenceId.
     * @param  paymentId  String value for paymentId.
     */
    @JsonCreator
    public GiftCardActivityUnlinkedActivityRefund(
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("payment_id") String paymentId) {
        this.amountMoney = amountMoney;
        this.referenceId = referenceId;
        this.paymentId = paymentId;
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
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for ReferenceId.
     * A client-specified ID to associate an entity, in another system, with this gift card
     * activity. This can be used to track the order or payment related information when the Square
     * Payments API is not being used.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for PaymentId.
     * When using the Square Payments API, the ID of the payment that was refunded to this gift
     * card.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountMoney, referenceId, paymentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityUnlinkedActivityRefund)) {
            return false;
        }
        GiftCardActivityUnlinkedActivityRefund other = (GiftCardActivityUnlinkedActivityRefund) obj;
        return Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(paymentId, other.paymentId);
    }

    /**
     * Converts this GiftCardActivityUnlinkedActivityRefund into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityUnlinkedActivityRefund [" + "amountMoney=" + amountMoney
                + ", referenceId=" + referenceId + ", paymentId=" + paymentId + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityUnlinkedActivityRefund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityUnlinkedActivityRefund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney)
                .referenceId(getReferenceId())
                .paymentId(getPaymentId());
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityUnlinkedActivityRefund}.
     */
    public static class Builder {
        private Money amountMoney;
        private String referenceId;
        private String paymentId;

        /**
         * Initialization constructor.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(Money amountMoney) {
            this.amountMoney = amountMoney;
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
         * Builds a new {@link GiftCardActivityUnlinkedActivityRefund} object using the set fields.
         * @return {@link GiftCardActivityUnlinkedActivityRefund}
         */
        public GiftCardActivityUnlinkedActivityRefund build() {
            return new GiftCardActivityUnlinkedActivityRefund(amountMoney, referenceId, paymentId);
        }
    }
}

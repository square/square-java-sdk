
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityRedeem type.
 */
public class GiftCardActivityRedeem {
    private final Money amountMoney;
    private final String paymentId;
    private final String referenceId;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  paymentId  String value for paymentId.
     * @param  referenceId  String value for referenceId.
     */
    @JsonCreator
    public GiftCardActivityRedeem(
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("reference_id") String referenceId) {
        this.amountMoney = amountMoney;
        this.paymentId = paymentId;
        this.referenceId = referenceId;
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
     * Getter for PaymentId.
     * When the Square Payments API is used, Redeem is not called on the Gift Cards API. However,
     * when Square reads a Redeem activity from the Gift Cards API, developers need to know the
     * associated `payment_id`.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Getter for ReferenceId.
     * A client-specified ID to associate an entity, in another system, with this gift card
     * activity. This can be used to track the order or payment related information when the Square
     * Orders API is not being used.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReferenceId() {
        return referenceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountMoney, paymentId, referenceId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityRedeem)) {
            return false;
        }
        GiftCardActivityRedeem other = (GiftCardActivityRedeem) obj;
        return Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(paymentId, other.paymentId)
            && Objects.equals(referenceId, other.referenceId);
    }

    /**
     * Converts this GiftCardActivityRedeem into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityRedeem [" + "amountMoney=" + amountMoney + ", paymentId="
                + paymentId + ", referenceId=" + referenceId + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityRedeem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityRedeem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney)
                .paymentId(getPaymentId())
                .referenceId(getReferenceId());
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityRedeem}.
     */
    public static class Builder {
        private Money amountMoney;
        private String paymentId;
        private String referenceId;

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
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
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
         * Builds a new {@link GiftCardActivityRedeem} object using the set fields.
         * @return {@link GiftCardActivityRedeem}
         */
        public GiftCardActivityRedeem build() {
            return new GiftCardActivityRedeem(amountMoney, paymentId, referenceId);
        }
    }
}


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
    private final String status;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  paymentId  String value for paymentId.
     * @param  referenceId  String value for referenceId.
     * @param  status  String value for status.
     */
    @JsonCreator
    public GiftCardActivityRedeem(
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("status") String status) {
        this.amountMoney = amountMoney;
        this.paymentId = paymentId;
        this.referenceId = referenceId;
        this.status = status;
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
     * The ID of the payment that represents the gift card redemption. Square populates this field
     * if the payment was processed by Square.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Getter for ReferenceId.
     * A client-specified ID that associates the gift card activity with an entity in another
     * system. Applications that use a custom payment processing system can use this field to track
     * information related to an order or payment.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for Status.
     * Indicates the status of a [gift card]($m/GiftCard) redemption. This status is relevant only
     * for redemptions made from Square products (such as Square Point of Sale) because Square
     * products use a two-state process. Gift cards redeemed using the Gift Card Activities API
     * always have a `COMPLETED` status.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountMoney, paymentId, referenceId, status);
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
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this GiftCardActivityRedeem into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityRedeem [" + "amountMoney=" + amountMoney + ", paymentId="
                + paymentId + ", referenceId=" + referenceId + ", status=" + status + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityRedeem.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityRedeem.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney)
                .paymentId(getPaymentId())
                .referenceId(getReferenceId())
                .status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityRedeem}.
     */
    public static class Builder {
        private Money amountMoney;
        private String paymentId;
        private String referenceId;
        private String status;

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
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link GiftCardActivityRedeem} object using the set fields.
         * @return {@link GiftCardActivityRedeem}
         */
        public GiftCardActivityRedeem build() {
            return new GiftCardActivityRedeem(amountMoney, paymentId, referenceId, status);
        }
    }
}

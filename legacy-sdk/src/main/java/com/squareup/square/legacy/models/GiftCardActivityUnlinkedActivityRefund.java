package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityUnlinkedActivityRefund type.
 */
public class GiftCardActivityUnlinkedActivityRefund {
    private final Money amountMoney;
    private final OptionalNullable<String> referenceId;
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
        this.referenceId = OptionalNullable.of(referenceId);
        this.paymentId = paymentId;
    }

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  referenceId  String value for referenceId.
     * @param  paymentId  String value for paymentId.
     */
    protected GiftCardActivityUnlinkedActivityRefund(
            Money amountMoney, OptionalNullable<String> referenceId, String paymentId) {
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
     * Internal Getter for ReferenceId.
     * A client-specified ID that associates the gift card activity with an entity in another
     * system.
     * @return Returns the Internal String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for ReferenceId.
     * A client-specified ID that associates the gift card activity with an entity in another
     * system.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
    }

    /**
     * Getter for PaymentId.
     * The ID of the refunded payment. This field is not used starting in Square version 2022-06-16.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        return "GiftCardActivityUnlinkedActivityRefund [" + "amountMoney=" + amountMoney + ", referenceId="
                + referenceId + ", paymentId=" + paymentId + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityUnlinkedActivityRefund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityUnlinkedActivityRefund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney).paymentId(getPaymentId());
        builder.referenceId = internalGetReferenceId();
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityUnlinkedActivityRefund}.
     */
    public static class Builder {
        private Money amountMoney;
        private OptionalNullable<String> referenceId;
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
            this.referenceId = OptionalNullable.of(referenceId);
            return this;
        }

        /**
         * UnSetter for referenceId.
         * @return Builder
         */
        public Builder unsetReferenceId() {
            referenceId = null;
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

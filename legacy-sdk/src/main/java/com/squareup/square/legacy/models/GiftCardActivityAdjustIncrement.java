package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityAdjustIncrement type.
 */
public class GiftCardActivityAdjustIncrement {
    private final Money amountMoney;
    private final String reason;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  reason  String value for reason.
     */
    @JsonCreator
    public GiftCardActivityAdjustIncrement(
            @JsonProperty("amount_money") Money amountMoney, @JsonProperty("reason") String reason) {
        this.amountMoney = amountMoney;
        this.reason = reason;
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
     * Getter for Reason.
     * Indicates the reason for adding money to a [gift card]($m/GiftCard).
     * @return Returns the String
     */
    @JsonGetter("reason")
    public String getReason() {
        return reason;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountMoney, reason);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityAdjustIncrement)) {
            return false;
        }
        GiftCardActivityAdjustIncrement other = (GiftCardActivityAdjustIncrement) obj;
        return Objects.equals(amountMoney, other.amountMoney) && Objects.equals(reason, other.reason);
    }

    /**
     * Converts this GiftCardActivityAdjustIncrement into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityAdjustIncrement [" + "amountMoney=" + amountMoney + ", reason=" + reason + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityAdjustIncrement.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityAdjustIncrement.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney, reason);
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityAdjustIncrement}.
     */
    public static class Builder {
        private Money amountMoney;
        private String reason;

        /**
         * Initialization constructor.
         * @param  amountMoney  Money value for amountMoney.
         * @param  reason  String value for reason.
         */
        public Builder(Money amountMoney, String reason) {
            this.amountMoney = amountMoney;
            this.reason = reason;
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
         * Setter for reason.
         * @param  reason  String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Builds a new {@link GiftCardActivityAdjustIncrement} object using the set fields.
         * @return {@link GiftCardActivityAdjustIncrement}
         */
        public GiftCardActivityAdjustIncrement build() {
            return new GiftCardActivityAdjustIncrement(amountMoney, reason);
        }
    }
}

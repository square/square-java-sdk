
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityImportReversal type.
 */
public class GiftCardActivityImportReversal {
    private final Money amountMoney;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     */
    @JsonCreator
    public GiftCardActivityImportReversal(
            @JsonProperty("amount_money") Money amountMoney) {
        this.amountMoney = amountMoney;
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

    @Override
    public int hashCode() {
        return Objects.hash(amountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCardActivityImportReversal)) {
            return false;
        }
        GiftCardActivityImportReversal other = (GiftCardActivityImportReversal) obj;
        return Objects.equals(amountMoney, other.amountMoney);
    }

    /**
     * Converts this GiftCardActivityImportReversal into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityImportReversal [" + "amountMoney=" + amountMoney + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityImportReversal.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityImportReversal.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney);
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityImportReversal}.
     */
    public static class Builder {
        private Money amountMoney;

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
         * Builds a new {@link GiftCardActivityImportReversal} object using the set fields.
         * @return {@link GiftCardActivityImportReversal}
         */
        public GiftCardActivityImportReversal build() {
            return new GiftCardActivityImportReversal(amountMoney);
        }
    }
}

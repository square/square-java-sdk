
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for GiftCardActivityImport type.
 */
public class GiftCardActivityImport {
    private final Money amountMoney;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     */
    @JsonCreator
    public GiftCardActivityImport(
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
        if (!(obj instanceof GiftCardActivityImport)) {
            return false;
        }
        GiftCardActivityImport other = (GiftCardActivityImport) obj;
        return Objects.equals(amountMoney, other.amountMoney);
    }

    /**
     * Converts this GiftCardActivityImport into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCardActivityImport [" + "amountMoney=" + amountMoney + "]";
    }

    /**
     * Builds a new {@link GiftCardActivityImport.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCardActivityImport.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney);
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCardActivityImport}.
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
         * Builds a new {@link GiftCardActivityImport} object using the set fields.
         * @return {@link GiftCardActivityImport}
         */
        public GiftCardActivityImport build() {
            return new GiftCardActivityImport(amountMoney);
        }
    }
}

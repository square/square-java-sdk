
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for Money type.
 */
public class Money {
    private final OptionalNullable<Long> amount;
    private final String currency;

    /**
     * Initialization constructor.
     * @param  amount  Long value for amount.
     * @param  currency  String value for currency.
     */
    @JsonCreator
    public Money(
            @JsonProperty("amount") Long amount,
            @JsonProperty("currency") String currency) {
        this.amount = OptionalNullable.of(amount);
        this.currency = currency;
    }

    /**
     * Initialization constructor.
     * @param  amount  Long value for amount.
     * @param  currency  String value for currency.
     */

    protected Money(OptionalNullable<Long> amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Internal Getter for Amount.
     * The amount of money, in the smallest denomination of the currency indicated by `currency`.
     * For example, when `currency` is `USD`, `amount` is in cents. Monetary amounts can be positive
     * or negative. See the specific field description to determine the meaning of the sign in a
     * particular case.
     * @return Returns the Internal Long
     */
    @JsonGetter("amount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetAmount() {
        return this.amount;
    }

    /**
     * Getter for Amount.
     * The amount of money, in the smallest denomination of the currency indicated by `currency`.
     * For example, when `currency` is `USD`, `amount` is in cents. Monetary amounts can be positive
     * or negative. See the specific field description to determine the meaning of the sign in a
     * particular case.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getAmount() {
        return OptionalNullable.getFrom(amount);
    }

    /**
     * Getter for Currency.
     * Indicates the associated currency for an amount of money. Values correspond to [ISO
     * 4217](https://wikipedia.org/wiki/ISO_4217).
     * @return Returns the String
     */
    @JsonGetter("currency")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Money)) {
            return false;
        }
        Money other = (Money) obj;
        return Objects.equals(amount, other.amount)
            && Objects.equals(currency, other.currency);
    }

    /**
     * Converts this Money into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Money [" + "amount=" + amount + ", currency=" + currency + "]";
    }

    /**
     * Builds a new {@link Money.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Money.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .currency(getCurrency());
        builder.amount = internalGetAmount();
        return builder;
    }

    /**
     * Class to build instances of {@link Money}.
     */
    public static class Builder {
        private OptionalNullable<Long> amount;
        private String currency;



        /**
         * Setter for amount.
         * @param  amount  Long value for amount.
         * @return Builder
         */
        public Builder amount(Long amount) {
            this.amount = OptionalNullable.of(amount);
            return this;
        }

        /**
         * UnSetter for amount.
         * @return Builder
         */
        public Builder unsetAmount() {
            amount = null;
            return this;
        }

        /**
         * Setter for currency.
         * @param  currency  String value for currency.
         * @return Builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Builds a new {@link Money} object using the set fields.
         * @return {@link Money}
         */
        public Money build() {
            return new Money(amount, currency);
        }
    }
}

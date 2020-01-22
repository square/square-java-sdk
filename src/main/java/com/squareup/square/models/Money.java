package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Money type.
 */
public class Money {

    /**
     * Initialization constructor.
     * @param amount
     * @param currency
     */
    @JsonCreator
    public Money(
            @JsonProperty("amount") Long amount,
            @JsonProperty("currency") String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    private final Long amount;
    private final String currency;
    /**
     * Getter for Amount.
     * The amount of money, in the smallest denomination of the currency
     * indicated by `currency`. For example, when `currency` is `USD`, `amount` is
     * in cents. Monetary amounts can be positive or negative. See the specific
     * field description to determine the meaning of the sign in a particular case.
     */
    @JsonGetter("amount")
    public Long getAmount() {
        return this.amount;
    }

    /**
     * Getter for Currency.
     * Indicates the associated currency for an amount of money. Values correspond
     * to [ISO 4217](https://wikipedia.org/wiki/ISO_4217).
     */
    @JsonGetter("currency")
    public String getCurrency() {
        return this.currency;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Money)) {
            return false;
        }
        Money money = (Money) obj;
        return Objects.equals(amount, money.amount) &&
            Objects.equals(currency, money.currency);
    }

    /**
     * Builds a new {@link Money.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Money.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .amount(getAmount())
            .currency(getCurrency());
            return builder;
    }

    /**
     * Class to build instances of {@link Money}
     */
    public static class Builder {
        private Long amount;
        private String currency;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for amount
         * @param amount
         * @return Builder
         */
        public Builder amount(Long amount) {
            this.amount = amount;
            return this;
        }
        /**
         * Setter for currency
         * @param currency
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
            return new Money(amount,
                currency);
        }
    }
}

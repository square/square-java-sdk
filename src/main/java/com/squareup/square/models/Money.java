package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Money {

    @JsonCreator
    public Money(
            @JsonProperty("amount") Long amount,
            @JsonProperty("currency") String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    private final Long amount;
    private final String currency;

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Money)) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(amount, money.amount) &&
            Objects.equals(currency, money.currency);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .amount(getAmount())
            .currency(getCurrency());
            return builder;
    }

    public static class Builder {
        private Long amount;
        private String currency;

        public Builder() { }

        public Builder amount(Long value) {
            amount = value;
            return this;
        }
        public Builder currency(String value) {
            currency = value;
            return this;
        }

        public Money build() {
            return new Money(amount,
                currency);
        }
    }
}

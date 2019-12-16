package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1Money {

    @JsonCreator
    public V1Money(
            @JsonProperty("amount") Integer amount,
            @JsonProperty("currency_code") String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    private final Integer amount;
    private final String currencyCode;

    @Override
    public int hashCode() {
        return Objects.hash(amount, currencyCode);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Money)) {
            return false;
        }
        V1Money v1Money = (V1Money) o;
        return Objects.equals(amount, v1Money.amount) &&
            Objects.equals(currencyCode, v1Money.currencyCode);
    }

    /**
     * Getter for Amount.
     * Amount in the lowest denominated value of this Currency. E.g. in USD
     * these are cents, in JPY they are Yen (which do not have a 'cent' concept).
     */
    @JsonGetter("amount")
    public Integer getAmount() { 
        return this.amount;
    }

    /**
     * Getter for CurrencyCode.
     * Indicates the associated currency for an amount of money. Values correspond
     * to [ISO 4217](https://wikipedia.org/wiki/ISO_4217).
     */
    @JsonGetter("currency_code")
    public String getCurrencyCode() { 
        return this.currencyCode;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .amount(getAmount())
            .currencyCode(getCurrencyCode());
            return builder;
    }

    public static class Builder {
        private Integer amount;
        private String currencyCode;

        public Builder() { }

        public Builder amount(Integer value) {
            amount = value;
            return this;
        }
        public Builder currencyCode(String value) {
            currencyCode = value;
            return this;
        }

        public V1Money build() {
            return new V1Money(amount,
                currencyCode);
        }
    }
}

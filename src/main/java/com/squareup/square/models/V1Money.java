package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1Money type.
 */
public class V1Money {

    /**
     * Initialization constructor.
     * @param amount
     * @param currencyCode
     */
    @JsonCreator
    public V1Money(
            @JsonProperty("amount") Integer amount,
            @JsonProperty("currency_code") String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    private final Integer amount;
    private final String currencyCode;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(amount, currencyCode);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Money)) {
            return false;
        }
        V1Money v1Money = (V1Money) obj;
        return Objects.equals(amount, v1Money.amount) &&
            Objects.equals(currencyCode, v1Money.currencyCode);
    }

    /**
     * Builds a new {@link V1Money.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Money.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .amount(getAmount())
            .currencyCode(getCurrencyCode());
            return builder;
    }

    /**
     * Class to build instances of {@link V1Money}
     */
    public static class Builder {
        private Integer amount;
        private String currencyCode;

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
        public Builder amount(Integer amount) {
            this.amount = amount;
            return this;
        }
        /**
         * Setter for currencyCode
         * @param currencyCode
         * @return Builder
         */
        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        /**
         * Builds a new {@link V1Money} object using the set fields.
         * @return {@link V1Money}
         */
        public V1Money build() {
            return new V1Money(amount,
                currencyCode);
        }
    }
}

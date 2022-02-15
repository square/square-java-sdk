
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1Money type.
 */
public class V1Money {
    private final Integer amount;
    private final String currencyCode;

    /**
     * Initialization constructor.
     * @param  amount  Integer value for amount.
     * @param  currencyCode  String value for currencyCode.
     */
    @JsonCreator
    public V1Money(
            @JsonProperty("amount") Integer amount,
            @JsonProperty("currency_code") String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    /**
     * Getter for Amount.
     * Amount in the lowest denominated value of this Currency. E.g. in USD these are cents, in JPY
     * they are Yen (which do not have a 'cent' concept).
     * @return Returns the Integer
     */
    @JsonGetter("amount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getAmount() {
        return amount;
    }

    /**
     * Getter for CurrencyCode.
     * Indicates the associated currency for an amount of money. Values correspond to [ISO
     * 4217](https://wikipedia.org/wiki/ISO_4217).
     * @return Returns the String
     */
    @JsonGetter("currency_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currencyCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Money)) {
            return false;
        }
        V1Money other = (V1Money) obj;
        return Objects.equals(amount, other.amount)
            && Objects.equals(currencyCode, other.currencyCode);
    }

    /**
     * Converts this V1Money into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1Money [" + "amount=" + amount + ", currencyCode=" + currencyCode + "]";
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
     * Class to build instances of {@link V1Money}.
     */
    public static class Builder {
        private Integer amount;
        private String currencyCode;



        /**
         * Setter for amount.
         * @param  amount  Integer value for amount.
         * @return Builder
         */
        public Builder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        /**
         * Setter for currencyCode.
         * @param  currencyCode  String value for currencyCode.
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
            return new V1Money(amount, currencyCode);
        }
    }
}

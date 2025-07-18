/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Money.Builder.class)
public final class Money {
    private final Optional<Long> amount;

    private final Optional<Currency> currency;

    private final Map<String, Object> additionalProperties;

    private Money(Optional<Long> amount, Optional<Currency> currency, Map<String, Object> additionalProperties) {
        this.amount = amount;
        this.currency = currency;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The amount of money, in the smallest denomination of the currency
     * indicated by <code>currency</code>. For example, when <code>currency</code> is <code>USD</code>, <code>amount</code> is
     * in cents. Monetary amounts can be positive or negative. See the specific
     * field description to determine the meaning of the sign in a particular case.
     */
    @JsonIgnore
    public Optional<Long> getAmount() {
        if (amount == null) {
            return Optional.empty();
        }
        return amount;
    }

    /**
     * @return The type of currency, in <strong>ISO 4217 format</strong>. For example, the currency
     * code for US dollars is <code>USD</code>.
     * <p>See <a href="entity:Currency">Currency</a> for possible values.
     * See <a href="#type-currency">Currency</a> for possible values</p>
     */
    @JsonProperty("currency")
    public Optional<Currency> getCurrency() {
        return currency;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("amount")
    private Optional<Long> _getAmount() {
        return amount;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Money && equalTo((Money) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Money other) {
        return amount.equals(other.amount) && currency.equals(other.currency);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.amount, this.currency);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<Long> amount = Optional.empty();

        private Optional<Currency> currency = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Money other) {
            amount(other.getAmount());
            currency(other.getCurrency());
            return this;
        }

        /**
         * <p>The amount of money, in the smallest denomination of the currency
         * indicated by <code>currency</code>. For example, when <code>currency</code> is <code>USD</code>, <code>amount</code> is
         * in cents. Monetary amounts can be positive or negative. See the specific
         * field description to determine the meaning of the sign in a particular case.</p>
         */
        @JsonSetter(value = "amount", nulls = Nulls.SKIP)
        public Builder amount(Optional<Long> amount) {
            this.amount = amount;
            return this;
        }

        public Builder amount(Long amount) {
            this.amount = Optional.ofNullable(amount);
            return this;
        }

        public Builder amount(Nullable<Long> amount) {
            if (amount.isNull()) {
                this.amount = null;
            } else if (amount.isEmpty()) {
                this.amount = Optional.empty();
            } else {
                this.amount = Optional.of(amount.get());
            }
            return this;
        }

        /**
         * <p>The type of currency, in <strong>ISO 4217 format</strong>. For example, the currency
         * code for US dollars is <code>USD</code>.</p>
         * <p>See <a href="entity:Currency">Currency</a> for possible values.
         * See <a href="#type-currency">Currency</a> for possible values</p>
         */
        @JsonSetter(value = "currency", nulls = Nulls.SKIP)
        public Builder currency(Optional<Currency> currency) {
            this.currency = currency;
            return this;
        }

        public Builder currency(Currency currency) {
            this.currency = Optional.ofNullable(currency);
            return this;
        }

        public Money build() {
            return new Money(amount, currency, additionalProperties);
        }
    }
}

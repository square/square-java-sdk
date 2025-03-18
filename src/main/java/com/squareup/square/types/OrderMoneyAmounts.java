/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = OrderMoneyAmounts.Builder.class)
public final class OrderMoneyAmounts {
    private final Optional<Money> totalMoney;

    private final Optional<Money> taxMoney;

    private final Optional<Money> discountMoney;

    private final Optional<Money> tipMoney;

    private final Optional<Money> serviceChargeMoney;

    private final Map<String, Object> additionalProperties;

    private OrderMoneyAmounts(
            Optional<Money> totalMoney,
            Optional<Money> taxMoney,
            Optional<Money> discountMoney,
            Optional<Money> tipMoney,
            Optional<Money> serviceChargeMoney,
            Map<String, Object> additionalProperties) {
        this.totalMoney = totalMoney;
        this.taxMoney = taxMoney;
        this.discountMoney = discountMoney;
        this.tipMoney = tipMoney;
        this.serviceChargeMoney = serviceChargeMoney;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The total money.
     */
    @JsonProperty("total_money")
    public Optional<Money> getTotalMoney() {
        return totalMoney;
    }

    /**
     * @return The money associated with taxes.
     */
    @JsonProperty("tax_money")
    public Optional<Money> getTaxMoney() {
        return taxMoney;
    }

    /**
     * @return The money associated with discounts.
     */
    @JsonProperty("discount_money")
    public Optional<Money> getDiscountMoney() {
        return discountMoney;
    }

    /**
     * @return The money associated with tips.
     */
    @JsonProperty("tip_money")
    public Optional<Money> getTipMoney() {
        return tipMoney;
    }

    /**
     * @return The money associated with service charges.
     */
    @JsonProperty("service_charge_money")
    public Optional<Money> getServiceChargeMoney() {
        return serviceChargeMoney;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OrderMoneyAmounts && equalTo((OrderMoneyAmounts) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(OrderMoneyAmounts other) {
        return totalMoney.equals(other.totalMoney)
                && taxMoney.equals(other.taxMoney)
                && discountMoney.equals(other.discountMoney)
                && tipMoney.equals(other.tipMoney)
                && serviceChargeMoney.equals(other.serviceChargeMoney);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.totalMoney, this.taxMoney, this.discountMoney, this.tipMoney, this.serviceChargeMoney);
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
        private Optional<Money> totalMoney = Optional.empty();

        private Optional<Money> taxMoney = Optional.empty();

        private Optional<Money> discountMoney = Optional.empty();

        private Optional<Money> tipMoney = Optional.empty();

        private Optional<Money> serviceChargeMoney = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(OrderMoneyAmounts other) {
            totalMoney(other.getTotalMoney());
            taxMoney(other.getTaxMoney());
            discountMoney(other.getDiscountMoney());
            tipMoney(other.getTipMoney());
            serviceChargeMoney(other.getServiceChargeMoney());
            return this;
        }

        @JsonSetter(value = "total_money", nulls = Nulls.SKIP)
        public Builder totalMoney(Optional<Money> totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        public Builder totalMoney(Money totalMoney) {
            this.totalMoney = Optional.ofNullable(totalMoney);
            return this;
        }

        @JsonSetter(value = "tax_money", nulls = Nulls.SKIP)
        public Builder taxMoney(Optional<Money> taxMoney) {
            this.taxMoney = taxMoney;
            return this;
        }

        public Builder taxMoney(Money taxMoney) {
            this.taxMoney = Optional.ofNullable(taxMoney);
            return this;
        }

        @JsonSetter(value = "discount_money", nulls = Nulls.SKIP)
        public Builder discountMoney(Optional<Money> discountMoney) {
            this.discountMoney = discountMoney;
            return this;
        }

        public Builder discountMoney(Money discountMoney) {
            this.discountMoney = Optional.ofNullable(discountMoney);
            return this;
        }

        @JsonSetter(value = "tip_money", nulls = Nulls.SKIP)
        public Builder tipMoney(Optional<Money> tipMoney) {
            this.tipMoney = tipMoney;
            return this;
        }

        public Builder tipMoney(Money tipMoney) {
            this.tipMoney = Optional.ofNullable(tipMoney);
            return this;
        }

        @JsonSetter(value = "service_charge_money", nulls = Nulls.SKIP)
        public Builder serviceChargeMoney(Optional<Money> serviceChargeMoney) {
            this.serviceChargeMoney = serviceChargeMoney;
            return this;
        }

        public Builder serviceChargeMoney(Money serviceChargeMoney) {
            this.serviceChargeMoney = Optional.ofNullable(serviceChargeMoney);
            return this;
        }

        public OrderMoneyAmounts build() {
            return new OrderMoneyAmounts(
                    totalMoney, taxMoney, discountMoney, tipMoney, serviceChargeMoney, additionalProperties);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1PaymentDiscount {

    @JsonCreator
    public V1PaymentDiscount(
            @JsonProperty("name") String name,
            @JsonProperty("applied_money") V1Money appliedMoney,
            @JsonProperty("discount_id") String discountId) {
        this.name = name;
        this.appliedMoney = appliedMoney;
        this.discountId = discountId;
    }

    private final String name;
    private final V1Money appliedMoney;
    private final String discountId;

    @Override
    public int hashCode() {
        return Objects.hash(name, appliedMoney, discountId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1PaymentDiscount)) {
            return false;
        }
        V1PaymentDiscount v1PaymentDiscount = (V1PaymentDiscount) o;
        return Objects.equals(name, v1PaymentDiscount.name) &&
            Objects.equals(appliedMoney, v1PaymentDiscount.appliedMoney) &&
            Objects.equals(discountId, v1PaymentDiscount.discountId);
    }

    /**
     * Getter for Name.
     * The discount's name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for AppliedMoney.
     */
    @JsonGetter("applied_money")
    public V1Money getAppliedMoney() { 
        return this.appliedMoney;
    }

    /**
     * Getter for DiscountId.
     * The ID of the applied discount, if available. Discounts applied in older versions of Square Register might not have an ID.
     */
    @JsonGetter("discount_id")
    public String getDiscountId() { 
        return this.discountId;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .appliedMoney(getAppliedMoney())
            .discountId(getDiscountId());
            return builder;
    }

    public static class Builder {
        private String name;
        private V1Money appliedMoney;
        private String discountId;

        public Builder() { }

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder appliedMoney(V1Money value) {
            appliedMoney = value;
            return this;
        }
        public Builder discountId(String value) {
            discountId = value;
            return this;
        }

        public V1PaymentDiscount build() {
            return new V1PaymentDiscount(name,
                appliedMoney,
                discountId);
        }
    }
}

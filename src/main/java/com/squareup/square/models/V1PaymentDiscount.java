package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1PaymentDiscount type.
 */
public class V1PaymentDiscount {

    /**
     * Initialization constructor.
     * @param name
     * @param appliedMoney
     * @param discountId
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(name, appliedMoney, discountId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1PaymentDiscount)) {
            return false;
        }
        V1PaymentDiscount v1PaymentDiscount = (V1PaymentDiscount) obj;
        return Objects.equals(name, v1PaymentDiscount.name) &&
            Objects.equals(appliedMoney, v1PaymentDiscount.appliedMoney) &&
            Objects.equals(discountId, v1PaymentDiscount.discountId);
    }

    /**
     * Builds a new {@link V1PaymentDiscount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PaymentDiscount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .appliedMoney(getAppliedMoney())
            .discountId(getDiscountId());
            return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentDiscount}
     */
    public static class Builder {
        private String name;
        private V1Money appliedMoney;
        private String discountId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for appliedMoney
         * @param appliedMoney
         * @return Builder
         */
        public Builder appliedMoney(V1Money appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }
        /**
         * Setter for discountId
         * @param discountId
         * @return Builder
         */
        public Builder discountId(String discountId) {
            this.discountId = discountId;
            return this;
        }

        /**
         * Builds a new {@link V1PaymentDiscount} object using the set fields.
         * @return {@link V1PaymentDiscount}
         */
        public V1PaymentDiscount build() {
            return new V1PaymentDiscount(name,
                appliedMoney,
                discountId);
        }
    }
}

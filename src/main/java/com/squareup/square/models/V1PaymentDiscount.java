
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1PaymentDiscount type.
 */
public class V1PaymentDiscount {
    private final String name;
    private final V1Money appliedMoney;
    private final String discountId;

    /**
     * Initialization constructor.
     * @param name String value for name.
     * @param appliedMoney V1Money value for appliedMoney.
     * @param discountId String value for discountId.
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

    /**
     * Getter for Name.
     * The discount's name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for AppliedMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("applied_money")
    public V1Money getAppliedMoney() {
        return this.appliedMoney;
    }

    /**
     * Getter for DiscountId.
     * The ID of the applied discount, if available. Discounts applied in older versions of Square
     * Register might not have an ID.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1PaymentDiscount)) {
            return false;
        }
        V1PaymentDiscount other = (V1PaymentDiscount) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(discountId, other.discountId);
    }

    /**
     * Converts this V1PaymentDiscount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1PaymentDiscount [" + "name=" + name + ", appliedMoney=" + appliedMoney
                + ", discountId=" + discountId + "]";
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
     * Class to build instances of {@link V1PaymentDiscount}.
     */
    public static class Builder {
        private String name;
        private V1Money appliedMoney;
        private String discountId;



        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for appliedMoney.
         * @param appliedMoney V1Money value for appliedMoney.
         * @return Builder
         */
        public Builder appliedMoney(V1Money appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }

        /**
         * Setter for discountId.
         * @param discountId String value for discountId.
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
            return new V1PaymentDiscount(name, appliedMoney, discountId);
        }
    }
}

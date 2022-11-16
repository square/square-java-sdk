
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for V1PaymentDiscount type.
 */
public class V1PaymentDiscount {
    private final OptionalNullable<String> name;
    private final V1Money appliedMoney;
    private final OptionalNullable<String> discountId;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  appliedMoney  V1Money value for appliedMoney.
     * @param  discountId  String value for discountId.
     */
    @JsonCreator
    public V1PaymentDiscount(
            @JsonProperty("name") String name,
            @JsonProperty("applied_money") V1Money appliedMoney,
            @JsonProperty("discount_id") String discountId) {
        this.name = OptionalNullable.of(name);
        this.appliedMoney = appliedMoney;
        this.discountId = OptionalNullable.of(discountId);
    }

    /**
     * Internal initialization constructor.
     */
    protected V1PaymentDiscount(OptionalNullable<String> name, V1Money appliedMoney,
            OptionalNullable<String> discountId) {
        this.name = name;
        this.appliedMoney = appliedMoney;
        this.discountId = discountId;
    }

    /**
     * Internal Getter for Name.
     * The discount's name.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The discount's name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for AppliedMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("applied_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getAppliedMoney() {
        return appliedMoney;
    }

    /**
     * Internal Getter for DiscountId.
     * The ID of the applied discount, if available. Discounts applied in older versions of Square
     * Register might not have an ID.
     * @return Returns the Internal String
     */
    @JsonGetter("discount_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDiscountId() {
        return this.discountId;
    }

    /**
     * Getter for DiscountId.
     * The ID of the applied discount, if available. Discounts applied in older versions of Square
     * Register might not have an ID.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDiscountId() {
        return OptionalNullable.getFrom(discountId);
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
                .appliedMoney(getAppliedMoney());
        builder.name = internalGetName();
        builder.discountId = internalGetDiscountId();
        return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentDiscount}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private V1Money appliedMoney;
        private OptionalNullable<String> discountId;



        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for appliedMoney.
         * @param  appliedMoney  V1Money value for appliedMoney.
         * @return Builder
         */
        public Builder appliedMoney(V1Money appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }

        /**
         * Setter for discountId.
         * @param  discountId  String value for discountId.
         * @return Builder
         */
        public Builder discountId(String discountId) {
            this.discountId = OptionalNullable.of(discountId);
            return this;
        }

        /**
         * UnSetter for discountId.
         * @return Builder
         */
        public Builder unsetDiscountId() {
            discountId = null;
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

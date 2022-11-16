
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1PaymentSurcharge type.
 */
public class V1PaymentSurcharge {
    private final OptionalNullable<String> name;
    private final V1Money appliedMoney;
    private final OptionalNullable<String> rate;
    private final V1Money amountMoney;
    private final String type;
    private final OptionalNullable<Boolean> taxable;
    private final OptionalNullable<List<V1PaymentTax>> taxes;
    private final OptionalNullable<String> surchargeId;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  appliedMoney  V1Money value for appliedMoney.
     * @param  rate  String value for rate.
     * @param  amountMoney  V1Money value for amountMoney.
     * @param  type  String value for type.
     * @param  taxable  Boolean value for taxable.
     * @param  taxes  List of V1PaymentTax value for taxes.
     * @param  surchargeId  String value for surchargeId.
     */
    @JsonCreator
    public V1PaymentSurcharge(
            @JsonProperty("name") String name,
            @JsonProperty("applied_money") V1Money appliedMoney,
            @JsonProperty("rate") String rate,
            @JsonProperty("amount_money") V1Money amountMoney,
            @JsonProperty("type") String type,
            @JsonProperty("taxable") Boolean taxable,
            @JsonProperty("taxes") List<V1PaymentTax> taxes,
            @JsonProperty("surcharge_id") String surchargeId) {
        this.name = OptionalNullable.of(name);
        this.appliedMoney = appliedMoney;
        this.rate = OptionalNullable.of(rate);
        this.amountMoney = amountMoney;
        this.type = type;
        this.taxable = OptionalNullable.of(taxable);
        this.taxes = OptionalNullable.of(taxes);
        this.surchargeId = OptionalNullable.of(surchargeId);
    }

    /**
     * Internal initialization constructor.
     */
    protected V1PaymentSurcharge(OptionalNullable<String> name, V1Money appliedMoney,
            OptionalNullable<String> rate, V1Money amountMoney, String type,
            OptionalNullable<Boolean> taxable, OptionalNullable<List<V1PaymentTax>> taxes,
            OptionalNullable<String> surchargeId) {
        this.name = name;
        this.appliedMoney = appliedMoney;
        this.rate = rate;
        this.amountMoney = amountMoney;
        this.type = type;
        this.taxable = taxable;
        this.taxes = taxes;
        this.surchargeId = surchargeId;
    }

    /**
     * Internal Getter for Name.
     * The name of the surcharge.
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
     * The name of the surcharge.
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
     * Internal Getter for Rate.
     * The amount of the surcharge as a percentage. The percentage is provided as a string
     * representing the decimal equivalent of the percentage. For example, "0.7" corresponds to a 7%
     * surcharge. Exactly one of rate or amount_money should be set.
     * @return Returns the Internal String
     */
    @JsonGetter("rate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetRate() {
        return this.rate;
    }

    /**
     * Getter for Rate.
     * The amount of the surcharge as a percentage. The percentage is provided as a string
     * representing the decimal equivalent of the percentage. For example, "0.7" corresponds to a 7%
     * surcharge. Exactly one of rate or amount_money should be set.
     * @return Returns the String
     */
    @JsonIgnore
    public String getRate() {
        return OptionalNullable.getFrom(rate);
    }

    /**
     * Getter for AmountMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public V1Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Internal Getter for Taxable.
     * Indicates whether the surcharge is taxable.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("taxable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetTaxable() {
        return this.taxable;
    }

    /**
     * Getter for Taxable.
     * Indicates whether the surcharge is taxable.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getTaxable() {
        return OptionalNullable.getFrom(taxable);
    }

    /**
     * Internal Getter for Taxes.
     * The list of taxes that should be applied to the surcharge.
     * @return Returns the Internal List of V1PaymentTax
     */
    @JsonGetter("taxes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<V1PaymentTax>> internalGetTaxes() {
        return this.taxes;
    }

    /**
     * Getter for Taxes.
     * The list of taxes that should be applied to the surcharge.
     * @return Returns the List of V1PaymentTax
     */
    @JsonIgnore
    public List<V1PaymentTax> getTaxes() {
        return OptionalNullable.getFrom(taxes);
    }

    /**
     * Internal Getter for SurchargeId.
     * A Square-issued unique identifier associated with the surcharge.
     * @return Returns the Internal String
     */
    @JsonGetter("surcharge_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSurchargeId() {
        return this.surchargeId;
    }

    /**
     * Getter for SurchargeId.
     * A Square-issued unique identifier associated with the surcharge.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSurchargeId() {
        return OptionalNullable.getFrom(surchargeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, appliedMoney, rate, amountMoney, type, taxable, taxes,
                surchargeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1PaymentSurcharge)) {
            return false;
        }
        V1PaymentSurcharge other = (V1PaymentSurcharge) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(rate, other.rate)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(type, other.type)
            && Objects.equals(taxable, other.taxable)
            && Objects.equals(taxes, other.taxes)
            && Objects.equals(surchargeId, other.surchargeId);
    }

    /**
     * Converts this V1PaymentSurcharge into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1PaymentSurcharge [" + "name=" + name + ", appliedMoney=" + appliedMoney
                + ", rate=" + rate + ", amountMoney=" + amountMoney + ", type=" + type
                + ", taxable=" + taxable + ", taxes=" + taxes + ", surchargeId=" + surchargeId
                + "]";
    }

    /**
     * Builds a new {@link V1PaymentSurcharge.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PaymentSurcharge.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .appliedMoney(getAppliedMoney())
                .amountMoney(getAmountMoney())
                .type(getType());
        builder.name = internalGetName();
        builder.rate = internalGetRate();
        builder.taxable = internalGetTaxable();
        builder.taxes = internalGetTaxes();
        builder.surchargeId = internalGetSurchargeId();
        return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentSurcharge}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private V1Money appliedMoney;
        private OptionalNullable<String> rate;
        private V1Money amountMoney;
        private String type;
        private OptionalNullable<Boolean> taxable;
        private OptionalNullable<List<V1PaymentTax>> taxes;
        private OptionalNullable<String> surchargeId;



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
         * Setter for rate.
         * @param  rate  String value for rate.
         * @return Builder
         */
        public Builder rate(String rate) {
            this.rate = OptionalNullable.of(rate);
            return this;
        }

        /**
         * UnSetter for rate.
         * @return Builder
         */
        public Builder unsetRate() {
            rate = null;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param  amountMoney  V1Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(V1Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for taxable.
         * @param  taxable  Boolean value for taxable.
         * @return Builder
         */
        public Builder taxable(Boolean taxable) {
            this.taxable = OptionalNullable.of(taxable);
            return this;
        }

        /**
         * UnSetter for taxable.
         * @return Builder
         */
        public Builder unsetTaxable() {
            taxable = null;
            return this;
        }

        /**
         * Setter for taxes.
         * @param  taxes  List of V1PaymentTax value for taxes.
         * @return Builder
         */
        public Builder taxes(List<V1PaymentTax> taxes) {
            this.taxes = OptionalNullable.of(taxes);
            return this;
        }

        /**
         * UnSetter for taxes.
         * @return Builder
         */
        public Builder unsetTaxes() {
            taxes = null;
            return this;
        }

        /**
         * Setter for surchargeId.
         * @param  surchargeId  String value for surchargeId.
         * @return Builder
         */
        public Builder surchargeId(String surchargeId) {
            this.surchargeId = OptionalNullable.of(surchargeId);
            return this;
        }

        /**
         * UnSetter for surchargeId.
         * @return Builder
         */
        public Builder unsetSurchargeId() {
            surchargeId = null;
            return this;
        }

        /**
         * Builds a new {@link V1PaymentSurcharge} object using the set fields.
         * @return {@link V1PaymentSurcharge}
         */
        public V1PaymentSurcharge build() {
            return new V1PaymentSurcharge(name, appliedMoney, rate, amountMoney, type, taxable,
                    taxes, surchargeId);
        }
    }
}

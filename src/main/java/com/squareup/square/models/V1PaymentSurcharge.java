package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1PaymentSurcharge type.
 */
public class V1PaymentSurcharge {

    /**
     * Initialization constructor.
     * @param name
     * @param appliedMoney
     * @param rate
     * @param amountMoney
     * @param type
     * @param taxable
     * @param taxes
     * @param surchargeId
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
        this.name = name;
        this.appliedMoney = appliedMoney;
        this.rate = rate;
        this.amountMoney = amountMoney;
        this.type = type;
        this.taxable = taxable;
        this.taxes = taxes;
        this.surchargeId = surchargeId;
    }

    private final String name;
    private final V1Money appliedMoney;
    private final String rate;
    private final V1Money amountMoney;
    private final String type;
    private final Boolean taxable;
    private final List<V1PaymentTax> taxes;
    private final String surchargeId;
    /**
     * Getter for Name.
     * The name of the surcharge.
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
     * Getter for Rate.
     * The amount of the surcharge as a percentage. The percentage is provided as a string representing the decimal equivalent of the percentage. For example, "0.7" corresponds to a 7% surcharge. Exactly one of rate or amount_money should be set.
     */
    @JsonGetter("rate")
    public String getRate() {
        return this.rate;
    }

    /**
     * Getter for AmountMoney.
     */
    @JsonGetter("amount_money")
    public V1Money getAmountMoney() {
        return this.amountMoney;
    }

    /**
     * Getter for Type.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Taxable.
     * Indicates whether the surcharge is taxable.
     */
    @JsonGetter("taxable")
    public Boolean getTaxable() {
        return this.taxable;
    }

    /**
     * Getter for Taxes.
     * The list of taxes that should be applied to the surcharge.
     */
    @JsonGetter("taxes")
    public List<V1PaymentTax> getTaxes() {
        return this.taxes;
    }

    /**
     * Getter for SurchargeId.
     * A Square-issued unique identifier associated with the surcharge.
     */
    @JsonGetter("surcharge_id")
    public String getSurchargeId() {
        return this.surchargeId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, appliedMoney, rate, amountMoney, type, taxable, taxes, surchargeId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1PaymentSurcharge)) {
            return false;
        }
        V1PaymentSurcharge v1PaymentSurcharge = (V1PaymentSurcharge) obj;
        return Objects.equals(name, v1PaymentSurcharge.name) &&
            Objects.equals(appliedMoney, v1PaymentSurcharge.appliedMoney) &&
            Objects.equals(rate, v1PaymentSurcharge.rate) &&
            Objects.equals(amountMoney, v1PaymentSurcharge.amountMoney) &&
            Objects.equals(type, v1PaymentSurcharge.type) &&
            Objects.equals(taxable, v1PaymentSurcharge.taxable) &&
            Objects.equals(taxes, v1PaymentSurcharge.taxes) &&
            Objects.equals(surchargeId, v1PaymentSurcharge.surchargeId);
    }

    /**
     * Builds a new {@link V1PaymentSurcharge.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PaymentSurcharge.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .appliedMoney(getAppliedMoney())
            .rate(getRate())
            .amountMoney(getAmountMoney())
            .type(getType())
            .taxable(getTaxable())
            .taxes(getTaxes())
            .surchargeId(getSurchargeId());
            return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentSurcharge}
     */
    public static class Builder {
        private String name;
        private V1Money appliedMoney;
        private String rate;
        private V1Money amountMoney;
        private String type;
        private Boolean taxable;
        private List<V1PaymentTax> taxes;
        private String surchargeId;

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
         * Setter for rate
         * @param rate
         * @return Builder
         */
        public Builder rate(String rate) {
            this.rate = rate;
            return this;
        }
        /**
         * Setter for amountMoney
         * @param amountMoney
         * @return Builder
         */
        public Builder amountMoney(V1Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }
        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for taxable
         * @param taxable
         * @return Builder
         */
        public Builder taxable(Boolean taxable) {
            this.taxable = taxable;
            return this;
        }
        /**
         * Setter for taxes
         * @param taxes
         * @return Builder
         */
        public Builder taxes(List<V1PaymentTax> taxes) {
            this.taxes = taxes;
            return this;
        }
        /**
         * Setter for surchargeId
         * @param surchargeId
         * @return Builder
         */
        public Builder surchargeId(String surchargeId) {
            this.surchargeId = surchargeId;
            return this;
        }

        /**
         * Builds a new {@link V1PaymentSurcharge} object using the set fields.
         * @return {@link V1PaymentSurcharge}
         */
        public V1PaymentSurcharge build() {
            return new V1PaymentSurcharge(name,
                appliedMoney,
                rate,
                amountMoney,
                type,
                taxable,
                taxes,
                surchargeId);
        }
    }
}

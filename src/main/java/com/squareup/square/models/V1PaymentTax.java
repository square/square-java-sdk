package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1PaymentTax type.
 */
public class V1PaymentTax {

    /**
     * Initialization constructor.
     * @param errors
     * @param name
     * @param appliedMoney
     * @param rate
     * @param inclusionType
     * @param feeId
     */
    @JsonCreator
    public V1PaymentTax(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("name") String name,
            @JsonProperty("applied_money") V1Money appliedMoney,
            @JsonProperty("rate") String rate,
            @JsonProperty("inclusion_type") String inclusionType,
            @JsonProperty("fee_id") String feeId) {
        this.errors = errors;
        this.name = name;
        this.appliedMoney = appliedMoney;
        this.rate = rate;
        this.inclusionType = inclusionType;
        this.feeId = feeId;
    }

    private final List<Error> errors;
    private final String name;
    private final V1Money appliedMoney;
    private final String rate;
    private final String inclusionType;
    private final String feeId;
    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Name.
     * The merchant-defined name of the tax.
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
     * The rate of the tax, as a string representation of a decimal number. A value of 0.07 corresponds to a rate of 7%.
     */
    @JsonGetter("rate")
    public String getRate() {
        return this.rate;
    }

    /**
     * Getter for InclusionType.
     */
    @JsonGetter("inclusion_type")
    public String getInclusionType() {
        return this.inclusionType;
    }

    /**
     * Getter for FeeId.
     * The ID of the tax, if available. Taxes applied in older versions of Square Register might not have an ID.
     */
    @JsonGetter("fee_id")
    public String getFeeId() {
        return this.feeId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, name, appliedMoney, rate, inclusionType, feeId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1PaymentTax)) {
            return false;
        }
        V1PaymentTax v1PaymentTax = (V1PaymentTax) obj;
        return Objects.equals(errors, v1PaymentTax.errors) &&
            Objects.equals(name, v1PaymentTax.name) &&
            Objects.equals(appliedMoney, v1PaymentTax.appliedMoney) &&
            Objects.equals(rate, v1PaymentTax.rate) &&
            Objects.equals(inclusionType, v1PaymentTax.inclusionType) &&
            Objects.equals(feeId, v1PaymentTax.feeId);
    }

    /**
     * Builds a new {@link V1PaymentTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PaymentTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .name(getName())
            .appliedMoney(getAppliedMoney())
            .rate(getRate())
            .inclusionType(getInclusionType())
            .feeId(getFeeId());
            return builder;
    }

    /**
     * Class to build instances of {@link V1PaymentTax}
     */
    public static class Builder {
        private List<Error> errors;
        private String name;
        private V1Money appliedMoney;
        private String rate;
        private String inclusionType;
        private String feeId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
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
         * Setter for inclusionType
         * @param inclusionType
         * @return Builder
         */
        public Builder inclusionType(String inclusionType) {
            this.inclusionType = inclusionType;
            return this;
        }
        /**
         * Setter for feeId
         * @param feeId
         * @return Builder
         */
        public Builder feeId(String feeId) {
            this.feeId = feeId;
            return this;
        }

        /**
         * Builds a new {@link V1PaymentTax} object using the set fields.
         * @return {@link V1PaymentTax}
         */
        public V1PaymentTax build() {
            return new V1PaymentTax(errors,
                name,
                appliedMoney,
                rate,
                inclusionType,
                feeId);
        }
    }
}

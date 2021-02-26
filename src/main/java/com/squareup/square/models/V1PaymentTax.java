
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1PaymentTax type.
 */
public class V1PaymentTax {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final V1Money appliedMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String rate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String inclusionType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String feeId;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  name  String value for name.
     * @param  appliedMoney  V1Money value for appliedMoney.
     * @param  rate  String value for rate.
     * @param  inclusionType  String value for inclusionType.
     * @param  feeId  String value for feeId.
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

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Name.
     * The merchant-defined name of the tax.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for AppliedMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("applied_money")
    public V1Money getAppliedMoney() {
        return appliedMoney;
    }

    /**
     * Getter for Rate.
     * The rate of the tax, as a string representation of a decimal number. A value of 0.07
     * corresponds to a rate of 7%.
     * @return Returns the String
     */
    @JsonGetter("rate")
    public String getRate() {
        return rate;
    }

    /**
     * Getter for InclusionType.
     * @return Returns the String
     */
    @JsonGetter("inclusion_type")
    public String getInclusionType() {
        return inclusionType;
    }

    /**
     * Getter for FeeId.
     * The ID of the tax, if available. Taxes applied in older versions of Square Register might not
     * have an ID.
     * @return Returns the String
     */
    @JsonGetter("fee_id")
    public String getFeeId() {
        return feeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, name, appliedMoney, rate, inclusionType, feeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1PaymentTax)) {
            return false;
        }
        V1PaymentTax other = (V1PaymentTax) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(name, other.name)
            && Objects.equals(appliedMoney, other.appliedMoney)
            && Objects.equals(rate, other.rate)
            && Objects.equals(inclusionType, other.inclusionType)
            && Objects.equals(feeId, other.feeId);
    }

    /**
     * Converts this V1PaymentTax into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1PaymentTax [" + "errors=" + errors + ", name=" + name + ", appliedMoney="
                + appliedMoney + ", rate=" + rate + ", inclusionType=" + inclusionType + ", feeId="
                + feeId + "]";
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
     * Class to build instances of {@link V1PaymentTax}.
     */
    public static class Builder {
        private List<Error> errors;
        private String name;
        private V1Money appliedMoney;
        private String rate;
        private String inclusionType;
        private String feeId;



        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
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
            this.rate = rate;
            return this;
        }

        /**
         * Setter for inclusionType.
         * @param  inclusionType  String value for inclusionType.
         * @return Builder
         */
        public Builder inclusionType(String inclusionType) {
            this.inclusionType = inclusionType;
            return this;
        }

        /**
         * Setter for feeId.
         * @param  feeId  String value for feeId.
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
            return new V1PaymentTax(errors, name, appliedMoney, rate, inclusionType, feeId);
        }
    }
}

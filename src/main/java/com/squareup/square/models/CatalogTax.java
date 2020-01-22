package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogTax type.
 */
public class CatalogTax {

    /**
     * Initialization constructor.
     * @param name
     * @param calculationPhase
     * @param inclusionType
     * @param percentage
     * @param appliesToCustomAmounts
     * @param enabled
     */
    @JsonCreator
    public CatalogTax(
            @JsonProperty("name") String name,
            @JsonProperty("calculation_phase") String calculationPhase,
            @JsonProperty("inclusion_type") String inclusionType,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("applies_to_custom_amounts") Boolean appliesToCustomAmounts,
            @JsonProperty("enabled") Boolean enabled) {
        this.name = name;
        this.calculationPhase = calculationPhase;
        this.inclusionType = inclusionType;
        this.percentage = percentage;
        this.appliesToCustomAmounts = appliesToCustomAmounts;
        this.enabled = enabled;
    }

    private final String name;
    private final String calculationPhase;
    private final String inclusionType;
    private final String percentage;
    private final Boolean appliesToCustomAmounts;
    private final Boolean enabled;
    /**
     * Getter for Name.
     * The tax's name. Searchable. This field has max length of 255 Unicode code points.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for CalculationPhase.
     * When to calculate the taxes due on a cart.
     */
    @JsonGetter("calculation_phase")
    public String getCalculationPhase() {
        return this.calculationPhase;
    }

    /**
     * Getter for InclusionType.
     * Whether to the tax amount should be additional to or included in the CatalogItem price.
     */
    @JsonGetter("inclusion_type")
    public String getInclusionType() {
        return this.inclusionType;
    }

    /**
     * Getter for Percentage.
     * The percentage of the tax in decimal form, using a `'.'` as the decimal separator and without a `'%'` sign.
     * A value of `7.5` corresponds to 7.5%.
     */
    @JsonGetter("percentage")
    public String getPercentage() {
        return this.percentage;
    }

    /**
     * Getter for AppliesToCustomAmounts.
     * If `true`, the fee applies to custom amounts entered into the Square Point of Sale
     * app that are not associated with a particular `CatalogItem`.
     */
    @JsonGetter("applies_to_custom_amounts")
    public Boolean getAppliesToCustomAmounts() {
        return this.appliesToCustomAmounts;
    }

    /**
     * Getter for Enabled.
     * If `true`, the tax will be shown as enabled in the Square Point of Sale app.
     */
    @JsonGetter("enabled")
    public Boolean getEnabled() {
        return this.enabled;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, calculationPhase, inclusionType, percentage,
            appliesToCustomAmounts, enabled);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogTax)) {
            return false;
        }
        CatalogTax catalogTax = (CatalogTax) obj;
        return Objects.equals(name, catalogTax.name) &&
            Objects.equals(calculationPhase, catalogTax.calculationPhase) &&
            Objects.equals(inclusionType, catalogTax.inclusionType) &&
            Objects.equals(percentage, catalogTax.percentage) &&
            Objects.equals(appliesToCustomAmounts, catalogTax.appliesToCustomAmounts) &&
            Objects.equals(enabled, catalogTax.enabled);
    }

    /**
     * Builds a new {@link CatalogTax.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogTax.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .calculationPhase(getCalculationPhase())
            .inclusionType(getInclusionType())
            .percentage(getPercentage())
            .appliesToCustomAmounts(getAppliesToCustomAmounts())
            .enabled(getEnabled());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogTax}
     */
    public static class Builder {
        private String name;
        private String calculationPhase;
        private String inclusionType;
        private String percentage;
        private Boolean appliesToCustomAmounts;
        private Boolean enabled;

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
         * Setter for calculationPhase
         * @param calculationPhase
         * @return Builder
         */
        public Builder calculationPhase(String calculationPhase) {
            this.calculationPhase = calculationPhase;
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
         * Setter for percentage
         * @param percentage
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
            return this;
        }
        /**
         * Setter for appliesToCustomAmounts
         * @param appliesToCustomAmounts
         * @return Builder
         */
        public Builder appliesToCustomAmounts(Boolean appliesToCustomAmounts) {
            this.appliesToCustomAmounts = appliesToCustomAmounts;
            return this;
        }
        /**
         * Setter for enabled
         * @param enabled
         * @return Builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Builds a new {@link CatalogTax} object using the set fields.
         * @return {@link CatalogTax}
         */
        public CatalogTax build() {
            return new CatalogTax(name,
                calculationPhase,
                inclusionType,
                percentage,
                appliesToCustomAmounts,
                enabled);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogTax type.
 */
public class CatalogTax {
    private final String name;
    private final String calculationPhase;
    private final String inclusionType;
    private final String percentage;
    private final Boolean appliesToCustomAmounts;
    private final Boolean enabled;

    /**
     * Initialization constructor.
     * @param name String value for name.
     * @param calculationPhase String value for calculationPhase.
     * @param inclusionType String value for inclusionType.
     * @param percentage String value for percentage.
     * @param appliesToCustomAmounts Boolean value for appliesToCustomAmounts.
     * @param enabled Boolean value for enabled.
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

    /**
     * Getter for Name.
     * The tax's name. This is a searchable attribute for use in applicable query filters, and its
     * value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for CalculationPhase.
     * When to calculate the taxes due on a cart.
     * @return Returns the String
     */
    @JsonGetter("calculation_phase")
    public String getCalculationPhase() {
        return this.calculationPhase;
    }

    /**
     * Getter for InclusionType.
     * Whether to the tax amount should be additional to or included in the CatalogItem price.
     * @return Returns the String
     */
    @JsonGetter("inclusion_type")
    public String getInclusionType() {
        return this.inclusionType;
    }

    /**
     * Getter for Percentage.
     * The percentage of the tax in decimal form, using a `'.'` as the decimal separator and without
     * a `'%'` sign. A value of `7.5` corresponds to 7.5%.
     * @return Returns the String
     */
    @JsonGetter("percentage")
    public String getPercentage() {
        return this.percentage;
    }

    /**
     * Getter for AppliesToCustomAmounts.
     * If `true`, the fee applies to custom amounts entered into the Square Point of Sale app that
     * are not associated with a particular `CatalogItem`.
     * @return Returns the Boolean
     */
    @JsonGetter("applies_to_custom_amounts")
    public Boolean getAppliesToCustomAmounts() {
        return this.appliesToCustomAmounts;
    }

    /**
     * Getter for Enabled.
     * A Boolean flag to indicate whether the tax is displayed as enabled (`true`) in the Square
     * Point of Sale app or not (`false`).
     * @return Returns the Boolean
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogTax)) {
            return false;
        }
        CatalogTax other = (CatalogTax) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(calculationPhase, other.calculationPhase)
            && Objects.equals(inclusionType, other.inclusionType)
            && Objects.equals(percentage, other.percentage)
            && Objects.equals(appliesToCustomAmounts, other.appliesToCustomAmounts)
            && Objects.equals(enabled, other.enabled);
    }

    /**
     * Converts this CatalogTax into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogTax [" + "name=" + name + ", calculationPhase=" + calculationPhase
                + ", inclusionType=" + inclusionType + ", percentage=" + percentage
                + ", appliesToCustomAmounts=" + appliesToCustomAmounts + ", enabled=" + enabled
                + "]";
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
     * Class to build instances of {@link CatalogTax}.
     */
    public static class Builder {
        private String name;
        private String calculationPhase;
        private String inclusionType;
        private String percentage;
        private Boolean appliesToCustomAmounts;
        private Boolean enabled;



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
         * Setter for calculationPhase.
         * @param calculationPhase String value for calculationPhase.
         * @return Builder
         */
        public Builder calculationPhase(String calculationPhase) {
            this.calculationPhase = calculationPhase;
            return this;
        }

        /**
         * Setter for inclusionType.
         * @param inclusionType String value for inclusionType.
         * @return Builder
         */
        public Builder inclusionType(String inclusionType) {
            this.inclusionType = inclusionType;
            return this;
        }

        /**
         * Setter for percentage.
         * @param percentage String value for percentage.
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = percentage;
            return this;
        }

        /**
         * Setter for appliesToCustomAmounts.
         * @param appliesToCustomAmounts Boolean value for appliesToCustomAmounts.
         * @return Builder
         */
        public Builder appliesToCustomAmounts(Boolean appliesToCustomAmounts) {
            this.appliesToCustomAmounts = appliesToCustomAmounts;
            return this;
        }

        /**
         * Setter for enabled.
         * @param enabled Boolean value for enabled.
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
            return new CatalogTax(name, calculationPhase, inclusionType, percentage,
                    appliesToCustomAmounts, enabled);
        }
    }
}

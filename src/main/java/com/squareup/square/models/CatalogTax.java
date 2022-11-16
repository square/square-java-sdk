
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
 * This is a model class for CatalogTax type.
 */
public class CatalogTax {
    private final OptionalNullable<String> name;
    private final String calculationPhase;
    private final String inclusionType;
    private final OptionalNullable<String> percentage;
    private final OptionalNullable<Boolean> appliesToCustomAmounts;
    private final OptionalNullable<Boolean> enabled;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  calculationPhase  String value for calculationPhase.
     * @param  inclusionType  String value for inclusionType.
     * @param  percentage  String value for percentage.
     * @param  appliesToCustomAmounts  Boolean value for appliesToCustomAmounts.
     * @param  enabled  Boolean value for enabled.
     */
    @JsonCreator
    public CatalogTax(
            @JsonProperty("name") String name,
            @JsonProperty("calculation_phase") String calculationPhase,
            @JsonProperty("inclusion_type") String inclusionType,
            @JsonProperty("percentage") String percentage,
            @JsonProperty("applies_to_custom_amounts") Boolean appliesToCustomAmounts,
            @JsonProperty("enabled") Boolean enabled) {
        this.name = OptionalNullable.of(name);
        this.calculationPhase = calculationPhase;
        this.inclusionType = inclusionType;
        this.percentage = OptionalNullable.of(percentage);
        this.appliesToCustomAmounts = OptionalNullable.of(appliesToCustomAmounts);
        this.enabled = OptionalNullable.of(enabled);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogTax(OptionalNullable<String> name, String calculationPhase,
            String inclusionType, OptionalNullable<String> percentage,
            OptionalNullable<Boolean> appliesToCustomAmounts, OptionalNullable<Boolean> enabled) {
        this.name = name;
        this.calculationPhase = calculationPhase;
        this.inclusionType = inclusionType;
        this.percentage = percentage;
        this.appliesToCustomAmounts = appliesToCustomAmounts;
        this.enabled = enabled;
    }

    /**
     * Internal Getter for Name.
     * The tax's name. This is a searchable attribute for use in applicable query filters, and its
     * value length is of Unicode code points.
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
     * The tax's name. This is a searchable attribute for use in applicable query filters, and its
     * value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for CalculationPhase.
     * When to calculate the taxes due on a cart.
     * @return Returns the String
     */
    @JsonGetter("calculation_phase")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCalculationPhase() {
        return calculationPhase;
    }

    /**
     * Getter for InclusionType.
     * Whether to the tax amount should be additional to or included in the CatalogItem price.
     * @return Returns the String
     */
    @JsonGetter("inclusion_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInclusionType() {
        return inclusionType;
    }

    /**
     * Internal Getter for Percentage.
     * The percentage of the tax in decimal form, using a `'.'` as the decimal separator and without
     * a `'%'` sign. A value of `7.5` corresponds to 7.5%. For a location-specific tax rate, contact
     * the tax authority of the location or a tax consultant.
     * @return Returns the Internal String
     */
    @JsonGetter("percentage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPercentage() {
        return this.percentage;
    }

    /**
     * Getter for Percentage.
     * The percentage of the tax in decimal form, using a `'.'` as the decimal separator and without
     * a `'%'` sign. A value of `7.5` corresponds to 7.5%. For a location-specific tax rate, contact
     * the tax authority of the location or a tax consultant.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPercentage() {
        return OptionalNullable.getFrom(percentage);
    }

    /**
     * Internal Getter for AppliesToCustomAmounts.
     * If `true`, the fee applies to custom amounts entered into the Square Point of Sale app that
     * are not associated with a particular `CatalogItem`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("applies_to_custom_amounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAppliesToCustomAmounts() {
        return this.appliesToCustomAmounts;
    }

    /**
     * Getter for AppliesToCustomAmounts.
     * If `true`, the fee applies to custom amounts entered into the Square Point of Sale app that
     * are not associated with a particular `CatalogItem`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAppliesToCustomAmounts() {
        return OptionalNullable.getFrom(appliesToCustomAmounts);
    }

    /**
     * Internal Getter for Enabled.
     * A Boolean flag to indicate whether the tax is displayed as enabled (`true`) in the Square
     * Point of Sale app or not (`false`).
     * @return Returns the Internal Boolean
     */
    @JsonGetter("enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetEnabled() {
        return this.enabled;
    }

    /**
     * Getter for Enabled.
     * A Boolean flag to indicate whether the tax is displayed as enabled (`true`) in the Square
     * Point of Sale app or not (`false`).
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getEnabled() {
        return OptionalNullable.getFrom(enabled);
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
                .calculationPhase(getCalculationPhase())
                .inclusionType(getInclusionType());
        builder.name = internalGetName();
        builder.percentage = internalGetPercentage();
        builder.appliesToCustomAmounts = internalGetAppliesToCustomAmounts();
        builder.enabled = internalGetEnabled();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogTax}.
     */
    public static class Builder {
        private OptionalNullable<String> name;
        private String calculationPhase;
        private String inclusionType;
        private OptionalNullable<String> percentage;
        private OptionalNullable<Boolean> appliesToCustomAmounts;
        private OptionalNullable<Boolean> enabled;



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
         * Setter for calculationPhase.
         * @param  calculationPhase  String value for calculationPhase.
         * @return Builder
         */
        public Builder calculationPhase(String calculationPhase) {
            this.calculationPhase = calculationPhase;
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
         * Setter for percentage.
         * @param  percentage  String value for percentage.
         * @return Builder
         */
        public Builder percentage(String percentage) {
            this.percentage = OptionalNullable.of(percentage);
            return this;
        }

        /**
         * UnSetter for percentage.
         * @return Builder
         */
        public Builder unsetPercentage() {
            percentage = null;
            return this;
        }

        /**
         * Setter for appliesToCustomAmounts.
         * @param  appliesToCustomAmounts  Boolean value for appliesToCustomAmounts.
         * @return Builder
         */
        public Builder appliesToCustomAmounts(Boolean appliesToCustomAmounts) {
            this.appliesToCustomAmounts = OptionalNullable.of(appliesToCustomAmounts);
            return this;
        }

        /**
         * UnSetter for appliesToCustomAmounts.
         * @return Builder
         */
        public Builder unsetAppliesToCustomAmounts() {
            appliesToCustomAmounts = null;
            return this;
        }

        /**
         * Setter for enabled.
         * @param  enabled  Boolean value for enabled.
         * @return Builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = OptionalNullable.of(enabled);
            return this;
        }

        /**
         * UnSetter for enabled.
         * @return Builder
         */
        public Builder unsetEnabled() {
            enabled = null;
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

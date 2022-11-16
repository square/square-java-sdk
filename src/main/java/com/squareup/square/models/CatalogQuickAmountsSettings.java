
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
 * This is a model class for CatalogQuickAmountsSettings type.
 */
public class CatalogQuickAmountsSettings {
    private final String option;
    private final OptionalNullable<Boolean> eligibleForAutoAmounts;
    private final OptionalNullable<List<CatalogQuickAmount>> amounts;

    /**
     * Initialization constructor.
     * @param  option  String value for option.
     * @param  eligibleForAutoAmounts  Boolean value for eligibleForAutoAmounts.
     * @param  amounts  List of CatalogQuickAmount value for amounts.
     */
    @JsonCreator
    public CatalogQuickAmountsSettings(
            @JsonProperty("option") String option,
            @JsonProperty("eligible_for_auto_amounts") Boolean eligibleForAutoAmounts,
            @JsonProperty("amounts") List<CatalogQuickAmount> amounts) {
        this.option = option;
        this.eligibleForAutoAmounts = OptionalNullable.of(eligibleForAutoAmounts);
        this.amounts = OptionalNullable.of(amounts);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogQuickAmountsSettings(String option,
            OptionalNullable<Boolean> eligibleForAutoAmounts,
            OptionalNullable<List<CatalogQuickAmount>> amounts) {
        this.option = option;
        this.eligibleForAutoAmounts = eligibleForAutoAmounts;
        this.amounts = amounts;
    }

    /**
     * Getter for Option.
     * Determines a seller's option on Quick Amounts feature.
     * @return Returns the String
     */
    @JsonGetter("option")
    public String getOption() {
        return option;
    }

    /**
     * Internal Getter for EligibleForAutoAmounts.
     * Represents location's eligibility for auto amounts The boolean should be consistent with
     * whether there are AUTO amounts in the `amounts`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("eligible_for_auto_amounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetEligibleForAutoAmounts() {
        return this.eligibleForAutoAmounts;
    }

    /**
     * Getter for EligibleForAutoAmounts.
     * Represents location's eligibility for auto amounts The boolean should be consistent with
     * whether there are AUTO amounts in the `amounts`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getEligibleForAutoAmounts() {
        return OptionalNullable.getFrom(eligibleForAutoAmounts);
    }

    /**
     * Internal Getter for Amounts.
     * Represents a set of Quick Amounts at this location.
     * @return Returns the Internal List of CatalogQuickAmount
     */
    @JsonGetter("amounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogQuickAmount>> internalGetAmounts() {
        return this.amounts;
    }

    /**
     * Getter for Amounts.
     * Represents a set of Quick Amounts at this location.
     * @return Returns the List of CatalogQuickAmount
     */
    @JsonIgnore
    public List<CatalogQuickAmount> getAmounts() {
        return OptionalNullable.getFrom(amounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(option, eligibleForAutoAmounts, amounts);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogQuickAmountsSettings)) {
            return false;
        }
        CatalogQuickAmountsSettings other = (CatalogQuickAmountsSettings) obj;
        return Objects.equals(option, other.option)
            && Objects.equals(eligibleForAutoAmounts, other.eligibleForAutoAmounts)
            && Objects.equals(amounts, other.amounts);
    }

    /**
     * Converts this CatalogQuickAmountsSettings into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogQuickAmountsSettings [" + "option=" + option + ", eligibleForAutoAmounts="
                + eligibleForAutoAmounts + ", amounts=" + amounts + "]";
    }

    /**
     * Builds a new {@link CatalogQuickAmountsSettings.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQuickAmountsSettings.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(option);
        builder.eligibleForAutoAmounts = internalGetEligibleForAutoAmounts();
        builder.amounts = internalGetAmounts();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogQuickAmountsSettings}.
     */
    public static class Builder {
        private String option;
        private OptionalNullable<Boolean> eligibleForAutoAmounts;
        private OptionalNullable<List<CatalogQuickAmount>> amounts;

        /**
         * Initialization constructor.
         * @param  option  String value for option.
         */
        public Builder(String option) {
            this.option = option;
        }

        /**
         * Setter for option.
         * @param  option  String value for option.
         * @return Builder
         */
        public Builder option(String option) {
            this.option = option;
            return this;
        }

        /**
         * Setter for eligibleForAutoAmounts.
         * @param  eligibleForAutoAmounts  Boolean value for eligibleForAutoAmounts.
         * @return Builder
         */
        public Builder eligibleForAutoAmounts(Boolean eligibleForAutoAmounts) {
            this.eligibleForAutoAmounts = OptionalNullable.of(eligibleForAutoAmounts);
            return this;
        }

        /**
         * UnSetter for eligibleForAutoAmounts.
         * @return Builder
         */
        public Builder unsetEligibleForAutoAmounts() {
            eligibleForAutoAmounts = null;
            return this;
        }

        /**
         * Setter for amounts.
         * @param  amounts  List of CatalogQuickAmount value for amounts.
         * @return Builder
         */
        public Builder amounts(List<CatalogQuickAmount> amounts) {
            this.amounts = OptionalNullable.of(amounts);
            return this;
        }

        /**
         * UnSetter for amounts.
         * @return Builder
         */
        public Builder unsetAmounts() {
            amounts = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogQuickAmountsSettings} object using the set fields.
         * @return {@link CatalogQuickAmountsSettings}
         */
        public CatalogQuickAmountsSettings build() {
            return new CatalogQuickAmountsSettings(option, eligibleForAutoAmounts, amounts);
        }
    }
}

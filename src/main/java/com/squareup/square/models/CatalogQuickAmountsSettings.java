package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQuickAmountsSettings type.
 */
public class CatalogQuickAmountsSettings {

    /**
     * Initialization constructor.
     * @param option
     * @param eligibleForAutoAmounts
     * @param amounts
     */
    @JsonCreator
    public CatalogQuickAmountsSettings(
            @JsonProperty("option") String option,
            @JsonProperty("eligible_for_auto_amounts") Boolean eligibleForAutoAmounts,
            @JsonProperty("amounts") List<CatalogQuickAmount> amounts) {
        this.option = option;
        this.eligibleForAutoAmounts = eligibleForAutoAmounts;
        this.amounts = amounts;
    }

    private final String option;
    private final Boolean eligibleForAutoAmounts;
    private final List<CatalogQuickAmount> amounts;
    /**
     * Getter for Option.
     * Determines a seller's option on Quick Amounts feature.
     */
    @JsonGetter("option")
    public String getOption() {
        return this.option;
    }

    /**
     * Getter for EligibleForAutoAmounts.
     * Represents location's eligibility for auto amounts
     * The boolean should be consistent with whether there are AUTO amounts in the `amounts`.
     */
    @JsonGetter("eligible_for_auto_amounts")
    public Boolean getEligibleForAutoAmounts() {
        return this.eligibleForAutoAmounts;
    }

    /**
     * Getter for Amounts.
     * Represents a set of Quick Amounts at this location.
     */
    @JsonGetter("amounts")
    public List<CatalogQuickAmount> getAmounts() {
        return this.amounts;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(option, eligibleForAutoAmounts, amounts);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQuickAmountsSettings)) {
            return false;
        }
        CatalogQuickAmountsSettings catalogQuickAmountsSettings = (CatalogQuickAmountsSettings) obj;
        return Objects.equals(option, catalogQuickAmountsSettings.option) &&
            Objects.equals(eligibleForAutoAmounts, catalogQuickAmountsSettings.eligibleForAutoAmounts) &&
            Objects.equals(amounts, catalogQuickAmountsSettings.amounts);
    }

    /**
     * Builds a new {@link CatalogQuickAmountsSettings.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQuickAmountsSettings.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(option)
            .eligibleForAutoAmounts(getEligibleForAutoAmounts())
            .amounts(getAmounts());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQuickAmountsSettings}
     */
    public static class Builder {
        private String option;
        private Boolean eligibleForAutoAmounts;
        private List<CatalogQuickAmount> amounts;

        /**
         * Initialization constructor
         */
        public Builder(String option) {
            this.option = option;
        }

        /**
         * Setter for option
         * @param option
         * @return Builder
         */
        public Builder option(String option) {
            this.option = option;
            return this;
        }
        /**
         * Setter for eligibleForAutoAmounts
         * @param eligibleForAutoAmounts
         * @return Builder
         */
        public Builder eligibleForAutoAmounts(Boolean eligibleForAutoAmounts) {
            this.eligibleForAutoAmounts = eligibleForAutoAmounts;
            return this;
        }
        /**
         * Setter for amounts
         * @param amounts
         * @return Builder
         */
        public Builder amounts(List<CatalogQuickAmount> amounts) {
            this.amounts = amounts;
            return this;
        }

        /**
         * Builds a new {@link CatalogQuickAmountsSettings} object using the set fields.
         * @return {@link CatalogQuickAmountsSettings}
         */
        public CatalogQuickAmountsSettings build() {
            return new CatalogQuickAmountsSettings(option,
                eligibleForAutoAmounts,
                amounts);
        }
    }
}

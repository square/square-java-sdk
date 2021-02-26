
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderPricingOptions type.
 */
public class OrderPricingOptions {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean autoApplyDiscounts;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean autoApplyTaxes;

    /**
     * Initialization constructor.
     * @param  autoApplyDiscounts  Boolean value for autoApplyDiscounts.
     * @param  autoApplyTaxes  Boolean value for autoApplyTaxes.
     */
    @JsonCreator
    public OrderPricingOptions(
            @JsonProperty("auto_apply_discounts") Boolean autoApplyDiscounts,
            @JsonProperty("auto_apply_taxes") Boolean autoApplyTaxes) {
        this.autoApplyDiscounts = autoApplyDiscounts;
        this.autoApplyTaxes = autoApplyTaxes;
    }

    /**
     * Getter for AutoApplyDiscounts.
     * The option to determine whether pricing rule-based discounts are automatically applied to an
     * order.
     * @return Returns the Boolean
     */
    @JsonGetter("auto_apply_discounts")
    public Boolean getAutoApplyDiscounts() {
        return autoApplyDiscounts;
    }

    /**
     * Getter for AutoApplyTaxes.
     * The option to determine whether rule-based taxes are automatically applied to an order when
     * the criteria of the corresponding rules are met.
     * @return Returns the Boolean
     */
    @JsonGetter("auto_apply_taxes")
    public Boolean getAutoApplyTaxes() {
        return autoApplyTaxes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoApplyDiscounts, autoApplyTaxes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderPricingOptions)) {
            return false;
        }
        OrderPricingOptions other = (OrderPricingOptions) obj;
        return Objects.equals(autoApplyDiscounts, other.autoApplyDiscounts)
            && Objects.equals(autoApplyTaxes, other.autoApplyTaxes);
    }

    /**
     * Converts this OrderPricingOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderPricingOptions [" + "autoApplyDiscounts=" + autoApplyDiscounts
                + ", autoApplyTaxes=" + autoApplyTaxes + "]";
    }

    /**
     * Builds a new {@link OrderPricingOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderPricingOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .autoApplyDiscounts(getAutoApplyDiscounts())
                .autoApplyTaxes(getAutoApplyTaxes());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderPricingOptions}.
     */
    public static class Builder {
        private Boolean autoApplyDiscounts;
        private Boolean autoApplyTaxes;



        /**
         * Setter for autoApplyDiscounts.
         * @param  autoApplyDiscounts  Boolean value for autoApplyDiscounts.
         * @return Builder
         */
        public Builder autoApplyDiscounts(Boolean autoApplyDiscounts) {
            this.autoApplyDiscounts = autoApplyDiscounts;
            return this;
        }

        /**
         * Setter for autoApplyTaxes.
         * @param  autoApplyTaxes  Boolean value for autoApplyTaxes.
         * @return Builder
         */
        public Builder autoApplyTaxes(Boolean autoApplyTaxes) {
            this.autoApplyTaxes = autoApplyTaxes;
            return this;
        }

        /**
         * Builds a new {@link OrderPricingOptions} object using the set fields.
         * @return {@link OrderPricingOptions}
         */
        public OrderPricingOptions build() {
            return new OrderPricingOptions(autoApplyDiscounts, autoApplyTaxes);
        }
    }
}

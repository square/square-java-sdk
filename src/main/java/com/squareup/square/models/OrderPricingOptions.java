
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for OrderPricingOptions type.
 */
public class OrderPricingOptions {
    private final Boolean autoApplyDiscounts;

    /**
     * Initialization constructor.
     * @param autoApplyDiscounts Boolean value for autoApplyDiscounts.
     */
    @JsonCreator
    public OrderPricingOptions(
            @JsonProperty("auto_apply_discounts") Boolean autoApplyDiscounts) {
        this.autoApplyDiscounts = autoApplyDiscounts;
    }

    /**
     * Getter for AutoApplyDiscounts.
     * The option to determine whether or not pricing rule-based discounts are automatically applied
     * to an order.
     * @return Returns the Boolean
     */
    @JsonGetter("auto_apply_discounts")
    public Boolean getAutoApplyDiscounts() {
        return this.autoApplyDiscounts;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(autoApplyDiscounts);
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
        return Objects.equals(autoApplyDiscounts, other.autoApplyDiscounts);
    }

    /**
     * Builds a new {@link OrderPricingOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderPricingOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .autoApplyDiscounts(getAutoApplyDiscounts());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderPricingOptions}.
     */
    public static class Builder {
        private Boolean autoApplyDiscounts;



        /**
         * Setter for autoApplyDiscounts.
         * @param autoApplyDiscounts Boolean value for autoApplyDiscounts.
         * @return Builder
         */
        public Builder autoApplyDiscounts(Boolean autoApplyDiscounts) {
            this.autoApplyDiscounts = autoApplyDiscounts;
            return this;
        }

        /**
         * Builds a new {@link OrderPricingOptions} object using the set fields.
         * @return {@link OrderPricingOptions}
         */
        public OrderPricingOptions build() {
            return new OrderPricingOptions(autoApplyDiscounts);
        }
    }
}

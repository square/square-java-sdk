package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderPricingOptions type.
 */
public class OrderPricingOptions {

    /**
     * Initialization constructor.
     * @param autoApplyDiscounts
     */
    @JsonCreator
    public OrderPricingOptions(
            @JsonProperty("auto_apply_discounts") Boolean autoApplyDiscounts) {
        this.autoApplyDiscounts = autoApplyDiscounts;
    }

    private final Boolean autoApplyDiscounts;
    /**
     * Getter for AutoApplyDiscounts.
     * The option to determine whether or not pricing rule-based discounts are automatically applied to an order.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderPricingOptions)) {
            return false;
        }
        OrderPricingOptions orderPricingOptions = (OrderPricingOptions) obj;
        return Objects.equals(autoApplyDiscounts, orderPricingOptions.autoApplyDiscounts);
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
     * Class to build instances of {@link OrderPricingOptions}
     */
    public static class Builder {
        private Boolean autoApplyDiscounts;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for autoApplyDiscounts
         * @param autoApplyDiscounts
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

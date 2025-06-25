package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderPricingOptions type.
 */
public class OrderPricingOptions {
    private final OptionalNullable<Boolean> autoApplyDiscounts;
    private final OptionalNullable<Boolean> autoApplyTaxes;

    /**
     * Initialization constructor.
     * @param  autoApplyDiscounts  Boolean value for autoApplyDiscounts.
     * @param  autoApplyTaxes  Boolean value for autoApplyTaxes.
     */
    @JsonCreator
    public OrderPricingOptions(
            @JsonProperty("auto_apply_discounts") Boolean autoApplyDiscounts,
            @JsonProperty("auto_apply_taxes") Boolean autoApplyTaxes) {
        this.autoApplyDiscounts = OptionalNullable.of(autoApplyDiscounts);
        this.autoApplyTaxes = OptionalNullable.of(autoApplyTaxes);
    }

    /**
     * Initialization constructor.
     * @param  autoApplyDiscounts  Boolean value for autoApplyDiscounts.
     * @param  autoApplyTaxes  Boolean value for autoApplyTaxes.
     */
    protected OrderPricingOptions(
            OptionalNullable<Boolean> autoApplyDiscounts, OptionalNullable<Boolean> autoApplyTaxes) {
        this.autoApplyDiscounts = autoApplyDiscounts;
        this.autoApplyTaxes = autoApplyTaxes;
    }

    /**
     * Internal Getter for AutoApplyDiscounts.
     * The option to determine whether pricing rule-based discounts are automatically applied to an
     * order.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("auto_apply_discounts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAutoApplyDiscounts() {
        return this.autoApplyDiscounts;
    }

    /**
     * Getter for AutoApplyDiscounts.
     * The option to determine whether pricing rule-based discounts are automatically applied to an
     * order.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAutoApplyDiscounts() {
        return OptionalNullable.getFrom(autoApplyDiscounts);
    }

    /**
     * Internal Getter for AutoApplyTaxes.
     * The option to determine whether rule-based taxes are automatically applied to an order when
     * the criteria of the corresponding rules are met.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("auto_apply_taxes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAutoApplyTaxes() {
        return this.autoApplyTaxes;
    }

    /**
     * Getter for AutoApplyTaxes.
     * The option to determine whether rule-based taxes are automatically applied to an order when
     * the criteria of the corresponding rules are met.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAutoApplyTaxes() {
        return OptionalNullable.getFrom(autoApplyTaxes);
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
        return "OrderPricingOptions [" + "autoApplyDiscounts=" + autoApplyDiscounts + ", autoApplyTaxes="
                + autoApplyTaxes + "]";
    }

    /**
     * Builds a new {@link OrderPricingOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderPricingOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.autoApplyDiscounts = internalGetAutoApplyDiscounts();
        builder.autoApplyTaxes = internalGetAutoApplyTaxes();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderPricingOptions}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> autoApplyDiscounts;
        private OptionalNullable<Boolean> autoApplyTaxes;

        /**
         * Setter for autoApplyDiscounts.
         * @param  autoApplyDiscounts  Boolean value for autoApplyDiscounts.
         * @return Builder
         */
        public Builder autoApplyDiscounts(Boolean autoApplyDiscounts) {
            this.autoApplyDiscounts = OptionalNullable.of(autoApplyDiscounts);
            return this;
        }

        /**
         * UnSetter for autoApplyDiscounts.
         * @return Builder
         */
        public Builder unsetAutoApplyDiscounts() {
            autoApplyDiscounts = null;
            return this;
        }

        /**
         * Setter for autoApplyTaxes.
         * @param  autoApplyTaxes  Boolean value for autoApplyTaxes.
         * @return Builder
         */
        public Builder autoApplyTaxes(Boolean autoApplyTaxes) {
            this.autoApplyTaxes = OptionalNullable.of(autoApplyTaxes);
            return this;
        }

        /**
         * UnSetter for autoApplyTaxes.
         * @return Builder
         */
        public Builder unsetAutoApplyTaxes() {
            autoApplyTaxes = null;
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

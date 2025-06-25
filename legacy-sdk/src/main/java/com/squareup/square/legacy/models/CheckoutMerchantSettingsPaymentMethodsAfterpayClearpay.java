package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay type.
 */
public class CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay {
    private final CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange orderEligibilityRange;
    private final CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange itemEligibilityRange;
    private final Boolean enabled;

    /**
     * Initialization constructor.
     * @param  orderEligibilityRange
     *         CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange value for
     *         orderEligibilityRange.
     * @param  itemEligibilityRange
     *         CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange value for
     *         itemEligibilityRange.
     * @param  enabled  Boolean value for enabled.
     */
    @JsonCreator
    public CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay(
            @JsonProperty("order_eligibility_range")
                    CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange orderEligibilityRange,
            @JsonProperty("item_eligibility_range")
                    CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange itemEligibilityRange,
            @JsonProperty("enabled") Boolean enabled) {
        this.orderEligibilityRange = orderEligibilityRange;
        this.itemEligibilityRange = itemEligibilityRange;
        this.enabled = enabled;
    }

    /**
     * Getter for OrderEligibilityRange.
     * A range of purchase price that qualifies.
     * @return Returns the CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange
     */
    @JsonGetter("order_eligibility_range")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange getOrderEligibilityRange() {
        return orderEligibilityRange;
    }

    /**
     * Getter for ItemEligibilityRange.
     * A range of purchase price that qualifies.
     * @return Returns the CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange
     */
    @JsonGetter("item_eligibility_range")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange getItemEligibilityRange() {
        return itemEligibilityRange;
    }

    /**
     * Getter for Enabled.
     * Indicates whether the payment method is enabled for the account.
     * @return Returns the Boolean
     */
    @JsonGetter("enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getEnabled() {
        return enabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderEligibilityRange, itemEligibilityRange, enabled);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay)) {
            return false;
        }
        CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay other =
                (CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay) obj;
        return Objects.equals(orderEligibilityRange, other.orderEligibilityRange)
                && Objects.equals(itemEligibilityRange, other.itemEligibilityRange)
                && Objects.equals(enabled, other.enabled);
    }

    /**
     * Converts this CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay [" + "orderEligibilityRange="
                + orderEligibilityRange + ", itemEligibilityRange=" + itemEligibilityRange
                + ", enabled=" + enabled + "]";
    }

    /**
     * Builds a new {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .orderEligibilityRange(getOrderEligibilityRange())
                .itemEligibilityRange(getItemEligibilityRange())
                .enabled(getEnabled());
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay}.
     */
    public static class Builder {
        private CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange orderEligibilityRange;
        private CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange itemEligibilityRange;
        private Boolean enabled;

        /**
         * Setter for orderEligibilityRange.
         * @param  orderEligibilityRange
         *         CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange value for
         *         orderEligibilityRange.
         * @return Builder
         */
        public Builder orderEligibilityRange(
                CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange orderEligibilityRange) {
            this.orderEligibilityRange = orderEligibilityRange;
            return this;
        }

        /**
         * Setter for itemEligibilityRange.
         * @param  itemEligibilityRange
         *         CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange value for
         *         itemEligibilityRange.
         * @return Builder
         */
        public Builder itemEligibilityRange(
                CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange itemEligibilityRange) {
            this.itemEligibilityRange = itemEligibilityRange;
            return this;
        }

        /**
         * Setter for enabled.
         * @param  enabled  Boolean value for enabled.
         * @return Builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Builds a new {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay} object using
         * the set fields.
         * @return {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay}
         */
        public CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay build() {
            return new CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay(
                    orderEligibilityRange, itemEligibilityRange, enabled);
        }
    }
}

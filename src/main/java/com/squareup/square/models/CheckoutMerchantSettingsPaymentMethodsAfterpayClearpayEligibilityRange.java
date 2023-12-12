
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange type.
 */
public class CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange {
    private final Money min;
    private final Money max;

    /**
     * Initialization constructor.
     * @param  min  Money value for min.
     * @param  max  Money value for max.
     */
    @JsonCreator
    public CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange(
            @JsonProperty("min") Money min,
            @JsonProperty("max") Money max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Getter for Min.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("min")
    public Money getMin() {
        return min;
    }

    /**
     * Getter for Max.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("max")
    public Money getMax() {
        return max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange)) {
            return false;
        }
        CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange other =
                (CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange) obj;
        return Objects.equals(min, other.min)
            && Objects.equals(max, other.max);
    }

    /**
     * Converts this CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange [" + "min="
                + min + ", max=" + max + "]";
    }

    /**
     * Builds a new {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(min, max);
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange}.
     */
    public static class Builder {
        private Money min;
        private Money max;

        /**
         * Initialization constructor.
         * @param  min  Money value for min.
         * @param  max  Money value for max.
         */
        public Builder(Money min, Money max) {
            this.min = min;
            this.max = max;
        }

        /**
         * Setter for min.
         * @param  min  Money value for min.
         * @return Builder
         */
        public Builder min(Money min) {
            this.min = min;
            return this;
        }

        /**
         * Setter for max.
         * @param  max  Money value for max.
         * @return Builder
         */
        public Builder max(Money max) {
            this.max = max;
            return this;
        }

        /**
         * Builds a new {@link
         * CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange} object using the
         * set fields.
         * @return {@link CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange}
         */
        public CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange build() {
            return new CheckoutMerchantSettingsPaymentMethodsAfterpayClearpayEligibilityRange(min,
                    max);
        }
    }
}

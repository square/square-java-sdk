
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CheckoutMerchantSettingsPaymentMethodsPaymentMethod type.
 */
public class CheckoutMerchantSettingsPaymentMethodsPaymentMethod {
    private final OptionalNullable<Boolean> enabled;

    /**
     * Initialization constructor.
     * @param  enabled  Boolean value for enabled.
     */
    @JsonCreator
    public CheckoutMerchantSettingsPaymentMethodsPaymentMethod(
            @JsonProperty("enabled") Boolean enabled) {
        this.enabled = OptionalNullable.of(enabled);
    }

    /**
     * Initialization constructor.
     * @param  enabled  Boolean value for enabled.
     */

    protected CheckoutMerchantSettingsPaymentMethodsPaymentMethod(
            OptionalNullable<Boolean> enabled) {
        this.enabled = enabled;
    }

    /**
     * Internal Getter for Enabled.
     * Indicates whether the payment method is enabled for the account.
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
     * Indicates whether the payment method is enabled for the account.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getEnabled() {
        return OptionalNullable.getFrom(enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutMerchantSettingsPaymentMethodsPaymentMethod)) {
            return false;
        }
        CheckoutMerchantSettingsPaymentMethodsPaymentMethod other =
                (CheckoutMerchantSettingsPaymentMethodsPaymentMethod) obj;
        return Objects.equals(enabled, other.enabled);
    }

    /**
     * Converts this CheckoutMerchantSettingsPaymentMethodsPaymentMethod into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutMerchantSettingsPaymentMethodsPaymentMethod [" + "enabled=" + enabled + "]";
    }

    /**
     * Builds a new {@link CheckoutMerchantSettingsPaymentMethodsPaymentMethod.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutMerchantSettingsPaymentMethodsPaymentMethod.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.enabled = internalGetEnabled();
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutMerchantSettingsPaymentMethodsPaymentMethod}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> enabled;



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
         * Builds a new {@link CheckoutMerchantSettingsPaymentMethodsPaymentMethod} object using the
         * set fields.
         * @return {@link CheckoutMerchantSettingsPaymentMethodsPaymentMethod}
         */
        public CheckoutMerchantSettingsPaymentMethodsPaymentMethod build() {
            return new CheckoutMerchantSettingsPaymentMethodsPaymentMethod(enabled);
        }
    }
}

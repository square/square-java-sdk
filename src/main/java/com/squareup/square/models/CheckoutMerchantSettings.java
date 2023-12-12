
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CheckoutMerchantSettings type.
 */
public class CheckoutMerchantSettings {
    private final CheckoutMerchantSettingsPaymentMethods paymentMethods;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  paymentMethods  CheckoutMerchantSettingsPaymentMethods value for paymentMethods.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public CheckoutMerchantSettings(
            @JsonProperty("payment_methods") CheckoutMerchantSettingsPaymentMethods paymentMethods,
            @JsonProperty("updated_at") String updatedAt) {
        this.paymentMethods = paymentMethods;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for PaymentMethods.
     * @return Returns the CheckoutMerchantSettingsPaymentMethods
     */
    @JsonGetter("payment_methods")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutMerchantSettingsPaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the settings were last updated, in RFC 3339 format. Examples for January
     * 25th, 2020 6:25:34pm Pacific Standard Time: UTC: 2020-01-26T02:25:34Z Pacific Standard Time
     * with UTC offset: 2020-01-25T18:25:34-08:00
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethods, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutMerchantSettings)) {
            return false;
        }
        CheckoutMerchantSettings other = (CheckoutMerchantSettings) obj;
        return Objects.equals(paymentMethods, other.paymentMethods)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this CheckoutMerchantSettings into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutMerchantSettings [" + "paymentMethods=" + paymentMethods + ", updatedAt="
                + updatedAt + "]";
    }

    /**
     * Builds a new {@link CheckoutMerchantSettings.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutMerchantSettings.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .paymentMethods(getPaymentMethods())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutMerchantSettings}.
     */
    public static class Builder {
        private CheckoutMerchantSettingsPaymentMethods paymentMethods;
        private String updatedAt;



        /**
         * Setter for paymentMethods.
         * @param  paymentMethods  CheckoutMerchantSettingsPaymentMethods value for paymentMethods.
         * @return Builder
         */
        public Builder paymentMethods(CheckoutMerchantSettingsPaymentMethods paymentMethods) {
            this.paymentMethods = paymentMethods;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link CheckoutMerchantSettings} object using the set fields.
         * @return {@link CheckoutMerchantSettings}
         */
        public CheckoutMerchantSettings build() {
            return new CheckoutMerchantSettings(paymentMethods, updatedAt);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CheckoutMerchantSettingsPaymentMethods type.
 */
public class CheckoutMerchantSettingsPaymentMethods {
    private final CheckoutMerchantSettingsPaymentMethodsPaymentMethod applePay;
    private final CheckoutMerchantSettingsPaymentMethodsPaymentMethod googlePay;
    private final CheckoutMerchantSettingsPaymentMethodsPaymentMethod cashApp;
    private final CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay afterpayClearpay;

    /**
     * Initialization constructor.
     * @param  applePay  CheckoutMerchantSettingsPaymentMethodsPaymentMethod value for applePay.
     * @param  googlePay  CheckoutMerchantSettingsPaymentMethodsPaymentMethod value for googlePay.
     * @param  cashApp  CheckoutMerchantSettingsPaymentMethodsPaymentMethod value for cashApp.
     * @param  afterpayClearpay  CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay value for
     *         afterpayClearpay.
     */
    @JsonCreator
    public CheckoutMerchantSettingsPaymentMethods(
            @JsonProperty("apple_pay") CheckoutMerchantSettingsPaymentMethodsPaymentMethod applePay,
            @JsonProperty("google_pay") CheckoutMerchantSettingsPaymentMethodsPaymentMethod googlePay,
            @JsonProperty("cash_app") CheckoutMerchantSettingsPaymentMethodsPaymentMethod cashApp,
            @JsonProperty("afterpay_clearpay") CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay afterpayClearpay) {
        this.applePay = applePay;
        this.googlePay = googlePay;
        this.cashApp = cashApp;
        this.afterpayClearpay = afterpayClearpay;
    }

    /**
     * Getter for ApplePay.
     * The settings allowed for a payment method.
     * @return Returns the CheckoutMerchantSettingsPaymentMethodsPaymentMethod
     */
    @JsonGetter("apple_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutMerchantSettingsPaymentMethodsPaymentMethod getApplePay() {
        return applePay;
    }

    /**
     * Getter for GooglePay.
     * The settings allowed for a payment method.
     * @return Returns the CheckoutMerchantSettingsPaymentMethodsPaymentMethod
     */
    @JsonGetter("google_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutMerchantSettingsPaymentMethodsPaymentMethod getGooglePay() {
        return googlePay;
    }

    /**
     * Getter for CashApp.
     * The settings allowed for a payment method.
     * @return Returns the CheckoutMerchantSettingsPaymentMethodsPaymentMethod
     */
    @JsonGetter("cash_app")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutMerchantSettingsPaymentMethodsPaymentMethod getCashApp() {
        return cashApp;
    }

    /**
     * Getter for AfterpayClearpay.
     * The settings allowed for AfterpayClearpay.
     * @return Returns the CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay
     */
    @JsonGetter("afterpay_clearpay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay getAfterpayClearpay() {
        return afterpayClearpay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(applePay, googlePay, cashApp, afterpayClearpay);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutMerchantSettingsPaymentMethods)) {
            return false;
        }
        CheckoutMerchantSettingsPaymentMethods other = (CheckoutMerchantSettingsPaymentMethods) obj;
        return Objects.equals(applePay, other.applePay)
            && Objects.equals(googlePay, other.googlePay)
            && Objects.equals(cashApp, other.cashApp)
            && Objects.equals(afterpayClearpay, other.afterpayClearpay);
    }

    /**
     * Converts this CheckoutMerchantSettingsPaymentMethods into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutMerchantSettingsPaymentMethods [" + "applePay=" + applePay + ", googlePay="
                + googlePay + ", cashApp=" + cashApp + ", afterpayClearpay=" + afterpayClearpay
                + "]";
    }

    /**
     * Builds a new {@link CheckoutMerchantSettingsPaymentMethods.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutMerchantSettingsPaymentMethods.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .applePay(getApplePay())
                .googlePay(getGooglePay())
                .cashApp(getCashApp())
                .afterpayClearpay(getAfterpayClearpay());
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutMerchantSettingsPaymentMethods}.
     */
    public static class Builder {
        private CheckoutMerchantSettingsPaymentMethodsPaymentMethod applePay;
        private CheckoutMerchantSettingsPaymentMethodsPaymentMethod googlePay;
        private CheckoutMerchantSettingsPaymentMethodsPaymentMethod cashApp;
        private CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay afterpayClearpay;



        /**
         * Setter for applePay.
         * @param  applePay  CheckoutMerchantSettingsPaymentMethodsPaymentMethod value for applePay.
         * @return Builder
         */
        public Builder applePay(CheckoutMerchantSettingsPaymentMethodsPaymentMethod applePay) {
            this.applePay = applePay;
            return this;
        }

        /**
         * Setter for googlePay.
         * @param  googlePay  CheckoutMerchantSettingsPaymentMethodsPaymentMethod value for
         *         googlePay.
         * @return Builder
         */
        public Builder googlePay(CheckoutMerchantSettingsPaymentMethodsPaymentMethod googlePay) {
            this.googlePay = googlePay;
            return this;
        }

        /**
         * Setter for cashApp.
         * @param  cashApp  CheckoutMerchantSettingsPaymentMethodsPaymentMethod value for cashApp.
         * @return Builder
         */
        public Builder cashApp(CheckoutMerchantSettingsPaymentMethodsPaymentMethod cashApp) {
            this.cashApp = cashApp;
            return this;
        }

        /**
         * Setter for afterpayClearpay.
         * @param  afterpayClearpay  CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay value
         *         for afterpayClearpay.
         * @return Builder
         */
        public Builder afterpayClearpay(
                CheckoutMerchantSettingsPaymentMethodsAfterpayClearpay afterpayClearpay) {
            this.afterpayClearpay = afterpayClearpay;
            return this;
        }

        /**
         * Builds a new {@link CheckoutMerchantSettingsPaymentMethods} object using the set fields.
         * @return {@link CheckoutMerchantSettingsPaymentMethods}
         */
        public CheckoutMerchantSettingsPaymentMethods build() {
            return new CheckoutMerchantSettingsPaymentMethods(applePay, googlePay, cashApp,
                    afterpayClearpay);
        }
    }
}

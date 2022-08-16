
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for AcceptedPaymentMethods type.
 */
public class AcceptedPaymentMethods {
    private final Boolean applePay;
    private final Boolean googlePay;
    private final Boolean cashAppPay;
    private final Boolean afterpayClearpay;

    /**
     * Initialization constructor.
     * @param  applePay  Boolean value for applePay.
     * @param  googlePay  Boolean value for googlePay.
     * @param  cashAppPay  Boolean value for cashAppPay.
     * @param  afterpayClearpay  Boolean value for afterpayClearpay.
     */
    @JsonCreator
    public AcceptedPaymentMethods(
            @JsonProperty("apple_pay") Boolean applePay,
            @JsonProperty("google_pay") Boolean googlePay,
            @JsonProperty("cash_app_pay") Boolean cashAppPay,
            @JsonProperty("afterpay_clearpay") Boolean afterpayClearpay) {
        this.applePay = applePay;
        this.googlePay = googlePay;
        this.cashAppPay = cashAppPay;
        this.afterpayClearpay = afterpayClearpay;
    }

    /**
     * Getter for ApplePay.
     * Whether Apple Pay is accepted at checkout.
     * @return Returns the Boolean
     */
    @JsonGetter("apple_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getApplePay() {
        return applePay;
    }

    /**
     * Getter for GooglePay.
     * Whether Google Pay is accepted at checkout.
     * @return Returns the Boolean
     */
    @JsonGetter("google_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getGooglePay() {
        return googlePay;
    }

    /**
     * Getter for CashAppPay.
     * Whether Cash App Pay is accepted at checkout.
     * @return Returns the Boolean
     */
    @JsonGetter("cash_app_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getCashAppPay() {
        return cashAppPay;
    }

    /**
     * Getter for AfterpayClearpay.
     * Whether Afterpay/Clearpay is accepted at checkout.
     * @return Returns the Boolean
     */
    @JsonGetter("afterpay_clearpay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAfterpayClearpay() {
        return afterpayClearpay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(applePay, googlePay, cashAppPay, afterpayClearpay);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AcceptedPaymentMethods)) {
            return false;
        }
        AcceptedPaymentMethods other = (AcceptedPaymentMethods) obj;
        return Objects.equals(applePay, other.applePay)
            && Objects.equals(googlePay, other.googlePay)
            && Objects.equals(cashAppPay, other.cashAppPay)
            && Objects.equals(afterpayClearpay, other.afterpayClearpay);
    }

    /**
     * Converts this AcceptedPaymentMethods into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AcceptedPaymentMethods [" + "applePay=" + applePay + ", googlePay=" + googlePay
                + ", cashAppPay=" + cashAppPay + ", afterpayClearpay=" + afterpayClearpay + "]";
    }

    /**
     * Builds a new {@link AcceptedPaymentMethods.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AcceptedPaymentMethods.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .applePay(getApplePay())
                .googlePay(getGooglePay())
                .cashAppPay(getCashAppPay())
                .afterpayClearpay(getAfterpayClearpay());
        return builder;
    }

    /**
     * Class to build instances of {@link AcceptedPaymentMethods}.
     */
    public static class Builder {
        private Boolean applePay;
        private Boolean googlePay;
        private Boolean cashAppPay;
        private Boolean afterpayClearpay;



        /**
         * Setter for applePay.
         * @param  applePay  Boolean value for applePay.
         * @return Builder
         */
        public Builder applePay(Boolean applePay) {
            this.applePay = applePay;
            return this;
        }

        /**
         * Setter for googlePay.
         * @param  googlePay  Boolean value for googlePay.
         * @return Builder
         */
        public Builder googlePay(Boolean googlePay) {
            this.googlePay = googlePay;
            return this;
        }

        /**
         * Setter for cashAppPay.
         * @param  cashAppPay  Boolean value for cashAppPay.
         * @return Builder
         */
        public Builder cashAppPay(Boolean cashAppPay) {
            this.cashAppPay = cashAppPay;
            return this;
        }

        /**
         * Setter for afterpayClearpay.
         * @param  afterpayClearpay  Boolean value for afterpayClearpay.
         * @return Builder
         */
        public Builder afterpayClearpay(Boolean afterpayClearpay) {
            this.afterpayClearpay = afterpayClearpay;
            return this;
        }

        /**
         * Builds a new {@link AcceptedPaymentMethods} object using the set fields.
         * @return {@link AcceptedPaymentMethods}
         */
        public AcceptedPaymentMethods build() {
            return new AcceptedPaymentMethods(applePay, googlePay, cashAppPay, afterpayClearpay);
        }
    }
}

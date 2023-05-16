
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
 * This is a model class for AcceptedPaymentMethods type.
 */
public class AcceptedPaymentMethods {
    private final OptionalNullable<Boolean> applePay;
    private final OptionalNullable<Boolean> googlePay;
    private final OptionalNullable<Boolean> cashAppPay;
    private final OptionalNullable<Boolean> afterpayClearpay;

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
        this.applePay = OptionalNullable.of(applePay);
        this.googlePay = OptionalNullable.of(googlePay);
        this.cashAppPay = OptionalNullable.of(cashAppPay);
        this.afterpayClearpay = OptionalNullable.of(afterpayClearpay);
    }

    /**
     * Internal initialization constructor.
     */
    protected AcceptedPaymentMethods(OptionalNullable<Boolean> applePay,
            OptionalNullable<Boolean> googlePay, OptionalNullable<Boolean> cashAppPay,
            OptionalNullable<Boolean> afterpayClearpay) {
        this.applePay = applePay;
        this.googlePay = googlePay;
        this.cashAppPay = cashAppPay;
        this.afterpayClearpay = afterpayClearpay;
    }

    /**
     * Internal Getter for ApplePay.
     * Whether Apple Pay is accepted at checkout.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("apple_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetApplePay() {
        return this.applePay;
    }

    /**
     * Getter for ApplePay.
     * Whether Apple Pay is accepted at checkout.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getApplePay() {
        return OptionalNullable.getFrom(applePay);
    }

    /**
     * Internal Getter for GooglePay.
     * Whether Google Pay is accepted at checkout.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("google_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetGooglePay() {
        return this.googlePay;
    }

    /**
     * Getter for GooglePay.
     * Whether Google Pay is accepted at checkout.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getGooglePay() {
        return OptionalNullable.getFrom(googlePay);
    }

    /**
     * Internal Getter for CashAppPay.
     * Whether Cash App Pay is accepted at checkout.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("cash_app_pay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetCashAppPay() {
        return this.cashAppPay;
    }

    /**
     * Getter for CashAppPay.
     * Whether Cash App Pay is accepted at checkout.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getCashAppPay() {
        return OptionalNullable.getFrom(cashAppPay);
    }

    /**
     * Internal Getter for AfterpayClearpay.
     * Whether Afterpay/Clearpay is accepted at checkout.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("afterpay_clearpay")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAfterpayClearpay() {
        return this.afterpayClearpay;
    }

    /**
     * Getter for AfterpayClearpay.
     * Whether Afterpay/Clearpay is accepted at checkout.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAfterpayClearpay() {
        return OptionalNullable.getFrom(afterpayClearpay);
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
        Builder builder = new Builder();
        builder.applePay = internalGetApplePay();
        builder.googlePay = internalGetGooglePay();
        builder.cashAppPay = internalGetCashAppPay();
        builder.afterpayClearpay = internalGetAfterpayClearpay();
        return builder;
    }

    /**
     * Class to build instances of {@link AcceptedPaymentMethods}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> applePay;
        private OptionalNullable<Boolean> googlePay;
        private OptionalNullable<Boolean> cashAppPay;
        private OptionalNullable<Boolean> afterpayClearpay;



        /**
         * Setter for applePay.
         * @param  applePay  Boolean value for applePay.
         * @return Builder
         */
        public Builder applePay(Boolean applePay) {
            this.applePay = OptionalNullable.of(applePay);
            return this;
        }

        /**
         * UnSetter for applePay.
         * @return Builder
         */
        public Builder unsetApplePay() {
            applePay = null;
            return this;
        }

        /**
         * Setter for googlePay.
         * @param  googlePay  Boolean value for googlePay.
         * @return Builder
         */
        public Builder googlePay(Boolean googlePay) {
            this.googlePay = OptionalNullable.of(googlePay);
            return this;
        }

        /**
         * UnSetter for googlePay.
         * @return Builder
         */
        public Builder unsetGooglePay() {
            googlePay = null;
            return this;
        }

        /**
         * Setter for cashAppPay.
         * @param  cashAppPay  Boolean value for cashAppPay.
         * @return Builder
         */
        public Builder cashAppPay(Boolean cashAppPay) {
            this.cashAppPay = OptionalNullable.of(cashAppPay);
            return this;
        }

        /**
         * UnSetter for cashAppPay.
         * @return Builder
         */
        public Builder unsetCashAppPay() {
            cashAppPay = null;
            return this;
        }

        /**
         * Setter for afterpayClearpay.
         * @param  afterpayClearpay  Boolean value for afterpayClearpay.
         * @return Builder
         */
        public Builder afterpayClearpay(Boolean afterpayClearpay) {
            this.afterpayClearpay = OptionalNullable.of(afterpayClearpay);
            return this;
        }

        /**
         * UnSetter for afterpayClearpay.
         * @return Builder
         */
        public Builder unsetAfterpayClearpay() {
            afterpayClearpay = null;
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

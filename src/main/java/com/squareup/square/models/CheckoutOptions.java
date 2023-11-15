
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CheckoutOptions type.
 */
public class CheckoutOptions {
    private final OptionalNullable<Boolean> allowTipping;
    private final OptionalNullable<List<CustomField>> customFields;
    private final OptionalNullable<String> subscriptionPlanId;
    private final OptionalNullable<String> redirectUrl;
    private final OptionalNullable<String> merchantSupportEmail;
    private final OptionalNullable<Boolean> askForShippingAddress;
    private final AcceptedPaymentMethods acceptedPaymentMethods;
    private final Money appFeeMoney;
    private final ShippingFee shippingFee;
    private final OptionalNullable<Boolean> enableCoupon;
    private final OptionalNullable<Boolean> enableLoyalty;

    /**
     * Initialization constructor.
     * @param  allowTipping  Boolean value for allowTipping.
     * @param  customFields  List of CustomField value for customFields.
     * @param  subscriptionPlanId  String value for subscriptionPlanId.
     * @param  redirectUrl  String value for redirectUrl.
     * @param  merchantSupportEmail  String value for merchantSupportEmail.
     * @param  askForShippingAddress  Boolean value for askForShippingAddress.
     * @param  acceptedPaymentMethods  AcceptedPaymentMethods value for acceptedPaymentMethods.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  shippingFee  ShippingFee value for shippingFee.
     * @param  enableCoupon  Boolean value for enableCoupon.
     * @param  enableLoyalty  Boolean value for enableLoyalty.
     */
    @JsonCreator
    public CheckoutOptions(
            @JsonProperty("allow_tipping") Boolean allowTipping,
            @JsonProperty("custom_fields") List<CustomField> customFields,
            @JsonProperty("subscription_plan_id") String subscriptionPlanId,
            @JsonProperty("redirect_url") String redirectUrl,
            @JsonProperty("merchant_support_email") String merchantSupportEmail,
            @JsonProperty("ask_for_shipping_address") Boolean askForShippingAddress,
            @JsonProperty("accepted_payment_methods") AcceptedPaymentMethods acceptedPaymentMethods,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("shipping_fee") ShippingFee shippingFee,
            @JsonProperty("enable_coupon") Boolean enableCoupon,
            @JsonProperty("enable_loyalty") Boolean enableLoyalty) {
        this.allowTipping = OptionalNullable.of(allowTipping);
        this.customFields = OptionalNullable.of(customFields);
        this.subscriptionPlanId = OptionalNullable.of(subscriptionPlanId);
        this.redirectUrl = OptionalNullable.of(redirectUrl);
        this.merchantSupportEmail = OptionalNullable.of(merchantSupportEmail);
        this.askForShippingAddress = OptionalNullable.of(askForShippingAddress);
        this.acceptedPaymentMethods = acceptedPaymentMethods;
        this.appFeeMoney = appFeeMoney;
        this.shippingFee = shippingFee;
        this.enableCoupon = OptionalNullable.of(enableCoupon);
        this.enableLoyalty = OptionalNullable.of(enableLoyalty);
    }

    /**
     * Initialization constructor.
     * @param  allowTipping  Boolean value for allowTipping.
     * @param  customFields  List of CustomField value for customFields.
     * @param  subscriptionPlanId  String value for subscriptionPlanId.
     * @param  redirectUrl  String value for redirectUrl.
     * @param  merchantSupportEmail  String value for merchantSupportEmail.
     * @param  askForShippingAddress  Boolean value for askForShippingAddress.
     * @param  acceptedPaymentMethods  AcceptedPaymentMethods value for acceptedPaymentMethods.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  shippingFee  ShippingFee value for shippingFee.
     * @param  enableCoupon  Boolean value for enableCoupon.
     * @param  enableLoyalty  Boolean value for enableLoyalty.
     */

    protected CheckoutOptions(OptionalNullable<Boolean> allowTipping,
            OptionalNullable<List<CustomField>> customFields,
            OptionalNullable<String> subscriptionPlanId, OptionalNullable<String> redirectUrl,
            OptionalNullable<String> merchantSupportEmail,
            OptionalNullable<Boolean> askForShippingAddress,
            AcceptedPaymentMethods acceptedPaymentMethods, Money appFeeMoney,
            ShippingFee shippingFee, OptionalNullable<Boolean> enableCoupon,
            OptionalNullable<Boolean> enableLoyalty) {
        this.allowTipping = allowTipping;
        this.customFields = customFields;
        this.subscriptionPlanId = subscriptionPlanId;
        this.redirectUrl = redirectUrl;
        this.merchantSupportEmail = merchantSupportEmail;
        this.askForShippingAddress = askForShippingAddress;
        this.acceptedPaymentMethods = acceptedPaymentMethods;
        this.appFeeMoney = appFeeMoney;
        this.shippingFee = shippingFee;
        this.enableCoupon = enableCoupon;
        this.enableLoyalty = enableLoyalty;
    }

    /**
     * Internal Getter for AllowTipping.
     * Indicates whether the payment allows tipping.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("allow_tipping")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAllowTipping() {
        return this.allowTipping;
    }

    /**
     * Getter for AllowTipping.
     * Indicates whether the payment allows tipping.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAllowTipping() {
        return OptionalNullable.getFrom(allowTipping);
    }

    /**
     * Internal Getter for CustomFields.
     * The custom fields requesting information from the buyer.
     * @return Returns the Internal List of CustomField
     */
    @JsonGetter("custom_fields")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CustomField>> internalGetCustomFields() {
        return this.customFields;
    }

    /**
     * Getter for CustomFields.
     * The custom fields requesting information from the buyer.
     * @return Returns the List of CustomField
     */
    @JsonIgnore
    public List<CustomField> getCustomFields() {
        return OptionalNullable.getFrom(customFields);
    }

    /**
     * Internal Getter for SubscriptionPlanId.
     * The ID of the subscription plan for the buyer to pay and subscribe. For more information, see
     * [Subscription Plan
     * Checkout](https://developer.squareup.com/docs/checkout-api/subscription-plan-checkout).
     * @return Returns the Internal String
     */
    @JsonGetter("subscription_plan_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    /**
     * Getter for SubscriptionPlanId.
     * The ID of the subscription plan for the buyer to pay and subscribe. For more information, see
     * [Subscription Plan
     * Checkout](https://developer.squareup.com/docs/checkout-api/subscription-plan-checkout).
     * @return Returns the String
     */
    @JsonIgnore
    public String getSubscriptionPlanId() {
        return OptionalNullable.getFrom(subscriptionPlanId);
    }

    /**
     * Internal Getter for RedirectUrl.
     * The confirmation page URL to redirect the buyer to after Square processes the payment.
     * @return Returns the Internal String
     */
    @JsonGetter("redirect_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetRedirectUrl() {
        return this.redirectUrl;
    }

    /**
     * Getter for RedirectUrl.
     * The confirmation page URL to redirect the buyer to after Square processes the payment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getRedirectUrl() {
        return OptionalNullable.getFrom(redirectUrl);
    }

    /**
     * Internal Getter for MerchantSupportEmail.
     * The email address that buyers can use to contact the seller.
     * @return Returns the Internal String
     */
    @JsonGetter("merchant_support_email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMerchantSupportEmail() {
        return this.merchantSupportEmail;
    }

    /**
     * Getter for MerchantSupportEmail.
     * The email address that buyers can use to contact the seller.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMerchantSupportEmail() {
        return OptionalNullable.getFrom(merchantSupportEmail);
    }

    /**
     * Internal Getter for AskForShippingAddress.
     * Indicates whether to include the address fields in the payment form.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("ask_for_shipping_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAskForShippingAddress() {
        return this.askForShippingAddress;
    }

    /**
     * Getter for AskForShippingAddress.
     * Indicates whether to include the address fields in the payment form.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAskForShippingAddress() {
        return OptionalNullable.getFrom(askForShippingAddress);
    }

    /**
     * Getter for AcceptedPaymentMethods.
     * @return Returns the AcceptedPaymentMethods
     */
    @JsonGetter("accepted_payment_methods")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public AcceptedPaymentMethods getAcceptedPaymentMethods() {
        return acceptedPaymentMethods;
    }

    /**
     * Getter for AppFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("app_fee_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAppFeeMoney() {
        return appFeeMoney;
    }

    /**
     * Getter for ShippingFee.
     * @return Returns the ShippingFee
     */
    @JsonGetter("shipping_fee")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ShippingFee getShippingFee() {
        return shippingFee;
    }

    /**
     * Internal Getter for EnableCoupon.
     * Indicates whether to include the `Add coupon` section for the buyer to provide a Square
     * marketing coupon in the payment form.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("enable_coupon")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetEnableCoupon() {
        return this.enableCoupon;
    }

    /**
     * Getter for EnableCoupon.
     * Indicates whether to include the `Add coupon` section for the buyer to provide a Square
     * marketing coupon in the payment form.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getEnableCoupon() {
        return OptionalNullable.getFrom(enableCoupon);
    }

    /**
     * Internal Getter for EnableLoyalty.
     * Indicates whether to include the `REWARDS` section for the buyer to opt in to loyalty, redeem
     * rewards in the payment form, or both.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("enable_loyalty")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetEnableLoyalty() {
        return this.enableLoyalty;
    }

    /**
     * Getter for EnableLoyalty.
     * Indicates whether to include the `REWARDS` section for the buyer to opt in to loyalty, redeem
     * rewards in the payment form, or both.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getEnableLoyalty() {
        return OptionalNullable.getFrom(enableLoyalty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowTipping, customFields, subscriptionPlanId, redirectUrl,
                merchantSupportEmail, askForShippingAddress, acceptedPaymentMethods, appFeeMoney,
                shippingFee, enableCoupon, enableLoyalty);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutOptions)) {
            return false;
        }
        CheckoutOptions other = (CheckoutOptions) obj;
        return Objects.equals(allowTipping, other.allowTipping)
            && Objects.equals(customFields, other.customFields)
            && Objects.equals(subscriptionPlanId, other.subscriptionPlanId)
            && Objects.equals(redirectUrl, other.redirectUrl)
            && Objects.equals(merchantSupportEmail, other.merchantSupportEmail)
            && Objects.equals(askForShippingAddress, other.askForShippingAddress)
            && Objects.equals(acceptedPaymentMethods, other.acceptedPaymentMethods)
            && Objects.equals(appFeeMoney, other.appFeeMoney)
            && Objects.equals(shippingFee, other.shippingFee)
            && Objects.equals(enableCoupon, other.enableCoupon)
            && Objects.equals(enableLoyalty, other.enableLoyalty);
    }

    /**
     * Converts this CheckoutOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutOptions [" + "allowTipping=" + allowTipping + ", customFields="
                + customFields + ", subscriptionPlanId=" + subscriptionPlanId + ", redirectUrl="
                + redirectUrl + ", merchantSupportEmail=" + merchantSupportEmail
                + ", askForShippingAddress=" + askForShippingAddress + ", acceptedPaymentMethods="
                + acceptedPaymentMethods + ", appFeeMoney=" + appFeeMoney + ", shippingFee="
                + shippingFee + ", enableCoupon=" + enableCoupon + ", enableLoyalty="
                + enableLoyalty + "]";
    }

    /**
     * Builds a new {@link CheckoutOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .acceptedPaymentMethods(getAcceptedPaymentMethods())
                .appFeeMoney(getAppFeeMoney())
                .shippingFee(getShippingFee());
        builder.allowTipping = internalGetAllowTipping();
        builder.customFields = internalGetCustomFields();
        builder.subscriptionPlanId = internalGetSubscriptionPlanId();
        builder.redirectUrl = internalGetRedirectUrl();
        builder.merchantSupportEmail = internalGetMerchantSupportEmail();
        builder.askForShippingAddress = internalGetAskForShippingAddress();
        builder.enableCoupon = internalGetEnableCoupon();
        builder.enableLoyalty = internalGetEnableLoyalty();
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutOptions}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> allowTipping;
        private OptionalNullable<List<CustomField>> customFields;
        private OptionalNullable<String> subscriptionPlanId;
        private OptionalNullable<String> redirectUrl;
        private OptionalNullable<String> merchantSupportEmail;
        private OptionalNullable<Boolean> askForShippingAddress;
        private AcceptedPaymentMethods acceptedPaymentMethods;
        private Money appFeeMoney;
        private ShippingFee shippingFee;
        private OptionalNullable<Boolean> enableCoupon;
        private OptionalNullable<Boolean> enableLoyalty;



        /**
         * Setter for allowTipping.
         * @param  allowTipping  Boolean value for allowTipping.
         * @return Builder
         */
        public Builder allowTipping(Boolean allowTipping) {
            this.allowTipping = OptionalNullable.of(allowTipping);
            return this;
        }

        /**
         * UnSetter for allowTipping.
         * @return Builder
         */
        public Builder unsetAllowTipping() {
            allowTipping = null;
            return this;
        }

        /**
         * Setter for customFields.
         * @param  customFields  List of CustomField value for customFields.
         * @return Builder
         */
        public Builder customFields(List<CustomField> customFields) {
            this.customFields = OptionalNullable.of(customFields);
            return this;
        }

        /**
         * UnSetter for customFields.
         * @return Builder
         */
        public Builder unsetCustomFields() {
            customFields = null;
            return this;
        }

        /**
         * Setter for subscriptionPlanId.
         * @param  subscriptionPlanId  String value for subscriptionPlanId.
         * @return Builder
         */
        public Builder subscriptionPlanId(String subscriptionPlanId) {
            this.subscriptionPlanId = OptionalNullable.of(subscriptionPlanId);
            return this;
        }

        /**
         * UnSetter for subscriptionPlanId.
         * @return Builder
         */
        public Builder unsetSubscriptionPlanId() {
            subscriptionPlanId = null;
            return this;
        }

        /**
         * Setter for redirectUrl.
         * @param  redirectUrl  String value for redirectUrl.
         * @return Builder
         */
        public Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = OptionalNullable.of(redirectUrl);
            return this;
        }

        /**
         * UnSetter for redirectUrl.
         * @return Builder
         */
        public Builder unsetRedirectUrl() {
            redirectUrl = null;
            return this;
        }

        /**
         * Setter for merchantSupportEmail.
         * @param  merchantSupportEmail  String value for merchantSupportEmail.
         * @return Builder
         */
        public Builder merchantSupportEmail(String merchantSupportEmail) {
            this.merchantSupportEmail = OptionalNullable.of(merchantSupportEmail);
            return this;
        }

        /**
         * UnSetter for merchantSupportEmail.
         * @return Builder
         */
        public Builder unsetMerchantSupportEmail() {
            merchantSupportEmail = null;
            return this;
        }

        /**
         * Setter for askForShippingAddress.
         * @param  askForShippingAddress  Boolean value for askForShippingAddress.
         * @return Builder
         */
        public Builder askForShippingAddress(Boolean askForShippingAddress) {
            this.askForShippingAddress = OptionalNullable.of(askForShippingAddress);
            return this;
        }

        /**
         * UnSetter for askForShippingAddress.
         * @return Builder
         */
        public Builder unsetAskForShippingAddress() {
            askForShippingAddress = null;
            return this;
        }

        /**
         * Setter for acceptedPaymentMethods.
         * @param  acceptedPaymentMethods  AcceptedPaymentMethods value for acceptedPaymentMethods.
         * @return Builder
         */
        public Builder acceptedPaymentMethods(AcceptedPaymentMethods acceptedPaymentMethods) {
            this.acceptedPaymentMethods = acceptedPaymentMethods;
            return this;
        }

        /**
         * Setter for appFeeMoney.
         * @param  appFeeMoney  Money value for appFeeMoney.
         * @return Builder
         */
        public Builder appFeeMoney(Money appFeeMoney) {
            this.appFeeMoney = appFeeMoney;
            return this;
        }

        /**
         * Setter for shippingFee.
         * @param  shippingFee  ShippingFee value for shippingFee.
         * @return Builder
         */
        public Builder shippingFee(ShippingFee shippingFee) {
            this.shippingFee = shippingFee;
            return this;
        }

        /**
         * Setter for enableCoupon.
         * @param  enableCoupon  Boolean value for enableCoupon.
         * @return Builder
         */
        public Builder enableCoupon(Boolean enableCoupon) {
            this.enableCoupon = OptionalNullable.of(enableCoupon);
            return this;
        }

        /**
         * UnSetter for enableCoupon.
         * @return Builder
         */
        public Builder unsetEnableCoupon() {
            enableCoupon = null;
            return this;
        }

        /**
         * Setter for enableLoyalty.
         * @param  enableLoyalty  Boolean value for enableLoyalty.
         * @return Builder
         */
        public Builder enableLoyalty(Boolean enableLoyalty) {
            this.enableLoyalty = OptionalNullable.of(enableLoyalty);
            return this;
        }

        /**
         * UnSetter for enableLoyalty.
         * @return Builder
         */
        public Builder unsetEnableLoyalty() {
            enableLoyalty = null;
            return this;
        }

        /**
         * Builds a new {@link CheckoutOptions} object using the set fields.
         * @return {@link CheckoutOptions}
         */
        public CheckoutOptions build() {
            return new CheckoutOptions(allowTipping, customFields, subscriptionPlanId, redirectUrl,
                    merchantSupportEmail, askForShippingAddress, acceptedPaymentMethods,
                    appFeeMoney, shippingFee, enableCoupon, enableLoyalty);
        }
    }
}

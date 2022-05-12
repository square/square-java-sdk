
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CheckoutOptions type.
 */
public class CheckoutOptions {
    private final Boolean allowTipping;
    private final List<CustomField> customFields;
    private final String subscriptionPlanId;
    private final String redirectUrl;
    private final String merchantSupportEmail;
    private final Boolean askForShippingAddress;
    private final AcceptedPaymentMethods acceptedPaymentMethods;

    /**
     * Initialization constructor.
     * @param  allowTipping  Boolean value for allowTipping.
     * @param  customFields  List of CustomField value for customFields.
     * @param  subscriptionPlanId  String value for subscriptionPlanId.
     * @param  redirectUrl  String value for redirectUrl.
     * @param  merchantSupportEmail  String value for merchantSupportEmail.
     * @param  askForShippingAddress  Boolean value for askForShippingAddress.
     * @param  acceptedPaymentMethods  AcceptedPaymentMethods value for acceptedPaymentMethods.
     */
    @JsonCreator
    public CheckoutOptions(
            @JsonProperty("allow_tipping") Boolean allowTipping,
            @JsonProperty("custom_fields") List<CustomField> customFields,
            @JsonProperty("subscription_plan_id") String subscriptionPlanId,
            @JsonProperty("redirect_url") String redirectUrl,
            @JsonProperty("merchant_support_email") String merchantSupportEmail,
            @JsonProperty("ask_for_shipping_address") Boolean askForShippingAddress,
            @JsonProperty("accepted_payment_methods") AcceptedPaymentMethods acceptedPaymentMethods) {
        this.allowTipping = allowTipping;
        this.customFields = customFields;
        this.subscriptionPlanId = subscriptionPlanId;
        this.redirectUrl = redirectUrl;
        this.merchantSupportEmail = merchantSupportEmail;
        this.askForShippingAddress = askForShippingAddress;
        this.acceptedPaymentMethods = acceptedPaymentMethods;
    }

    /**
     * Getter for AllowTipping.
     * Indicates whether the payment allows tipping.
     * @return Returns the Boolean
     */
    @JsonGetter("allow_tipping")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAllowTipping() {
        return allowTipping;
    }

    /**
     * Getter for CustomFields.
     * The custom fields requesting information from the buyer.
     * @return Returns the List of CustomField
     */
    @JsonGetter("custom_fields")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CustomField> getCustomFields() {
        return customFields;
    }

    /**
     * Getter for SubscriptionPlanId.
     * The ID of the subscription plan for the buyer to pay and subscribe. For more information, see
     * [Subscription Plan
     * Checkout](https://developer.squareup.com/docs/checkout-api/subscription-plan-checkout).
     * @return Returns the String
     */
    @JsonGetter("subscription_plan_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    /**
     * Getter for RedirectUrl.
     * The confirmation page URL to redirect the buyer to after Square processes the payment.
     * @return Returns the String
     */
    @JsonGetter("redirect_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Getter for MerchantSupportEmail.
     * The email address that buyers can use to contact the seller.
     * @return Returns the String
     */
    @JsonGetter("merchant_support_email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMerchantSupportEmail() {
        return merchantSupportEmail;
    }

    /**
     * Getter for AskForShippingAddress.
     * Indicates whether to include the address fields in the payment form.
     * @return Returns the Boolean
     */
    @JsonGetter("ask_for_shipping_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getAskForShippingAddress() {
        return askForShippingAddress;
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

    @Override
    public int hashCode() {
        return Objects.hash(allowTipping, customFields, subscriptionPlanId, redirectUrl,
                merchantSupportEmail, askForShippingAddress, acceptedPaymentMethods);
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
            && Objects.equals(acceptedPaymentMethods, other.acceptedPaymentMethods);
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
                + acceptedPaymentMethods + "]";
    }

    /**
     * Builds a new {@link CheckoutOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .allowTipping(getAllowTipping())
                .customFields(getCustomFields())
                .subscriptionPlanId(getSubscriptionPlanId())
                .redirectUrl(getRedirectUrl())
                .merchantSupportEmail(getMerchantSupportEmail())
                .askForShippingAddress(getAskForShippingAddress())
                .acceptedPaymentMethods(getAcceptedPaymentMethods());
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutOptions}.
     */
    public static class Builder {
        private Boolean allowTipping;
        private List<CustomField> customFields;
        private String subscriptionPlanId;
        private String redirectUrl;
        private String merchantSupportEmail;
        private Boolean askForShippingAddress;
        private AcceptedPaymentMethods acceptedPaymentMethods;



        /**
         * Setter for allowTipping.
         * @param  allowTipping  Boolean value for allowTipping.
         * @return Builder
         */
        public Builder allowTipping(Boolean allowTipping) {
            this.allowTipping = allowTipping;
            return this;
        }

        /**
         * Setter for customFields.
         * @param  customFields  List of CustomField value for customFields.
         * @return Builder
         */
        public Builder customFields(List<CustomField> customFields) {
            this.customFields = customFields;
            return this;
        }

        /**
         * Setter for subscriptionPlanId.
         * @param  subscriptionPlanId  String value for subscriptionPlanId.
         * @return Builder
         */
        public Builder subscriptionPlanId(String subscriptionPlanId) {
            this.subscriptionPlanId = subscriptionPlanId;
            return this;
        }

        /**
         * Setter for redirectUrl.
         * @param  redirectUrl  String value for redirectUrl.
         * @return Builder
         */
        public Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        /**
         * Setter for merchantSupportEmail.
         * @param  merchantSupportEmail  String value for merchantSupportEmail.
         * @return Builder
         */
        public Builder merchantSupportEmail(String merchantSupportEmail) {
            this.merchantSupportEmail = merchantSupportEmail;
            return this;
        }

        /**
         * Setter for askForShippingAddress.
         * @param  askForShippingAddress  Boolean value for askForShippingAddress.
         * @return Builder
         */
        public Builder askForShippingAddress(Boolean askForShippingAddress) {
            this.askForShippingAddress = askForShippingAddress;
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
         * Builds a new {@link CheckoutOptions} object using the set fields.
         * @return {@link CheckoutOptions}
         */
        public CheckoutOptions build() {
            return new CheckoutOptions(allowTipping, customFields, subscriptionPlanId, redirectUrl,
                    merchantSupportEmail, askForShippingAddress, acceptedPaymentMethods);
        }
    }
}

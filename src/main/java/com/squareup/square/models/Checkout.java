
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
 * This is a model class for Checkout type.
 */
public class Checkout {
    private final String id;
    private final OptionalNullable<String> checkoutPageUrl;
    private final OptionalNullable<Boolean> askForShippingAddress;
    private final OptionalNullable<String> merchantSupportEmail;
    private final OptionalNullable<String> prePopulateBuyerEmail;
    private final Address prePopulateShippingAddress;
    private final OptionalNullable<String> redirectUrl;
    private final Order order;
    private final String createdAt;
    private final OptionalNullable<List<AdditionalRecipient>> additionalRecipients;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  checkoutPageUrl  String value for checkoutPageUrl.
     * @param  askForShippingAddress  Boolean value for askForShippingAddress.
     * @param  merchantSupportEmail  String value for merchantSupportEmail.
     * @param  prePopulateBuyerEmail  String value for prePopulateBuyerEmail.
     * @param  prePopulateShippingAddress  Address value for prePopulateShippingAddress.
     * @param  redirectUrl  String value for redirectUrl.
     * @param  order  Order value for order.
     * @param  createdAt  String value for createdAt.
     * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
     */
    @JsonCreator
    public Checkout(
            @JsonProperty("id") String id,
            @JsonProperty("checkout_page_url") String checkoutPageUrl,
            @JsonProperty("ask_for_shipping_address") Boolean askForShippingAddress,
            @JsonProperty("merchant_support_email") String merchantSupportEmail,
            @JsonProperty("pre_populate_buyer_email") String prePopulateBuyerEmail,
            @JsonProperty("pre_populate_shipping_address") Address prePopulateShippingAddress,
            @JsonProperty("redirect_url") String redirectUrl,
            @JsonProperty("order") Order order,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("additional_recipients") List<AdditionalRecipient> additionalRecipients) {
        this.id = id;
        this.checkoutPageUrl = OptionalNullable.of(checkoutPageUrl);
        this.askForShippingAddress = OptionalNullable.of(askForShippingAddress);
        this.merchantSupportEmail = OptionalNullable.of(merchantSupportEmail);
        this.prePopulateBuyerEmail = OptionalNullable.of(prePopulateBuyerEmail);
        this.prePopulateShippingAddress = prePopulateShippingAddress;
        this.redirectUrl = OptionalNullable.of(redirectUrl);
        this.order = order;
        this.createdAt = createdAt;
        this.additionalRecipients = OptionalNullable.of(additionalRecipients);
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  checkoutPageUrl  String value for checkoutPageUrl.
     * @param  askForShippingAddress  Boolean value for askForShippingAddress.
     * @param  merchantSupportEmail  String value for merchantSupportEmail.
     * @param  prePopulateBuyerEmail  String value for prePopulateBuyerEmail.
     * @param  prePopulateShippingAddress  Address value for prePopulateShippingAddress.
     * @param  redirectUrl  String value for redirectUrl.
     * @param  order  Order value for order.
     * @param  createdAt  String value for createdAt.
     * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
     */

    protected Checkout(String id, OptionalNullable<String> checkoutPageUrl,
            OptionalNullable<Boolean> askForShippingAddress,
            OptionalNullable<String> merchantSupportEmail,
            OptionalNullable<String> prePopulateBuyerEmail, Address prePopulateShippingAddress,
            OptionalNullable<String> redirectUrl, Order order, String createdAt,
            OptionalNullable<List<AdditionalRecipient>> additionalRecipients) {
        this.id = id;
        this.checkoutPageUrl = checkoutPageUrl;
        this.askForShippingAddress = askForShippingAddress;
        this.merchantSupportEmail = merchantSupportEmail;
        this.prePopulateBuyerEmail = prePopulateBuyerEmail;
        this.prePopulateShippingAddress = prePopulateShippingAddress;
        this.redirectUrl = redirectUrl;
        this.order = order;
        this.createdAt = createdAt;
        this.additionalRecipients = additionalRecipients;
    }

    /**
     * Getter for Id.
     * ID generated by Square Checkout when a new checkout is requested.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for CheckoutPageUrl.
     * The URL that the buyer's browser should be redirected to after the checkout is completed.
     * @return Returns the Internal String
     */
    @JsonGetter("checkout_page_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCheckoutPageUrl() {
        return this.checkoutPageUrl;
    }

    /**
     * Getter for CheckoutPageUrl.
     * The URL that the buyer's browser should be redirected to after the checkout is completed.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCheckoutPageUrl() {
        return OptionalNullable.getFrom(checkoutPageUrl);
    }

    /**
     * Internal Getter for AskForShippingAddress.
     * If `true`, Square Checkout will collect shipping information on your behalf and store that
     * information with the transaction information in your Square Dashboard. Default: `false`.
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
     * If `true`, Square Checkout will collect shipping information on your behalf and store that
     * information with the transaction information in your Square Dashboard. Default: `false`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAskForShippingAddress() {
        return OptionalNullable.getFrom(askForShippingAddress);
    }

    /**
     * Internal Getter for MerchantSupportEmail.
     * The email address to display on the Square Checkout confirmation page and confirmation email
     * that the buyer can use to contact the merchant. If this value is not set, the confirmation
     * page and email will display the primary email address associated with the merchant's Square
     * account. Default: none; only exists if explicitly set.
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
     * The email address to display on the Square Checkout confirmation page and confirmation email
     * that the buyer can use to contact the merchant. If this value is not set, the confirmation
     * page and email will display the primary email address associated with the merchant's Square
     * account. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMerchantSupportEmail() {
        return OptionalNullable.getFrom(merchantSupportEmail);
    }

    /**
     * Internal Getter for PrePopulateBuyerEmail.
     * If provided, the buyer's email is pre-populated on the checkout page as an editable text
     * field. Default: none; only exists if explicitly set.
     * @return Returns the Internal String
     */
    @JsonGetter("pre_populate_buyer_email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPrePopulateBuyerEmail() {
        return this.prePopulateBuyerEmail;
    }

    /**
     * Getter for PrePopulateBuyerEmail.
     * If provided, the buyer's email is pre-populated on the checkout page as an editable text
     * field. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPrePopulateBuyerEmail() {
        return OptionalNullable.getFrom(prePopulateBuyerEmail);
    }

    /**
     * Getter for PrePopulateShippingAddress.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("pre_populate_shipping_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getPrePopulateShippingAddress() {
        return prePopulateShippingAddress;
    }

    /**
     * Internal Getter for RedirectUrl.
     * The URL to redirect to after checkout is completed with `checkoutId`, Square's `orderId`,
     * `transactionId`, and `referenceId` appended as URL parameters. For example, if the provided
     * redirect_url is `http://www.example.com/order-complete`, a successful transaction redirects
     * the customer to:
     * &lt;pre&gt;&lt;code&gt;http://www.example.com/order-complete?checkoutId=xxxxxx&amp;orderId=xxxxxx&amp;referenceId=xxxxxx&amp;transactionId=xxxxxx&lt;/code&gt;&lt;/pre&gt;
     * If you do not provide a redirect URL, Square Checkout will display an order confirmation page
     * on your behalf; however Square strongly recommends that you provide a redirect URL so you can
     * verify the transaction results and finalize the order through your existing/normal
     * confirmation workflow.
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
     * The URL to redirect to after checkout is completed with `checkoutId`, Square's `orderId`,
     * `transactionId`, and `referenceId` appended as URL parameters. For example, if the provided
     * redirect_url is `http://www.example.com/order-complete`, a successful transaction redirects
     * the customer to:
     * &lt;pre&gt;&lt;code&gt;http://www.example.com/order-complete?checkoutId=xxxxxx&amp;orderId=xxxxxx&amp;referenceId=xxxxxx&amp;transactionId=xxxxxx&lt;/code&gt;&lt;/pre&gt;
     * If you do not provide a redirect URL, Square Checkout will display an order confirmation page
     * on your behalf; however Square strongly recommends that you provide a redirect URL so you can
     * verify the transaction results and finalize the order through your existing/normal
     * confirmation workflow.
     * @return Returns the String
     */
    @JsonIgnore
    public String getRedirectUrl() {
        return OptionalNullable.getFrom(redirectUrl);
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square, including line
     * items that specify the products to purchase. `Order` objects also include information about
     * any associated tenders, refunds, and returns. All Connect V2 Transactions have all been
     * converted to Orders including all associated itemization data.
     * @return Returns the Order
     */
    @JsonGetter("order")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Order getOrder() {
        return order;
    }

    /**
     * Getter for CreatedAt.
     * The time when the checkout was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Internal Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this checkout. For
     * example, fees assessed on the purchase by a third party integration.
     * @return Returns the Internal List of AdditionalRecipient
     */
    @JsonGetter("additional_recipients")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<AdditionalRecipient>> internalGetAdditionalRecipients() {
        return this.additionalRecipients;
    }

    /**
     * Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this checkout. For
     * example, fees assessed on the purchase by a third party integration.
     * @return Returns the List of AdditionalRecipient
     */
    @JsonIgnore
    public List<AdditionalRecipient> getAdditionalRecipients() {
        return OptionalNullable.getFrom(additionalRecipients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkoutPageUrl, askForShippingAddress, merchantSupportEmail,
                prePopulateBuyerEmail, prePopulateShippingAddress, redirectUrl, order, createdAt,
                additionalRecipients);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Checkout)) {
            return false;
        }
        Checkout other = (Checkout) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(checkoutPageUrl, other.checkoutPageUrl)
            && Objects.equals(askForShippingAddress, other.askForShippingAddress)
            && Objects.equals(merchantSupportEmail, other.merchantSupportEmail)
            && Objects.equals(prePopulateBuyerEmail, other.prePopulateBuyerEmail)
            && Objects.equals(prePopulateShippingAddress, other.prePopulateShippingAddress)
            && Objects.equals(redirectUrl, other.redirectUrl)
            && Objects.equals(order, other.order)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(additionalRecipients, other.additionalRecipients);
    }

    /**
     * Converts this Checkout into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Checkout [" + "id=" + id + ", checkoutPageUrl=" + checkoutPageUrl
                + ", askForShippingAddress=" + askForShippingAddress + ", merchantSupportEmail="
                + merchantSupportEmail + ", prePopulateBuyerEmail=" + prePopulateBuyerEmail
                + ", prePopulateShippingAddress=" + prePopulateShippingAddress + ", redirectUrl="
                + redirectUrl + ", order=" + order + ", createdAt=" + createdAt
                + ", additionalRecipients=" + additionalRecipients + "]";
    }

    /**
     * Builds a new {@link Checkout.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Checkout.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .prePopulateShippingAddress(getPrePopulateShippingAddress())
                .order(getOrder())
                .createdAt(getCreatedAt());
        builder.checkoutPageUrl = internalGetCheckoutPageUrl();
        builder.askForShippingAddress = internalGetAskForShippingAddress();
        builder.merchantSupportEmail = internalGetMerchantSupportEmail();
        builder.prePopulateBuyerEmail = internalGetPrePopulateBuyerEmail();
        builder.redirectUrl = internalGetRedirectUrl();
        builder.additionalRecipients = internalGetAdditionalRecipients();
        return builder;
    }

    /**
     * Class to build instances of {@link Checkout}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> checkoutPageUrl;
        private OptionalNullable<Boolean> askForShippingAddress;
        private OptionalNullable<String> merchantSupportEmail;
        private OptionalNullable<String> prePopulateBuyerEmail;
        private Address prePopulateShippingAddress;
        private OptionalNullable<String> redirectUrl;
        private Order order;
        private String createdAt;
        private OptionalNullable<List<AdditionalRecipient>> additionalRecipients;



        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for checkoutPageUrl.
         * @param  checkoutPageUrl  String value for checkoutPageUrl.
         * @return Builder
         */
        public Builder checkoutPageUrl(String checkoutPageUrl) {
            this.checkoutPageUrl = OptionalNullable.of(checkoutPageUrl);
            return this;
        }

        /**
         * UnSetter for checkoutPageUrl.
         * @return Builder
         */
        public Builder unsetCheckoutPageUrl() {
            checkoutPageUrl = null;
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
         * Setter for prePopulateBuyerEmail.
         * @param  prePopulateBuyerEmail  String value for prePopulateBuyerEmail.
         * @return Builder
         */
        public Builder prePopulateBuyerEmail(String prePopulateBuyerEmail) {
            this.prePopulateBuyerEmail = OptionalNullable.of(prePopulateBuyerEmail);
            return this;
        }

        /**
         * UnSetter for prePopulateBuyerEmail.
         * @return Builder
         */
        public Builder unsetPrePopulateBuyerEmail() {
            prePopulateBuyerEmail = null;
            return this;
        }

        /**
         * Setter for prePopulateShippingAddress.
         * @param  prePopulateShippingAddress  Address value for prePopulateShippingAddress.
         * @return Builder
         */
        public Builder prePopulateShippingAddress(Address prePopulateShippingAddress) {
            this.prePopulateShippingAddress = prePopulateShippingAddress;
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
         * Setter for order.
         * @param  order  Order value for order.
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for additionalRecipients.
         * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
         * @return Builder
         */
        public Builder additionalRecipients(List<AdditionalRecipient> additionalRecipients) {
            this.additionalRecipients = OptionalNullable.of(additionalRecipients);
            return this;
        }

        /**
         * UnSetter for additionalRecipients.
         * @return Builder
         */
        public Builder unsetAdditionalRecipients() {
            additionalRecipients = null;
            return this;
        }

        /**
         * Builds a new {@link Checkout} object using the set fields.
         * @return {@link Checkout}
         */
        public Checkout build() {
            return new Checkout(id, checkoutPageUrl, askForShippingAddress, merchantSupportEmail,
                    prePopulateBuyerEmail, prePopulateShippingAddress, redirectUrl, order,
                    createdAt, additionalRecipients);
        }
    }
}

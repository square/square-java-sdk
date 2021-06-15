
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateCheckoutRequest type.
 */
public class CreateCheckoutRequest {
    private final String idempotencyKey;
    private final CreateOrderRequest order;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean askForShippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String merchantSupportEmail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String prePopulateBuyerEmail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address prePopulateShippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String redirectUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<ChargeRequestAdditionalRecipient> additionalRecipients;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  order  CreateOrderRequest value for order.
     * @param  askForShippingAddress  Boolean value for askForShippingAddress.
     * @param  merchantSupportEmail  String value for merchantSupportEmail.
     * @param  prePopulateBuyerEmail  String value for prePopulateBuyerEmail.
     * @param  prePopulateShippingAddress  Address value for prePopulateShippingAddress.
     * @param  redirectUrl  String value for redirectUrl.
     * @param  additionalRecipients  List of ChargeRequestAdditionalRecipient value for
     *         additionalRecipients.
     * @param  note  String value for note.
     */
    @JsonCreator
    public CreateCheckoutRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("order") CreateOrderRequest order,
            @JsonProperty("ask_for_shipping_address") Boolean askForShippingAddress,
            @JsonProperty("merchant_support_email") String merchantSupportEmail,
            @JsonProperty("pre_populate_buyer_email") String prePopulateBuyerEmail,
            @JsonProperty("pre_populate_shipping_address") Address prePopulateShippingAddress,
            @JsonProperty("redirect_url") String redirectUrl,
            @JsonProperty("additional_recipients") List<ChargeRequestAdditionalRecipient> additionalRecipients,
            @JsonProperty("note") String note) {
        this.idempotencyKey = idempotencyKey;
        this.order = order;
        this.askForShippingAddress = askForShippingAddress;
        this.merchantSupportEmail = merchantSupportEmail;
        this.prePopulateBuyerEmail = prePopulateBuyerEmail;
        this.prePopulateShippingAddress = prePopulateShippingAddress;
        this.redirectUrl = redirectUrl;
        this.additionalRecipients = additionalRecipients;
        this.note = note;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this checkout among others you have created. It can be any
     * valid string but must be unique for every order sent to Square Checkout for a given location
     * ID. The idempotency key is used to avoid processing the same order more than once. If you are
     * unsure whether a particular checkout was created successfully, you can attempt it again with
     * the same idempotency key and all the same other parameters without worrying about creating
     * duplicates. You should use a random number/string generator native to the language you are
     * working in to generate strings for your idempotency keys. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Order.
     * @return Returns the CreateOrderRequest
     */
    @JsonGetter("order")
    public CreateOrderRequest getOrder() {
        return order;
    }

    /**
     * Getter for AskForShippingAddress.
     * If `true`, Square Checkout collects shipping information on your behalf and stores that
     * information with the transaction information in the Square Seller Dashboard. Default:
     * `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("ask_for_shipping_address")
    public Boolean getAskForShippingAddress() {
        return askForShippingAddress;
    }

    /**
     * Getter for MerchantSupportEmail.
     * The email address to display on the Square Checkout confirmation page and confirmation email
     * that the buyer can use to contact the seller. If this value is not set, the confirmation page
     * and email display the primary email address associated with the seller's Square account.
     * Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonGetter("merchant_support_email")
    public String getMerchantSupportEmail() {
        return merchantSupportEmail;
    }

    /**
     * Getter for PrePopulateBuyerEmail.
     * If provided, the buyer's email is prepopulated on the checkout page as an editable text
     * field. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonGetter("pre_populate_buyer_email")
    public String getPrePopulateBuyerEmail() {
        return prePopulateBuyerEmail;
    }

    /**
     * Getter for PrePopulateShippingAddress.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("pre_populate_shipping_address")
    public Address getPrePopulateShippingAddress() {
        return prePopulateShippingAddress;
    }

    /**
     * Getter for RedirectUrl.
     * The URL to redirect to after the checkout is completed with `checkoutId`, `transactionId`,
     * and `referenceId` appended as URL parameters. For example, if the provided redirect URL is
     * `http://www.example.com/order-complete`, a successful transaction redirects the customer to:
     * <pre><code>http://www.example.com/order-complete?checkoutId=xxxxxx&amp;referenceId=xxxxxx&amp;transactionId=xxxxxx</code></pre>
     * If you do not provide a redirect URL, Square Checkout displays an order confirmation page on
     * your behalf; however, it is strongly recommended that you provide a redirect URL so you can
     * verify the transaction results and finalize the order through your existing/normal
     * confirmation workflow. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonGetter("redirect_url")
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Getter for AdditionalRecipients.
     * The basic primitive of a multi-party transaction. The value is optional. The transaction
     * facilitated by you can be split from here. If you provide this value, the `amount_money`
     * value in your `additional_recipients` field cannot be more than 90% of the `total_money`
     * calculated by Square for your order. The `location_id` must be a valid seller location where
     * the checkout is occurring. This field requires `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth
     * permission. This field is currently not supported in the Square Sandbox.
     * @return Returns the List of ChargeRequestAdditionalRecipient
     */
    @JsonGetter("additional_recipients")
    public List<ChargeRequestAdditionalRecipient> getAdditionalRecipients() {
        return additionalRecipients;
    }

    /**
     * Getter for Note.
     * An optional note to associate with the `checkout` object. This value cannot exceed 60
     * characters.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return note;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, order, askForShippingAddress, merchantSupportEmail,
                prePopulateBuyerEmail, prePopulateShippingAddress, redirectUrl,
                additionalRecipients, note);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCheckoutRequest)) {
            return false;
        }
        CreateCheckoutRequest other = (CreateCheckoutRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(order, other.order)
            && Objects.equals(askForShippingAddress, other.askForShippingAddress)
            && Objects.equals(merchantSupportEmail, other.merchantSupportEmail)
            && Objects.equals(prePopulateBuyerEmail, other.prePopulateBuyerEmail)
            && Objects.equals(prePopulateShippingAddress, other.prePopulateShippingAddress)
            && Objects.equals(redirectUrl, other.redirectUrl)
            && Objects.equals(additionalRecipients, other.additionalRecipients)
            && Objects.equals(note, other.note);
    }

    /**
     * Converts this CreateCheckoutRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateCheckoutRequest [" + "idempotencyKey=" + idempotencyKey + ", order=" + order
                + ", askForShippingAddress=" + askForShippingAddress + ", merchantSupportEmail="
                + merchantSupportEmail + ", prePopulateBuyerEmail=" + prePopulateBuyerEmail
                + ", prePopulateShippingAddress=" + prePopulateShippingAddress + ", redirectUrl="
                + redirectUrl + ", additionalRecipients=" + additionalRecipients + ", note=" + note
                + "]";
    }

    /**
     * Builds a new {@link CreateCheckoutRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCheckoutRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, order)
                .askForShippingAddress(getAskForShippingAddress())
                .merchantSupportEmail(getMerchantSupportEmail())
                .prePopulateBuyerEmail(getPrePopulateBuyerEmail())
                .prePopulateShippingAddress(getPrePopulateShippingAddress())
                .redirectUrl(getRedirectUrl())
                .additionalRecipients(getAdditionalRecipients())
                .note(getNote());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCheckoutRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private CreateOrderRequest order;
        private Boolean askForShippingAddress;
        private String merchantSupportEmail;
        private String prePopulateBuyerEmail;
        private Address prePopulateShippingAddress;
        private String redirectUrl;
        private List<ChargeRequestAdditionalRecipient> additionalRecipients;
        private String note;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  order  CreateOrderRequest value for order.
         */
        public Builder(String idempotencyKey, CreateOrderRequest order) {
            this.idempotencyKey = idempotencyKey;
            this.order = order;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for order.
         * @param  order  CreateOrderRequest value for order.
         * @return Builder
         */
        public Builder order(CreateOrderRequest order) {
            this.order = order;
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
         * Setter for merchantSupportEmail.
         * @param  merchantSupportEmail  String value for merchantSupportEmail.
         * @return Builder
         */
        public Builder merchantSupportEmail(String merchantSupportEmail) {
            this.merchantSupportEmail = merchantSupportEmail;
            return this;
        }

        /**
         * Setter for prePopulateBuyerEmail.
         * @param  prePopulateBuyerEmail  String value for prePopulateBuyerEmail.
         * @return Builder
         */
        public Builder prePopulateBuyerEmail(String prePopulateBuyerEmail) {
            this.prePopulateBuyerEmail = prePopulateBuyerEmail;
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
            this.redirectUrl = redirectUrl;
            return this;
        }

        /**
         * Setter for additionalRecipients.
         * @param  additionalRecipients  List of ChargeRequestAdditionalRecipient value for
         *         additionalRecipients.
         * @return Builder
         */
        public Builder additionalRecipients(
                List<ChargeRequestAdditionalRecipient> additionalRecipients) {
            this.additionalRecipients = additionalRecipients;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Builds a new {@link CreateCheckoutRequest} object using the set fields.
         * @return {@link CreateCheckoutRequest}
         */
        public CreateCheckoutRequest build() {
            return new CreateCheckoutRequest(idempotencyKey, order, askForShippingAddress,
                    merchantSupportEmail, prePopulateBuyerEmail, prePopulateShippingAddress,
                    redirectUrl, additionalRecipients, note);
        }
    }
}

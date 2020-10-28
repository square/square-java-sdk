
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CreateCheckoutRequest type.
 */
public class CreateCheckoutRequest {
    private final String idempotencyKey;
    private final CreateOrderRequest order;
    private final Boolean askForShippingAddress;
    private final String merchantSupportEmail;
    private final String prePopulateBuyerEmail;
    private final Address prePopulateShippingAddress;
    private final String redirectUrl;
    private final List<ChargeRequestAdditionalRecipient> additionalRecipients;
    private final String note;

    /**
     * Initialization constructor.
     * @param idempotencyKey String value for idempotencyKey.
     * @param order CreateOrderRequest value for order.
     * @param askForShippingAddress Boolean value for askForShippingAddress.
     * @param merchantSupportEmail String value for merchantSupportEmail.
     * @param prePopulateBuyerEmail String value for prePopulateBuyerEmail.
     * @param prePopulateShippingAddress Address value for prePopulateShippingAddress.
     * @param redirectUrl String value for redirectUrl.
     * @param additionalRecipients List of ChargeRequestAdditionalRecipient value for additionalRecipients.
     * @param note String value for note.
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
     * A unique string that identifies this checkout among others you've created. It can be any
     * valid string but must be unique for every order sent to Square Checkout for a given location
     * ID. The idempotency key is used to avoid processing the same order more than once. If you're
     * unsure whether a particular checkout was created successfully, you can reattempt it with the
     * same idempotency key and all the same other parameters without worrying about creating
     * duplicates. We recommend using a random number/string generator native to the language you
     * are working in to generate strings for your idempotency keys. See the
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency) guide for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for Order.
     * @return Returns the CreateOrderRequest
     */
    @JsonGetter("order")
    public CreateOrderRequest getOrder() {
        return this.order;
    }

    /**
     * Getter for AskForShippingAddress.
     * If `true`, Square Checkout will collect shipping information on your behalf and store that
     * information with the transaction information in your Square Dashboard. Default: `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("ask_for_shipping_address")
    public Boolean getAskForShippingAddress() {
        return this.askForShippingAddress;
    }

    /**
     * Getter for MerchantSupportEmail.
     * The email address to display on the Square Checkout confirmation page and confirmation email
     * that the buyer can use to contact the merchant. If this value is not set, the confirmation
     * page and email will display the primary email address associated with the merchant's Square
     * account. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonGetter("merchant_support_email")
    public String getMerchantSupportEmail() {
        return this.merchantSupportEmail;
    }

    /**
     * Getter for PrePopulateBuyerEmail.
     * If provided, the buyer's email is pre-populated on the checkout page as an editable text
     * field. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonGetter("pre_populate_buyer_email")
    public String getPrePopulateBuyerEmail() {
        return this.prePopulateBuyerEmail;
    }

    /**
     * Getter for PrePopulateShippingAddress.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("pre_populate_shipping_address")
    public Address getPrePopulateShippingAddress() {
        return this.prePopulateShippingAddress;
    }

    /**
     * Getter for RedirectUrl.
     * The URL to redirect to after checkout is completed with `checkoutId`, Square's `orderId`,
     * `transactionId`, and `referenceId` appended as URL parameters. For example, if the provided
     * redirect_url is `http://www.example.com/order-complete`, a successful transaction redirects
     * the customer to:
     * `http://www.example.com/order-complete?checkoutId=xxxxxx&orderId=xxxxxx&referenceId=xxxxxx&transactionId=xxxxxx`
     * If you do not provide a redirect URL, Square Checkout will display an order confirmation page
     * on your behalf; however Square strongly recommends that you provide a redirect URL so you can
     * verify the transaction results and finalize the order through your existing/normal
     * confirmation workflow. Default: none; only exists if explicitly set.
     * @return Returns the String
     */
    @JsonGetter("redirect_url")
    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    /**
     * Getter for AdditionalRecipients.
     * The basic primitive of multi-party transaction. The value is optional. The transaction
     * facilitated by you can be split from here. If you provide this value, the `amount_money`
     * value in your additional_recipients must not be more than 90% of the `total_money` calculated
     * by Square for your order. The `location_id` must be the valid location of the app owner
     * merchant. This field requires `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission. This
     * field is currently not supported in sandbox.
     * @return Returns the List of ChargeRequestAdditionalRecipient
     */
    @JsonGetter("additional_recipients")
    public List<ChargeRequestAdditionalRecipient> getAdditionalRecipients() {
        return this.additionalRecipients;
    }

    /**
     * Getter for Note.
     * An optional note to associate with the checkout object. This value cannot exceed 60
     * characters.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return this.note;
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
     * Builds a new {@link CreateCheckoutRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCheckoutRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            order)
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
         * @param idempotencyKey String value for idempotencyKey.
         * @param order CreateOrderRequest value for order.
         */
        public Builder(String idempotencyKey,
                CreateOrderRequest order) {
            this.idempotencyKey = idempotencyKey;
            this.order = order;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for order.
         * @param order CreateOrderRequest value for order.
         * @return Builder
         */
        public Builder order(CreateOrderRequest order) {
            this.order = order;
            return this;
        }

        /**
         * Setter for askForShippingAddress.
         * @param askForShippingAddress Boolean value for askForShippingAddress.
         * @return Builder
         */
        public Builder askForShippingAddress(Boolean askForShippingAddress) {
            this.askForShippingAddress = askForShippingAddress;
            return this;
        }

        /**
         * Setter for merchantSupportEmail.
         * @param merchantSupportEmail String value for merchantSupportEmail.
         * @return Builder
         */
        public Builder merchantSupportEmail(String merchantSupportEmail) {
            this.merchantSupportEmail = merchantSupportEmail;
            return this;
        }

        /**
         * Setter for prePopulateBuyerEmail.
         * @param prePopulateBuyerEmail String value for prePopulateBuyerEmail.
         * @return Builder
         */
        public Builder prePopulateBuyerEmail(String prePopulateBuyerEmail) {
            this.prePopulateBuyerEmail = prePopulateBuyerEmail;
            return this;
        }

        /**
         * Setter for prePopulateShippingAddress.
         * @param prePopulateShippingAddress Address value for prePopulateShippingAddress.
         * @return Builder
         */
        public Builder prePopulateShippingAddress(Address prePopulateShippingAddress) {
            this.prePopulateShippingAddress = prePopulateShippingAddress;
            return this;
        }

        /**
         * Setter for redirectUrl.
         * @param redirectUrl String value for redirectUrl.
         * @return Builder
         */
        public Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        /**
         * Setter for additionalRecipients.
         * @param additionalRecipients List of ChargeRequestAdditionalRecipient value for additionalRecipients.
         * @return Builder
         */
        public Builder additionalRecipients(List<ChargeRequestAdditionalRecipient> additionalRecipients) {
            this.additionalRecipients = additionalRecipients;
            return this;
        }

        /**
         * Setter for note.
         * @param note String value for note.
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
            return new CreateCheckoutRequest(idempotencyKey,
                order,
                askForShippingAddress,
                merchantSupportEmail,
                prePopulateBuyerEmail,
                prePopulateShippingAddress,
                redirectUrl,
                additionalRecipients,
                note);
        }
    }
}

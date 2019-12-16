package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateCheckoutRequest {

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

    private final String idempotencyKey;
    private final CreateOrderRequest order;
    private final Boolean askForShippingAddress;
    private final String merchantSupportEmail;
    private final String prePopulateBuyerEmail;
    private final Address prePopulateShippingAddress;
    private final String redirectUrl;
    private final List<ChargeRequestAdditionalRecipient> additionalRecipients;
    private final String note;

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, order, askForShippingAddress, merchantSupportEmail, prePopulateBuyerEmail, prePopulateShippingAddress, redirectUrl, additionalRecipients, note);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateCheckoutRequest)) {
            return false;
        }
        CreateCheckoutRequest createCheckoutRequest = (CreateCheckoutRequest) o;
        return Objects.equals(idempotencyKey, createCheckoutRequest.idempotencyKey) &&
            Objects.equals(order, createCheckoutRequest.order) &&
            Objects.equals(askForShippingAddress, createCheckoutRequest.askForShippingAddress) &&
            Objects.equals(merchantSupportEmail, createCheckoutRequest.merchantSupportEmail) &&
            Objects.equals(prePopulateBuyerEmail, createCheckoutRequest.prePopulateBuyerEmail) &&
            Objects.equals(prePopulateShippingAddress, createCheckoutRequest.prePopulateShippingAddress) &&
            Objects.equals(redirectUrl, createCheckoutRequest.redirectUrl) &&
            Objects.equals(additionalRecipients, createCheckoutRequest.additionalRecipients) &&
            Objects.equals(note, createCheckoutRequest.note);
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this checkout among others
     * you've created. It can be any valid string but must be unique for every
     * order sent to Square Checkout for a given location ID.
     * The idempotency key is used to avoid processing the same order more than
     * once. If you're unsure whether a particular checkout was created
     * successfully, you can reattempt it with the same idempotency key and all the
     * same other parameters without worrying about creating duplicates.
     * We recommend using a random number/string generator native to the language
     * you are working in to generate strings for your idempotency keys.
     * See [Idempotency keys](#idempotencykeys) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() { 
        return this.idempotencyKey;
    }

    /**
     * Getter for Order.
     */
    @JsonGetter("order")
    public CreateOrderRequest getOrder() { 
        return this.order;
    }

    /**
     * Getter for AskForShippingAddress.
     * If `true`, Square Checkout will collect shipping information on your
     * behalf and store that information with the transaction information in your
     * Square Dashboard.
     * Default: `false`.
     */
    @JsonGetter("ask_for_shipping_address")
    public Boolean getAskForShippingAddress() { 
        return this.askForShippingAddress;
    }

    /**
     * Getter for MerchantSupportEmail.
     * The email address to display on the Square Checkout confirmation page
     * and confirmation email that the buyer can use to contact the merchant.
     * If this value is not set, the confirmation page and email will display the
     * primary email address associated with the merchant's Square account.
     * Default: none; only exists if explicitly set.
     */
    @JsonGetter("merchant_support_email")
    public String getMerchantSupportEmail() { 
        return this.merchantSupportEmail;
    }

    /**
     * Getter for PrePopulateBuyerEmail.
     * If provided, the buyer's email is pre-populated on the checkout page
     * as an editable text field.
     * Default: none; only exists if explicitly set.
     */
    @JsonGetter("pre_populate_buyer_email")
    public String getPrePopulateBuyerEmail() { 
        return this.prePopulateBuyerEmail;
    }

    /**
     * Getter for PrePopulateShippingAddress.
     * Represents a physical address.
     */
    @JsonGetter("pre_populate_shipping_address")
    public Address getPrePopulateShippingAddress() { 
        return this.prePopulateShippingAddress;
    }

    /**
     * Getter for RedirectUrl.
     * The URL to redirect to after checkout is completed with `checkoutId`,
     * Square's `orderId`, `transactionId`, and `referenceId` appended as URL
     * parameters. For example, if the provided redirect_url is
     * `http://www.example.com/order-complete`, a successful transaction redirects
     * the customer to:
     * `http://www.example.com/order-complete?checkoutId=xxxxxx&orderId=xxxxxx&referenceId=xxxxxx&transactionId=xxxxxx`
     * If you do not provide a redirect URL, Square Checkout will display an order
     * confirmation page on your behalf; however Square strongly recommends that
     * you provide a redirect URL so you can verify the transaction results and
     * finalize the order through your existing/normal confirmation workflow.
     * Default: none; only exists if explicitly set.
     */
    @JsonGetter("redirect_url")
    public String getRedirectUrl() { 
        return this.redirectUrl;
    }

    /**
     * Getter for AdditionalRecipients.
     * The basic primitive of multi-party transaction. The value is optional.
     * The transaction facilitated by you can be split from here.
     * If you provide this value, the `amount_money` value in your additional_recipients
     * must not be more than 90% of the `total_money` calculated by Square for your order.
     * The `location_id` must be the valid location of the app owner merchant.
     * This field requires `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission.
     * This field is currently not supported in sandbox.
     */
    @JsonGetter("additional_recipients")
    public List<ChargeRequestAdditionalRecipient> getAdditionalRecipients() { 
        return this.additionalRecipients;
    }

    /**
     * Getter for Note.
     * An optional note to associate with the checkout object.
     * This value cannot exceed 60 characters.
     */
    @JsonGetter("note")
    public String getNote() { 
        return this.note;
    }

 
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

        public Builder(String idempotencyKey,
                CreateOrderRequest order) {
            this.idempotencyKey = idempotencyKey;
            this.order = order;
        }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder order(CreateOrderRequest value) {
            order = value;
            return this;
        }
        public Builder askForShippingAddress(Boolean value) {
            askForShippingAddress = value;
            return this;
        }
        public Builder merchantSupportEmail(String value) {
            merchantSupportEmail = value;
            return this;
        }
        public Builder prePopulateBuyerEmail(String value) {
            prePopulateBuyerEmail = value;
            return this;
        }
        public Builder prePopulateShippingAddress(Address value) {
            prePopulateShippingAddress = value;
            return this;
        }
        public Builder redirectUrl(String value) {
            redirectUrl = value;
            return this;
        }
        public Builder additionalRecipients(List<ChargeRequestAdditionalRecipient> value) {
            additionalRecipients = value;
            return this;
        }
        public Builder note(String value) {
            note = value;
            return this;
        }

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

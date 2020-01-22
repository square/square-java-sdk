package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ChargeRequest type.
 */
public class ChargeRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param amountMoney
     * @param cardNonce
     * @param customerCardId
     * @param delayCapture
     * @param referenceId
     * @param note
     * @param customerId
     * @param billingAddress
     * @param shippingAddress
     * @param buyerEmailAddress
     * @param orderId
     * @param additionalRecipients
     * @param verificationToken
     */
    @JsonCreator
    public ChargeRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("card_nonce") String cardNonce,
            @JsonProperty("customer_card_id") String customerCardId,
            @JsonProperty("delay_capture") Boolean delayCapture,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("note") String note,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("billing_address") Address billingAddress,
            @JsonProperty("shipping_address") Address shippingAddress,
            @JsonProperty("buyer_email_address") String buyerEmailAddress,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("additional_recipients") List<AdditionalRecipient> additionalRecipients,
            @JsonProperty("verification_token") String verificationToken) {
        this.idempotencyKey = idempotencyKey;
        this.amountMoney = amountMoney;
        this.cardNonce = cardNonce;
        this.customerCardId = customerCardId;
        this.delayCapture = delayCapture;
        this.referenceId = referenceId;
        this.note = note;
        this.customerId = customerId;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.buyerEmailAddress = buyerEmailAddress;
        this.orderId = orderId;
        this.additionalRecipients = additionalRecipients;
        this.verificationToken = verificationToken;
    }

    private final String idempotencyKey;
    private final Money amountMoney;
    private final String cardNonce;
    private final String customerCardId;
    private final Boolean delayCapture;
    private final String referenceId;
    private final String note;
    private final String customerId;
    private final Address billingAddress;
    private final Address shippingAddress;
    private final String buyerEmailAddress;
    private final String orderId;
    private final List<AdditionalRecipient> additionalRecipients;
    private final String verificationToken;
    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this
     * transaction among transactions you've created.
     * If you're unsure whether a particular transaction succeeded,
     * you can reattempt it with the same idempotency key without
     * worrying about double-charging the buyer.
     * See [Idempotency keys](#idempotencykeys) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return this.amountMoney;
    }

    /**
     * Getter for CardNonce.
     * A nonce generated from the `SqPaymentForm` that represents the card
     * to charge.
     * The application that provides a nonce to this endpoint must be the
     * _same application_ that generated the nonce with the `SqPaymentForm`.
     * Otherwise, the nonce is invalid.
     * Do not provide a value for this field if you provide a value for
     * `customer_card_id`.
     */
    @JsonGetter("card_nonce")
    public String getCardNonce() {
        return this.cardNonce;
    }

    /**
     * Getter for CustomerCardId.
     * The ID of the customer card on file to charge. Do
     * not provide a value for this field if you provide a value for `card_nonce`.
     * If you provide this value, you _must_ also provide a value for
     * `customer_id`.
     */
    @JsonGetter("customer_card_id")
    public String getCustomerCardId() {
        return this.customerCardId;
    }

    /**
     * Getter for DelayCapture.
     * If `true`, the request will only perform an Auth on the provided
     * card. You can then later perform either a Capture (with the
     * [CaptureTransaction](#endpoint-capturetransaction) endpoint) or a Void
     * (with the [VoidTransaction](#endpoint-voidtransaction) endpoint).
     * Default value: `false`
     */
    @JsonGetter("delay_capture")
    public Boolean getDelayCapture() {
        return this.delayCapture;
    }

    /**
     * Getter for ReferenceId.
     * An optional ID you can associate with the transaction for your own
     * purposes (such as to associate the transaction with an entity ID in your
     * own database).
     * This value cannot exceed 40 characters.
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for Note.
     * An optional note to associate with the transaction.
     * This value cannot exceed 60 characters.
     */
    @JsonGetter("note")
    public String getNote() {
        return this.note;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer to associate this transaction with. This field
     * is required if you provide a value for `customer_card_id`, and optional
     * otherwise.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for BillingAddress.
     * Represents a physical address.
     */
    @JsonGetter("billing_address")
    public Address getBillingAddress() {
        return this.billingAddress;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a physical address.
     */
    @JsonGetter("shipping_address")
    public Address getShippingAddress() {
        return this.shippingAddress;
    }

    /**
     * Getter for BuyerEmailAddress.
     * The buyer's email address, if available. This value is optional,
     * but this transaction is ineligible for chargeback protection if it is not
     * provided.
     */
    @JsonGetter("buyer_email_address")
    public String getBuyerEmailAddress() {
        return this.buyerEmailAddress;
    }

    /**
     * Getter for OrderId.
     * The ID of the order to associate with this transaction.
     * If you provide this value, the `amount_money` value of your request must
     * __exactly match__ the value of the order's `total_money` field.
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Getter for AdditionalRecipients.
     * The basic primitive of multi-party transaction. The value is optional.
     * The transaction facilitated by you can be split from here.
     * If you provide this value, the `amount_money` value in your additional_recipients
     * must not be more than 90% of the `amount_money` value in the charge request.
     * The `location_id` must be the valid location of the app owner merchant.
     * This field requires the `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission.
     * This field is currently not supported in sandbox.
     */
    @JsonGetter("additional_recipients")
    public List<AdditionalRecipient> getAdditionalRecipients() {
        return this.additionalRecipients;
    }

    /**
     * Getter for VerificationToken.
     * A token generated by SqPaymentForm's verifyBuyer() that represents
     * customer's device info and 3ds challenge result.
     */
    @JsonGetter("verification_token")
    public String getVerificationToken() {
        return this.verificationToken;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, amountMoney, cardNonce, customerCardId, delayCapture,
            referenceId, note, customerId, billingAddress, shippingAddress, buyerEmailAddress,
            orderId, additionalRecipients, verificationToken);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ChargeRequest)) {
            return false;
        }
        ChargeRequest chargeRequest = (ChargeRequest) obj;
        return Objects.equals(idempotencyKey, chargeRequest.idempotencyKey) &&
            Objects.equals(amountMoney, chargeRequest.amountMoney) &&
            Objects.equals(cardNonce, chargeRequest.cardNonce) &&
            Objects.equals(customerCardId, chargeRequest.customerCardId) &&
            Objects.equals(delayCapture, chargeRequest.delayCapture) &&
            Objects.equals(referenceId, chargeRequest.referenceId) &&
            Objects.equals(note, chargeRequest.note) &&
            Objects.equals(customerId, chargeRequest.customerId) &&
            Objects.equals(billingAddress, chargeRequest.billingAddress) &&
            Objects.equals(shippingAddress, chargeRequest.shippingAddress) &&
            Objects.equals(buyerEmailAddress, chargeRequest.buyerEmailAddress) &&
            Objects.equals(orderId, chargeRequest.orderId) &&
            Objects.equals(additionalRecipients, chargeRequest.additionalRecipients) &&
            Objects.equals(verificationToken, chargeRequest.verificationToken);
    }

    /**
     * Builds a new {@link ChargeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ChargeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            amountMoney)
            .cardNonce(getCardNonce())
            .customerCardId(getCustomerCardId())
            .delayCapture(getDelayCapture())
            .referenceId(getReferenceId())
            .note(getNote())
            .customerId(getCustomerId())
            .billingAddress(getBillingAddress())
            .shippingAddress(getShippingAddress())
            .buyerEmailAddress(getBuyerEmailAddress())
            .orderId(getOrderId())
            .additionalRecipients(getAdditionalRecipients())
            .verificationToken(getVerificationToken());
            return builder;
    }

    /**
     * Class to build instances of {@link ChargeRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private Money amountMoney;
        private String cardNonce;
        private String customerCardId;
        private Boolean delayCapture;
        private String referenceId;
        private String note;
        private String customerId;
        private Address billingAddress;
        private Address shippingAddress;
        private String buyerEmailAddress;
        private String orderId;
        private List<AdditionalRecipient> additionalRecipients;
        private String verificationToken;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey,
                Money amountMoney) {
            this.idempotencyKey = idempotencyKey;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for amountMoney
         * @param amountMoney
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }
        /**
         * Setter for cardNonce
         * @param cardNonce
         * @return Builder
         */
        public Builder cardNonce(String cardNonce) {
            this.cardNonce = cardNonce;
            return this;
        }
        /**
         * Setter for customerCardId
         * @param customerCardId
         * @return Builder
         */
        public Builder customerCardId(String customerCardId) {
            this.customerCardId = customerCardId;
            return this;
        }
        /**
         * Setter for delayCapture
         * @param delayCapture
         * @return Builder
         */
        public Builder delayCapture(Boolean delayCapture) {
            this.delayCapture = delayCapture;
            return this;
        }
        /**
         * Setter for referenceId
         * @param referenceId
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }
        /**
         * Setter for note
         * @param note
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }
        /**
         * Setter for customerId
         * @param customerId
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }
        /**
         * Setter for billingAddress
         * @param billingAddress
         * @return Builder
         */
        public Builder billingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }
        /**
         * Setter for shippingAddress
         * @param shippingAddress
         * @return Builder
         */
        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }
        /**
         * Setter for buyerEmailAddress
         * @param buyerEmailAddress
         * @return Builder
         */
        public Builder buyerEmailAddress(String buyerEmailAddress) {
            this.buyerEmailAddress = buyerEmailAddress;
            return this;
        }
        /**
         * Setter for orderId
         * @param orderId
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }
        /**
         * Setter for additionalRecipients
         * @param additionalRecipients
         * @return Builder
         */
        public Builder additionalRecipients(List<AdditionalRecipient> additionalRecipients) {
            this.additionalRecipients = additionalRecipients;
            return this;
        }
        /**
         * Setter for verificationToken
         * @param verificationToken
         * @return Builder
         */
        public Builder verificationToken(String verificationToken) {
            this.verificationToken = verificationToken;
            return this;
        }

        /**
         * Builds a new {@link ChargeRequest} object using the set fields.
         * @return {@link ChargeRequest}
         */
        public ChargeRequest build() {
            return new ChargeRequest(idempotencyKey,
                amountMoney,
                cardNonce,
                customerCardId,
                delayCapture,
                referenceId,
                note,
                customerId,
                billingAddress,
                shippingAddress,
                buyerEmailAddress,
                orderId,
                additionalRecipients,
                verificationToken);
        }
    }
}

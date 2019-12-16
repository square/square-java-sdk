package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ChargeRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, amountMoney, cardNonce, customerCardId, delayCapture, referenceId, note, customerId, billingAddress, shippingAddress, buyerEmailAddress, orderId, additionalRecipients, verificationToken);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChargeRequest)) {
            return false;
        }
        ChargeRequest chargeRequest = (ChargeRequest) o;
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

        public Builder(String idempotencyKey,
                Money amountMoney) {
            this.idempotencyKey = idempotencyKey;
            this.amountMoney = amountMoney;
        }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder cardNonce(String value) {
            cardNonce = value;
            return this;
        }
        public Builder customerCardId(String value) {
            customerCardId = value;
            return this;
        }
        public Builder delayCapture(Boolean value) {
            delayCapture = value;
            return this;
        }
        public Builder referenceId(String value) {
            referenceId = value;
            return this;
        }
        public Builder note(String value) {
            note = value;
            return this;
        }
        public Builder customerId(String value) {
            customerId = value;
            return this;
        }
        public Builder billingAddress(Address value) {
            billingAddress = value;
            return this;
        }
        public Builder shippingAddress(Address value) {
            shippingAddress = value;
            return this;
        }
        public Builder buyerEmailAddress(String value) {
            buyerEmailAddress = value;
            return this;
        }
        public Builder orderId(String value) {
            orderId = value;
            return this;
        }
        public Builder additionalRecipients(List<AdditionalRecipient> value) {
            additionalRecipients = value;
            return this;
        }
        public Builder verificationToken(String value) {
            verificationToken = value;
            return this;
        }

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

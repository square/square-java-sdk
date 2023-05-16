
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
 * This is a model class for ChargeRequest type.
 */
public class ChargeRequest {
    private final String idempotencyKey;
    private final Money amountMoney;
    private final OptionalNullable<String> cardNonce;
    private final OptionalNullable<String> customerCardId;
    private final OptionalNullable<Boolean> delayCapture;
    private final OptionalNullable<String> referenceId;
    private final OptionalNullable<String> note;
    private final OptionalNullable<String> customerId;
    private final Address billingAddress;
    private final Address shippingAddress;
    private final OptionalNullable<String> buyerEmailAddress;
    private final OptionalNullable<String> orderId;
    private final OptionalNullable<List<ChargeRequestAdditionalRecipient>> additionalRecipients;
    private final OptionalNullable<String> verificationToken;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  amountMoney  Money value for amountMoney.
     * @param  cardNonce  String value for cardNonce.
     * @param  customerCardId  String value for customerCardId.
     * @param  delayCapture  Boolean value for delayCapture.
     * @param  referenceId  String value for referenceId.
     * @param  note  String value for note.
     * @param  customerId  String value for customerId.
     * @param  billingAddress  Address value for billingAddress.
     * @param  shippingAddress  Address value for shippingAddress.
     * @param  buyerEmailAddress  String value for buyerEmailAddress.
     * @param  orderId  String value for orderId.
     * @param  additionalRecipients  List of ChargeRequestAdditionalRecipient value for
     *         additionalRecipients.
     * @param  verificationToken  String value for verificationToken.
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
            @JsonProperty("additional_recipients") List<ChargeRequestAdditionalRecipient> additionalRecipients,
            @JsonProperty("verification_token") String verificationToken) {
        this.idempotencyKey = idempotencyKey;
        this.amountMoney = amountMoney;
        this.cardNonce = OptionalNullable.of(cardNonce);
        this.customerCardId = OptionalNullable.of(customerCardId);
        this.delayCapture = OptionalNullable.of(delayCapture);
        this.referenceId = OptionalNullable.of(referenceId);
        this.note = OptionalNullable.of(note);
        this.customerId = OptionalNullable.of(customerId);
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.buyerEmailAddress = OptionalNullable.of(buyerEmailAddress);
        this.orderId = OptionalNullable.of(orderId);
        this.additionalRecipients = OptionalNullable.of(additionalRecipients);
        this.verificationToken = OptionalNullable.of(verificationToken);
    }

    /**
     * Internal initialization constructor.
     */
    protected ChargeRequest(String idempotencyKey, Money amountMoney,
            OptionalNullable<String> cardNonce, OptionalNullable<String> customerCardId,
            OptionalNullable<Boolean> delayCapture, OptionalNullable<String> referenceId,
            OptionalNullable<String> note, OptionalNullable<String> customerId,
            Address billingAddress, Address shippingAddress,
            OptionalNullable<String> buyerEmailAddress, OptionalNullable<String> orderId,
            OptionalNullable<List<ChargeRequestAdditionalRecipient>> additionalRecipients,
            OptionalNullable<String> verificationToken) {
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

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this transaction among transactions you've
     * created. If you're unsure whether a particular transaction succeeded, you can reattempt it
     * with the same idempotency key without worrying about double-charging the buyer. See
     * [Idempotency keys](https://developer.squareup.com/docs/working-with-apis/idempotency) for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Internal Getter for CardNonce.
     * A payment token generated from the
     * [Card.tokenize()](https://developer.squareup.com/reference/sdks/web/payments/objects/Card#Card.tokenize)
     * that represents the card to charge. The application that provides a payment token to this
     * endpoint must be the _same application_ that generated the payment token with the Web
     * Payments SDK. Otherwise, the nonce is invalid. Do not provide a value for this field if you
     * provide a value for `customer_card_id`.
     * @return Returns the Internal String
     */
    @JsonGetter("card_nonce")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCardNonce() {
        return this.cardNonce;
    }

    /**
     * Getter for CardNonce.
     * A payment token generated from the
     * [Card.tokenize()](https://developer.squareup.com/reference/sdks/web/payments/objects/Card#Card.tokenize)
     * that represents the card to charge. The application that provides a payment token to this
     * endpoint must be the _same application_ that generated the payment token with the Web
     * Payments SDK. Otherwise, the nonce is invalid. Do not provide a value for this field if you
     * provide a value for `customer_card_id`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCardNonce() {
        return OptionalNullable.getFrom(cardNonce);
    }

    /**
     * Internal Getter for CustomerCardId.
     * The ID of the customer card on file to charge. Do not provide a value for this field if you
     * provide a value for `card_nonce`. If you provide this value, you _must_ also provide a value
     * for `customer_id`.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_card_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerCardId() {
        return this.customerCardId;
    }

    /**
     * Getter for CustomerCardId.
     * The ID of the customer card on file to charge. Do not provide a value for this field if you
     * provide a value for `card_nonce`. If you provide this value, you _must_ also provide a value
     * for `customer_id`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerCardId() {
        return OptionalNullable.getFrom(customerCardId);
    }

    /**
     * Internal Getter for DelayCapture.
     * If `true`, the request will only perform an Auth on the provided card. You can then later
     * perform either a Capture (with the
     * [CaptureTransaction](api-endpoint:Transactions-CaptureTransaction) endpoint) or a Void (with
     * the [VoidTransaction](api-endpoint:Transactions-VoidTransaction) endpoint). Default value:
     * `false`
     * @return Returns the Internal Boolean
     */
    @JsonGetter("delay_capture")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetDelayCapture() {
        return this.delayCapture;
    }

    /**
     * Getter for DelayCapture.
     * If `true`, the request will only perform an Auth on the provided card. You can then later
     * perform either a Capture (with the
     * [CaptureTransaction](api-endpoint:Transactions-CaptureTransaction) endpoint) or a Void (with
     * the [VoidTransaction](api-endpoint:Transactions-VoidTransaction) endpoint). Default value:
     * `false`
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getDelayCapture() {
        return OptionalNullable.getFrom(delayCapture);
    }

    /**
     * Internal Getter for ReferenceId.
     * An optional ID you can associate with the transaction for your own purposes (such as to
     * associate the transaction with an entity ID in your own database). This value cannot exceed
     * 40 characters.
     * @return Returns the Internal String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for ReferenceId.
     * An optional ID you can associate with the transaction for your own purposes (such as to
     * associate the transaction with an entity ID in your own database). This value cannot exceed
     * 40 characters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
    }

    /**
     * Internal Getter for Note.
     * An optional note to associate with the transaction. This value cannot exceed 60 characters.
     * @return Returns the Internal String
     */
    @JsonGetter("note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNote() {
        return this.note;
    }

    /**
     * Getter for Note.
     * An optional note to associate with the transaction. This value cannot exceed 60 characters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
    }

    /**
     * Internal Getter for CustomerId.
     * The ID of the customer to associate this transaction with. This field is required if you
     * provide a value for `customer_card_id`, and optional otherwise.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer to associate this transaction with. This field is required if you
     * provide a value for `customer_card_id`, and optional otherwise.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
    }

    /**
     * Getter for BillingAddress.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("billing_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("shipping_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Internal Getter for BuyerEmailAddress.
     * The buyer's email address, if available. This value is optional, but this transaction is
     * ineligible for chargeback protection if it is not provided.
     * @return Returns the Internal String
     */
    @JsonGetter("buyer_email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBuyerEmailAddress() {
        return this.buyerEmailAddress;
    }

    /**
     * Getter for BuyerEmailAddress.
     * The buyer's email address, if available. This value is optional, but this transaction is
     * ineligible for chargeback protection if it is not provided.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBuyerEmailAddress() {
        return OptionalNullable.getFrom(buyerEmailAddress);
    }

    /**
     * Internal Getter for OrderId.
     * The ID of the order to associate with this transaction. If you provide this value, the
     * `amount_money` value of your request must __exactly match__ the value of the order's
     * `total_money` field.
     * @return Returns the Internal String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOrderId() {
        return this.orderId;
    }

    /**
     * Getter for OrderId.
     * The ID of the order to associate with this transaction. If you provide this value, the
     * `amount_money` value of your request must __exactly match__ the value of the order's
     * `total_money` field.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderId() {
        return OptionalNullable.getFrom(orderId);
    }

    /**
     * Internal Getter for AdditionalRecipients.
     * The basic primitive of multi-party transaction. The value is optional. The transaction
     * facilitated by you can be split from here. If you provide this value, the `amount_money`
     * value in your additional_recipients must not be more than 90% of the `amount_money` value in
     * the charge request. The `location_id` must be the valid location of the app owner merchant.
     * This field requires the `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission. This field
     * is currently not supported in sandbox.
     * @return Returns the Internal List of ChargeRequestAdditionalRecipient
     */
    @JsonGetter("additional_recipients")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<ChargeRequestAdditionalRecipient>> internalGetAdditionalRecipients() {
        return this.additionalRecipients;
    }

    /**
     * Getter for AdditionalRecipients.
     * The basic primitive of multi-party transaction. The value is optional. The transaction
     * facilitated by you can be split from here. If you provide this value, the `amount_money`
     * value in your additional_recipients must not be more than 90% of the `amount_money` value in
     * the charge request. The `location_id` must be the valid location of the app owner merchant.
     * This field requires the `PAYMENTS_WRITE_ADDITIONAL_RECIPIENTS` OAuth permission. This field
     * is currently not supported in sandbox.
     * @return Returns the List of ChargeRequestAdditionalRecipient
     */
    @JsonIgnore
    public List<ChargeRequestAdditionalRecipient> getAdditionalRecipients() {
        return OptionalNullable.getFrom(additionalRecipients);
    }

    /**
     * Internal Getter for VerificationToken.
     * A token generated by SqPaymentForm's verifyBuyer() that represents customer's device info and
     * 3ds challenge result.
     * @return Returns the Internal String
     */
    @JsonGetter("verification_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetVerificationToken() {
        return this.verificationToken;
    }

    /**
     * Getter for VerificationToken.
     * A token generated by SqPaymentForm's verifyBuyer() that represents customer's device info and
     * 3ds challenge result.
     * @return Returns the String
     */
    @JsonIgnore
    public String getVerificationToken() {
        return OptionalNullable.getFrom(verificationToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, amountMoney, cardNonce, customerCardId, delayCapture,
                referenceId, note, customerId, billingAddress, shippingAddress, buyerEmailAddress,
                orderId, additionalRecipients, verificationToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChargeRequest)) {
            return false;
        }
        ChargeRequest other = (ChargeRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(cardNonce, other.cardNonce)
            && Objects.equals(customerCardId, other.customerCardId)
            && Objects.equals(delayCapture, other.delayCapture)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(note, other.note)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(billingAddress, other.billingAddress)
            && Objects.equals(shippingAddress, other.shippingAddress)
            && Objects.equals(buyerEmailAddress, other.buyerEmailAddress)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(additionalRecipients, other.additionalRecipients)
            && Objects.equals(verificationToken, other.verificationToken);
    }

    /**
     * Converts this ChargeRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ChargeRequest [" + "idempotencyKey=" + idempotencyKey + ", amountMoney="
                + amountMoney + ", cardNonce=" + cardNonce + ", customerCardId=" + customerCardId
                + ", delayCapture=" + delayCapture + ", referenceId=" + referenceId + ", note="
                + note + ", customerId=" + customerId + ", billingAddress=" + billingAddress
                + ", shippingAddress=" + shippingAddress + ", buyerEmailAddress="
                + buyerEmailAddress + ", orderId=" + orderId + ", additionalRecipients="
                + additionalRecipients + ", verificationToken=" + verificationToken + "]";
    }

    /**
     * Builds a new {@link ChargeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ChargeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, amountMoney)
                .billingAddress(getBillingAddress())
                .shippingAddress(getShippingAddress());
        builder.cardNonce = internalGetCardNonce();
        builder.customerCardId = internalGetCustomerCardId();
        builder.delayCapture = internalGetDelayCapture();
        builder.referenceId = internalGetReferenceId();
        builder.note = internalGetNote();
        builder.customerId = internalGetCustomerId();
        builder.buyerEmailAddress = internalGetBuyerEmailAddress();
        builder.orderId = internalGetOrderId();
        builder.additionalRecipients = internalGetAdditionalRecipients();
        builder.verificationToken = internalGetVerificationToken();
        return builder;
    }

    /**
     * Class to build instances of {@link ChargeRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private Money amountMoney;
        private OptionalNullable<String> cardNonce;
        private OptionalNullable<String> customerCardId;
        private OptionalNullable<Boolean> delayCapture;
        private OptionalNullable<String> referenceId;
        private OptionalNullable<String> note;
        private OptionalNullable<String> customerId;
        private Address billingAddress;
        private Address shippingAddress;
        private OptionalNullable<String> buyerEmailAddress;
        private OptionalNullable<String> orderId;
        private OptionalNullable<List<ChargeRequestAdditionalRecipient>> additionalRecipients;
        private OptionalNullable<String> verificationToken;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String idempotencyKey, Money amountMoney) {
            this.idempotencyKey = idempotencyKey;
            this.amountMoney = amountMoney;
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
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for cardNonce.
         * @param  cardNonce  String value for cardNonce.
         * @return Builder
         */
        public Builder cardNonce(String cardNonce) {
            this.cardNonce = OptionalNullable.of(cardNonce);
            return this;
        }

        /**
         * UnSetter for cardNonce.
         * @return Builder
         */
        public Builder unsetCardNonce() {
            cardNonce = null;
            return this;
        }

        /**
         * Setter for customerCardId.
         * @param  customerCardId  String value for customerCardId.
         * @return Builder
         */
        public Builder customerCardId(String customerCardId) {
            this.customerCardId = OptionalNullable.of(customerCardId);
            return this;
        }

        /**
         * UnSetter for customerCardId.
         * @return Builder
         */
        public Builder unsetCustomerCardId() {
            customerCardId = null;
            return this;
        }

        /**
         * Setter for delayCapture.
         * @param  delayCapture  Boolean value for delayCapture.
         * @return Builder
         */
        public Builder delayCapture(Boolean delayCapture) {
            this.delayCapture = OptionalNullable.of(delayCapture);
            return this;
        }

        /**
         * UnSetter for delayCapture.
         * @return Builder
         */
        public Builder unsetDelayCapture() {
            delayCapture = null;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = OptionalNullable.of(referenceId);
            return this;
        }

        /**
         * UnSetter for referenceId.
         * @return Builder
         */
        public Builder unsetReferenceId() {
            referenceId = null;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = OptionalNullable.of(note);
            return this;
        }

        /**
         * UnSetter for note.
         * @return Builder
         */
        public Builder unsetNote() {
            note = null;
            return this;
        }

        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = OptionalNullable.of(customerId);
            return this;
        }

        /**
         * UnSetter for customerId.
         * @return Builder
         */
        public Builder unsetCustomerId() {
            customerId = null;
            return this;
        }

        /**
         * Setter for billingAddress.
         * @param  billingAddress  Address value for billingAddress.
         * @return Builder
         */
        public Builder billingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        /**
         * Setter for shippingAddress.
         * @param  shippingAddress  Address value for shippingAddress.
         * @return Builder
         */
        public Builder shippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        /**
         * Setter for buyerEmailAddress.
         * @param  buyerEmailAddress  String value for buyerEmailAddress.
         * @return Builder
         */
        public Builder buyerEmailAddress(String buyerEmailAddress) {
            this.buyerEmailAddress = OptionalNullable.of(buyerEmailAddress);
            return this;
        }

        /**
         * UnSetter for buyerEmailAddress.
         * @return Builder
         */
        public Builder unsetBuyerEmailAddress() {
            buyerEmailAddress = null;
            return this;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = OptionalNullable.of(orderId);
            return this;
        }

        /**
         * UnSetter for orderId.
         * @return Builder
         */
        public Builder unsetOrderId() {
            orderId = null;
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
         * Setter for verificationToken.
         * @param  verificationToken  String value for verificationToken.
         * @return Builder
         */
        public Builder verificationToken(String verificationToken) {
            this.verificationToken = OptionalNullable.of(verificationToken);
            return this;
        }

        /**
         * UnSetter for verificationToken.
         * @return Builder
         */
        public Builder unsetVerificationToken() {
            verificationToken = null;
            return this;
        }

        /**
         * Builds a new {@link ChargeRequest} object using the set fields.
         * @return {@link ChargeRequest}
         */
        public ChargeRequest build() {
            return new ChargeRequest(idempotencyKey, amountMoney, cardNonce, customerCardId,
                    delayCapture, referenceId, note, customerId, billingAddress, shippingAddress,
                    buyerEmailAddress, orderId, additionalRecipients, verificationToken);
        }
    }
}

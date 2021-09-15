
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ChargeRequest type.
 */
public class ChargeRequest {
    private final String idempotencyKey;
    private final Money amountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cardNonce;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerCardId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean delayCapture;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String referenceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address billingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address shippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String buyerEmailAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String orderId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<ChargeRequestAdditionalRecipient> additionalRecipients;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String verificationToken;

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
     * Getter for CardNonce.
     * A payment token generated from the
     * [Card.tokenize()](https://developer.squareup.com/reference/sdks/web/payments/objects/Card#Card.tokenize)
     * that represents the card to charge. The application that provides a payment token to this
     * endpoint must be the _same application_ that generated the payment token with the Web
     * Payments SDK. Otherwise, the nonce is invalid. Do not provide a value for this field if you
     * provide a value for `customer_card_id`.
     * @return Returns the String
     */
    @JsonGetter("card_nonce")
    public String getCardNonce() {
        return cardNonce;
    }

    /**
     * Getter for CustomerCardId.
     * The ID of the customer card on file to charge. Do not provide a value for this field if you
     * provide a value for `card_nonce`. If you provide this value, you _must_ also provide a value
     * for `customer_id`.
     * @return Returns the String
     */
    @JsonGetter("customer_card_id")
    public String getCustomerCardId() {
        return customerCardId;
    }

    /**
     * Getter for DelayCapture.
     * If `true`, the request will only perform an Auth on the provided card. You can then later
     * perform either a Capture (with the [CaptureTransaction]($e/Transactions/CaptureTransaction)
     * endpoint) or a Void (with the [VoidTransaction]($e/Transactions/VoidTransaction) endpoint).
     * Default value: `false`
     * @return Returns the Boolean
     */
    @JsonGetter("delay_capture")
    public Boolean getDelayCapture() {
        return delayCapture;
    }

    /**
     * Getter for ReferenceId.
     * An optional ID you can associate with the transaction for your own purposes (such as to
     * associate the transaction with an entity ID in your own database). This value cannot exceed
     * 40 characters.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for Note.
     * An optional note to associate with the transaction. This value cannot exceed 60 characters.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return note;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer to associate this transaction with. This field is required if you
     * provide a value for `customer_card_id`, and optional otherwise.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for BillingAddress.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("billing_address")
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Getter for ShippingAddress.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("shipping_address")
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Getter for BuyerEmailAddress.
     * The buyer's email address, if available. This value is optional, but this transaction is
     * ineligible for chargeback protection if it is not provided.
     * @return Returns the String
     */
    @JsonGetter("buyer_email_address")
    public String getBuyerEmailAddress() {
        return buyerEmailAddress;
    }

    /**
     * Getter for OrderId.
     * The ID of the order to associate with this transaction. If you provide this value, the
     * `amount_money` value of your request must __exactly match__ the value of the order's
     * `total_money` field.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
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
    @JsonGetter("additional_recipients")
    public List<ChargeRequestAdditionalRecipient> getAdditionalRecipients() {
        return additionalRecipients;
    }

    /**
     * Getter for VerificationToken.
     * A token generated by SqPaymentForm's verifyBuyer() that represents customer's device info and
     * 3ds challenge result.
     * @return Returns the String
     */
    @JsonGetter("verification_token")
    public String getVerificationToken() {
        return verificationToken;
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
     * Class to build instances of {@link ChargeRequest}.
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
        private List<ChargeRequestAdditionalRecipient> additionalRecipients;
        private String verificationToken;

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
            this.cardNonce = cardNonce;
            return this;
        }

        /**
         * Setter for customerCardId.
         * @param  customerCardId  String value for customerCardId.
         * @return Builder
         */
        public Builder customerCardId(String customerCardId) {
            this.customerCardId = customerCardId;
            return this;
        }

        /**
         * Setter for delayCapture.
         * @param  delayCapture  Boolean value for delayCapture.
         * @return Builder
         */
        public Builder delayCapture(Boolean delayCapture) {
            this.delayCapture = delayCapture;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
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
            this.buyerEmailAddress = buyerEmailAddress;
            return this;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
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
         * Setter for verificationToken.
         * @param  verificationToken  String value for verificationToken.
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
            return new ChargeRequest(idempotencyKey, amountMoney, cardNonce, customerCardId,
                    delayCapture, referenceId, note, customerId, billingAddress, shippingAddress,
                    buyerEmailAddress, orderId, additionalRecipients, verificationToken);
        }
    }
}

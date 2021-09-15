
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreatePaymentRequest type.
 */
public class CreatePaymentRequest {
    private final String sourceId;
    private final String idempotencyKey;
    private final Money amountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money tipMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money appFeeMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String delayDuration;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean autocomplete;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String orderId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String referenceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String verificationToken;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean acceptPartialAuthorization;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String buyerEmailAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address billingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address shippingAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String statementDescriptionIdentifier;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CashPaymentDetails cashDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final ExternalPaymentDetails externalDetails;

    /**
     * Initialization constructor.
     * @param  sourceId  String value for sourceId.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  amountMoney  Money value for amountMoney.
     * @param  tipMoney  Money value for tipMoney.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  delayDuration  String value for delayDuration.
     * @param  autocomplete  Boolean value for autocomplete.
     * @param  orderId  String value for orderId.
     * @param  customerId  String value for customerId.
     * @param  locationId  String value for locationId.
     * @param  referenceId  String value for referenceId.
     * @param  verificationToken  String value for verificationToken.
     * @param  acceptPartialAuthorization  Boolean value for acceptPartialAuthorization.
     * @param  buyerEmailAddress  String value for buyerEmailAddress.
     * @param  billingAddress  Address value for billingAddress.
     * @param  shippingAddress  Address value for shippingAddress.
     * @param  note  String value for note.
     * @param  statementDescriptionIdentifier  String value for statementDescriptionIdentifier.
     * @param  cashDetails  CashPaymentDetails value for cashDetails.
     * @param  externalDetails  ExternalPaymentDetails value for externalDetails.
     */
    @JsonCreator
    public CreatePaymentRequest(
            @JsonProperty("source_id") String sourceId,
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("tip_money") Money tipMoney,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("delay_duration") String delayDuration,
            @JsonProperty("autocomplete") Boolean autocomplete,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("verification_token") String verificationToken,
            @JsonProperty("accept_partial_authorization") Boolean acceptPartialAuthorization,
            @JsonProperty("buyer_email_address") String buyerEmailAddress,
            @JsonProperty("billing_address") Address billingAddress,
            @JsonProperty("shipping_address") Address shippingAddress,
            @JsonProperty("note") String note,
            @JsonProperty("statement_description_identifier") String statementDescriptionIdentifier,
            @JsonProperty("cash_details") CashPaymentDetails cashDetails,
            @JsonProperty("external_details") ExternalPaymentDetails externalDetails) {
        this.sourceId = sourceId;
        this.idempotencyKey = idempotencyKey;
        this.amountMoney = amountMoney;
        this.tipMoney = tipMoney;
        this.appFeeMoney = appFeeMoney;
        this.delayDuration = delayDuration;
        this.autocomplete = autocomplete;
        this.orderId = orderId;
        this.customerId = customerId;
        this.locationId = locationId;
        this.referenceId = referenceId;
        this.verificationToken = verificationToken;
        this.acceptPartialAuthorization = acceptPartialAuthorization;
        this.buyerEmailAddress = buyerEmailAddress;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.note = note;
        this.statementDescriptionIdentifier = statementDescriptionIdentifier;
        this.cashDetails = cashDetails;
        this.externalDetails = externalDetails;
    }

    /**
     * Getter for SourceId.
     * The ID for the source of funds for this payment. This can be a payment token (card nonce)
     * generated by the Square payment form or a card on file made with the Customers API. If
     * recording a payment that the seller received outside of Square, specify either "CASH" or
     * "EXTERNAL". For more information, see [Take
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments).
     * @return Returns the String
     */
    @JsonGetter("source_id")
    public String getSourceId() {
        return sourceId;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreatePayment` request. Keys can be any valid string
     * but must be unique for every `CreatePayment` request. Max: 45 characters Note: The number of
     * allowed characters might be less than the stated maximum, if multi-byte characters are used.
     * For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
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
     * Getter for TipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("tip_money")
    public Money getTipMoney() {
        return tipMoney;
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
    public Money getAppFeeMoney() {
        return appFeeMoney;
    }

    /**
     * Getter for DelayDuration.
     * The duration of time after the payment's creation when Square automatically cancels the
     * payment. This automatic cancellation applies only to payments that do not reach a terminal
     * state (COMPLETED, CANCELED, or FAILED) before the `delay_duration` time period. This
     * parameter should be specified as a time duration, in RFC 3339 format, with a minimum value of
     * 1 minute. Note: This feature is only supported for card payments. This parameter can only be
     * set for a delayed capture payment (`autocomplete=false`). Default: - Card-present payments:
     * "PT36H" (36 hours) from the creation time. - Card-not-present payments: "P7D" (7 days) from
     * the creation time.
     * @return Returns the String
     */
    @JsonGetter("delay_duration")
    public String getDelayDuration() {
        return delayDuration;
    }

    /**
     * Getter for Autocomplete.
     * If set to `true`, this payment will be completed when possible. If set to `false`, this
     * payment is held in an approved state until either explicitly completed (captured) or canceled
     * (voided). For more information, see [Delayed
     * capture](https://developer.squareup.com/docs/payments-api/take-payments/card-payments#delayed-capture-of-a-card-payment).
     * Default: true
     * @return Returns the Boolean
     */
    @JsonGetter("autocomplete")
    public Boolean getAutocomplete() {
        return autocomplete;
    }

    /**
     * Getter for OrderId.
     * Associates a previously created order with this payment.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for CustomerId.
     * The [Customer]($m/Customer) ID of the customer associated with the payment. This is required
     * if the `source_id` refers to a card on file created using the Customers API.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for LocationId.
     * The location ID to associate with the payment. If not specified, the default location is
     * used.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for ReferenceId.
     * A user-defined ID to associate with the payment. You can use this field to associate the
     * payment to an entity in an external system (for example, you might specify an order ID that
     * is generated by a third-party shopping cart). Limit 40 characters.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for VerificationToken.
     * An identifying token generated by `SqPaymentForm.verifyBuyer()`. Verification tokens
     * encapsulate customer device information and 3-D Secure challenge results to indicate that
     * Square has verified the buyer identity. For more information, see [SCA
     * Overview](https://developer.squareup.com/docs/sca-overview).
     * @return Returns the String
     */
    @JsonGetter("verification_token")
    public String getVerificationToken() {
        return verificationToken;
    }

    /**
     * Getter for AcceptPartialAuthorization.
     * If set to `true` and charging a Square Gift Card, a payment might be returned with
     * `amount_money` equal to less than what was requested. For example, a request for $20 when
     * charging a Square Gift Card with a balance of $5 results in an APPROVED payment of $5. You
     * might choose to prompt the buyer for an additional payment to cover the remainder or cancel
     * the Gift Card payment. This field cannot be `true` when `autocomplete = true`. For more
     * information, see [Partial amount with Square Gift
     * Cards](https://developer.squareup.com/docs/payments-api/take-payments#partial-payment-gift-card).
     * Default: false
     * @return Returns the Boolean
     */
    @JsonGetter("accept_partial_authorization")
    public Boolean getAcceptPartialAuthorization() {
        return acceptPartialAuthorization;
    }

    /**
     * Getter for BuyerEmailAddress.
     * The buyer's email address.
     * @return Returns the String
     */
    @JsonGetter("buyer_email_address")
    public String getBuyerEmailAddress() {
        return buyerEmailAddress;
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
     * Getter for Note.
     * An optional note to be entered by the developer when creating a payment. Limit 500
     * characters.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return note;
    }

    /**
     * Getter for StatementDescriptionIdentifier.
     * Optional additional payment information to include on the customer's card statement as part
     * of the statement description. This can be, for example, an invoice number, ticket number, or
     * short description that uniquely identifies the purchase. Note that the
     * `statement_description_identifier` might get truncated on the statement description to fit
     * the required information including the Square identifier (SQ *) and name of the seller taking
     * the payment.
     * @return Returns the String
     */
    @JsonGetter("statement_description_identifier")
    public String getStatementDescriptionIdentifier() {
        return statementDescriptionIdentifier;
    }

    /**
     * Getter for CashDetails.
     * Stores details about a cash payment. Contains only non-confidential information. For more
     * information, see [Take Cash
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments/cash-payments).
     * @return Returns the CashPaymentDetails
     */
    @JsonGetter("cash_details")
    public CashPaymentDetails getCashDetails() {
        return cashDetails;
    }

    /**
     * Getter for ExternalDetails.
     * Stores details about an external payment. Contains only non-confidential information. For
     * more information, see [Take External
     * Payments](https://developer.squareup.com/docs/payments-api/take-payments/external-payments).
     * @return Returns the ExternalPaymentDetails
     */
    @JsonGetter("external_details")
    public ExternalPaymentDetails getExternalDetails() {
        return externalDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceId, idempotencyKey, amountMoney, tipMoney, appFeeMoney,
                delayDuration, autocomplete, orderId, customerId, locationId, referenceId,
                verificationToken, acceptPartialAuthorization, buyerEmailAddress, billingAddress,
                shippingAddress, note, statementDescriptionIdentifier, cashDetails,
                externalDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreatePaymentRequest)) {
            return false;
        }
        CreatePaymentRequest other = (CreatePaymentRequest) obj;
        return Objects.equals(sourceId, other.sourceId)
            && Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(tipMoney, other.tipMoney)
            && Objects.equals(appFeeMoney, other.appFeeMoney)
            && Objects.equals(delayDuration, other.delayDuration)
            && Objects.equals(autocomplete, other.autocomplete)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(verificationToken, other.verificationToken)
            && Objects.equals(acceptPartialAuthorization, other.acceptPartialAuthorization)
            && Objects.equals(buyerEmailAddress, other.buyerEmailAddress)
            && Objects.equals(billingAddress, other.billingAddress)
            && Objects.equals(shippingAddress, other.shippingAddress)
            && Objects.equals(note, other.note)
            && Objects.equals(statementDescriptionIdentifier,
                    other.statementDescriptionIdentifier)
            && Objects.equals(cashDetails, other.cashDetails)
            && Objects.equals(externalDetails, other.externalDetails);
    }

    /**
     * Converts this CreatePaymentRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreatePaymentRequest [" + "sourceId=" + sourceId + ", idempotencyKey="
                + idempotencyKey + ", amountMoney=" + amountMoney + ", tipMoney=" + tipMoney
                + ", appFeeMoney=" + appFeeMoney + ", delayDuration=" + delayDuration
                + ", autocomplete=" + autocomplete + ", orderId=" + orderId + ", customerId="
                + customerId + ", locationId=" + locationId + ", referenceId=" + referenceId
                + ", verificationToken=" + verificationToken + ", acceptPartialAuthorization="
                + acceptPartialAuthorization + ", buyerEmailAddress=" + buyerEmailAddress
                + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress
                + ", note=" + note + ", statementDescriptionIdentifier="
                + statementDescriptionIdentifier + ", cashDetails=" + cashDetails
                + ", externalDetails=" + externalDetails + "]";
    }

    /**
     * Builds a new {@link CreatePaymentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreatePaymentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(sourceId, idempotencyKey, amountMoney)
                .tipMoney(getTipMoney())
                .appFeeMoney(getAppFeeMoney())
                .delayDuration(getDelayDuration())
                .autocomplete(getAutocomplete())
                .orderId(getOrderId())
                .customerId(getCustomerId())
                .locationId(getLocationId())
                .referenceId(getReferenceId())
                .verificationToken(getVerificationToken())
                .acceptPartialAuthorization(getAcceptPartialAuthorization())
                .buyerEmailAddress(getBuyerEmailAddress())
                .billingAddress(getBillingAddress())
                .shippingAddress(getShippingAddress())
                .note(getNote())
                .statementDescriptionIdentifier(getStatementDescriptionIdentifier())
                .cashDetails(getCashDetails())
                .externalDetails(getExternalDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link CreatePaymentRequest}.
     */
    public static class Builder {
        private String sourceId;
        private String idempotencyKey;
        private Money amountMoney;
        private Money tipMoney;
        private Money appFeeMoney;
        private String delayDuration;
        private Boolean autocomplete;
        private String orderId;
        private String customerId;
        private String locationId;
        private String referenceId;
        private String verificationToken;
        private Boolean acceptPartialAuthorization;
        private String buyerEmailAddress;
        private Address billingAddress;
        private Address shippingAddress;
        private String note;
        private String statementDescriptionIdentifier;
        private CashPaymentDetails cashDetails;
        private ExternalPaymentDetails externalDetails;

        /**
         * Initialization constructor.
         * @param  sourceId  String value for sourceId.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String sourceId, String idempotencyKey, Money amountMoney) {
            this.sourceId = sourceId;
            this.idempotencyKey = idempotencyKey;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for sourceId.
         * @param  sourceId  String value for sourceId.
         * @return Builder
         */
        public Builder sourceId(String sourceId) {
            this.sourceId = sourceId;
            return this;
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
         * Setter for tipMoney.
         * @param  tipMoney  Money value for tipMoney.
         * @return Builder
         */
        public Builder tipMoney(Money tipMoney) {
            this.tipMoney = tipMoney;
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
         * Setter for delayDuration.
         * @param  delayDuration  String value for delayDuration.
         * @return Builder
         */
        public Builder delayDuration(String delayDuration) {
            this.delayDuration = delayDuration;
            return this;
        }

        /**
         * Setter for autocomplete.
         * @param  autocomplete  Boolean value for autocomplete.
         * @return Builder
         */
        public Builder autocomplete(Boolean autocomplete) {
            this.autocomplete = autocomplete;
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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
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
         * Setter for verificationToken.
         * @param  verificationToken  String value for verificationToken.
         * @return Builder
         */
        public Builder verificationToken(String verificationToken) {
            this.verificationToken = verificationToken;
            return this;
        }

        /**
         * Setter for acceptPartialAuthorization.
         * @param  acceptPartialAuthorization  Boolean value for acceptPartialAuthorization.
         * @return Builder
         */
        public Builder acceptPartialAuthorization(Boolean acceptPartialAuthorization) {
            this.acceptPartialAuthorization = acceptPartialAuthorization;
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
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Setter for statementDescriptionIdentifier.
         * @param  statementDescriptionIdentifier  String value for statementDescriptionIdentifier.
         * @return Builder
         */
        public Builder statementDescriptionIdentifier(String statementDescriptionIdentifier) {
            this.statementDescriptionIdentifier = statementDescriptionIdentifier;
            return this;
        }

        /**
         * Setter for cashDetails.
         * @param  cashDetails  CashPaymentDetails value for cashDetails.
         * @return Builder
         */
        public Builder cashDetails(CashPaymentDetails cashDetails) {
            this.cashDetails = cashDetails;
            return this;
        }

        /**
         * Setter for externalDetails.
         * @param  externalDetails  ExternalPaymentDetails value for externalDetails.
         * @return Builder
         */
        public Builder externalDetails(ExternalPaymentDetails externalDetails) {
            this.externalDetails = externalDetails;
            return this;
        }

        /**
         * Builds a new {@link CreatePaymentRequest} object using the set fields.
         * @return {@link CreatePaymentRequest}
         */
        public CreatePaymentRequest build() {
            return new CreatePaymentRequest(sourceId, idempotencyKey, amountMoney, tipMoney,
                    appFeeMoney, delayDuration, autocomplete, orderId, customerId, locationId,
                    referenceId, verificationToken, acceptPartialAuthorization, buyerEmailAddress,
                    billingAddress, shippingAddress, note, statementDescriptionIdentifier,
                    cashDetails, externalDetails);
        }
    }
}

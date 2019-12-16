package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreatePaymentRequest {

    @JsonCreator
    public CreatePaymentRequest(
            @JsonProperty("source_id") String sourceId,
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("tip_money") Money tipMoney,
            @JsonProperty("app_fee_money") Money appFeeMoney,
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
            @JsonProperty("statement_description_identifier") String statementDescriptionIdentifier) {
        this.sourceId = sourceId;
        this.idempotencyKey = idempotencyKey;
        this.amountMoney = amountMoney;
        this.tipMoney = tipMoney;
        this.appFeeMoney = appFeeMoney;
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
    }

    private final String sourceId;
    private final String idempotencyKey;
    private final Money amountMoney;
    private final Money tipMoney;
    private final Money appFeeMoney;
    private final Boolean autocomplete;
    private final String orderId;
    private final String customerId;
    private final String locationId;
    private final String referenceId;
    private final String verificationToken;
    private final Boolean acceptPartialAuthorization;
    private final String buyerEmailAddress;
    private final Address billingAddress;
    private final Address shippingAddress;
    private final String note;
    private final String statementDescriptionIdentifier;

    @Override
    public int hashCode() {
        return Objects.hash(sourceId, idempotencyKey, amountMoney, tipMoney, appFeeMoney, autocomplete, orderId, customerId, locationId, referenceId, verificationToken, acceptPartialAuthorization, buyerEmailAddress, billingAddress, shippingAddress, note, statementDescriptionIdentifier);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreatePaymentRequest)) {
            return false;
        }
        CreatePaymentRequest createPaymentRequest = (CreatePaymentRequest) o;
        return Objects.equals(sourceId, createPaymentRequest.sourceId) &&
            Objects.equals(idempotencyKey, createPaymentRequest.idempotencyKey) &&
            Objects.equals(amountMoney, createPaymentRequest.amountMoney) &&
            Objects.equals(tipMoney, createPaymentRequest.tipMoney) &&
            Objects.equals(appFeeMoney, createPaymentRequest.appFeeMoney) &&
            Objects.equals(autocomplete, createPaymentRequest.autocomplete) &&
            Objects.equals(orderId, createPaymentRequest.orderId) &&
            Objects.equals(customerId, createPaymentRequest.customerId) &&
            Objects.equals(locationId, createPaymentRequest.locationId) &&
            Objects.equals(referenceId, createPaymentRequest.referenceId) &&
            Objects.equals(verificationToken, createPaymentRequest.verificationToken) &&
            Objects.equals(acceptPartialAuthorization, createPaymentRequest.acceptPartialAuthorization) &&
            Objects.equals(buyerEmailAddress, createPaymentRequest.buyerEmailAddress) &&
            Objects.equals(billingAddress, createPaymentRequest.billingAddress) &&
            Objects.equals(shippingAddress, createPaymentRequest.shippingAddress) &&
            Objects.equals(note, createPaymentRequest.note) &&
            Objects.equals(statementDescriptionIdentifier, createPaymentRequest.statementDescriptionIdentifier);
    }

    /**
     * Getter for SourceId.
     * The ID for the source of funds for this payment.  This can be a nonce
     * generated by the Payment Form or a card on file made with the Customers API.
     */
    @JsonGetter("source_id")
    public String getSourceId() { 
        return this.sourceId;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this CreatePayment request. Keys can be any valid string but
     * must be unique for every CreatePayment request. 
     * Max: 45 characters
     * See [Idempotency keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
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
     * Getter for TipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("tip_money")
    public Money getTipMoney() { 
        return this.tipMoney;
    }

    /**
     * Getter for AppFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("app_fee_money")
    public Money getAppFeeMoney() { 
        return this.appFeeMoney;
    }

    /**
     * Getter for Autocomplete.
     * If set to `true`, this payment will be completed when possible. If
     * set to `false`, this payment will be held in an approved state until either
     * explicitly completed (captured) or canceled (voided). For more information, see 
     * [Delayed Payments](https://developer.squareup.com/docs/payments-api/take-payments#delayed-payments).
     * Default: true
     */
    @JsonGetter("autocomplete")
    public Boolean getAutocomplete() { 
        return this.autocomplete;
    }

    /**
     * Getter for OrderId.
     * Associate a previously created order with this payment
     */
    @JsonGetter("order_id")
    public String getOrderId() { 
        return this.orderId;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer associated with the payment.
     * Required if the `source_id` refers to a card on file created using the
     * Customers API.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() { 
        return this.customerId;
    }

    /**
     * Getter for LocationId.
     * The location ID to associate with the payment. If not specified, the default location is used.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for ReferenceId.
     * A user-defined ID to associate with the payment.
     * You can use this field to associate the payment to an entity in an external system.
     * For example, you might specify an order ID that is generated by a third-party shopping cart.
     * Limit 40 characters.
     */
    @JsonGetter("reference_id")
    public String getReferenceId() { 
        return this.referenceId;
    }

    /**
     * Getter for VerificationToken.
     * An identifying token generated by `SqPaymentForm.verifyBuyer()`.
     * Verification tokens encapsulate customer device information and 3-D Secure
     * challenge results to indicate that Square has verified the buyer identity.
     * See the [SCA Overview](https://developer.squareup.com/docs/sca-overview).
     */
    @JsonGetter("verification_token")
    public String getVerificationToken() { 
        return this.verificationToken;
    }

    /**
     * Getter for AcceptPartialAuthorization.
     * If set to true and charging a Square Gift Card, a payment may be returned with
     * amount_money equal to less than what was requested.  Example, a request for $20 when charging
     * a Square Gift Card with balance of $5 wil result in an APPROVED payment of $5.  You may choose
     * to prompt the buyer for an additional payment to cover the remainder, or cancel the gift card
     * payment.  Cannot be `true` when `autocomplete = true`.
     * For more information, see 
     * [Partial amount with Square gift cards](https://developer.squareup.com/docs/payments-api/take-payments#partial-payment-gift-card).
     * Default: false
     */
    @JsonGetter("accept_partial_authorization")
    public Boolean getAcceptPartialAuthorization() { 
        return this.acceptPartialAuthorization;
    }

    /**
     * Getter for BuyerEmailAddress.
     * The buyer's e-mail address
     */
    @JsonGetter("buyer_email_address")
    public String getBuyerEmailAddress() { 
        return this.buyerEmailAddress;
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
     * Getter for Note.
     * An optional note to be entered by the developer when creating a payment
     * Limit 500 characters.
     */
    @JsonGetter("note")
    public String getNote() { 
        return this.note;
    }

    /**
     * Getter for StatementDescriptionIdentifier.
     * Optional additional payment information to include on the customer's card statement
     * as part of statement description. This can be, for example, an invoice number, ticket number,
     * or short description that uniquely identifies the purchase.
     * Limit 20 characters.
     * Note that the statement_description_identifier may get truncated on the statement description
     * to fit the required information including the Square identifier (SQ *) and name of the
     * merchant taking the payment.
     */
    @JsonGetter("statement_description_identifier")
    public String getStatementDescriptionIdentifier() { 
        return this.statementDescriptionIdentifier;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(sourceId,
            idempotencyKey,
            amountMoney)
            .tipMoney(getTipMoney())
            .appFeeMoney(getAppFeeMoney())
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
            .statementDescriptionIdentifier(getStatementDescriptionIdentifier());
            return builder;
    }

    public static class Builder {
        private String sourceId;
        private String idempotencyKey;
        private Money amountMoney;
        private Money tipMoney;
        private Money appFeeMoney;
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

        public Builder(String sourceId,
                String idempotencyKey,
                Money amountMoney) {
            this.sourceId = sourceId;
            this.idempotencyKey = idempotencyKey;
            this.amountMoney = amountMoney;
        }

        public Builder sourceId(String value) {
            sourceId = value;
            return this;
        }
        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder tipMoney(Money value) {
            tipMoney = value;
            return this;
        }
        public Builder appFeeMoney(Money value) {
            appFeeMoney = value;
            return this;
        }
        public Builder autocomplete(Boolean value) {
            autocomplete = value;
            return this;
        }
        public Builder orderId(String value) {
            orderId = value;
            return this;
        }
        public Builder customerId(String value) {
            customerId = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder referenceId(String value) {
            referenceId = value;
            return this;
        }
        public Builder verificationToken(String value) {
            verificationToken = value;
            return this;
        }
        public Builder acceptPartialAuthorization(Boolean value) {
            acceptPartialAuthorization = value;
            return this;
        }
        public Builder buyerEmailAddress(String value) {
            buyerEmailAddress = value;
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
        public Builder note(String value) {
            note = value;
            return this;
        }
        public Builder statementDescriptionIdentifier(String value) {
            statementDescriptionIdentifier = value;
            return this;
        }

        public CreatePaymentRequest build() {
            return new CreatePaymentRequest(sourceId,
                idempotencyKey,
                amountMoney,
                tipMoney,
                appFeeMoney,
                autocomplete,
                orderId,
                customerId,
                locationId,
                referenceId,
                verificationToken,
                acceptPartialAuthorization,
                buyerEmailAddress,
                billingAddress,
                shippingAddress,
                note,
                statementDescriptionIdentifier);
        }
    }
}

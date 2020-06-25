package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Tender type.
 */
public class Tender {

    /**
     * Initialization constructor.
     * @param type
     * @param id
     * @param locationId
     * @param transactionId
     * @param createdAt
     * @param note
     * @param amountMoney
     * @param tipMoney
     * @param processingFeeMoney
     * @param customerId
     * @param cardDetails
     * @param cashDetails
     * @param additionalRecipients
     * @param paymentId
     */
    @JsonCreator
    public Tender(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("transaction_id") String transactionId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("note") String note,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("tip_money") Money tipMoney,
            @JsonProperty("processing_fee_money") Money processingFeeMoney,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("card_details") TenderCardDetails cardDetails,
            @JsonProperty("cash_details") TenderCashDetails cashDetails,
            @JsonProperty("additional_recipients") List<AdditionalRecipient> additionalRecipients,
            @JsonProperty("payment_id") String paymentId) {
        this.id = id;
        this.locationId = locationId;
        this.transactionId = transactionId;
        this.createdAt = createdAt;
        this.note = note;
        this.amountMoney = amountMoney;
        this.tipMoney = tipMoney;
        this.processingFeeMoney = processingFeeMoney;
        this.customerId = customerId;
        this.type = type;
        this.cardDetails = cardDetails;
        this.cashDetails = cashDetails;
        this.additionalRecipients = additionalRecipients;
        this.paymentId = paymentId;
    }

    private final String id;
    private final String locationId;
    private final String transactionId;
    private final String createdAt;
    private final String note;
    private final Money amountMoney;
    private final Money tipMoney;
    private final Money processingFeeMoney;
    private final String customerId;
    private final String type;
    private final TenderCardDetails cardDetails;
    private final TenderCashDetails cashDetails;
    private final List<AdditionalRecipient> additionalRecipients;
    private final String paymentId;
    /**
     * Getter for Id.
     * The tender's unique ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for LocationId.
     * The ID of the transaction's associated location.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for TransactionId.
     * The ID of the tender's associated transaction.
     */
    @JsonGetter("transaction_id")
    public String getTransactionId() {
        return this.transactionId;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp for when the tender was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for Note.
     * An optional note associated with the tender at the time of payment.
     */
    @JsonGetter("note")
    public String getNote() {
        return this.note;
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
     * Getter for ProcessingFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("processing_fee_money")
    public Money getProcessingFeeMoney() {
        return this.processingFeeMoney;
    }

    /**
     * Getter for CustomerId.
     * If the tender is associated with a customer or represents a customer's card on file,
     * this is the ID of the associated customer.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for Type.
     * Indicates a tender's type.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for CardDetails.
     * Represents additional details of a tender with `type` `CARD` or `SQUARE_GIFT_CARD`
     */
    @JsonGetter("card_details")
    public TenderCardDetails getCardDetails() {
        return this.cardDetails;
    }

    /**
     * Getter for CashDetails.
     * Represents the details of a tender with `type` `CASH`.
     */
    @JsonGetter("cash_details")
    public TenderCashDetails getCashDetails() {
        return this.cashDetails;
    }

    /**
     * Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this tender.
     * For example, fees assessed on the purchase by a third party integration.
     */
    @JsonGetter("additional_recipients")
    public List<AdditionalRecipient> getAdditionalRecipients() {
        return this.additionalRecipients;
    }

    /**
     * Getter for PaymentId.
     * The ID of the [Payment](#type-payment) that corresponds to this tender.
     * This value is only present for payments created with the v2 Payments API.
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return this.paymentId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, transactionId, createdAt, note, amountMoney, tipMoney,
            processingFeeMoney, customerId, type, cardDetails, cashDetails, additionalRecipients,
            paymentId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Tender)) {
            return false;
        }
        Tender tender = (Tender) obj;
        return Objects.equals(id, tender.id) &&
            Objects.equals(locationId, tender.locationId) &&
            Objects.equals(transactionId, tender.transactionId) &&
            Objects.equals(createdAt, tender.createdAt) &&
            Objects.equals(note, tender.note) &&
            Objects.equals(amountMoney, tender.amountMoney) &&
            Objects.equals(tipMoney, tender.tipMoney) &&
            Objects.equals(processingFeeMoney, tender.processingFeeMoney) &&
            Objects.equals(customerId, tender.customerId) &&
            Objects.equals(type, tender.type) &&
            Objects.equals(cardDetails, tender.cardDetails) &&
            Objects.equals(cashDetails, tender.cashDetails) &&
            Objects.equals(additionalRecipients, tender.additionalRecipients) &&
            Objects.equals(paymentId, tender.paymentId);
    }

    /**
     * Builds a new {@link Tender.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Tender.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type)
            .id(getId())
            .locationId(getLocationId())
            .transactionId(getTransactionId())
            .createdAt(getCreatedAt())
            .note(getNote())
            .amountMoney(getAmountMoney())
            .tipMoney(getTipMoney())
            .processingFeeMoney(getProcessingFeeMoney())
            .customerId(getCustomerId())
            .cardDetails(getCardDetails())
            .cashDetails(getCashDetails())
            .additionalRecipients(getAdditionalRecipients())
            .paymentId(getPaymentId());
            return builder;
    }

    /**
     * Class to build instances of {@link Tender}
     */
    public static class Builder {
        private String type;
        private String id;
        private String locationId;
        private String transactionId;
        private String createdAt;
        private String note;
        private Money amountMoney;
        private Money tipMoney;
        private Money processingFeeMoney;
        private String customerId;
        private TenderCardDetails cardDetails;
        private TenderCashDetails cashDetails;
        private List<AdditionalRecipient> additionalRecipients;
        private String paymentId;

        /**
         * Initialization constructor
         */
        public Builder(String type) {
            this.type = type;
        }

        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for transactionId
         * @param transactionId
         * @return Builder
         */
        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
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
         * Setter for amountMoney
         * @param amountMoney
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }
        /**
         * Setter for tipMoney
         * @param tipMoney
         * @return Builder
         */
        public Builder tipMoney(Money tipMoney) {
            this.tipMoney = tipMoney;
            return this;
        }
        /**
         * Setter for processingFeeMoney
         * @param processingFeeMoney
         * @return Builder
         */
        public Builder processingFeeMoney(Money processingFeeMoney) {
            this.processingFeeMoney = processingFeeMoney;
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
         * Setter for cardDetails
         * @param cardDetails
         * @return Builder
         */
        public Builder cardDetails(TenderCardDetails cardDetails) {
            this.cardDetails = cardDetails;
            return this;
        }
        /**
         * Setter for cashDetails
         * @param cashDetails
         * @return Builder
         */
        public Builder cashDetails(TenderCashDetails cashDetails) {
            this.cashDetails = cashDetails;
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
         * Setter for paymentId
         * @param paymentId
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * Builds a new {@link Tender} object using the set fields.
         * @return {@link Tender}
         */
        public Tender build() {
            return new Tender(type,
                id,
                locationId,
                transactionId,
                createdAt,
                note,
                amountMoney,
                tipMoney,
                processingFeeMoney,
                customerId,
                cardDetails,
                cashDetails,
                additionalRecipients,
                paymentId);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Tender type.
 */
public class Tender {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String transactionId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money amountMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money tipMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money processingFeeMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String customerId;
    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TenderCardDetails cardDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TenderCashDetails cashDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<AdditionalRecipient> additionalRecipients;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String paymentId;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  id  String value for id.
     * @param  locationId  String value for locationId.
     * @param  transactionId  String value for transactionId.
     * @param  createdAt  String value for createdAt.
     * @param  note  String value for note.
     * @param  amountMoney  Money value for amountMoney.
     * @param  tipMoney  Money value for tipMoney.
     * @param  processingFeeMoney  Money value for processingFeeMoney.
     * @param  customerId  String value for customerId.
     * @param  cardDetails  TenderCardDetails value for cardDetails.
     * @param  cashDetails  TenderCashDetails value for cashDetails.
     * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
     * @param  paymentId  String value for paymentId.
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

    /**
     * Getter for Id.
     * The tender's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for LocationId.
     * The ID of the transaction's associated location.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for TransactionId.
     * The ID of the tender's associated transaction.
     * @return Returns the String
     */
    @JsonGetter("transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp for when the tender was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for Note.
     * An optional note associated with the tender at the time of payment.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return note;
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
     * Getter for ProcessingFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("processing_fee_money")
    public Money getProcessingFeeMoney() {
        return processingFeeMoney;
    }

    /**
     * Getter for CustomerId.
     * If the tender is associated with a customer or represents a customer's card on file, this is
     * the ID of the associated customer.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for Type.
     * Indicates a tender's type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for CardDetails.
     * Represents additional details of a tender with `type` `CARD` or `SQUARE_GIFT_CARD`
     * @return Returns the TenderCardDetails
     */
    @JsonGetter("card_details")
    public TenderCardDetails getCardDetails() {
        return cardDetails;
    }

    /**
     * Getter for CashDetails.
     * Represents the details of a tender with `type` `CASH`.
     * @return Returns the TenderCashDetails
     */
    @JsonGetter("cash_details")
    public TenderCashDetails getCashDetails() {
        return cashDetails;
    }

    /**
     * Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this tender. For
     * example, fees assessed on the purchase by a third party integration.
     * @return Returns the List of AdditionalRecipient
     */
    @JsonGetter("additional_recipients")
    public List<AdditionalRecipient> getAdditionalRecipients() {
        return additionalRecipients;
    }

    /**
     * Getter for PaymentId.
     * The ID of the [Payment](#type-payment) that corresponds to this tender. This value is only
     * present for payments created with the v2 Payments API.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, transactionId, createdAt, note, amountMoney, tipMoney,
                processingFeeMoney, customerId, type, cardDetails, cashDetails,
                additionalRecipients, paymentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tender)) {
            return false;
        }
        Tender other = (Tender) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(transactionId, other.transactionId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(note, other.note)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(tipMoney, other.tipMoney)
            && Objects.equals(processingFeeMoney, other.processingFeeMoney)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(type, other.type)
            && Objects.equals(cardDetails, other.cardDetails)
            && Objects.equals(cashDetails, other.cashDetails)
            && Objects.equals(additionalRecipients, other.additionalRecipients)
            && Objects.equals(paymentId, other.paymentId);
    }

    /**
     * Converts this Tender into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Tender [" + "type=" + type + ", id=" + id + ", locationId=" + locationId
                + ", transactionId=" + transactionId + ", createdAt=" + createdAt + ", note=" + note
                + ", amountMoney=" + amountMoney + ", tipMoney=" + tipMoney
                + ", processingFeeMoney=" + processingFeeMoney + ", customerId=" + customerId
                + ", cardDetails=" + cardDetails + ", cashDetails=" + cashDetails
                + ", additionalRecipients=" + additionalRecipients + ", paymentId=" + paymentId
                + "]";
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
     * Class to build instances of {@link Tender}.
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
         * Initialization constructor.
         * @param  type  String value for type.
         */
        public Builder(String type) {
            this.type = type;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for transactionId.
         * @param  transactionId  String value for transactionId.
         * @return Builder
         */
        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
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
         * Setter for processingFeeMoney.
         * @param  processingFeeMoney  Money value for processingFeeMoney.
         * @return Builder
         */
        public Builder processingFeeMoney(Money processingFeeMoney) {
            this.processingFeeMoney = processingFeeMoney;
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
         * Setter for cardDetails.
         * @param  cardDetails  TenderCardDetails value for cardDetails.
         * @return Builder
         */
        public Builder cardDetails(TenderCardDetails cardDetails) {
            this.cardDetails = cardDetails;
            return this;
        }

        /**
         * Setter for cashDetails.
         * @param  cashDetails  TenderCashDetails value for cashDetails.
         * @return Builder
         */
        public Builder cashDetails(TenderCashDetails cashDetails) {
            this.cashDetails = cashDetails;
            return this;
        }

        /**
         * Setter for additionalRecipients.
         * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
         * @return Builder
         */
        public Builder additionalRecipients(List<AdditionalRecipient> additionalRecipients) {
            this.additionalRecipients = additionalRecipients;
            return this;
        }

        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
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
            return new Tender(type, id, locationId, transactionId, createdAt, note, amountMoney,
                    tipMoney, processingFeeMoney, customerId, cardDetails, cashDetails,
                    additionalRecipients, paymentId);
        }
    }
}

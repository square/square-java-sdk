package com.squareup.square.legacy.models;

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
 * This is a model class for Tender type.
 */
public class Tender {
    private final String id;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> transactionId;
    private final String createdAt;
    private final OptionalNullable<String> note;
    private final Money amountMoney;
    private final Money tipMoney;
    private final Money processingFeeMoney;
    private final OptionalNullable<String> customerId;
    private final String type;
    private final TenderCardDetails cardDetails;
    private final TenderCashDetails cashDetails;
    private final TenderBankAccountDetails bankAccountDetails;
    private final TenderBuyNowPayLaterDetails buyNowPayLaterDetails;
    private final TenderSquareAccountDetails squareAccountDetails;
    private final OptionalNullable<List<AdditionalRecipient>> additionalRecipients;
    private final OptionalNullable<String> paymentId;

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
     * @param  bankAccountDetails  TenderBankAccountDetails value for bankAccountDetails.
     * @param  buyNowPayLaterDetails  TenderBuyNowPayLaterDetails value for buyNowPayLaterDetails.
     * @param  squareAccountDetails  TenderSquareAccountDetails value for squareAccountDetails.
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
            @JsonProperty("bank_account_details") TenderBankAccountDetails bankAccountDetails,
            @JsonProperty("buy_now_pay_later_details") TenderBuyNowPayLaterDetails buyNowPayLaterDetails,
            @JsonProperty("square_account_details") TenderSquareAccountDetails squareAccountDetails,
            @JsonProperty("additional_recipients") List<AdditionalRecipient> additionalRecipients,
            @JsonProperty("payment_id") String paymentId) {
        this.id = id;
        this.locationId = OptionalNullable.of(locationId);
        this.transactionId = OptionalNullable.of(transactionId);
        this.createdAt = createdAt;
        this.note = OptionalNullable.of(note);
        this.amountMoney = amountMoney;
        this.tipMoney = tipMoney;
        this.processingFeeMoney = processingFeeMoney;
        this.customerId = OptionalNullable.of(customerId);
        this.type = type;
        this.cardDetails = cardDetails;
        this.cashDetails = cashDetails;
        this.bankAccountDetails = bankAccountDetails;
        this.buyNowPayLaterDetails = buyNowPayLaterDetails;
        this.squareAccountDetails = squareAccountDetails;
        this.additionalRecipients = OptionalNullable.of(additionalRecipients);
        this.paymentId = OptionalNullable.of(paymentId);
    }

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
     * @param  bankAccountDetails  TenderBankAccountDetails value for bankAccountDetails.
     * @param  buyNowPayLaterDetails  TenderBuyNowPayLaterDetails value for buyNowPayLaterDetails.
     * @param  squareAccountDetails  TenderSquareAccountDetails value for squareAccountDetails.
     * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
     * @param  paymentId  String value for paymentId.
     */
    protected Tender(
            String type,
            String id,
            OptionalNullable<String> locationId,
            OptionalNullable<String> transactionId,
            String createdAt,
            OptionalNullable<String> note,
            Money amountMoney,
            Money tipMoney,
            Money processingFeeMoney,
            OptionalNullable<String> customerId,
            TenderCardDetails cardDetails,
            TenderCashDetails cashDetails,
            TenderBankAccountDetails bankAccountDetails,
            TenderBuyNowPayLaterDetails buyNowPayLaterDetails,
            TenderSquareAccountDetails squareAccountDetails,
            OptionalNullable<List<AdditionalRecipient>> additionalRecipients,
            OptionalNullable<String> paymentId) {
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
        this.bankAccountDetails = bankAccountDetails;
        this.buyNowPayLaterDetails = buyNowPayLaterDetails;
        this.squareAccountDetails = squareAccountDetails;
        this.additionalRecipients = additionalRecipients;
        this.paymentId = paymentId;
    }

    /**
     * Getter for Id.
     * The tender's unique ID. It is the associated payment ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the transaction's associated location.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the transaction's associated location.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for TransactionId.
     * The ID of the tender's associated transaction.
     * @return Returns the Internal String
     */
    @JsonGetter("transaction_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTransactionId() {
        return this.transactionId;
    }

    /**
     * Getter for TransactionId.
     * The ID of the tender's associated transaction.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTransactionId() {
        return OptionalNullable.getFrom(transactionId);
    }

    /**
     * Getter for CreatedAt.
     * The timestamp for when the tender was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Internal Getter for Note.
     * An optional note associated with the tender at the time of payment.
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
     * An optional note associated with the tender at the time of payment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getProcessingFeeMoney() {
        return processingFeeMoney;
    }

    /**
     * Internal Getter for CustomerId.
     * If the tender is associated with a customer or represents a customer's card on file, this is
     * the ID of the associated customer.
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
     * If the tender is associated with a customer or represents a customer's card on file, this is
     * the ID of the associated customer.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TenderCardDetails getCardDetails() {
        return cardDetails;
    }

    /**
     * Getter for CashDetails.
     * Represents the details of a tender with `type` `CASH`.
     * @return Returns the TenderCashDetails
     */
    @JsonGetter("cash_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TenderCashDetails getCashDetails() {
        return cashDetails;
    }

    /**
     * Getter for BankAccountDetails.
     * Represents the details of a tender with `type` `BANK_ACCOUNT`. See
     * [BankAccountPaymentDetails]($m/BankAccountPaymentDetails) for more exposed details of a bank
     * account payment.
     * @return Returns the TenderBankAccountDetails
     */
    @JsonGetter("bank_account_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TenderBankAccountDetails getBankAccountDetails() {
        return bankAccountDetails;
    }

    /**
     * Getter for BuyNowPayLaterDetails.
     * Represents the details of a tender with `type` `BUY_NOW_PAY_LATER`.
     * @return Returns the TenderBuyNowPayLaterDetails
     */
    @JsonGetter("buy_now_pay_later_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TenderBuyNowPayLaterDetails getBuyNowPayLaterDetails() {
        return buyNowPayLaterDetails;
    }

    /**
     * Getter for SquareAccountDetails.
     * Represents the details of a tender with `type` `SQUARE_ACCOUNT`.
     * @return Returns the TenderSquareAccountDetails
     */
    @JsonGetter("square_account_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TenderSquareAccountDetails getSquareAccountDetails() {
        return squareAccountDetails;
    }

    /**
     * Internal Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this tender. For
     * example, fees assessed on the purchase by a third party integration.
     * @return Returns the Internal List of AdditionalRecipient
     */
    @JsonGetter("additional_recipients")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<AdditionalRecipient>> internalGetAdditionalRecipients() {
        return this.additionalRecipients;
    }

    /**
     * Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this tender. For
     * example, fees assessed on the purchase by a third party integration.
     * @return Returns the List of AdditionalRecipient
     */
    @JsonIgnore
    public List<AdditionalRecipient> getAdditionalRecipients() {
        return OptionalNullable.getFrom(additionalRecipients);
    }

    /**
     * Internal Getter for PaymentId.
     * The ID of the [Payment](entity:Payment) that corresponds to this tender. This value is only
     * present for payments created with the v2 Payments API.
     * @return Returns the Internal String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPaymentId() {
        return this.paymentId;
    }

    /**
     * Getter for PaymentId.
     * The ID of the [Payment](entity:Payment) that corresponds to this tender. This value is only
     * present for payments created with the v2 Payments API.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentId() {
        return OptionalNullable.getFrom(paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                locationId,
                transactionId,
                createdAt,
                note,
                amountMoney,
                tipMoney,
                processingFeeMoney,
                customerId,
                type,
                cardDetails,
                cashDetails,
                bankAccountDetails,
                buyNowPayLaterDetails,
                squareAccountDetails,
                additionalRecipients,
                paymentId);
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
                && Objects.equals(bankAccountDetails, other.bankAccountDetails)
                && Objects.equals(buyNowPayLaterDetails, other.buyNowPayLaterDetails)
                && Objects.equals(squareAccountDetails, other.squareAccountDetails)
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
                + ", bankAccountDetails=" + bankAccountDetails + ", buyNowPayLaterDetails="
                + buyNowPayLaterDetails + ", squareAccountDetails=" + squareAccountDetails
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
                .createdAt(getCreatedAt())
                .amountMoney(getAmountMoney())
                .tipMoney(getTipMoney())
                .processingFeeMoney(getProcessingFeeMoney())
                .cardDetails(getCardDetails())
                .cashDetails(getCashDetails())
                .bankAccountDetails(getBankAccountDetails())
                .buyNowPayLaterDetails(getBuyNowPayLaterDetails())
                .squareAccountDetails(getSquareAccountDetails());
        builder.locationId = internalGetLocationId();
        builder.transactionId = internalGetTransactionId();
        builder.note = internalGetNote();
        builder.customerId = internalGetCustomerId();
        builder.additionalRecipients = internalGetAdditionalRecipients();
        builder.paymentId = internalGetPaymentId();
        return builder;
    }

    /**
     * Class to build instances of {@link Tender}.
     */
    public static class Builder {
        private String type;
        private String id;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> transactionId;
        private String createdAt;
        private OptionalNullable<String> note;
        private Money amountMoney;
        private Money tipMoney;
        private Money processingFeeMoney;
        private OptionalNullable<String> customerId;
        private TenderCardDetails cardDetails;
        private TenderCashDetails cashDetails;
        private TenderBankAccountDetails bankAccountDetails;
        private TenderBuyNowPayLaterDetails buyNowPayLaterDetails;
        private TenderSquareAccountDetails squareAccountDetails;
        private OptionalNullable<List<AdditionalRecipient>> additionalRecipients;
        private OptionalNullable<String> paymentId;

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
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for transactionId.
         * @param  transactionId  String value for transactionId.
         * @return Builder
         */
        public Builder transactionId(String transactionId) {
            this.transactionId = OptionalNullable.of(transactionId);
            return this;
        }

        /**
         * UnSetter for transactionId.
         * @return Builder
         */
        public Builder unsetTransactionId() {
            transactionId = null;
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
         * Setter for bankAccountDetails.
         * @param  bankAccountDetails  TenderBankAccountDetails value for bankAccountDetails.
         * @return Builder
         */
        public Builder bankAccountDetails(TenderBankAccountDetails bankAccountDetails) {
            this.bankAccountDetails = bankAccountDetails;
            return this;
        }

        /**
         * Setter for buyNowPayLaterDetails.
         * @param  buyNowPayLaterDetails  TenderBuyNowPayLaterDetails value for
         *         buyNowPayLaterDetails.
         * @return Builder
         */
        public Builder buyNowPayLaterDetails(TenderBuyNowPayLaterDetails buyNowPayLaterDetails) {
            this.buyNowPayLaterDetails = buyNowPayLaterDetails;
            return this;
        }

        /**
         * Setter for squareAccountDetails.
         * @param  squareAccountDetails  TenderSquareAccountDetails value for squareAccountDetails.
         * @return Builder
         */
        public Builder squareAccountDetails(TenderSquareAccountDetails squareAccountDetails) {
            this.squareAccountDetails = squareAccountDetails;
            return this;
        }

        /**
         * Setter for additionalRecipients.
         * @param  additionalRecipients  List of AdditionalRecipient value for additionalRecipients.
         * @return Builder
         */
        public Builder additionalRecipients(List<AdditionalRecipient> additionalRecipients) {
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
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = OptionalNullable.of(paymentId);
            return this;
        }

        /**
         * UnSetter for paymentId.
         * @return Builder
         */
        public Builder unsetPaymentId() {
            paymentId = null;
            return this;
        }

        /**
         * Builds a new {@link Tender} object using the set fields.
         * @return {@link Tender}
         */
        public Tender build() {
            return new Tender(
                    type,
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
                    bankAccountDetails,
                    buyNowPayLaterDetails,
                    squareAccountDetails,
                    additionalRecipients,
                    paymentId);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for Refund type.
 */
public class Refund {
    private final String id;
    private final String locationId;
    private final String transactionId;
    private final String tenderId;
    private final String createdAt;
    private final String reason;
    private final Money amountMoney;
    private final String status;
    private final Money processingFeeMoney;
    private final List<AdditionalRecipient> additionalRecipients;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param locationId String value for locationId.
     * @param transactionId String value for transactionId.
     * @param tenderId String value for tenderId.
     * @param reason String value for reason.
     * @param amountMoney Money value for amountMoney.
     * @param status String value for status.
     * @param createdAt String value for createdAt.
     * @param processingFeeMoney Money value for processingFeeMoney.
     * @param additionalRecipients List of AdditionalRecipient value for additionalRecipients.
     */
    @JsonCreator
    public Refund(
            @JsonProperty("id") String id,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("transaction_id") String transactionId,
            @JsonProperty("tender_id") String tenderId,
            @JsonProperty("reason") String reason,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("status") String status,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("processing_fee_money") Money processingFeeMoney,
            @JsonProperty("additional_recipients") List<AdditionalRecipient> additionalRecipients) {
        this.id = id;
        this.locationId = locationId;
        this.transactionId = transactionId;
        this.tenderId = tenderId;
        this.createdAt = createdAt;
        this.reason = reason;
        this.amountMoney = amountMoney;
        this.status = status;
        this.processingFeeMoney = processingFeeMoney;
        this.additionalRecipients = additionalRecipients;
    }

    /**
     * Getter for Id.
     * The refund's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for LocationId.
     * The ID of the refund's associated location.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for TransactionId.
     * The ID of the transaction that the refunded tender is part of.
     * @return Returns the String
     */
    @JsonGetter("transaction_id")
    public String getTransactionId() {
        return this.transactionId;
    }

    /**
     * Getter for TenderId.
     * The ID of the refunded tender.
     * @return Returns the String
     */
    @JsonGetter("tender_id")
    public String getTenderId() {
        return this.tenderId;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp for when the refund was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for Reason.
     * The reason for the refund being issued.
     * @return Returns the String
     */
    @JsonGetter("reason")
    public String getReason() {
        return this.reason;
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
        return this.amountMoney;
    }

    /**
     * Getter for Status.
     * Indicates a refund's current status.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
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
        return this.processingFeeMoney;
    }

    /**
     * Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this refund. For
     * example, fees assessed on a refund of a purchase by a third party integration.
     * @return Returns the List of AdditionalRecipient
     */
    @JsonGetter("additional_recipients")
    public List<AdditionalRecipient> getAdditionalRecipients() {
        return this.additionalRecipients;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, transactionId, tenderId, createdAt, reason, amountMoney,
                status, processingFeeMoney, additionalRecipients);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Refund)) {
            return false;
        }
        Refund other = (Refund) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(transactionId, other.transactionId)
            && Objects.equals(tenderId, other.tenderId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(reason, other.reason)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(status, other.status)
            && Objects.equals(processingFeeMoney, other.processingFeeMoney)
            && Objects.equals(additionalRecipients, other.additionalRecipients);
    }

    /**
     * Builds a new {@link Refund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Refund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            locationId,
            transactionId,
            tenderId,
            reason,
            amountMoney,
            status)
            .createdAt(getCreatedAt())
            .processingFeeMoney(getProcessingFeeMoney())
            .additionalRecipients(getAdditionalRecipients());
        return builder;
    }

    /**
     * Class to build instances of {@link Refund}.
     */
    public static class Builder {
        private String id;
        private String locationId;
        private String transactionId;
        private String tenderId;
        private String reason;
        private Money amountMoney;
        private String status;
        private String createdAt;
        private Money processingFeeMoney;
        private List<AdditionalRecipient> additionalRecipients;

        /**
         * Initialization constructor.
         * @param id String value for id.
         * @param locationId String value for locationId.
         * @param transactionId String value for transactionId.
         * @param tenderId String value for tenderId.
         * @param reason String value for reason.
         * @param amountMoney Money value for amountMoney.
         * @param status String value for status.
         */
        public Builder(String id,
                String locationId,
                String transactionId,
                String tenderId,
                String reason,
                Money amountMoney,
                String status) {
            this.id = id;
            this.locationId = locationId;
            this.transactionId = transactionId;
            this.tenderId = tenderId;
            this.reason = reason;
            this.amountMoney = amountMoney;
            this.status = status;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for locationId.
         * @param locationId String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for transactionId.
         * @param transactionId String value for transactionId.
         * @return Builder
         */
        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        /**
         * Setter for tenderId.
         * @param tenderId String value for tenderId.
         * @return Builder
         */
        public Builder tenderId(String tenderId) {
            this.tenderId = tenderId;
            return this;
        }

        /**
         * Setter for reason.
         * @param reason String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param amountMoney Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for status.
         * @param status String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for processingFeeMoney.
         * @param processingFeeMoney Money value for processingFeeMoney.
         * @return Builder
         */
        public Builder processingFeeMoney(Money processingFeeMoney) {
            this.processingFeeMoney = processingFeeMoney;
            return this;
        }

        /**
         * Setter for additionalRecipients.
         * @param additionalRecipients List of AdditionalRecipient value for additionalRecipients.
         * @return Builder
         */
        public Builder additionalRecipients(List<AdditionalRecipient> additionalRecipients) {
            this.additionalRecipients = additionalRecipients;
            return this;
        }

        /**
         * Builds a new {@link Refund} object using the set fields.
         * @return {@link Refund}
         */
        public Refund build() {
            return new Refund(id,
                locationId,
                transactionId,
                tenderId,
                reason,
                amountMoney,
                status,
                createdAt,
                processingFeeMoney,
                additionalRecipients);
        }
    }
}

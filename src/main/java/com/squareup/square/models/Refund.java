package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Refund {

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

    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, transactionId, tenderId, reason, amountMoney, status, createdAt, processingFeeMoney, additionalRecipients);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Refund)) {
            return false;
        }
        Refund refund = (Refund) o;
        return Objects.equals(id, refund.id) &&
            Objects.equals(locationId, refund.locationId) &&
            Objects.equals(transactionId, refund.transactionId) &&
            Objects.equals(tenderId, refund.tenderId) &&
            Objects.equals(reason, refund.reason) &&
            Objects.equals(amountMoney, refund.amountMoney) &&
            Objects.equals(status, refund.status) &&
            Objects.equals(createdAt, refund.createdAt) &&
            Objects.equals(processingFeeMoney, refund.processingFeeMoney) &&
            Objects.equals(additionalRecipients, refund.additionalRecipients);
    }

    /**
     * Getter for Id.
     * The refund's unique ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for LocationId.
     * The ID of the refund's associated location.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for TransactionId.
     * The ID of the transaction that the refunded tender is part of.
     */
    @JsonGetter("transaction_id")
    public String getTransactionId() { 
        return this.transactionId;
    }

    /**
     * Getter for TenderId.
     * The ID of the refunded tender.
     */
    @JsonGetter("tender_id")
    public String getTenderId() { 
        return this.tenderId;
    }

    /**
     * Getter for CreatedAt.
     * The time when the refund was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for Reason.
     * The reason for the refund being issued.
     */
    @JsonGetter("reason")
    public String getReason() { 
        return this.reason;
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
     * Getter for Status.
     * Indicates a refund's current status.
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
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
     * Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this refund.
     * For example, fees assessed on a refund of a purchase by a third party integration.
     */
    @JsonGetter("additional_recipients")
    public List<AdditionalRecipient> getAdditionalRecipients() { 
        return this.additionalRecipients;
    }

 
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

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder transactionId(String value) {
            transactionId = value;
            return this;
        }
        public Builder tenderId(String value) {
            tenderId = value;
            return this;
        }
        public Builder reason(String value) {
            reason = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder processingFeeMoney(Money value) {
            processingFeeMoney = value;
            return this;
        }
        public Builder additionalRecipients(List<AdditionalRecipient> value) {
            additionalRecipients = value;
            return this;
        }

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

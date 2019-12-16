package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class AdditionalRecipientReceivable {

    @JsonCreator
    public AdditionalRecipientReceivable(
            @JsonProperty("id") String id,
            @JsonProperty("transaction_id") String transactionId,
            @JsonProperty("transaction_location_id") String transactionLocationId,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("refunds") List<AdditionalRecipientReceivableRefund> refunds) {
        this.id = id;
        this.transactionId = transactionId;
        this.transactionLocationId = transactionLocationId;
        this.amountMoney = amountMoney;
        this.createdAt = createdAt;
        this.refunds = refunds;
    }

    private final String id;
    private final String transactionId;
    private final String transactionLocationId;
    private final Money amountMoney;
    private final String createdAt;
    private final List<AdditionalRecipientReceivableRefund> refunds;

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId, transactionLocationId, amountMoney, createdAt, refunds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AdditionalRecipientReceivable)) {
            return false;
        }
        AdditionalRecipientReceivable additionalRecipientReceivable = (AdditionalRecipientReceivable) o;
        return Objects.equals(id, additionalRecipientReceivable.id) &&
            Objects.equals(transactionId, additionalRecipientReceivable.transactionId) &&
            Objects.equals(transactionLocationId, additionalRecipientReceivable.transactionLocationId) &&
            Objects.equals(amountMoney, additionalRecipientReceivable.amountMoney) &&
            Objects.equals(createdAt, additionalRecipientReceivable.createdAt) &&
            Objects.equals(refunds, additionalRecipientReceivable.refunds);
    }

    /**
     * Getter for Id.
     * The additional recipient receivable's unique ID, issued by Square payments servers.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for TransactionId.
     * The ID of the transaction that the additional recipient receivable was applied to.
     */
    @JsonGetter("transaction_id")
    public String getTransactionId() { 
        return this.transactionId;
    }

    /**
     * Getter for TransactionLocationId.
     * The ID of the location that created the receivable. This is the location ID on the associated transaction.
     */
    @JsonGetter("transaction_location_id")
    public String getTransactionLocationId() { 
        return this.transactionLocationId;
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
     * Getter for CreatedAt.
     * The time when the additional recipient receivable was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for Refunds.
     * Any refunds of the receivable that have been applied.
     */
    @JsonGetter("refunds")
    public List<AdditionalRecipientReceivableRefund> getRefunds() { 
        return this.refunds;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            transactionId,
            transactionLocationId,
            amountMoney)
            .createdAt(getCreatedAt())
            .refunds(getRefunds());
            return builder;
    }

    public static class Builder {
        private String id;
        private String transactionId;
        private String transactionLocationId;
        private Money amountMoney;
        private String createdAt;
        private List<AdditionalRecipientReceivableRefund> refunds;

        public Builder(String id,
                String transactionId,
                String transactionLocationId,
                Money amountMoney) {
            this.id = id;
            this.transactionId = transactionId;
            this.transactionLocationId = transactionLocationId;
            this.amountMoney = amountMoney;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder transactionId(String value) {
            transactionId = value;
            return this;
        }
        public Builder transactionLocationId(String value) {
            transactionLocationId = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder refunds(List<AdditionalRecipientReceivableRefund> value) {
            refunds = value;
            return this;
        }

        public AdditionalRecipientReceivable build() {
            return new AdditionalRecipientReceivable(id,
                transactionId,
                transactionLocationId,
                amountMoney,
                createdAt,
                refunds);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class AdditionalRecipientReceivableRefund {

    @JsonCreator
    public AdditionalRecipientReceivableRefund(
            @JsonProperty("id") String id,
            @JsonProperty("receivable_id") String receivableId,
            @JsonProperty("refund_id") String refundId,
            @JsonProperty("transaction_location_id") String transactionLocationId,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("created_at") String createdAt) {
        this.id = id;
        this.receivableId = receivableId;
        this.refundId = refundId;
        this.transactionLocationId = transactionLocationId;
        this.amountMoney = amountMoney;
        this.createdAt = createdAt;
    }

    private final String id;
    private final String receivableId;
    private final String refundId;
    private final String transactionLocationId;
    private final Money amountMoney;
    private final String createdAt;

    @Override
    public int hashCode() {
        return Objects.hash(id, receivableId, refundId, transactionLocationId, amountMoney, createdAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AdditionalRecipientReceivableRefund)) {
            return false;
        }
        AdditionalRecipientReceivableRefund additionalRecipientReceivableRefund = (AdditionalRecipientReceivableRefund) o;
        return Objects.equals(id, additionalRecipientReceivableRefund.id) &&
            Objects.equals(receivableId, additionalRecipientReceivableRefund.receivableId) &&
            Objects.equals(refundId, additionalRecipientReceivableRefund.refundId) &&
            Objects.equals(transactionLocationId, additionalRecipientReceivableRefund.transactionLocationId) &&
            Objects.equals(amountMoney, additionalRecipientReceivableRefund.amountMoney) &&
            Objects.equals(createdAt, additionalRecipientReceivableRefund.createdAt);
    }

    /**
     * Getter for Id.
     * The receivable refund's unique ID, issued by Square payments servers.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for ReceivableId.
     * The ID of the receivable that the refund was applied to.
     */
    @JsonGetter("receivable_id")
    public String getReceivableId() { 
        return this.receivableId;
    }

    /**
     * Getter for RefundId.
     * The ID of the refund that is associated to this receivable refund.
     */
    @JsonGetter("refund_id")
    public String getRefundId() { 
        return this.refundId;
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
     * The time when the refund was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            receivableId,
            refundId,
            transactionLocationId,
            amountMoney)
            .createdAt(getCreatedAt());
            return builder;
    }

    public static class Builder {
        private String id;
        private String receivableId;
        private String refundId;
        private String transactionLocationId;
        private Money amountMoney;
        private String createdAt;

        public Builder(String id,
                String receivableId,
                String refundId,
                String transactionLocationId,
                Money amountMoney) {
            this.id = id;
            this.receivableId = receivableId;
            this.refundId = refundId;
            this.transactionLocationId = transactionLocationId;
            this.amountMoney = amountMoney;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder receivableId(String value) {
            receivableId = value;
            return this;
        }
        public Builder refundId(String value) {
            refundId = value;
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

        public AdditionalRecipientReceivableRefund build() {
            return new AdditionalRecipientReceivableRefund(id,
                receivableId,
                refundId,
                transactionLocationId,
                amountMoney,
                createdAt);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for AdditionalRecipientReceivableRefund type.
 */
public class AdditionalRecipientReceivableRefund {

    /**
     * Initialization constructor.
     * @param id
     * @param receivableId
     * @param refundId
     * @param transactionLocationId
     * @param amountMoney
     * @param createdAt
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(id, receivableId, refundId, transactionLocationId, amountMoney,
            createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof AdditionalRecipientReceivableRefund)) {
            return false;
        }
        AdditionalRecipientReceivableRefund additionalRecipientReceivableRefund = (AdditionalRecipientReceivableRefund) obj;
        return Objects.equals(id, additionalRecipientReceivableRefund.id) &&
            Objects.equals(receivableId, additionalRecipientReceivableRefund.receivableId) &&
            Objects.equals(refundId, additionalRecipientReceivableRefund.refundId) &&
            Objects.equals(transactionLocationId, additionalRecipientReceivableRefund.transactionLocationId) &&
            Objects.equals(amountMoney, additionalRecipientReceivableRefund.amountMoney) &&
            Objects.equals(createdAt, additionalRecipientReceivableRefund.createdAt);
    }

    /**
     * Builds a new {@link AdditionalRecipientReceivableRefund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AdditionalRecipientReceivableRefund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            receivableId,
            refundId,
            transactionLocationId,
            amountMoney)
            .createdAt(getCreatedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link AdditionalRecipientReceivableRefund}
     */
    public static class Builder {
        private String id;
        private String receivableId;
        private String refundId;
        private String transactionLocationId;
        private Money amountMoney;
        private String createdAt;

        /**
         * Initialization constructor
         */
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
         * Setter for receivableId
         * @param receivableId
         * @return Builder
         */
        public Builder receivableId(String receivableId) {
            this.receivableId = receivableId;
            return this;
        }
        /**
         * Setter for refundId
         * @param refundId
         * @return Builder
         */
        public Builder refundId(String refundId) {
            this.refundId = refundId;
            return this;
        }
        /**
         * Setter for transactionLocationId
         * @param transactionLocationId
         * @return Builder
         */
        public Builder transactionLocationId(String transactionLocationId) {
            this.transactionLocationId = transactionLocationId;
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
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Builds a new {@link AdditionalRecipientReceivableRefund} object using the set fields.
         * @return {@link AdditionalRecipientReceivableRefund}
         */
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

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateRefundRequest {

    @JsonCreator
    public CreateRefundRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("tender_id") String tenderId,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("reason") String reason) {
        this.idempotencyKey = idempotencyKey;
        this.tenderId = tenderId;
        this.reason = reason;
        this.amountMoney = amountMoney;
    }

    private final String idempotencyKey;
    private final String tenderId;
    private final String reason;

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, tenderId, amountMoney, reason);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateRefundRequest)) {
            return false;
        }
        CreateRefundRequest createRefundRequest = (CreateRefundRequest) o;
        return Objects.equals(idempotencyKey, createRefundRequest.idempotencyKey) &&
            Objects.equals(tenderId, createRefundRequest.tenderId) &&
            Objects.equals(amountMoney, createRefundRequest.amountMoney) &&
            Objects.equals(reason, createRefundRequest.reason);
    }

    private final Money amountMoney;
    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this
     * refund among refunds you've created for the tender.
     * If you're unsure whether a particular refund succeeded,
     * you can reattempt it with the same idempotency key without
     * worrying about duplicating the refund.
     * See [Idempotency keys](#idempotencykeys) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() { 
        return this.idempotencyKey;
    }

    /**
     * Getter for TenderId.
     * The ID of the tender to refund.
     * A [`Transaction`](#type-transaction) has one or more `tenders` (i.e., methods
     * of payment) associated with it, and you refund each tender separately with
     * the Connect API.
     */
    @JsonGetter("tender_id")
    public String getTenderId() { 
        return this.tenderId;
    }

    /**
     * Getter for Reason.
     * A description of the reason for the refund.
     * Default value: `Refund via API`
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

 
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            tenderId,
            amountMoney)
            .reason(getReason());
            return builder;
    }

    public static class Builder {
        private String idempotencyKey;
        private String tenderId;
        private Money amountMoney;
        private String reason;

        public Builder(String idempotencyKey,
                String tenderId,
                Money amountMoney) {
            this.idempotencyKey = idempotencyKey;
            this.tenderId = tenderId;
            this.amountMoney = amountMoney;
        }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder tenderId(String value) {
            tenderId = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder reason(String value) {
            reason = value;
            return this;
        }

        public CreateRefundRequest build() {
            return new CreateRefundRequest(idempotencyKey,
                tenderId,
                amountMoney,
                reason);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class RefundPaymentRequest {

    @JsonCreator
    public RefundPaymentRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("reason") String reason) {
        this.idempotencyKey = idempotencyKey;
        this.amountMoney = amountMoney;
        this.appFeeMoney = appFeeMoney;
        this.paymentId = paymentId;
        this.reason = reason;
    }

    private final String idempotencyKey;
    private final Money amountMoney;
    private final Money appFeeMoney;
    private final String paymentId;
    private final String reason;

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, amountMoney, appFeeMoney, paymentId, reason);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RefundPaymentRequest)) {
            return false;
        }
        RefundPaymentRequest refundPaymentRequest = (RefundPaymentRequest) o;
        return Objects.equals(idempotencyKey, refundPaymentRequest.idempotencyKey) &&
            Objects.equals(amountMoney, refundPaymentRequest.amountMoney) &&
            Objects.equals(appFeeMoney, refundPaymentRequest.appFeeMoney) &&
            Objects.equals(paymentId, refundPaymentRequest.paymentId) &&
            Objects.equals(reason, refundPaymentRequest.reason);
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this RefundPayment request. Key can be any valid string but
     * must be unique for every RefundPayment request.
     * For more information, see [Idempotency keys](https://developer.squareup.com/docs/working-with-apis/idempotency).
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
     * Getter for PaymentId.
     * Unique ID of the payment being refunded.
     */
    @JsonGetter("payment_id")
    public String getPaymentId() { 
        return this.paymentId;
    }

    /**
     * Getter for Reason.
     * A description of the reason for the refund.
     */
    @JsonGetter("reason")
    public String getReason() { 
        return this.reason;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            amountMoney)
            .appFeeMoney(getAppFeeMoney())
            .paymentId(getPaymentId())
            .reason(getReason());
            return builder;
    }

    public static class Builder {
        private String idempotencyKey;
        private Money amountMoney;
        private Money appFeeMoney;
        private String paymentId;
        private String reason;

        public Builder(String idempotencyKey,
                Money amountMoney) {
            this.idempotencyKey = idempotencyKey;
            this.amountMoney = amountMoney;
        }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder appFeeMoney(Money value) {
            appFeeMoney = value;
            return this;
        }
        public Builder paymentId(String value) {
            paymentId = value;
            return this;
        }
        public Builder reason(String value) {
            reason = value;
            return this;
        }

        public RefundPaymentRequest build() {
            return new RefundPaymentRequest(idempotencyKey,
                amountMoney,
                appFeeMoney,
                paymentId,
                reason);
        }
    }
}

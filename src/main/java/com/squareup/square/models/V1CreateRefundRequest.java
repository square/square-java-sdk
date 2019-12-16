package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreateRefundRequest {

    @JsonCreator
    public V1CreateRefundRequest(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("type") String type,
            @JsonProperty("reason") String reason,
            @JsonProperty("refunded_money") V1Money refundedMoney,
            @JsonProperty("request_idempotence_key") String requestIdempotenceKey) {
        this.paymentId = paymentId;
        this.type = type;
        this.reason = reason;
        this.refundedMoney = refundedMoney;
        this.requestIdempotenceKey = requestIdempotenceKey;
    }

    private final String paymentId;
    private final String type;
    private final String reason;
    private final V1Money refundedMoney;
    private final String requestIdempotenceKey;

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, type, reason, refundedMoney, requestIdempotenceKey);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1CreateRefundRequest)) {
            return false;
        }
        V1CreateRefundRequest v1CreateRefundRequest = (V1CreateRefundRequest) o;
        return Objects.equals(paymentId, v1CreateRefundRequest.paymentId) &&
            Objects.equals(type, v1CreateRefundRequest.type) &&
            Objects.equals(reason, v1CreateRefundRequest.reason) &&
            Objects.equals(refundedMoney, v1CreateRefundRequest.refundedMoney) &&
            Objects.equals(requestIdempotenceKey, v1CreateRefundRequest.requestIdempotenceKey);
    }

    /**
     * Getter for PaymentId.
     * The ID of the payment to refund. If you are creating a `PARTIAL`
     * refund for a split tender payment, instead provide the id of the
     * particular tender you want to refund.
     */
    @JsonGetter("payment_id")
    public String getPaymentId() { 
        return this.paymentId;
    }

    /**
     * Getter for Type.
     */
    @JsonGetter("type")
    public String getType() { 
        return this.type;
    }

    /**
     * Getter for Reason.
     * The reason for the refund.
     */
    @JsonGetter("reason")
    public String getReason() { 
        return this.reason;
    }

    /**
     * Getter for RefundedMoney.
     */
    @JsonGetter("refunded_money")
    public V1Money getRefundedMoney() { 
        return this.refundedMoney;
    }

    /**
     * Getter for RequestIdempotenceKey.
     * An optional key to ensure idempotence if you issue the same PARTIAL refund request more than once.
     */
    @JsonGetter("request_idempotence_key")
    public String getRequestIdempotenceKey() { 
        return this.requestIdempotenceKey;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(paymentId,
            type,
            reason)
            .refundedMoney(getRefundedMoney())
            .requestIdempotenceKey(getRequestIdempotenceKey());
            return builder;
    }

    public static class Builder {
        private String paymentId;
        private String type;
        private String reason;
        private V1Money refundedMoney;
        private String requestIdempotenceKey;

        public Builder(String paymentId,
                String type,
                String reason) {
            this.paymentId = paymentId;
            this.type = type;
            this.reason = reason;
        }

        public Builder paymentId(String value) {
            paymentId = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder reason(String value) {
            reason = value;
            return this;
        }
        public Builder refundedMoney(V1Money value) {
            refundedMoney = value;
            return this;
        }
        public Builder requestIdempotenceKey(String value) {
            requestIdempotenceKey = value;
            return this;
        }

        public V1CreateRefundRequest build() {
            return new V1CreateRefundRequest(paymentId,
                type,
                reason,
                refundedMoney,
                requestIdempotenceKey);
        }
    }
}

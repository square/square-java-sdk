package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1CreateRefundRequest type.
 */
public class V1CreateRefundRequest {

    /**
     * Initialization constructor.
     * @param paymentId
     * @param type
     * @param reason
     * @param refundedMoney
     * @param requestIdempotenceKey
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(paymentId, type, reason, refundedMoney, requestIdempotenceKey);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1CreateRefundRequest)) {
            return false;
        }
        V1CreateRefundRequest v1CreateRefundRequest = (V1CreateRefundRequest) obj;
        return Objects.equals(paymentId, v1CreateRefundRequest.paymentId) &&
            Objects.equals(type, v1CreateRefundRequest.type) &&
            Objects.equals(reason, v1CreateRefundRequest.reason) &&
            Objects.equals(refundedMoney, v1CreateRefundRequest.refundedMoney) &&
            Objects.equals(requestIdempotenceKey, v1CreateRefundRequest.requestIdempotenceKey);
    }

    /**
     * Builds a new {@link V1CreateRefundRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1CreateRefundRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(paymentId,
            type,
            reason)
            .refundedMoney(getRefundedMoney())
            .requestIdempotenceKey(getRequestIdempotenceKey());
            return builder;
    }

    /**
     * Class to build instances of {@link V1CreateRefundRequest}
     */
    public static class Builder {
        private String paymentId;
        private String type;
        private String reason;
        private V1Money refundedMoney;
        private String requestIdempotenceKey;

        /**
         * Initialization constructor
         */
        public Builder(String paymentId,
                String type,
                String reason) {
            this.paymentId = paymentId;
            this.type = type;
            this.reason = reason;
        }

        /**
         * Setter for paymentId
         * @param paymentId
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }
        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for reason
         * @param reason
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }
        /**
         * Setter for refundedMoney
         * @param refundedMoney
         * @return Builder
         */
        public Builder refundedMoney(V1Money refundedMoney) {
            this.refundedMoney = refundedMoney;
            return this;
        }
        /**
         * Setter for requestIdempotenceKey
         * @param requestIdempotenceKey
         * @return Builder
         */
        public Builder requestIdempotenceKey(String requestIdempotenceKey) {
            this.requestIdempotenceKey = requestIdempotenceKey;
            return this;
        }

        /**
         * Builds a new {@link V1CreateRefundRequest} object using the set fields.
         * @return {@link V1CreateRefundRequest}
         */
        public V1CreateRefundRequest build() {
            return new V1CreateRefundRequest(paymentId,
                type,
                reason,
                refundedMoney,
                requestIdempotenceKey);
        }
    }
}

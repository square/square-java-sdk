package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class PayOrderRequest {

    @JsonCreator
    public PayOrderRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("order_version") Integer orderVersion,
            @JsonProperty("payment_ids") List<String> paymentIds) {
        this.idempotencyKey = idempotencyKey;
        this.orderVersion = orderVersion;
        this.paymentIds = paymentIds;
    }

    private final String idempotencyKey;
    private final Integer orderVersion;
    private final List<String> paymentIds;

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, orderVersion, paymentIds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PayOrderRequest)) {
            return false;
        }
        PayOrderRequest payOrderRequest = (PayOrderRequest) o;
        return Objects.equals(idempotencyKey, payOrderRequest.idempotencyKey) &&
            Objects.equals(orderVersion, payOrderRequest.orderVersion) &&
            Objects.equals(paymentIds, payOrderRequest.paymentIds);
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this request among requests you've sent. If
     * you're unsure whether a particular payment request was completed successfully, you can reattempt
     * it with the same idempotency key without worrying about duplicate payments.
     * See [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency) for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() { 
        return this.idempotencyKey;
    }

    /**
     * Getter for OrderVersion.
     * The version of the order being paid. If not supplied, the latest version will be paid.
     */
    @JsonGetter("order_version")
    public Integer getOrderVersion() { 
        return this.orderVersion;
    }

    /**
     * Getter for PaymentIds.
     */
    @JsonGetter("payment_ids")
    public List<String> getPaymentIds() { 
        return this.paymentIds;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
            .orderVersion(getOrderVersion())
            .paymentIds(getPaymentIds());
            return builder;
    }

    public static class Builder {
        private String idempotencyKey;
        private Integer orderVersion;
        private List<String> paymentIds;

        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }
        public Builder orderVersion(Integer value) {
            orderVersion = value;
            return this;
        }
        public Builder paymentIds(List<String> value) {
            paymentIds = value;
            return this;
        }

        public PayOrderRequest build() {
            return new PayOrderRequest(idempotencyKey,
                orderVersion,
                paymentIds);
        }
    }
}

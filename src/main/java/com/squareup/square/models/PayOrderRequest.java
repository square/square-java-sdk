package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for PayOrderRequest type.
 */
public class PayOrderRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param orderVersion
     * @param paymentIds
     */
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
     * The IDs of the [payments](#type-payment) to collect.
     * The payment total must match the order total.
     */
    @JsonGetter("payment_ids")
    public List<String> getPaymentIds() {
        return this.paymentIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, orderVersion, paymentIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof PayOrderRequest)) {
            return false;
        }
        PayOrderRequest payOrderRequest = (PayOrderRequest) obj;
        return Objects.equals(idempotencyKey, payOrderRequest.idempotencyKey) &&
            Objects.equals(orderVersion, payOrderRequest.orderVersion) &&
            Objects.equals(paymentIds, payOrderRequest.paymentIds);
    }

    /**
     * Builds a new {@link PayOrderRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PayOrderRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
            .orderVersion(getOrderVersion())
            .paymentIds(getPaymentIds());
            return builder;
    }

    /**
     * Class to build instances of {@link PayOrderRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private Integer orderVersion;
        private List<String> paymentIds;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for orderVersion
         * @param orderVersion
         * @return Builder
         */
        public Builder orderVersion(Integer orderVersion) {
            this.orderVersion = orderVersion;
            return this;
        }
        /**
         * Setter for paymentIds
         * @param paymentIds
         * @return Builder
         */
        public Builder paymentIds(List<String> paymentIds) {
            this.paymentIds = paymentIds;
            return this;
        }

        /**
         * Builds a new {@link PayOrderRequest} object using the set fields.
         * @return {@link PayOrderRequest}
         */
        public PayOrderRequest build() {
            return new PayOrderRequest(idempotencyKey,
                orderVersion,
                paymentIds);
        }
    }
}

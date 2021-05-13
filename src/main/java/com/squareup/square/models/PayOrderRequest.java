
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for PayOrderRequest type.
 */
public class PayOrderRequest {
    private final String idempotencyKey;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer orderVersion;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> paymentIds;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  orderVersion  Integer value for orderVersion.
     * @param  paymentIds  List of String value for paymentIds.
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

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this request among requests you have sent. If
     * you are unsure whether a particular payment request was completed successfully, you can
     * reattempt it with the same idempotency key without worrying about duplicate payments. For
     * more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for OrderVersion.
     * The version of the order being paid. If not supplied, the latest version will be paid.
     * @return Returns the Integer
     */
    @JsonGetter("order_version")
    public Integer getOrderVersion() {
        return orderVersion;
    }

    /**
     * Getter for PaymentIds.
     * The IDs of the [payments]($m/Payment) to collect. The payment total must match the order
     * total.
     * @return Returns the List of String
     */
    @JsonGetter("payment_ids")
    public List<String> getPaymentIds() {
        return paymentIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, orderVersion, paymentIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayOrderRequest)) {
            return false;
        }
        PayOrderRequest other = (PayOrderRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(orderVersion, other.orderVersion)
            && Objects.equals(paymentIds, other.paymentIds);
    }

    /**
     * Converts this PayOrderRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PayOrderRequest [" + "idempotencyKey=" + idempotencyKey + ", orderVersion="
                + orderVersion + ", paymentIds=" + paymentIds + "]";
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
     * Class to build instances of {@link PayOrderRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private Integer orderVersion;
        private List<String> paymentIds;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for orderVersion.
         * @param  orderVersion  Integer value for orderVersion.
         * @return Builder
         */
        public Builder orderVersion(Integer orderVersion) {
            this.orderVersion = orderVersion;
            return this;
        }

        /**
         * Setter for paymentIds.
         * @param  paymentIds  List of String value for paymentIds.
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
            return new PayOrderRequest(idempotencyKey, orderVersion, paymentIds);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CloneOrderRequest type.
 */
public class CloneOrderRequest {
    private final String orderId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param  orderId  String value for orderId.
     * @param  version  Integer value for version.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CloneOrderRequest(
            @JsonProperty("order_id") String orderId,
            @JsonProperty("version") Integer version,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.orderId = orderId;
        this.version = version;
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for OrderId.
     * The ID of the order to clone.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for Version.
     * An optional order version for concurrency protection. If a version is provided, it must match
     * the latest stored version of the order to clone. If a version is not provided, the API clones
     * the latest version.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this clone request. If you are unsure whether a
     * particular order was cloned successfully, you can reattempt the call with the same
     * idempotency key without worrying about creating duplicate cloned orders. The originally
     * cloned order is returned. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, version, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CloneOrderRequest)) {
            return false;
        }
        CloneOrderRequest other = (CloneOrderRequest) obj;
        return Objects.equals(orderId, other.orderId)
            && Objects.equals(version, other.version)
            && Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CloneOrderRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CloneOrderRequest [" + "orderId=" + orderId + ", version=" + version
                + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CloneOrderRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CloneOrderRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(orderId)
                .version(getVersion())
                .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CloneOrderRequest}.
     */
    public static class Builder {
        private String orderId;
        private Integer version;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  orderId  String value for orderId.
         */
        public Builder(String orderId) {
            this.orderId = orderId;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
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
         * Builds a new {@link CloneOrderRequest} object using the set fields.
         * @return {@link CloneOrderRequest}
         */
        public CloneOrderRequest build() {
            return new CloneOrderRequest(orderId, version, idempotencyKey);
        }
    }
}

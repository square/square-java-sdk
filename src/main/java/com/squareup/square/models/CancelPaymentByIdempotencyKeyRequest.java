
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CancelPaymentByIdempotencyKeyRequest type.
 */
public class CancelPaymentByIdempotencyKeyRequest {
    private final String idempotencyKey;

    /**
     * Initialization constructor.
     * @param idempotencyKey String value for idempotencyKey.
     */
    @JsonCreator
    public CancelPaymentByIdempotencyKeyRequest(
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    /**
     * Getter for IdempotencyKey.
     * The `idempotency_key` identifying the payment to be canceled.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelPaymentByIdempotencyKeyRequest)) {
            return false;
        }
        CancelPaymentByIdempotencyKeyRequest other = (CancelPaymentByIdempotencyKeyRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey);
    }

    /**
     * Converts this CancelPaymentByIdempotencyKeyRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CancelPaymentByIdempotencyKeyRequest [" + "idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CancelPaymentByIdempotencyKeyRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CancelPaymentByIdempotencyKeyRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey);
        return builder;
    }

    /**
     * Class to build instances of {@link CancelPaymentByIdempotencyKeyRequest}.
     */
    public static class Builder {
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param idempotencyKey String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CancelPaymentByIdempotencyKeyRequest} object using the set fields.
         * @return {@link CancelPaymentByIdempotencyKeyRequest}
         */
        public CancelPaymentByIdempotencyKeyRequest build() {
            return new CancelPaymentByIdempotencyKeyRequest(idempotencyKey);
        }
    }
}

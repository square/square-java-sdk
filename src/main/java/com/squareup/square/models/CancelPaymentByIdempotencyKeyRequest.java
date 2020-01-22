package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CancelPaymentByIdempotencyKeyRequest type.
 */
public class CancelPaymentByIdempotencyKeyRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     */
    @JsonCreator
    public CancelPaymentByIdempotencyKeyRequest(
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    private final String idempotencyKey;
    /**
     * Getter for IdempotencyKey.
     * `idempotency_key` identifying the payment to be canceled.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CancelPaymentByIdempotencyKeyRequest)) {
            return false;
        }
        CancelPaymentByIdempotencyKeyRequest cancelPaymentByIdempotencyKeyRequest = (CancelPaymentByIdempotencyKeyRequest) obj;
        return Objects.equals(idempotencyKey, cancelPaymentByIdempotencyKeyRequest.idempotencyKey);
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
     * Class to build instances of {@link CancelPaymentByIdempotencyKeyRequest}
     */
    public static class Builder {
        private String idempotencyKey;

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
         * Builds a new {@link CancelPaymentByIdempotencyKeyRequest} object using the set fields.
         * @return {@link CancelPaymentByIdempotencyKeyRequest}
         */
        public CancelPaymentByIdempotencyKeyRequest build() {
            return new CancelPaymentByIdempotencyKeyRequest(idempotencyKey);
        }
    }
}

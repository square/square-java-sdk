package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CancelPaymentByIdempotencyKeyRequest {

    @JsonCreator
    public CancelPaymentByIdempotencyKeyRequest(
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    private final String idempotencyKey;

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CancelPaymentByIdempotencyKeyRequest)) {
            return false;
        }
        CancelPaymentByIdempotencyKeyRequest cancelPaymentByIdempotencyKeyRequest = (CancelPaymentByIdempotencyKeyRequest) o;
        return Objects.equals(idempotencyKey, cancelPaymentByIdempotencyKeyRequest.idempotencyKey);
    }

    /**
     * Getter for IdempotencyKey.
     * `idempotency_key` identifying the payment to be canceled.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() { 
        return this.idempotencyKey;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey);
            return builder;
    }

    public static class Builder {
        private String idempotencyKey;

        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }

        public CancelPaymentByIdempotencyKeyRequest build() {
            return new CancelPaymentByIdempotencyKeyRequest(idempotencyKey);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateBreakTypeRequest {

    @JsonCreator
    public CreateBreakTypeRequest(
            @JsonProperty("break_type") BreakType breakType,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.breakType = breakType;
    }

    private final String idempotencyKey;

    @Override
    public int hashCode() {
        return Objects.hash(breakType, idempotencyKey);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateBreakTypeRequest)) {
            return false;
        }
        CreateBreakTypeRequest createBreakTypeRequest = (CreateBreakTypeRequest) o;
        return Objects.equals(breakType, createBreakTypeRequest.breakType) &&
            Objects.equals(idempotencyKey, createBreakTypeRequest.idempotencyKey);
    }

    private final BreakType breakType;
    /**
     * Getter for IdempotencyKey.
     * Unique string value to insure idempotency of the operation
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() { 
        return this.idempotencyKey;
    }

    /**
     * Getter for BreakType.
     * A defined break template that sets an expectation for possible `Break` 
     * instances on a `Shift`.
     */
    @JsonGetter("break_type")
    public BreakType getBreakType() { 
        return this.breakType;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(breakType)
            .idempotencyKey(getIdempotencyKey());
            return builder;
    }

    public static class Builder {
        private BreakType breakType;
        private String idempotencyKey;

        public Builder(BreakType breakType) {
            this.breakType = breakType;
        }

        public Builder breakType(BreakType value) {
            breakType = value;
            return this;
        }
        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }

        public CreateBreakTypeRequest build() {
            return new CreateBreakTypeRequest(breakType,
                idempotencyKey);
        }
    }
}

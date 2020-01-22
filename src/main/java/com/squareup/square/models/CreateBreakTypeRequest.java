package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateBreakTypeRequest type.
 */
public class CreateBreakTypeRequest {

    /**
     * Initialization constructor.
     * @param breakType
     * @param idempotencyKey
     */
    @JsonCreator
    public CreateBreakTypeRequest(
            @JsonProperty("break_type") BreakType breakType,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.breakType = breakType;
    }

    private final String idempotencyKey;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, breakType);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateBreakTypeRequest)) {
            return false;
        }
        CreateBreakTypeRequest createBreakTypeRequest = (CreateBreakTypeRequest) obj;
        return Objects.equals(idempotencyKey, createBreakTypeRequest.idempotencyKey) &&
            Objects.equals(breakType, createBreakTypeRequest.breakType);
    }

    /**
     * Builds a new {@link CreateBreakTypeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateBreakTypeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(breakType)
            .idempotencyKey(getIdempotencyKey());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateBreakTypeRequest}
     */
    public static class Builder {
        private BreakType breakType;
        private String idempotencyKey;

        /**
         * Initialization constructor
         */
        public Builder(BreakType breakType) {
            this.breakType = breakType;
        }

        /**
         * Setter for breakType
         * @param breakType
         * @return Builder
         */
        public Builder breakType(BreakType breakType) {
            this.breakType = breakType;
            return this;
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
         * Builds a new {@link CreateBreakTypeRequest} object using the set fields.
         * @return {@link CreateBreakTypeRequest}
         */
        public CreateBreakTypeRequest build() {
            return new CreateBreakTypeRequest(breakType,
                idempotencyKey);
        }
    }
}

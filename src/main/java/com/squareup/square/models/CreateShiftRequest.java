package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateShiftRequest {

    @JsonCreator
    public CreateShiftRequest(
            @JsonProperty("shift") Shift shift,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.shift = shift;
    }

    private final String idempotencyKey;

    @Override
    public int hashCode() {
        return Objects.hash(shift, idempotencyKey);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateShiftRequest)) {
            return false;
        }
        CreateShiftRequest createShiftRequest = (CreateShiftRequest) o;
        return Objects.equals(shift, createShiftRequest.shift) &&
            Objects.equals(idempotencyKey, createShiftRequest.idempotencyKey);
    }

    private final Shift shift;
    /**
     * Getter for IdempotencyKey.
     * Unique string value to insure the idempotency of the operation.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() { 
        return this.idempotencyKey;
    }

    /**
     * Getter for Shift.
     * A record of the hourly rate, start, and end times for a single work shift 
     * for an employee. May include a record of the start and end times for breaks 
     * taken during the shift.
     */
    @JsonGetter("shift")
    public Shift getShift() { 
        return this.shift;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(shift)
            .idempotencyKey(getIdempotencyKey());
            return builder;
    }

    public static class Builder {
        private Shift shift;
        private String idempotencyKey;

        public Builder(Shift shift) {
            this.shift = shift;
        }

        public Builder shift(Shift value) {
            shift = value;
            return this;
        }
        public Builder idempotencyKey(String value) {
            idempotencyKey = value;
            return this;
        }

        public CreateShiftRequest build() {
            return new CreateShiftRequest(shift,
                idempotencyKey);
        }
    }
}

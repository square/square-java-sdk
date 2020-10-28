
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for CreateShiftRequest type.
 */
public class CreateShiftRequest {
    private final String idempotencyKey;
    private final Shift shift;

    /**
     * Initialization constructor.
     * @param shift Shift value for shift.
     * @param idempotencyKey String value for idempotencyKey.
     */
    @JsonCreator
    public CreateShiftRequest(
            @JsonProperty("shift") Shift shift,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.shift = shift;
    }

    /**
     * Getter for IdempotencyKey.
     * Unique string value to insure the idempotency of the operation.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for Shift.
     * A record of the hourly rate, start, and end times for a single work shift for an employee.
     * May include a record of the start and end times for breaks taken during the shift.
     * @return Returns the Shift
     */
    @JsonGetter("shift")
    public Shift getShift() {
        return this.shift;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, shift);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateShiftRequest)) {
            return false;
        }
        CreateShiftRequest other = (CreateShiftRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(shift, other.shift);
    }

    /**
     * Builds a new {@link CreateShiftRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateShiftRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(shift)
            .idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateShiftRequest}.
     */
    public static class Builder {
        private Shift shift;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param shift Shift value for shift.
         */
        public Builder(Shift shift) {
            this.shift = shift;
        }

        /**
         * Setter for shift.
         * @param shift Shift value for shift.
         * @return Builder
         */
        public Builder shift(Shift shift) {
            this.shift = shift;
            return this;
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
         * Builds a new {@link CreateShiftRequest} object using the set fields.
         * @return {@link CreateShiftRequest}
         */
        public CreateShiftRequest build() {
            return new CreateShiftRequest(shift,
                idempotencyKey);
        }
    }
}

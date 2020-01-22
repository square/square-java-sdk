package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateShiftRequest type.
 */
public class UpdateShiftRequest {

    /**
     * Initialization constructor.
     * @param shift
     */
    @JsonCreator
    public UpdateShiftRequest(
            @JsonProperty("shift") Shift shift) {
        this.shift = shift;
    }

    private final Shift shift;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(shift);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateShiftRequest)) {
            return false;
        }
        UpdateShiftRequest updateShiftRequest = (UpdateShiftRequest) obj;
        return Objects.equals(shift, updateShiftRequest.shift);
    }

    /**
     * Builds a new {@link UpdateShiftRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateShiftRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(shift);
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateShiftRequest}
     */
    public static class Builder {
        private Shift shift;

        /**
         * Initialization constructor
         */
        public Builder(Shift shift) {
            this.shift = shift;
        }

        /**
         * Setter for shift
         * @param shift
         * @return Builder
         */
        public Builder shift(Shift shift) {
            this.shift = shift;
            return this;
        }

        /**
         * Builds a new {@link UpdateShiftRequest} object using the set fields.
         * @return {@link UpdateShiftRequest}
         */
        public UpdateShiftRequest build() {
            return new UpdateShiftRequest(shift);
        }
    }
}

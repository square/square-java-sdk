package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class UpdateShiftRequest {

    @JsonCreator
    public UpdateShiftRequest(
            @JsonProperty("shift") Shift shift) {
        this.shift = shift;
    }

    private final Shift shift;

    @Override
    public int hashCode() {
        return Objects.hash(shift);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateShiftRequest)) {
            return false;
        }
        UpdateShiftRequest updateShiftRequest = (UpdateShiftRequest) o;
        return Objects.equals(shift, updateShiftRequest.shift);
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
        Builder builder = new Builder(shift);
            return builder;
    }

    public static class Builder {
        private Shift shift;

        public Builder(Shift shift) {
            this.shift = shift;
        }

        public Builder shift(Shift value) {
            shift = value;
            return this;
        }

        public UpdateShiftRequest build() {
            return new UpdateShiftRequest(shift);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class UpdateBreakTypeRequest {

    @JsonCreator
    public UpdateBreakTypeRequest(
            @JsonProperty("break_type") BreakType breakType) {
        this.breakType = breakType;
    }

    private final BreakType breakType;

    @Override
    public int hashCode() {
        return Objects.hash(breakType);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateBreakTypeRequest)) {
            return false;
        }
        UpdateBreakTypeRequest updateBreakTypeRequest = (UpdateBreakTypeRequest) o;
        return Objects.equals(breakType, updateBreakTypeRequest.breakType);
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
        Builder builder = new Builder(breakType);
            return builder;
    }

    public static class Builder {
        private BreakType breakType;

        public Builder(BreakType breakType) {
            this.breakType = breakType;
        }

        public Builder breakType(BreakType value) {
            breakType = value;
            return this;
        }

        public UpdateBreakTypeRequest build() {
            return new UpdateBreakTypeRequest(breakType);
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateBreakTypeRequest type.
 */
public class UpdateBreakTypeRequest {

    /**
     * Initialization constructor.
     * @param breakType
     */
    @JsonCreator
    public UpdateBreakTypeRequest(
            @JsonProperty("break_type") BreakType breakType) {
        this.breakType = breakType;
    }

    private final BreakType breakType;
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
        return Objects.hash(breakType);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateBreakTypeRequest)) {
            return false;
        }
        UpdateBreakTypeRequest updateBreakTypeRequest = (UpdateBreakTypeRequest) obj;
        return Objects.equals(breakType, updateBreakTypeRequest.breakType);
    }

    /**
     * Builds a new {@link UpdateBreakTypeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateBreakTypeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(breakType);
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateBreakTypeRequest}
     */
    public static class Builder {
        private BreakType breakType;

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
         * Builds a new {@link UpdateBreakTypeRequest} object using the set fields.
         * @return {@link UpdateBreakTypeRequest}
         */
        public UpdateBreakTypeRequest build() {
            return new UpdateBreakTypeRequest(breakType);
        }
    }
}

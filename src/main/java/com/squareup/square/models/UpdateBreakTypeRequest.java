
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for UpdateBreakTypeRequest type.
 */
public class UpdateBreakTypeRequest {
    private final BreakType breakType;

    /**
     * Initialization constructor.
     * @param breakType BreakType value for breakType.
     */
    @JsonCreator
    public UpdateBreakTypeRequest(
            @JsonProperty("break_type") BreakType breakType) {
        this.breakType = breakType;
    }

    /**
     * Getter for BreakType.
     * A defined break template that sets an expectation for possible `Break` instances on a
     * `Shift`.
     * @return Returns the BreakType
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateBreakTypeRequest)) {
            return false;
        }
        UpdateBreakTypeRequest other = (UpdateBreakTypeRequest) obj;
        return Objects.equals(breakType, other.breakType);
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
     * Class to build instances of {@link UpdateBreakTypeRequest}.
     */
    public static class Builder {
        private BreakType breakType;

        /**
         * Initialization constructor.
         * @param breakType BreakType value for breakType.
         */
        public Builder(BreakType breakType) {
            this.breakType = breakType;
        }

        /**
         * Setter for breakType.
         * @param breakType BreakType value for breakType.
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

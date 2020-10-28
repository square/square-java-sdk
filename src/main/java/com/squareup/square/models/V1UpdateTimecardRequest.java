
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for V1UpdateTimecardRequest type.
 */
public class V1UpdateTimecardRequest {
    private final V1Timecard body;

    /**
     * Initialization constructor.
     * @param body V1Timecard value for body.
     */
    @JsonCreator
    public V1UpdateTimecardRequest(
            @JsonProperty("body") V1Timecard body) {
        this.body = body;
    }

    /**
     * Getter for Body.
     * Represents a timecard for an employee.
     * @return Returns the V1Timecard
     */
    @JsonGetter("body")
    public V1Timecard getBody() {
        return this.body;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1UpdateTimecardRequest)) {
            return false;
        }
        V1UpdateTimecardRequest other = (V1UpdateTimecardRequest) obj;
        return Objects.equals(body, other.body);
    }

    /**
     * Builds a new {@link V1UpdateTimecardRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateTimecardRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
        return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateTimecardRequest}.
     */
    public static class Builder {
        private V1Timecard body;

        /**
         * Initialization constructor.
         * @param body V1Timecard value for body.
         */
        public Builder(V1Timecard body) {
            this.body = body;
        }

        /**
         * Setter for body.
         * @param body V1Timecard value for body.
         * @return Builder
         */
        public Builder body(V1Timecard body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateTimecardRequest} object using the set fields.
         * @return {@link V1UpdateTimecardRequest}
         */
        public V1UpdateTimecardRequest build() {
            return new V1UpdateTimecardRequest(body);
        }
    }
}

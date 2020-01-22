package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateEmployeeRequest type.
 */
public class V1UpdateEmployeeRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1UpdateEmployeeRequest(
            @JsonProperty("body") V1Employee body) {
        this.body = body;
    }

    private final V1Employee body;
    /**
     * Getter for Body.
     * Represents one of a business's employees.
     */
    @JsonGetter("body")
    public V1Employee getBody() {
        return this.body;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1UpdateEmployeeRequest)) {
            return false;
        }
        V1UpdateEmployeeRequest v1UpdateEmployeeRequest = (V1UpdateEmployeeRequest) obj;
        return Objects.equals(body, v1UpdateEmployeeRequest.body);
    }

    /**
     * Builds a new {@link V1UpdateEmployeeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateEmployeeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateEmployeeRequest}
     */
    public static class Builder {
        private V1Employee body;

        /**
         * Initialization constructor
         */
        public Builder(V1Employee body) {
            this.body = body;
        }

        /**
         * Setter for body
         * @param body
         * @return Builder
         */
        public Builder body(V1Employee body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateEmployeeRequest} object using the set fields.
         * @return {@link V1UpdateEmployeeRequest}
         */
        public V1UpdateEmployeeRequest build() {
            return new V1UpdateEmployeeRequest(body);
        }
    }
}

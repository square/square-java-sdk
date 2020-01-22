package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateEmployeeRoleRequest type.
 */
public class V1UpdateEmployeeRoleRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1UpdateEmployeeRoleRequest(
            @JsonProperty("body") V1EmployeeRole body) {
        this.body = body;
    }

    private final V1EmployeeRole body;
    /**
     * Getter for Body.
     * V1EmployeeRole
     */
    @JsonGetter("body")
    public V1EmployeeRole getBody() {
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
        if(!(obj instanceof V1UpdateEmployeeRoleRequest)) {
            return false;
        }
        V1UpdateEmployeeRoleRequest v1UpdateEmployeeRoleRequest = (V1UpdateEmployeeRoleRequest) obj;
        return Objects.equals(body, v1UpdateEmployeeRoleRequest.body);
    }

    /**
     * Builds a new {@link V1UpdateEmployeeRoleRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateEmployeeRoleRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateEmployeeRoleRequest}
     */
    public static class Builder {
        private V1EmployeeRole body;

        /**
         * Initialization constructor
         */
        public Builder(V1EmployeeRole body) {
            this.body = body;
        }

        /**
         * Setter for body
         * @param body
         * @return Builder
         */
        public Builder body(V1EmployeeRole body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateEmployeeRoleRequest} object using the set fields.
         * @return {@link V1UpdateEmployeeRoleRequest}
         */
        public V1UpdateEmployeeRoleRequest build() {
            return new V1UpdateEmployeeRoleRequest(body);
        }
    }
}

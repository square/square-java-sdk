package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1CreateEmployeeRoleRequest type.
 */
public class V1CreateEmployeeRoleRequest {

    /**
     * Initialization constructor.
     * @param employeeRole
     */
    @JsonCreator
    public V1CreateEmployeeRoleRequest(
            @JsonProperty("employee_role") V1EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    private final V1EmployeeRole employeeRole;
    /**
     * Getter for EmployeeRole.
     * V1EmployeeRole
     */
    @JsonGetter("employee_role")
    public V1EmployeeRole getEmployeeRole() {
        return this.employeeRole;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(employeeRole);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1CreateEmployeeRoleRequest)) {
            return false;
        }
        V1CreateEmployeeRoleRequest v1CreateEmployeeRoleRequest = (V1CreateEmployeeRoleRequest) obj;
        return Objects.equals(employeeRole, v1CreateEmployeeRoleRequest.employeeRole);
    }

    /**
     * Builds a new {@link V1CreateEmployeeRoleRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1CreateEmployeeRoleRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .employeeRole(getEmployeeRole());
            return builder;
    }

    /**
     * Class to build instances of {@link V1CreateEmployeeRoleRequest}
     */
    public static class Builder {
        private V1EmployeeRole employeeRole;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for employeeRole
         * @param employeeRole
         * @return Builder
         */
        public Builder employeeRole(V1EmployeeRole employeeRole) {
            this.employeeRole = employeeRole;
            return this;
        }

        /**
         * Builds a new {@link V1CreateEmployeeRoleRequest} object using the set fields.
         * @return {@link V1CreateEmployeeRoleRequest}
         */
        public V1CreateEmployeeRoleRequest build() {
            return new V1CreateEmployeeRoleRequest(employeeRole);
        }
    }
}

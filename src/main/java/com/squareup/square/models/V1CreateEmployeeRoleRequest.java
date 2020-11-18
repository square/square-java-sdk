
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1CreateEmployeeRoleRequest type.
 */
public class V1CreateEmployeeRoleRequest {
    private final V1EmployeeRole employeeRole;

    /**
     * Initialization constructor.
     * @param employeeRole V1EmployeeRole value for employeeRole.
     */
    @JsonCreator
    public V1CreateEmployeeRoleRequest(
            @JsonProperty("employee_role") V1EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    /**
     * Getter for EmployeeRole.
     * V1EmployeeRole
     * @return Returns the V1EmployeeRole
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1CreateEmployeeRoleRequest)) {
            return false;
        }
        V1CreateEmployeeRoleRequest other = (V1CreateEmployeeRoleRequest) obj;
        return Objects.equals(employeeRole, other.employeeRole);
    }

    /**
     * Converts this V1CreateEmployeeRoleRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1CreateEmployeeRoleRequest [" + "employeeRole=" + employeeRole + "]";
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
     * Class to build instances of {@link V1CreateEmployeeRoleRequest}.
     */
    public static class Builder {
        private V1EmployeeRole employeeRole;



        /**
         * Setter for employeeRole.
         * @param employeeRole V1EmployeeRole value for employeeRole.
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

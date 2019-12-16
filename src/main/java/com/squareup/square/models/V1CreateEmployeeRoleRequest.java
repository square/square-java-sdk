package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1CreateEmployeeRoleRequest {

    @JsonCreator
    public V1CreateEmployeeRoleRequest(
            @JsonProperty("employee_role") V1EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    private final V1EmployeeRole employeeRole;

    @Override
    public int hashCode() {
        return Objects.hash(employeeRole);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1CreateEmployeeRoleRequest)) {
            return false;
        }
        V1CreateEmployeeRoleRequest v1CreateEmployeeRoleRequest = (V1CreateEmployeeRoleRequest) o;
        return Objects.equals(employeeRole, v1CreateEmployeeRoleRequest.employeeRole);
    }

    /**
     * Getter for EmployeeRole.
     * V1EmployeeRole
     */
    @JsonGetter("employee_role")
    public V1EmployeeRole getEmployeeRole() { 
        return this.employeeRole;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .employeeRole(getEmployeeRole());
            return builder;
    }

    public static class Builder {
        private V1EmployeeRole employeeRole;

        public Builder() { }

        public Builder employeeRole(V1EmployeeRole value) {
            employeeRole = value;
            return this;
        }

        public V1CreateEmployeeRoleRequest build() {
            return new V1CreateEmployeeRoleRequest(employeeRole);
        }
    }
}

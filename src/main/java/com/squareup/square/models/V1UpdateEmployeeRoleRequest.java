package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateEmployeeRoleRequest {

    @JsonCreator
    public V1UpdateEmployeeRoleRequest(
            @JsonProperty("body") V1EmployeeRole body) {
        this.body = body;
    }

    private final V1EmployeeRole body;

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1UpdateEmployeeRoleRequest)) {
            return false;
        }
        V1UpdateEmployeeRoleRequest v1UpdateEmployeeRoleRequest = (V1UpdateEmployeeRoleRequest) o;
        return Objects.equals(body, v1UpdateEmployeeRoleRequest.body);
    }

    /**
     * Getter for Body.
     * V1EmployeeRole
     */
    @JsonGetter("body")
    public V1EmployeeRole getBody() { 
        return this.body;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    public static class Builder {
        private V1EmployeeRole body;

        public Builder(V1EmployeeRole body) {
            this.body = body;
        }

        public Builder body(V1EmployeeRole value) {
            body = value;
            return this;
        }

        public V1UpdateEmployeeRoleRequest build() {
            return new V1UpdateEmployeeRoleRequest(body);
        }
    }
}

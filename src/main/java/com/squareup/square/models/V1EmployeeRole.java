package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1EmployeeRole {

    @JsonCreator
    public V1EmployeeRole(
            @JsonProperty("name") String name,
            @JsonProperty("permissions") List<String> permissions,
            @JsonProperty("id") String id,
            @JsonProperty("is_owner") Boolean isOwner,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
        this.isOwner = isOwner;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final List<String> permissions;
    private final Boolean isOwner;
    private final String createdAt;
    private final String updatedAt;

    @Override
    public int hashCode() {
        return Objects.hash(name, permissions, id, isOwner, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1EmployeeRole)) {
            return false;
        }
        V1EmployeeRole v1EmployeeRole = (V1EmployeeRole) o;
        return Objects.equals(name, v1EmployeeRole.name) &&
            Objects.equals(permissions, v1EmployeeRole.permissions) &&
            Objects.equals(id, v1EmployeeRole.id) &&
            Objects.equals(isOwner, v1EmployeeRole.isOwner) &&
            Objects.equals(createdAt, v1EmployeeRole.createdAt) &&
            Objects.equals(updatedAt, v1EmployeeRole.updatedAt);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The role's unique ID, Can only be set by Square.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Name.
     * The role's merchant-defined name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for Permissions.
     * The role's permissions.
     * See [V1EmployeeRolePermissions](#type-v1employeerolepermissions) for possible values
     */
    @JsonGetter("permissions")
    public List<String> getPermissions() { 
        return this.permissions;
    }

    /**
     * Getter for IsOwner.
     * If true, employees with this role have all permissions, regardless of the values indicated in permissions.
     */
    @JsonGetter("is_owner")
    public Boolean getIsOwner() { 
        return this.isOwner;
    }

    /**
     * Getter for CreatedAt.
     * The time when the employee entity was created, in ISO 8601 format. Is set by Square when the Role is created.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the employee entity was most recently updated, in ISO 8601 format. Is set by Square when the Role updated.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(name,
            permissions)
            .id(getId())
            .isOwner(getIsOwner())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String name;
        private List<String> permissions;
        private String id;
        private Boolean isOwner;
        private String createdAt;
        private String updatedAt;

        public Builder(String name,
                List<String> permissions) {
            this.name = name;
            this.permissions = permissions;
        }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder permissions(List<String> value) {
            permissions = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder isOwner(Boolean value) {
            isOwner = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder updatedAt(String value) {
            updatedAt = value;
            return this;
        }

        public V1EmployeeRole build() {
            V1EmployeeRole model = new V1EmployeeRole(name,
                permissions,
                id,
                isOwner,
                createdAt,
                updatedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}

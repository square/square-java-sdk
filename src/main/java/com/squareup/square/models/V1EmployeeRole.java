package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1EmployeeRole type.
 */
public class V1EmployeeRole {

    /**
     * Initialization constructor.
     * @param name
     * @param permissions
     * @param id
     * @param isOwner
     * @param createdAt
     * @param updatedAt
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, permissions, isOwner, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1EmployeeRole)) {
            return false;
        }
        V1EmployeeRole v1EmployeeRole = (V1EmployeeRole) obj;
        return Objects.equals(id, v1EmployeeRole.id) &&
            Objects.equals(name, v1EmployeeRole.name) &&
            Objects.equals(permissions, v1EmployeeRole.permissions) &&
            Objects.equals(isOwner, v1EmployeeRole.isOwner) &&
            Objects.equals(createdAt, v1EmployeeRole.createdAt) &&
            Objects.equals(updatedAt, v1EmployeeRole.updatedAt);
    }

    /**
     * Builds a new {@link V1EmployeeRole.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1EmployeeRole.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name,
            permissions)
            .id(getId())
            .isOwner(getIsOwner())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link V1EmployeeRole}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String name;
        private List<String> permissions;
        private String id;
        private Boolean isOwner;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor
         */
        public Builder(String name,
                List<String> permissions) {
            this.name = name;
            this.permissions = permissions;
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for permissions
         * @param permissions
         * @return Builder
         */
        public Builder permissions(List<String> permissions) {
            this.permissions = permissions;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for isOwner
         * @param isOwner
         * @return Builder
         */
        public Builder isOwner(Boolean isOwner) {
            this.isOwner = isOwner;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link V1EmployeeRole} object using the set fields.
         * @return {@link V1EmployeeRole}
         */
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

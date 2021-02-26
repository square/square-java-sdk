
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1EmployeeRole type.
 */
public class V1EmployeeRole {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    private final String name;
    private final List<String> permissions;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean isOwner;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  permissions  List of String value for permissions.
     * @param  id  String value for id.
     * @param  isOwner  Boolean value for isOwner.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The role's unique ID, Can only be set by Square.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Name.
     * The role's merchant-defined name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Permissions.
     * The role's permissions. See [V1EmployeeRolePermissions](#type-v1employeerolepermissions) for
     * possible values
     * @return Returns the List of String
     */
    @JsonGetter("permissions")
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * Getter for IsOwner.
     * If true, employees with this role have all permissions, regardless of the values indicated in
     * permissions.
     * @return Returns the Boolean
     */
    @JsonGetter("is_owner")
    public Boolean getIsOwner() {
        return isOwner;
    }

    /**
     * Getter for CreatedAt.
     * The time when the employee entity was created, in ISO 8601 format. Is set by Square when the
     * Role is created.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the employee entity was most recently updated, in ISO 8601 format. Is set by
     * Square when the Role updated.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, permissions, isOwner, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1EmployeeRole)) {
            return false;
        }
        V1EmployeeRole other = (V1EmployeeRole) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(permissions, other.permissions)
            && Objects.equals(isOwner, other.isOwner)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this V1EmployeeRole into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1EmployeeRole [" + "name=" + name + ", permissions=" + permissions + ", id=" + id
                + ", isOwner=" + isOwner + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + "]";
    }

    /**
     * Builds a new {@link V1EmployeeRole.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1EmployeeRole.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name, permissions)
                .id(getId())
                .isOwner(getIsOwner())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link V1EmployeeRole}.
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
         * Initialization constructor.
         * @param  name  String value for name.
         * @param  permissions  List of String value for permissions.
         */
        public Builder(String name, List<String> permissions) {
            this.name = name;
            this.permissions = permissions;
        }

        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for permissions.
         * @param  permissions  List of String value for permissions.
         * @return Builder
         */
        public Builder permissions(List<String> permissions) {
            this.permissions = permissions;
            return this;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for isOwner.
         * @param  isOwner  Boolean value for isOwner.
         * @return Builder
         */
        public Builder isOwner(Boolean isOwner) {
            this.isOwner = isOwner;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
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
            V1EmployeeRole model =
                    new V1EmployeeRole(name, permissions, id, isOwner, createdAt, updatedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}

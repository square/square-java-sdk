package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Employee {

    @JsonCreator
    public V1Employee(
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") String lastName,
            @JsonProperty("id") String id,
            @JsonProperty("role_ids") List<String> roleIds,
            @JsonProperty("authorized_location_ids") List<String> authorizedLocationIds,
            @JsonProperty("email") String email,
            @JsonProperty("status") String status,
            @JsonProperty("external_id") String externalId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleIds = roleIds;
        this.authorizedLocationIds = authorizedLocationIds;
        this.email = email;
        this.status = status;
        this.externalId = externalId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private HttpContext httpContext;
    private final String id;
    private final String firstName;
    private final String lastName;
    private final List<String> roleIds;
    private final List<String> authorizedLocationIds;
    private final String email;
    private final String status;
    private final String externalId;
    private final String createdAt;
    private final String updatedAt;

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, roleIds, authorizedLocationIds, email, status, externalId, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Employee)) {
            return false;
        }
        V1Employee v1Employee = (V1Employee) o;
        return Objects.equals(firstName, v1Employee.firstName) &&
            Objects.equals(lastName, v1Employee.lastName) &&
            Objects.equals(id, v1Employee.id) &&
            Objects.equals(roleIds, v1Employee.roleIds) &&
            Objects.equals(authorizedLocationIds, v1Employee.authorizedLocationIds) &&
            Objects.equals(email, v1Employee.email) &&
            Objects.equals(status, v1Employee.status) &&
            Objects.equals(externalId, v1Employee.externalId) &&
            Objects.equals(createdAt, v1Employee.createdAt) &&
            Objects.equals(updatedAt, v1Employee.updatedAt);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The employee's unique ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for FirstName.
     * The employee's first name.
     */
    @JsonGetter("first_name")
    public String getFirstName() { 
        return this.firstName;
    }

    /**
     * Getter for LastName.
     * The employee's last name.
     */
    @JsonGetter("last_name")
    public String getLastName() { 
        return this.lastName;
    }

    /**
     * Getter for RoleIds.
     * The ids of the employee's associated roles. Currently, you can specify only one or zero roles per employee.
     */
    @JsonGetter("role_ids")
    public List<String> getRoleIds() { 
        return this.roleIds;
    }

    /**
     * Getter for AuthorizedLocationIds.
     * The IDs of the locations the employee is allowed to clock in at.
     */
    @JsonGetter("authorized_location_ids")
    public List<String> getAuthorizedLocationIds() { 
        return this.authorizedLocationIds;
    }

    /**
     * Getter for Email.
     * The employee's email address.
     */
    @JsonGetter("email")
    public String getEmail() { 
        return this.email;
    }

    /**
     * Getter for Status.
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
    }

    /**
     * Getter for ExternalId.
     * An ID the merchant can set to associate the employee with an entity in another system.
     */
    @JsonGetter("external_id")
    public String getExternalId() { 
        return this.externalId;
    }

    /**
     * Getter for CreatedAt.
     * The time when the employee entity was created, in ISO 8601 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the employee entity was most recently updated, in ISO 8601 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(firstName,
            lastName)
            .id(getId())
            .roleIds(getRoleIds())
            .authorizedLocationIds(getAuthorizedLocationIds())
            .email(getEmail())
            .status(getStatus())
            .externalId(getExternalId())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String firstName;
        private String lastName;
        private String id;
        private List<String> roleIds;
        private List<String> authorizedLocationIds;
        private String email;
        private String status;
        private String externalId;
        private String createdAt;
        private String updatedAt;

        public Builder(String firstName,
                String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder firstName(String value) {
            firstName = value;
            return this;
        }
        public Builder lastName(String value) {
            lastName = value;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder roleIds(List<String> value) {
            roleIds = value;
            return this;
        }
        public Builder authorizedLocationIds(List<String> value) {
            authorizedLocationIds = value;
            return this;
        }
        public Builder email(String value) {
            email = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder externalId(String value) {
            externalId = value;
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

        public V1Employee build() {
            V1Employee model = new V1Employee(firstName,
                lastName,
                id,
                roleIds,
                authorizedLocationIds,
                email,
                status,
                externalId,
                createdAt,
                updatedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}

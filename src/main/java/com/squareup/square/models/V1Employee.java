
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1Employee type.
 */
public class V1Employee {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    private final String firstName;
    private final String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> roleIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> authorizedLocationIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String externalId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  firstName  String value for firstName.
     * @param  lastName  String value for lastName.
     * @param  id  String value for id.
     * @param  roleIds  List of String value for roleIds.
     * @param  authorizedLocationIds  List of String value for authorizedLocationIds.
     * @param  email  String value for email.
     * @param  status  String value for status.
     * @param  externalId  String value for externalId.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     */
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The employee's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for FirstName.
     * The employee's first name.
     * @return Returns the String
     */
    @JsonGetter("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for LastName.
     * The employee's last name.
     * @return Returns the String
     */
    @JsonGetter("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for RoleIds.
     * The ids of the employee's associated roles. Currently, you can specify only one or zero roles
     * per employee.
     * @return Returns the List of String
     */
    @JsonGetter("role_ids")
    public List<String> getRoleIds() {
        return roleIds;
    }

    /**
     * Getter for AuthorizedLocationIds.
     * The IDs of the locations the employee is allowed to clock in at.
     * @return Returns the List of String
     */
    @JsonGetter("authorized_location_ids")
    public List<String> getAuthorizedLocationIds() {
        return authorizedLocationIds;
    }

    /**
     * Getter for Email.
     * The employee's email address.
     * @return Returns the String
     */
    @JsonGetter("email")
    public String getEmail() {
        return email;
    }

    /**
     * Getter for Status.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Getter for ExternalId.
     * An ID the merchant can set to associate the employee with an entity in another system.
     * @return Returns the String
     */
    @JsonGetter("external_id")
    public String getExternalId() {
        return externalId;
    }

    /**
     * Getter for CreatedAt.
     * The time when the employee entity was created, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the employee entity was most recently updated, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, roleIds, authorizedLocationIds, email, status,
                externalId, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Employee)) {
            return false;
        }
        V1Employee other = (V1Employee) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(firstName, other.firstName)
            && Objects.equals(lastName, other.lastName)
            && Objects.equals(roleIds, other.roleIds)
            && Objects.equals(authorizedLocationIds, other.authorizedLocationIds)
            && Objects.equals(email, other.email)
            && Objects.equals(status, other.status)
            && Objects.equals(externalId, other.externalId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this V1Employee into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1Employee [" + "firstName=" + firstName + ", lastName=" + lastName + ", id=" + id
                + ", roleIds=" + roleIds + ", authorizedLocationIds=" + authorizedLocationIds
                + ", email=" + email + ", status=" + status + ", externalId=" + externalId
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link V1Employee.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Employee.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(firstName, lastName)
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

    /**
     * Class to build instances of {@link V1Employee}.
     */
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

        /**
         * Initialization constructor.
         * @param  firstName  String value for firstName.
         * @param  lastName  String value for lastName.
         */
        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
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
         * Setter for firstName.
         * @param  firstName  String value for firstName.
         * @return Builder
         */
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Setter for lastName.
         * @param  lastName  String value for lastName.
         * @return Builder
         */
        public Builder lastName(String lastName) {
            this.lastName = lastName;
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
         * Setter for roleIds.
         * @param  roleIds  List of String value for roleIds.
         * @return Builder
         */
        public Builder roleIds(List<String> roleIds) {
            this.roleIds = roleIds;
            return this;
        }

        /**
         * Setter for authorizedLocationIds.
         * @param  authorizedLocationIds  List of String value for authorizedLocationIds.
         * @return Builder
         */
        public Builder authorizedLocationIds(List<String> authorizedLocationIds) {
            this.authorizedLocationIds = authorizedLocationIds;
            return this;
        }

        /**
         * Setter for email.
         * @param  email  String value for email.
         * @return Builder
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for externalId.
         * @param  externalId  String value for externalId.
         * @return Builder
         */
        public Builder externalId(String externalId) {
            this.externalId = externalId;
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
         * Builds a new {@link V1Employee} object using the set fields.
         * @return {@link V1Employee}
         */
        public V1Employee build() {
            V1Employee model =
                    new V1Employee(firstName, lastName, id, roleIds, authorizedLocationIds, email,
                            status, externalId, createdAt, updatedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}

package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Employee type.
 */
public class Employee {

    /**
     * Initialization constructor.
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param locationIds
     * @param status
     * @param isOwner
     * @param createdAt
     * @param updatedAt
     */
    @JsonCreator
    public Employee(
            @JsonProperty("id") String id,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("status") String status,
            @JsonProperty("is_owner") Boolean isOwner,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.locationIds = locationIds;
        this.status = status;
        this.isOwner = isOwner;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final List<String> locationIds;
    private final String status;
    private final Boolean isOwner;
    private final String createdAt;
    private final String updatedAt;
    /**
     * Getter for Id.
     * UUID for this object.
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
     * Getter for Email.
     * The employee's email address
     */
    @JsonGetter("email")
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for PhoneNumber.
     * The employee's phone number in E.164 format, i.e. "+12125554250"
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for LocationIds.
     * A list of location IDs where this employee has access to.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for Status.
     * The status of the Employee being retrieved.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for IsOwner.
     * Whether this employee is the owner of the merchant. Each merchant
     * has one owner employee, and that employee has full authority over
     * the account.
     */
    @JsonGetter("is_owner")
    public Boolean getIsOwner() {
        return this.isOwner;
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, locationIds, status,
            isOwner, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) obj;
        return Objects.equals(id, employee.id) &&
            Objects.equals(firstName, employee.firstName) &&
            Objects.equals(lastName, employee.lastName) &&
            Objects.equals(email, employee.email) &&
            Objects.equals(phoneNumber, employee.phoneNumber) &&
            Objects.equals(locationIds, employee.locationIds) &&
            Objects.equals(status, employee.status) &&
            Objects.equals(isOwner, employee.isOwner) &&
            Objects.equals(createdAt, employee.createdAt) &&
            Objects.equals(updatedAt, employee.updatedAt);
    }

    /**
     * Builds a new {@link Employee.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Employee.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .firstName(getFirstName())
            .lastName(getLastName())
            .email(getEmail())
            .phoneNumber(getPhoneNumber())
            .locationIds(getLocationIds())
            .status(getStatus())
            .isOwner(getIsOwner())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link Employee}
     */
    public static class Builder {
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private List<String> locationIds;
        private String status;
        private Boolean isOwner;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for firstName
         * @param firstName
         * @return Builder
         */
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        /**
         * Setter for lastName
         * @param lastName
         * @return Builder
         */
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        /**
         * Setter for email
         * @param email
         * @return Builder
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        /**
         * Setter for phoneNumber
         * @param phoneNumber
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        /**
         * Setter for locationIds
         * @param locationIds
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
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
         * Builds a new {@link Employee} object using the set fields.
         * @return {@link Employee}
         */
        public Employee build() {
            return new Employee(id,
                firstName,
                lastName,
                email,
                phoneNumber,
                locationIds,
                status,
                isOwner,
                createdAt,
                updatedAt);
        }
    }
}

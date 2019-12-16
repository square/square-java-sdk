package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Employee {

    @JsonCreator
    public Employee(
            @JsonProperty("id") String id,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("status") String status,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.locationIds = locationIds;
        this.status = status;
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
    private final String createdAt;
    private final String updatedAt;

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, locationIds, status, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
            Objects.equals(firstName, employee.firstName) &&
            Objects.equals(lastName, employee.lastName) &&
            Objects.equals(email, employee.email) &&
            Objects.equals(phoneNumber, employee.phoneNumber) &&
            Objects.equals(locationIds, employee.locationIds) &&
            Objects.equals(status, employee.status) &&
            Objects.equals(createdAt, employee.createdAt) &&
            Objects.equals(updatedAt, employee.updatedAt);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .firstName(getFirstName())
            .lastName(getLastName())
            .email(getEmail())
            .phoneNumber(getPhoneNumber())
            .locationIds(getLocationIds())
            .status(getStatus())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    public static class Builder {
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private List<String> locationIds;
        private String status;
        private String createdAt;
        private String updatedAt;

        public Builder() { }

        public Builder id(String value) {
            id = value;
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
        public Builder email(String value) {
            email = value;
            return this;
        }
        public Builder phoneNumber(String value) {
            phoneNumber = value;
            return this;
        }
        public Builder locationIds(List<String> value) {
            locationIds = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
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

        public Employee build() {
            return new Employee(id,
                firstName,
                lastName,
                email,
                phoneNumber,
                locationIds,
                status,
                createdAt,
                updatedAt);
        }
    }
}

/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Employee.Builder.class)
public final class Employee {
    private final Optional<String> id;

    private final Optional<String> firstName;

    private final Optional<String> lastName;

    private final Optional<String> email;

    private final Optional<String> phoneNumber;

    private final Optional<List<String>> locationIds;

    private final Optional<EmployeeStatus> status;

    private final Optional<Boolean> isOwner;

    private final Optional<String> createdAt;

    private final Optional<String> updatedAt;

    private final Map<String, Object> additionalProperties;

    private Employee(
            Optional<String> id,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> email,
            Optional<String> phoneNumber,
            Optional<List<String>> locationIds,
            Optional<EmployeeStatus> status,
            Optional<Boolean> isOwner,
            Optional<String> createdAt,
            Optional<String> updatedAt,
            Map<String, Object> additionalProperties) {
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
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return UUID for this object.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The employee's first name.
     */
    @JsonIgnore
    public Optional<String> getFirstName() {
        if (firstName == null) {
            return Optional.empty();
        }
        return firstName;
    }

    /**
     * @return The employee's last name.
     */
    @JsonIgnore
    public Optional<String> getLastName() {
        if (lastName == null) {
            return Optional.empty();
        }
        return lastName;
    }

    /**
     * @return The employee's email address
     */
    @JsonIgnore
    public Optional<String> getEmail() {
        if (email == null) {
            return Optional.empty();
        }
        return email;
    }

    /**
     * @return The employee's phone number in E.164 format, i.e. &quot;+12125554250&quot;
     */
    @JsonIgnore
    public Optional<String> getPhoneNumber() {
        if (phoneNumber == null) {
            return Optional.empty();
        }
        return phoneNumber;
    }

    /**
     * @return A list of location IDs where this employee has access to.
     */
    @JsonIgnore
    public Optional<List<String>> getLocationIds() {
        if (locationIds == null) {
            return Optional.empty();
        }
        return locationIds;
    }

    /**
     * @return Specifies the status of the employees being fetched.
     * See <a href="#type-employeestatus">EmployeeStatus</a> for possible values
     */
    @JsonProperty("status")
    public Optional<EmployeeStatus> getStatus() {
        return status;
    }

    /**
     * @return Whether this employee is the owner of the merchant. Each merchant
     * has one owner employee, and that employee has full authority over
     * the account.
     */
    @JsonIgnore
    public Optional<Boolean> getIsOwner() {
        if (isOwner == null) {
            return Optional.empty();
        }
        return isOwner;
    }

    /**
     * @return A read-only timestamp in RFC 3339 format.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return A read-only timestamp in RFC 3339 format.
     */
    @JsonProperty("updated_at")
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("first_name")
    private Optional<String> _getFirstName() {
        return firstName;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("last_name")
    private Optional<String> _getLastName() {
        return lastName;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("email")
    private Optional<String> _getEmail() {
        return email;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("phone_number")
    private Optional<String> _getPhoneNumber() {
        return phoneNumber;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("location_ids")
    private Optional<List<String>> _getLocationIds() {
        return locationIds;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("is_owner")
    private Optional<Boolean> _getIsOwner() {
        return isOwner;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Employee && equalTo((Employee) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Employee other) {
        return id.equals(other.id)
                && firstName.equals(other.firstName)
                && lastName.equals(other.lastName)
                && email.equals(other.email)
                && phoneNumber.equals(other.phoneNumber)
                && locationIds.equals(other.locationIds)
                && status.equals(other.status)
                && isOwner.equals(other.isOwner)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.firstName,
                this.lastName,
                this.email,
                this.phoneNumber,
                this.locationIds,
                this.status,
                this.isOwner,
                this.createdAt,
                this.updatedAt);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> id = Optional.empty();

        private Optional<String> firstName = Optional.empty();

        private Optional<String> lastName = Optional.empty();

        private Optional<String> email = Optional.empty();

        private Optional<String> phoneNumber = Optional.empty();

        private Optional<List<String>> locationIds = Optional.empty();

        private Optional<EmployeeStatus> status = Optional.empty();

        private Optional<Boolean> isOwner = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Employee other) {
            id(other.getId());
            firstName(other.getFirstName());
            lastName(other.getLastName());
            email(other.getEmail());
            phoneNumber(other.getPhoneNumber());
            locationIds(other.getLocationIds());
            status(other.getStatus());
            isOwner(other.getIsOwner());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        @JsonSetter(value = "first_name", nulls = Nulls.SKIP)
        public Builder firstName(Optional<String> firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = Optional.ofNullable(firstName);
            return this;
        }

        public Builder firstName(Nullable<String> firstName) {
            if (firstName.isNull()) {
                this.firstName = null;
            } else if (firstName.isEmpty()) {
                this.firstName = Optional.empty();
            } else {
                this.firstName = Optional.of(firstName.get());
            }
            return this;
        }

        @JsonSetter(value = "last_name", nulls = Nulls.SKIP)
        public Builder lastName(Optional<String> lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = Optional.ofNullable(lastName);
            return this;
        }

        public Builder lastName(Nullable<String> lastName) {
            if (lastName.isNull()) {
                this.lastName = null;
            } else if (lastName.isEmpty()) {
                this.lastName = Optional.empty();
            } else {
                this.lastName = Optional.of(lastName.get());
            }
            return this;
        }

        @JsonSetter(value = "email", nulls = Nulls.SKIP)
        public Builder email(Optional<String> email) {
            this.email = email;
            return this;
        }

        public Builder email(String email) {
            this.email = Optional.ofNullable(email);
            return this;
        }

        public Builder email(Nullable<String> email) {
            if (email.isNull()) {
                this.email = null;
            } else if (email.isEmpty()) {
                this.email = Optional.empty();
            } else {
                this.email = Optional.of(email.get());
            }
            return this;
        }

        @JsonSetter(value = "phone_number", nulls = Nulls.SKIP)
        public Builder phoneNumber(Optional<String> phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = Optional.ofNullable(phoneNumber);
            return this;
        }

        public Builder phoneNumber(Nullable<String> phoneNumber) {
            if (phoneNumber.isNull()) {
                this.phoneNumber = null;
            } else if (phoneNumber.isEmpty()) {
                this.phoneNumber = Optional.empty();
            } else {
                this.phoneNumber = Optional.of(phoneNumber.get());
            }
            return this;
        }

        @JsonSetter(value = "location_ids", nulls = Nulls.SKIP)
        public Builder locationIds(Optional<List<String>> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        public Builder locationIds(List<String> locationIds) {
            this.locationIds = Optional.ofNullable(locationIds);
            return this;
        }

        public Builder locationIds(Nullable<List<String>> locationIds) {
            if (locationIds.isNull()) {
                this.locationIds = null;
            } else if (locationIds.isEmpty()) {
                this.locationIds = Optional.empty();
            } else {
                this.locationIds = Optional.of(locationIds.get());
            }
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<EmployeeStatus> status) {
            this.status = status;
            return this;
        }

        public Builder status(EmployeeStatus status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @JsonSetter(value = "is_owner", nulls = Nulls.SKIP)
        public Builder isOwner(Optional<Boolean> isOwner) {
            this.isOwner = isOwner;
            return this;
        }

        public Builder isOwner(Boolean isOwner) {
            this.isOwner = Optional.ofNullable(isOwner);
            return this;
        }

        public Builder isOwner(Nullable<Boolean> isOwner) {
            if (isOwner.isNull()) {
                this.isOwner = null;
            } else if (isOwner.isEmpty()) {
                this.isOwner = Optional.empty();
            } else {
                this.isOwner = Optional.of(isOwner.get());
            }
            return this;
        }

        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public Builder createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public Builder updatedAt(Optional<String> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder updatedAt(String updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        public Employee build() {
            return new Employee(
                    id,
                    firstName,
                    lastName,
                    email,
                    phoneNumber,
                    locationIds,
                    status,
                    isOwner,
                    createdAt,
                    updatedAt,
                    additionalProperties);
        }
    }
}

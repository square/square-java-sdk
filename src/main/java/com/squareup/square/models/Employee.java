
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Employee type.
 */
public class Employee {
    private final String id;
    private final OptionalNullable<String> firstName;
    private final OptionalNullable<String> lastName;
    private final OptionalNullable<String> email;
    private final OptionalNullable<String> phoneNumber;
    private final OptionalNullable<List<String>> locationIds;
    private final String status;
    private final OptionalNullable<Boolean> isOwner;
    private final String createdAt;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  firstName  String value for firstName.
     * @param  lastName  String value for lastName.
     * @param  email  String value for email.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  locationIds  List of String value for locationIds.
     * @param  status  String value for status.
     * @param  isOwner  Boolean value for isOwner.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
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
        this.firstName = OptionalNullable.of(firstName);
        this.lastName = OptionalNullable.of(lastName);
        this.email = OptionalNullable.of(email);
        this.phoneNumber = OptionalNullable.of(phoneNumber);
        this.locationIds = OptionalNullable.of(locationIds);
        this.status = status;
        this.isOwner = OptionalNullable.of(isOwner);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Internal initialization constructor.
     */
    protected Employee(String id, OptionalNullable<String> firstName,
            OptionalNullable<String> lastName, OptionalNullable<String> email,
            OptionalNullable<String> phoneNumber, OptionalNullable<List<String>> locationIds,
            String status, OptionalNullable<Boolean> isOwner, String createdAt,
            String updatedAt) {
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

    /**
     * Getter for Id.
     * UUID for this object.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for FirstName.
     * The employee's first name.
     * @return Returns the Internal String
     */
    @JsonGetter("first_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFirstName() {
        return this.firstName;
    }

    /**
     * Getter for FirstName.
     * The employee's first name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFirstName() {
        return OptionalNullable.getFrom(firstName);
    }

    /**
     * Internal Getter for LastName.
     * The employee's last name.
     * @return Returns the Internal String
     */
    @JsonGetter("last_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLastName() {
        return this.lastName;
    }

    /**
     * Getter for LastName.
     * The employee's last name.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLastName() {
        return OptionalNullable.getFrom(lastName);
    }

    /**
     * Internal Getter for Email.
     * The employee's email address
     * @return Returns the Internal String
     */
    @JsonGetter("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEmail() {
        return this.email;
    }

    /**
     * Getter for Email.
     * The employee's email address
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmail() {
        return OptionalNullable.getFrom(email);
    }

    /**
     * Internal Getter for PhoneNumber.
     * The employee's phone number in E.164 format, i.e. "+12125554250"
     * @return Returns the Internal String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for PhoneNumber.
     * The employee's phone number in E.164 format, i.e. "+12125554250"
     * @return Returns the String
     */
    @JsonIgnore
    public String getPhoneNumber() {
        return OptionalNullable.getFrom(phoneNumber);
    }

    /**
     * Internal Getter for LocationIds.
     * A list of location IDs where this employee has access to.
     * @return Returns the Internal List of String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for LocationIds.
     * A list of location IDs where this employee has access to.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getLocationIds() {
        return OptionalNullable.getFrom(locationIds);
    }

    /**
     * Getter for Status.
     * The status of the Employee being retrieved. DEPRECATED at version 2020-08-26. Replaced by
     * [TeamMemberStatus](entity:TeamMemberStatus).
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Internal Getter for IsOwner.
     * Whether this employee is the owner of the merchant. Each merchant has one owner employee, and
     * that employee has full authority over the account.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_owner")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsOwner() {
        return this.isOwner;
    }

    /**
     * Getter for IsOwner.
     * Whether this employee is the owner of the merchant. Each merchant has one owner employee, and
     * that employee has full authority over the account.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsOwner() {
        return OptionalNullable.getFrom(isOwner);
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, locationIds, status,
                isOwner, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(firstName, other.firstName)
            && Objects.equals(lastName, other.lastName)
            && Objects.equals(email, other.email)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(locationIds, other.locationIds)
            && Objects.equals(status, other.status)
            && Objects.equals(isOwner, other.isOwner)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this Employee into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Employee [" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", phoneNumber=" + phoneNumber + ", locationIds="
                + locationIds + ", status=" + status + ", isOwner=" + isOwner + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link Employee.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Employee.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .status(getStatus())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        builder.firstName = internalGetFirstName();
        builder.lastName = internalGetLastName();
        builder.email = internalGetEmail();
        builder.phoneNumber = internalGetPhoneNumber();
        builder.locationIds = internalGetLocationIds();
        builder.isOwner = internalGetIsOwner();
        return builder;
    }

    /**
     * Class to build instances of {@link Employee}.
     */
    public static class Builder {
        private String id;
        private OptionalNullable<String> firstName;
        private OptionalNullable<String> lastName;
        private OptionalNullable<String> email;
        private OptionalNullable<String> phoneNumber;
        private OptionalNullable<List<String>> locationIds;
        private String status;
        private OptionalNullable<Boolean> isOwner;
        private String createdAt;
        private String updatedAt;



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
         * Setter for firstName.
         * @param  firstName  String value for firstName.
         * @return Builder
         */
        public Builder firstName(String firstName) {
            this.firstName = OptionalNullable.of(firstName);
            return this;
        }

        /**
         * UnSetter for firstName.
         * @return Builder
         */
        public Builder unsetFirstName() {
            firstName = null;
            return this;
        }

        /**
         * Setter for lastName.
         * @param  lastName  String value for lastName.
         * @return Builder
         */
        public Builder lastName(String lastName) {
            this.lastName = OptionalNullable.of(lastName);
            return this;
        }

        /**
         * UnSetter for lastName.
         * @return Builder
         */
        public Builder unsetLastName() {
            lastName = null;
            return this;
        }

        /**
         * Setter for email.
         * @param  email  String value for email.
         * @return Builder
         */
        public Builder email(String email) {
            this.email = OptionalNullable.of(email);
            return this;
        }

        /**
         * UnSetter for email.
         * @return Builder
         */
        public Builder unsetEmail() {
            email = null;
            return this;
        }

        /**
         * Setter for phoneNumber.
         * @param  phoneNumber  String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = OptionalNullable.of(phoneNumber);
            return this;
        }

        /**
         * UnSetter for phoneNumber.
         * @return Builder
         */
        public Builder unsetPhoneNumber() {
            phoneNumber = null;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = OptionalNullable.of(locationIds);
            return this;
        }

        /**
         * UnSetter for locationIds.
         * @return Builder
         */
        public Builder unsetLocationIds() {
            locationIds = null;
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
         * Setter for isOwner.
         * @param  isOwner  Boolean value for isOwner.
         * @return Builder
         */
        public Builder isOwner(Boolean isOwner) {
            this.isOwner = OptionalNullable.of(isOwner);
            return this;
        }

        /**
         * UnSetter for isOwner.
         * @return Builder
         */
        public Builder unsetIsOwner() {
            isOwner = null;
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
         * Builds a new {@link Employee} object using the set fields.
         * @return {@link Employee}
         */
        public Employee build() {
            return new Employee(id, firstName, lastName, email, phoneNumber, locationIds, status,
                    isOwner, createdAt, updatedAt);
        }
    }
}

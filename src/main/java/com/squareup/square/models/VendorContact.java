
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for VendorContact type.
 */
public class VendorContact {
    private final String id;
    private final OptionalNullable<String> name;
    private final OptionalNullable<String> emailAddress;
    private final OptionalNullable<String> phoneNumber;
    private final OptionalNullable<Boolean> removed;
    private final int ordinal;

    /**
     * Initialization constructor.
     * @param  ordinal  int value for ordinal.
     * @param  id  String value for id.
     * @param  name  String value for name.
     * @param  emailAddress  String value for emailAddress.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  removed  Boolean value for removed.
     */
    @JsonCreator
    public VendorContact(
            @JsonProperty("ordinal") int ordinal,
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("removed") Boolean removed) {
        this.id = id;
        this.name = OptionalNullable.of(name);
        this.emailAddress = OptionalNullable.of(emailAddress);
        this.phoneNumber = OptionalNullable.of(phoneNumber);
        this.removed = OptionalNullable.of(removed);
        this.ordinal = ordinal;
    }

    /**
     * Internal initialization constructor.
     */
    protected VendorContact(int ordinal, String id, OptionalNullable<String> name,
            OptionalNullable<String> emailAddress, OptionalNullable<String> phoneNumber,
            OptionalNullable<Boolean> removed) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.removed = removed;
        this.ordinal = ordinal;
    }

    /**
     * Getter for Id.
     * A unique Square-generated ID for the [VendorContact]($m/VendorContact). This field is
     * required when attempting to update a [VendorContact]($m/VendorContact).
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for Name.
     * The name of the [VendorContact]($m/VendorContact). This field is required when attempting to
     * create a [Vendor]($m/Vendor).
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The name of the [VendorContact]($m/VendorContact). This field is required when attempting to
     * create a [Vendor]($m/Vendor).
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for EmailAddress.
     * The email address of the [VendorContact]($m/VendorContact).
     * @return Returns the Internal String
     */
    @JsonGetter("email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Getter for EmailAddress.
     * The email address of the [VendorContact]($m/VendorContact).
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmailAddress() {
        return OptionalNullable.getFrom(emailAddress);
    }

    /**
     * Internal Getter for PhoneNumber.
     * The phone number of the [VendorContact]($m/VendorContact).
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
     * The phone number of the [VendorContact]($m/VendorContact).
     * @return Returns the String
     */
    @JsonIgnore
    public String getPhoneNumber() {
        return OptionalNullable.getFrom(phoneNumber);
    }

    /**
     * Internal Getter for Removed.
     * The state of the [VendorContact]($m/VendorContact).
     * @return Returns the Internal Boolean
     */
    @JsonGetter("removed")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetRemoved() {
        return this.removed;
    }

    /**
     * Getter for Removed.
     * The state of the [VendorContact]($m/VendorContact).
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getRemoved() {
        return OptionalNullable.getFrom(removed);
    }

    /**
     * Getter for Ordinal.
     * The ordinal of the [VendorContact]($m/VendorContact).
     * @return Returns the int
     */
    @JsonGetter("ordinal")
    public int getOrdinal() {
        return ordinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, emailAddress, phoneNumber, removed, ordinal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VendorContact)) {
            return false;
        }
        VendorContact other = (VendorContact) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(emailAddress, other.emailAddress)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(removed, other.removed)
            && Objects.equals(ordinal, other.ordinal);
    }

    /**
     * Converts this VendorContact into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "VendorContact [" + "ordinal=" + ordinal + ", id=" + id + ", name=" + name
                + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", removed="
                + removed + "]";
    }

    /**
     * Builds a new {@link VendorContact.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link VendorContact.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(ordinal)
                .id(getId());
        builder.name = internalGetName();
        builder.emailAddress = internalGetEmailAddress();
        builder.phoneNumber = internalGetPhoneNumber();
        builder.removed = internalGetRemoved();
        return builder;
    }

    /**
     * Class to build instances of {@link VendorContact}.
     */
    public static class Builder {
        private int ordinal;
        private String id;
        private OptionalNullable<String> name;
        private OptionalNullable<String> emailAddress;
        private OptionalNullable<String> phoneNumber;
        private OptionalNullable<Boolean> removed;

        /**
         * Initialization constructor.
         * @param  ordinal  int value for ordinal.
         */
        public Builder(int ordinal) {
            this.ordinal = ordinal;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  int value for ordinal.
         * @return Builder
         */
        public Builder ordinal(int ordinal) {
            this.ordinal = ordinal;
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
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for emailAddress.
         * @param  emailAddress  String value for emailAddress.
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = OptionalNullable.of(emailAddress);
            return this;
        }

        /**
         * UnSetter for emailAddress.
         * @return Builder
         */
        public Builder unsetEmailAddress() {
            emailAddress = null;
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
         * Setter for removed.
         * @param  removed  Boolean value for removed.
         * @return Builder
         */
        public Builder removed(Boolean removed) {
            this.removed = OptionalNullable.of(removed);
            return this;
        }

        /**
         * UnSetter for removed.
         * @return Builder
         */
        public Builder unsetRemoved() {
            removed = null;
            return this;
        }

        /**
         * Builds a new {@link VendorContact} object using the set fields.
         * @return {@link VendorContact}
         */
        public VendorContact build() {
            return new VendorContact(ordinal, id, name, emailAddress, phoneNumber, removed);
        }
    }
}

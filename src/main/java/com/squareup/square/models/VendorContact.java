
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for VendorContact type.
 */
public class VendorContact {
    private final String id;
    private final String name;
    private final String emailAddress;
    private final String phoneNumber;
    private final Boolean removed;
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
     * Getter for Name.
     * The name of the [VendorContact]($m/VendorContact). This field is required when attempting to
     * create a [Vendor]($m/Vendor).
     * @return Returns the String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    /**
     * Getter for EmailAddress.
     * The email address of the [VendorContact]($m/VendorContact).
     * @return Returns the String
     */
    @JsonGetter("email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Getter for PhoneNumber.
     * The phone number of the [VendorContact]($m/VendorContact).
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for Removed.
     * The state of the [VendorContact]($m/VendorContact).
     * @return Returns the Boolean
     */
    @JsonGetter("removed")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getRemoved() {
        return removed;
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
                .id(getId())
                .name(getName())
                .emailAddress(getEmailAddress())
                .phoneNumber(getPhoneNumber())
                .removed(getRemoved());
        return builder;
    }

    /**
     * Class to build instances of {@link VendorContact}.
     */
    public static class Builder {
        private int ordinal;
        private String id;
        private String name;
        private String emailAddress;
        private String phoneNumber;
        private Boolean removed;

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
            this.name = name;
            return this;
        }

        /**
         * Setter for emailAddress.
         * @param  emailAddress  String value for emailAddress.
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * Setter for phoneNumber.
         * @param  phoneNumber  String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter for removed.
         * @param  removed  Boolean value for removed.
         * @return Builder
         */
        public Builder removed(Boolean removed) {
            this.removed = removed;
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

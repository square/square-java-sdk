package com.squareup.square.legacy.models;

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
 * This is a model class for Vendor type.
 */
public class Vendor {
    private final String id;
    private final String createdAt;
    private final String updatedAt;
    private final OptionalNullable<String> name;
    private final Address address;
    private final OptionalNullable<List<VendorContact>> contacts;
    private final OptionalNullable<String> accountNumber;
    private final OptionalNullable<String> note;
    private final Integer version;
    private final String status;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  name  String value for name.
     * @param  address  Address value for address.
     * @param  contacts  List of VendorContact value for contacts.
     * @param  accountNumber  String value for accountNumber.
     * @param  note  String value for note.
     * @param  version  Integer value for version.
     * @param  status  String value for status.
     */
    @JsonCreator
    public Vendor(
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("name") String name,
            @JsonProperty("address") Address address,
            @JsonProperty("contacts") List<VendorContact> contacts,
            @JsonProperty("account_number") String accountNumber,
            @JsonProperty("note") String note,
            @JsonProperty("version") Integer version,
            @JsonProperty("status") String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = OptionalNullable.of(name);
        this.address = address;
        this.contacts = OptionalNullable.of(contacts);
        this.accountNumber = OptionalNullable.of(accountNumber);
        this.note = OptionalNullable.of(note);
        this.version = version;
        this.status = status;
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  name  String value for name.
     * @param  address  Address value for address.
     * @param  contacts  List of VendorContact value for contacts.
     * @param  accountNumber  String value for accountNumber.
     * @param  note  String value for note.
     * @param  version  Integer value for version.
     * @param  status  String value for status.
     */
    protected Vendor(
            String id,
            String createdAt,
            String updatedAt,
            OptionalNullable<String> name,
            Address address,
            OptionalNullable<List<VendorContact>> contacts,
            OptionalNullable<String> accountNumber,
            OptionalNullable<String> note,
            Integer version,
            String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.address = address;
        this.contacts = contacts;
        this.accountNumber = accountNumber;
        this.note = note;
        this.version = version;
        this.status = status;
    }

    /**
     * Getter for Id.
     * A unique Square-generated ID for the [Vendor](entity:Vendor). This field is required when
     * attempting to update a [Vendor](entity:Vendor).
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for CreatedAt.
     * An RFC 3339-formatted timestamp that indicates when the [Vendor](entity:Vendor) was created.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * An RFC 3339-formatted timestamp that indicates when the [Vendor](entity:Vendor) was last
     * updated.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Internal Getter for Name.
     * The name of the [Vendor](entity:Vendor). This field is required when attempting to create or
     * update a [Vendor](entity:Vendor).
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
     * The name of the [Vendor](entity:Vendor). This field is required when attempting to create or
     * update a [Vendor](entity:Vendor).
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Getter for Address.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getAddress() {
        return address;
    }

    /**
     * Internal Getter for Contacts.
     * The contacts of the [Vendor](entity:Vendor).
     * @return Returns the Internal List of VendorContact
     */
    @JsonGetter("contacts")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<VendorContact>> internalGetContacts() {
        return this.contacts;
    }

    /**
     * Getter for Contacts.
     * The contacts of the [Vendor](entity:Vendor).
     * @return Returns the List of VendorContact
     */
    @JsonIgnore
    public List<VendorContact> getContacts() {
        return OptionalNullable.getFrom(contacts);
    }

    /**
     * Internal Getter for AccountNumber.
     * The account number of the [Vendor](entity:Vendor).
     * @return Returns the Internal String
     */
    @JsonGetter("account_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Getter for AccountNumber.
     * The account number of the [Vendor](entity:Vendor).
     * @return Returns the String
     */
    @JsonIgnore
    public String getAccountNumber() {
        return OptionalNullable.getFrom(accountNumber);
    }

    /**
     * Internal Getter for Note.
     * A note detailing information about the [Vendor](entity:Vendor).
     * @return Returns the Internal String
     */
    @JsonGetter("note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNote() {
        return this.note;
    }

    /**
     * Getter for Note.
     * A note detailing information about the [Vendor](entity:Vendor).
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
    }

    /**
     * Getter for Version.
     * The version of the [Vendor](entity:Vendor).
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for Status.
     * The status of the [Vendor]($m/Vendor), whether a [Vendor]($m/Vendor) is active or inactive.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, name, address, contacts, accountNumber, note, version, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(updatedAt, other.updatedAt)
                && Objects.equals(name, other.name)
                && Objects.equals(address, other.address)
                && Objects.equals(contacts, other.contacts)
                && Objects.equals(accountNumber, other.accountNumber)
                && Objects.equals(note, other.note)
                && Objects.equals(version, other.version)
                && Objects.equals(status, other.status);
    }

    /**
     * Converts this Vendor into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Vendor [" + "id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", name=" + name + ", address=" + address + ", contacts=" + contacts
                + ", accountNumber=" + accountNumber + ", note=" + note + ", version=" + version
                + ", status=" + status + "]";
    }

    /**
     * Builds a new {@link Vendor.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Vendor.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .address(getAddress())
                .version(getVersion())
                .status(getStatus());
        builder.name = internalGetName();
        builder.contacts = internalGetContacts();
        builder.accountNumber = internalGetAccountNumber();
        builder.note = internalGetNote();
        return builder;
    }

    /**
     * Class to build instances of {@link Vendor}.
     */
    public static class Builder {
        private String id;
        private String createdAt;
        private String updatedAt;
        private OptionalNullable<String> name;
        private Address address;
        private OptionalNullable<List<VendorContact>> contacts;
        private OptionalNullable<String> accountNumber;
        private OptionalNullable<String> note;
        private Integer version;
        private String status;

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
         * Setter for address.
         * @param  address  Address value for address.
         * @return Builder
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         * Setter for contacts.
         * @param  contacts  List of VendorContact value for contacts.
         * @return Builder
         */
        public Builder contacts(List<VendorContact> contacts) {
            this.contacts = OptionalNullable.of(contacts);
            return this;
        }

        /**
         * UnSetter for contacts.
         * @return Builder
         */
        public Builder unsetContacts() {
            contacts = null;
            return this;
        }

        /**
         * Setter for accountNumber.
         * @param  accountNumber  String value for accountNumber.
         * @return Builder
         */
        public Builder accountNumber(String accountNumber) {
            this.accountNumber = OptionalNullable.of(accountNumber);
            return this;
        }

        /**
         * UnSetter for accountNumber.
         * @return Builder
         */
        public Builder unsetAccountNumber() {
            accountNumber = null;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = OptionalNullable.of(note);
            return this;
        }

        /**
         * UnSetter for note.
         * @return Builder
         */
        public Builder unsetNote() {
            note = null;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * Builds a new {@link Vendor} object using the set fields.
         * @return {@link Vendor}
         */
        public Vendor build() {
            return new Vendor(id, createdAt, updatedAt, name, address, contacts, accountNumber, note, version, status);
        }
    }
}

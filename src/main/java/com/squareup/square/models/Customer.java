package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Customer {

    @JsonCreator
    public Customer(
            @JsonProperty("id") String id,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("cards") List<Card> cards,
            @JsonProperty("given_name") String givenName,
            @JsonProperty("family_name") String familyName,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("company_name") String companyName,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("address") Address address,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("birthday") String birthday,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("note") String note,
            @JsonProperty("preferences") CustomerPreferences preferences,
            @JsonProperty("groups") List<CustomerGroupInfo> groups,
            @JsonProperty("creation_source") String creationSource) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.cards = cards;
        this.givenName = givenName;
        this.familyName = familyName;
        this.nickname = nickname;
        this.companyName = companyName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.referenceId = referenceId;
        this.note = note;
        this.preferences = preferences;
        this.groups = groups;
        this.creationSource = creationSource;
    }

    private final String id;
    private final String createdAt;
    private final String updatedAt;
    private final List<Card> cards;
    private final String givenName;
    private final String familyName;
    private final String nickname;
    private final String companyName;
    private final String emailAddress;
    private final Address address;
    private final String phoneNumber;
    private final String birthday;
    private final String referenceId;
    private final String note;
    private final CustomerPreferences preferences;
    private final List<CustomerGroupInfo> groups;
    private final String creationSource;

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, cards, givenName, familyName, nickname, companyName, emailAddress, address, phoneNumber, birthday, referenceId, note, preferences, groups, creationSource);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
            Objects.equals(createdAt, customer.createdAt) &&
            Objects.equals(updatedAt, customer.updatedAt) &&
            Objects.equals(cards, customer.cards) &&
            Objects.equals(givenName, customer.givenName) &&
            Objects.equals(familyName, customer.familyName) &&
            Objects.equals(nickname, customer.nickname) &&
            Objects.equals(companyName, customer.companyName) &&
            Objects.equals(emailAddress, customer.emailAddress) &&
            Objects.equals(address, customer.address) &&
            Objects.equals(phoneNumber, customer.phoneNumber) &&
            Objects.equals(birthday, customer.birthday) &&
            Objects.equals(referenceId, customer.referenceId) &&
            Objects.equals(note, customer.note) &&
            Objects.equals(preferences, customer.preferences) &&
            Objects.equals(groups, customer.groups) &&
            Objects.equals(creationSource, customer.creationSource);
    }

    /**
     * Getter for Id.
     * A unique, Square-assigned object ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for CreatedAt.
     * The time when the customer profile was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the customer profile was last updated, in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

    /**
     * Getter for Cards.
     * Payment details of cards stored on file for the customer profile.
     */
    @JsonGetter("cards")
    public List<Card> getCards() { 
        return this.cards;
    }

    /**
     * Getter for GivenName.
     * The given (i.e., first) name associated with the customer profile.
     */
    @JsonGetter("given_name")
    public String getGivenName() { 
        return this.givenName;
    }

    /**
     * Getter for FamilyName.
     * The family (i.e., last) name associated with the customer profile.
     */
    @JsonGetter("family_name")
    public String getFamilyName() { 
        return this.familyName;
    }

    /**
     * Getter for Nickname.
     * A nickname for the customer profile.
     */
    @JsonGetter("nickname")
    public String getNickname() { 
        return this.nickname;
    }

    /**
     * Getter for CompanyName.
     * A business name associated with the customer profile.
     */
    @JsonGetter("company_name")
    public String getCompanyName() { 
        return this.companyName;
    }

    /**
     * Getter for EmailAddress.
     * The email address associated with the customer profile.
     */
    @JsonGetter("email_address")
    public String getEmailAddress() { 
        return this.emailAddress;
    }

    /**
     * Getter for Address.
     * Represents a physical address.
     */
    @JsonGetter("address")
    public Address getAddress() { 
        return this.address;
    }

    /**
     * Getter for PhoneNumber.
     * The 11-digit phone number associated with the customer profile.
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() { 
        return this.phoneNumber;
    }

    /**
     * Getter for Birthday.
     * The birthday associated with the customer profile, in RFC-3339 format.
     * Year is optional, timezone and times are not allowed.
     * For example: `0000-09-01T00:00:00-00:00` indicates a birthday on September 1st.
     * `1998-09-01T00:00:00-00:00` indications a birthday on September 1st __1998__.
     */
    @JsonGetter("birthday")
    public String getBirthday() { 
        return this.birthday;
    }

    /**
     * Getter for ReferenceId.
     * An optional, second ID used to associate the customer profile with an
     * entity in another system.
     */
    @JsonGetter("reference_id")
    public String getReferenceId() { 
        return this.referenceId;
    }

    /**
     * Getter for Note.
     * A custom note associated with the customer profile.
     */
    @JsonGetter("note")
    public String getNote() { 
        return this.note;
    }

    /**
     * Getter for Preferences.
     * Represents communication preferences for the customer profile.
     */
    @JsonGetter("preferences")
    public CustomerPreferences getPreferences() { 
        return this.preferences;
    }

    /**
     * Getter for Groups.
     * The groups the customer belongs to.
     */
    @JsonGetter("groups")
    public List<CustomerGroupInfo> getGroups() { 
        return this.groups;
    }

    /**
     * Getter for CreationSource.
     * Indicates the method used to create the customer profile.
     */
    @JsonGetter("creation_source")
    public String getCreationSource() { 
        return this.creationSource;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            createdAt,
            updatedAt)
            .cards(getCards())
            .givenName(getGivenName())
            .familyName(getFamilyName())
            .nickname(getNickname())
            .companyName(getCompanyName())
            .emailAddress(getEmailAddress())
            .address(getAddress())
            .phoneNumber(getPhoneNumber())
            .birthday(getBirthday())
            .referenceId(getReferenceId())
            .note(getNote())
            .preferences(getPreferences())
            .groups(getGroups())
            .creationSource(getCreationSource());
            return builder;
    }

    public static class Builder {
        private String id;
        private String createdAt;
        private String updatedAt;
        private List<Card> cards;
        private String givenName;
        private String familyName;
        private String nickname;
        private String companyName;
        private String emailAddress;
        private Address address;
        private String phoneNumber;
        private String birthday;
        private String referenceId;
        private String note;
        private CustomerPreferences preferences;
        private List<CustomerGroupInfo> groups;
        private String creationSource;

        public Builder(String id,
                String createdAt,
                String updatedAt) {
            this.id = id;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public Builder id(String value) {
            id = value;
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
        public Builder cards(List<Card> value) {
            cards = value;
            return this;
        }
        public Builder givenName(String value) {
            givenName = value;
            return this;
        }
        public Builder familyName(String value) {
            familyName = value;
            return this;
        }
        public Builder nickname(String value) {
            nickname = value;
            return this;
        }
        public Builder companyName(String value) {
            companyName = value;
            return this;
        }
        public Builder emailAddress(String value) {
            emailAddress = value;
            return this;
        }
        public Builder address(Address value) {
            address = value;
            return this;
        }
        public Builder phoneNumber(String value) {
            phoneNumber = value;
            return this;
        }
        public Builder birthday(String value) {
            birthday = value;
            return this;
        }
        public Builder referenceId(String value) {
            referenceId = value;
            return this;
        }
        public Builder note(String value) {
            note = value;
            return this;
        }
        public Builder preferences(CustomerPreferences value) {
            preferences = value;
            return this;
        }
        public Builder groups(List<CustomerGroupInfo> value) {
            groups = value;
            return this;
        }
        public Builder creationSource(String value) {
            creationSource = value;
            return this;
        }

        public Customer build() {
            return new Customer(id,
                createdAt,
                updatedAt,
                cards,
                givenName,
                familyName,
                nickname,
                companyName,
                emailAddress,
                address,
                phoneNumber,
                birthday,
                referenceId,
                note,
                preferences,
                groups,
                creationSource);
        }
    }
}

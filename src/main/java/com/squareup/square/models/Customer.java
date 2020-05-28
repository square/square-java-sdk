package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Customer type.
 */
public class Customer {

    /**
     * Initialization constructor.
     * @param id
     * @param createdAt
     * @param updatedAt
     * @param cards
     * @param givenName
     * @param familyName
     * @param nickname
     * @param companyName
     * @param emailAddress
     * @param address
     * @param phoneNumber
     * @param birthday
     * @param referenceId
     * @param note
     * @param preferences
     * @param groups
     * @param creationSource
     * @param groupIds
     * @param segmentIds
     */
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
            @JsonProperty("creation_source") String creationSource,
            @JsonProperty("group_ids") List<String> groupIds,
            @JsonProperty("segment_ids") List<String> segmentIds) {
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
        this.groupIds = groupIds;
        this.segmentIds = segmentIds;
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
    private final List<String> groupIds;
    private final List<String> segmentIds;
    /**
     * Getter for Id.
     * A unique Square-assigned ID for the customer profile.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the customer profile was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the customer profile was last updated, in RFC 3339 format.
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
     * The customer groups and segments the customer belongs to. This deprecated field has been replaced with  the dedicated `group_ids` for customer groups and the dedicated `segment_ids` field for customer segments. You can retrieve information about a given customer group and segment respectively using the Customer Groups API and Customer Segments API.
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

    /**
     * Getter for GroupIds.
     * The IDs of customer groups the customer belongs to.
     */
    @JsonGetter("group_ids")
    public List<String> getGroupIds() {
        return this.groupIds;
    }

    /**
     * Getter for SegmentIds.
     * The IDs of segments the customer belongs to.
     */
    @JsonGetter("segment_ids")
    public List<String> getSegmentIds() {
        return this.segmentIds;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, cards, givenName, familyName, nickname,
            companyName, emailAddress, address, phoneNumber, birthday, referenceId, note,
            preferences, groups, creationSource, groupIds, segmentIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) obj;
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
            Objects.equals(creationSource, customer.creationSource) &&
            Objects.equals(groupIds, customer.groupIds) &&
            Objects.equals(segmentIds, customer.segmentIds);
    }

    /**
     * Builds a new {@link Customer.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Customer.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
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
            .creationSource(getCreationSource())
            .groupIds(getGroupIds())
            .segmentIds(getSegmentIds());
            return builder;
    }

    /**
     * Class to build instances of {@link Customer}
     */
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
        private List<String> groupIds;
        private List<String> segmentIds;

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
         * Setter for cards
         * @param cards
         * @return Builder
         */
        public Builder cards(List<Card> cards) {
            this.cards = cards;
            return this;
        }
        /**
         * Setter for givenName
         * @param givenName
         * @return Builder
         */
        public Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }
        /**
         * Setter for familyName
         * @param familyName
         * @return Builder
         */
        public Builder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }
        /**
         * Setter for nickname
         * @param nickname
         * @return Builder
         */
        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }
        /**
         * Setter for companyName
         * @param companyName
         * @return Builder
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }
        /**
         * Setter for emailAddress
         * @param emailAddress
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        /**
         * Setter for address
         * @param address
         * @return Builder
         */
        public Builder address(Address address) {
            this.address = address;
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
         * Setter for birthday
         * @param birthday
         * @return Builder
         */
        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }
        /**
         * Setter for referenceId
         * @param referenceId
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }
        /**
         * Setter for note
         * @param note
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }
        /**
         * Setter for preferences
         * @param preferences
         * @return Builder
         */
        public Builder preferences(CustomerPreferences preferences) {
            this.preferences = preferences;
            return this;
        }
        /**
         * Setter for groups
         * @param groups
         * @return Builder
         */
        public Builder groups(List<CustomerGroupInfo> groups) {
            this.groups = groups;
            return this;
        }
        /**
         * Setter for creationSource
         * @param creationSource
         * @return Builder
         */
        public Builder creationSource(String creationSource) {
            this.creationSource = creationSource;
            return this;
        }
        /**
         * Setter for groupIds
         * @param groupIds
         * @return Builder
         */
        public Builder groupIds(List<String> groupIds) {
            this.groupIds = groupIds;
            return this;
        }
        /**
         * Setter for segmentIds
         * @param segmentIds
         * @return Builder
         */
        public Builder segmentIds(List<String> segmentIds) {
            this.segmentIds = segmentIds;
            return this;
        }

        /**
         * Builds a new {@link Customer} object using the set fields.
         * @return {@link Customer}
         */
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
                creationSource,
                groupIds,
                segmentIds);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for Customer type.
 */
public class Customer {
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
     * Initialization constructor.
     * @param id String value for id.
     * @param createdAt String value for createdAt.
     * @param updatedAt String value for updatedAt.
     * @param cards List of Card value for cards.
     * @param givenName String value for givenName.
     * @param familyName String value for familyName.
     * @param nickname String value for nickname.
     * @param companyName String value for companyName.
     * @param emailAddress String value for emailAddress.
     * @param address Address value for address.
     * @param phoneNumber String value for phoneNumber.
     * @param birthday String value for birthday.
     * @param referenceId String value for referenceId.
     * @param note String value for note.
     * @param preferences CustomerPreferences value for preferences.
     * @param groups List of CustomerGroupInfo value for groups.
     * @param creationSource String value for creationSource.
     * @param groupIds List of String value for groupIds.
     * @param segmentIds List of String value for segmentIds.
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

    /**
     * Getter for Id.
     * A unique Square-assigned ID for the customer profile.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the customer profile was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the customer profile was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for Cards.
     * Payment details of cards stored on file for the customer profile.
     * @return Returns the List of Card
     */
    @JsonGetter("cards")
    public List<Card> getCards() {
        return this.cards;
    }

    /**
     * Getter for GivenName.
     * The given (i.e., first) name associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("given_name")
    public String getGivenName() {
        return this.givenName;
    }

    /**
     * Getter for FamilyName.
     * The family (i.e., last) name associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("family_name")
    public String getFamilyName() {
        return this.familyName;
    }

    /**
     * Getter for Nickname.
     * A nickname for the customer profile.
     * @return Returns the String
     */
    @JsonGetter("nickname")
    public String getNickname() {
        return this.nickname;
    }

    /**
     * Getter for CompanyName.
     * A business name associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("company_name")
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * Getter for EmailAddress.
     * The email address associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("email_address")
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Getter for Address.
     * Represents a physical address.
     * @return Returns the Address
     */
    @JsonGetter("address")
    public Address getAddress() {
        return this.address;
    }

    /**
     * Getter for PhoneNumber.
     * The 11-digit phone number associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for Birthday.
     * The birthday associated with the customer profile, in RFC 3339 format. Year is optional,
     * timezone and times are not allowed. For example: `0000-09-01T00:00:00-00:00` indicates a
     * birthday on September 1st. `1998-09-01T00:00:00-00:00` indications a birthday on September
     * 1st __1998__.
     * @return Returns the String
     */
    @JsonGetter("birthday")
    public String getBirthday() {
        return this.birthday;
    }

    /**
     * Getter for ReferenceId.
     * An optional, second ID used to associate the customer profile with an entity in another
     * system.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for Note.
     * A custom note associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return this.note;
    }

    /**
     * Getter for Preferences.
     * Represents communication preferences for the customer profile.
     * @return Returns the CustomerPreferences
     */
    @JsonGetter("preferences")
    public CustomerPreferences getPreferences() {
        return this.preferences;
    }

    /**
     * Getter for Groups.
     * The customer groups and segments the customer belongs to. This deprecated field has been
     * replaced with the dedicated `group_ids` for customer groups and the dedicated `segment_ids`
     * field for customer segments. You can retrieve information about a given customer group and
     * segment respectively using the Customer Groups API and Customer Segments API.
     * @return Returns the List of CustomerGroupInfo
     */
    @JsonGetter("groups")
    public List<CustomerGroupInfo> getGroups() {
        return this.groups;
    }

    /**
     * Getter for CreationSource.
     * Indicates the method used to create the customer profile.
     * @return Returns the String
     */
    @JsonGetter("creation_source")
    public String getCreationSource() {
        return this.creationSource;
    }

    /**
     * Getter for GroupIds.
     * The IDs of customer groups the customer belongs to.
     * @return Returns the List of String
     */
    @JsonGetter("group_ids")
    public List<String> getGroupIds() {
        return this.groupIds;
    }

    /**
     * Getter for SegmentIds.
     * The IDs of segments the customer belongs to.
     * @return Returns the List of String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(cards, other.cards)
            && Objects.equals(givenName, other.givenName)
            && Objects.equals(familyName, other.familyName)
            && Objects.equals(nickname, other.nickname)
            && Objects.equals(companyName, other.companyName)
            && Objects.equals(emailAddress, other.emailAddress)
            && Objects.equals(address, other.address)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(birthday, other.birthday)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(note, other.note)
            && Objects.equals(preferences, other.preferences)
            && Objects.equals(groups, other.groups)
            && Objects.equals(creationSource, other.creationSource)
            && Objects.equals(groupIds, other.groupIds)
            && Objects.equals(segmentIds, other.segmentIds);
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
     * Class to build instances of {@link Customer}.
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
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param updatedAt String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for cards.
         * @param cards List of Card value for cards.
         * @return Builder
         */
        public Builder cards(List<Card> cards) {
            this.cards = cards;
            return this;
        }

        /**
         * Setter for givenName.
         * @param givenName String value for givenName.
         * @return Builder
         */
        public Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        /**
         * Setter for familyName.
         * @param familyName String value for familyName.
         * @return Builder
         */
        public Builder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        /**
         * Setter for nickname.
         * @param nickname String value for nickname.
         * @return Builder
         */
        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        /**
         * Setter for companyName.
         * @param companyName String value for companyName.
         * @return Builder
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        /**
         * Setter for emailAddress.
         * @param emailAddress String value for emailAddress.
         * @return Builder
         */
        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        /**
         * Setter for address.
         * @param address Address value for address.
         * @return Builder
         */
        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        /**
         * Setter for phoneNumber.
         * @param phoneNumber String value for phoneNumber.
         * @return Builder
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter for birthday.
         * @param birthday String value for birthday.
         * @return Builder
         */
        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param referenceId String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        /**
         * Setter for note.
         * @param note String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Setter for preferences.
         * @param preferences CustomerPreferences value for preferences.
         * @return Builder
         */
        public Builder preferences(CustomerPreferences preferences) {
            this.preferences = preferences;
            return this;
        }

        /**
         * Setter for groups.
         * @param groups List of CustomerGroupInfo value for groups.
         * @return Builder
         */
        public Builder groups(List<CustomerGroupInfo> groups) {
            this.groups = groups;
            return this;
        }

        /**
         * Setter for creationSource.
         * @param creationSource String value for creationSource.
         * @return Builder
         */
        public Builder creationSource(String creationSource) {
            this.creationSource = creationSource;
            return this;
        }

        /**
         * Setter for groupIds.
         * @param groupIds List of String value for groupIds.
         * @return Builder
         */
        public Builder groupIds(List<String> groupIds) {
            this.groupIds = groupIds;
            return this;
        }

        /**
         * Setter for segmentIds.
         * @param segmentIds List of String value for segmentIds.
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

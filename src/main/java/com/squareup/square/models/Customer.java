
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Customer type.
 */
public class Customer {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Card> cards;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String givenName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String familyName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String nickname;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String companyName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String emailAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address address;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String phoneNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String birthday;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String referenceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CustomerPreferences preferences;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String creationSource;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> groupIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> segmentIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long version;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CustomerTaxIds taxIds;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  cards  List of Card value for cards.
     * @param  givenName  String value for givenName.
     * @param  familyName  String value for familyName.
     * @param  nickname  String value for nickname.
     * @param  companyName  String value for companyName.
     * @param  emailAddress  String value for emailAddress.
     * @param  address  Address value for address.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  birthday  String value for birthday.
     * @param  referenceId  String value for referenceId.
     * @param  note  String value for note.
     * @param  preferences  CustomerPreferences value for preferences.
     * @param  creationSource  String value for creationSource.
     * @param  groupIds  List of String value for groupIds.
     * @param  segmentIds  List of String value for segmentIds.
     * @param  version  Long value for version.
     * @param  taxIds  CustomerTaxIds value for taxIds.
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
            @JsonProperty("creation_source") String creationSource,
            @JsonProperty("group_ids") List<String> groupIds,
            @JsonProperty("segment_ids") List<String> segmentIds,
            @JsonProperty("version") Long version,
            @JsonProperty("tax_ids") CustomerTaxIds taxIds) {
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
        this.creationSource = creationSource;
        this.groupIds = groupIds;
        this.segmentIds = segmentIds;
        this.version = version;
        this.taxIds = taxIds;
    }

    /**
     * Getter for Id.
     * A unique Square-assigned ID for the customer profile.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the customer profile was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the customer profile was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for Cards.
     * Payment details of the credit, debit, and gift cards stored on file for the customer profile.
     * DEPRECATED at version 2021-06-16. Replaced by calling [ListCards]($e/Cards/ListCards) (for
     * credit and debit cards on file) or [ListGiftCards]($e/GiftCards/ListGiftCards) (for gift
     * cards on file) and including the `customer_id` query parameter. For more information, see
     * [Migrate to the Cards API and Gift Cards
     * API](https://developer.squareup.com/docs/customers-api/use-the-api/integrate-with-other-services#migrate-customer-cards).
     * @return Returns the List of Card
     */
    @JsonGetter("cards")
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Getter for GivenName.
     * The given (i.e., first) name associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("given_name")
    public String getGivenName() {
        return givenName;
    }

    /**
     * Getter for FamilyName.
     * The family (i.e., last) name associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("family_name")
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Getter for Nickname.
     * A nickname for the customer profile.
     * @return Returns the String
     */
    @JsonGetter("nickname")
    public String getNickname() {
        return nickname;
    }

    /**
     * Getter for CompanyName.
     * A business name associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("company_name")
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Getter for EmailAddress.
     * The email address associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Getter for Address.
     * Represents a postal address in a country. The address format is based on an [open-source
     * library from Google](https://github.com/google/libaddressinput). For more information, see
     * [AddressValidationMetadata](https://github.com/google/libaddressinput/wiki/AddressValidationMetadata).
     * This format has dedicated fields for four address components: postal code, locality (city),
     * administrative district (state, prefecture, or province), and sublocality (town or village).
     * These components have dedicated fields in the `Address` object because software sometimes
     * behaves differently based on them. For example, sales tax software may charge different
     * amounts of sales tax based on the postal code, and some software is only available in certain
     * states due to compliance reasons. For the remaining address components, the `Address` type
     * provides the `address_line_1` and `address_line_2` fields for free-form data entry. These
     * fields are free-form because the remaining address components have too many variations around
     * the world and typical software does not parse these components. These fields enable users to
     * enter anything they want. Note that, in the current implementation, all other `Address` type
     * fields are blank. These include `address_line_3`, `sublocality_2`, `sublocality_3`,
     * `administrative_district_level_2`, `administrative_district_level_3`, `first_name`,
     * `last_name`, and `organization`. When it comes to localization, the seller's language
     * preferences (see [Language
     * preferences](https://developer.squareup.com/docs/locations-api#location-specific-and-seller-level-language-preferences))
     * are ignored for addresses. Even though Square products (such as Square Point of Sale and the
     * Seller Dashboard) mostly use a seller's language preference in communication, when it comes
     * to addresses, they will use English for a US address, Japanese for an address in Japan, and
     * so on.
     * @return Returns the Address
     */
    @JsonGetter("address")
    public Address getAddress() {
        return address;
    }

    /**
     * Getter for PhoneNumber.
     * The 11-digit phone number associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for Birthday.
     * The birthday associated with the customer profile, in RFC 3339 format. The year is optional.
     * The timezone and time are not allowed. For example, `0000-09-21T00:00:00-00:00` represents a
     * birthday on September 21 and `1998-09-21T00:00:00-00:00` represents a birthday on September
     * 21, 1998.
     * @return Returns the String
     */
    @JsonGetter("birthday")
    public String getBirthday() {
        return birthday;
    }

    /**
     * Getter for ReferenceId.
     * An optional second ID used to associate the customer profile with an entity in another
     * system.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for Note.
     * A custom note associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return note;
    }

    /**
     * Getter for Preferences.
     * Represents communication preferences for the customer profile.
     * @return Returns the CustomerPreferences
     */
    @JsonGetter("preferences")
    public CustomerPreferences getPreferences() {
        return preferences;
    }

    /**
     * Getter for CreationSource.
     * Indicates the method used to create the customer profile.
     * @return Returns the String
     */
    @JsonGetter("creation_source")
    public String getCreationSource() {
        return creationSource;
    }

    /**
     * Getter for GroupIds.
     * The IDs of customer groups the customer belongs to.
     * @return Returns the List of String
     */
    @JsonGetter("group_ids")
    public List<String> getGroupIds() {
        return groupIds;
    }

    /**
     * Getter for SegmentIds.
     * The IDs of segments the customer belongs to.
     * @return Returns the List of String
     */
    @JsonGetter("segment_ids")
    public List<String> getSegmentIds() {
        return segmentIds;
    }

    /**
     * Getter for Version.
     * The Square-assigned version number of the customer profile. The version number is incremented
     * each time an update is committed to the customer profile, except for changes to customer
     * segment membership and cards on file.
     * @return Returns the Long
     */
    @JsonGetter("version")
    public Long getVersion() {
        return version;
    }

    /**
     * Getter for TaxIds.
     * Represents the tax ID associated with a customer profile. The corresponding `tax_ids` field
     * is available only for customers of sellers in France, Ireland, or the United Kingdom. For
     * more information, see [Customer tax
     * IDs](https://developer.squareup.com/docs/customers-api/what-it-does#customer-tax-ids).
     * @return Returns the CustomerTaxIds
     */
    @JsonGetter("tax_ids")
    public CustomerTaxIds getTaxIds() {
        return taxIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, cards, givenName, familyName, nickname,
                companyName, emailAddress, address, phoneNumber, birthday, referenceId, note,
                preferences, creationSource, groupIds, segmentIds, version, taxIds);
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
            && Objects.equals(creationSource, other.creationSource)
            && Objects.equals(groupIds, other.groupIds)
            && Objects.equals(segmentIds, other.segmentIds)
            && Objects.equals(version, other.version)
            && Objects.equals(taxIds, other.taxIds);
    }

    /**
     * Converts this Customer into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Customer [" + "id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", cards=" + cards + ", givenName=" + givenName + ", familyName=" + familyName
                + ", nickname=" + nickname + ", companyName=" + companyName + ", emailAddress="
                + emailAddress + ", address=" + address + ", phoneNumber=" + phoneNumber
                + ", birthday=" + birthday + ", referenceId=" + referenceId + ", note=" + note
                + ", preferences=" + preferences + ", creationSource=" + creationSource
                + ", groupIds=" + groupIds + ", segmentIds=" + segmentIds + ", version=" + version
                + ", taxIds=" + taxIds + "]";
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
                .creationSource(getCreationSource())
                .groupIds(getGroupIds())
                .segmentIds(getSegmentIds())
                .version(getVersion())
                .taxIds(getTaxIds());
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
        private String creationSource;
        private List<String> groupIds;
        private List<String> segmentIds;
        private Long version;
        private CustomerTaxIds taxIds;



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
         * Setter for cards.
         * @param  cards  List of Card value for cards.
         * @return Builder
         */
        public Builder cards(List<Card> cards) {
            this.cards = cards;
            return this;
        }

        /**
         * Setter for givenName.
         * @param  givenName  String value for givenName.
         * @return Builder
         */
        public Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        /**
         * Setter for familyName.
         * @param  familyName  String value for familyName.
         * @return Builder
         */
        public Builder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        /**
         * Setter for nickname.
         * @param  nickname  String value for nickname.
         * @return Builder
         */
        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        /**
         * Setter for companyName.
         * @param  companyName  String value for companyName.
         * @return Builder
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
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
         * Setter for address.
         * @param  address  Address value for address.
         * @return Builder
         */
        public Builder address(Address address) {
            this.address = address;
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
         * Setter for birthday.
         * @param  birthday  String value for birthday.
         * @return Builder
         */
        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Setter for preferences.
         * @param  preferences  CustomerPreferences value for preferences.
         * @return Builder
         */
        public Builder preferences(CustomerPreferences preferences) {
            this.preferences = preferences;
            return this;
        }

        /**
         * Setter for creationSource.
         * @param  creationSource  String value for creationSource.
         * @return Builder
         */
        public Builder creationSource(String creationSource) {
            this.creationSource = creationSource;
            return this;
        }

        /**
         * Setter for groupIds.
         * @param  groupIds  List of String value for groupIds.
         * @return Builder
         */
        public Builder groupIds(List<String> groupIds) {
            this.groupIds = groupIds;
            return this;
        }

        /**
         * Setter for segmentIds.
         * @param  segmentIds  List of String value for segmentIds.
         * @return Builder
         */
        public Builder segmentIds(List<String> segmentIds) {
            this.segmentIds = segmentIds;
            return this;
        }

        /**
         * Setter for version.
         * @param  version  Long value for version.
         * @return Builder
         */
        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        /**
         * Setter for taxIds.
         * @param  taxIds  CustomerTaxIds value for taxIds.
         * @return Builder
         */
        public Builder taxIds(CustomerTaxIds taxIds) {
            this.taxIds = taxIds;
            return this;
        }

        /**
         * Builds a new {@link Customer} object using the set fields.
         * @return {@link Customer}
         */
        public Customer build() {
            return new Customer(id, createdAt, updatedAt, cards, givenName, familyName, nickname,
                    companyName, emailAddress, address, phoneNumber, birthday, referenceId, note,
                    preferences, creationSource, groupIds, segmentIds, version, taxIds);
        }
    }
}

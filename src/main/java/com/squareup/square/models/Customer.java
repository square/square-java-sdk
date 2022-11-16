
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for Customer type.
 */
public class Customer {
    private final String id;
    private final String createdAt;
    private final String updatedAt;
    private final OptionalNullable<List<Card>> cards;
    private final OptionalNullable<String> givenName;
    private final OptionalNullable<String> familyName;
    private final OptionalNullable<String> nickname;
    private final OptionalNullable<String> companyName;
    private final OptionalNullable<String> emailAddress;
    private final Address address;
    private final OptionalNullable<String> phoneNumber;
    private final OptionalNullable<String> birthday;
    private final OptionalNullable<String> referenceId;
    private final OptionalNullable<String> note;
    private final CustomerPreferences preferences;
    private final String creationSource;
    private final OptionalNullable<List<String>> groupIds;
    private final OptionalNullable<List<String>> segmentIds;
    private final Long version;
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
        this.cards = OptionalNullable.of(cards);
        this.givenName = OptionalNullable.of(givenName);
        this.familyName = OptionalNullable.of(familyName);
        this.nickname = OptionalNullable.of(nickname);
        this.companyName = OptionalNullable.of(companyName);
        this.emailAddress = OptionalNullable.of(emailAddress);
        this.address = address;
        this.phoneNumber = OptionalNullable.of(phoneNumber);
        this.birthday = OptionalNullable.of(birthday);
        this.referenceId = OptionalNullable.of(referenceId);
        this.note = OptionalNullable.of(note);
        this.preferences = preferences;
        this.creationSource = creationSource;
        this.groupIds = OptionalNullable.of(groupIds);
        this.segmentIds = OptionalNullable.of(segmentIds);
        this.version = version;
        this.taxIds = taxIds;
    }

    /**
     * Internal initialization constructor.
     */
    protected Customer(String id, String createdAt, String updatedAt,
            OptionalNullable<List<Card>> cards, OptionalNullable<String> givenName,
            OptionalNullable<String> familyName, OptionalNullable<String> nickname,
            OptionalNullable<String> companyName, OptionalNullable<String> emailAddress,
            Address address, OptionalNullable<String> phoneNumber,
            OptionalNullable<String> birthday, OptionalNullable<String> referenceId,
            OptionalNullable<String> note, CustomerPreferences preferences, String creationSource,
            OptionalNullable<List<String>> groupIds, OptionalNullable<List<String>> segmentIds,
            Long version, CustomerTaxIds taxIds) {
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
     * A unique Square-assigned ID for the customer profile. If you need this ID for an API request,
     * use the ID returned when you created the customer profile or call the
     * [SearchCustomers]($e/Customers/SearchCustomers) or
     * [ListCustomers]($e/Customers/ListCustomers) endpoint.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the customer profile was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the customer profile was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Internal Getter for Cards.
     * Payment details of the credit, debit, and gift cards stored on file for the customer profile.
     * DEPRECATED at version 2021-06-16. Replaced by calling [ListCards]($e/Cards/ListCards) (for
     * credit and debit cards on file) or [ListGiftCards]($e/GiftCards/ListGiftCards) (for gift
     * cards on file) and including the `customer_id` query parameter. For more information, see
     * [Migration
     * notes](https://developer.squareup.com/docs/customers-api/what-it-does#migrate-customer-cards).
     * @return Returns the Internal List of Card
     */
    @JsonGetter("cards")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Card>> internalGetCards() {
        return this.cards;
    }

    /**
     * Getter for Cards.
     * Payment details of the credit, debit, and gift cards stored on file for the customer profile.
     * DEPRECATED at version 2021-06-16. Replaced by calling [ListCards]($e/Cards/ListCards) (for
     * credit and debit cards on file) or [ListGiftCards]($e/GiftCards/ListGiftCards) (for gift
     * cards on file) and including the `customer_id` query parameter. For more information, see
     * [Migration
     * notes](https://developer.squareup.com/docs/customers-api/what-it-does#migrate-customer-cards).
     * @return Returns the List of Card
     */
    @JsonIgnore
    public List<Card> getCards() {
        return OptionalNullable.getFrom(cards);
    }

    /**
     * Internal Getter for GivenName.
     * The given name (that is, the first name) associated with the customer profile.
     * @return Returns the Internal String
     */
    @JsonGetter("given_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetGivenName() {
        return this.givenName;
    }

    /**
     * Getter for GivenName.
     * The given name (that is, the first name) associated with the customer profile.
     * @return Returns the String
     */
    @JsonIgnore
    public String getGivenName() {
        return OptionalNullable.getFrom(givenName);
    }

    /**
     * Internal Getter for FamilyName.
     * The family name (that is, the last name) associated with the customer profile.
     * @return Returns the Internal String
     */
    @JsonGetter("family_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFamilyName() {
        return this.familyName;
    }

    /**
     * Getter for FamilyName.
     * The family name (that is, the last name) associated with the customer profile.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFamilyName() {
        return OptionalNullable.getFrom(familyName);
    }

    /**
     * Internal Getter for Nickname.
     * A nickname for the customer profile.
     * @return Returns the Internal String
     */
    @JsonGetter("nickname")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNickname() {
        return this.nickname;
    }

    /**
     * Getter for Nickname.
     * A nickname for the customer profile.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNickname() {
        return OptionalNullable.getFrom(nickname);
    }

    /**
     * Internal Getter for CompanyName.
     * A business name associated with the customer profile.
     * @return Returns the Internal String
     */
    @JsonGetter("company_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCompanyName() {
        return this.companyName;
    }

    /**
     * Getter for CompanyName.
     * A business name associated with the customer profile.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCompanyName() {
        return OptionalNullable.getFrom(companyName);
    }

    /**
     * Internal Getter for EmailAddress.
     * The email address associated with the customer profile.
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
     * The email address associated with the customer profile.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEmailAddress() {
        return OptionalNullable.getFrom(emailAddress);
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
     * Internal Getter for PhoneNumber.
     * The phone number associated with the customer profile.
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
     * The phone number associated with the customer profile.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPhoneNumber() {
        return OptionalNullable.getFrom(phoneNumber);
    }

    /**
     * Internal Getter for Birthday.
     * The birthday associated with the customer profile, in `YYYY-MM-DD` format. For example,
     * `1998-09-21` represents September 21, 1998, and `0000-09-21` represents September 21 (without
     * a birth year).
     * @return Returns the Internal String
     */
    @JsonGetter("birthday")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBirthday() {
        return this.birthday;
    }

    /**
     * Getter for Birthday.
     * The birthday associated with the customer profile, in `YYYY-MM-DD` format. For example,
     * `1998-09-21` represents September 21, 1998, and `0000-09-21` represents September 21 (without
     * a birth year).
     * @return Returns the String
     */
    @JsonIgnore
    public String getBirthday() {
        return OptionalNullable.getFrom(birthday);
    }

    /**
     * Internal Getter for ReferenceId.
     * An optional second ID used to associate the customer profile with an entity in another
     * system.
     * @return Returns the Internal String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for ReferenceId.
     * An optional second ID used to associate the customer profile with an entity in another
     * system.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
    }

    /**
     * Internal Getter for Note.
     * A custom note associated with the customer profile.
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
     * A custom note associated with the customer profile.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
    }

    /**
     * Getter for Preferences.
     * Represents communication preferences for the customer profile.
     * @return Returns the CustomerPreferences
     */
    @JsonGetter("preferences")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerPreferences getPreferences() {
        return preferences;
    }

    /**
     * Getter for CreationSource.
     * Indicates the method used to create the customer profile.
     * @return Returns the String
     */
    @JsonGetter("creation_source")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreationSource() {
        return creationSource;
    }

    /**
     * Internal Getter for GroupIds.
     * The IDs of customer groups the customer belongs to.
     * @return Returns the Internal List of String
     */
    @JsonGetter("group_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetGroupIds() {
        return this.groupIds;
    }

    /**
     * Getter for GroupIds.
     * The IDs of customer groups the customer belongs to.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getGroupIds() {
        return OptionalNullable.getFrom(groupIds);
    }

    /**
     * Internal Getter for SegmentIds.
     * The IDs of segments the customer belongs to.
     * @return Returns the Internal List of String
     */
    @JsonGetter("segment_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetSegmentIds() {
        return this.segmentIds;
    }

    /**
     * Getter for SegmentIds.
     * The IDs of segments the customer belongs to.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getSegmentIds() {
        return OptionalNullable.getFrom(segmentIds);
    }

    /**
     * Getter for Version.
     * The Square-assigned version number of the customer profile. The version number is incremented
     * each time an update is committed to the customer profile, except for changes to customer
     * segment membership and cards on file.
     * @return Returns the Long
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getVersion() {
        return version;
    }

    /**
     * Getter for TaxIds.
     * Represents the tax ID associated with a [customer profile]($m/Customer). The corresponding
     * `tax_ids` field is available only for customers of sellers in EU countries or the United
     * Kingdom. For more information, see [Customer tax
     * IDs](https://developer.squareup.com/docs/customers-api/what-it-does#customer-tax-ids).
     * @return Returns the CustomerTaxIds
     */
    @JsonGetter("tax_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
                .address(getAddress())
                .preferences(getPreferences())
                .creationSource(getCreationSource())
                .version(getVersion())
                .taxIds(getTaxIds());
        builder.cards = internalGetCards();
        builder.givenName = internalGetGivenName();
        builder.familyName = internalGetFamilyName();
        builder.nickname = internalGetNickname();
        builder.companyName = internalGetCompanyName();
        builder.emailAddress = internalGetEmailAddress();
        builder.phoneNumber = internalGetPhoneNumber();
        builder.birthday = internalGetBirthday();
        builder.referenceId = internalGetReferenceId();
        builder.note = internalGetNote();
        builder.groupIds = internalGetGroupIds();
        builder.segmentIds = internalGetSegmentIds();
        return builder;
    }

    /**
     * Class to build instances of {@link Customer}.
     */
    public static class Builder {
        private String id;
        private String createdAt;
        private String updatedAt;
        private OptionalNullable<List<Card>> cards;
        private OptionalNullable<String> givenName;
        private OptionalNullable<String> familyName;
        private OptionalNullable<String> nickname;
        private OptionalNullable<String> companyName;
        private OptionalNullable<String> emailAddress;
        private Address address;
        private OptionalNullable<String> phoneNumber;
        private OptionalNullable<String> birthday;
        private OptionalNullable<String> referenceId;
        private OptionalNullable<String> note;
        private CustomerPreferences preferences;
        private String creationSource;
        private OptionalNullable<List<String>> groupIds;
        private OptionalNullable<List<String>> segmentIds;
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
            this.cards = OptionalNullable.of(cards);
            return this;
        }

        /**
         * UnSetter for cards.
         * @return Builder
         */
        public Builder unsetCards() {
            cards = null;
            return this;
        }

        /**
         * Setter for givenName.
         * @param  givenName  String value for givenName.
         * @return Builder
         */
        public Builder givenName(String givenName) {
            this.givenName = OptionalNullable.of(givenName);
            return this;
        }

        /**
         * UnSetter for givenName.
         * @return Builder
         */
        public Builder unsetGivenName() {
            givenName = null;
            return this;
        }

        /**
         * Setter for familyName.
         * @param  familyName  String value for familyName.
         * @return Builder
         */
        public Builder familyName(String familyName) {
            this.familyName = OptionalNullable.of(familyName);
            return this;
        }

        /**
         * UnSetter for familyName.
         * @return Builder
         */
        public Builder unsetFamilyName() {
            familyName = null;
            return this;
        }

        /**
         * Setter for nickname.
         * @param  nickname  String value for nickname.
         * @return Builder
         */
        public Builder nickname(String nickname) {
            this.nickname = OptionalNullable.of(nickname);
            return this;
        }

        /**
         * UnSetter for nickname.
         * @return Builder
         */
        public Builder unsetNickname() {
            nickname = null;
            return this;
        }

        /**
         * Setter for companyName.
         * @param  companyName  String value for companyName.
         * @return Builder
         */
        public Builder companyName(String companyName) {
            this.companyName = OptionalNullable.of(companyName);
            return this;
        }

        /**
         * UnSetter for companyName.
         * @return Builder
         */
        public Builder unsetCompanyName() {
            companyName = null;
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
         * Setter for birthday.
         * @param  birthday  String value for birthday.
         * @return Builder
         */
        public Builder birthday(String birthday) {
            this.birthday = OptionalNullable.of(birthday);
            return this;
        }

        /**
         * UnSetter for birthday.
         * @return Builder
         */
        public Builder unsetBirthday() {
            birthday = null;
            return this;
        }

        /**
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = OptionalNullable.of(referenceId);
            return this;
        }

        /**
         * UnSetter for referenceId.
         * @return Builder
         */
        public Builder unsetReferenceId() {
            referenceId = null;
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
            this.groupIds = OptionalNullable.of(groupIds);
            return this;
        }

        /**
         * UnSetter for groupIds.
         * @return Builder
         */
        public Builder unsetGroupIds() {
            groupIds = null;
            return this;
        }

        /**
         * Setter for segmentIds.
         * @param  segmentIds  List of String value for segmentIds.
         * @return Builder
         */
        public Builder segmentIds(List<String> segmentIds) {
            this.segmentIds = OptionalNullable.of(segmentIds);
            return this;
        }

        /**
         * UnSetter for segmentIds.
         * @return Builder
         */
        public Builder unsetSegmentIds() {
            segmentIds = null;
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

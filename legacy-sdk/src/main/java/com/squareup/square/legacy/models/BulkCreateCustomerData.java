package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for BulkCreateCustomerData type.
 */
public class BulkCreateCustomerData {
    private final OptionalNullable<String> givenName;
    private final OptionalNullable<String> familyName;
    private final OptionalNullable<String> companyName;
    private final OptionalNullable<String> nickname;
    private final OptionalNullable<String> emailAddress;
    private final Address address;
    private final OptionalNullable<String> phoneNumber;
    private final OptionalNullable<String> referenceId;
    private final OptionalNullable<String> note;
    private final OptionalNullable<String> birthday;
    private final CustomerTaxIds taxIds;

    /**
     * Initialization constructor.
     * @param  givenName  String value for givenName.
     * @param  familyName  String value for familyName.
     * @param  companyName  String value for companyName.
     * @param  nickname  String value for nickname.
     * @param  emailAddress  String value for emailAddress.
     * @param  address  Address value for address.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  referenceId  String value for referenceId.
     * @param  note  String value for note.
     * @param  birthday  String value for birthday.
     * @param  taxIds  CustomerTaxIds value for taxIds.
     */
    @JsonCreator
    public BulkCreateCustomerData(
            @JsonProperty("given_name") String givenName,
            @JsonProperty("family_name") String familyName,
            @JsonProperty("company_name") String companyName,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("address") Address address,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("note") String note,
            @JsonProperty("birthday") String birthday,
            @JsonProperty("tax_ids") CustomerTaxIds taxIds) {
        this.givenName = OptionalNullable.of(givenName);
        this.familyName = OptionalNullable.of(familyName);
        this.companyName = OptionalNullable.of(companyName);
        this.nickname = OptionalNullable.of(nickname);
        this.emailAddress = OptionalNullable.of(emailAddress);
        this.address = address;
        this.phoneNumber = OptionalNullable.of(phoneNumber);
        this.referenceId = OptionalNullable.of(referenceId);
        this.note = OptionalNullable.of(note);
        this.birthday = OptionalNullable.of(birthday);
        this.taxIds = taxIds;
    }

    /**
     * Initialization constructor.
     * @param  givenName  String value for givenName.
     * @param  familyName  String value for familyName.
     * @param  companyName  String value for companyName.
     * @param  nickname  String value for nickname.
     * @param  emailAddress  String value for emailAddress.
     * @param  address  Address value for address.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  referenceId  String value for referenceId.
     * @param  note  String value for note.
     * @param  birthday  String value for birthday.
     * @param  taxIds  CustomerTaxIds value for taxIds.
     */
    protected BulkCreateCustomerData(
            OptionalNullable<String> givenName,
            OptionalNullable<String> familyName,
            OptionalNullable<String> companyName,
            OptionalNullable<String> nickname,
            OptionalNullable<String> emailAddress,
            Address address,
            OptionalNullable<String> phoneNumber,
            OptionalNullable<String> referenceId,
            OptionalNullable<String> note,
            OptionalNullable<String> birthday,
            CustomerTaxIds taxIds) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.companyName = companyName;
        this.nickname = nickname;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.referenceId = referenceId;
        this.note = note;
        this.birthday = birthday;
        this.taxIds = taxIds;
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
     * The phone number associated with the customer profile. The phone number must be valid and can
     * contain 9–16 digits, with an optional `+` prefix and country code. For more information, see
     * [Customer phone
     * numbers](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#phone-number).
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
     * The phone number associated with the customer profile. The phone number must be valid and can
     * contain 9–16 digits, with an optional `+` prefix and country code. For more information, see
     * [Customer phone
     * numbers](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#phone-number).
     * @return Returns the String
     */
    @JsonIgnore
    public String getPhoneNumber() {
        return OptionalNullable.getFrom(phoneNumber);
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
     * Internal Getter for Birthday.
     * The birthday associated with the customer profile, in `YYYY-MM-DD` or `MM-DD` format. For
     * example, specify `1998-09-21` for September 21, 1998, or `09-21` for September 21. Birthdays
     * are returned in `YYYY-MM-DD` format, where `YYYY` is the specified birth year or `0000` if a
     * birth year is not specified.
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
     * The birthday associated with the customer profile, in `YYYY-MM-DD` or `MM-DD` format. For
     * example, specify `1998-09-21` for September 21, 1998, or `09-21` for September 21. Birthdays
     * are returned in `YYYY-MM-DD` format, where `YYYY` is the specified birth year or `0000` if a
     * birth year is not specified.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBirthday() {
        return OptionalNullable.getFrom(birthday);
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
        return Objects.hash(
                givenName,
                familyName,
                companyName,
                nickname,
                emailAddress,
                address,
                phoneNumber,
                referenceId,
                note,
                birthday,
                taxIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkCreateCustomerData)) {
            return false;
        }
        BulkCreateCustomerData other = (BulkCreateCustomerData) obj;
        return Objects.equals(givenName, other.givenName)
                && Objects.equals(familyName, other.familyName)
                && Objects.equals(companyName, other.companyName)
                && Objects.equals(nickname, other.nickname)
                && Objects.equals(emailAddress, other.emailAddress)
                && Objects.equals(address, other.address)
                && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(referenceId, other.referenceId)
                && Objects.equals(note, other.note)
                && Objects.equals(birthday, other.birthday)
                && Objects.equals(taxIds, other.taxIds);
    }

    /**
     * Converts this BulkCreateCustomerData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkCreateCustomerData [" + "givenName=" + givenName + ", familyName=" + familyName
                + ", companyName=" + companyName + ", nickname=" + nickname + ", emailAddress="
                + emailAddress + ", address=" + address + ", phoneNumber=" + phoneNumber
                + ", referenceId=" + referenceId + ", note=" + note + ", birthday=" + birthday
                + ", taxIds=" + taxIds + "]";
    }

    /**
     * Builds a new {@link BulkCreateCustomerData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkCreateCustomerData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().address(getAddress()).taxIds(getTaxIds());
        builder.givenName = internalGetGivenName();
        builder.familyName = internalGetFamilyName();
        builder.companyName = internalGetCompanyName();
        builder.nickname = internalGetNickname();
        builder.emailAddress = internalGetEmailAddress();
        builder.phoneNumber = internalGetPhoneNumber();
        builder.referenceId = internalGetReferenceId();
        builder.note = internalGetNote();
        builder.birthday = internalGetBirthday();
        return builder;
    }

    /**
     * Class to build instances of {@link BulkCreateCustomerData}.
     */
    public static class Builder {
        private OptionalNullable<String> givenName;
        private OptionalNullable<String> familyName;
        private OptionalNullable<String> companyName;
        private OptionalNullable<String> nickname;
        private OptionalNullable<String> emailAddress;
        private Address address;
        private OptionalNullable<String> phoneNumber;
        private OptionalNullable<String> referenceId;
        private OptionalNullable<String> note;
        private OptionalNullable<String> birthday;
        private CustomerTaxIds taxIds;

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
         * Setter for taxIds.
         * @param  taxIds  CustomerTaxIds value for taxIds.
         * @return Builder
         */
        public Builder taxIds(CustomerTaxIds taxIds) {
            this.taxIds = taxIds;
            return this;
        }

        /**
         * Builds a new {@link BulkCreateCustomerData} object using the set fields.
         * @return {@link BulkCreateCustomerData}
         */
        public BulkCreateCustomerData build() {
            return new BulkCreateCustomerData(
                    givenName,
                    familyName,
                    companyName,
                    nickname,
                    emailAddress,
                    address,
                    phoneNumber,
                    referenceId,
                    note,
                    birthday,
                    taxIds);
        }
    }
}

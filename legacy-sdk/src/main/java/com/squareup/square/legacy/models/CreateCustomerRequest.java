package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateCustomerRequest type.
 */
public class CreateCustomerRequest {
    private final String idempotencyKey;
    private final String givenName;
    private final String familyName;
    private final String companyName;
    private final String nickname;
    private final String emailAddress;
    private final Address address;
    private final String phoneNumber;
    private final String referenceId;
    private final String note;
    private final String birthday;
    private final CustomerTaxIds taxIds;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
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
    public CreateCustomerRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
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
        this.idempotencyKey = idempotencyKey;
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
     * Getter for IdempotencyKey.
     * The idempotency key for the request.	For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for GivenName.
     * The given name (that is, the first name) associated with the customer profile. The maximum
     * length for this value is 300 characters.
     * @return Returns the String
     */
    @JsonGetter("given_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getGivenName() {
        return givenName;
    }

    /**
     * Getter for FamilyName.
     * The family name (that is, the last name) associated with the customer profile. The maximum
     * length for this value is 300 characters.
     * @return Returns the String
     */
    @JsonGetter("family_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Getter for CompanyName.
     * A business name associated with the customer profile. The maximum length for this value is
     * 500 characters.
     * @return Returns the String
     */
    @JsonGetter("company_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Getter for Nickname.
     * A nickname for the customer profile. The maximum length for this value is 100 characters.
     * @return Returns the String
     */
    @JsonGetter("nickname")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNickname() {
        return nickname;
    }

    /**
     * Getter for EmailAddress.
     * The email address associated with the customer profile. The maximum length for this value is
     * 254 characters.
     * @return Returns the String
     */
    @JsonGetter("email_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEmailAddress() {
        return emailAddress;
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
     * Getter for PhoneNumber.
     * The phone number associated with the customer profile. The phone number must be valid and can
     * contain 9–16 digits, with an optional `+` prefix and country code. For more information, see
     * [Customer phone
     * numbers](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#phone-number).
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for ReferenceId.
     * An optional second ID used to associate the customer profile with an entity in another
     * system. The maximum length for this value is 100 characters.
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for Note.
     * A custom note associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNote() {
        return note;
    }

    /**
     * Getter for Birthday.
     * The birthday associated with the customer profile, in `YYYY-MM-DD` or `MM-DD` format. For
     * example, specify `1998-09-21` for September 21, 1998, or `09-21` for September 21. Birthdays
     * are returned in `YYYY-MM-DD` format, where `YYYY` is the specified birth year or `0000` if a
     * birth year is not specified.
     * @return Returns the String
     */
    @JsonGetter("birthday")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBirthday() {
        return birthday;
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
                idempotencyKey,
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
        if (!(obj instanceof CreateCustomerRequest)) {
            return false;
        }
        CreateCustomerRequest other = (CreateCustomerRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
                && Objects.equals(givenName, other.givenName)
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
     * Converts this CreateCustomerRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateCustomerRequest [" + "idempotencyKey=" + idempotencyKey + ", givenName="
                + givenName + ", familyName=" + familyName + ", companyName=" + companyName
                + ", nickname=" + nickname + ", emailAddress=" + emailAddress + ", address="
                + address + ", phoneNumber=" + phoneNumber + ", referenceId=" + referenceId
                + ", note=" + note + ", birthday=" + birthday + ", taxIds=" + taxIds + "]";
    }

    /**
     * Builds a new {@link CreateCustomerRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCustomerRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .idempotencyKey(getIdempotencyKey())
                .givenName(getGivenName())
                .familyName(getFamilyName())
                .companyName(getCompanyName())
                .nickname(getNickname())
                .emailAddress(getEmailAddress())
                .address(getAddress())
                .phoneNumber(getPhoneNumber())
                .referenceId(getReferenceId())
                .note(getNote())
                .birthday(getBirthday())
                .taxIds(getTaxIds());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCustomerRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String givenName;
        private String familyName;
        private String companyName;
        private String nickname;
        private String emailAddress;
        private Address address;
        private String phoneNumber;
        private String referenceId;
        private String note;
        private String birthday;
        private CustomerTaxIds taxIds;

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Setter for companyName.
         * @param  companyName  String value for companyName.
         * @return Builder
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
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
         * Setter for birthday.
         * @param  birthday  String value for birthday.
         * @return Builder
         */
        public Builder birthday(String birthday) {
            this.birthday = birthday;
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
         * Builds a new {@link CreateCustomerRequest} object using the set fields.
         * @return {@link CreateCustomerRequest}
         */
        public CreateCustomerRequest build() {
            return new CreateCustomerRequest(
                    idempotencyKey,
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

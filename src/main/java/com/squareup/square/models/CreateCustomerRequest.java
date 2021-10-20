
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateCustomerRequest type.
 */
public class CreateCustomerRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String idempotencyKey;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String givenName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String familyName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String companyName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String nickname;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String emailAddress;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Address address;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String phoneNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String referenceId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String birthday;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for GivenName.
     * The given name (that is, the first name) associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("given_name")
    public String getGivenName() {
        return givenName;
    }

    /**
     * Getter for FamilyName.
     * The family name (that is, the last name) associated with the customer profile.
     * @return Returns the String
     */
    @JsonGetter("family_name")
    public String getFamilyName() {
        return familyName;
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
     * Getter for Nickname.
     * A nickname for the customer profile.
     * @return Returns the String
     */
    @JsonGetter("nickname")
    public String getNickname() {
        return nickname;
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
     * Getter for Birthday.
     * The birthday associated with the customer profile, in RFC 3339 format. The year is optional.
     * The timezone and time are not allowed. For example, `0000-09-21T00:00:00-00:00` represents a
     * birthday on September 21 and `1998-09-21T00:00:00-00:00` represents a birthday on September
     * 21, 1998. You can also specify this value in `YYYY-MM-DD` format.
     * @return Returns the String
     */
    @JsonGetter("birthday")
    public String getBirthday() {
        return birthday;
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
        return Objects.hash(idempotencyKey, givenName, familyName, companyName, nickname,
                emailAddress, address, phoneNumber, referenceId, note, birthday, taxIds);
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
            return new CreateCustomerRequest(idempotencyKey, givenName, familyName, companyName,
                    nickname, emailAddress, address, phoneNumber, referenceId, note, birthday,
                    taxIds);
        }
    }
}

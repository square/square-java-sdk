package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateCustomerRequest type.
 */
public class CreateCustomerRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param givenName
     * @param familyName
     * @param companyName
     * @param nickname
     * @param emailAddress
     * @param address
     * @param phoneNumber
     * @param referenceId
     * @param note
     * @param birthday
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
            @JsonProperty("birthday") String birthday) {
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
    }

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
    /**
     * Getter for IdempotencyKey.
     * The idempotency key for the request.	See the
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency) guide for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
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
     * Getter for CompanyName.
     * A business name associated with the customer profile.
     */
    @JsonGetter("company_name")
    public String getCompanyName() {
        return this.companyName;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, givenName, familyName, companyName, nickname,
            emailAddress, address, phoneNumber, referenceId, note, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateCustomerRequest)) {
            return false;
        }
        CreateCustomerRequest createCustomerRequest = (CreateCustomerRequest) obj;
        return Objects.equals(idempotencyKey, createCustomerRequest.idempotencyKey) &&
            Objects.equals(givenName, createCustomerRequest.givenName) &&
            Objects.equals(familyName, createCustomerRequest.familyName) &&
            Objects.equals(companyName, createCustomerRequest.companyName) &&
            Objects.equals(nickname, createCustomerRequest.nickname) &&
            Objects.equals(emailAddress, createCustomerRequest.emailAddress) &&
            Objects.equals(address, createCustomerRequest.address) &&
            Objects.equals(phoneNumber, createCustomerRequest.phoneNumber) &&
            Objects.equals(referenceId, createCustomerRequest.referenceId) &&
            Objects.equals(note, createCustomerRequest.note) &&
            Objects.equals(birthday, createCustomerRequest.birthday);
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
            .birthday(getBirthday());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateCustomerRequest}
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

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Setter for companyName
         * @param companyName
         * @return Builder
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
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
         * Setter for birthday
         * @param birthday
         * @return Builder
         */
        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        /**
         * Builds a new {@link CreateCustomerRequest} object using the set fields.
         * @return {@link CreateCustomerRequest}
         */
        public CreateCustomerRequest build() {
            return new CreateCustomerRequest(idempotencyKey,
                givenName,
                familyName,
                companyName,
                nickname,
                emailAddress,
                address,
                phoneNumber,
                referenceId,
                note,
                birthday);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateCustomerRequest type.
 */
public class UpdateCustomerRequest {
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
     */
    @JsonCreator
    public UpdateCustomerRequest(
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
     * Represents a physical address.
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
     * An optional, second ID used to associate the customer profile with an entity in another
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
     * The birthday associated with the customer profile, in RFC 3339 format. Year is optional,
     * timezone and times are not allowed. For example: `0000-09-01T00:00:00-00:00` indicates a
     * birthday on September 1st. `1998-09-01T00:00:00-00:00` indications a birthday on September
     * 1st __1998__.
     * @return Returns the String
     */
    @JsonGetter("birthday")
    public String getBirthday() {
        return birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(givenName, familyName, companyName, nickname, emailAddress, address,
                phoneNumber, referenceId, note, birthday);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateCustomerRequest)) {
            return false;
        }
        UpdateCustomerRequest other = (UpdateCustomerRequest) obj;
        return Objects.equals(givenName, other.givenName)
            && Objects.equals(familyName, other.familyName)
            && Objects.equals(companyName, other.companyName)
            && Objects.equals(nickname, other.nickname)
            && Objects.equals(emailAddress, other.emailAddress)
            && Objects.equals(address, other.address)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(note, other.note)
            && Objects.equals(birthday, other.birthday);
    }

    /**
     * Converts this UpdateCustomerRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateCustomerRequest [" + "givenName=" + givenName + ", familyName=" + familyName
                + ", companyName=" + companyName + ", nickname=" + nickname + ", emailAddress="
                + emailAddress + ", address=" + address + ", phoneNumber=" + phoneNumber
                + ", referenceId=" + referenceId + ", note=" + note + ", birthday=" + birthday
                + "]";
    }

    /**
     * Builds a new {@link UpdateCustomerRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateCustomerRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
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
     * Class to build instances of {@link UpdateCustomerRequest}.
     */
    public static class Builder {
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
         * Builds a new {@link UpdateCustomerRequest} object using the set fields.
         * @return {@link UpdateCustomerRequest}
         */
        public UpdateCustomerRequest build() {
            return new UpdateCustomerRequest(givenName, familyName, companyName, nickname,
                    emailAddress, address, phoneNumber, referenceId, note, birthday);
        }
    }
}

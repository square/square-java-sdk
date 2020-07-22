package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for InvoiceRecipient type.
 */
public class InvoiceRecipient {

    /**
     * Initialization constructor.
     * @param customerId
     * @param givenName
     * @param familyName
     * @param emailAddress
     * @param address
     * @param phoneNumber
     * @param companyName
     */
    @JsonCreator
    public InvoiceRecipient(
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("given_name") String givenName,
            @JsonProperty("family_name") String familyName,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("address") Address address,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("company_name") String companyName) {
        this.customerId = customerId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
    }

    private final String customerId;
    private final String givenName;
    private final String familyName;
    private final String emailAddress;
    private final Address address;
    private final String phoneNumber;
    private final String companyName;
    /**
     * Getter for CustomerId.
     * The ID of the customer. This is the customer profile ID that 
     * you provide when creating a draft invoice.
     */
    @JsonGetter("customer_id")
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for GivenName.
     * The recipient's given (that is, first) name.
     */
    @JsonGetter("given_name")
    public String getGivenName() {
        return this.givenName;
    }

    /**
     * Getter for FamilyName.
     * The recipient's family (that is, last) name.
     */
    @JsonGetter("family_name")
    public String getFamilyName() {
        return this.familyName;
    }

    /**
     * Getter for EmailAddress.
     * The recipient's email address.
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
     * The recipient's phone number.
     */
    @JsonGetter("phone_number")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter for CompanyName.
     * The name of the recipient's company.
     */
    @JsonGetter("company_name")
    public String getCompanyName() {
        return this.companyName;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(customerId, givenName, familyName, emailAddress, address, phoneNumber,
            companyName);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof InvoiceRecipient)) {
            return false;
        }
        InvoiceRecipient invoiceRecipient = (InvoiceRecipient) obj;
        return Objects.equals(customerId, invoiceRecipient.customerId) &&
            Objects.equals(givenName, invoiceRecipient.givenName) &&
            Objects.equals(familyName, invoiceRecipient.familyName) &&
            Objects.equals(emailAddress, invoiceRecipient.emailAddress) &&
            Objects.equals(address, invoiceRecipient.address) &&
            Objects.equals(phoneNumber, invoiceRecipient.phoneNumber) &&
            Objects.equals(companyName, invoiceRecipient.companyName);
    }

    /**
     * Builds a new {@link InvoiceRecipient.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceRecipient.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .customerId(getCustomerId())
            .givenName(getGivenName())
            .familyName(getFamilyName())
            .emailAddress(getEmailAddress())
            .address(getAddress())
            .phoneNumber(getPhoneNumber())
            .companyName(getCompanyName());
            return builder;
    }

    /**
     * Class to build instances of {@link InvoiceRecipient}
     */
    public static class Builder {
        private String customerId;
        private String givenName;
        private String familyName;
        private String emailAddress;
        private Address address;
        private String phoneNumber;
        private String companyName;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for customerId
         * @param customerId
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
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
         * Setter for companyName
         * @param companyName
         * @return Builder
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        /**
         * Builds a new {@link InvoiceRecipient} object using the set fields.
         * @return {@link InvoiceRecipient}
         */
        public InvoiceRecipient build() {
            return new InvoiceRecipient(customerId,
                givenName,
                familyName,
                emailAddress,
                address,
                phoneNumber,
                companyName);
        }
    }
}

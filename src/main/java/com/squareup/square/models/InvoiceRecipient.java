
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for InvoiceRecipient type.
 */
public class InvoiceRecipient {
    private final String customerId;
    private final String givenName;
    private final String familyName;
    private final String emailAddress;
    private final Address address;
    private final String phoneNumber;
    private final String companyName;
    private final InvoiceRecipientTaxIds taxIds;

    /**
     * Initialization constructor.
     * @param  customerId  String value for customerId.
     * @param  givenName  String value for givenName.
     * @param  familyName  String value for familyName.
     * @param  emailAddress  String value for emailAddress.
     * @param  address  Address value for address.
     * @param  phoneNumber  String value for phoneNumber.
     * @param  companyName  String value for companyName.
     * @param  taxIds  InvoiceRecipientTaxIds value for taxIds.
     */
    @JsonCreator
    public InvoiceRecipient(
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("given_name") String givenName,
            @JsonProperty("family_name") String familyName,
            @JsonProperty("email_address") String emailAddress,
            @JsonProperty("address") Address address,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("company_name") String companyName,
            @JsonProperty("tax_ids") InvoiceRecipientTaxIds taxIds) {
        this.customerId = customerId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.taxIds = taxIds;
    }

    /**
     * Getter for CustomerId.
     * The ID of the customer. This is the customer profile ID that you provide when creating a
     * draft invoice.
     * @return Returns the String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Getter for GivenName.
     * The recipient's given (that is, first) name.
     * @return Returns the String
     */
    @JsonGetter("given_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getGivenName() {
        return givenName;
    }

    /**
     * Getter for FamilyName.
     * The recipient's family (that is, last) name.
     * @return Returns the String
     */
    @JsonGetter("family_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Getter for EmailAddress.
     * The recipient's email address.
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
     * The recipient's phone number.
     * @return Returns the String
     */
    @JsonGetter("phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter for CompanyName.
     * The name of the recipient's company.
     * @return Returns the String
     */
    @JsonGetter("company_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Getter for TaxIds.
     * Represents the tax IDs for an invoice recipient. The country of the seller account determines
     * whether the corresponding `tax_ids` field is available for the customer. For more
     * information, see [Invoice recipient tax
     * IDs](https://developer.squareup.com/docs/invoices-api/overview#recipient-tax-ids).
     * @return Returns the InvoiceRecipientTaxIds
     */
    @JsonGetter("tax_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InvoiceRecipientTaxIds getTaxIds() {
        return taxIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, givenName, familyName, emailAddress, address, phoneNumber,
                companyName, taxIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvoiceRecipient)) {
            return false;
        }
        InvoiceRecipient other = (InvoiceRecipient) obj;
        return Objects.equals(customerId, other.customerId)
            && Objects.equals(givenName, other.givenName)
            && Objects.equals(familyName, other.familyName)
            && Objects.equals(emailAddress, other.emailAddress)
            && Objects.equals(address, other.address)
            && Objects.equals(phoneNumber, other.phoneNumber)
            && Objects.equals(companyName, other.companyName)
            && Objects.equals(taxIds, other.taxIds);
    }

    /**
     * Converts this InvoiceRecipient into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoiceRecipient [" + "customerId=" + customerId + ", givenName=" + givenName
                + ", familyName=" + familyName + ", emailAddress=" + emailAddress + ", address="
                + address + ", phoneNumber=" + phoneNumber + ", companyName=" + companyName
                + ", taxIds=" + taxIds + "]";
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
                .companyName(getCompanyName())
                .taxIds(getTaxIds());
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceRecipient}.
     */
    public static class Builder {
        private String customerId;
        private String givenName;
        private String familyName;
        private String emailAddress;
        private Address address;
        private String phoneNumber;
        private String companyName;
        private InvoiceRecipientTaxIds taxIds;



        /**
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
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
         * Setter for companyName.
         * @param  companyName  String value for companyName.
         * @return Builder
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        /**
         * Setter for taxIds.
         * @param  taxIds  InvoiceRecipientTaxIds value for taxIds.
         * @return Builder
         */
        public Builder taxIds(InvoiceRecipientTaxIds taxIds) {
            this.taxIds = taxIds;
            return this;
        }

        /**
         * Builds a new {@link InvoiceRecipient} object using the set fields.
         * @return {@link InvoiceRecipient}
         */
        public InvoiceRecipient build() {
            return new InvoiceRecipient(customerId, givenName, familyName, emailAddress, address,
                    phoneNumber, companyName, taxIds);
        }
    }
}

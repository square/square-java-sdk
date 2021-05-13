
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BankAccountPaymentDetails type.
 */
public class BankAccountPaymentDetails {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String bankName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String transferType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String accountOwnershipType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String fingerprint;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String country;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String statementDescription;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final ACHDetails achDetails;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  bankName  String value for bankName.
     * @param  transferType  String value for transferType.
     * @param  accountOwnershipType  String value for accountOwnershipType.
     * @param  fingerprint  String value for fingerprint.
     * @param  country  String value for country.
     * @param  statementDescription  String value for statementDescription.
     * @param  achDetails  ACHDetails value for achDetails.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BankAccountPaymentDetails(
            @JsonProperty("bank_name") String bankName,
            @JsonProperty("transfer_type") String transferType,
            @JsonProperty("account_ownership_type") String accountOwnershipType,
            @JsonProperty("fingerprint") String fingerprint,
            @JsonProperty("country") String country,
            @JsonProperty("statement_description") String statementDescription,
            @JsonProperty("ach_details") ACHDetails achDetails,
            @JsonProperty("errors") List<Error> errors) {
        this.bankName = bankName;
        this.transferType = transferType;
        this.accountOwnershipType = accountOwnershipType;
        this.fingerprint = fingerprint;
        this.country = country;
        this.statementDescription = statementDescription;
        this.achDetails = achDetails;
        this.errors = errors;
    }

    /**
     * Getter for BankName.
     * The name of the bank associated with the bank account.
     * @return Returns the String
     */
    @JsonGetter("bank_name")
    public String getBankName() {
        return bankName;
    }

    /**
     * Getter for TransferType.
     * The type of the bank transfer. The type can be `ACH` or `UNKNOWN`.
     * @return Returns the String
     */
    @JsonGetter("transfer_type")
    public String getTransferType() {
        return transferType;
    }

    /**
     * Getter for AccountOwnershipType.
     * The ownership type of the bank account performing the transfer. The type can be `INDIVIDUAL`,
     * `COMPANY`, or `UNKNOWN`.
     * @return Returns the String
     */
    @JsonGetter("account_ownership_type")
    public String getAccountOwnershipType() {
        return accountOwnershipType;
    }

    /**
     * Getter for Fingerprint.
     * Uniquely identifies the bank account for this seller and can be used to determine if payments
     * are from the same bank account.
     * @return Returns the String
     */
    @JsonGetter("fingerprint")
    public String getFingerprint() {
        return fingerprint;
    }

    /**
     * Getter for Country.
     * The two-letter ISO code representing the country the bank account is located in.
     * @return Returns the String
     */
    @JsonGetter("country")
    public String getCountry() {
        return country;
    }

    /**
     * Getter for StatementDescription.
     * The statement description as sent to the bank.
     * @return Returns the String
     */
    @JsonGetter("statement_description")
    public String getStatementDescription() {
        return statementDescription;
    }

    /**
     * Getter for AchDetails.
     * ACH-specific details about `BANK_ACCOUNT` type payments with the `transfer_type` of `ACH`.
     * @return Returns the ACHDetails
     */
    @JsonGetter("ach_details")
    public ACHDetails getAchDetails() {
        return achDetails;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, transferType, accountOwnershipType, fingerprint, country,
                statementDescription, achDetails, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BankAccountPaymentDetails)) {
            return false;
        }
        BankAccountPaymentDetails other = (BankAccountPaymentDetails) obj;
        return Objects.equals(bankName, other.bankName)
            && Objects.equals(transferType, other.transferType)
            && Objects.equals(accountOwnershipType, other.accountOwnershipType)
            && Objects.equals(fingerprint, other.fingerprint)
            && Objects.equals(country, other.country)
            && Objects.equals(statementDescription, other.statementDescription)
            && Objects.equals(achDetails, other.achDetails)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BankAccountPaymentDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BankAccountPaymentDetails [" + "bankName=" + bankName + ", transferType="
                + transferType + ", accountOwnershipType=" + accountOwnershipType + ", fingerprint="
                + fingerprint + ", country=" + country + ", statementDescription="
                + statementDescription + ", achDetails=" + achDetails + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BankAccountPaymentDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BankAccountPaymentDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .bankName(getBankName())
                .transferType(getTransferType())
                .accountOwnershipType(getAccountOwnershipType())
                .fingerprint(getFingerprint())
                .country(getCountry())
                .statementDescription(getStatementDescription())
                .achDetails(getAchDetails())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BankAccountPaymentDetails}.
     */
    public static class Builder {
        private String bankName;
        private String transferType;
        private String accountOwnershipType;
        private String fingerprint;
        private String country;
        private String statementDescription;
        private ACHDetails achDetails;
        private List<Error> errors;



        /**
         * Setter for bankName.
         * @param  bankName  String value for bankName.
         * @return Builder
         */
        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        /**
         * Setter for transferType.
         * @param  transferType  String value for transferType.
         * @return Builder
         */
        public Builder transferType(String transferType) {
            this.transferType = transferType;
            return this;
        }

        /**
         * Setter for accountOwnershipType.
         * @param  accountOwnershipType  String value for accountOwnershipType.
         * @return Builder
         */
        public Builder accountOwnershipType(String accountOwnershipType) {
            this.accountOwnershipType = accountOwnershipType;
            return this;
        }

        /**
         * Setter for fingerprint.
         * @param  fingerprint  String value for fingerprint.
         * @return Builder
         */
        public Builder fingerprint(String fingerprint) {
            this.fingerprint = fingerprint;
            return this;
        }

        /**
         * Setter for country.
         * @param  country  String value for country.
         * @return Builder
         */
        public Builder country(String country) {
            this.country = country;
            return this;
        }

        /**
         * Setter for statementDescription.
         * @param  statementDescription  String value for statementDescription.
         * @return Builder
         */
        public Builder statementDescription(String statementDescription) {
            this.statementDescription = statementDescription;
            return this;
        }

        /**
         * Setter for achDetails.
         * @param  achDetails  ACHDetails value for achDetails.
         * @return Builder
         */
        public Builder achDetails(ACHDetails achDetails) {
            this.achDetails = achDetails;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link BankAccountPaymentDetails} object using the set fields.
         * @return {@link BankAccountPaymentDetails}
         */
        public BankAccountPaymentDetails build() {
            return new BankAccountPaymentDetails(bankName, transferType, accountOwnershipType,
                    fingerprint, country, statementDescription, achDetails, errors);
        }
    }
}

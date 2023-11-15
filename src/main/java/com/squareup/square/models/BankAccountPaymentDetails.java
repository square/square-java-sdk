
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BankAccountPaymentDetails type.
 */
public class BankAccountPaymentDetails {
    private final OptionalNullable<String> bankName;
    private final OptionalNullable<String> transferType;
    private final OptionalNullable<String> accountOwnershipType;
    private final OptionalNullable<String> fingerprint;
    private final OptionalNullable<String> country;
    private final OptionalNullable<String> statementDescription;
    private final ACHDetails achDetails;
    private final OptionalNullable<List<Error>> errors;

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
        this.bankName = OptionalNullable.of(bankName);
        this.transferType = OptionalNullable.of(transferType);
        this.accountOwnershipType = OptionalNullable.of(accountOwnershipType);
        this.fingerprint = OptionalNullable.of(fingerprint);
        this.country = OptionalNullable.of(country);
        this.statementDescription = OptionalNullable.of(statementDescription);
        this.achDetails = achDetails;
        this.errors = OptionalNullable.of(errors);
    }

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

    protected BankAccountPaymentDetails(OptionalNullable<String> bankName,
            OptionalNullable<String> transferType, OptionalNullable<String> accountOwnershipType,
            OptionalNullable<String> fingerprint, OptionalNullable<String> country,
            OptionalNullable<String> statementDescription, ACHDetails achDetails,
            OptionalNullable<List<Error>> errors) {
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
     * Internal Getter for BankName.
     * The name of the bank associated with the bank account.
     * @return Returns the Internal String
     */
    @JsonGetter("bank_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBankName() {
        return this.bankName;
    }

    /**
     * Getter for BankName.
     * The name of the bank associated with the bank account.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBankName() {
        return OptionalNullable.getFrom(bankName);
    }

    /**
     * Internal Getter for TransferType.
     * The type of the bank transfer. The type can be `ACH` or `UNKNOWN`.
     * @return Returns the Internal String
     */
    @JsonGetter("transfer_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTransferType() {
        return this.transferType;
    }

    /**
     * Getter for TransferType.
     * The type of the bank transfer. The type can be `ACH` or `UNKNOWN`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTransferType() {
        return OptionalNullable.getFrom(transferType);
    }

    /**
     * Internal Getter for AccountOwnershipType.
     * The ownership type of the bank account performing the transfer. The type can be `INDIVIDUAL`,
     * `COMPANY`, or `ACCOUNT_TYPE_UNKNOWN`.
     * @return Returns the Internal String
     */
    @JsonGetter("account_ownership_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAccountOwnershipType() {
        return this.accountOwnershipType;
    }

    /**
     * Getter for AccountOwnershipType.
     * The ownership type of the bank account performing the transfer. The type can be `INDIVIDUAL`,
     * `COMPANY`, or `ACCOUNT_TYPE_UNKNOWN`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAccountOwnershipType() {
        return OptionalNullable.getFrom(accountOwnershipType);
    }

    /**
     * Internal Getter for Fingerprint.
     * Uniquely identifies the bank account for this seller and can be used to determine if payments
     * are from the same bank account.
     * @return Returns the Internal String
     */
    @JsonGetter("fingerprint")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFingerprint() {
        return this.fingerprint;
    }

    /**
     * Getter for Fingerprint.
     * Uniquely identifies the bank account for this seller and can be used to determine if payments
     * are from the same bank account.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFingerprint() {
        return OptionalNullable.getFrom(fingerprint);
    }

    /**
     * Internal Getter for Country.
     * The two-letter ISO code representing the country the bank account is located in.
     * @return Returns the Internal String
     */
    @JsonGetter("country")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCountry() {
        return this.country;
    }

    /**
     * Getter for Country.
     * The two-letter ISO code representing the country the bank account is located in.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCountry() {
        return OptionalNullable.getFrom(country);
    }

    /**
     * Internal Getter for StatementDescription.
     * The statement description as sent to the bank.
     * @return Returns the Internal String
     */
    @JsonGetter("statement_description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStatementDescription() {
        return this.statementDescription;
    }

    /**
     * Getter for StatementDescription.
     * The statement description as sent to the bank.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStatementDescription() {
        return OptionalNullable.getFrom(statementDescription);
    }

    /**
     * Getter for AchDetails.
     * ACH-specific details about `BANK_ACCOUNT` type payments with the `transfer_type` of `ACH`.
     * @return Returns the ACHDetails
     */
    @JsonGetter("ach_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ACHDetails getAchDetails() {
        return achDetails;
    }

    /**
     * Internal Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the Internal List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Error>> internalGetErrors() {
        return this.errors;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonIgnore
    public List<Error> getErrors() {
        return OptionalNullable.getFrom(errors);
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
                .achDetails(getAchDetails());
        builder.bankName = internalGetBankName();
        builder.transferType = internalGetTransferType();
        builder.accountOwnershipType = internalGetAccountOwnershipType();
        builder.fingerprint = internalGetFingerprint();
        builder.country = internalGetCountry();
        builder.statementDescription = internalGetStatementDescription();
        builder.errors = internalGetErrors();
        return builder;
    }

    /**
     * Class to build instances of {@link BankAccountPaymentDetails}.
     */
    public static class Builder {
        private OptionalNullable<String> bankName;
        private OptionalNullable<String> transferType;
        private OptionalNullable<String> accountOwnershipType;
        private OptionalNullable<String> fingerprint;
        private OptionalNullable<String> country;
        private OptionalNullable<String> statementDescription;
        private ACHDetails achDetails;
        private OptionalNullable<List<Error>> errors;



        /**
         * Setter for bankName.
         * @param  bankName  String value for bankName.
         * @return Builder
         */
        public Builder bankName(String bankName) {
            this.bankName = OptionalNullable.of(bankName);
            return this;
        }

        /**
         * UnSetter for bankName.
         * @return Builder
         */
        public Builder unsetBankName() {
            bankName = null;
            return this;
        }

        /**
         * Setter for transferType.
         * @param  transferType  String value for transferType.
         * @return Builder
         */
        public Builder transferType(String transferType) {
            this.transferType = OptionalNullable.of(transferType);
            return this;
        }

        /**
         * UnSetter for transferType.
         * @return Builder
         */
        public Builder unsetTransferType() {
            transferType = null;
            return this;
        }

        /**
         * Setter for accountOwnershipType.
         * @param  accountOwnershipType  String value for accountOwnershipType.
         * @return Builder
         */
        public Builder accountOwnershipType(String accountOwnershipType) {
            this.accountOwnershipType = OptionalNullable.of(accountOwnershipType);
            return this;
        }

        /**
         * UnSetter for accountOwnershipType.
         * @return Builder
         */
        public Builder unsetAccountOwnershipType() {
            accountOwnershipType = null;
            return this;
        }

        /**
         * Setter for fingerprint.
         * @param  fingerprint  String value for fingerprint.
         * @return Builder
         */
        public Builder fingerprint(String fingerprint) {
            this.fingerprint = OptionalNullable.of(fingerprint);
            return this;
        }

        /**
         * UnSetter for fingerprint.
         * @return Builder
         */
        public Builder unsetFingerprint() {
            fingerprint = null;
            return this;
        }

        /**
         * Setter for country.
         * @param  country  String value for country.
         * @return Builder
         */
        public Builder country(String country) {
            this.country = OptionalNullable.of(country);
            return this;
        }

        /**
         * UnSetter for country.
         * @return Builder
         */
        public Builder unsetCountry() {
            country = null;
            return this;
        }

        /**
         * Setter for statementDescription.
         * @param  statementDescription  String value for statementDescription.
         * @return Builder
         */
        public Builder statementDescription(String statementDescription) {
            this.statementDescription = OptionalNullable.of(statementDescription);
            return this;
        }

        /**
         * UnSetter for statementDescription.
         * @return Builder
         */
        public Builder unsetStatementDescription() {
            statementDescription = null;
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
            this.errors = OptionalNullable.of(errors);
            return this;
        }

        /**
         * UnSetter for errors.
         * @return Builder
         */
        public Builder unsetErrors() {
            errors = null;
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

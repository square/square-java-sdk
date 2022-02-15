
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BankAccount type.
 */
public class BankAccount {
    private final String id;
    private final String accountNumberSuffix;
    private final String country;
    private final String currency;
    private final String accountType;
    private final String holderName;
    private final String primaryBankIdentificationNumber;
    private final String secondaryBankIdentificationNumber;
    private final String debitMandateReferenceId;
    private final String referenceId;
    private final String locationId;
    private final String status;
    private final boolean creditable;
    private final boolean debitable;
    private final String fingerprint;
    private final Integer version;
    private final String bankName;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  accountNumberSuffix  String value for accountNumberSuffix.
     * @param  country  String value for country.
     * @param  currency  String value for currency.
     * @param  accountType  String value for accountType.
     * @param  holderName  String value for holderName.
     * @param  primaryBankIdentificationNumber  String value for primaryBankIdentificationNumber.
     * @param  status  String value for status.
     * @param  creditable  boolean value for creditable.
     * @param  debitable  boolean value for debitable.
     * @param  secondaryBankIdentificationNumber  String value for
     *         secondaryBankIdentificationNumber.
     * @param  debitMandateReferenceId  String value for debitMandateReferenceId.
     * @param  referenceId  String value for referenceId.
     * @param  locationId  String value for locationId.
     * @param  fingerprint  String value for fingerprint.
     * @param  version  Integer value for version.
     * @param  bankName  String value for bankName.
     */
    @JsonCreator
    public BankAccount(
            @JsonProperty("id") String id,
            @JsonProperty("account_number_suffix") String accountNumberSuffix,
            @JsonProperty("country") String country,
            @JsonProperty("currency") String currency,
            @JsonProperty("account_type") String accountType,
            @JsonProperty("holder_name") String holderName,
            @JsonProperty("primary_bank_identification_number") String primaryBankIdentificationNumber,
            @JsonProperty("status") String status,
            @JsonProperty("creditable") boolean creditable,
            @JsonProperty("debitable") boolean debitable,
            @JsonProperty("secondary_bank_identification_number") String secondaryBankIdentificationNumber,
            @JsonProperty("debit_mandate_reference_id") String debitMandateReferenceId,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("fingerprint") String fingerprint,
            @JsonProperty("version") Integer version,
            @JsonProperty("bank_name") String bankName) {
        this.id = id;
        this.accountNumberSuffix = accountNumberSuffix;
        this.country = country;
        this.currency = currency;
        this.accountType = accountType;
        this.holderName = holderName;
        this.primaryBankIdentificationNumber = primaryBankIdentificationNumber;
        this.secondaryBankIdentificationNumber = secondaryBankIdentificationNumber;
        this.debitMandateReferenceId = debitMandateReferenceId;
        this.referenceId = referenceId;
        this.locationId = locationId;
        this.status = status;
        this.creditable = creditable;
        this.debitable = debitable;
        this.fingerprint = fingerprint;
        this.version = version;
        this.bankName = bankName;
    }

    /**
     * Getter for Id.
     * The unique, Square-issued identifier for the bank account.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for AccountNumberSuffix.
     * The last few digits of the account number.
     * @return Returns the String
     */
    @JsonGetter("account_number_suffix")
    public String getAccountNumberSuffix() {
        return accountNumberSuffix;
    }

    /**
     * Getter for Country.
     * Indicates the country associated with another entity, such as a business. Values are in [ISO
     * 3166-1-alpha-2 format](http://www.iso.org/iso/home/standards/country_codes.htm).
     * @return Returns the String
     */
    @JsonGetter("country")
    public String getCountry() {
        return country;
    }

    /**
     * Getter for Currency.
     * Indicates the associated currency for an amount of money. Values correspond to [ISO
     * 4217](https://wikipedia.org/wiki/ISO_4217).
     * @return Returns the String
     */
    @JsonGetter("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * Getter for AccountType.
     * Indicates the financial purpose of the bank account.
     * @return Returns the String
     */
    @JsonGetter("account_type")
    public String getAccountType() {
        return accountType;
    }

    /**
     * Getter for HolderName.
     * Name of the account holder. This name must match the name on the targeted bank account
     * record.
     * @return Returns the String
     */
    @JsonGetter("holder_name")
    public String getHolderName() {
        return holderName;
    }

    /**
     * Getter for PrimaryBankIdentificationNumber.
     * Primary identifier for the bank. For more information, see [Bank Accounts
     * API](https://developer.squareup.com/docs/bank-accounts-api).
     * @return Returns the String
     */
    @JsonGetter("primary_bank_identification_number")
    public String getPrimaryBankIdentificationNumber() {
        return primaryBankIdentificationNumber;
    }

    /**
     * Getter for SecondaryBankIdentificationNumber.
     * Secondary identifier for the bank. For more information, see [Bank Accounts
     * API](https://developer.squareup.com/docs/bank-accounts-api).
     * @return Returns the String
     */
    @JsonGetter("secondary_bank_identification_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSecondaryBankIdentificationNumber() {
        return secondaryBankIdentificationNumber;
    }

    /**
     * Getter for DebitMandateReferenceId.
     * Reference identifier that will be displayed to UK bank account owners when collecting direct
     * debit authorization. Only required for UK bank accounts.
     * @return Returns the String
     */
    @JsonGetter("debit_mandate_reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDebitMandateReferenceId() {
        return debitMandateReferenceId;
    }

    /**
     * Getter for ReferenceId.
     * Client-provided identifier for linking the banking account to an entity in a third-party
     * system (for example, a bank account number or a user identifier).
     * @return Returns the String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Getter for LocationId.
     * The location to which the bank account belongs.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for Status.
     * Indicates the current verification status of a `BankAccount` object.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Getter for Creditable.
     * Indicates whether it is possible for Square to send money to this bank account.
     * @return Returns the boolean
     */
    @JsonGetter("creditable")
    public boolean getCreditable() {
        return creditable;
    }

    /**
     * Getter for Debitable.
     * Indicates whether it is possible for Square to take money from this bank account.
     * @return Returns the boolean
     */
    @JsonGetter("debitable")
    public boolean getDebitable() {
        return debitable;
    }

    /**
     * Getter for Fingerprint.
     * A Square-assigned, unique identifier for the bank account based on the account information.
     * The account fingerprint can be used to compare account entries and determine if the they
     * represent the same real-world bank account.
     * @return Returns the String
     */
    @JsonGetter("fingerprint")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFingerprint() {
        return fingerprint;
    }

    /**
     * Getter for Version.
     * The current version of the `BankAccount`.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Getter for BankName.
     * Read only. Name of actual financial institution. For example "Bank of America".
     * @return Returns the String
     */
    @JsonGetter("bank_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBankName() {
        return bankName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumberSuffix, country, currency, accountType, holderName,
                primaryBankIdentificationNumber, secondaryBankIdentificationNumber,
                debitMandateReferenceId, referenceId, locationId, status, creditable, debitable,
                fingerprint, version, bankName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BankAccount)) {
            return false;
        }
        BankAccount other = (BankAccount) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(accountNumberSuffix, other.accountNumberSuffix)
            && Objects.equals(country, other.country)
            && Objects.equals(currency, other.currency)
            && Objects.equals(accountType, other.accountType)
            && Objects.equals(holderName, other.holderName)
            && Objects.equals(primaryBankIdentificationNumber,
                    other.primaryBankIdentificationNumber)
            && Objects.equals(secondaryBankIdentificationNumber,
                    other.secondaryBankIdentificationNumber)
            && Objects.equals(debitMandateReferenceId, other.debitMandateReferenceId)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(status, other.status)
            && Objects.equals(creditable, other.creditable)
            && Objects.equals(debitable, other.debitable)
            && Objects.equals(fingerprint, other.fingerprint)
            && Objects.equals(version, other.version)
            && Objects.equals(bankName, other.bankName);
    }

    /**
     * Converts this BankAccount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BankAccount [" + "id=" + id + ", accountNumberSuffix=" + accountNumberSuffix
                + ", country=" + country + ", currency=" + currency + ", accountType=" + accountType
                + ", holderName=" + holderName + ", primaryBankIdentificationNumber="
                + primaryBankIdentificationNumber + ", status=" + status + ", creditable="
                + creditable + ", debitable=" + debitable + ", secondaryBankIdentificationNumber="
                + secondaryBankIdentificationNumber + ", debitMandateReferenceId="
                + debitMandateReferenceId + ", referenceId=" + referenceId + ", locationId="
                + locationId + ", fingerprint=" + fingerprint + ", version=" + version
                + ", bankName=" + bankName + "]";
    }

    /**
     * Builds a new {@link BankAccount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BankAccount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, accountNumberSuffix, country, currency, accountType,
                holderName, primaryBankIdentificationNumber, status, creditable, debitable)
                .secondaryBankIdentificationNumber(getSecondaryBankIdentificationNumber())
                .debitMandateReferenceId(getDebitMandateReferenceId())
                .referenceId(getReferenceId())
                .locationId(getLocationId())
                .fingerprint(getFingerprint())
                .version(getVersion())
                .bankName(getBankName());
        return builder;
    }

    /**
     * Class to build instances of {@link BankAccount}.
     */
    public static class Builder {
        private String id;
        private String accountNumberSuffix;
        private String country;
        private String currency;
        private String accountType;
        private String holderName;
        private String primaryBankIdentificationNumber;
        private String status;
        private boolean creditable;
        private boolean debitable;
        private String secondaryBankIdentificationNumber;
        private String debitMandateReferenceId;
        private String referenceId;
        private String locationId;
        private String fingerprint;
        private Integer version;
        private String bankName;

        /**
         * Initialization constructor.
         * @param  id  String value for id.
         * @param  accountNumberSuffix  String value for accountNumberSuffix.
         * @param  country  String value for country.
         * @param  currency  String value for currency.
         * @param  accountType  String value for accountType.
         * @param  holderName  String value for holderName.
         * @param  primaryBankIdentificationNumber  String value for
         *         primaryBankIdentificationNumber.
         * @param  status  String value for status.
         * @param  creditable  boolean value for creditable.
         * @param  debitable  boolean value for debitable.
         */
        public Builder(String id, String accountNumberSuffix, String country, String currency,
                String accountType, String holderName, String primaryBankIdentificationNumber,
                String status, boolean creditable, boolean debitable) {
            this.id = id;
            this.accountNumberSuffix = accountNumberSuffix;
            this.country = country;
            this.currency = currency;
            this.accountType = accountType;
            this.holderName = holderName;
            this.primaryBankIdentificationNumber = primaryBankIdentificationNumber;
            this.status = status;
            this.creditable = creditable;
            this.debitable = debitable;
        }

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
         * Setter for accountNumberSuffix.
         * @param  accountNumberSuffix  String value for accountNumberSuffix.
         * @return Builder
         */
        public Builder accountNumberSuffix(String accountNumberSuffix) {
            this.accountNumberSuffix = accountNumberSuffix;
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
         * Setter for currency.
         * @param  currency  String value for currency.
         * @return Builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Setter for accountType.
         * @param  accountType  String value for accountType.
         * @return Builder
         */
        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        /**
         * Setter for holderName.
         * @param  holderName  String value for holderName.
         * @return Builder
         */
        public Builder holderName(String holderName) {
            this.holderName = holderName;
            return this;
        }

        /**
         * Setter for primaryBankIdentificationNumber.
         * @param  primaryBankIdentificationNumber  String value for
         *         primaryBankIdentificationNumber.
         * @return Builder
         */
        public Builder primaryBankIdentificationNumber(String primaryBankIdentificationNumber) {
            this.primaryBankIdentificationNumber = primaryBankIdentificationNumber;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for creditable.
         * @param  creditable  boolean value for creditable.
         * @return Builder
         */
        public Builder creditable(boolean creditable) {
            this.creditable = creditable;
            return this;
        }

        /**
         * Setter for debitable.
         * @param  debitable  boolean value for debitable.
         * @return Builder
         */
        public Builder debitable(boolean debitable) {
            this.debitable = debitable;
            return this;
        }

        /**
         * Setter for secondaryBankIdentificationNumber.
         * @param  secondaryBankIdentificationNumber  String value for
         *         secondaryBankIdentificationNumber.
         * @return Builder
         */
        public Builder secondaryBankIdentificationNumber(
                String secondaryBankIdentificationNumber) {
            this.secondaryBankIdentificationNumber = secondaryBankIdentificationNumber;
            return this;
        }

        /**
         * Setter for debitMandateReferenceId.
         * @param  debitMandateReferenceId  String value for debitMandateReferenceId.
         * @return Builder
         */
        public Builder debitMandateReferenceId(String debitMandateReferenceId) {
            this.debitMandateReferenceId = debitMandateReferenceId;
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
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
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
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

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
         * Builds a new {@link BankAccount} object using the set fields.
         * @return {@link BankAccount}
         */
        public BankAccount build() {
            return new BankAccount(id, accountNumberSuffix, country, currency, accountType,
                    holderName, primaryBankIdentificationNumber, status, creditable, debitable,
                    secondaryBankIdentificationNumber, debitMandateReferenceId, referenceId,
                    locationId, fingerprint, version, bankName);
        }
    }
}

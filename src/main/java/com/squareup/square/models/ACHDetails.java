
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ACHDetails type.
 */
public class ACHDetails {
    private final String routingNumber;
    private final String accountNumberSuffix;
    private final String accountType;

    /**
     * Initialization constructor.
     * @param  routingNumber  String value for routingNumber.
     * @param  accountNumberSuffix  String value for accountNumberSuffix.
     * @param  accountType  String value for accountType.
     */
    @JsonCreator
    public ACHDetails(
            @JsonProperty("routing_number") String routingNumber,
            @JsonProperty("account_number_suffix") String accountNumberSuffix,
            @JsonProperty("account_type") String accountType) {
        this.routingNumber = routingNumber;
        this.accountNumberSuffix = accountNumberSuffix;
        this.accountType = accountType;
    }

    /**
     * Getter for RoutingNumber.
     * The routing number for the bank account.
     * @return Returns the String
     */
    @JsonGetter("routing_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRoutingNumber() {
        return routingNumber;
    }

    /**
     * Getter for AccountNumberSuffix.
     * The last few digits of the bank account number.
     * @return Returns the String
     */
    @JsonGetter("account_number_suffix")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAccountNumberSuffix() {
        return accountNumberSuffix;
    }

    /**
     * Getter for AccountType.
     * The type of the bank account performing the transfer. The account type can be `CHECKING`,
     * `SAVINGS`, or `UNKNOWN`.
     * @return Returns the String
     */
    @JsonGetter("account_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAccountType() {
        return accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(routingNumber, accountNumberSuffix, accountType);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ACHDetails)) {
            return false;
        }
        ACHDetails other = (ACHDetails) obj;
        return Objects.equals(routingNumber, other.routingNumber)
            && Objects.equals(accountNumberSuffix, other.accountNumberSuffix)
            && Objects.equals(accountType, other.accountType);
    }

    /**
     * Converts this ACHDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ACHDetails [" + "routingNumber=" + routingNumber + ", accountNumberSuffix="
                + accountNumberSuffix + ", accountType=" + accountType + "]";
    }

    /**
     * Builds a new {@link ACHDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ACHDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .routingNumber(getRoutingNumber())
                .accountNumberSuffix(getAccountNumberSuffix())
                .accountType(getAccountType());
        return builder;
    }

    /**
     * Class to build instances of {@link ACHDetails}.
     */
    public static class Builder {
        private String routingNumber;
        private String accountNumberSuffix;
        private String accountType;



        /**
         * Setter for routingNumber.
         * @param  routingNumber  String value for routingNumber.
         * @return Builder
         */
        public Builder routingNumber(String routingNumber) {
            this.routingNumber = routingNumber;
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
         * Setter for accountType.
         * @param  accountType  String value for accountType.
         * @return Builder
         */
        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        /**
         * Builds a new {@link ACHDetails} object using the set fields.
         * @return {@link ACHDetails}
         */
        public ACHDetails build() {
            return new ACHDetails(routingNumber, accountNumberSuffix, accountType);
        }
    }
}

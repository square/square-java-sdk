package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BalancePaymentDetails type.
 */
public class BalancePaymentDetails {

    /**
     * Initialization constructor.
     * @param accountId
     * @param status
     */
    @JsonCreator
    public BalancePaymentDetails(
            @JsonProperty("account_id") String accountId,
            @JsonProperty("status") String status) {
        this.accountId = accountId;
        this.status = status;
    }

    private final String accountId;
    private final String status;
    /**
     * Getter for AccountId.
     * ID for the account used to fund the payment.
     */
    @JsonGetter("account_id")
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Getter for Status.
     * The balance payment’s current state. Can be `COMPLETED` or `FAILED`.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(accountId, status);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BalancePaymentDetails)) {
            return false;
        }
        BalancePaymentDetails balancePaymentDetails = (BalancePaymentDetails) obj;
        return Objects.equals(accountId, balancePaymentDetails.accountId) &&
            Objects.equals(status, balancePaymentDetails.status);
    }

    /**
     * Builds a new {@link BalancePaymentDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BalancePaymentDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .accountId(getAccountId())
            .status(getStatus());
            return builder;
    }

    /**
     * Class to build instances of {@link BalancePaymentDetails}
     */
    public static class Builder {
        private String accountId;
        private String status;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for accountId
         * @param accountId
         * @return Builder
         */
        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link BalancePaymentDetails} object using the set fields.
         * @return {@link BalancePaymentDetails}
         */
        public BalancePaymentDetails build() {
            return new BalancePaymentDetails(accountId,
                status);
        }
    }
}

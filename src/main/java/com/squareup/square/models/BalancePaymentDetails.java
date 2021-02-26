
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BalancePaymentDetails type.
 */
public class BalancePaymentDetails {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String accountId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;

    /**
     * Initialization constructor.
     * @param  accountId  String value for accountId.
     * @param  status  String value for status.
     */
    @JsonCreator
    public BalancePaymentDetails(
            @JsonProperty("account_id") String accountId,
            @JsonProperty("status") String status) {
        this.accountId = accountId;
        this.status = status;
    }

    /**
     * Getter for AccountId.
     * The ID of the account used to fund the payment.
     * @return Returns the String
     */
    @JsonGetter("account_id")
    public String getAccountId() {
        return accountId;
    }

    /**
     * Getter for Status.
     * The balance payment’s current state. The state can be COMPLETED or FAILED.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BalancePaymentDetails)) {
            return false;
        }
        BalancePaymentDetails other = (BalancePaymentDetails) obj;
        return Objects.equals(accountId, other.accountId)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this BalancePaymentDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BalancePaymentDetails [" + "accountId=" + accountId + ", status=" + status + "]";
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
     * Class to build instances of {@link BalancePaymentDetails}.
     */
    public static class Builder {
        private String accountId;
        private String status;



        /**
         * Setter for accountId.
         * @param  accountId  String value for accountId.
         * @return Builder
         */
        public Builder accountId(String accountId) {
            this.accountId = accountId;
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
         * Builds a new {@link BalancePaymentDetails} object using the set fields.
         * @return {@link BalancePaymentDetails}
         */
        public BalancePaymentDetails build() {
            return new BalancePaymentDetails(accountId, status);
        }
    }
}

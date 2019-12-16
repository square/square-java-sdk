package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class BalancePaymentDetails {

    @JsonCreator
    public BalancePaymentDetails(
            @JsonProperty("account_id") String accountId,
            @JsonProperty("status") String status) {
        this.accountId = accountId;
        this.status = status;
    }

    private final String accountId;
    private final String status;

    @Override
    public int hashCode() {
        return Objects.hash(accountId, status);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BalancePaymentDetails)) {
            return false;
        }
        BalancePaymentDetails balancePaymentDetails = (BalancePaymentDetails) o;
        return Objects.equals(accountId, balancePaymentDetails.accountId) &&
            Objects.equals(status, balancePaymentDetails.status);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .accountId(getAccountId())
            .status(getStatus());
            return builder;
    }

    public static class Builder {
        private String accountId;
        private String status;

        public Builder() { }

        public Builder accountId(String value) {
            accountId = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }

        public BalancePaymentDetails build() {
            return new BalancePaymentDetails(accountId,
                status);
        }
    }
}

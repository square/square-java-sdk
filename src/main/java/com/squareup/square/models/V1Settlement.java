package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1Settlement type.
 */
public class V1Settlement {

    /**
     * Initialization constructor.
     * @param id
     * @param status
     * @param totalMoney
     * @param initiatedAt
     * @param bankAccountId
     * @param entries
     */
    @JsonCreator
    public V1Settlement(
            @JsonProperty("id") String id,
            @JsonProperty("status") String status,
            @JsonProperty("total_money") V1Money totalMoney,
            @JsonProperty("initiated_at") String initiatedAt,
            @JsonProperty("bank_account_id") String bankAccountId,
            @JsonProperty("entries") List<V1SettlementEntry> entries) {
        this.id = id;
        this.status = status;
        this.totalMoney = totalMoney;
        this.initiatedAt = initiatedAt;
        this.bankAccountId = bankAccountId;
        this.entries = entries;
    }

    private HttpContext httpContext;
    private final String id;
    private final String status;
    private final V1Money totalMoney;
    private final String initiatedAt;
    private final String bankAccountId;
    private final List<V1SettlementEntry> entries;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The settlement's unique identifier.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Status.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for TotalMoney.
     */
    @JsonGetter("total_money")
    public V1Money getTotalMoney() {
        return this.totalMoney;
    }

    /**
     * Getter for InitiatedAt.
     * The time when the settlement was submitted for deposit or withdrawal, in ISO 8601 format.
     */
    @JsonGetter("initiated_at")
    public String getInitiatedAt() {
        return this.initiatedAt;
    }

    /**
     * Getter for BankAccountId.
     * The Square-issued unique identifier for the bank account associated with the settlement.
     */
    @JsonGetter("bank_account_id")
    public String getBankAccountId() {
        return this.bankAccountId;
    }

    /**
     * Getter for Entries.
     * The entries included in this settlement.
     */
    @JsonGetter("entries")
    public List<V1SettlementEntry> getEntries() {
        return this.entries;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, status, totalMoney, initiatedAt, bankAccountId, entries);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Settlement)) {
            return false;
        }
        V1Settlement v1Settlement = (V1Settlement) obj;
        return Objects.equals(id, v1Settlement.id) &&
            Objects.equals(status, v1Settlement.status) &&
            Objects.equals(totalMoney, v1Settlement.totalMoney) &&
            Objects.equals(initiatedAt, v1Settlement.initiatedAt) &&
            Objects.equals(bankAccountId, v1Settlement.bankAccountId) &&
            Objects.equals(entries, v1Settlement.entries);
    }

    /**
     * Builds a new {@link V1Settlement.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Settlement.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .status(getStatus())
            .totalMoney(getTotalMoney())
            .initiatedAt(getInitiatedAt())
            .bankAccountId(getBankAccountId())
            .entries(getEntries());
            return builder;
    }

    /**
     * Class to build instances of {@link V1Settlement}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String status;
        private V1Money totalMoney;
        private String initiatedAt;
        private String bankAccountId;
        private List<V1SettlementEntry> entries;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for totalMoney
         * @param totalMoney
         * @return Builder
         */
        public Builder totalMoney(V1Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }
        /**
         * Setter for initiatedAt
         * @param initiatedAt
         * @return Builder
         */
        public Builder initiatedAt(String initiatedAt) {
            this.initiatedAt = initiatedAt;
            return this;
        }
        /**
         * Setter for bankAccountId
         * @param bankAccountId
         * @return Builder
         */
        public Builder bankAccountId(String bankAccountId) {
            this.bankAccountId = bankAccountId;
            return this;
        }
        /**
         * Setter for entries
         * @param entries
         * @return Builder
         */
        public Builder entries(List<V1SettlementEntry> entries) {
            this.entries = entries;
            return this;
        }

        /**
         * Builds a new {@link V1Settlement} object using the set fields.
         * @return {@link V1Settlement}
         */
        public V1Settlement build() {
            V1Settlement model = new V1Settlement(id,
                status,
                totalMoney,
                initiatedAt,
                bankAccountId,
                entries);
            model.httpContext = httpContext;
            return model;
        }
    }
}

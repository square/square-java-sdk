package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Settlement {

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

    @Override
    public int hashCode() {
        return Objects.hash(id, status, totalMoney, initiatedAt, bankAccountId, entries);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Settlement)) {
            return false;
        }
        V1Settlement v1Settlement = (V1Settlement) o;
        return Objects.equals(id, v1Settlement.id) &&
            Objects.equals(status, v1Settlement.status) &&
            Objects.equals(totalMoney, v1Settlement.totalMoney) &&
            Objects.equals(initiatedAt, v1Settlement.initiatedAt) &&
            Objects.equals(bankAccountId, v1Settlement.bankAccountId) &&
            Objects.equals(entries, v1Settlement.entries);
    }


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

    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String status;
        private V1Money totalMoney;
        private String initiatedAt;
        private String bankAccountId;
        private List<V1SettlementEntry> entries;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder totalMoney(V1Money value) {
            totalMoney = value;
            return this;
        }
        public Builder initiatedAt(String value) {
            initiatedAt = value;
            return this;
        }
        public Builder bankAccountId(String value) {
            bankAccountId = value;
            return this;
        }
        public Builder entries(List<V1SettlementEntry> value) {
            entries = value;
            return this;
        }

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

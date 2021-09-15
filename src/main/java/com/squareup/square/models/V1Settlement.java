
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1Settlement type.
 */
public class V1Settlement {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final V1Money totalMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String initiatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String bankAccountId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<V1SettlementEntry> entries;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  status  String value for status.
     * @param  totalMoney  V1Money value for totalMoney.
     * @param  initiatedAt  String value for initiatedAt.
     * @param  bankAccountId  String value for bankAccountId.
     * @param  entries  List of V1SettlementEntry value for entries.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The settlement's unique identifier.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Status.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    /**
     * Getter for TotalMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("total_money")
    public V1Money getTotalMoney() {
        return totalMoney;
    }

    /**
     * Getter for InitiatedAt.
     * The time when the settlement was submitted for deposit or withdrawal, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("initiated_at")
    public String getInitiatedAt() {
        return initiatedAt;
    }

    /**
     * Getter for BankAccountId.
     * The Square-issued unique identifier for the bank account associated with the settlement.
     * @return Returns the String
     */
    @JsonGetter("bank_account_id")
    public String getBankAccountId() {
        return bankAccountId;
    }

    /**
     * Getter for Entries.
     * The entries included in this settlement.
     * @return Returns the List of V1SettlementEntry
     */
    @JsonGetter("entries")
    public List<V1SettlementEntry> getEntries() {
        return entries;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, totalMoney, initiatedAt, bankAccountId, entries);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Settlement)) {
            return false;
        }
        V1Settlement other = (V1Settlement) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(status, other.status)
            && Objects.equals(totalMoney, other.totalMoney)
            && Objects.equals(initiatedAt, other.initiatedAt)
            && Objects.equals(bankAccountId, other.bankAccountId)
            && Objects.equals(entries, other.entries);
    }

    /**
     * Converts this V1Settlement into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1Settlement [" + "id=" + id + ", status=" + status + ", totalMoney=" + totalMoney
                + ", initiatedAt=" + initiatedAt + ", bankAccountId=" + bankAccountId + ", entries="
                + entries + "]";
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
     * Class to build instances of {@link V1Settlement}.
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
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
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
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for totalMoney.
         * @param  totalMoney  V1Money value for totalMoney.
         * @return Builder
         */
        public Builder totalMoney(V1Money totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        /**
         * Setter for initiatedAt.
         * @param  initiatedAt  String value for initiatedAt.
         * @return Builder
         */
        public Builder initiatedAt(String initiatedAt) {
            this.initiatedAt = initiatedAt;
            return this;
        }

        /**
         * Setter for bankAccountId.
         * @param  bankAccountId  String value for bankAccountId.
         * @return Builder
         */
        public Builder bankAccountId(String bankAccountId) {
            this.bankAccountId = bankAccountId;
            return this;
        }

        /**
         * Setter for entries.
         * @param  entries  List of V1SettlementEntry value for entries.
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
            V1Settlement model =
                    new V1Settlement(id, status, totalMoney, initiatedAt, bankAccountId, entries);
            model.httpContext = httpContext;
            return model;
        }
    }
}

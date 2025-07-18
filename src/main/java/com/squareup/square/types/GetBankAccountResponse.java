/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetBankAccountResponse.Builder.class)
public final class GetBankAccountResponse {
    private final Optional<List<Error>> errors;

    private final Optional<BankAccount> bankAccount;

    private final Map<String, Object> additionalProperties;

    private GetBankAccountResponse(
            Optional<List<Error>> errors, Optional<BankAccount> bankAccount, Map<String, Object> additionalProperties) {
        this.errors = errors;
        this.bankAccount = bankAccount;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Information on errors encountered during the request.
     */
    @JsonProperty("errors")
    public Optional<List<Error>> getErrors() {
        return errors;
    }

    /**
     * @return The requested <code>BankAccount</code> object.
     */
    @JsonProperty("bank_account")
    public Optional<BankAccount> getBankAccount() {
        return bankAccount;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetBankAccountResponse && equalTo((GetBankAccountResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetBankAccountResponse other) {
        return errors.equals(other.errors) && bankAccount.equals(other.bankAccount);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.errors, this.bankAccount);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<Error>> errors = Optional.empty();

        private Optional<BankAccount> bankAccount = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(GetBankAccountResponse other) {
            errors(other.getErrors());
            bankAccount(other.getBankAccount());
            return this;
        }

        /**
         * <p>Information on errors encountered during the request.</p>
         */
        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(Optional<List<Error>> errors) {
            this.errors = errors;
            return this;
        }

        public Builder errors(List<Error> errors) {
            this.errors = Optional.ofNullable(errors);
            return this;
        }

        /**
         * <p>The requested <code>BankAccount</code> object.</p>
         */
        @JsonSetter(value = "bank_account", nulls = Nulls.SKIP)
        public Builder bankAccount(Optional<BankAccount> bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public Builder bankAccount(BankAccount bankAccount) {
            this.bankAccount = Optional.ofNullable(bankAccount);
            return this;
        }

        public GetBankAccountResponse build() {
            return new GetBankAccountResponse(errors, bankAccount, additionalProperties);
        }
    }
}

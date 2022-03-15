
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
 * This is a model class for GetBankAccountResponse type.
 */
public class GetBankAccountResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final BankAccount bankAccount;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  bankAccount  BankAccount value for bankAccount.
     */
    @JsonCreator
    public GetBankAccountResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("bank_account") BankAccount bankAccount) {
        this.errors = errors;
        this.bankAccount = bankAccount;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for BankAccount.
     * Represents a bank account. For more information about linking a bank account to a Square
     * account, see [Bank Accounts API](https://developer.squareup.com/docs/bank-accounts-api).
     * @return Returns the BankAccount
     */
    @JsonGetter("bank_account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public BankAccount getBankAccount() {
        return bankAccount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, bankAccount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetBankAccountResponse)) {
            return false;
        }
        GetBankAccountResponse other = (GetBankAccountResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(bankAccount, other.bankAccount);
    }

    /**
     * Converts this GetBankAccountResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GetBankAccountResponse [" + "errors=" + errors + ", bankAccount=" + bankAccount
                + "]";
    }

    /**
     * Builds a new {@link GetBankAccountResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GetBankAccountResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .bankAccount(getBankAccount());
        return builder;
    }

    /**
     * Class to build instances of {@link GetBankAccountResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private BankAccount bankAccount;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for bankAccount.
         * @param  bankAccount  BankAccount value for bankAccount.
         * @return Builder
         */
        public Builder bankAccount(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        /**
         * Builds a new {@link GetBankAccountResponse} object using the set fields.
         * @return {@link GetBankAccountResponse}
         */
        public GetBankAccountResponse build() {
            GetBankAccountResponse model =
                    new GetBankAccountResponse(errors, bankAccount);
            model.httpContext = httpContext;
            return model;
        }
    }
}

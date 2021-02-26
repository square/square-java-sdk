
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListBankAccountsResponse type.
 */
public class ListBankAccountsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<BankAccount> bankAccounts;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  bankAccounts  List of BankAccount value for bankAccounts.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListBankAccountsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("bank_accounts") List<BankAccount> bankAccounts,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.bankAccounts = bankAccounts;
        this.cursor = cursor;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for BankAccounts.
     * List of BankAccounts associated with this account.
     * @return Returns the List of BankAccount
     */
    @JsonGetter("bank_accounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can use in a subsequent request
     * to fetch next set of bank accounts. If empty, this is the final response. For more
     * information, see
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, bankAccounts, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListBankAccountsResponse)) {
            return false;
        }
        ListBankAccountsResponse other = (ListBankAccountsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(bankAccounts, other.bankAccounts)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListBankAccountsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListBankAccountsResponse [" + "errors=" + errors + ", bankAccounts=" + bankAccounts
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListBankAccountsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBankAccountsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .bankAccounts(getBankAccounts())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListBankAccountsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<BankAccount> bankAccounts;
        private String cursor;



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
         * Setter for bankAccounts.
         * @param  bankAccounts  List of BankAccount value for bankAccounts.
         * @return Builder
         */
        public Builder bankAccounts(List<BankAccount> bankAccounts) {
            this.bankAccounts = bankAccounts;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListBankAccountsResponse} object using the set fields.
         * @return {@link ListBankAccountsResponse}
         */
        public ListBankAccountsResponse build() {
            ListBankAccountsResponse model =
                    new ListBankAccountsResponse(errors, bankAccounts, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

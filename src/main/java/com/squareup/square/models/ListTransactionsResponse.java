
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListTransactionsResponse type.
 */
public class ListTransactionsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Transaction> transactions;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  transactions  List of Transaction value for transactions.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListTransactionsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("transactions") List<Transaction> transactions,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.transactions = transactions;
        this.cursor = cursor;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Transactions.
     * An array of transactions that match your query.
     * @return Returns the List of Transaction
     */
    @JsonGetter("transactions")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor for retrieving the next set of results, if any remain. Provide this value
     * as the `cursor` parameter in a subsequent request to this endpoint. See [Paginating
     * results](#paginatingresults) for more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, transactions, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListTransactionsResponse)) {
            return false;
        }
        ListTransactionsResponse other = (ListTransactionsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(transactions, other.transactions)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListTransactionsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListTransactionsResponse [" + "errors=" + errors + ", transactions=" + transactions
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListTransactionsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListTransactionsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .transactions(getTransactions())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListTransactionsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Transaction> transactions;
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
         * Setter for transactions.
         * @param  transactions  List of Transaction value for transactions.
         * @return Builder
         */
        public Builder transactions(List<Transaction> transactions) {
            this.transactions = transactions;
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
         * Builds a new {@link ListTransactionsResponse} object using the set fields.
         * @return {@link ListTransactionsResponse}
         */
        public ListTransactionsResponse build() {
            ListTransactionsResponse model =
                    new ListTransactionsResponse(errors, transactions, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

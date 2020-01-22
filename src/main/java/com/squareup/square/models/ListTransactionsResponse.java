package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListTransactionsResponse type.
 */
public class ListTransactionsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param transactions
     * @param cursor
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

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Transaction> transactions;
    private final String cursor;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Transactions.
     * An array of transactions that match your query.
     */
    @JsonGetter("transactions")
    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor for retrieving the next set of results,
     * if any remain. Provide this value as the `cursor` parameter in a subsequent
     * request to this endpoint.
     * See [Paginating results](#paginatingresults) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, transactions, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListTransactionsResponse)) {
            return false;
        }
        ListTransactionsResponse listTransactionsResponse = (ListTransactionsResponse) obj;
        return Objects.equals(errors, listTransactionsResponse.errors) &&
            Objects.equals(transactions, listTransactionsResponse.transactions) &&
            Objects.equals(cursor, listTransactionsResponse.cursor);
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
     * Class to build instances of {@link ListTransactionsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Transaction> transactions;
        private String cursor;

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
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for transactions
         * @param transactions
         * @return Builder
         */
        public Builder transactions(List<Transaction> transactions) {
            this.transactions = transactions;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
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
            ListTransactionsResponse model = new ListTransactionsResponse(errors,
                transactions,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

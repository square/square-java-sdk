package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListTransactionsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, transactions, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListTransactionsResponse)) {
            return false;
        }
        ListTransactionsResponse listTransactionsResponse = (ListTransactionsResponse) o;
        return Objects.equals(errors, listTransactionsResponse.errors) &&
            Objects.equals(transactions, listTransactionsResponse.transactions) &&
            Objects.equals(cursor, listTransactionsResponse.cursor);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .transactions(getTransactions())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Transaction> transactions;
        private String cursor;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder transactions(List<Transaction> value) {
            transactions = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListTransactionsResponse build() {
            ListTransactionsResponse model = new ListTransactionsResponse(errors,
                transactions,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

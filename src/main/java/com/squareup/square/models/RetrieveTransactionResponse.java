package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveTransactionResponse {

    @JsonCreator
    public RetrieveTransactionResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("transaction") Transaction transaction) {
        this.errors = errors;
        this.transaction = transaction;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Transaction transaction;

    @Override
    public int hashCode() {
        return Objects.hash(errors, transaction);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveTransactionResponse)) {
            return false;
        }
        RetrieveTransactionResponse retrieveTransactionResponse = (RetrieveTransactionResponse) o;
        return Objects.equals(errors, retrieveTransactionResponse.errors) &&
            Objects.equals(transaction, retrieveTransactionResponse.transaction);
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
     * Getter for Transaction.
     * Represents a transaction processed with Square, either with the
     * Connect API or with Square Point of Sale.
     * The `tenders` field of this object lists all methods of payment used to pay in
     * the transaction.
     */
    @JsonGetter("transaction")
    public Transaction getTransaction() { 
        return this.transaction;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .transaction(getTransaction());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Transaction transaction;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder transaction(Transaction value) {
            transaction = value;
            return this;
        }

        public RetrieveTransactionResponse build() {
            RetrieveTransactionResponse model = new RetrieveTransactionResponse(errors,
                transaction);
            model.httpContext = httpContext;
            return model;
        }
    }
}

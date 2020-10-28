
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for RetrieveTransactionResponse type.
 */
public class RetrieveTransactionResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Transaction transaction;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param transaction Transaction value for transaction.
     */
    @JsonCreator
    public RetrieveTransactionResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("transaction") Transaction transaction) {
        this.errors = errors;
        this.transaction = transaction;
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
        return this.errors;
    }

    /**
     * Getter for Transaction.
     * Represents a transaction processed with Square, either with the Connect API or with Square
     * Point of Sale. The `tenders` field of this object lists all methods of payment used to pay in
     * the transaction.
     * @return Returns the Transaction
     */
    @JsonGetter("transaction")
    public Transaction getTransaction() {
        return this.transaction;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveTransactionResponse)) {
            return false;
        }
        RetrieveTransactionResponse other = (RetrieveTransactionResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(transaction, other.transaction);
    }

    /**
     * Builds a new {@link RetrieveTransactionResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveTransactionResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .transaction(getTransaction());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveTransactionResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Transaction transaction;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for transaction.
         * @param transaction Transaction value for transaction.
         * @return Builder
         */
        public Builder transaction(Transaction transaction) {
            this.transaction = transaction;
            return this;
        }

        /**
         * Builds a new {@link RetrieveTransactionResponse} object using the set fields.
         * @return {@link RetrieveTransactionResponse}
         */
        public RetrieveTransactionResponse build() {
            RetrieveTransactionResponse model =
                    new RetrieveTransactionResponse(errors,
                            transaction);
            model.httpContext = httpContext;
            return model;
        }
    }
}

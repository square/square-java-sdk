package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ChargeResponse type.
 */
public class ChargeResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param transaction
     */
    @JsonCreator
    public ChargeResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("transaction") Transaction transaction) {
        this.errors = errors;
        this.transaction = transaction;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Transaction transaction;

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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, transaction);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ChargeResponse)) {
            return false;
        }
        ChargeResponse chargeResponse = (ChargeResponse) obj;
        return Objects.equals(errors, chargeResponse.errors) &&
            Objects.equals(transaction, chargeResponse.transaction);
    }

    /**
     * Builds a new {@link ChargeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ChargeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .transaction(getTransaction());
            return builder;
    }

    /**
     * Class to build instances of {@link ChargeResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Transaction transaction;

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
         * Setter for transaction
         * @param transaction
         * @return Builder
         */
        public Builder transaction(Transaction transaction) {
            this.transaction = transaction;
            return this;
        }

        /**
         * Builds a new {@link ChargeResponse} object using the set fields.
         * @return {@link ChargeResponse}
         */
        public ChargeResponse build() {
            ChargeResponse model = new ChargeResponse(errors,
                transaction);
            model.httpContext = httpContext;
            return model;
        }
    }
}

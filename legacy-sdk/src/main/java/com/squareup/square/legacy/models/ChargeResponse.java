package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ChargeResponse type.
 */
public class ChargeResponse {
    private final List<Error> errors;
    private final Transaction transaction;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  transaction  Transaction value for transaction.
     */
    @JsonCreator
    public ChargeResponse(
            @JsonProperty("errors") List<Error> errors, @JsonProperty("transaction") Transaction transaction) {
        this.errors = errors;
        this.transaction = transaction;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Transaction.
     * Represents a transaction processed with Square, either with the Connect API or with Square
     * Point of Sale. The `tenders` field of this object lists all methods of payment used to pay in
     * the transaction.
     * @return Returns the Transaction
     */
    @JsonGetter("transaction")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Transaction getTransaction() {
        return transaction;
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
        if (!(obj instanceof ChargeResponse)) {
            return false;
        }
        ChargeResponse other = (ChargeResponse) obj;
        return Objects.equals(errors, other.errors) && Objects.equals(transaction, other.transaction);
    }

    /**
     * Converts this ChargeResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ChargeResponse [" + "errors=" + errors + ", transaction=" + transaction + "]";
    }

    /**
     * Builds a new {@link ChargeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ChargeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors()).transaction(getTransaction());
        return builder;
    }

    /**
     * Class to build instances of {@link ChargeResponse}.
     */
    public static class Builder {
        private List<Error> errors;
        private Transaction transaction;

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
         * Setter for transaction.
         * @param  transaction  Transaction value for transaction.
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
            return new ChargeResponse(errors, transaction);
        }
    }
}

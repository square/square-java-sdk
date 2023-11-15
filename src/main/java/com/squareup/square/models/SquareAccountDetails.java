
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SquareAccountDetails type.
 */
public class SquareAccountDetails {
    private final OptionalNullable<String> paymentSourceToken;
    private final OptionalNullable<List<Error>> errors;

    /**
     * Initialization constructor.
     * @param  paymentSourceToken  String value for paymentSourceToken.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public SquareAccountDetails(
            @JsonProperty("payment_source_token") String paymentSourceToken,
            @JsonProperty("errors") List<Error> errors) {
        this.paymentSourceToken = OptionalNullable.of(paymentSourceToken);
        this.errors = OptionalNullable.of(errors);
    }

    /**
     * Initialization constructor.
     * @param  paymentSourceToken  String value for paymentSourceToken.
     * @param  errors  List of Error value for errors.
     */

    protected SquareAccountDetails(OptionalNullable<String> paymentSourceToken,
            OptionalNullable<List<Error>> errors) {
        this.paymentSourceToken = paymentSourceToken;
        this.errors = errors;
    }

    /**
     * Internal Getter for PaymentSourceToken.
     * Unique identifier for the payment source used for this payment.
     * @return Returns the Internal String
     */
    @JsonGetter("payment_source_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPaymentSourceToken() {
        return this.paymentSourceToken;
    }

    /**
     * Getter for PaymentSourceToken.
     * Unique identifier for the payment source used for this payment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentSourceToken() {
        return OptionalNullable.getFrom(paymentSourceToken);
    }

    /**
     * Internal Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the Internal List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Error>> internalGetErrors() {
        return this.errors;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonIgnore
    public List<Error> getErrors() {
        return OptionalNullable.getFrom(errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentSourceToken, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SquareAccountDetails)) {
            return false;
        }
        SquareAccountDetails other = (SquareAccountDetails) obj;
        return Objects.equals(paymentSourceToken, other.paymentSourceToken)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this SquareAccountDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SquareAccountDetails [" + "paymentSourceToken=" + paymentSourceToken + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link SquareAccountDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SquareAccountDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.paymentSourceToken = internalGetPaymentSourceToken();
        builder.errors = internalGetErrors();
        return builder;
    }

    /**
     * Class to build instances of {@link SquareAccountDetails}.
     */
    public static class Builder {
        private OptionalNullable<String> paymentSourceToken;
        private OptionalNullable<List<Error>> errors;



        /**
         * Setter for paymentSourceToken.
         * @param  paymentSourceToken  String value for paymentSourceToken.
         * @return Builder
         */
        public Builder paymentSourceToken(String paymentSourceToken) {
            this.paymentSourceToken = OptionalNullable.of(paymentSourceToken);
            return this;
        }

        /**
         * UnSetter for paymentSourceToken.
         * @return Builder
         */
        public Builder unsetPaymentSourceToken() {
            paymentSourceToken = null;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = OptionalNullable.of(errors);
            return this;
        }

        /**
         * UnSetter for errors.
         * @return Builder
         */
        public Builder unsetErrors() {
            errors = null;
            return this;
        }

        /**
         * Builds a new {@link SquareAccountDetails} object using the set fields.
         * @return {@link SquareAccountDetails}
         */
        public SquareAccountDetails build() {
            return new SquareAccountDetails(paymentSourceToken, errors);
        }
    }
}

package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateRefundResponse type.
 */
public class CreateRefundResponse {
    private final List<Error> errors;
    private final Refund refund;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  refund  Refund value for refund.
     */
    @JsonCreator
    public CreateRefundResponse(@JsonProperty("errors") List<Error> errors, @JsonProperty("refund") Refund refund) {
        this.errors = errors;
        this.refund = refund;
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
     * Getter for Refund.
     * Represents a refund processed for a Square transaction.
     * @return Returns the Refund
     */
    @JsonGetter("refund")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Refund getRefund() {
        return refund;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, refund);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateRefundResponse)) {
            return false;
        }
        CreateRefundResponse other = (CreateRefundResponse) obj;
        return Objects.equals(errors, other.errors) && Objects.equals(refund, other.refund);
    }

    /**
     * Converts this CreateRefundResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateRefundResponse [" + "errors=" + errors + ", refund=" + refund + "]";
    }

    /**
     * Builds a new {@link CreateRefundResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateRefundResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors()).refund(getRefund());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateRefundResponse}.
     */
    public static class Builder {
        private List<Error> errors;
        private Refund refund;

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
         * Setter for refund.
         * @param  refund  Refund value for refund.
         * @return Builder
         */
        public Builder refund(Refund refund) {
            this.refund = refund;
            return this;
        }

        /**
         * Builds a new {@link CreateRefundResponse} object using the set fields.
         * @return {@link CreateRefundResponse}
         */
        public CreateRefundResponse build() {
            return new CreateRefundResponse(errors, refund);
        }
    }
}

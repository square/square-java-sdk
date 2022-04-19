
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateTerminalRefundRequest type.
 */
public class CreateTerminalRefundRequest {
    private final String idempotencyKey;
    private final TerminalRefund refund;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  refund  TerminalRefund value for refund.
     */
    @JsonCreator
    public CreateTerminalRefundRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("refund") TerminalRefund refund) {
        this.idempotencyKey = idempotencyKey;
        this.refund = refund;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateRefund` request. Keys can be any valid string but
     * must be unique for every `CreateRefund` request. See [Idempotency
     * keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Refund.
     * Represents a payment refund processed by the Square Terminal. Only supports Interac (Canadian
     * debit network) payment refunds.
     * @return Returns the TerminalRefund
     */
    @JsonGetter("refund")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TerminalRefund getRefund() {
        return refund;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, refund);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateTerminalRefundRequest)) {
            return false;
        }
        CreateTerminalRefundRequest other = (CreateTerminalRefundRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(refund, other.refund);
    }

    /**
     * Converts this CreateTerminalRefundRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateTerminalRefundRequest [" + "idempotencyKey=" + idempotencyKey + ", refund="
                + refund + "]";
    }

    /**
     * Builds a new {@link CreateTerminalRefundRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateTerminalRefundRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
                .refund(getRefund());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateTerminalRefundRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private TerminalRefund refund;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for refund.
         * @param  refund  TerminalRefund value for refund.
         * @return Builder
         */
        public Builder refund(TerminalRefund refund) {
            this.refund = refund;
            return this;
        }

        /**
         * Builds a new {@link CreateTerminalRefundRequest} object using the set fields.
         * @return {@link CreateTerminalRefundRequest}
         */
        public CreateTerminalRefundRequest build() {
            return new CreateTerminalRefundRequest(idempotencyKey, refund);
        }
    }
}

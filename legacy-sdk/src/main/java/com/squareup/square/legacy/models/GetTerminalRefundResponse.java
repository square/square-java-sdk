package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for GetTerminalRefundResponse type.
 */
public class GetTerminalRefundResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final TerminalRefund refund;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  refund  TerminalRefund value for refund.
     */
    @JsonCreator
    public GetTerminalRefundResponse(
            @JsonProperty("errors") List<Error> errors, @JsonProperty("refund") TerminalRefund refund) {
        this.errors = errors;
        this.refund = refund;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
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
        return Objects.hash(errors, refund);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTerminalRefundResponse)) {
            return false;
        }
        GetTerminalRefundResponse other = (GetTerminalRefundResponse) obj;
        return Objects.equals(errors, other.errors) && Objects.equals(refund, other.refund);
    }

    /**
     * Converts this GetTerminalRefundResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GetTerminalRefundResponse [" + "errors=" + errors + ", refund=" + refund + "]";
    }

    /**
     * Builds a new {@link GetTerminalRefundResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GetTerminalRefundResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors()).refund(getRefund());
        return builder;
    }

    /**
     * Class to build instances of {@link GetTerminalRefundResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private TerminalRefund refund;

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
         * Setter for refund.
         * @param  refund  TerminalRefund value for refund.
         * @return Builder
         */
        public Builder refund(TerminalRefund refund) {
            this.refund = refund;
            return this;
        }

        /**
         * Builds a new {@link GetTerminalRefundResponse} object using the set fields.
         * @return {@link GetTerminalRefundResponse}
         */
        public GetTerminalRefundResponse build() {
            GetTerminalRefundResponse model = new GetTerminalRefundResponse(errors, refund);
            model.httpContext = httpContext;
            return model;
        }
    }
}

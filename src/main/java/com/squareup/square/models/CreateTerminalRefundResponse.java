
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateTerminalRefundResponse type.
 */
public class CreateTerminalRefundResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final TerminalRefund refund;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  refund  TerminalRefund value for refund.
     */
    @JsonCreator
    public CreateTerminalRefundResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refund") TerminalRefund refund) {
        this.errors = errors;
        this.refund = refund;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Refund.
     * @return Returns the TerminalRefund
     */
    @JsonGetter("refund")
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
        if (!(obj instanceof CreateTerminalRefundResponse)) {
            return false;
        }
        CreateTerminalRefundResponse other = (CreateTerminalRefundResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(refund, other.refund);
    }

    /**
     * Converts this CreateTerminalRefundResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateTerminalRefundResponse [" + "errors=" + errors + ", refund=" + refund + "]";
    }

    /**
     * Builds a new {@link CreateTerminalRefundResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateTerminalRefundResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .refund(getRefund());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateTerminalRefundResponse}.
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
         * Builds a new {@link CreateTerminalRefundResponse} object using the set fields.
         * @return {@link CreateTerminalRefundResponse}
         */
        public CreateTerminalRefundResponse build() {
            CreateTerminalRefundResponse model =
                    new CreateTerminalRefundResponse(errors, refund);
            model.httpContext = httpContext;
            return model;
        }
    }
}

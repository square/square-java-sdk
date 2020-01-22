package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CreateRefundResponse type.
 */
public class CreateRefundResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param refund
     */
    @JsonCreator
    public CreateRefundResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("refund") Refund refund) {
        this.errors = errors;
        this.refund = refund;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Refund refund;

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
     * Getter for Refund.
     * Represents a refund processed for a Square transaction.
     */
    @JsonGetter("refund")
    public Refund getRefund() {
        return this.refund;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, refund);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateRefundResponse)) {
            return false;
        }
        CreateRefundResponse createRefundResponse = (CreateRefundResponse) obj;
        return Objects.equals(errors, createRefundResponse.errors) &&
            Objects.equals(refund, createRefundResponse.refund);
    }

    /**
     * Builds a new {@link CreateRefundResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateRefundResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .refund(getRefund());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateRefundResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Refund refund;

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
         * Setter for refund
         * @param refund
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
            CreateRefundResponse model = new CreateRefundResponse(errors,
                refund);
            model.httpContext = httpContext;
            return model;
        }
    }
}

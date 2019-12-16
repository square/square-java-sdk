package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreateRefundResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, refund);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateRefundResponse)) {
            return false;
        }
        CreateRefundResponse createRefundResponse = (CreateRefundResponse) o;
        return Objects.equals(errors, createRefundResponse.errors) &&
            Objects.equals(refund, createRefundResponse.refund);
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
     * Getter for Refund.
     * Represents a refund processed for a Square transaction.
     */
    @JsonGetter("refund")
    public Refund getRefund() { 
        return this.refund;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .refund(getRefund());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Refund refund;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder refund(Refund value) {
            refund = value;
            return this;
        }

        public CreateRefundResponse build() {
            CreateRefundResponse model = new CreateRefundResponse(errors,
                refund);
            model.httpContext = httpContext;
            return model;
        }
    }
}

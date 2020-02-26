package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveDisputeResponse type.
 */
public class RetrieveDisputeResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param dispute
     */
    @JsonCreator
    public RetrieveDisputeResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("dispute") Dispute dispute) {
        this.errors = errors;
        this.dispute = dispute;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Dispute dispute;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Dispute.
     * Represents a dispute a cardholder initiated with their bank.
     */
    @JsonGetter("dispute")
    public Dispute getDispute() {
        return this.dispute;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, dispute);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveDisputeResponse)) {
            return false;
        }
        RetrieveDisputeResponse retrieveDisputeResponse = (RetrieveDisputeResponse) obj;
        return Objects.equals(errors, retrieveDisputeResponse.errors) &&
            Objects.equals(dispute, retrieveDisputeResponse.dispute);
    }

    /**
     * Builds a new {@link RetrieveDisputeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveDisputeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .dispute(getDispute());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveDisputeResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Dispute dispute;

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
         * Setter for dispute
         * @param dispute
         * @return Builder
         */
        public Builder dispute(Dispute dispute) {
            this.dispute = dispute;
            return this;
        }

        /**
         * Builds a new {@link RetrieveDisputeResponse} object using the set fields.
         * @return {@link RetrieveDisputeResponse}
         */
        public RetrieveDisputeResponse build() {
            RetrieveDisputeResponse model = new RetrieveDisputeResponse(errors,
                dispute);
            model.httpContext = httpContext;
            return model;
        }
    }
}

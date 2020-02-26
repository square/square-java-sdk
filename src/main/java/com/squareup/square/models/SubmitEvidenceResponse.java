package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SubmitEvidenceResponse type.
 */
public class SubmitEvidenceResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param dispute
     */
    @JsonCreator
    public SubmitEvidenceResponse(
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
        if(!(obj instanceof SubmitEvidenceResponse)) {
            return false;
        }
        SubmitEvidenceResponse submitEvidenceResponse = (SubmitEvidenceResponse) obj;
        return Objects.equals(errors, submitEvidenceResponse.errors) &&
            Objects.equals(dispute, submitEvidenceResponse.dispute);
    }

    /**
     * Builds a new {@link SubmitEvidenceResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubmitEvidenceResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .dispute(getDispute());
            return builder;
    }

    /**
     * Class to build instances of {@link SubmitEvidenceResponse}
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
         * Builds a new {@link SubmitEvidenceResponse} object using the set fields.
         * @return {@link SubmitEvidenceResponse}
         */
        public SubmitEvidenceResponse build() {
            SubmitEvidenceResponse model = new SubmitEvidenceResponse(errors,
                dispute);
            model.httpContext = httpContext;
            return model;
        }
    }
}

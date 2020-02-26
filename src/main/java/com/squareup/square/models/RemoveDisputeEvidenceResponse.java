package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RemoveDisputeEvidenceResponse type.
 */
public class RemoveDisputeEvidenceResponse {

    /**
     * Initialization constructor.
     * @param errors
     */
    @JsonCreator
    public RemoveDisputeEvidenceResponse(
            @JsonProperty("errors") List<Error> errors) {
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<Error> errors;

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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RemoveDisputeEvidenceResponse)) {
            return false;
        }
        RemoveDisputeEvidenceResponse removeDisputeEvidenceResponse = (RemoveDisputeEvidenceResponse) obj;
        return Objects.equals(errors, removeDisputeEvidenceResponse.errors);
    }

    /**
     * Builds a new {@link RemoveDisputeEvidenceResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RemoveDisputeEvidenceResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link RemoveDisputeEvidenceResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;

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
         * Builds a new {@link RemoveDisputeEvidenceResponse} object using the set fields.
         * @return {@link RemoveDisputeEvidenceResponse}
         */
        public RemoveDisputeEvidenceResponse build() {
            RemoveDisputeEvidenceResponse model = new RemoveDisputeEvidenceResponse(errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

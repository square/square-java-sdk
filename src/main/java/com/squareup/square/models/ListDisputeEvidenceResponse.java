
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListDisputeEvidenceResponse type.
 */
public class ListDisputeEvidenceResponse {
    private HttpContext httpContext;
    private final List<DisputeEvidence> evidence;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param evidence List of DisputeEvidence value for evidence.
     * @param errors List of Error value for errors.
     */
    @JsonCreator
    public ListDisputeEvidenceResponse(
            @JsonProperty("evidence") List<DisputeEvidence> evidence,
            @JsonProperty("errors") List<Error> errors) {
        this.evidence = evidence;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Evidence.
     * The list of evidence previously uploaded to the specified dispute.
     * @return Returns the List of DisputeEvidence
     */
    @JsonGetter("evidence")
    public List<DisputeEvidence> getEvidence() {
        return this.evidence;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(evidence, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListDisputeEvidenceResponse)) {
            return false;
        }
        ListDisputeEvidenceResponse other = (ListDisputeEvidenceResponse) obj;
        return Objects.equals(evidence, other.evidence)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListDisputeEvidenceResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDisputeEvidenceResponse [" + "evidence=" + evidence + ", errors=" + errors
                + "]";
    }

    /**
     * Builds a new {@link ListDisputeEvidenceResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDisputeEvidenceResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .evidence(getEvidence())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListDisputeEvidenceResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<DisputeEvidence> evidence;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for evidence.
         * @param evidence List of DisputeEvidence value for evidence.
         * @return Builder
         */
        public Builder evidence(List<DisputeEvidence> evidence) {
            this.evidence = evidence;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link ListDisputeEvidenceResponse} object using the set fields.
         * @return {@link ListDisputeEvidenceResponse}
         */
        public ListDisputeEvidenceResponse build() {
            ListDisputeEvidenceResponse model =
                    new ListDisputeEvidenceResponse(evidence, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}

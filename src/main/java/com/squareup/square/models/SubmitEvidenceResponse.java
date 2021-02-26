
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SubmitEvidenceResponse type.
 */
public class SubmitEvidenceResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Dispute dispute;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  dispute  Dispute value for dispute.
     */
    @JsonCreator
    public SubmitEvidenceResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("dispute") Dispute dispute) {
        this.errors = errors;
        this.dispute = dispute;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Dispute.
     * Represents a dispute a cardholder initiated with their bank.
     * @return Returns the Dispute
     */
    @JsonGetter("dispute")
    public Dispute getDispute() {
        return dispute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, dispute);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitEvidenceResponse)) {
            return false;
        }
        SubmitEvidenceResponse other = (SubmitEvidenceResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(dispute, other.dispute);
    }

    /**
     * Converts this SubmitEvidenceResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubmitEvidenceResponse [" + "errors=" + errors + ", dispute=" + dispute + "]";
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
     * Class to build instances of {@link SubmitEvidenceResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Dispute dispute;



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
         * Setter for dispute.
         * @param  dispute  Dispute value for dispute.
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
            SubmitEvidenceResponse model =
                    new SubmitEvidenceResponse(errors, dispute);
            model.httpContext = httpContext;
            return model;
        }
    }
}

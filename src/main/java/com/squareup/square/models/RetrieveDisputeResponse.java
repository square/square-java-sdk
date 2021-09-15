
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveDisputeResponse type.
 */
public class RetrieveDisputeResponse {
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
    public RetrieveDisputeResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("dispute") Dispute dispute) {
        this.errors = errors;
        this.dispute = dispute;
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
        if (!(obj instanceof RetrieveDisputeResponse)) {
            return false;
        }
        RetrieveDisputeResponse other = (RetrieveDisputeResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(dispute, other.dispute);
    }

    /**
     * Converts this RetrieveDisputeResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveDisputeResponse [" + "errors=" + errors + ", dispute=" + dispute + "]";
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
     * Class to build instances of {@link RetrieveDisputeResponse}.
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
         * Builds a new {@link RetrieveDisputeResponse} object using the set fields.
         * @return {@link RetrieveDisputeResponse}
         */
        public RetrieveDisputeResponse build() {
            RetrieveDisputeResponse model =
                    new RetrieveDisputeResponse(errors, dispute);
            model.httpContext = httpContext;
            return model;
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListDisputeEvidenceResponse type.
 */
public class ListDisputeEvidenceResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<DisputeEvidence> evidence;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  evidence  List of DisputeEvidence value for evidence.
     * @param  errors  List of Error value for errors.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListDisputeEvidenceResponse(
            @JsonProperty("evidence") List<DisputeEvidence> evidence,
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("cursor") String cursor) {
        this.evidence = evidence;
        this.errors = errors;
        this.cursor = cursor;
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
        return evidence;
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
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final
     * response. For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(evidence, errors, cursor);
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
            && Objects.equals(errors, other.errors)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListDisputeEvidenceResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListDisputeEvidenceResponse [" + "evidence=" + evidence + ", errors=" + errors
                + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListDisputeEvidenceResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListDisputeEvidenceResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .evidence(getEvidence())
                .errors(getErrors())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListDisputeEvidenceResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<DisputeEvidence> evidence;
        private List<Error> errors;
        private String cursor;



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
         * Setter for evidence.
         * @param  evidence  List of DisputeEvidence value for evidence.
         * @return Builder
         */
        public Builder evidence(List<DisputeEvidence> evidence) {
            this.evidence = evidence;
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
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListDisputeEvidenceResponse} object using the set fields.
         * @return {@link ListDisputeEvidenceResponse}
         */
        public ListDisputeEvidenceResponse build() {
            ListDisputeEvidenceResponse model =
                    new ListDisputeEvidenceResponse(evidence, errors, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

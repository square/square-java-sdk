
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for DeprecatedCreateDisputeEvidenceTextResponse type.
 */
public class DeprecatedCreateDisputeEvidenceTextResponse {
    private final List<Error> errors;
    private final DisputeEvidence evidence;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  evidence  DisputeEvidence value for evidence.
     */
    @JsonCreator
    public DeprecatedCreateDisputeEvidenceTextResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("evidence") DisputeEvidence evidence) {
        this.errors = errors;
        this.evidence = evidence;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Evidence.
     * @return Returns the DisputeEvidence
     */
    @JsonGetter("evidence")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DisputeEvidence getEvidence() {
        return evidence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, evidence);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeprecatedCreateDisputeEvidenceTextResponse)) {
            return false;
        }
        DeprecatedCreateDisputeEvidenceTextResponse other =
                (DeprecatedCreateDisputeEvidenceTextResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(evidence, other.evidence);
    }

    /**
     * Converts this DeprecatedCreateDisputeEvidenceTextResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeprecatedCreateDisputeEvidenceTextResponse [" + "errors=" + errors + ", evidence="
                + evidence + "]";
    }

    /**
     * Builds a new {@link DeprecatedCreateDisputeEvidenceTextResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeprecatedCreateDisputeEvidenceTextResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .evidence(getEvidence());
        return builder;
    }

    /**
     * Class to build instances of {@link DeprecatedCreateDisputeEvidenceTextResponse}.
     */
    public static class Builder {
        private List<Error> errors;
        private DisputeEvidence evidence;



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
         * Setter for evidence.
         * @param  evidence  DisputeEvidence value for evidence.
         * @return Builder
         */
        public Builder evidence(DisputeEvidence evidence) {
            this.evidence = evidence;
            return this;
        }

        /**
         * Builds a new {@link DeprecatedCreateDisputeEvidenceTextResponse} object using the set
         * fields.
         * @return {@link DeprecatedCreateDisputeEvidenceTextResponse}
         */
        public DeprecatedCreateDisputeEvidenceTextResponse build() {
            return new DeprecatedCreateDisputeEvidenceTextResponse(errors, evidence);
        }
    }
}

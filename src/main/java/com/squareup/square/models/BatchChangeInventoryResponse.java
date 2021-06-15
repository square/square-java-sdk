
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchChangeInventoryResponse type.
 */
public class BatchChangeInventoryResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<InventoryCount> counts;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<InventoryChange> changes;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  counts  List of InventoryCount value for counts.
     * @param  changes  List of InventoryChange value for changes.
     */
    @JsonCreator
    public BatchChangeInventoryResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("counts") List<InventoryCount> counts,
            @JsonProperty("changes") List<InventoryChange> changes) {
        this.errors = errors;
        this.counts = counts;
        this.changes = changes;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Counts.
     * The current counts for all objects referenced in the request.
     * @return Returns the List of InventoryCount
     */
    @JsonGetter("counts")
    public List<InventoryCount> getCounts() {
        return counts;
    }

    /**
     * Getter for Changes.
     * Changes created for the request.
     * @return Returns the List of InventoryChange
     */
    @JsonGetter("changes")
    public List<InventoryChange> getChanges() {
        return changes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, counts, changes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchChangeInventoryResponse)) {
            return false;
        }
        BatchChangeInventoryResponse other = (BatchChangeInventoryResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(counts, other.counts)
            && Objects.equals(changes, other.changes);
    }

    /**
     * Converts this BatchChangeInventoryResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchChangeInventoryResponse [" + "errors=" + errors + ", counts=" + counts
                + ", changes=" + changes + "]";
    }

    /**
     * Builds a new {@link BatchChangeInventoryResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchChangeInventoryResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .counts(getCounts())
                .changes(getChanges());
        return builder;
    }

    /**
     * Class to build instances of {@link BatchChangeInventoryResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryCount> counts;
        private List<InventoryChange> changes;



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
         * Setter for counts.
         * @param  counts  List of InventoryCount value for counts.
         * @return Builder
         */
        public Builder counts(List<InventoryCount> counts) {
            this.counts = counts;
            return this;
        }

        /**
         * Setter for changes.
         * @param  changes  List of InventoryChange value for changes.
         * @return Builder
         */
        public Builder changes(List<InventoryChange> changes) {
            this.changes = changes;
            return this;
        }

        /**
         * Builds a new {@link BatchChangeInventoryResponse} object using the set fields.
         * @return {@link BatchChangeInventoryResponse}
         */
        public BatchChangeInventoryResponse build() {
            BatchChangeInventoryResponse model =
                    new BatchChangeInventoryResponse(errors, counts, changes);
            model.httpContext = httpContext;
            return model;
        }
    }
}

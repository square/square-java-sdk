package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for BatchChangeInventoryResponse type.
 */
public class BatchChangeInventoryResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param counts
     */
    @JsonCreator
    public BatchChangeInventoryResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("counts") List<InventoryCount> counts) {
        this.errors = errors;
        this.counts = counts;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<InventoryCount> counts;

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
     * Getter for Counts.
     * The current counts for all objects referenced in the request.
     */
    @JsonGetter("counts")
    public List<InventoryCount> getCounts() {
        return this.counts;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, counts);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchChangeInventoryResponse)) {
            return false;
        }
        BatchChangeInventoryResponse batchChangeInventoryResponse = (BatchChangeInventoryResponse) obj;
        return Objects.equals(errors, batchChangeInventoryResponse.errors) &&
            Objects.equals(counts, batchChangeInventoryResponse.counts);
    }

    /**
     * Builds a new {@link BatchChangeInventoryResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchChangeInventoryResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .counts(getCounts());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchChangeInventoryResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryCount> counts;

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
         * Setter for counts
         * @param counts
         * @return Builder
         */
        public Builder counts(List<InventoryCount> counts) {
            this.counts = counts;
            return this;
        }

        /**
         * Builds a new {@link BatchChangeInventoryResponse} object using the set fields.
         * @return {@link BatchChangeInventoryResponse}
         */
        public BatchChangeInventoryResponse build() {
            BatchChangeInventoryResponse model = new BatchChangeInventoryResponse(errors,
                counts);
            model.httpContext = httpContext;
            return model;
        }
    }
}

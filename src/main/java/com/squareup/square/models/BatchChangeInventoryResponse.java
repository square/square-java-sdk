package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class BatchChangeInventoryResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, counts);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchChangeInventoryResponse)) {
            return false;
        }
        BatchChangeInventoryResponse batchChangeInventoryResponse = (BatchChangeInventoryResponse) o;
        return Objects.equals(errors, batchChangeInventoryResponse.errors) &&
            Objects.equals(counts, batchChangeInventoryResponse.counts);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .counts(getCounts());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryCount> counts;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder counts(List<InventoryCount> value) {
            counts = value;
            return this;
        }

        public BatchChangeInventoryResponse build() {
            BatchChangeInventoryResponse model = new BatchChangeInventoryResponse(errors,
                counts);
            model.httpContext = httpContext;
            return model;
        }
    }
}

package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveInventoryCountResponse {

    @JsonCreator
    public RetrieveInventoryCountResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("counts") List<InventoryCount> counts,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.counts = counts;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<InventoryCount> counts;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(errors, counts, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveInventoryCountResponse)) {
            return false;
        }
        RetrieveInventoryCountResponse retrieveInventoryCountResponse = (RetrieveInventoryCountResponse) o;
        return Objects.equals(errors, retrieveInventoryCountResponse.errors) &&
            Objects.equals(counts, retrieveInventoryCountResponse.counts) &&
            Objects.equals(cursor, retrieveInventoryCountResponse.cursor);
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
     * The current calculated inventory counts for the requested object and
     * locations.
     */
    @JsonGetter("counts")
    public List<InventoryCount> getCounts() { 
        return this.counts;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset,
     * this is the final response.
     * See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .counts(getCounts())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryCount> counts;
        private String cursor;

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
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public RetrieveInventoryCountResponse build() {
            RetrieveInventoryCountResponse model = new RetrieveInventoryCountResponse(errors,
                counts,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

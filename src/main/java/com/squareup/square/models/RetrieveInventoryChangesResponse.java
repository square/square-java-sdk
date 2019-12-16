package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveInventoryChangesResponse {

    @JsonCreator
    public RetrieveInventoryChangesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("changes") List<InventoryChange> changes,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.changes = changes;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<InventoryChange> changes;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(errors, changes, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveInventoryChangesResponse)) {
            return false;
        }
        RetrieveInventoryChangesResponse retrieveInventoryChangesResponse = (RetrieveInventoryChangesResponse) o;
        return Objects.equals(errors, retrieveInventoryChangesResponse.errors) &&
            Objects.equals(changes, retrieveInventoryChangesResponse.changes) &&
            Objects.equals(cursor, retrieveInventoryChangesResponse.cursor);
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
     * Getter for Changes.
     * The set of inventory changes for the requested object and locations.
     */
    @JsonGetter("changes")
    public List<InventoryChange> getChanges() { 
        return this.changes;
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
            .changes(getChanges())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryChange> changes;
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
        public Builder changes(List<InventoryChange> value) {
            changes = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public RetrieveInventoryChangesResponse build() {
            RetrieveInventoryChangesResponse model = new RetrieveInventoryChangesResponse(errors,
                changes,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

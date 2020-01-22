package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveInventoryChangesResponse type.
 */
public class RetrieveInventoryChangesResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param changes
     * @param cursor
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, changes, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveInventoryChangesResponse)) {
            return false;
        }
        RetrieveInventoryChangesResponse retrieveInventoryChangesResponse = (RetrieveInventoryChangesResponse) obj;
        return Objects.equals(errors, retrieveInventoryChangesResponse.errors) &&
            Objects.equals(changes, retrieveInventoryChangesResponse.changes) &&
            Objects.equals(cursor, retrieveInventoryChangesResponse.cursor);
    }

    /**
     * Builds a new {@link RetrieveInventoryChangesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveInventoryChangesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .changes(getChanges())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveInventoryChangesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryChange> changes;
        private String cursor;

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
         * Setter for changes
         * @param changes
         * @return Builder
         */
        public Builder changes(List<InventoryChange> changes) {
            this.changes = changes;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link RetrieveInventoryChangesResponse} object using the set fields.
         * @return {@link RetrieveInventoryChangesResponse}
         */
        public RetrieveInventoryChangesResponse build() {
            RetrieveInventoryChangesResponse model = new RetrieveInventoryChangesResponse(errors,
                changes,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

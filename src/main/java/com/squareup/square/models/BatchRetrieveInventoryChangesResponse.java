
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for BatchRetrieveInventoryChangesResponse type.
 */
public class BatchRetrieveInventoryChangesResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<InventoryChange> changes;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param changes List of InventoryChange value for changes.
     * @param cursor String value for cursor.
     */
    @JsonCreator
    public BatchRetrieveInventoryChangesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("changes") List<InventoryChange> changes,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.changes = changes;
        this.cursor = cursor;
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
        return this.errors;
    }

    /**
     * Getter for Changes.
     * The current calculated inventory changes for the requested objects and locations.
     * @return Returns the List of InventoryChange
     */
    @JsonGetter("changes")
    public List<InventoryChange> getChanges() {
        return this.changes;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final
     * response. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchRetrieveInventoryChangesResponse)) {
            return false;
        }
        BatchRetrieveInventoryChangesResponse other = (BatchRetrieveInventoryChangesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(changes, other.changes)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Builds a new {@link BatchRetrieveInventoryChangesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveInventoryChangesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .changes(getChanges())
            .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveInventoryChangesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryChange> changes;
        private String cursor;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for changes.
         * @param changes List of InventoryChange value for changes.
         * @return Builder
         */
        public Builder changes(List<InventoryChange> changes) {
            this.changes = changes;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveInventoryChangesResponse} object using the set fields.
         * @return {@link BatchRetrieveInventoryChangesResponse}
         */
        public BatchRetrieveInventoryChangesResponse build() {
            BatchRetrieveInventoryChangesResponse model =
                    new BatchRetrieveInventoryChangesResponse(errors,
                            changes,
                            cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

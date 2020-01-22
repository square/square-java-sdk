package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveInventoryCountResponse type.
 */
public class RetrieveInventoryCountResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param counts
     * @param cursor
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, counts, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveInventoryCountResponse)) {
            return false;
        }
        RetrieveInventoryCountResponse retrieveInventoryCountResponse = (RetrieveInventoryCountResponse) obj;
        return Objects.equals(errors, retrieveInventoryCountResponse.errors) &&
            Objects.equals(counts, retrieveInventoryCountResponse.counts) &&
            Objects.equals(cursor, retrieveInventoryCountResponse.cursor);
    }

    /**
     * Builds a new {@link RetrieveInventoryCountResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveInventoryCountResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .counts(getCounts())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveInventoryCountResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<InventoryCount> counts;
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
         * Setter for counts
         * @param counts
         * @return Builder
         */
        public Builder counts(List<InventoryCount> counts) {
            this.counts = counts;
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
         * Builds a new {@link RetrieveInventoryCountResponse} object using the set fields.
         * @return {@link RetrieveInventoryCountResponse}
         */
        public RetrieveInventoryCountResponse build() {
            RetrieveInventoryCountResponse model = new RetrieveInventoryCountResponse(errors,
                counts,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}

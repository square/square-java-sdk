package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListCatalogResponse type.
 */
public class ListCatalogResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param cursor
     * @param objects
     */
    @JsonCreator
    public ListCatalogResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("objects") List<CatalogObject> objects) {
        this.errors = errors;
        this.cursor = cursor;
        this.objects = objects;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final String cursor;
    private final List<CatalogObject> objects;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on any errors encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final response.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Objects.
     * The CatalogObjects returned.
     */
    @JsonGetter("objects")
    public List<CatalogObject> getObjects() {
        return this.objects;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, cursor, objects);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListCatalogResponse)) {
            return false;
        }
        ListCatalogResponse listCatalogResponse = (ListCatalogResponse) obj;
        return Objects.equals(errors, listCatalogResponse.errors) &&
            Objects.equals(cursor, listCatalogResponse.cursor) &&
            Objects.equals(objects, listCatalogResponse.objects);
    }

    /**
     * Builds a new {@link ListCatalogResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCatalogResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .cursor(getCursor())
            .objects(getObjects());
            return builder;
    }

    /**
     * Class to build instances of {@link ListCatalogResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String cursor;
        private List<CatalogObject> objects;

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
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }
        /**
         * Setter for objects
         * @param objects
         * @return Builder
         */
        public Builder objects(List<CatalogObject> objects) {
            this.objects = objects;
            return this;
        }

        /**
         * Builds a new {@link ListCatalogResponse} object using the set fields.
         * @return {@link ListCatalogResponse}
         */
        public ListCatalogResponse build() {
            ListCatalogResponse model = new ListCatalogResponse(errors,
                cursor,
                objects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

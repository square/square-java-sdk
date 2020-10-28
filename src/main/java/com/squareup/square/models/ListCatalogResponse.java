
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for ListCatalogResponse type.
 */
public class ListCatalogResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final String cursor;
    private final List<CatalogObject> objects;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param cursor String value for cursor.
     * @param objects List of CatalogObject value for objects.
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
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If unset, this is the final
     * response. See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for
     * more information.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Objects.
     * The CatalogObjects returned.
     * @return Returns the List of CatalogObject
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCatalogResponse)) {
            return false;
        }
        ListCatalogResponse other = (ListCatalogResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(objects, other.objects);
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
     * Class to build instances of {@link ListCatalogResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String cursor;
        private List<CatalogObject> objects;



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
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for objects.
         * @param objects List of CatalogObject value for objects.
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
            ListCatalogResponse model =
                    new ListCatalogResponse(errors,
                            cursor,
                            objects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

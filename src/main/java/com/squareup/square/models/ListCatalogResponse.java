package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListCatalogResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, cursor, objects);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListCatalogResponse)) {
            return false;
        }
        ListCatalogResponse listCatalogResponse = (ListCatalogResponse) o;
        return Objects.equals(errors, listCatalogResponse.errors) &&
            Objects.equals(cursor, listCatalogResponse.cursor) &&
            Objects.equals(objects, listCatalogResponse.objects);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .cursor(getCursor())
            .objects(getObjects());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String cursor;
        private List<CatalogObject> objects;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder objects(List<CatalogObject> value) {
            objects = value;
            return this;
        }

        public ListCatalogResponse build() {
            ListCatalogResponse model = new ListCatalogResponse(errors,
                cursor,
                objects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

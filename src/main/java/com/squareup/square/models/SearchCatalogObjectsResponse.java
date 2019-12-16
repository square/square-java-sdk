package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class SearchCatalogObjectsResponse {

    @JsonCreator
    public SearchCatalogObjectsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("objects") List<CatalogObject> objects,
            @JsonProperty("related_objects") List<CatalogObject> relatedObjects,
            @JsonProperty("latest_time") String latestTime) {
        this.errors = errors;
        this.cursor = cursor;
        this.objects = objects;
        this.relatedObjects = relatedObjects;
        this.latestTime = latestTime;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final String cursor;
    private final List<CatalogObject> objects;
    private final List<CatalogObject> relatedObjects;
    private final String latestTime;

    @Override
    public int hashCode() {
        return Objects.hash(errors, cursor, objects, relatedObjects, latestTime);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchCatalogObjectsResponse)) {
            return false;
        }
        SearchCatalogObjectsResponse searchCatalogObjectsResponse = (SearchCatalogObjectsResponse) o;
        return Objects.equals(errors, searchCatalogObjectsResponse.errors) &&
            Objects.equals(cursor, searchCatalogObjectsResponse.cursor) &&
            Objects.equals(objects, searchCatalogObjectsResponse.objects) &&
            Objects.equals(relatedObjects, searchCatalogObjectsResponse.relatedObjects) &&
            Objects.equals(latestTime, searchCatalogObjectsResponse.latestTime);
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

    /**
     * Getter for RelatedObjects.
     * A list of CatalogObjects referenced by the objects in the `objects` field.
     */
    @JsonGetter("related_objects")
    public List<CatalogObject> getRelatedObjects() { 
        return this.relatedObjects;
    }

    /**
     * Getter for LatestTime.
     * When the associated product catalog was last updated. Will
     * match the value for `end_time` or `cursor` if either field is included in the `SearchCatalog` request.
     */
    @JsonGetter("latest_time")
    public String getLatestTime() { 
        return this.latestTime;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .cursor(getCursor())
            .objects(getObjects())
            .relatedObjects(getRelatedObjects())
            .latestTime(getLatestTime());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String cursor;
        private List<CatalogObject> objects;
        private List<CatalogObject> relatedObjects;
        private String latestTime;

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
        public Builder relatedObjects(List<CatalogObject> value) {
            relatedObjects = value;
            return this;
        }
        public Builder latestTime(String value) {
            latestTime = value;
            return this;
        }

        public SearchCatalogObjectsResponse build() {
            SearchCatalogObjectsResponse model = new SearchCatalogObjectsResponse(errors,
                cursor,
                objects,
                relatedObjects,
                latestTime);
            model.httpContext = httpContext;
            return model;
        }
    }
}

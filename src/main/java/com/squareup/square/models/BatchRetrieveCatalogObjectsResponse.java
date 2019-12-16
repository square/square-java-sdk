package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class BatchRetrieveCatalogObjectsResponse {

    @JsonCreator
    public BatchRetrieveCatalogObjectsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("objects") List<CatalogObject> objects,
            @JsonProperty("related_objects") List<CatalogObject> relatedObjects) {
        this.errors = errors;
        this.objects = objects;
        this.relatedObjects = relatedObjects;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<CatalogObject> objects;
    private final List<CatalogObject> relatedObjects;

    @Override
    public int hashCode() {
        return Objects.hash(errors, objects, relatedObjects);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchRetrieveCatalogObjectsResponse)) {
            return false;
        }
        BatchRetrieveCatalogObjectsResponse batchRetrieveCatalogObjectsResponse = (BatchRetrieveCatalogObjectsResponse) o;
        return Objects.equals(errors, batchRetrieveCatalogObjectsResponse.errors) &&
            Objects.equals(objects, batchRetrieveCatalogObjectsResponse.objects) &&
            Objects.equals(relatedObjects, batchRetrieveCatalogObjectsResponse.relatedObjects);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * The set of [Error](#type-error)s encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for Objects.
     * A list of [CatalogObject](#type-catalogobject)s returned.
     */
    @JsonGetter("objects")
    public List<CatalogObject> getObjects() { 
        return this.objects;
    }

    /**
     * Getter for RelatedObjects.
     * A list of [CatalogObject](#type-catalogobject)s referenced by the object in the `objects` field.
     */
    @JsonGetter("related_objects")
    public List<CatalogObject> getRelatedObjects() { 
        return this.relatedObjects;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .objects(getObjects())
            .relatedObjects(getRelatedObjects());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CatalogObject> objects;
        private List<CatalogObject> relatedObjects;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
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

        public BatchRetrieveCatalogObjectsResponse build() {
            BatchRetrieveCatalogObjectsResponse model = new BatchRetrieveCatalogObjectsResponse(errors,
                objects,
                relatedObjects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

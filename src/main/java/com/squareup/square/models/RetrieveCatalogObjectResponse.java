package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveCatalogObjectResponse {

    @JsonCreator
    public RetrieveCatalogObjectResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("object") CatalogObject object,
            @JsonProperty("related_objects") List<CatalogObject> relatedObjects) {
        this.errors = errors;
        this.object = object;
        this.relatedObjects = relatedObjects;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final CatalogObject object;
    private final List<CatalogObject> relatedObjects;

    @Override
    public int hashCode() {
        return Objects.hash(errors, object, relatedObjects);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveCatalogObjectResponse)) {
            return false;
        }
        RetrieveCatalogObjectResponse retrieveCatalogObjectResponse = (RetrieveCatalogObjectResponse) o;
        return Objects.equals(errors, retrieveCatalogObjectResponse.errors) &&
            Objects.equals(object, retrieveCatalogObjectResponse.object) &&
            Objects.equals(relatedObjects, retrieveCatalogObjectResponse.relatedObjects);
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
     * Getter for Object.
     */
    @JsonGetter("object")
    public CatalogObject getObject() { 
        return this.object;
    }

    /**
     * Getter for RelatedObjects.
     * A list of CatalogObjects referenced by the object in the `object` field.
     */
    @JsonGetter("related_objects")
    public List<CatalogObject> getRelatedObjects() { 
        return this.relatedObjects;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .object(getObject())
            .relatedObjects(getRelatedObjects());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject object;
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
        public Builder object(CatalogObject value) {
            object = value;
            return this;
        }
        public Builder relatedObjects(List<CatalogObject> value) {
            relatedObjects = value;
            return this;
        }

        public RetrieveCatalogObjectResponse build() {
            RetrieveCatalogObjectResponse model = new RetrieveCatalogObjectResponse(errors,
                object,
                relatedObjects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

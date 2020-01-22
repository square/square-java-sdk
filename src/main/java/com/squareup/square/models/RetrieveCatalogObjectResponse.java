package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveCatalogObjectResponse type.
 */
public class RetrieveCatalogObjectResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param object
     * @param relatedObjects
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, object, relatedObjects);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveCatalogObjectResponse)) {
            return false;
        }
        RetrieveCatalogObjectResponse retrieveCatalogObjectResponse = (RetrieveCatalogObjectResponse) obj;
        return Objects.equals(errors, retrieveCatalogObjectResponse.errors) &&
            Objects.equals(object, retrieveCatalogObjectResponse.object) &&
            Objects.equals(relatedObjects, retrieveCatalogObjectResponse.relatedObjects);
    }

    /**
     * Builds a new {@link RetrieveCatalogObjectResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCatalogObjectResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .object(getObject())
            .relatedObjects(getRelatedObjects());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCatalogObjectResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject object;
        private List<CatalogObject> relatedObjects;

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
         * Setter for object
         * @param object
         * @return Builder
         */
        public Builder object(CatalogObject object) {
            this.object = object;
            return this;
        }
        /**
         * Setter for relatedObjects
         * @param relatedObjects
         * @return Builder
         */
        public Builder relatedObjects(List<CatalogObject> relatedObjects) {
            this.relatedObjects = relatedObjects;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCatalogObjectResponse} object using the set fields.
         * @return {@link RetrieveCatalogObjectResponse}
         */
        public RetrieveCatalogObjectResponse build() {
            RetrieveCatalogObjectResponse model = new RetrieveCatalogObjectResponse(errors,
                object,
                relatedObjects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

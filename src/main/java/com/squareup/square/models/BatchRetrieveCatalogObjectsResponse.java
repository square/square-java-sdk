package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for BatchRetrieveCatalogObjectsResponse type.
 */
public class BatchRetrieveCatalogObjectsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param objects
     * @param relatedObjects
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, objects, relatedObjects);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchRetrieveCatalogObjectsResponse)) {
            return false;
        }
        BatchRetrieveCatalogObjectsResponse batchRetrieveCatalogObjectsResponse = (BatchRetrieveCatalogObjectsResponse) obj;
        return Objects.equals(errors, batchRetrieveCatalogObjectsResponse.errors) &&
            Objects.equals(objects, batchRetrieveCatalogObjectsResponse.objects) &&
            Objects.equals(relatedObjects, batchRetrieveCatalogObjectsResponse.relatedObjects);
    }

    /**
     * Builds a new {@link BatchRetrieveCatalogObjectsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveCatalogObjectsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .objects(getObjects())
            .relatedObjects(getRelatedObjects());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveCatalogObjectsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CatalogObject> objects;
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
         * Setter for objects
         * @param objects
         * @return Builder
         */
        public Builder objects(List<CatalogObject> objects) {
            this.objects = objects;
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
         * Builds a new {@link BatchRetrieveCatalogObjectsResponse} object using the set fields.
         * @return {@link BatchRetrieveCatalogObjectsResponse}
         */
        public BatchRetrieveCatalogObjectsResponse build() {
            BatchRetrieveCatalogObjectsResponse model = new BatchRetrieveCatalogObjectsResponse(errors,
                objects,
                relatedObjects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

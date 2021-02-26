
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveCatalogObjectsResponse type.
 */
public class BatchRetrieveCatalogObjectsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CatalogObject> objects;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CatalogObject> relatedObjects;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  objects  List of CatalogObject value for objects.
     * @param  relatedObjects  List of CatalogObject value for relatedObjects.
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
        return errors;
    }

    /**
     * Getter for Objects.
     * A list of [CatalogObject](#type-catalogobject)s returned.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("objects")
    public List<CatalogObject> getObjects() {
        return objects;
    }

    /**
     * Getter for RelatedObjects.
     * A list of [CatalogObject](#type-catalogobject)s referenced by the object in the `objects`
     * field.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("related_objects")
    public List<CatalogObject> getRelatedObjects() {
        return relatedObjects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, objects, relatedObjects);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchRetrieveCatalogObjectsResponse)) {
            return false;
        }
        BatchRetrieveCatalogObjectsResponse other = (BatchRetrieveCatalogObjectsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(objects, other.objects)
            && Objects.equals(relatedObjects, other.relatedObjects);
    }

    /**
     * Converts this BatchRetrieveCatalogObjectsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveCatalogObjectsResponse [" + "errors=" + errors + ", objects=" + objects
                + ", relatedObjects=" + relatedObjects + "]";
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
     * Class to build instances of {@link BatchRetrieveCatalogObjectsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CatalogObject> objects;
        private List<CatalogObject> relatedObjects;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for objects.
         * @param  objects  List of CatalogObject value for objects.
         * @return Builder
         */
        public Builder objects(List<CatalogObject> objects) {
            this.objects = objects;
            return this;
        }

        /**
         * Setter for relatedObjects.
         * @param  relatedObjects  List of CatalogObject value for relatedObjects.
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
            BatchRetrieveCatalogObjectsResponse model =
                    new BatchRetrieveCatalogObjectsResponse(errors, objects, relatedObjects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

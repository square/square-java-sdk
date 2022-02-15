
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveCatalogObjectResponse type.
 */
public class RetrieveCatalogObjectResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final CatalogObject object;
    private final List<CatalogObject> relatedObjects;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  object  CatalogObject value for object.
     * @param  relatedObjects  List of CatalogObject value for relatedObjects.
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

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Object.
     * The wrapper object for the catalog entries of a given object type. Depending on the `type`
     * attribute value, a `CatalogObject` instance assumes a type-specific data to yield the
     * corresponding type of catalog object. For example, if `type=ITEM`, the `CatalogObject`
     * instance must have the ITEM-specific data set on the `item_data` attribute. The resulting
     * `CatalogObject` instance is also a `CatalogItem` instance. In general, if
     * `type=&lt;OBJECT_TYPE&gt;`, the `CatalogObject` instance must have the `&lt;OBJECT_TYPE&gt;`-specific
     * data set on the `&lt;object_type&gt;_data` attribute. The resulting `CatalogObject` instance is
     * also a `Catalog&lt;ObjectType&gt;` instance. For a more detailed discussion of the Catalog data
     * model, please see the [Design a
     * Catalog](https://developer.squareup.com/docs/catalog-api/design-a-catalog) guide.
     * @return Returns the CatalogObject
     */
    @JsonGetter("object")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogObject getObject() {
        return object;
    }

    /**
     * Getter for RelatedObjects.
     * A list of `CatalogObject`s referenced by the object in the `object` field.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("related_objects")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CatalogObject> getRelatedObjects() {
        return relatedObjects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, object, relatedObjects);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCatalogObjectResponse)) {
            return false;
        }
        RetrieveCatalogObjectResponse other = (RetrieveCatalogObjectResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(object, other.object)
            && Objects.equals(relatedObjects, other.relatedObjects);
    }

    /**
     * Converts this RetrieveCatalogObjectResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveCatalogObjectResponse [" + "errors=" + errors + ", object=" + object
                + ", relatedObjects=" + relatedObjects + "]";
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
     * Class to build instances of {@link RetrieveCatalogObjectResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject object;
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
         * Setter for object.
         * @param  object  CatalogObject value for object.
         * @return Builder
         */
        public Builder object(CatalogObject object) {
            this.object = object;
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
         * Builds a new {@link RetrieveCatalogObjectResponse} object using the set fields.
         * @return {@link RetrieveCatalogObjectResponse}
         */
        public RetrieveCatalogObjectResponse build() {
            RetrieveCatalogObjectResponse model =
                    new RetrieveCatalogObjectResponse(errors, object, relatedObjects);
            model.httpContext = httpContext;
            return model;
        }
    }
}

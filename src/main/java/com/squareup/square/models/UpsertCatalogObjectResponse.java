
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
 * This is a model class for UpsertCatalogObjectResponse type.
 */
public class UpsertCatalogObjectResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final CatalogObject catalogObject;
    private final List<CatalogIdMapping> idMappings;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  catalogObject  CatalogObject value for catalogObject.
     * @param  idMappings  List of CatalogIdMapping value for idMappings.
     */
    @JsonCreator
    public UpsertCatalogObjectResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("catalog_object") CatalogObject catalogObject,
            @JsonProperty("id_mappings") List<CatalogIdMapping> idMappings) {
        this.errors = errors;
        this.catalogObject = catalogObject;
        this.idMappings = idMappings;
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
     * Getter for CatalogObject.
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
    @JsonGetter("catalog_object")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CatalogObject getCatalogObject() {
        return catalogObject;
    }

    /**
     * Getter for IdMappings.
     * The mapping between client and server IDs for this upsert.
     * @return Returns the List of CatalogIdMapping
     */
    @JsonGetter("id_mappings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CatalogIdMapping> getIdMappings() {
        return idMappings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, catalogObject, idMappings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpsertCatalogObjectResponse)) {
            return false;
        }
        UpsertCatalogObjectResponse other = (UpsertCatalogObjectResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(catalogObject, other.catalogObject)
            && Objects.equals(idMappings, other.idMappings);
    }

    /**
     * Converts this UpsertCatalogObjectResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpsertCatalogObjectResponse [" + "errors=" + errors + ", catalogObject="
                + catalogObject + ", idMappings=" + idMappings + "]";
    }

    /**
     * Builds a new {@link UpsertCatalogObjectResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpsertCatalogObjectResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .catalogObject(getCatalogObject())
                .idMappings(getIdMappings());
        return builder;
    }

    /**
     * Class to build instances of {@link UpsertCatalogObjectResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject catalogObject;
        private List<CatalogIdMapping> idMappings;



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
         * Setter for catalogObject.
         * @param  catalogObject  CatalogObject value for catalogObject.
         * @return Builder
         */
        public Builder catalogObject(CatalogObject catalogObject) {
            this.catalogObject = catalogObject;
            return this;
        }

        /**
         * Setter for idMappings.
         * @param  idMappings  List of CatalogIdMapping value for idMappings.
         * @return Builder
         */
        public Builder idMappings(List<CatalogIdMapping> idMappings) {
            this.idMappings = idMappings;
            return this;
        }

        /**
         * Builds a new {@link UpsertCatalogObjectResponse} object using the set fields.
         * @return {@link UpsertCatalogObjectResponse}
         */
        public UpsertCatalogObjectResponse build() {
            UpsertCatalogObjectResponse model =
                    new UpsertCatalogObjectResponse(errors, catalogObject, idMappings);
            model.httpContext = httpContext;
            return model;
        }
    }
}

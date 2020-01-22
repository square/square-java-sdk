package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for UpsertCatalogObjectResponse type.
 */
public class UpsertCatalogObjectResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param catalogObject
     * @param idMappings
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

    private HttpContext httpContext;
    private final List<Error> errors;
    private final CatalogObject catalogObject;
    private final List<CatalogIdMapping> idMappings;

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
     * Getter for CatalogObject.
     */
    @JsonGetter("catalog_object")
    public CatalogObject getCatalogObject() {
        return this.catalogObject;
    }

    /**
     * Getter for IdMappings.
     * The mapping between client and server IDs for this upsert.
     */
    @JsonGetter("id_mappings")
    public List<CatalogIdMapping> getIdMappings() {
        return this.idMappings;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, catalogObject, idMappings);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpsertCatalogObjectResponse)) {
            return false;
        }
        UpsertCatalogObjectResponse upsertCatalogObjectResponse = (UpsertCatalogObjectResponse) obj;
        return Objects.equals(errors, upsertCatalogObjectResponse.errors) &&
            Objects.equals(catalogObject, upsertCatalogObjectResponse.catalogObject) &&
            Objects.equals(idMappings, upsertCatalogObjectResponse.idMappings);
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
     * Class to build instances of {@link UpsertCatalogObjectResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject catalogObject;
        private List<CatalogIdMapping> idMappings;

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
         * Setter for catalogObject
         * @param catalogObject
         * @return Builder
         */
        public Builder catalogObject(CatalogObject catalogObject) {
            this.catalogObject = catalogObject;
            return this;
        }
        /**
         * Setter for idMappings
         * @param idMappings
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
            UpsertCatalogObjectResponse model = new UpsertCatalogObjectResponse(errors,
                catalogObject,
                idMappings);
            model.httpContext = httpContext;
            return model;
        }
    }
}

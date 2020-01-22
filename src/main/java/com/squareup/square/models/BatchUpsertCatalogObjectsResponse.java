package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for BatchUpsertCatalogObjectsResponse type.
 */
public class BatchUpsertCatalogObjectsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param objects
     * @param updatedAt
     * @param idMappings
     */
    @JsonCreator
    public BatchUpsertCatalogObjectsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("objects") List<CatalogObject> objects,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("id_mappings") List<CatalogIdMapping> idMappings) {
        this.errors = errors;
        this.objects = objects;
        this.updatedAt = updatedAt;
        this.idMappings = idMappings;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<CatalogObject> objects;
    private final String updatedAt;
    private final List<CatalogIdMapping> idMappings;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on any errors that encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Objects.
     * The created successfully created CatalogObjects.
     */
    @JsonGetter("objects")
    public List<CatalogObject> getObjects() {
        return this.objects;
    }

    /**
     * Getter for UpdatedAt.
     * The database [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) of this update in RFC 3339 format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
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
        return Objects.hash(errors, objects, updatedAt, idMappings);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchUpsertCatalogObjectsResponse)) {
            return false;
        }
        BatchUpsertCatalogObjectsResponse batchUpsertCatalogObjectsResponse = (BatchUpsertCatalogObjectsResponse) obj;
        return Objects.equals(errors, batchUpsertCatalogObjectsResponse.errors) &&
            Objects.equals(objects, batchUpsertCatalogObjectsResponse.objects) &&
            Objects.equals(updatedAt, batchUpsertCatalogObjectsResponse.updatedAt) &&
            Objects.equals(idMappings, batchUpsertCatalogObjectsResponse.idMappings);
    }

    /**
     * Builds a new {@link BatchUpsertCatalogObjectsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchUpsertCatalogObjectsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .objects(getObjects())
            .updatedAt(getUpdatedAt())
            .idMappings(getIdMappings());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchUpsertCatalogObjectsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CatalogObject> objects;
        private String updatedAt;
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
         * Setter for objects
         * @param objects
         * @return Builder
         */
        public Builder objects(List<CatalogObject> objects) {
            this.objects = objects;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
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
         * Builds a new {@link BatchUpsertCatalogObjectsResponse} object using the set fields.
         * @return {@link BatchUpsertCatalogObjectsResponse}
         */
        public BatchUpsertCatalogObjectsResponse build() {
            BatchUpsertCatalogObjectsResponse model = new BatchUpsertCatalogObjectsResponse(errors,
                objects,
                updatedAt,
                idMappings);
            model.httpContext = httpContext;
            return model;
        }
    }
}

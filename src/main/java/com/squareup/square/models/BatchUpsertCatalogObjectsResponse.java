package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class BatchUpsertCatalogObjectsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, objects, updatedAt, idMappings);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchUpsertCatalogObjectsResponse)) {
            return false;
        }
        BatchUpsertCatalogObjectsResponse batchUpsertCatalogObjectsResponse = (BatchUpsertCatalogObjectsResponse) o;
        return Objects.equals(errors, batchUpsertCatalogObjectsResponse.errors) &&
            Objects.equals(objects, batchUpsertCatalogObjectsResponse.objects) &&
            Objects.equals(updatedAt, batchUpsertCatalogObjectsResponse.updatedAt) &&
            Objects.equals(idMappings, batchUpsertCatalogObjectsResponse.idMappings);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .objects(getObjects())
            .updatedAt(getUpdatedAt())
            .idMappings(getIdMappings());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<CatalogObject> objects;
        private String updatedAt;
        private List<CatalogIdMapping> idMappings;

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
        public Builder updatedAt(String value) {
            updatedAt = value;
            return this;
        }
        public Builder idMappings(List<CatalogIdMapping> value) {
            idMappings = value;
            return this;
        }

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

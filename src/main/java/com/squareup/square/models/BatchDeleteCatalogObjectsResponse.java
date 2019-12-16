package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class BatchDeleteCatalogObjectsResponse {

    @JsonCreator
    public BatchDeleteCatalogObjectsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("deleted_object_ids") List<String> deletedObjectIds,
            @JsonProperty("deleted_at") String deletedAt) {
        this.errors = errors;
        this.deletedObjectIds = deletedObjectIds;
        this.deletedAt = deletedAt;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<String> deletedObjectIds;
    private final String deletedAt;

    @Override
    public int hashCode() {
        return Objects.hash(errors, deletedObjectIds, deletedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchDeleteCatalogObjectsResponse)) {
            return false;
        }
        BatchDeleteCatalogObjectsResponse batchDeleteCatalogObjectsResponse = (BatchDeleteCatalogObjectsResponse) o;
        return Objects.equals(errors, batchDeleteCatalogObjectsResponse.errors) &&
            Objects.equals(deletedObjectIds, batchDeleteCatalogObjectsResponse.deletedObjectIds) &&
            Objects.equals(deletedAt, batchDeleteCatalogObjectsResponse.deletedAt);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * The set of Errors encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for DeletedObjectIds.
     * The IDs of all CatalogObjects deleted by this request.
     */
    @JsonGetter("deleted_object_ids")
    public List<String> getDeletedObjectIds() { 
        return this.deletedObjectIds;
    }

    /**
     * Getter for DeletedAt.
     * The database [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) of this deletion in RFC 3339 format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("deleted_at")
    public String getDeletedAt() { 
        return this.deletedAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .deletedObjectIds(getDeletedObjectIds())
            .deletedAt(getDeletedAt());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<String> deletedObjectIds;
        private String deletedAt;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder deletedObjectIds(List<String> value) {
            deletedObjectIds = value;
            return this;
        }
        public Builder deletedAt(String value) {
            deletedAt = value;
            return this;
        }

        public BatchDeleteCatalogObjectsResponse build() {
            BatchDeleteCatalogObjectsResponse model = new BatchDeleteCatalogObjectsResponse(errors,
                deletedObjectIds,
                deletedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}

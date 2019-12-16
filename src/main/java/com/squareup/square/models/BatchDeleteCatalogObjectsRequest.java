package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class BatchDeleteCatalogObjectsRequest {

    @JsonCreator
    public BatchDeleteCatalogObjectsRequest(
            @JsonProperty("object_ids") List<String> objectIds) {
        this.objectIds = objectIds;
    }

    private final List<String> objectIds;

    @Override
    public int hashCode() {
        return Objects.hash(objectIds);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchDeleteCatalogObjectsRequest)) {
            return false;
        }
        BatchDeleteCatalogObjectsRequest batchDeleteCatalogObjectsRequest = (BatchDeleteCatalogObjectsRequest) o;
        return Objects.equals(objectIds, batchDeleteCatalogObjectsRequest.objectIds);
    }

    /**
     * Getter for ObjectIds.
     * The IDs of the CatalogObjects to be deleted. When an object is deleted, other objects
     * in the graph that depend on that object will be deleted as well (for example, deleting a
     * CatalogItem will delete its CatalogItemVariation.
     */
    @JsonGetter("object_ids")
    public List<String> getObjectIds() { 
        return this.objectIds;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .objectIds(getObjectIds());
            return builder;
    }

    public static class Builder {
        private List<String> objectIds;

        public Builder() { }

        public Builder objectIds(List<String> value) {
            objectIds = value;
            return this;
        }

        public BatchDeleteCatalogObjectsRequest build() {
            return new BatchDeleteCatalogObjectsRequest(objectIds);
        }
    }
}

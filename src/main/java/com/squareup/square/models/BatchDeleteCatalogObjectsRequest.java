package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BatchDeleteCatalogObjectsRequest type.
 */
public class BatchDeleteCatalogObjectsRequest {

    /**
     * Initialization constructor.
     * @param objectIds
     */
    @JsonCreator
    public BatchDeleteCatalogObjectsRequest(
            @JsonProperty("object_ids") List<String> objectIds) {
        this.objectIds = objectIds;
    }

    private final List<String> objectIds;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(objectIds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchDeleteCatalogObjectsRequest)) {
            return false;
        }
        BatchDeleteCatalogObjectsRequest batchDeleteCatalogObjectsRequest = (BatchDeleteCatalogObjectsRequest) obj;
        return Objects.equals(objectIds, batchDeleteCatalogObjectsRequest.objectIds);
    }

    /**
     * Builds a new {@link BatchDeleteCatalogObjectsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchDeleteCatalogObjectsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .objectIds(getObjectIds());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchDeleteCatalogObjectsRequest}
     */
    public static class Builder {
        private List<String> objectIds;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for objectIds
         * @param objectIds
         * @return Builder
         */
        public Builder objectIds(List<String> objectIds) {
            this.objectIds = objectIds;
            return this;
        }

        /**
         * Builds a new {@link BatchDeleteCatalogObjectsRequest} object using the set fields.
         * @return {@link BatchDeleteCatalogObjectsRequest}
         */
        public BatchDeleteCatalogObjectsRequest build() {
            return new BatchDeleteCatalogObjectsRequest(objectIds);
        }
    }
}

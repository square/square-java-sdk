package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class BatchRetrieveCatalogObjectsRequest {

    @JsonCreator
    public BatchRetrieveCatalogObjectsRequest(
            @JsonProperty("object_ids") List<String> objectIds,
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects) {
        this.objectIds = objectIds;
        this.includeRelatedObjects = includeRelatedObjects;
    }

    private final List<String> objectIds;
    private final Boolean includeRelatedObjects;

    @Override
    public int hashCode() {
        return Objects.hash(objectIds, includeRelatedObjects);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchRetrieveCatalogObjectsRequest)) {
            return false;
        }
        BatchRetrieveCatalogObjectsRequest batchRetrieveCatalogObjectsRequest = (BatchRetrieveCatalogObjectsRequest) o;
        return Objects.equals(objectIds, batchRetrieveCatalogObjectsRequest.objectIds) &&
            Objects.equals(includeRelatedObjects, batchRetrieveCatalogObjectsRequest.includeRelatedObjects);
    }

    /**
     * Getter for ObjectIds.
     * The IDs of the CatalogObjects to be retrieved.
     */
    @JsonGetter("object_ids")
    public List<String> getObjectIds() { 
        return this.objectIds;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the
     * requested objects, as follows:
     * If the `objects` field of the response contains a CatalogItem, its associated
     * CatalogCategory objects, CatalogTax objects, CatalogImage objects and
     * CatalogModifierLists will be returned in the `related_objects` field of the
     * response. If the `objects` field of the response contains a CatalogItemVariation,
     * its parent CatalogItem will be returned in the `related_objects` field of
     * the response.
     */
    @JsonGetter("include_related_objects")
    public Boolean getIncludeRelatedObjects() { 
        return this.includeRelatedObjects;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(objectIds)
            .includeRelatedObjects(getIncludeRelatedObjects());
            return builder;
    }

    public static class Builder {
        private List<String> objectIds;
        private Boolean includeRelatedObjects;

        public Builder(List<String> objectIds) {
            this.objectIds = objectIds;
        }

        public Builder objectIds(List<String> value) {
            objectIds = value;
            return this;
        }
        public Builder includeRelatedObjects(Boolean value) {
            includeRelatedObjects = value;
            return this;
        }

        public BatchRetrieveCatalogObjectsRequest build() {
            return new BatchRetrieveCatalogObjectsRequest(objectIds,
                includeRelatedObjects);
        }
    }
}

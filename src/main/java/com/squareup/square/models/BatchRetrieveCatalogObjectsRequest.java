
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for BatchRetrieveCatalogObjectsRequest type.
 */
public class BatchRetrieveCatalogObjectsRequest {
    private final List<String> objectIds;
    private final Boolean includeRelatedObjects;

    /**
     * Initialization constructor.
     * @param objectIds List of String value for objectIds.
     * @param includeRelatedObjects Boolean value for includeRelatedObjects.
     */
    @JsonCreator
    public BatchRetrieveCatalogObjectsRequest(
            @JsonProperty("object_ids") List<String> objectIds,
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects) {
        this.objectIds = objectIds;
        this.includeRelatedObjects = includeRelatedObjects;
    }

    /**
     * Getter for ObjectIds.
     * The IDs of the CatalogObjects to be retrieved.
     * @return Returns the List of String
     */
    @JsonGetter("object_ids")
    public List<String> getObjectIds() {
        return this.objectIds;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the requested
     * objects, as follows: If the `objects` field of the response contains a CatalogItem, its
     * associated CatalogCategory objects, CatalogTax objects, CatalogImage objects and
     * CatalogModifierLists will be returned in the `related_objects` field of the response. If the
     * `objects` field of the response contains a CatalogItemVariation, its parent CatalogItem will
     * be returned in the `related_objects` field of the response.
     * @return Returns the Boolean
     */
    @JsonGetter("include_related_objects")
    public Boolean getIncludeRelatedObjects() {
        return this.includeRelatedObjects;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(objectIds, includeRelatedObjects);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchRetrieveCatalogObjectsRequest)) {
            return false;
        }
        BatchRetrieveCatalogObjectsRequest other = (BatchRetrieveCatalogObjectsRequest) obj;
        return Objects.equals(objectIds, other.objectIds)
            && Objects.equals(includeRelatedObjects, other.includeRelatedObjects);
    }

    /**
     * Builds a new {@link BatchRetrieveCatalogObjectsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveCatalogObjectsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(objectIds)
            .includeRelatedObjects(getIncludeRelatedObjects());
        return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveCatalogObjectsRequest}.
     */
    public static class Builder {
        private List<String> objectIds;
        private Boolean includeRelatedObjects;

        /**
         * Initialization constructor.
         * @param objectIds List of String value for objectIds.
         */
        public Builder(List<String> objectIds) {
            this.objectIds = objectIds;
        }

        /**
         * Setter for objectIds.
         * @param objectIds List of String value for objectIds.
         * @return Builder
         */
        public Builder objectIds(List<String> objectIds) {
            this.objectIds = objectIds;
            return this;
        }

        /**
         * Setter for includeRelatedObjects.
         * @param includeRelatedObjects Boolean value for includeRelatedObjects.
         * @return Builder
         */
        public Builder includeRelatedObjects(Boolean includeRelatedObjects) {
            this.includeRelatedObjects = includeRelatedObjects;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveCatalogObjectsRequest} object using the set fields.
         * @return {@link BatchRetrieveCatalogObjectsRequest}
         */
        public BatchRetrieveCatalogObjectsRequest build() {
            return new BatchRetrieveCatalogObjectsRequest(objectIds,
                includeRelatedObjects);
        }
    }
}

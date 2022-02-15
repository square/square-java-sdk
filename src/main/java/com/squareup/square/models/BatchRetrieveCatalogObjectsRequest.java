
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveCatalogObjectsRequest type.
 */
public class BatchRetrieveCatalogObjectsRequest {
    private final List<String> objectIds;
    private final Boolean includeRelatedObjects;
    private final Long catalogVersion;

    /**
     * Initialization constructor.
     * @param  objectIds  List of String value for objectIds.
     * @param  includeRelatedObjects  Boolean value for includeRelatedObjects.
     * @param  catalogVersion  Long value for catalogVersion.
     */
    @JsonCreator
    public BatchRetrieveCatalogObjectsRequest(
            @JsonProperty("object_ids") List<String> objectIds,
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects,
            @JsonProperty("catalog_version") Long catalogVersion) {
        this.objectIds = objectIds;
        this.includeRelatedObjects = includeRelatedObjects;
        this.catalogVersion = catalogVersion;
    }

    /**
     * Getter for ObjectIds.
     * The IDs of the CatalogObjects to be retrieved.
     * @return Returns the List of String
     */
    @JsonGetter("object_ids")
    public List<String> getObjectIds() {
        return objectIds;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the requested
     * objects. Related objects are defined as any objects referenced by ID by the results in the
     * `objects` field of the response. These objects are put in the `related_objects` field.
     * Setting this to `true` is helpful when the objects are needed for immediate display to a
     * user. This process only goes one level deep. Objects referenced by the related objects will
     * not be included. For example, if the `objects` field of the response contains a CatalogItem,
     * its associated CatalogCategory objects, CatalogTax objects, CatalogImage objects and
     * CatalogModifierLists will be returned in the `related_objects` field of the response. If the
     * `objects` field of the response contains a CatalogItemVariation, its parent CatalogItem will
     * be returned in the `related_objects` field of the response. Default value: `false`
     * @return Returns the Boolean
     */
    @JsonGetter("include_related_objects")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIncludeRelatedObjects() {
        return includeRelatedObjects;
    }

    /**
     * Getter for CatalogVersion.
     * The specific version of the catalog objects to be included in the response. This allows you
     * to retrieve historical versions of objects. The specified version value is matched against
     * the [CatalogObject]($m/CatalogObject)s' `version` attribute. If not included, results will be
     * from the current version of the catalog.
     * @return Returns the Long
     */
    @JsonGetter("catalog_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getCatalogVersion() {
        return catalogVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectIds, includeRelatedObjects, catalogVersion);
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
            && Objects.equals(includeRelatedObjects, other.includeRelatedObjects)
            && Objects.equals(catalogVersion, other.catalogVersion);
    }

    /**
     * Converts this BatchRetrieveCatalogObjectsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveCatalogObjectsRequest [" + "objectIds=" + objectIds
                + ", includeRelatedObjects=" + includeRelatedObjects + ", catalogVersion="
                + catalogVersion + "]";
    }

    /**
     * Builds a new {@link BatchRetrieveCatalogObjectsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveCatalogObjectsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(objectIds)
                .includeRelatedObjects(getIncludeRelatedObjects())
                .catalogVersion(getCatalogVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveCatalogObjectsRequest}.
     */
    public static class Builder {
        private List<String> objectIds;
        private Boolean includeRelatedObjects;
        private Long catalogVersion;

        /**
         * Initialization constructor.
         * @param  objectIds  List of String value for objectIds.
         */
        public Builder(List<String> objectIds) {
            this.objectIds = objectIds;
        }

        /**
         * Setter for objectIds.
         * @param  objectIds  List of String value for objectIds.
         * @return Builder
         */
        public Builder objectIds(List<String> objectIds) {
            this.objectIds = objectIds;
            return this;
        }

        /**
         * Setter for includeRelatedObjects.
         * @param  includeRelatedObjects  Boolean value for includeRelatedObjects.
         * @return Builder
         */
        public Builder includeRelatedObjects(Boolean includeRelatedObjects) {
            this.includeRelatedObjects = includeRelatedObjects;
            return this;
        }

        /**
         * Setter for catalogVersion.
         * @param  catalogVersion  Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = catalogVersion;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveCatalogObjectsRequest} object using the set fields.
         * @return {@link BatchRetrieveCatalogObjectsRequest}
         */
        public BatchRetrieveCatalogObjectsRequest build() {
            return new BatchRetrieveCatalogObjectsRequest(objectIds, includeRelatedObjects,
                    catalogVersion);
        }
    }
}

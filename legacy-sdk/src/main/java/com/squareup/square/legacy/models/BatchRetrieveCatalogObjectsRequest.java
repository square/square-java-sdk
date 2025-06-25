package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveCatalogObjectsRequest type.
 */
public class BatchRetrieveCatalogObjectsRequest {
    private final List<String> objectIds;
    private final OptionalNullable<Boolean> includeRelatedObjects;
    private final OptionalNullable<Long> catalogVersion;
    private final OptionalNullable<Boolean> includeDeletedObjects;
    private final OptionalNullable<Boolean> includeCategoryPathToRoot;

    /**
     * Initialization constructor.
     * @param  objectIds  List of String value for objectIds.
     * @param  includeRelatedObjects  Boolean value for includeRelatedObjects.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  includeDeletedObjects  Boolean value for includeDeletedObjects.
     * @param  includeCategoryPathToRoot  Boolean value for includeCategoryPathToRoot.
     */
    @JsonCreator
    public BatchRetrieveCatalogObjectsRequest(
            @JsonProperty("object_ids") List<String> objectIds,
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects,
            @JsonProperty("catalog_version") Long catalogVersion,
            @JsonProperty("include_deleted_objects") Boolean includeDeletedObjects,
            @JsonProperty("include_category_path_to_root") Boolean includeCategoryPathToRoot) {
        this.objectIds = objectIds;
        this.includeRelatedObjects = OptionalNullable.of(includeRelatedObjects);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
        this.includeDeletedObjects = OptionalNullable.of(includeDeletedObjects);
        this.includeCategoryPathToRoot = OptionalNullable.of(includeCategoryPathToRoot);
    }

    /**
     * Initialization constructor.
     * @param  objectIds  List of String value for objectIds.
     * @param  includeRelatedObjects  Boolean value for includeRelatedObjects.
     * @param  catalogVersion  Long value for catalogVersion.
     * @param  includeDeletedObjects  Boolean value for includeDeletedObjects.
     * @param  includeCategoryPathToRoot  Boolean value for includeCategoryPathToRoot.
     */
    protected BatchRetrieveCatalogObjectsRequest(
            List<String> objectIds,
            OptionalNullable<Boolean> includeRelatedObjects,
            OptionalNullable<Long> catalogVersion,
            OptionalNullable<Boolean> includeDeletedObjects,
            OptionalNullable<Boolean> includeCategoryPathToRoot) {
        this.objectIds = objectIds;
        this.includeRelatedObjects = includeRelatedObjects;
        this.catalogVersion = catalogVersion;
        this.includeDeletedObjects = includeDeletedObjects;
        this.includeCategoryPathToRoot = includeCategoryPathToRoot;
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
     * Internal Getter for IncludeRelatedObjects.
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
     * @return Returns the Internal Boolean
     */
    @JsonGetter("include_related_objects")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIncludeRelatedObjects() {
        return this.includeRelatedObjects;
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
    @JsonIgnore
    public Boolean getIncludeRelatedObjects() {
        return OptionalNullable.getFrom(includeRelatedObjects);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The specific version of the catalog objects to be included in the response. This allows you
     * to retrieve historical versions of objects. The specified version value is matched against
     * the [CatalogObject]($m/CatalogObject)s' `version` attribute. If not included, results will be
     * from the current version of the catalog.
     * @return Returns the Internal Long
     */
    @JsonGetter("catalog_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetCatalogVersion() {
        return this.catalogVersion;
    }

    /**
     * Getter for CatalogVersion.
     * The specific version of the catalog objects to be included in the response. This allows you
     * to retrieve historical versions of objects. The specified version value is matched against
     * the [CatalogObject]($m/CatalogObject)s' `version` attribute. If not included, results will be
     * from the current version of the catalog.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
    }

    /**
     * Internal Getter for IncludeDeletedObjects.
     * Indicates whether to include (`true`) or not (`false`) in the response deleted objects,
     * namely, those with the `is_deleted` attribute set to `true`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("include_deleted_objects")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIncludeDeletedObjects() {
        return this.includeDeletedObjects;
    }

    /**
     * Getter for IncludeDeletedObjects.
     * Indicates whether to include (`true`) or not (`false`) in the response deleted objects,
     * namely, those with the `is_deleted` attribute set to `true`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIncludeDeletedObjects() {
        return OptionalNullable.getFrom(includeDeletedObjects);
    }

    /**
     * Internal Getter for IncludeCategoryPathToRoot.
     * Specifies whether or not to include the `path_to_root` list for each returned category
     * instance. The `path_to_root` list consists of `CategoryPathToRootNode` objects and specifies
     * the path that starts with the immediate parent category of the returned category and ends
     * with its root category. If the returned category is a top-level category, the `path_to_root`
     * list is empty and is not returned in the response payload.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("include_category_path_to_root")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIncludeCategoryPathToRoot() {
        return this.includeCategoryPathToRoot;
    }

    /**
     * Getter for IncludeCategoryPathToRoot.
     * Specifies whether or not to include the `path_to_root` list for each returned category
     * instance. The `path_to_root` list consists of `CategoryPathToRootNode` objects and specifies
     * the path that starts with the immediate parent category of the returned category and ends
     * with its root category. If the returned category is a top-level category, the `path_to_root`
     * list is empty and is not returned in the response payload.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIncludeCategoryPathToRoot() {
        return OptionalNullable.getFrom(includeCategoryPathToRoot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                objectIds, includeRelatedObjects, catalogVersion, includeDeletedObjects, includeCategoryPathToRoot);
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
                && Objects.equals(catalogVersion, other.catalogVersion)
                && Objects.equals(includeDeletedObjects, other.includeDeletedObjects)
                && Objects.equals(includeCategoryPathToRoot, other.includeCategoryPathToRoot);
    }

    /**
     * Converts this BatchRetrieveCatalogObjectsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveCatalogObjectsRequest [" + "objectIds=" + objectIds
                + ", includeRelatedObjects=" + includeRelatedObjects + ", catalogVersion="
                + catalogVersion + ", includeDeletedObjects=" + includeDeletedObjects
                + ", includeCategoryPathToRoot=" + includeCategoryPathToRoot + "]";
    }

    /**
     * Builds a new {@link BatchRetrieveCatalogObjectsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveCatalogObjectsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(objectIds);
        builder.includeRelatedObjects = internalGetIncludeRelatedObjects();
        builder.catalogVersion = internalGetCatalogVersion();
        builder.includeDeletedObjects = internalGetIncludeDeletedObjects();
        builder.includeCategoryPathToRoot = internalGetIncludeCategoryPathToRoot();
        return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveCatalogObjectsRequest}.
     */
    public static class Builder {
        private List<String> objectIds;
        private OptionalNullable<Boolean> includeRelatedObjects;
        private OptionalNullable<Long> catalogVersion;
        private OptionalNullable<Boolean> includeDeletedObjects;
        private OptionalNullable<Boolean> includeCategoryPathToRoot;

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
            this.includeRelatedObjects = OptionalNullable.of(includeRelatedObjects);
            return this;
        }

        /**
         * UnSetter for includeRelatedObjects.
         * @return Builder
         */
        public Builder unsetIncludeRelatedObjects() {
            includeRelatedObjects = null;
            return this;
        }

        /**
         * Setter for catalogVersion.
         * @param  catalogVersion  Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = OptionalNullable.of(catalogVersion);
            return this;
        }

        /**
         * UnSetter for catalogVersion.
         * @return Builder
         */
        public Builder unsetCatalogVersion() {
            catalogVersion = null;
            return this;
        }

        /**
         * Setter for includeDeletedObjects.
         * @param  includeDeletedObjects  Boolean value for includeDeletedObjects.
         * @return Builder
         */
        public Builder includeDeletedObjects(Boolean includeDeletedObjects) {
            this.includeDeletedObjects = OptionalNullable.of(includeDeletedObjects);
            return this;
        }

        /**
         * UnSetter for includeDeletedObjects.
         * @return Builder
         */
        public Builder unsetIncludeDeletedObjects() {
            includeDeletedObjects = null;
            return this;
        }

        /**
         * Setter for includeCategoryPathToRoot.
         * @param  includeCategoryPathToRoot  Boolean value for includeCategoryPathToRoot.
         * @return Builder
         */
        public Builder includeCategoryPathToRoot(Boolean includeCategoryPathToRoot) {
            this.includeCategoryPathToRoot = OptionalNullable.of(includeCategoryPathToRoot);
            return this;
        }

        /**
         * UnSetter for includeCategoryPathToRoot.
         * @return Builder
         */
        public Builder unsetIncludeCategoryPathToRoot() {
            includeCategoryPathToRoot = null;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveCatalogObjectsRequest} object using the set fields.
         * @return {@link BatchRetrieveCatalogObjectsRequest}
         */
        public BatchRetrieveCatalogObjectsRequest build() {
            return new BatchRetrieveCatalogObjectsRequest(
                    objectIds, includeRelatedObjects, catalogVersion, includeDeletedObjects, includeCategoryPathToRoot);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RetrieveCatalogObjectRequest type.
 */
public class RetrieveCatalogObjectRequest {
    private final Boolean includeRelatedObjects;
    private final Long catalogVersion;

    /**
     * Initialization constructor.
     * @param includeRelatedObjects Boolean value for includeRelatedObjects.
     * @param catalogVersion Long value for catalogVersion.
     */
    @JsonCreator
    public RetrieveCatalogObjectRequest(
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects,
            @JsonProperty("catalog_version") Long catalogVersion) {
        this.includeRelatedObjects = includeRelatedObjects;
        this.catalogVersion = catalogVersion;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the requested
     * object, as follows: If the `object` field of the response contains a `CatalogItem`, its
     * associated `CatalogCategory`, `CatalogTax`, `CatalogImage` and `CatalogModifierList` objects
     * will be returned in the `related_objects` field of the response. If the `object` field of the
     * response contains a `CatalogItemVariation`, its parent `CatalogItem` will be returned in the
     * `related_objects` field of the response. Default value: `false`
     * @return Returns the Boolean
     */
    @JsonGetter("include_related_objects")
    public Boolean getIncludeRelatedObjects() {
        return this.includeRelatedObjects;
    }

    /**
     * Getter for CatalogVersion.
     * Requests objects as of a specific version of the catalog. This allows you to retrieve
     * historical versions of objects. The value to retrieve a specific version of an object can be
     * found in the version field of [CatalogObject](#type-catalogobject)s.
     * @return Returns the Long
     */
    @JsonGetter("catalog_version")
    public Long getCatalogVersion() {
        return this.catalogVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(includeRelatedObjects, catalogVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCatalogObjectRequest)) {
            return false;
        }
        RetrieveCatalogObjectRequest other = (RetrieveCatalogObjectRequest) obj;
        return Objects.equals(includeRelatedObjects, other.includeRelatedObjects)
            && Objects.equals(catalogVersion, other.catalogVersion);
    }

    /**
     * Converts this RetrieveCatalogObjectRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveCatalogObjectRequest [" + "includeRelatedObjects=" + includeRelatedObjects
                + ", catalogVersion=" + catalogVersion + "]";
    }

    /**
     * Builds a new {@link RetrieveCatalogObjectRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCatalogObjectRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .includeRelatedObjects(getIncludeRelatedObjects())
                .catalogVersion(getCatalogVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCatalogObjectRequest}.
     */
    public static class Builder {
        private Boolean includeRelatedObjects;
        private Long catalogVersion;



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
         * Setter for catalogVersion.
         * @param catalogVersion Long value for catalogVersion.
         * @return Builder
         */
        public Builder catalogVersion(Long catalogVersion) {
            this.catalogVersion = catalogVersion;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCatalogObjectRequest} object using the set fields.
         * @return {@link RetrieveCatalogObjectRequest}
         */
        public RetrieveCatalogObjectRequest build() {
            return new RetrieveCatalogObjectRequest(includeRelatedObjects, catalogVersion);
        }
    }
}

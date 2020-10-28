
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for VersionedCatalogObject type.
 */
public class VersionedCatalogObject {
    private final String objectId;
    private final Long catalogVersion;

    /**
     * Initialization constructor.
     * @param objectId String value for objectId.
     * @param catalogVersion Long value for catalogVersion.
     */
    @JsonCreator
    public VersionedCatalogObject(
            @JsonProperty("object_id") String objectId,
            @JsonProperty("catalog_version") Long catalogVersion) {
        this.objectId = objectId;
        this.catalogVersion = catalogVersion;
    }

    /**
     * Getter for ObjectId.
     * The ID of the referenced object.
     * @return Returns the String
     */
    @JsonGetter("object_id")
    public String getObjectId() {
        return this.objectId;
    }

    /**
     * Getter for CatalogVersion.
     * The version of the object.
     * @return Returns the Long
     */
    @JsonGetter("catalog_version")
    public Long getCatalogVersion() {
        return this.catalogVersion;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(objectId, catalogVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VersionedCatalogObject)) {
            return false;
        }
        VersionedCatalogObject other = (VersionedCatalogObject) obj;
        return Objects.equals(objectId, other.objectId)
            && Objects.equals(catalogVersion, other.catalogVersion);
    }

    /**
     * Builds a new {@link VersionedCatalogObject.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link VersionedCatalogObject.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .objectId(getObjectId())
            .catalogVersion(getCatalogVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link VersionedCatalogObject}.
     */
    public static class Builder {
        private String objectId;
        private Long catalogVersion;



        /**
         * Setter for objectId.
         * @param objectId String value for objectId.
         * @return Builder
         */
        public Builder objectId(String objectId) {
            this.objectId = objectId;
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
         * Builds a new {@link VersionedCatalogObject} object using the set fields.
         * @return {@link VersionedCatalogObject}
         */
        public VersionedCatalogObject build() {
            return new VersionedCatalogObject(objectId,
                catalogVersion);
        }
    }
}

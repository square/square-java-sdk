
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CatalogObjectReference type.
 */
public class CatalogObjectReference {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String objectId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long catalogVersion;

    /**
     * Initialization constructor.
     * @param  objectId  String value for objectId.
     * @param  catalogVersion  Long value for catalogVersion.
     */
    @JsonCreator
    public CatalogObjectReference(
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
        return objectId;
    }

    /**
     * Getter for CatalogVersion.
     * The version of the object.
     * @return Returns the Long
     */
    @JsonGetter("catalog_version")
    public Long getCatalogVersion() {
        return catalogVersion;
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
        if (!(obj instanceof CatalogObjectReference)) {
            return false;
        }
        CatalogObjectReference other = (CatalogObjectReference) obj;
        return Objects.equals(objectId, other.objectId)
            && Objects.equals(catalogVersion, other.catalogVersion);
    }

    /**
     * Converts this CatalogObjectReference into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogObjectReference [" + "objectId=" + objectId + ", catalogVersion="
                + catalogVersion + "]";
    }

    /**
     * Builds a new {@link CatalogObjectReference.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogObjectReference.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .objectId(getObjectId())
                .catalogVersion(getCatalogVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogObjectReference}.
     */
    public static class Builder {
        private String objectId;
        private Long catalogVersion;



        /**
         * Setter for objectId.
         * @param  objectId  String value for objectId.
         * @return Builder
         */
        public Builder objectId(String objectId) {
            this.objectId = objectId;
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
         * Builds a new {@link CatalogObjectReference} object using the set fields.
         * @return {@link CatalogObjectReference}
         */
        public CatalogObjectReference build() {
            return new CatalogObjectReference(objectId, catalogVersion);
        }
    }
}

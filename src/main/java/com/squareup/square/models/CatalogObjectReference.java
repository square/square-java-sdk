
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CatalogObjectReference type.
 */
public class CatalogObjectReference {
    private final OptionalNullable<String> objectId;
    private final OptionalNullable<Long> catalogVersion;

    /**
     * Initialization constructor.
     * @param  objectId  String value for objectId.
     * @param  catalogVersion  Long value for catalogVersion.
     */
    @JsonCreator
    public CatalogObjectReference(
            @JsonProperty("object_id") String objectId,
            @JsonProperty("catalog_version") Long catalogVersion) {
        this.objectId = OptionalNullable.of(objectId);
        this.catalogVersion = OptionalNullable.of(catalogVersion);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogObjectReference(OptionalNullable<String> objectId,
            OptionalNullable<Long> catalogVersion) {
        this.objectId = objectId;
        this.catalogVersion = catalogVersion;
    }

    /**
     * Internal Getter for ObjectId.
     * The ID of the referenced object.
     * @return Returns the Internal String
     */
    @JsonGetter("object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetObjectId() {
        return this.objectId;
    }

    /**
     * Getter for ObjectId.
     * The ID of the referenced object.
     * @return Returns the String
     */
    @JsonIgnore
    public String getObjectId() {
        return OptionalNullable.getFrom(objectId);
    }

    /**
     * Internal Getter for CatalogVersion.
     * The version of the object.
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
     * The version of the object.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getCatalogVersion() {
        return OptionalNullable.getFrom(catalogVersion);
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
        Builder builder = new Builder();
        builder.objectId = internalGetObjectId();
        builder.catalogVersion = internalGetCatalogVersion();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogObjectReference}.
     */
    public static class Builder {
        private OptionalNullable<String> objectId;
        private OptionalNullable<Long> catalogVersion;



        /**
         * Setter for objectId.
         * @param  objectId  String value for objectId.
         * @return Builder
         */
        public Builder objectId(String objectId) {
            this.objectId = OptionalNullable.of(objectId);
            return this;
        }

        /**
         * UnSetter for objectId.
         * @return Builder
         */
        public Builder unsetObjectId() {
            objectId = null;
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
         * Builds a new {@link CatalogObjectReference} object using the set fields.
         * @return {@link CatalogObjectReference}
         */
        public CatalogObjectReference build() {
            return new CatalogObjectReference(objectId, catalogVersion);
        }
    }
}

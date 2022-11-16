
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
 * This is a model class for CatalogV1Id type.
 */
public class CatalogV1Id {
    private final OptionalNullable<String> catalogV1Id;
    private final OptionalNullable<String> locationId;

    /**
     * Initialization constructor.
     * @param  catalogV1Id  String value for catalogV1Id.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public CatalogV1Id(
            @JsonProperty("catalog_v1_id") String catalogV1Id,
            @JsonProperty("location_id") String locationId) {
        this.catalogV1Id = OptionalNullable.of(catalogV1Id);
        this.locationId = OptionalNullable.of(locationId);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogV1Id(OptionalNullable<String> catalogV1Id,
            OptionalNullable<String> locationId) {
        this.catalogV1Id = catalogV1Id;
        this.locationId = locationId;
    }

    /**
     * Internal Getter for CatalogV1Id.
     * The ID for an object used in the Square API V1, if the object ID differs from the Square API
     * V2 object ID.
     * @return Returns the Internal String
     */
    @JsonGetter("catalog_v1_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCatalogV1Id() {
        return this.catalogV1Id;
    }

    /**
     * Getter for CatalogV1Id.
     * The ID for an object used in the Square API V1, if the object ID differs from the Square API
     * V2 object ID.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogV1Id() {
        return OptionalNullable.getFrom(catalogV1Id);
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the `Location` this Connect V1 ID is associated with.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the `Location` this Connect V1 ID is associated with.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogV1Id, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogV1Id)) {
            return false;
        }
        CatalogV1Id other = (CatalogV1Id) obj;
        return Objects.equals(catalogV1Id, other.catalogV1Id)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this CatalogV1Id into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogV1Id [" + "catalogV1Id=" + catalogV1Id + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link CatalogV1Id.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogV1Id.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.catalogV1Id = internalGetCatalogV1Id();
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogV1Id}.
     */
    public static class Builder {
        private OptionalNullable<String> catalogV1Id;
        private OptionalNullable<String> locationId;



        /**
         * Setter for catalogV1Id.
         * @param  catalogV1Id  String value for catalogV1Id.
         * @return Builder
         */
        public Builder catalogV1Id(String catalogV1Id) {
            this.catalogV1Id = OptionalNullable.of(catalogV1Id);
            return this;
        }

        /**
         * UnSetter for catalogV1Id.
         * @return Builder
         */
        public Builder unsetCatalogV1Id() {
            catalogV1Id = null;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogV1Id} object using the set fields.
         * @return {@link CatalogV1Id}
         */
        public CatalogV1Id build() {
            return new CatalogV1Id(catalogV1Id, locationId);
        }
    }
}

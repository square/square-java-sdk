package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogV1Id type.
 */
public class CatalogV1Id {

    /**
     * Initialization constructor.
     * @param catalogV1Id
     * @param locationId
     */
    @JsonCreator
    public CatalogV1Id(
            @JsonProperty("catalog_v1_id") String catalogV1Id,
            @JsonProperty("location_id") String locationId) {
        this.catalogV1Id = catalogV1Id;
        this.locationId = locationId;
    }

    private final String catalogV1Id;
    private final String locationId;
    /**
     * Getter for CatalogV1Id.
     * The ID for an object in Connect V1, if different from its Connect V2 ID.
     */
    @JsonGetter("catalog_v1_id")
    public String getCatalogV1Id() {
        return this.catalogV1Id;
    }

    /**
     * Getter for LocationId.
     * The ID of the `Location` this Connect V1 ID is associated with.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(catalogV1Id, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogV1Id)) {
            return false;
        }
        CatalogV1Id catalogV1Id = (CatalogV1Id) obj;
        return Objects.equals(catalogV1Id, catalogV1Id.catalogV1Id) &&
            Objects.equals(locationId, catalogV1Id.locationId);
    }

    /**
     * Builds a new {@link CatalogV1Id.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogV1Id.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogV1Id(getCatalogV1Id())
            .locationId(getLocationId());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogV1Id}
     */
    public static class Builder {
        private String catalogV1Id;
        private String locationId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for catalogV1Id
         * @param catalogV1Id
         * @return Builder
         */
        public Builder catalogV1Id(String catalogV1Id) {
            this.catalogV1Id = catalogV1Id;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link CatalogV1Id} object using the set fields.
         * @return {@link CatalogV1Id}
         */
        public CatalogV1Id build() {
            return new CatalogV1Id(catalogV1Id,
                locationId);
        }
    }
}

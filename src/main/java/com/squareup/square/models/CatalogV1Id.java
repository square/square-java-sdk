package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CatalogV1Id {

    @JsonCreator
    public CatalogV1Id(
            @JsonProperty("catalog_v1_id") String catalogV1Id,
            @JsonProperty("location_id") String locationId) {
        this.catalogV1Id = catalogV1Id;
        this.locationId = locationId;
    }

    private final String catalogV1Id;
    private final String locationId;

    @Override
    public int hashCode() {
        return Objects.hash(catalogV1Id, locationId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogV1Id)) {
            return false;
        }
        CatalogV1Id catalogV1Id = (CatalogV1Id) o;
        return Objects.equals(catalogV1Id, catalogV1Id.catalogV1Id) &&
            Objects.equals(locationId, catalogV1Id.locationId);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogV1Id(getCatalogV1Id())
            .locationId(getLocationId());
            return builder;
    }

    public static class Builder {
        private String catalogV1Id;
        private String locationId;

        public Builder() { }

        public Builder catalogV1Id(String value) {
            catalogV1Id = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }

        public CatalogV1Id build() {
            return new CatalogV1Id(catalogV1Id,
                locationId);
        }
    }
}

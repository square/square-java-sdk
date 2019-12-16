package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class BatchRetrieveInventoryCountsRequest {

    @JsonCreator
    public BatchRetrieveInventoryCountsRequest(
            @JsonProperty("catalog_object_ids") List<String> catalogObjectIds,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("updated_after") String updatedAfter,
            @JsonProperty("cursor") String cursor) {
        this.catalogObjectIds = catalogObjectIds;
        this.locationIds = locationIds;
        this.updatedAfter = updatedAfter;
        this.cursor = cursor;
    }

    private final List<String> catalogObjectIds;
    private final List<String> locationIds;
    private final String updatedAfter;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectIds, locationIds, updatedAfter, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatchRetrieveInventoryCountsRequest)) {
            return false;
        }
        BatchRetrieveInventoryCountsRequest batchRetrieveInventoryCountsRequest = (BatchRetrieveInventoryCountsRequest) o;
        return Objects.equals(catalogObjectIds, batchRetrieveInventoryCountsRequest.catalogObjectIds) &&
            Objects.equals(locationIds, batchRetrieveInventoryCountsRequest.locationIds) &&
            Objects.equals(updatedAfter, batchRetrieveInventoryCountsRequest.updatedAfter) &&
            Objects.equals(cursor, batchRetrieveInventoryCountsRequest.cursor);
    }

    /**
     * Getter for CatalogObjectIds.
     * Filters results by `CatalogObject` ID.
     * Only applied when set. Default: unset.
     */
    @JsonGetter("catalog_object_ids")
    public List<String> getCatalogObjectIds() { 
        return this.catalogObjectIds;
    }

    /**
     * Getter for LocationIds.
     * Filters results by `Location` ID. Only
     * applied when set. Default: unset.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() { 
        return this.locationIds;
    }

    /**
     * Getter for UpdatedAfter.
     * Provided as an RFC 3339 timestamp. Returns results whose
     * `calculated_at` value is after the given time. Default: UNIX epoch
     * (`1970-01-01T00:00:00Z`).
     */
    @JsonGetter("updated_after")
    public String getUpdatedAfter() { 
        return this.updatedAfter;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for the original query.
     * See the [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectIds(getCatalogObjectIds())
            .locationIds(getLocationIds())
            .updatedAfter(getUpdatedAfter())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private List<String> catalogObjectIds;
        private List<String> locationIds;
        private String updatedAfter;
        private String cursor;

        public Builder() { }

        public Builder catalogObjectIds(List<String> value) {
            catalogObjectIds = value;
            return this;
        }
        public Builder locationIds(List<String> value) {
            locationIds = value;
            return this;
        }
        public Builder updatedAfter(String value) {
            updatedAfter = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public BatchRetrieveInventoryCountsRequest build() {
            return new BatchRetrieveInventoryCountsRequest(catalogObjectIds,
                locationIds,
                updatedAfter,
                cursor);
        }
    }
}

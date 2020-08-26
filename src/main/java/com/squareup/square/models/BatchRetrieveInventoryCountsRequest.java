package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BatchRetrieveInventoryCountsRequest type.
 */
public class BatchRetrieveInventoryCountsRequest {

    /**
     * Initialization constructor.
     * @param catalogObjectIds
     * @param locationIds
     * @param updatedAfter
     * @param cursor
     * @param states
     */
    @JsonCreator
    public BatchRetrieveInventoryCountsRequest(
            @JsonProperty("catalog_object_ids") List<String> catalogObjectIds,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("updated_after") String updatedAfter,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("states") List<String> states) {
        this.catalogObjectIds = catalogObjectIds;
        this.locationIds = locationIds;
        this.updatedAfter = updatedAfter;
        this.cursor = cursor;
        this.states = states;
    }

    private final List<String> catalogObjectIds;
    private final List<String> locationIds;
    private final String updatedAfter;
    private final String cursor;
    private final List<String> states;
    /**
     * Getter for CatalogObjectIds.
     * The filter to return results by `CatalogObject` ID.
     * The filter is applicable only when set.  The default is null.
     */
    @JsonGetter("catalog_object_ids")
    public List<String> getCatalogObjectIds() {
        return this.catalogObjectIds;
    }

    /**
     * Getter for LocationIds.
     * The filter to return results by `Location` ID. 
     * This filter is applicable only when set. The default is null.
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for UpdatedAfter.
     * The filter to return results with their `calculated_at` value 
     * after the given time as specified in an RFC 3339 timestamp. 
     * The default value is the UNIX epoch of (`1970-01-01T00:00:00Z`).
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

    /**
     * Getter for States.
     * The filter to return results by `InventoryState`. The filter is only applicable when set.
     * Ignored are untracked states of `NONE`, `SOLD`, and `UNLINKED_RETURN`.
     * The default is null.
     * See [InventoryState](#type-inventorystate) for possible values
     */
    @JsonGetter("states")
    public List<String> getStates() {
        return this.states;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectIds, locationIds, updatedAfter, cursor, states);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchRetrieveInventoryCountsRequest)) {
            return false;
        }
        BatchRetrieveInventoryCountsRequest batchRetrieveInventoryCountsRequest = (BatchRetrieveInventoryCountsRequest) obj;
        return Objects.equals(catalogObjectIds, batchRetrieveInventoryCountsRequest.catalogObjectIds) &&
            Objects.equals(locationIds, batchRetrieveInventoryCountsRequest.locationIds) &&
            Objects.equals(updatedAfter, batchRetrieveInventoryCountsRequest.updatedAfter) &&
            Objects.equals(cursor, batchRetrieveInventoryCountsRequest.cursor) &&
            Objects.equals(states, batchRetrieveInventoryCountsRequest.states);
    }

    /**
     * Builds a new {@link BatchRetrieveInventoryCountsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveInventoryCountsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectIds(getCatalogObjectIds())
            .locationIds(getLocationIds())
            .updatedAfter(getUpdatedAfter())
            .cursor(getCursor())
            .states(getStates());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveInventoryCountsRequest}
     */
    public static class Builder {
        private List<String> catalogObjectIds;
        private List<String> locationIds;
        private String updatedAfter;
        private String cursor;
        private List<String> states;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for catalogObjectIds
         * @param catalogObjectIds
         * @return Builder
         */
        public Builder catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = catalogObjectIds;
            return this;
        }
        /**
         * Setter for locationIds
         * @param locationIds
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }
        /**
         * Setter for updatedAfter
         * @param updatedAfter
         * @return Builder
         */
        public Builder updatedAfter(String updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }
        /**
         * Setter for states
         * @param states
         * @return Builder
         */
        public Builder states(List<String> states) {
            this.states = states;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveInventoryCountsRequest} object using the set fields.
         * @return {@link BatchRetrieveInventoryCountsRequest}
         */
        public BatchRetrieveInventoryCountsRequest build() {
            return new BatchRetrieveInventoryCountsRequest(catalogObjectIds,
                locationIds,
                updatedAfter,
                cursor,
                states);
        }
    }
}

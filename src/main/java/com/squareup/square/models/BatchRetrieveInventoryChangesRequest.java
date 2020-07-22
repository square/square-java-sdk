package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BatchRetrieveInventoryChangesRequest type.
 */
public class BatchRetrieveInventoryChangesRequest {

    /**
     * Initialization constructor.
     * @param catalogObjectIds
     * @param locationIds
     * @param types
     * @param states
     * @param updatedAfter
     * @param updatedBefore
     * @param cursor
     */
    @JsonCreator
    public BatchRetrieveInventoryChangesRequest(
            @JsonProperty("catalog_object_ids") List<String> catalogObjectIds,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("types") List<String> types,
            @JsonProperty("states") List<String> states,
            @JsonProperty("updated_after") String updatedAfter,
            @JsonProperty("updated_before") String updatedBefore,
            @JsonProperty("cursor") String cursor) {
        this.catalogObjectIds = catalogObjectIds;
        this.locationIds = locationIds;
        this.types = types;
        this.states = states;
        this.updatedAfter = updatedAfter;
        this.updatedBefore = updatedBefore;
        this.cursor = cursor;
    }

    private final List<String> catalogObjectIds;
    private final List<String> locationIds;
    private final List<String> types;
    private final List<String> states;
    private final String updatedAfter;
    private final String updatedBefore;
    private final String cursor;
    /**
     * Getter for CatalogObjectIds.
     * Filters results by `CatalogObject` ID.
     * Only applied when set. Max size is 500 IDs. Default: unset.
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
     * Getter for Types.
     * Filters results by `InventoryChangeType`.
     * Default: [`PHYSICAL_COUNT`, `ADJUSTMENT`]. `TRANSFER` is not supported as
     * a filter.
     * See [InventoryChangeType](#type-inventorychangetype) for possible values
     */
    @JsonGetter("types")
    public List<String> getTypes() {
        return this.types;
    }

    /**
     * Getter for States.
     * Filters `ADJUSTMENT` query results by
     * `InventoryState`. Only applied when set.
     * Default: unset.
     * See [InventoryState](#type-inventorystate) for possible values
     */
    @JsonGetter("states")
    public List<String> getStates() {
        return this.states;
    }

    /**
     * Getter for UpdatedAfter.
     * Provided as an RFC 3339 timestamp. Returns results whose
     * `created_at` or `calculated_at` value is after the given time.
     * Default: UNIX epoch (`1970-01-01T00:00:00Z`).
     */
    @JsonGetter("updated_after")
    public String getUpdatedAfter() {
        return this.updatedAfter;
    }

    /**
     * Getter for UpdatedBefore.
     * Provided as an RFC 3339 timestamp. Returns results whose
     * `created_at` or `calculated_at` value is strictly before the given time.
     * Default: UNIX epoch (`1970-01-01T00:00:00Z`).
     */
    @JsonGetter("updated_before")
    public String getUpdatedBefore() {
        return this.updatedBefore;
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

 
    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectIds, locationIds, types, states, updatedAfter,
            updatedBefore, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BatchRetrieveInventoryChangesRequest)) {
            return false;
        }
        BatchRetrieveInventoryChangesRequest batchRetrieveInventoryChangesRequest = (BatchRetrieveInventoryChangesRequest) obj;
        return Objects.equals(catalogObjectIds, batchRetrieveInventoryChangesRequest.catalogObjectIds) &&
            Objects.equals(locationIds, batchRetrieveInventoryChangesRequest.locationIds) &&
            Objects.equals(types, batchRetrieveInventoryChangesRequest.types) &&
            Objects.equals(states, batchRetrieveInventoryChangesRequest.states) &&
            Objects.equals(updatedAfter, batchRetrieveInventoryChangesRequest.updatedAfter) &&
            Objects.equals(updatedBefore, batchRetrieveInventoryChangesRequest.updatedBefore) &&
            Objects.equals(cursor, batchRetrieveInventoryChangesRequest.cursor);
    }

    /**
     * Builds a new {@link BatchRetrieveInventoryChangesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveInventoryChangesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .catalogObjectIds(getCatalogObjectIds())
            .locationIds(getLocationIds())
            .types(getTypes())
            .states(getStates())
            .updatedAfter(getUpdatedAfter())
            .updatedBefore(getUpdatedBefore())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveInventoryChangesRequest}
     */
    public static class Builder {
        private List<String> catalogObjectIds;
        private List<String> locationIds;
        private List<String> types;
        private List<String> states;
        private String updatedAfter;
        private String updatedBefore;
        private String cursor;

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
         * Setter for types
         * @param types
         * @return Builder
         */
        public Builder types(List<String> types) {
            this.types = types;
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
         * Setter for updatedAfter
         * @param updatedAfter
         * @return Builder
         */
        public Builder updatedAfter(String updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }
        /**
         * Setter for updatedBefore
         * @param updatedBefore
         * @return Builder
         */
        public Builder updatedBefore(String updatedBefore) {
            this.updatedBefore = updatedBefore;
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
         * Builds a new {@link BatchRetrieveInventoryChangesRequest} object using the set fields.
         * @return {@link BatchRetrieveInventoryChangesRequest}
         */
        public BatchRetrieveInventoryChangesRequest build() {
            return new BatchRetrieveInventoryChangesRequest(catalogObjectIds,
                locationIds,
                types,
                states,
                updatedAfter,
                updatedBefore,
                cursor);
        }
    }
}

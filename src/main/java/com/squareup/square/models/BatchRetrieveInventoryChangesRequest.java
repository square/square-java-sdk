
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveInventoryChangesRequest type.
 */
public class BatchRetrieveInventoryChangesRequest {
    private final List<String> catalogObjectIds;
    private final List<String> locationIds;
    private final List<String> types;
    private final List<String> states;
    private final String updatedAfter;
    private final String updatedBefore;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param catalogObjectIds List of String value for catalogObjectIds.
     * @param locationIds List of String value for locationIds.
     * @param types List of String value for types.
     * @param states List of String value for states.
     * @param updatedAfter String value for updatedAfter.
     * @param updatedBefore String value for updatedBefore.
     * @param cursor String value for cursor.
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

    /**
     * Getter for CatalogObjectIds.
     * The filter to return results by `CatalogObject` ID. The filter is only applicable when set.
     * The default value is null.
     * @return Returns the List of String
     */
    @JsonGetter("catalog_object_ids")
    public List<String> getCatalogObjectIds() {
        return this.catalogObjectIds;
    }

    /**
     * Getter for LocationIds.
     * The filter to return results by `Location` ID. The filter is only applicable when set. The
     * default value is null.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for Types.
     * The filter to return results by `InventoryChangeType` values other than `TRANSFER`. The
     * default value is `[PHYSICAL_COUNT, ADJUSTMENT]`.
     * @return Returns the List of String
     */
    @JsonGetter("types")
    public List<String> getTypes() {
        return this.types;
    }

    /**
     * Getter for States.
     * The filter to return `ADJUSTMENT` query results by `InventoryState`. This filter is only
     * applied when set. The default value is null.
     * @return Returns the List of String
     */
    @JsonGetter("states")
    public List<String> getStates() {
        return this.states;
    }

    /**
     * Getter for UpdatedAfter.
     * The filter to return results with their `calculated_at` value after the given time as
     * specified in an RFC 3339 timestamp. The default value is the UNIX epoch of
     * (`1970-01-01T00:00:00Z`).
     * @return Returns the String
     */
    @JsonGetter("updated_after")
    public String getUpdatedAfter() {
        return this.updatedAfter;
    }

    /**
     * Getter for UpdatedBefore.
     * The filter to return results with their `created_at` or `calculated_at` value strictly before
     * the given time as specified in an RFC 3339 timestamp. The default value is the UNIX epoch of
     * (`1970-01-01T00:00:00Z`).
     * @return Returns the String
     */
    @JsonGetter("updated_before")
    public String getUpdatedBefore() {
        return this.updatedBefore;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchRetrieveInventoryChangesRequest)) {
            return false;
        }
        BatchRetrieveInventoryChangesRequest other = (BatchRetrieveInventoryChangesRequest) obj;
        return Objects.equals(catalogObjectIds, other.catalogObjectIds)
            && Objects.equals(locationIds, other.locationIds)
            && Objects.equals(types, other.types)
            && Objects.equals(states, other.states)
            && Objects.equals(updatedAfter, other.updatedAfter)
            && Objects.equals(updatedBefore, other.updatedBefore)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this BatchRetrieveInventoryChangesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveInventoryChangesRequest [" + "catalogObjectIds=" + catalogObjectIds
                + ", locationIds=" + locationIds + ", types=" + types + ", states=" + states
                + ", updatedAfter=" + updatedAfter + ", updatedBefore=" + updatedBefore
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link BatchRetrieveInventoryChangesRequest}.
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
         * Setter for catalogObjectIds.
         * @param catalogObjectIds List of String value for catalogObjectIds.
         * @return Builder
         */
        public Builder catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = catalogObjectIds;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param locationIds List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Setter for types.
         * @param types List of String value for types.
         * @return Builder
         */
        public Builder types(List<String> types) {
            this.types = types;
            return this;
        }

        /**
         * Setter for states.
         * @param states List of String value for states.
         * @return Builder
         */
        public Builder states(List<String> states) {
            this.states = states;
            return this;
        }

        /**
         * Setter for updatedAfter.
         * @param updatedAfter String value for updatedAfter.
         * @return Builder
         */
        public Builder updatedAfter(String updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }

        /**
         * Setter for updatedBefore.
         * @param updatedBefore String value for updatedBefore.
         * @return Builder
         */
        public Builder updatedBefore(String updatedBefore) {
            this.updatedBefore = updatedBefore;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
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
            return new BatchRetrieveInventoryChangesRequest(catalogObjectIds, locationIds, types,
                    states, updatedAfter, updatedBefore, cursor);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveInventoryCountsRequest type.
 */
public class BatchRetrieveInventoryCountsRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> catalogObjectIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> locationIds;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAfter;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> states;

    /**
     * Initialization constructor.
     * @param  catalogObjectIds  List of String value for catalogObjectIds.
     * @param  locationIds  List of String value for locationIds.
     * @param  updatedAfter  String value for updatedAfter.
     * @param  cursor  String value for cursor.
     * @param  states  List of String value for states.
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

    /**
     * Getter for CatalogObjectIds.
     * The filter to return results by `CatalogObject` ID. The filter is applicable only when set.
     * The default is null.
     * @return Returns the List of String
     */
    @JsonGetter("catalog_object_ids")
    public List<String> getCatalogObjectIds() {
        return catalogObjectIds;
    }

    /**
     * Getter for LocationIds.
     * The filter to return results by `Location` ID. This filter is applicable only when set. The
     * default is null.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return locationIds;
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
        return updatedAfter;
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
        return cursor;
    }

    /**
     * Getter for States.
     * The filter to return results by `InventoryState`. The filter is only applicable when set.
     * Ignored are untracked states of `NONE`, `SOLD`, and `UNLINKED_RETURN`. The default is null.
     * @return Returns the List of String
     */
    @JsonGetter("states")
    public List<String> getStates() {
        return states;
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectIds, locationIds, updatedAfter, cursor, states);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchRetrieveInventoryCountsRequest)) {
            return false;
        }
        BatchRetrieveInventoryCountsRequest other = (BatchRetrieveInventoryCountsRequest) obj;
        return Objects.equals(catalogObjectIds, other.catalogObjectIds)
            && Objects.equals(locationIds, other.locationIds)
            && Objects.equals(updatedAfter, other.updatedAfter)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(states, other.states);
    }

    /**
     * Converts this BatchRetrieveInventoryCountsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveInventoryCountsRequest [" + "catalogObjectIds=" + catalogObjectIds
                + ", locationIds=" + locationIds + ", updatedAfter=" + updatedAfter + ", cursor="
                + cursor + ", states=" + states + "]";
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
     * Class to build instances of {@link BatchRetrieveInventoryCountsRequest}.
     */
    public static class Builder {
        private List<String> catalogObjectIds;
        private List<String> locationIds;
        private String updatedAfter;
        private String cursor;
        private List<String> states;



        /**
         * Setter for catalogObjectIds.
         * @param  catalogObjectIds  List of String value for catalogObjectIds.
         * @return Builder
         */
        public Builder catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = catalogObjectIds;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Setter for updatedAfter.
         * @param  updatedAfter  String value for updatedAfter.
         * @return Builder
         */
        public Builder updatedAfter(String updatedAfter) {
            this.updatedAfter = updatedAfter;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for states.
         * @param  states  List of String value for states.
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
            return new BatchRetrieveInventoryCountsRequest(catalogObjectIds, locationIds,
                    updatedAfter, cursor, states);
        }
    }
}

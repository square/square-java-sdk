package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for RetrieveInventoryCountRequest type.
 */
public class RetrieveInventoryCountRequest {

    /**
     * Initialization constructor.
     * @param locationIds
     * @param cursor
     */
    @JsonCreator
    public RetrieveInventoryCountRequest(
            @JsonProperty("location_ids") String locationIds,
            @JsonProperty("cursor") String cursor) {
        this.locationIds = locationIds;
        this.cursor = cursor;
    }

    private final String locationIds;
    private final String cursor;
    /**
     * Getter for LocationIds.
     * The [Location](#type-location) IDs to look up as a comma-separated
     * list. An empty list queries all locations.
     */
    @JsonGetter("location_ids")
    public String getLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint.
     * Provide this to retrieve the next set of results for the original query.
     * See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationIds, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveInventoryCountRequest)) {
            return false;
        }
        RetrieveInventoryCountRequest retrieveInventoryCountRequest = (RetrieveInventoryCountRequest) obj;
        return Objects.equals(locationIds, retrieveInventoryCountRequest.locationIds) &&
            Objects.equals(cursor, retrieveInventoryCountRequest.cursor);
    }

    /**
     * Builds a new {@link RetrieveInventoryCountRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveInventoryCountRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationIds(getLocationIds())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveInventoryCountRequest}
     */
    public static class Builder {
        private String locationIds;
        private String cursor;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for locationIds
         * @param locationIds
         * @return Builder
         */
        public Builder locationIds(String locationIds) {
            this.locationIds = locationIds;
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
         * Builds a new {@link RetrieveInventoryCountRequest} object using the set fields.
         * @return {@link RetrieveInventoryCountRequest}
         */
        public RetrieveInventoryCountRequest build() {
            return new RetrieveInventoryCountRequest(locationIds,
                cursor);
        }
    }
}

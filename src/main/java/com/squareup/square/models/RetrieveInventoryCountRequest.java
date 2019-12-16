package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class RetrieveInventoryCountRequest {

    @JsonCreator
    public RetrieveInventoryCountRequest(
            @JsonProperty("location_ids") String locationIds,
            @JsonProperty("cursor") String cursor) {
        this.locationIds = locationIds;
        this.cursor = cursor;
    }

    private final String locationIds;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveInventoryCountRequest)) {
            return false;
        }
        RetrieveInventoryCountRequest retrieveInventoryCountRequest = (RetrieveInventoryCountRequest) o;
        return Objects.equals(locationIds, retrieveInventoryCountRequest.locationIds) &&
            Objects.equals(cursor, retrieveInventoryCountRequest.cursor);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationIds(getLocationIds())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private String locationIds;
        private String cursor;

        public Builder() { }

        public Builder locationIds(String value) {
            locationIds = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public RetrieveInventoryCountRequest build() {
            return new RetrieveInventoryCountRequest(locationIds,
                cursor);
        }
    }
}

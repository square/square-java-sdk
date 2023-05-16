
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for RetrieveInventoryCountRequest type.
 */
public class RetrieveInventoryCountRequest {
    private final OptionalNullable<String> locationIds;
    private final OptionalNullable<String> cursor;

    /**
     * Initialization constructor.
     * @param  locationIds  String value for locationIds.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public RetrieveInventoryCountRequest(
            @JsonProperty("location_ids") String locationIds,
            @JsonProperty("cursor") String cursor) {
        this.locationIds = OptionalNullable.of(locationIds);
        this.cursor = OptionalNullable.of(cursor);
    }

    /**
     * Internal initialization constructor.
     */
    protected RetrieveInventoryCountRequest(OptionalNullable<String> locationIds,
            OptionalNullable<String> cursor) {
        this.locationIds = locationIds;
        this.cursor = cursor;
    }

    /**
     * Internal Getter for LocationIds.
     * The [Location](entity:Location) IDs to look up as a comma-separated list. An empty list
     * queries all locations.
     * @return Returns the Internal String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for LocationIds.
     * The [Location](entity:Location) IDs to look up as a comma-separated list. An empty list
     * queries all locations.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationIds() {
        return OptionalNullable.getFrom(locationIds);
    }

    /**
     * Internal Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the Internal String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCursor() {
        return this.cursor;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. Provide this to retrieve
     * the next set of results for the original query. See the
     * [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination) guide for more
     * information.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCursor() {
        return OptionalNullable.getFrom(cursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationIds, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveInventoryCountRequest)) {
            return false;
        }
        RetrieveInventoryCountRequest other = (RetrieveInventoryCountRequest) obj;
        return Objects.equals(locationIds, other.locationIds)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this RetrieveInventoryCountRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveInventoryCountRequest [" + "locationIds=" + locationIds + ", cursor="
                + cursor + "]";
    }

    /**
     * Builds a new {@link RetrieveInventoryCountRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveInventoryCountRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.locationIds = internalGetLocationIds();
        builder.cursor = internalGetCursor();
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveInventoryCountRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> locationIds;
        private OptionalNullable<String> cursor;



        /**
         * Setter for locationIds.
         * @param  locationIds  String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(String locationIds) {
            this.locationIds = OptionalNullable.of(locationIds);
            return this;
        }

        /**
         * UnSetter for locationIds.
         * @return Builder
         */
        public Builder unsetLocationIds() {
            locationIds = null;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = OptionalNullable.of(cursor);
            return this;
        }

        /**
         * UnSetter for cursor.
         * @return Builder
         */
        public Builder unsetCursor() {
            cursor = null;
            return this;
        }

        /**
         * Builds a new {@link RetrieveInventoryCountRequest} object using the set fields.
         * @return {@link RetrieveInventoryCountRequest}
         */
        public RetrieveInventoryCountRequest build() {
            return new RetrieveInventoryCountRequest(locationIds, cursor);
        }
    }
}


package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BatchRetrieveInventoryCountsRequest type.
 */
public class BatchRetrieveInventoryCountsRequest {
    private final OptionalNullable<List<String>> catalogObjectIds;
    private final OptionalNullable<List<String>> locationIds;
    private final OptionalNullable<String> updatedAfter;
    private final OptionalNullable<String> cursor;
    private final OptionalNullable<List<String>> states;
    private final OptionalNullable<Integer> limit;

    /**
     * Initialization constructor.
     * @param  catalogObjectIds  List of String value for catalogObjectIds.
     * @param  locationIds  List of String value for locationIds.
     * @param  updatedAfter  String value for updatedAfter.
     * @param  cursor  String value for cursor.
     * @param  states  List of String value for states.
     * @param  limit  Integer value for limit.
     */
    @JsonCreator
    public BatchRetrieveInventoryCountsRequest(
            @JsonProperty("catalog_object_ids") List<String> catalogObjectIds,
            @JsonProperty("location_ids") List<String> locationIds,
            @JsonProperty("updated_after") String updatedAfter,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("states") List<String> states,
            @JsonProperty("limit") Integer limit) {
        this.catalogObjectIds = OptionalNullable.of(catalogObjectIds);
        this.locationIds = OptionalNullable.of(locationIds);
        this.updatedAfter = OptionalNullable.of(updatedAfter);
        this.cursor = OptionalNullable.of(cursor);
        this.states = OptionalNullable.of(states);
        this.limit = OptionalNullable.of(limit);
    }

    /**
     * Internal initialization constructor.
     */
    protected BatchRetrieveInventoryCountsRequest(OptionalNullable<List<String>> catalogObjectIds,
            OptionalNullable<List<String>> locationIds, OptionalNullable<String> updatedAfter,
            OptionalNullable<String> cursor, OptionalNullable<List<String>> states,
            OptionalNullable<Integer> limit) {
        this.catalogObjectIds = catalogObjectIds;
        this.locationIds = locationIds;
        this.updatedAfter = updatedAfter;
        this.cursor = cursor;
        this.states = states;
        this.limit = limit;
    }

    /**
     * Internal Getter for CatalogObjectIds.
     * The filter to return results by `CatalogObject` ID. The filter is applicable only when set.
     * The default is null.
     * @return Returns the Internal List of String
     */
    @JsonGetter("catalog_object_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetCatalogObjectIds() {
        return this.catalogObjectIds;
    }

    /**
     * Getter for CatalogObjectIds.
     * The filter to return results by `CatalogObject` ID. The filter is applicable only when set.
     * The default is null.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getCatalogObjectIds() {
        return OptionalNullable.getFrom(catalogObjectIds);
    }

    /**
     * Internal Getter for LocationIds.
     * The filter to return results by `Location` ID. This filter is applicable only when set. The
     * default is null.
     * @return Returns the Internal List of String
     */
    @JsonGetter("location_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetLocationIds() {
        return this.locationIds;
    }

    /**
     * Getter for LocationIds.
     * The filter to return results by `Location` ID. This filter is applicable only when set. The
     * default is null.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getLocationIds() {
        return OptionalNullable.getFrom(locationIds);
    }

    /**
     * Internal Getter for UpdatedAfter.
     * The filter to return results with their `calculated_at` value after the given time as
     * specified in an RFC 3339 timestamp. The default value is the UNIX epoch of
     * (`1970-01-01T00:00:00Z`).
     * @return Returns the Internal String
     */
    @JsonGetter("updated_after")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUpdatedAfter() {
        return this.updatedAfter;
    }

    /**
     * Getter for UpdatedAfter.
     * The filter to return results with their `calculated_at` value after the given time as
     * specified in an RFC 3339 timestamp. The default value is the UNIX epoch of
     * (`1970-01-01T00:00:00Z`).
     * @return Returns the String
     */
    @JsonIgnore
    public String getUpdatedAfter() {
        return OptionalNullable.getFrom(updatedAfter);
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

    /**
     * Internal Getter for States.
     * The filter to return results by `InventoryState`. The filter is only applicable when set.
     * Ignored are untracked states of `NONE`, `SOLD`, and `UNLINKED_RETURN`. The default is null.
     * @return Returns the Internal List of String
     */
    @JsonGetter("states")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetStates() {
        return this.states;
    }

    /**
     * Getter for States.
     * The filter to return results by `InventoryState`. The filter is only applicable when set.
     * Ignored are untracked states of `NONE`, `SOLD`, and `UNLINKED_RETURN`. The default is null.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getStates() {
        return OptionalNullable.getFrom(states);
    }

    /**
     * Internal Getter for Limit.
     * The number of [records](entity:InventoryCount) to return.
     * @return Returns the Internal Integer
     */
    @JsonGetter("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetLimit() {
        return this.limit;
    }

    /**
     * Getter for Limit.
     * The number of [records](entity:InventoryCount) to return.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getLimit() {
        return OptionalNullable.getFrom(limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectIds, locationIds, updatedAfter, cursor, states, limit);
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
            && Objects.equals(states, other.states)
            && Objects.equals(limit, other.limit);
    }

    /**
     * Converts this BatchRetrieveInventoryCountsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BatchRetrieveInventoryCountsRequest [" + "catalogObjectIds=" + catalogObjectIds
                + ", locationIds=" + locationIds + ", updatedAfter=" + updatedAfter + ", cursor="
                + cursor + ", states=" + states + ", limit=" + limit + "]";
    }

    /**
     * Builds a new {@link BatchRetrieveInventoryCountsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BatchRetrieveInventoryCountsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.catalogObjectIds = internalGetCatalogObjectIds();
        builder.locationIds = internalGetLocationIds();
        builder.updatedAfter = internalGetUpdatedAfter();
        builder.cursor = internalGetCursor();
        builder.states = internalGetStates();
        builder.limit = internalGetLimit();
        return builder;
    }

    /**
     * Class to build instances of {@link BatchRetrieveInventoryCountsRequest}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> catalogObjectIds;
        private OptionalNullable<List<String>> locationIds;
        private OptionalNullable<String> updatedAfter;
        private OptionalNullable<String> cursor;
        private OptionalNullable<List<String>> states;
        private OptionalNullable<Integer> limit;



        /**
         * Setter for catalogObjectIds.
         * @param  catalogObjectIds  List of String value for catalogObjectIds.
         * @return Builder
         */
        public Builder catalogObjectIds(List<String> catalogObjectIds) {
            this.catalogObjectIds = OptionalNullable.of(catalogObjectIds);
            return this;
        }

        /**
         * UnSetter for catalogObjectIds.
         * @return Builder
         */
        public Builder unsetCatalogObjectIds() {
            catalogObjectIds = null;
            return this;
        }

        /**
         * Setter for locationIds.
         * @param  locationIds  List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
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
         * Setter for updatedAfter.
         * @param  updatedAfter  String value for updatedAfter.
         * @return Builder
         */
        public Builder updatedAfter(String updatedAfter) {
            this.updatedAfter = OptionalNullable.of(updatedAfter);
            return this;
        }

        /**
         * UnSetter for updatedAfter.
         * @return Builder
         */
        public Builder unsetUpdatedAfter() {
            updatedAfter = null;
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
         * Setter for states.
         * @param  states  List of String value for states.
         * @return Builder
         */
        public Builder states(List<String> states) {
            this.states = OptionalNullable.of(states);
            return this;
        }

        /**
         * UnSetter for states.
         * @return Builder
         */
        public Builder unsetStates() {
            states = null;
            return this;
        }

        /**
         * Setter for limit.
         * @param  limit  Integer value for limit.
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = OptionalNullable.of(limit);
            return this;
        }

        /**
         * UnSetter for limit.
         * @return Builder
         */
        public Builder unsetLimit() {
            limit = null;
            return this;
        }

        /**
         * Builds a new {@link BatchRetrieveInventoryCountsRequest} object using the set fields.
         * @return {@link BatchRetrieveInventoryCountsRequest}
         */
        public BatchRetrieveInventoryCountsRequest build() {
            return new BatchRetrieveInventoryCountsRequest(catalogObjectIds, locationIds,
                    updatedAfter, cursor, states, limit);
        }
    }
}
